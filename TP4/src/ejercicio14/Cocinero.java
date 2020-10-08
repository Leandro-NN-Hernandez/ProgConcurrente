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
public class Cocinero extends EmpleadoRestaurante{
    
    public Cocinero(Servicio serv){
        super(serv);
    }
    
    public void run(){
        for(int i=0;i<cont;i++){
            try {  
                this.service.atenderCocinero();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
