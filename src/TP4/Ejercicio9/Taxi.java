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

    private Contador cant;
    private final Semaphore semSalida;
    private final Semaphore semTaxista;
    private final Semaphore semTaxi;

    public Taxi(Semaphore sem, Semaphore semT, Semaphore semS, Contador c) {
        semTaxi = sem;
        semTaxista = semT;
        semSalida = semS;
        cant = c;
    }

    public void subirseTaxi(String nombre) {
        //El pasajero se sube al taxi, y avisa al taxista
        try {
            semTaxi.acquire();
            System.out.println(nombre + " se subio al taxi.");
            avisarTaxista();
        } catch (InterruptedException ie) {
        }
    }

    private void avisarTaxista() {
        //Se despierta el taxista
        semTaxista.release();

    }

    public void bajarseTaxi(String nombre) {
        //LLegado al destino, el pasajero se baja
        try {
            semSalida.acquire();
            System.out.println(nombre + " llego a destino.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre + " se bajo del taxi.");
        // Se disminuye la cantidad de pasajeros restantes
        cant.disminuir();
        semTaxi.release();
    }

    public void moverse(String nombre) {
        //El taxista se levanta y maneja a destino
        try {
            semTaxista.acquire();
            System.out.println(nombre + " esta manejando el taxi");
            Thread.sleep(1000L);
            System.out.println(nombre + " llego a destino.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxi.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Avisa a pasajero que llego
        semSalida.release();
    }

    public boolean cantMayorZero() {
        //le pregunta si hay pasajeros por subir
        return cant.cantMayorZero();
    }
    
    public int getCant(){
        //consigue la cantidad de pasajeros restantes
        return cant.getCant();
    }

}
