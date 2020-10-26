/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeoriaConcurrente;

/**
 *
 * @author Leandro Hernandez
 */
public class Test {

    public static void main(String[] args) {
        int cantP = 5, cantC = 5;
        Buffer buffer = new Buffer();
        Thread[] productor = new Thread[cantP];
        Thread[] consumidor = new Thread[cantC];

        for (int i = 0; i < cantP; i++) {
            productor[i] = new Thread(new Productor(i, buffer));
        }

        for (int i = 0; i < cantC; i++) {
            consumidor[i] = new Thread(new Consumidor(i, buffer));
        }

        for (int i = 0; i < cantP; i++) {
            productor[i].start();
        }

        for (int i = 0; i < cantC; i++) {
            consumidor[i].start();
        }
    }
}
