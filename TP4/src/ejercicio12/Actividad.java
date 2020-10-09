/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Barba
 */
public class Actividad {

    private ReentrantLock lockComida = new ReentrantLock();
    private ReentrantLock lockCorrer = new ReentrantLock();
    private ReentrantLock lockDormir = new ReentrantLock();

    public boolean comer(int numero) throws InterruptedException {
        boolean band = true;
        if (this.lockComida.tryLock()) {
            System.out.println("Hamster " + numero + " esta comiendo");
            Thread.sleep(1000);
            System.out.println("Hamster " + numero + " dejo de comer");
            this.lockComida.unlock();
            band = false;
        }
        return band;

    }

    public boolean correr(int numero) throws InterruptedException {
        boolean band = true;
        if (this.lockCorrer.tryLock()) {
            System.out.println("Hamster " + numero + " esta corriendo");
            Thread.sleep(1000);
            System.out.println("Hamster " + numero + " dejo de correr");
            band = false;
            this.lockCorrer.unlock();
        }
        return band;

    }

    public boolean dormir(int numero) throws InterruptedException {
        boolean band = true;
        if (this.lockDormir.tryLock()) {
            System.out.println("Hamster " + numero + " esta durmiendo");
            Thread.sleep(1000);
            System.out.println("Hamster " + numero + " dejo de dormir");
            this.lockDormir.unlock();
            band = false;
        }
        return band;

    }

}
