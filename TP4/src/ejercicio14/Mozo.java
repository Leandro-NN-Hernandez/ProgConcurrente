/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Mozo implements Runnable{
    private Servicio service;
    private int cont=0;
    
    public Mozo(Servicio serv){
        this.service=serv;    
    }
    public void setContador(int cant){
        this.cont=cant;
    }
    
    @Override
    public void run(){
        for(int i=0;i<cont;i++){
            try {  
                this.service.atenderMozo();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
