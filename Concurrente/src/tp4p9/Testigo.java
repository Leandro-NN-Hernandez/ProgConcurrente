/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4p9;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Testigo {
    private Semaphore sem;
    
    public Testigo(){
        this.sem = new Semaphore(1);
    }
    
    public void corre(String nombre){
        try {
            this.sem.acquire();
            System.out.println(nombre+" empieza a correr ");
        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pasarTestigo(String nombre){
        this.sem.release();
        System.out.println(nombre+" deja de correr");
    }
        
    
    
    
}
