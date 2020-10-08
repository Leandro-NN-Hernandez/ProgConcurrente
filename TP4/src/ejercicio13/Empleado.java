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
public class Empleado extends Thread{
    private int id;
    private Servicio ser;
    
    public Empleado(int ide, Servicio serv){
        this.id= ide;
        this.ser= serv;
    }
    
    @Override
    public void run(){
        try {
            this.ser.pedir(id);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
