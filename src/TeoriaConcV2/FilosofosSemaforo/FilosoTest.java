package TeoriaConcV2.FilosofosSemaforo;

public class FilosoTest {
    public static void main(String[] args){
        int cantFilosofos = 5;
        Mesa mesa = new Mesa(cantFilosofos);
        Thread[] filosofo = new Thread[cantFilosofos];

        for(int i=0; i<cantFilosofos; i++){
            filosofo[i] = new Thread(new Filosofo("Filosofo "+i, mesa));
            filosofo[i].start();
        }
    }
}
