/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

/**
 *
 * @author Barba
 */
public class Main {
    
    public static void main(String[] args) {
        Taxi taxi= new Taxi();
        Pasajero pas= new Pasajero(taxi);
        Taxista taxista= new Taxista(taxi);
        
        Thread hiloTaxista = new Thread(taxista);
        Thread hiloPasajero = new Thread(pas);
        
        hiloPasajero.start();
        hiloTaxista.start();
        
        
    }
    
    
}
