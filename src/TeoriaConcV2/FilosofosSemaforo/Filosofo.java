package TeoriaConcV2.FilosofosSemaforo;

import java.util.Random;

public class Filosofo implements Runnable {
    private String nombre;
    private Mesa mesa;
    private Random tiempo;

    public Filosofo(String nom, Mesa m){
        nombre = nom;
        mesa = m;
        this.tiempo = new Random();
    }

    public void run(){
        while(true){
           this.pensando();
           mesa.agarrarPalillos(nombre);
           mesa.comiendo(nombre);
        }
    }

    private void pensando(){
        System.out.println(nombre+" esta pensado sobre la vida y cosas de filosofia.");
        try {
            Thread.sleep((this.tiempo.nextInt(10)+1)*100);
        } catch (Exception e) {
                    }
    }

}