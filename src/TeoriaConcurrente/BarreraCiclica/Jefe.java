package TeoriaConcurrente.BarreraCiclica;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jefe extends Personal {

    Jefe(Saludo s, String n) {
        super(s, n);
    }

    @Override
    public void run() {
        try {
            saludo.cartelLlegaJefe(nombre);
            saludo.saludoJefe();
        } catch (InterruptedException ex) {
            Logger.getLogger(Jefe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Jefe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
