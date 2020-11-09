package TeoriaConcV2.BufferIlimitado;

import java.util.concurrent.Semaphore;

public class Bufer {
    private int cantidad;
    private Semaphore semConsumir;
    private Semaphore semCantidad;

    public Bufer() {
        this.cantidad = 0;
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
        if (cantidad != 0) {
            cantidad--;
            System.out.println(name + " CONSUMIO un producto. Quedan " + cantidad + " productos-----------");
          
        } else {
            System.out.println("--------------" + name + " NO PUDO CONSUMIR un producto.-----------");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        semCantidad.release();
    }

    public void producir(String name) {
        try {           
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