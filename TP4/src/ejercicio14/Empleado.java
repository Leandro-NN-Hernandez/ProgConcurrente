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
public class Empleado extends Thread{
    private int id;
    private Servicio ser;
    private int pedido;
    
    public Empleado(int ide, Servicio serv){
        this.id= ide;
        this.ser= serv;
    }
    public void setPedido(int ped){
        this.pedido=ped;
    }
    
    @Override
    public void run(){
        try {
            this.ser.pedir(id, pedido);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
