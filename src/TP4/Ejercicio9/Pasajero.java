/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP4.Ejercicio9;

/**
 *
 * @author Leandro Hernandez
 */
public class Pasajero implements Runnable {
    
    private final Taxi taxi;
    private final String nombre;
    
    public Pasajero(Taxi taxi, String nombre) {
        this.taxi = taxi;
        this.nombre = nombre;
    }
       
    @Override
    public void run() {
        //Camina mientras espera el taxi
        caminar();
        //Trata de subirse
        taxi.subirseTaxi(nombre);
        //una vez terminado el recorrido se baja
        taxi.bajarseTaxi(nombre);
    }
    
    private void caminar() {
        System.out.println(nombre + " esta caminando.");
        
    }
}
