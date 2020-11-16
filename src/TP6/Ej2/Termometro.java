package TP6.Ej2v2;

public class Termometro extends Hilo {
    private int temperatura;
    private int variacionTemp;

    public Termometro(Salon salon, int temp, int var) {
        super(salon);
        temperatura = temp;
        variacionTemp = var;
    }

    @Override
    public void run() {
        while (true) {
            cambiarTemp();
            salon.notificarTemperatura(temperatura);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {               
                e.printStackTrace();
            }
        }
    }


private void cambiarTemp(){
    double signo = Math.random();
   // System.out.println(signo);
    int cant=(int)Math.random()*variacionTemp+1;
    if(signo<0.5){
        temperatura += cant;
    }else{
        temperatura -= cant;
    }

}

}
