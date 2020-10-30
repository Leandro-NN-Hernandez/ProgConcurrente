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
public class Contador {

    //Clase para llevar la contabilidad de algunas cosas;
    private int cant;
    private final int MAX;

    public Contador(int c, int m) {
        cant = c;
        MAX = m;
    }

    public synchronized boolean cantMayorZero() {
        //Verifica que contador sea mayor a 0
        return cant > 0;
    }

    public synchronized boolean cantMenorMAX() {
        //Verifica que contador sea mayor a 0
        return cant < MAX;
    }

    public synchronized boolean isMAX() {
        //Verifica que contador sea mayor a 0
        return cant == MAX;
    }

    public synchronized boolean isZero() {
        //Verifica que contador sea mayor a 0
        return cant == 0;
    }

    public synchronized void disminuir() {
        //Disminuye el contador
        if (cant > 0) {
            cant--;
        }
    }

    public synchronized void aumentar() {
        //Aumenta el contador
        if (cant < MAX) {
            cant++;
        }
    }

}
