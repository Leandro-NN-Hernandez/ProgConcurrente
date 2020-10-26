/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeoriaConcurrente;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Hernandez
 */
public class Buffer {

    private final Semaphore semEspacio;
    private final ReentrantLock lockPermiso;
    private int cantidad;

    public Buffer() {
        semEspacio = new Semaphore(0, true);
        lockPermiso = new ReentrantLock();
        cantidad = 0;
    }

    public void ingresarBuffer(int nombre) {
        try {
            semEspacio.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarElemento(int nombre) {
        // if (semEspacio.availablePermits() < 10) {
        lockPermiso.lock();       
            System.out.println("Productor " + nombre + " AGREGA al buffer un elemento. Quedan: " + cantidad);
            try {
                cantidad++;
            } finally {
                lockPermiso.unlock();
                semEspacio.release();
            }
            
       // }
    }

    public void quitarElemento(int nombre) {
        try {
            semEspacio.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lockPermiso.tryLock()) {
            System.out.println("Consumidor " + nombre + " QUITA del buffer un elemento. Quedan: " + cantidad);
            try {
                if (cantidad > 0) {
                    cantidad--;
                }
            } finally {
                lockPermiso.unlock();
            }
        }
    }
}
