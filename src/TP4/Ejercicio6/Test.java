/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ejercicio6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Leandro Hernandez
 */
public class Test {

    public static void main(String[] args) {

        Semaphore[] sem = new Semaphore[3];
        sem[0] = new Semaphore(1);
        for (int i = 1; i < sem.length; i++) {
            sem[i] = new Semaphore(0);
        }
        char[] letra = {'A', 'B', 'C'};
        int[] rep = {1, 2, 3};

        Texto text = new Texto(sem, letra, rep);

        Thread a = new Thread(new Secuencia('A', text));
        Thread b = new Thread(new Secuencia('B', text));
        Thread c = new Thread(new Secuencia('C', text));

        a.start();
        b.start();
        c.start();
    }

}
