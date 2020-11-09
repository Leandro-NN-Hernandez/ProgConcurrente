package TP5.Ejercicio3;

public class Tren implements Runnable{
    private int lugares;
    private Vendedor vendedor;

    public Tren(int cant, Vendedor v){
        lugares = cant;
        vendedor = v;
    }

    public void run(){
        int i =0;
        while(i<10){
            vendedor.parteTren(lugares);
            vendedor.llegaTren(lugares);
            i++;
        }
    }
    
}
