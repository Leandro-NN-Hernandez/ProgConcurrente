package TP6.Ej2;

public abstract class Hilo implements Runnable{    
    protected Salon salon;

    public Hilo(Salon s){
        salon = s;
    }


}
