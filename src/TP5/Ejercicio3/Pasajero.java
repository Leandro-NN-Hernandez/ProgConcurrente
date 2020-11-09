package TP5.Ejercicio3;

public class Pasajero implements Runnable{
    private final Vendedor vendedor;
    private final String nombre;

    public Pasajero(String nom, Vendedor v){
        vendedor = v;        
        nombre = nom;          
    }

    public void run(){
            vendedor.hacerCola(nombre);
            vendedor.comprarTicket(nombre);
            vendedor.salirCola(nombre);
            vendedor.subirTren(nombre);
    }   
}