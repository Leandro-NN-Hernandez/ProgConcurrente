package TeoriaConcV2.JefeSaludoSinEspera;

public class Saludo {

    private static Object monitorSaludo = new Object();
    private final int MAXSALUDOS;
    private int cont;

    public Saludo(int max){
        MAXSALUDOS = max;
        cont = 0;
    }

    synchronized void esperarJefe(String empleado) {
        try {
            //System.out.println(empleado+" ENTRO ESPERARJEFE");
            wait(2000); //Por si las moscas
           // System.out.println(empleado+" PASO WAIT EJ--------------");
            System.out.println(empleado + "> Buenos dias jefe!");
            synchronized(monitorSaludo){                
                cont++;
                //System.out.println(cont);
                if(cont==MAXSALUDOS){ 
                    //System.out.println(empleado+" PASO ==");             
                    monitorSaludo.notify();
                }
                //System.out.println(empleado+" FINAL ej"); 
            }
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    synchronized void saludoJefe() {
        System.out.println("JEFE> Buenos dias!");
        notifyAll();
    }

    void aTrabajar() {
        synchronized (monitorSaludo) {
            while (cont < MAXSALUDOS) {
                try {
                    monitorSaludo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("LISTO, ahora que todos han saludado - a trabajar");
    }
}

}
    
