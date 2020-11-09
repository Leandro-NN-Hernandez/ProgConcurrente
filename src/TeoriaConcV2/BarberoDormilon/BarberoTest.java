package TeoriaConcV2.BarberoDormilon;

public class BarberoTest {

    public static void main(String[] args){
        int cantLugares = 5, cantC = 7;
        Barberia b = new Barberia(cantLugares);
        Thread[] cliente = new Thread[cantC];
        Thread barbero = new Thread(new Barbero(b));
        barbero.start();
    
        for(int i=0; i<cantC; i++){
            cliente[i] = new Thread(new Cliente(b, "Cliente "+i));
            cliente[i].start();
        }
    }
    
}
