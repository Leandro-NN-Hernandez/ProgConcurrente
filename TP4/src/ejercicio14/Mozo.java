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
public class Mozo extends EmpleadoRestaurante{
    
    public Mozo(Servicio serv){
        super(serv);   
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
