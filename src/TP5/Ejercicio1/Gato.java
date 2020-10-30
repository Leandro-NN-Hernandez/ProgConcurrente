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
public class Gato extends Animal implements Runnable {

    public Gato(String nom, Comedor c) {
        super(nom, c);
    }

    @Override
    public boolean isGato() {
        return true;
    }

    @Override
    public void run() {
        while (true) {
            comedor.turnoGato(nombre);
            this.descansar();
        }
    }
}
