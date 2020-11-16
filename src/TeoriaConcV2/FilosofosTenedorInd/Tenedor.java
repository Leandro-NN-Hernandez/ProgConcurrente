package TeoriaConcV2.FilosofosTenedorInd;

import java.util.concurrent.Semaphore;

public class Tenedor {
    private Semaphore semDisponible;
    private boolean disponible;

    public Tenedor() {
        semDisponible = new Semaphore(1, true);
        disponible = true;
    }

    public synchronized boolean isDisponible(){
        return disponible;
    }

    public void adquirirTenedor() {        
            try {            
            semDisponible.acquire();
            disponible = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    public void dejarTenedor() {        
        disponible = true;
        semDisponible.release();    
}


}
