/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ejercicio9;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Hernandez
 */
public class Taxi {

    private final Semaphore semSalida;
    private final Semaphore semTaxista;
    private final Semaphore semTaxi;

    public Taxi(Semaphore sem, Semaphore semT, Semaphore semS) {
        semTaxi = sem;
        semTaxista = semT;
        semSalida = semS;
    }

    public void subirseTaxi(String nombre) {
        try {
            semTaxi.acquire();
            System.out.println(nombre + " se subio al taxi.");
            avisarTaxista();
        } catch (InterruptedException ie) {
        }
    }

    private void avisarTaxista() {
        semTaxista.release();

    }

    public void bajarseTaxi(String nombre) {
        
        try {            
            semSalida.acquire();
            System.out.println(nombre + " llego a destino.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre + " se bajo del taxi.");
        semTaxi.release();
    }

    public void moverse(String nombre) {
        try {
            semTaxista.acquire();
            System.out.println(nombre + " esta manejando el taxi");
            Thread.sleep(1000L);
            System.out.println(nombre + " llego a destino.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        semSalida.release();
    }

}
