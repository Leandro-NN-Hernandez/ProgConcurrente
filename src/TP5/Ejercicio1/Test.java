/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ejercicio1;

/**
 *
 * @author Leandro Hernandez
 */
public class Test {

    public static void main(String[] args) {
        int cant = 2, cantP = 5, cantG = 5;
        Comedor comedor = new Comedor(cant);
        Thread[] perro = new Thread[cantP];
        Thread[] gato = new Thread[cantG];

        for (int i = 0; i < cantP; i++) {
            perro[i] = new Thread(new Perro("PERRO " + i, comedor));
        }

        for (int i = 0; i < cantP; i++) {
            gato[i] = new Thread(new Gato("GATO " + i, comedor));
        }

        for (int i = 0; i < cantP; i++) {
            perro[i].start();
        }

        for (int i = 0; i < cantP; i++) {
            gato[i].start();
        }
    }
}
