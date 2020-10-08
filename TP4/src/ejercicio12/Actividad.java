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

    public void comer(int numero) throws InterruptedException {
        try {
            if (this.lockComida.tryLock()) {
                System.out.println("Hamster " + numero + " esta comiendo");
                Thread.sleep(1000);
            }
        } finally {
            System.out.println("Hamster " + numero + " dejo de comer");
            this.lockComida.unlock();
            this.correr(numero);           
        }
        

    }
    public void correr(int numero) throws InterruptedException{
        try{
            if(this.lockCorrer.tryLock()){
                System.out.println("Hamster "+numero+" esta corriendo");
                Thread.sleep(1000);    
            }
        } finally{
            System.out.println("Hamster " + numero + " dejo de correr");
            this.lockCorrer.unlock();
            this.dormir(numero);
        
        }
    
    }
    public void dormir(int numero) throws InterruptedException{
        try{
            if(this.lockDormir.tryLock()){
                System.out.println("Hamster "+numero+" esta durmiendo");
                Thread.sleep(1000);
            }
        } finally{
            System.out.println("Hamster " + numero + " dejo de dormir");
            this.lockDormir.unlock();
        }
    
    }

}
