/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Servicio {

    private Semaphore semafEspacio = new Semaphore(1);
    private Semaphore semafPedir = new Semaphore(0);
    private Semaphore semafComida = new Semaphore(0);
    private Semaphore semafSalir = new Semaphore(0);

    public void atender() throws InterruptedException {
        this.semafPedir.acquire();
        System.out.println("Mozo atiende al Empleado");
        try {
                //Tiempo que tarda en llevar el pedido
                Thread.sleep(1000);
                this.semafComida.release();
        } catch (InterruptedException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
         }
            this.semafSalir.release();
        
    }

    public void pedir(int num) throws InterruptedException {
        this.semafEspacio.acquire(); 
            System.out.println("Empleado " + num + " se sienta");
            try {
                //Tiempo que tarda en pedir la comida
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.semafPedir.release();
            System.out.println("Empleado "+num+" pide comida");
            this.comer(num);
        

    }

    public void comer(int num) throws InterruptedException {
        this.semafComida.acquire();
            System.out.println("Empleado "+num+" esta comiendo");
            try {
                //tiempo que tarda en comer
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.irse(num);
        

    }
    public void irse(int num) throws InterruptedException{
        this.semafSalir.acquire();
        System.out.println("Empleado "+num+" se va y agradece al mozo");
        System.out.println("Mozo termino de atender al Empleado");
        this.semafEspacio.release();
           
    }
}
