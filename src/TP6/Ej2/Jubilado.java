package TP6.Ej2;

public class Jubilado extends Persona {

    public Jubilado(Salon s, String name) {
        super(s, name);        
    }

    @Override
    public void run(){
        while (true) {
            salon.entrarSalaJubilado(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {               
                e.printStackTrace();
            }
            salon.salirSala(name);
        }


    }
    
}
