
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
        /*int opcion = 0;
        while(true){
            
            switch(opcion){
              
            }
            
        }*/
    }

    
}
