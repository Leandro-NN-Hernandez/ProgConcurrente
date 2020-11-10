package TeoriaConcV2.JefeSaludoSinEspera;

public class Personal implements Runnable {
    private String nombre;
    private Saludo saludo;
    private boolean esJefe;
    static int llegaron = 0;
    private static int numEmp;
    private static Object monitor = new Object();

    Personal(Saludo s, String n) {
        esJefe = false;
        nombre = n;
        saludo = s;
    }

    Personal(Saludo s, String n, int x) {
        esJefe = true;
        nombre = n;
        saludo = s;
        numEmp = x;
    }

    public void run() {
        System.out.println("(" + nombre + " llega)");
        if (esJefe) {
            synchronized(monitor){
                while (llegaron < numEmp) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }         
        saludo.saludoJefe();
    } else {
        synchronized(monitor) {    
            llegaron++;
            //System.out.println(nombre+ " ENTRO MONITOR RUN");
            if(llegaron==numEmp){
                System.out.println(nombre+" ENTRO == monitor"); 
                monitor.notify();
            }            
        }       
        saludo.esperarJefe(nombre);    
    }     
        
    }
}
