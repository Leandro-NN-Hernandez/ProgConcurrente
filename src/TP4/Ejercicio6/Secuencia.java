/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ejercicio6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Hernandez
 */
public class Secuencia implements Runnable {

    private final char caracter;
    private final int repeticion;
    private final Semaphore inicial;
    private final Semaphore fin;

    public Secuencia(char caracter, int repeticion, Semaphore sem1, Semaphore sem2) {
        this.caracter = caracter;
        this.repeticion = repeticion;
        inicial = sem1;
        fin = sem2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            imprimir();
        }
    }

    private void imprimir() {
        String sec = "";
        for (int i = 0; i < repeticion; i++) {
            sec += caracter;
        }
        try {
            inicial.acquire();
            System.out.print(sec);
            fin.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Secuencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
