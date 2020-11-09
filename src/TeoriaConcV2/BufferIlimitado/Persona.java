package TeoriaConcV2.BufferIlimitado;

public class Persona {
    protected Bufer buffer;
    protected String nombre;

    public Persona(String nom, Bufer buf) {
        nombre = nom;
        buffer = buf;
    }
    
    public boolean isConsumidor(){
        return false;
    }

    public boolean isProductor(){
        return false;
    }
}
