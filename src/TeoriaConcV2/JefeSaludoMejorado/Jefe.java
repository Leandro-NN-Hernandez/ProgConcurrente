package TeoriaConcV2.JefeSaludoMejorado;

public class Jefe extends Personal{
    
    Jefe(Saludo s, String n, int cant) {
        super(s, n);
        numEmp = cant;
    }

    public void run() {
        this.cartelLlega();
        synchronized(monitor){
            if (llegaron < numEmp) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }         
    saludo.saludoJefe();    
    }
}
