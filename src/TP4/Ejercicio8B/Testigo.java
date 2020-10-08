package TP4.Ejercicio8B;

import java.util.concurrent.Semaphore;

public class Testigo {

    private Semaphore semTestigo;
    private int turno;

    public Testigo(Semaphore sem) {
        semTestigo = sem;
        turno = 0;
    }

    public void agarrar(String nombre, int t) throws InterruptedException {
        while (t != turno) {
            //Se decide usar yield para que no se quede en un deathlock, debido a que no se avanzaria
            // y el ejercicio requiere de un solo semaforo
            Thread.yield();
        }
        semTestigo.acquire();
        System.out.println(nombre + " agarra el testigo");
    }

    public void entrega(String nombre, long start) throws InterruptedException {
        System.out.println(nombre + " entrega el testigo a los " + ((System.currentTimeMillis() - start) / 1000) + " segundos.");
        turno++;
        semTestigo.release();
    }
}
