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

public class Buffer {

    private final Semaphore semEspacio;
    private final ReentrantLock lockPermiso;
    private final Semaphore cantidad;
    private int maximo;

    public Buffer(int cant) {
        semEspacio = new Semaphore(10, true);
        lockPermiso = new ReentrantLock();
        cantidad = new Semaphore(0);
        maximo=cant;
    }

    public void ingresarBuffer(int nombre) {
        try {
            semEspacio.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarElemento(int nombre) {
        lockPermiso.lock();
        try {
            // if (semEspacio.availablePermits() < 10) {
            if (cantidad.availablePermits() < maximo) {
                cantidad.release();
                System.out.println("Productor " + nombre + " AGREGA al buffer un elemento. Quedan: " + cantidad.availablePermits());
            }
            semEspacio.release();
            // }
        } finally {
            lockPermiso.unlock();
        }
    }

    public void quitarElemento(int nombre) {
        
        try {
            cantidad.acquire();
            System.out.println("Consumidor " + nombre + " QUITA del buffer un elemento. Quedan: " + cantidad.availablePermits());
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
        }
        semEspacio.release();

    }
}
