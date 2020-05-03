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
public class Camper {
    private int cabin;
    private String name;
    private Activity FirstChoice, FirstAlt, SecondChoice, SecondAlt;
    
    Camper(String n, int i){
        name = n;
        cabin = i;
    }
    
    //Setter Methods
    public void SetFirstChoice(Activity fc){
        FirstChoice = fc;
    }
    
    public void SetFirstAlt(Activity fa){
        FirstAlt = fa;
    }
    
    public void SetSecondChoice(Activity sc){
        SecondChoice = sc;
    }
    
    public void SetSecondAlt(Activity sa){
        SecondAlt = sa;
    }
    
    //Getter methods
    public int GetCabin(){
        return(cabin);
    }
    public String GetName(){
        return(name);
    }
    
    public Activity GetFirstChoice(){
        return(FirstChoice);
    }
    
    public Activity GetFirstAlt(){
        return(FirstAlt);
    }
    
    public Activity GetSecondChoice(){
        return(SecondChoice);
    }
    
    public Activity GetSecondAlt(){
        return(SecondAlt);
    }
}
