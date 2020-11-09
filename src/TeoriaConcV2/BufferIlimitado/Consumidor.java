package TeoriaConcV2.BufferIlimitado;

public class Consumidor extends Persona implements Runnable{
    
    public Consumidor(String nom, Bufer buf) {
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
