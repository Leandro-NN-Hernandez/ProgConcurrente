package TeoriaConcV2.JefeSaludoSinEspera;

public class TestSaludo {
    public static void main(String argv[]) {
        String[] nombresEmpleados = { "Pablo", "Luis", "Andrea", "Pedro", "Paula" };


        Saludo hola = new Saludo(5);

        Thread[] elPersonal = new Thread[6];
        elPersonal[0] = new Thread(new Personal(hola, "JEFE", 5));

        for (int i = 1; i < 6; i++) {
            elPersonal[i] = new Thread(new Personal(hola, nombresEmpleados[i - 1]));
        }

        for (int i = 1; i < 6; i++) {
            elPersonal[i].start();
        }    
        
        elPersonal[0].start();

        hola.aTrabajar();
    }
}
