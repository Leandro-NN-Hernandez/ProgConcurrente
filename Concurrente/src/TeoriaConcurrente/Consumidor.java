/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeoriaConcurrente;

/**
 *
 * @author Barba
 */
public class Consumidor extends Persona implements Runnable{   
   
    public Consumidor(int nom, Buffer buf){
        super(nom, buf);
    }
    
    @Override
    public void run() {
        while(true){
             buffer.ingresarBuffer(nombre);
           buffer.quitarElemento(nombre);
       }
    }
}
