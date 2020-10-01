/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Taxista implements Runnable {
    private Taxi taxi;
    
    public Taxista(Taxi taxi){
        this.taxi= taxi;
    }

    @Override
    public void run() {
            try {
                taxi.recorre();
            }catch(InterruptedException ex){
                Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    
}
