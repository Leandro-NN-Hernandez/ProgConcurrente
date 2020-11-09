package TP5.Ejercicio4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Pista {
    private Contador contadorAterrisajes;
    private ReentrantLock lockPista;
    private Semaphore semAterrizaje;

    public Pista(int c) {
        contadorAterrisajes = new Contador(0, c);
        lockPista = new ReentrantLock();
        semAterrizaje = new Semaphore(10, true);
    }

    public void aterrizar(String nombre) {
        try {
            semAterrizaje.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        lockPista.lock();
        System.out.println(nombre + " esta ATERRIZANDO.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        contadorAterrisajes.aumentar();
        
    }

    public void espera(String nombre) {
        System.out.println(nombre + " esta en ESPERA.");
        lockPista.unlock();
    }

    public void despegar(String nombre) {
        while(contadorAterrisajes.cantMenorMAX()){}
            try {                
                lockPista.lock();
                contadorAterrisajes.disminuir();
                System.out.println(nombre + " esta DESPEGANDO.");
                Thread.sleep(1000);
                semAterrizaje.release();
            } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }finally{
            lockPista.unlock();
        }
    }   
}
