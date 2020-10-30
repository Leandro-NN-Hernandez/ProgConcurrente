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
public class Perro extends Animal implements Runnable{
    
    public Perro(String nom,Comedor c){
        super(nom, c);
    }
    
    @Override
    public boolean isPerro(){
        return true;
    }

    @Override
    public void run() {
        while(true){
            comedor.turnoPerro(nombre);
            this.descansar();
        }
    }
    
    
}
