package TP4.Ejercicio8B;

import java.util.concurrent.Semaphore;

public class Testigo {
    private Semaphore semTestigo;

    public Testigo(Semaphore sem) {
        semTestigo = sem;
    }

    public void agarrar(String nombre) throws InterruptedException {
        semTestigo.acquire();
        System.out.println(nombre + " agarra el testigo");
    }

    public void entrega(String nombre, long start) throws InterruptedException { 
        System.out.println(nombre + " entrega el testigo a los " + ((System.currentTimeMillis() - start) / 1000)+" segundos.");
        semTestigo.release();
    }
}
