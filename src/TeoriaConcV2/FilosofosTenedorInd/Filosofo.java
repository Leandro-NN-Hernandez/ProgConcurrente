package TeoriaConcV2.FilosofosTenedorInd;

import java.util.Random;

public class Filosofo implements Runnable {
    private Tenedor tenedorIzq;
    private Tenedor tenedorDer;
    private String nombre;
    private boolean par;

    private static boolean turno = true;

    public Filosofo(String nombre, Tenedor izq, Tenedor der, boolean par){
        this.nombre = nombre;
        tenedorIzq = izq;
        tenedorDer = der;
        this.par = par;
    }

    public void run(){
        while(true){
            if(par==turno && tenedorDer.isDisponible() && tenedorIzq.isDisponible()){
                tenedorDer.adquirirTenedor();
                tenedorIzq.adquirirTenedor();
                this.comer();
                turno = !turno;
                tenedorDer.dejarTenedor();
                tenedorIzq.dejarTenedor();
            }else{
                this.pensar();
            }    
        }
    }
     
    private void comer(){
        int tiempo = (new Random().nextInt(10)+1)*100;
        System.out.println("--------------"+nombre+ " esta COMIENDO----------------------");
        try {
            Thread.sleep(tiempo);
        } catch (Exception e) {
            }
    }

    private void pensar(){
        int tiempo = (new Random().nextInt(10)+1)*100;
        System.out.println("....................."+nombre+ " esta PENSANDO.......................");
        try {
            Thread.sleep(tiempo);
        } catch (Exception e) {
            }
    }

}
