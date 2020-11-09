/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ejercicio6;

/**
 *
 * @author Leandro Hernandez
 */
public class Secuencia implements Runnable {

    private final Texto texto;
    private final char caracter;

    public Secuencia(char caracter, Texto text) {
        this.caracter = caracter;
        texto = text;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            texto.imprimir(caracter);
        }
    }

}
