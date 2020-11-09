package TP5.Ejercicio3;

public class Test {
    private static final int cantLugares = 2;

    public static void main(String[] args) {
        int cantP = cantLugares * 8;
        Vendedor vendedor = new Vendedor(cantLugares);
        Thread tren = new Thread(new Tren(cantLugares, vendedor));
        Thread[] pasajero = new Thread[cantP];
        tren.start();
        for (int i = 0; i < cantP; i++) {
            pasajero[i] = new Thread(new Pasajero("Pasajero" + i, vendedor));
            pasajero[i].start();
        }        
    }
}
