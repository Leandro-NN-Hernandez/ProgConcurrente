package TeoriaConcurrente.BarreraCiclica;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestSaludo {

    public static void main(String argv[]) {
        String[] nombresEmpleados = {"Pablo", "Luis", "Andrea", "Pedro", "Paula"};
        int largo = nombresEmpleados.length;
        Contador cont = new Contador(largo, largo);

        Saludo hola = new Saludo(largo);
        hola.setBar(largo, new Jefe(hola, "JEFE"));

        Thread[] elPersonal = new Thread[largo];
        for (int i = 0; i < largo; i++) {
            elPersonal[i] = new Thread(new Personal(hola, nombresEmpleados[i], cont));
        }

        for (int i = 0; i < largo; i++) {
            elPersonal[i].start();
        }

    }
}
