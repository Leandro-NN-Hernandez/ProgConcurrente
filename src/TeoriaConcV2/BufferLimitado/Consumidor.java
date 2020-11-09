package TeoriaConcV2.BufferLimitado;

public class Consumidor extends Persona implements Runnable{
    
    public Consumidor(String nom, BuferLim buf) {
        super(nom, buf);
    }

    public boolean isConsumidor(){
        return true;
    }

    public void run(){
        while(true){
            buffer.consumir(nombre);
        } 
    }
}
