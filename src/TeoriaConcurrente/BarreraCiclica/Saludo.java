package TeoriaConcurrente.BarreraCiclica;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Saludo {

    private CyclicBarrier barLlegada;
    private CyclicBarrier barSaludo;
    private CyclicBarrier barFinalizado;
    private Contador cont;

    public Saludo(int cantE) {
        barSaludo = new CyclicBarrier(cantE);
        barFinalizado = new CyclicBarrier(cantE);
        cont = new Contador(cantE, cantE);
    }

    public void setBar(int cantE, Personal jefe) {
        barLlegada = new CyclicBarrier(cantE, jefe);
    }

    void cartelLlega(String nombre) throws InterruptedException, BrokenBarrierException {
        System.out.println("(" + nombre + " llega)");
        barLlegada.await();
    }

    void cartelLlegaJefe(String nombre) {
        System.out.println("(" + nombre + " llega)");
    }

    void esperarJefe(String empleado) throws InterruptedException, BrokenBarrierException {
        System.out.println(empleado + "> Buenos dias jefe!");
        barSaludo.await();
        barFinalizado.await();

    }

    void saludoJefe() throws InterruptedException, BrokenBarrierException {
        System.out.println("JEFE> Buenos dias!");

    }

    void aTrabajar() throws InterruptedException, BrokenBarrierException {
        cont.disminuir();
        if (cont.isZero()) {
            System.out.println("LISTO, ahora que todos han saludado - a trabajar");
            cont.aMAX();
        }
        barFinalizado.await();
    }

}
