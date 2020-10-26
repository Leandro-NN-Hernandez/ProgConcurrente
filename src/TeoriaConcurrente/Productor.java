/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeoriaConcurrente;

/**
 *
 * @author Leandro Hernandez
 */
public class Productor extends Persona implements Runnable {
    
    
    public Productor(int nom, Buffer buf){
        super(nom, buf);
    }
    
    @Override
    public void run() {
       while(true){
           buffer.agregarElemento(nombre);
       }
    }

}
