package TP5.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Vendedor {
    private Semaphore semVendedor;
    private Semaphore semAsiento;
    private Semaphore semTren;

    public Vendedor(int cantLugares) {
        semVendedor = new Semaphore(1, true);
        semTren = new Semaphore(0);
        semAsiento = new Semaphore(cantLugares, true);
    }

    public void hacerCola(String nombre) {
        System.out.println(nombre + " esta haciendo COLA para comprar ticket.");
        try {
            semVendedor.acquire();
        } catch (InterruptedException ie) {
        }
    }

    public void comprarTicket(String nombre) {
        System.out.println(nombre + " COMPRO su ticket.");        
    }

    public void salirCola(String nombre) {
        System.out.println(nombre + " ESPERA al tren.");
        semVendedor.release();
    }

    public void subirTren(String nombre) {
        try {
            semAsiento.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre + " se SUBIO al tren.");
        semTren.release(1);

    }

    public void parteTren(int cant) {
        try {
            semTren.acquire(cant);
            System.out.println("El tren PARTIO.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void llegaTren(int cant){
        System.out.println("El tren TERMINA el recorrido.");
        System.out.println("Los pasajeros se BAJAN.");
        semAsiento.release(cant);

    }

}
