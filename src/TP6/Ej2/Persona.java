package TP6.Ej2v2;

public class Persona extends Hilo {

    protected final String name;

    public Persona(Salon s, String name) {
        super(s);
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            salon.entrarSala(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {               
                e.printStackTrace();
            }
            salon.salirSala(name);
        }

    }
    
}
