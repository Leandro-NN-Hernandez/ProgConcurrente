package TeoriaConcV2.JefeSaludoMejorado;

public class TestSaludo {
    public static void main(String argv[]) {
        String[] nombresEmpleados = { "Pablo", "Luis", "Andrea", "Pedro", "Paula" };
        int cantSaludos = nombresEmpleados.length, cantPersonas = cantSaludos + 1;

        Saludo hola = new Saludo(cantSaludos);

        Thread[] elPersonal = new Thread[cantPersonas];
        elPersonal[0] = new Thread(new Jefe(hola, "JEFE", cantSaludos));

        for (int i = 1; i < cantPersonas; i++) {
            elPersonal[i] = new Thread(new Personal(hola, nombresEmpleados[i - 1]));
        }

        for (int i = 1; i < cantPersonas; i++) {
            elPersonal[i].start();
        }    
            elPersonal[0].start();
        hola.aTrabajar();
    }
}
