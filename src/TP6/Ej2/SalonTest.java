package TP6.Ej2v2;

public class SalonTest {
    public static void main(String[] args){
        //Variables numeradas
        int cantMax = 10, cantMaxTemp = 5, tempMax = 30, temperaturaAmbiente=27, varMax = 8;
        int cantP = 7, cantJ = 5;
        //Recurso compartido
        Salon salon = new Salon(cantMax, cantMaxTemp, tempMax);
        //Hilos
        Thread termometro = new Thread(new Termometro(salon, temperaturaAmbiente, varMax));
        Thread[] jubilado = new Thread[cantJ];
        Thread[] persona = new Thread[cantP];

        //inicializacion de hilos
        termometro.start();
        
        for(int i=0; i<cantJ; i++){
            jubilado[i]= new Thread(new Jubilado(salon, "Jubilado "+i));
            jubilado[i].start();
        }
        for(int i=0; i<cantJ; i++){
            persona[i]= new Thread(new Persona(salon, "Persona "+i));
            persona[i].start();
        }
    }
}
