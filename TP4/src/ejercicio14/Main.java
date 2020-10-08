/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Main {
    public static void main(String[] args) {
        Servicio service= new Servicio();
        Mozo mozo= new Mozo(service);
        Cocinero cocin=new Cocinero(service);
        int pedido;
        int contadorBebida=0;
        int contadorComida=0;
        Empleado cliente1 = new Empleado(1,service);
        Empleado cliente2 = new Empleado(2,service);
        Empleado cliente3 = new Empleado(3,service);
        Empleado cliente4 = new Empleado(4,service);
        Empleado cliente5 = new Empleado(5,service);
        Empleado cliente6 = new Empleado(6,service);
        
       Empleado arr[]= {cliente1,cliente2,cliente3,cliente4,cliente5,cliente6};
       for(int n=0;n<6;n++){
           pedido= new Random().nextInt(2);
           arr[n].setPedido(pedido);
           switch (pedido){
               case 0:
                   contadorBebida++;break;
               case 1:
                   contadorComida++;break;
               case 2:
                   contadorComida++;contadorBebida++;break;
           }
       }
       mozo.setContador(contadorBebida);
       cocin.setContador(contadorComida);
              
       Thread hiloMozo= new Thread(mozo);
       Thread hiloCocin= new Thread(cocin);
       
       hiloCocin.start();
       hiloMozo.start();
        for(int i=0;i<6;i++){
           arr[i].start();
        }       
    }
    
}
