package TeoriaConcV2.BarberoDormilon;

public class Barberia {
    private static Object sillon;
    private static Object barbero;
    private static Object salon;
    private int cantOcupados;
    private final int MAXSillas;
    private int cantSillon;
    private int cantBarbero;

    public Barberia(int cantLugares) {
        cantBarbero = 1;
        cantSillon = 1;
        sillon = new Object();
        barbero = new Object();
        salon = new Object();
        cantOcupados = 0;
        MAXSillas = cantLugares;
    }

    public void entrarBarberia(String nombre) {
        synchronized (salon) {
            while (cantOcupados == MAXSillas) {
                System.out.println(nombre + ": esta PASEANDO.");
                try {
                    salon.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cantOcupados++;
            System.out.println(nombre + ": ENTRO a la barberia.");
        }
    }

    public void sentarseSillon(String nombre) {
        synchronized (sillon) {
            System.out.println("----------------" + nombre + ": ESPERA para sentarse en sillon.");
            while (cantSillon == 0) {
                try {
                    sillon.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cantSillon--;
            synchronized(salon){
                cantOcupados--;          
                System.out.println(nombre + ": se SIENTA en el sillon.-----------------------");
                salon.notifyAll();
            }
        }
    }

    public void notificarBarbero(String nombre) {
        synchronized (barbero) {
            cantBarbero--;
            barbero.notifyAll();
            System.out.println(nombre + ": ESTA siendo atendido");
            try {
                barbero.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            
            System.out.println(nombre + ":  SALE de la barberia.");
            synchronized(sillon){
                cantSillon++;
                sillon.notifyAll();
            }
            
        }
    }

    public void descansarBarbero() {
        synchronized (barbero) {            
            while (cantBarbero != 0) {
                System.out.println("Barbero DUERME");
                try {
                    barbero.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Barbero esta ATENDIENDO");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Barbero TERMINO de atender");
            cantBarbero++;
            barbero.notifyAll();
        }
    }


}
