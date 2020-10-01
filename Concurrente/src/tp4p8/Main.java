/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4p8;

/**
 *
 * @author Barba
 */
public class Main {
    public static void main(String[] args) {
        Testigo tes1= new Testigo();
        Testigo tes2= new Testigo();
        Corredor cor1= new Corredor("Corredor1",tes1);
        Corredor cor2= new Corredor("Corredor2",tes2);
        Corredor cor3= new Corredor("Corredor3",tes1);
        Corredor cor4= new Corredor("Corredor4",tes2);
        
        Corredor equipopar[]={cor2,cor4};
        Corredor equipoimpar[]={cor1,cor3};
        
        for(int i=0; i<2;i++){
            equipopar[i].start();
            equipoimpar[i].start();
        }
        try{
            for(int i=0; i<2;i++){
            equipopar[i].join();
            equipoimpar[i].join();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        
        
    }
}
