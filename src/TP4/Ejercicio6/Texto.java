/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ejercicio6;

import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Hernandez
 */
public class Texto {

    private final char[] letra;
    private final HashMap dicSem;
    private final HashMap dicText;

    public Texto(Semaphore[] sem, char[] letra, int[] rep) {
        this.letra = letra;
        this.dicText = new HashMap();
        dicSem = new HashMap();
        for (int i = 0; i < letra.length; i++) {
            dicSem.put(letra[i], sem[i]);
            String sec = "";
            for (int j = 0; j < rep[i]; j++) {
                sec += letra[i];
            }
            dicText.put(letra[i], sec);
        }
    }

    public void imprimir(char caracter) {
        int pos = buscarPosicion(caracter);
        Semaphore inicial = (Semaphore) dicSem.get(caracter);
        Semaphore fin = (Semaphore) dicSem.get(letra[(pos + 1) % letra.length]);
        try {
            inicial.acquire();
            System.out.print((String) dicText.get(caracter));
            fin.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Secuencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int buscarPosicion(char car) {
        boolean encontrado = false;
        int i = 0, pos = -1;

        while (!encontrado && i < letra.length) {
            encontrado = letra[i] == car;
            if (encontrado) {
                pos = i;
            } else {
                i++;
            }
        }
        return pos;
    }
}
