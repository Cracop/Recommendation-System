/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Tener la "distancia" de que tan parecido es un establecimiento a los otros con
la distancia real y cuantas categorias comparten,
 */
package recommendationsystem;

import java.util.*;
import java.io.*;
import org.json.JSONObject;

/**
 *
 * @author rodri
 */
public class RecommendationSystem {

    LinkedList<Establishment> establishments;
    LinkedList<Review> reviews;
    LinkedList<User> users;
    Set<String> con = new HashSet<String>();
    Stack sta = new Stack();
    Queue<String> qu = new LinkedList();
    ArrayList<User> workableUsers;

    public RecommendationSystem() throws Exception {
        establishments = new LinkedList<Establishment>();
        reviews = new LinkedList<Review>();
        users = new LinkedList<User>();
        workableUsers = new ArrayList<User>();
        importEstablishments("business.json");
        importReviews("review.json");
        importUsers("user.json");
        linkEstToRev();
        linkUsToRev();
        getAllRatings();
        designateVisited();
        designatePreferences();
        getWorkableUsers();
        giveOptionsForWorkableUsers();
    }
    /**
     * Reads the file and adds the establishments to the list
     * @param fileName the name of the json file that contains the establishments
     */
    public void importEstablishments(String fileName) {
        float maximun = 20000;
        float count=0;
        JSONObject obj;
        String s, cat;
        String[] cate;
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine() && count<maximun ) {
                s = sc.nextLine();
                obj = new JSONObject(s);
                Establishment place = new Establishment();
                place.address = obj.getString("address");
                place.name = obj.getString("name");
                place.business_id = obj.getString("business_id");
                cat = obj.getString("categories");
                cate = cat.split(", ");
                for (String str : cate) {
                    place.categories.add(str);
                }
                place.longitude = obj.getDouble("longitude");
                place.latitude = obj.getDouble("latitude");
                establishments.add(place);
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Reads the file and adds to reviews to the list
     * @param fileName the name of the file that contains the reviews
     */
    public void importReviews(String fileName) {
        float maximun = 40000;
        float count=0;
        JSONObject obj;
        String s;
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine() && count<maximun ) {
                s = sc.nextLine();
                obj = new JSONObject(s);
                Review rev = new Review();
                rev.business_id = obj.getString("business_id");
                rev.review_id = obj.getString("review_id");
                rev.stars = obj.getFloat("stars");
                rev.user_id = obj.getString("user_id");
                reviews.add(rev);
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Reads the file and adds the user to the list
     * @param fileName the name of the file that contains the users
     */
    public void importUsers(String fileName) {
        float maximun = 40000;
        float count=0;
        JSONObject obj;
        String s;
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine() && count<maximun) {
                s = sc.nextLine();
                obj = new JSONObject(s);
                User us = new User();
                us.name = obj.getString("name");
                us.user_id = obj.getString("user_id");
                users.add(us);
                count++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Prints all the establishments
     */
    public String establishmentsToString() {
        Iterator it = establishments.iterator();
        StringBuilder sb = new StringBuilder();
        Establishment current;
        while (it.hasNext()) {
            current = (Establishment) it.next();
            sb.append(current.toStringNoLink() + "\n\n");
        }
        return sb.toString();
    }
    
    /**
     * 
     * @return All the establishments that have reviews linked to them
     */
    public String linkedEstablishmentsToString() {
        Iterator it = establishments.iterator();
        StringBuilder sb = new StringBuilder();
        Establishment current;
        while (it.hasNext()) {
            current = (Establishment) it.next();
            if (current.reviews.size() > 0) {
                sb.append(current.toStringNoLink() + "\n\n");
            }

        }
        return sb.toString();
    }

    /**
     * 
     * @return Prints all the reviews
     */
    public String reviewsToString() {
        Iterator it = reviews.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().toString() + "\n\n");
        }
        return sb.toString();
    }

    /**
     * 
     * @return Prints all users
     */
    public String usersToString() {
        Iterator it = users.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().toString() + "");
        }
        return sb.toString();
    }
    
    /**
     * 
     * @return Prints all users that have visited places
     */ 
    public String workableUsersToString(){
        StringBuilder sb = new StringBuilder();
        for(User us : workableUsers){
            sb.append(us.toString());
        }
        return sb.toString();
    }

    /**
     * Checks every user and if they have visited an establishment that 
     * is on the list they it adds them to another list.
     */
    public void getWorkableUsers() {
        Iterator it = users.iterator();
        User current;
        while (it.hasNext()) {
            current = (User) it.next();
            if (current.visited.size() > 0) {
                workableUsers.add(current);
            }
        }
    }

    /**
     * Searches for an establishment
     * @param otherBusinessId the business id it uses to compare
     * @return null if it doesn't find any match, 
     * otherwise it returns the establishment
     */
    public Establishment searchEstablishment(String otherBusinessId) {
        Establishment answer = null;
        Establishment current;
        Iterator it = establishments.iterator();
        while (it.hasNext() && answer == null) {
            current = (Establishment) it.next();
            if (current.business_id.equals(otherBusinessId)) {
                answer = current;
            }
        }
        return answer;
    }

    /**
     * Using the business id in both the review and establishment,
     * it adds the review to the "review" list in the establishments
     */
    public void linkEstToRev() {
        Review current;
        String estBusiness_id;
        Establishment est;
        Iterator it = reviews.iterator();
        while (it.hasNext()) {
            current = (Review) it.next();
            estBusiness_id = current.business_id;
            est = searchEstablishment(estBusiness_id);
            if (est != null) {
                est.reviews.add(current);
            }
        }
    }

    /**
     * Looks for a specific user
     * @param otherUserId the user id it uses to compare
     * @return null if it doesnt find it, otherwise
     * it returns the user
     */ 
    public User searchUser(String otherUserId) {
        User answer = null;
        User current;
        Iterator it = users.iterator();
        while (it.hasNext() && answer == null) {
            current = (User) it.next();
            if (current.user_id.equals(otherUserId)) {
                answer = current;
            }
        }
        return answer;
    }

    /**
     * Using the user id in both the review and the user
     * it adds the review to the user's "reviews" list 
     */
    public void linkUsToRev() {
        Review current;
        String estUser_id;
        User use;
        Iterator it = reviews.iterator();
        while (it.hasNext()) {
            current = (Review) it.next();
            estUser_id = current.user_id;
            use = searchUser(estUser_id);
            if (use != null) {
                use.reviews.add(current);
            }
        }
    }
    /**
     * Calculates the rating for all establishments that have reviews
     */ 
    public void getAllRatings() {
        for (Establishment est : establishments) {
            if (est.reviews.size() > 0) {
                est.calculateRating();
            }
        }
    }
    /**
     * Adds the reviews' establishment to the user's "visited" set 
     */ 
    public void designateVisited() {
        Establishment est;
        for (User us : users) {
            if (us.reviews.size() > 0) {
                for (Review rev : us.reviews) {
                    est = searchEstablishment(rev.business_id);
                    if (est != null) {
                        us.visited.add(est);
                    }
                }
            }
        }
    }
    /**
     *With the user´s preferences it sees if the establishment would be a good option
     * and adds it to the user's "options" list
     */ 
    public void giveOptionsForWorkableUsers() throws Exception {
        for (Establishment est : establishments) {
            for (User us : workableUsers) {
                if(!us.options.contains(est)) {
                    for (String cat : est.categories) {
                        if (us.preferences.contains(cat) && !us.visited.contains(est) /*&& !cat.equals("Restaurants") */&& intersectionOfCategories(us.preferences, est.categories).size()>=2) {
                            est.likenessLevel = intersectionOfCategories(us.preferences, est.categories).size();
                            us.options.add(est);
                        }
                    }
                }
            us.sortOptions();
            }
            
        }
    }

    /**
     * If the user has visited at least one place, then it adds that 
     * establishment's categories to the user's "preferences" set
     */
    public void designatePreferences() {
        for (User us : users) {
            if (us.visited.size() > 0) {
                us.formPreferences();
            }
        }
    }
    
    /**
     * Intersects two given sets
     * @param set1 first set to intersect
     * @param set2 second set to intersect
     * @return the intersection as a set
     */ 
    public Set intersectionOfCategories(Set<String> set1, Set<String> set2) throws Exception {
        Set<String> answer = new HashSet<String>();
        Iterator it;
        String elem;
        if (set1 == null || set2 == null) {
            throw new Exception("Empty collector");
        }

        if (set1.size() < set2.size()) {
            it = set1.iterator();
            while (it.hasNext()) {
                elem = (String) it.next();
                if (set2.contains(elem)) {
                    answer.add(elem);
                }
            }
        } else {
            it = set2.iterator();
            while (it.hasNext()) {
                elem = (String) it.next();
                if (set1.contains(elem)) {
                    answer.add(elem);
                }
            }
        }
        return answer;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //RecommendationSystem rs = new RecommendationSystem();
        //System.out.println(rs.establishmentsToString());
        //System.out.println(rs.workableUsers.toString());
        //System.out.println("\n"+rs.workableUsers.get(0));
        RsMain rsg = new RsMain();
        rsg.setVisible(true);

    }

}
