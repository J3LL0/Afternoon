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
public class Cabin {
    private int cabin;                              //Cabin Number
    private Camper[] campers = new Camper[20];      //List of campers
    private int next = 0;
    
    Cabin(int n){
        cabin = n;
    }
    
    public void AddCamper(Camper c){
        campers[next] = c;
        next++;
    }
    
    public int GetCabinNumber(){
        return(cabin);
    }
}
