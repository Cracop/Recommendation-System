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
public class Establishment implements Comparable<Establishment> {
    String name;
    String address;
    String business_id;
    Set<String> categories;
    double longitude, latitude;
    float rating=0;
    LinkedList<Review> reviews;
    float likenessLevel=0;
    float weight;
    
    
    
    public Establishment(){
        reviews = new LinkedList<Review>();
        categories = new HashSet<String>();
        longitude = 0;
        latitude = 0;
        
    }
    
    public Establishment(String name, String address, String business_id, String categories){
        this();
        String[] cat = categories.split(", ");
        this.name=name;
        this.address=address;
        this.business_id=business_id;
        for(String str : cat){
            this.categories.add(str);
        } 
    }
    /**
     * Uses the "weight" compare
     * @param o the other establishment to compare
     * @return 1 if it's higher, 0 if they are the same and -1 if its lower
     */
    @Override
    public int compareTo(Establishment o){
        int resp;
        if(weight>o.weight){
            resp=1;
        }else{
            if(weight==o.weight){
                resp=0;
            }else{
                resp=-1;
            }
        }
        return resp;
    }
    
    /**
     * Calculates the rating based on the establishment's reviews
     * @return the rating
     */ 
    public void calculateRating(){
        float answer=0;
        for(Review rev : reviews){
            answer+=rev.stars;
        }
        rating = answer/reviews.size();
    }
    
    /**
     * Used for debuggin
     * @return prints the establishment's generic information without checking
     * if it has reviews
     */
    public String toStringNoLink(){
        StringBuilder sb = new StringBuilder();
        sb.append(name+"\n");
        //sb.append(" Longitude: "+longitude+"\n");
        //sb.append(" Latitude: "+latitude+"\n");
        //sb.append("  LikenessLevel: "+likenessLevel+"\n");
        sb.append(" Address: "+address+"\n");
        //sb.append(" Business ID: "+business_id+"\n");
        sb.append(" Categories: "+categories.toString()+"\n");
        sb.append(" Rating: "+rating+"\n");
        //sb.append("  Reviews: "+reviews.toString());
        return sb.toString();
    }
    
    /**
     * Used for debugging
     * @return prints the establishment0s information when they are linked to
     * a review.
     */ 
    public String toStringWithLink(){
        StringBuilder sb = new StringBuilder();
        sb.append(name+"\n");
        //sb.append(" Longitude: "+longitude+"\n");
        //sb.append(" Latitude: "+latitude+"\n");
        sb.append("Weight: "+weight+"\n");
        //sb.append("  LikenessLevel: "+likenessLevel+"\n");
        sb.append(" Address: "+address+"\n");
        //sb.append(" Business ID: "+business_id+"\n");
        sb.append(" Categories: "+categories.toString()+"\n");
        sb.append(" Rating: "+rating+"\n");
        //sb.append("  Reviews: "+reviews.toString());
        return sb.toString();
    }
}
