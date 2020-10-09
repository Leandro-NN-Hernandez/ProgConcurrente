/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

/**
 *
 * @author Barba
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Actividad accion= new Actividad();
        Hamster roedor1= new Hamster(1,accion);
        Hamster roedor2= new Hamster(2,accion);
        Hamster roedor3= new Hamster(3,accion);
        
        roedor1.start();
        roedor2.start();
        roedor3.start();
        roedor1.join();
        roedor2.join();
        roedor3.join();
        
    }
    
   
    
    
    
}
