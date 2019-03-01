
package Almacen;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @version 1.0
 */
public class Main{
    public static void main(String[] args) {
        GUI interfaz = new GUI(args);
        Thread ventanaInterfaz = new Thread(interfaz);
        ventanaInterfaz.start();
        
        Empleado empleado = new Empleado("",1);
        Bodega compania = new Bodega(empleado);
        
            Thread[] hilos = new Thread[20];
        for(int i=0;i<compania.getRobotsOrganizadores().length;i++){
            hilos[i]= new Thread(compania.getRobotsOrganizadores()[i]);
            hilos[i].start();
        }
        
    }

    
}
