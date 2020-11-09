package TeoriaConcV2.BarberoDormilon;

public class Barbero extends Persona implements Runnable{

    public Barbero(Barberia b) {
        super(b);
     }
    
     public void run(){
         while(true){
            barberia.descansarBarbero();}
     }
}
