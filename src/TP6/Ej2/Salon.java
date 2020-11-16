package TP6.Ej2v2;

public class Salon {
    // Variables constantes
    private final int MAXPERSONAS;
    private final int MAXIMOPORUMBRAL;
    private final int TUmbral;

    // Variables contadoras
    private int limitePersonasActual;
    private int cantPersonas;
    private int cantJubiladosEsperando;

    public Salon(int maxPersona, int maxUmbral, int tUmbral) {
        MAXPERSONAS = maxPersona;
        MAXIMOPORUMBRAL = maxUmbral;
        TUmbral = tUmbral;
        limitePersonasActual = maxPersona;
        cantPersonas = 0;
        cantJubiladosEsperando = 0;
    }

    public synchronized void entrarSala(String name) {
        while (limitePersonasActual <= cantPersonas && cantJubiladosEsperando > 0) {
            try {
                wait();
            } catch (InterruptedException e) {               
                e.printStackTrace();
            }
       }
        cantPersonas++;
        System.out.println("----------------- "+name+" ENTRO A LA SALA. HAY:"+cantPersonas);
    }

    public synchronized void entrarSalaJubilado(String name){
        cantJubiladosEsperando++;
        while (limitePersonasActual <= cantPersonas) {
            try {
                wait();
            } catch (InterruptedException e) {               
                e.printStackTrace();
            }
       }
        cantPersonas++;
        cantJubiladosEsperando--;
        System.out.println("----------------- "+name+" ENTRO A LA SALA. HAY:"+cantPersonas);
    }

    public synchronized void salirSala(String name){
        cantPersonas--;
        System.out.println(name+" SALIO DE LA SALA -----------------");
        System.out.println("QUEDAN
        : "+ cantPersonas);
        notifyAll();
    }

    public synchronized void notificarTemperatura(int temperatura){
        System.out.println("TEMPERATURA: "+ temperatura);
        if(temperatura<TUmbral) {
            limitePersonasActual = MAXPERSONAS;
        }else{
            limitePersonasActual = MAXIMOPORUMBRAL;
        }  
        notifyAll();   
    }


 }