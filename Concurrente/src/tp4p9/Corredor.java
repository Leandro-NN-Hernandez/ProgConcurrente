/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4p9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Corredor extends Thread {
    private String nombre;
    private double tiempo;
    private Testigo testigo;
    
    public Corredor(String nombre,Testigo test){
        this.testigo=test;
        this.nombre=nombre;
 
    }
    
    public double getTiempo(){
        return this.tiempo;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void run(){
        this.testigo.corre(this.nombre);
        try {
            Thread.sleep((long) ((Math.random()*3)*1000));
            this.testigo.pasarTestigo(this.nombre);
  
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
