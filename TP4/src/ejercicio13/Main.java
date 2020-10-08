/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13;

/**
 *
 * @author Barba
 */
public class Main {
    public static void main(String[] args) {
        Servicio service= new Servicio();
        Mozo mozo= new Mozo(service);
        Empleado cliente1 = new Empleado(1,service);
        Empleado cliente2 = new Empleado(2,service);
        Empleado cliente3 = new Empleado(3,service);
        Empleado cliente4 = new Empleado(4,service);
        Empleado cliente5 = new Empleado(5,service);
        Empleado cliente6 = new Empleado(6,service);
        
       Empleado arr[]= {cliente1,cliente2,cliente3,cliente4,cliente5,cliente6};
              
       Thread hiloMozo= new Thread(mozo);
       
       hiloMozo.start();
        for(int i=0;i<6;i++){
           arr[i].start();
        }
       
           
        
    }
}
