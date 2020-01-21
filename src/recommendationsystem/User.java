/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendationsystem;

import java.util.*;

/**
 *
 * @author rodri
 */
public class User {

    String name;
    String user_id;
    LinkedList<Review> reviews;
    Set<Establishment> visited;
    Set<String> preferences;
    LinkedList<Establishment> options;
    LinkedList<Establishment> recommended;
    Set<User> friends;

    public User() {
        visited = new HashSet<Establishment>();
        preferences = new HashSet<String>();
        reviews = new LinkedList<Review>();
        options = new LinkedList<Establishment>();
        friends = new HashSet<User>();
        recommended = new LinkedList<Establishment>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + "\n");
        //sb.append(" User ID: "+user_id+"\n");
        sb.append(" Likes: "+preferences.toString()+"\n");
        //sb.append("  Reviews: "+reviews.toString()+"\n");
        //sb.append("    Visited: " + visited.toString() + "\n");
        //sb.append("  "+visited.size()+"\n");
        //sb.append("   Recommended: \n  " + options.toString() + "\n");
        sb.append("\n");
        return sb.toString();
    }

    public void formPreferences() {
        for (Establishment est : visited) {
            for (String category : est.categories) {
                if(!preferences.contains(category)){
                    preferences.add(category);
                }
            }
        }
    }

    public void recommendEstablishmentForUser(double maximunDistance, int rating ) throws Exception {
        double distance;
        recommended.clear();
        if (maximunDistance < 0) {
            throw new IllegalArgumentException("Must be a valid distance!");
        }

        for (Establishment est : options) {
            for (Establishment estU : visited) {
                distance = haversine(estU.latitude, estU.longitude, est.latitude, est.longitude);
                if (distance < maximunDistance && est.rating >= rating ) {
                    if (!recommended.contains(est)) {
                        est.weight=est.rating  + est.likenessLevel;
                        recommended.add(est);
                    }
                }
            }
        }
        Collections.sort(recommended, Collections.reverseOrder());
    }

    /**
     * Using the parameters can tell the distances between two objects in a sphere
     * @param lat1 latitude of the first object
     * @param lon1 longitude of the first object
     * @param lat2 latitude of the second object
     * @param lon2 longitude of the second object
     * @return the distance in km
     */
    public double haversine(double lat1, double lon1, double lat2, double lon2) {
        // distance between latitudes and longitudes 
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians 
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae 
        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.pow(Math.sin(dLon / 2), 2)
                * Math.cos(lat1)
                * Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

    public void sortOptions() {
        ArrayList<Establishment> aux = new ArrayList<Establishment>();
        aux.addAll(options);

        Collections.sort(aux, Collections.reverseOrder());
        options.removeAll(aux);
        options.addAll(aux);
    }

    public String recommendedToString() {
        StringBuilder sb = new StringBuilder();
        for (Establishment est : recommended) {
            sb.append(est.toStringWithLink() + "\n");
        }
        return sb.toString();
    }

    public String visitedToString() {
        StringBuilder sb = new StringBuilder();
        for (Establishment est : visited) {
            sb.append(est.toStringWithLink() + "\n");
        }
        return sb.toString();
    }
}
