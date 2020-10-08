/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author Barba
 */
public class Servicio {

    private Semaphore semafEspacio = new Semaphore(2);
    private Semaphore semafPedirComida = new Semaphore(0);
    private Semaphore semafPedirBebida = new Semaphore(0);
    private Semaphore semafBebida = new Semaphore(0);
    private Semaphore semafComida = new Semaphore(0);
    private Semaphore semafSalir = new Semaphore(0);

    public void pedir(int num, int pedido) throws InterruptedException {
        this.semafEspacio.acquire();
        System.out.println("Empleado " + num + " se sienta");
        //tiempo que tarda en pedir
        Thread.sleep(1000);
        switch (pedido) {
            case 0:
                System.out.println("Empleado " + num + " pide bebida");
                this.semafPedirBebida.release();
                this.beber(num);
                break;
            case 1:
                this.semafPedirComida.release();
                System.out.println("Empleado " + num + " pide comida");
                this.comer(num);
                break;
            case 2:
                System.out.println("Empleado " + num + " pide menu completo");
                this.semafPedirBebida.release();
                this.semafPedirComida.release();
                this.comerMenu(num);
                break;
        }
    }

    public void beber(int num) throws InterruptedException {
        this.semafBebida.acquire();
        System.out.println("Empleado " + num + " esta bebiendo");
        // tiempo que esta bebiendo
        Thread.sleep(1000);
        this.irseBebida(num);

    }

    public void comer(int num) throws InterruptedException {
        this.semafComida.acquire();
        System.out.println("Empleado " + num + " esta comiendo");
        //tiempo que esta comiendo
        Thread.sleep(1000);
        this.irseComida(num);

    }

    public void comerMenu(int num) throws InterruptedException {
        this.semafBebida.acquire();
        System.out.println("Empleado " + num + " esta bebiendo");
        // tiempo que esta bebiendo
        Thread.sleep(1000);
        if (this.semafComida.tryAcquire()) {
            System.out.println("Empleado " + num + " esta comiendo");
            //tiempo que esta comiendo
            Thread.sleep(1000);
            this.irseMenu(num);
        }

    }

    public void irseBebida(int num) throws InterruptedException {
        this.semafSalir.acquire();
        System.out.println("Mozo termino de atender al Empleado " + num);
        this.semafEspacio.release();
    }

    public void irseComida(int num) throws InterruptedException {
        this.semafSalir.acquire();
        System.out.println("Cocinero termino de atender al Empleado " + num);
        this.semafEspacio.release();
    }

    public void irseMenu(int num) throws InterruptedException {
        this.semafSalir.acquire();
        System.out.println("Mozo termino de atender al Empleado " + num);
        System.out.println("Cocinero termino de atender al Empleado " + num);
        this.semafEspacio.release();
    }

    public void atenderMozo() throws InterruptedException {
        this.semafPedirBebida.acquire();
        System.out.println("Mozo atiende al Empleado");
        try {
            //Tiempo que tarda en llevar el pedido
            Thread.sleep(1000);
            this.semafBebida.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.semafSalir.release();

    }

    public void atenderCocinero() throws InterruptedException {
        this.semafPedirComida.acquire();
        System.out.println("Cocinero atiende al Empleado");
        try {
            Thread.sleep(1000);
            this.semafComida.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.semafSalir.release();

    }

}
