package TP5.Ejercicio4;

public class Avion implements Runnable{
    private final String nombre;
    private final Pista pista;

    public Avion(String nom, Pista p){
        nombre = nom;
        pista = p;
    }

    public void run(){
        for(int i=0; i<3; i++){
        System.out.println(nombre+" esta VOLANDO.");
        pista.aterrizar(nombre);
        pista.espera(nombre);
        pista.despegar(nombre);
    }
    }
}