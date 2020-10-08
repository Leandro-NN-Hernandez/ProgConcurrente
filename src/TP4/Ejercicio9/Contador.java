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
public class Contador {
    //Clase para llevar la contabilidad de los pasajeros restantes
    private int cant;

    public Contador(int c) {
        cant = c;
    }

    public synchronized boolean cantMayorZero() {
        return cant > 0;
    }

    public synchronized int getCant() {
        return cant;
    }
    
    public synchronized void disminuir(){
        cant--;
    }
    
  
}
