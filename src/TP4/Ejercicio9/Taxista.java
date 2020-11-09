/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ejercicio9;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Leandro Hernandez
 */
public class Taxista implements Runnable {

    private final Taxi taxi;
    private final String nombre;

    public Taxista(Semaphore semTaxista, Taxi taxi, String nombre) {
        this.taxi = taxi;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        //Inicia el taxista durmiendo
        System.out.println(nombre + " esta durmiendo.");
        while (taxi.cantMayorZero()) {
            
            taxi.moverse(nombre);
            System.out.println(nombre + " esta durmiendo por: " + taxi.getCant());
        }

    }
}
