package TP5.Ejercicio4;

public class Test {
    public static void main(String[] args){
        int cantAviones = 15, cantAterrisajes = 10; 
        Pista pista = new Pista(cantAterrisajes);
        Thread[] avion = new Thread[cantAviones];
        for(int i=0; i<cantAviones; i++){
            avion[i] = new Thread(new Avion("Avion "+i, pista));
            avion[i].start();
        }
    }
}
