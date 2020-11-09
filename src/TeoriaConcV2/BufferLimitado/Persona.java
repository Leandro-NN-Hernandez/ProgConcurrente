package TeoriaConcV2.BufferLimitado;

public class Persona {
    protected BuferLim buffer;
    protected String nombre;

    public Persona(String nom, BuferLim buf) {
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
