package TeoriaConcV2.FilosofosSemaforo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Mesa {
    private Semaphore semPalillos;

    public Mesa(int cantPalillos) {
        semPalillos = new Semaphore(cantPalillos, true);
    }

    public void agarrarPalillos(String nombre) {
        System.out.println("-----------" + nombre + " QUIERE agarrar los palillos.");
        try {
            semPalillos.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nombre + " AGARRO los dos palillos-----------");
    }

    public void comiendo(String nombre) {
        Random tiempo = new Random();
        System.out.println(nombre + " esta COMIENDO.");

        try {
            Thread.sleep((tiempo.nextInt(10) + 1) * 100);
        } catch (InterruptedException e) {           
            e.printStackTrace();
        }
            
        System.out.println("--------------"+nombre+" deja los palillos-------------------------");
        semPalillos.release(2); 
    }
}
