package TeoriaConcV2.JefeSaludoMejorado;

public class Personal implements Runnable {
    protected String nombre;
    protected Saludo saludo;
   
    protected static int llegaron = 0;
    protected static int numEmp;
    protected static Object monitor = new Object();

    Personal(Saludo s, String n) {        
        nombre = n;
        saludo = s;
    }

    /*
    public void setNumEmp(int n){
        numEmp = n;
    }
    */

    protected void cartelLlega(){
        System.out.println("(" + nombre + " llega)");
    }

    public void run() {
        this.cartelLlega();        
        synchronized(monitor) {    
            llegaron++;
            //System.out.println(nombre+ " ENTRO MONITOR RUN");
            if(llegaron==numEmp){
                //System.out.println(nombre+" ENTRO == monitor"); 
                monitor.notify();
            }             
        }               
        saludo.esperarJefe(nombre);   
    }     
        
    
}
