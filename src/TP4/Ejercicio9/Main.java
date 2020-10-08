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
public class Main {

    public static void main(String[] args) {
        int cantP = 10;
        Semaphore semTaxi = new Semaphore(1);
        Semaphore semTaxista = new Semaphore(0);
        Semaphore semSalida = new Semaphore(0);

        Taxi taxi = new Taxi(semTaxi, semTaxista, semSalida, new Contador(cantP));
        Taxista taxista = new Taxista(semTaxista, taxi, "TAXISTA");
        Thread pasajeros[] = new Thread[cantP];
        for (int i = 0; i < pasajeros.length; i++) {
            //Se generan una cantidad de hilos pasajeros igual a canP
            pasajeros[i] = new Thread(new Pasajero(taxi, ("PASAJERO-" + i)));
        }
        Thread hiloTaxista = new Thread(taxista);

        hiloTaxista.start();
        for (Thread pasajero : pasajeros) {
            pasajero.start();
        }
    }
}
