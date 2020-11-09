package TeoriaConcV2.BufferLimitado;

import java.util.concurrent.Semaphore;

public class BuferLim {
    private int cantidad;
    private Semaphore semConsumir;
    private Semaphore semProducir;
    private Semaphore semCantidad;

    public BuferLim(int cantidadPermisos) {
        this.cantidad = 0;
        semProducir = new Semaphore(cantidadPermisos, true);
        semConsumir = new Semaphore(0, true);
        semCantidad = new Semaphore(1, true);
    }

    public void consumir(String name) {
        try {
            semConsumir.acquire();
            semCantidad.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();       
        }       
        cantidad--;
        System.out.println(name + " CONSUMIO un producto. Quedan " + cantidad + " productos-----------");
        semProducir.release();     
        semCantidad.release();
    }

    public void producir(String name) {
        try {        
            semProducir.acquire();   
            semCantidad.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cantidad++;
        System.out.println("-----------------"+name + " PRODUJO un producto. Quedan "+cantidad+" productos");
        semConsumir.release();
        semCantidad.release();
    }
}