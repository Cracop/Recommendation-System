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
public class Review {
    String review_id;
    String user_id;
    String business_id;
    float stars=0;
    
    public Review(){
        
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Opinion: "+stars+"\n");
        sb.append("  User ID: "+user_id+"\n");
        sb.append("  Business ID: "+business_id+"\n");
        return sb.toString();
    }
}
