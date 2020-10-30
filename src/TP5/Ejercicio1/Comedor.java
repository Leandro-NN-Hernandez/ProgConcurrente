/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP5.Ejercicio1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Hernandez
 */
public class Comedor {

    private Contador cont;
    private Semaphore semComedor;
    private boolean turno;

    public Comedor(int cantAnimales) {
        cont = new Contador(0, cantAnimales);
        semComedor = new Semaphore(cantAnimales * 2);
        turno = false;
    }

    public void turnoPerro(String nom) {
        if (!turno) {
            try {
                semComedor.acquire(2);
                cont.aumentar();
                System.out.println(nom + " INGRESA al comedor.");
                System.out.println(nom + " COME.");
                Thread.sleep(500);
                System.out.println(nom + " DEJA de comer.");
                if (cont.isMAX()) {
                    turno = true;
                }
                semComedor.release(2);

            } catch (InterruptedException ex) {
                Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void turnoGato(String nom) {
        if (turno) {
            try {
                semComedor.acquire(1);
                cont.disminuir();
                System.out.println(nom + " INGRESA al comedor.");
                System.out.println(nom + " COME.");
                Thread.sleep(500);
                System.out.println(nom + " DEJA de comer.");
                if (cont.isZero()) {
                    turno = false;
                }
                semComedor.release(1);

            } catch (InterruptedException ex) {
                Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
