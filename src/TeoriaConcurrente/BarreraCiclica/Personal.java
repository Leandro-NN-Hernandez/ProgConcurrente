package TeoriaConcurrente.BarreraCiclica;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Personal implements Runnable {

    protected String nombre;
    protected Saludo saludo;

    Personal(Saludo s, String n) {
        nombre = n;
        saludo = s;
    }

    Personal(Saludo s, String n, Contador c) {
        nombre = n;
        saludo = s;        
    }

    @Override
    public void run() {
        while (true) {
            try {
                saludo.cartelLlega(nombre);
                saludo.esperarJefe(nombre);                            
                saludo.aTrabajar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
