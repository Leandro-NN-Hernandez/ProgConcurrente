/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Mozo implements Runnable{
    private Servicio service;
    
    public Mozo(Servicio serv){
        this.service=serv;    
    }
    
    @Override
    public void run(){
        try {
            for(int i=0;i<6;i++){
            this.service.atender();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
