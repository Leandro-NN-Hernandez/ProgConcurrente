package TP4.Ejercicio8B;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Leandro Hernandez
 */
public class Carrera {
    public static void main(String[] args) {
        Testigo testigo = new Testigo(new Semaphore(1));

        Thread[] atletas = { 
                new Thread(new Atleta("PRIMERO", testigo, 0)),
                new Thread(new Atleta("SEGUNDO", testigo, 1)),
                new Thread(new Atleta("TERCERO", testigo, 2)),
                new Thread(new Atleta("CUARTO", testigo, 3)) 
            };

        for (int i = 0; i < atletas.length; i++) {
            atletas[i].start();
        }
    }

}