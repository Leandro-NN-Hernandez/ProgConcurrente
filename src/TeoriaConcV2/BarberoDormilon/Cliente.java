package TeoriaConcV2.BarberoDormilon;

public class Cliente extends Persona implements Runnable {

    private String nombre;

    public Cliente(Barberia b, String n) {
        super(b);
        nombre = n;
    }

    public void run() {
        while (true) {
            barberia.entrarBarberia(nombre);
            barberia.sentarseSillon(nombre);
            barberia.notificarBarbero(nombre);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         }
     }
}
