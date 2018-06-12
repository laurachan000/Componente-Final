/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

/**
 *
 * @author chan oliva
 */
public class Hilo implements Runnable {

    public Hilo() {
    }

    @Override
     public void run() {
        // Código del hilo
        System.out.println("Hilo ejecutado perfectamente");
    }
    
}
