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
        Semaphore semA = new Semaphore(1);
        Semaphore semB = new Semaphore(0);
        Semaphore semC = new Semaphore(0);
        Thread a = new Thread(new Secuencia('A', 1, semA, semB));
        Thread b = new Thread(new Secuencia('B', 2, semB, semC ));
        Thread c = new Thread(new Secuencia('C', 3, semC, semA));

        a.start();
        b.start();
        c.start();
    }

}
