/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Taxi {
    private Semaphore semTaxi;
    private Semaphore semTaxista;
    private Semaphore semSalida;
    
    public Taxi(){
        this.semTaxi = new Semaphore(1);
        this.semTaxista= new Semaphore(0);
        this.semSalida=new Semaphore(0);    
    }
    
    public void recorre() throws InterruptedException{
        System.out.println("Taxista duerme");
        this.semTaxista.acquire();
        System.out.println("Taxista empieza a manejar");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Taxista deja de manejar");
        this.semSalida.release();     
    }
    
    public void entrarTaxi() throws InterruptedException{
        if(this.semTaxi.tryAcquire()){
            System.out.println("Pasajero llama al taxi");
            this.semTaxista.release();
            System.out.println("Sube al taxi");
            this.semSalida.acquire();
            this.semTaxi.release();
            System.out.println("Baja del taxi");
        }
    
    }
    
}
