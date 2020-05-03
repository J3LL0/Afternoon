/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afternoon;

/**
 *
 * @author Salim
 */
public class Activity {
    private String name;            // Name of the activity
    private int max;                // Maximum number of participants of current activity
    private Camper[] participants;  // List of campers;
    private int current = 0;            // current number of participants
    
    Activity(String n, int i){
        name = n;                   //Set the name of the activity
        max = i;                    //Set the maximum number of people in this activity
        participants = new Camper[max];
    }
    
    public String GetActivityName(){
        return(name);
    }
    
    public int AddCamper(Camper c){
        if(current < max){
            participants[current] = c;
            current++;
            return(1);                          //flag to indicate successfully enrolled
        } else {
            return(0);                          //flag to indicate that the activity is full
        }
                
    }
    
    public int GetCount(){
        return(current);
    }
    
}
