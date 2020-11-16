package TeoriaConcV2.FilosofosTenedorInd;

public class FilosofoTest {
    public static void main(String[] args){
        int cantFilosofos = 5;
        Tenedor[] tenedor = new Tenedor[cantFilosofos];
        Thread[] filosofo = new Thread[cantFilosofos];

        for(int i =0; i<cantFilosofos; i++){
            tenedor[i] = new Tenedor();
        }

        for(int i =0; i<cantFilosofos; i++){
            if(i%2==0){
                filosofo[i] = new Thread(new Filosofo("Filosofo"+i, tenedor[(cantFilosofos-1+i)%cantFilosofos],tenedor[i%cantFilosofos], true));
            }else{
                filosofo[i] = new Thread(new Filosofo("Filosofo"+i, tenedor[(cantFilosofos-1+i)%cantFilosofos],tenedor[i%cantFilosofos], false));
            }
        filosofo[i].start();
        }
    }
}
