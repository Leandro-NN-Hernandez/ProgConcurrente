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
public class Pasajero implements Runnable {
    private Taxi taxi;
    
    public Pasajero(Taxi taxi){
        this.taxi=taxi;
    }

    @Override
    public void run() {
        
            try {
                this.taxi.entrarTaxi();
            } catch (InterruptedException ex) {
                Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
    
    
    
    
    
}
