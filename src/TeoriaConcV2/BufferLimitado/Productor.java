package TeoriaConcV2.BufferLimitado;
public class Productor extends Persona implements Runnable{
    

    public Productor(String nom, BuferLim buf) {
        super(nom, buf);
    }

    public boolean isProductor() {
        return true;
    }

    public void run(){
        while(true){            
            buffer.producir(nombre);
        } 
    }
}
