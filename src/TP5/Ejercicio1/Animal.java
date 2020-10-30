/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Hernandez
 */
public abstract class Animal {
    
    protected String nombre;
    protected Comedor comedor;
    
    public Animal(String nom, Comedor c) {
        nombre = nom;
        comedor = c;
    }
    
    public boolean isGato() {
        return false;
    }
    
    public boolean isPerro() {
        return false;
    }
    
    public void descansar() {
        //System.out.println(nombre + " DUERME.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
