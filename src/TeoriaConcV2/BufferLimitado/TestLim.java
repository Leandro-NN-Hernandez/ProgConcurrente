package TeoriaConcV2.BufferLimitado;

public class TestLim {
    public static void main(String[] args){
        int cantidadPermisos = 3, cantC = 7, cantP = 3;

        BuferLim buffer = new BuferLim(cantidadPermisos);

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
