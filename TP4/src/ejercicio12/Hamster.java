/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Hamster extends Thread{
    private int numero;
    private Actividad accion;
    
    public Hamster(int n, Actividad acc){
        this.accion=acc;
        this.numero=n;
    }
    
    @Override
    public void run(){
        try {
            this.accion.comer(numero);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
}
