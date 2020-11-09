package TeoriaConcV2.BufferIlimitado;

public class Productor extends Persona implements Runnable{
    

    public Productor(String nom, Bufer buf) {
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
