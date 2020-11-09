package TeoriaConcV2.BufferIlimitado;

public class Test {
    public static void main(String[] args){
        int cantC = 7, cantP = 1;

        Bufer buffer = new Bufer();

        Thread[] consumidor = new Thread[cantC];
        Thread[] productor = new Thread[cantP];

        for(int i =0; i<cantP; i++){
            productor[i]= new Thread(new Productor("PRODUCTOR "+i, buffer));
            productor[i].start();            
        }
    
        for(int i =0; i<cantC; i++){
            consumidor[i]= new Thread(new Consumidor("CONSUMIDOR "+i, buffer));
            consumidor[i].start();            
        }

    }
}
