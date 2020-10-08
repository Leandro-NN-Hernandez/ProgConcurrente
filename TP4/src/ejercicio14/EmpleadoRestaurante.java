/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14;

/**
 *
 * @author Barba
 */
public abstract class EmpleadoRestaurante implements Runnable {
    public Servicio service;
    public int cont;
    
    public EmpleadoRestaurante(Servicio serv){
        this.service=serv;
    }
    public void setContador(int cant){
        this.cont=cant;
    }

    
    
}
