/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeoriaConcurrente;

/**
 *
 * @author Barba
 */
public class Persona {
    protected Buffer buffer;
    protected int nombre;

    public Persona(int nom, Buffer buf) {
        nombre = nom;
        buffer = buf;
    }
    
}
