/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barba
 */
public class Hamster extends Thread {

    private int numero;
    private Actividad accion;
    private boolean hambre = true;
    private boolean ejercicio = true;
    private boolean sueño = true;

    public Hamster(int n, Actividad acc) {
        this.accion = acc;
        this.numero = n;
    }

    @Override
    public void run() {
        try {
            int i=0;
            while(i<3){
                if (this.hambre) {
                    this.hambre=this.accion.comer(numero);
                    if(!this.hambre)
                        i++;
                }
                if (this.ejercicio) {
                    this.ejercicio=this.accion.correr(numero);
                    if(!this.ejercicio)
                        i++;
                }
                if (this.sueño) {
                    this.sueño=this.accion.dormir(numero);
                    if(!this.sueño)
                        i++;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hamster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
