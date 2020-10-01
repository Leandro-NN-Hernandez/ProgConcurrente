package TP4.Ejercicio8B;

public class Atleta implements Runnable {
    private Testigo testigo;
    private String nombre;

    public Atleta(String nom, Testigo test) {
        nombre = nom;
        testigo = test;
    }

    @Override
    public void run() {
        esperarTestigo();
        correr();
    }

    private void correr() {
        try {
            long start = System.currentTimeMillis();     
            testigo.agarrar(nombre);
            Thread.sleep((long) (((Math.random() * 3 )+ 9))*1000);
            testigo.entrega(nombre, start);
        } catch (InterruptedException ie) {
        }
    }

    private void esperarTestigo() {
        System.out.println(nombre + " espera testigo");
    }

}