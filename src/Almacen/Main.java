package Almacen;

/**
 *
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ArrayIndexOutOfBoundsException {

        Empleado empleado = new Empleado("", 1);
        Bodega compania = new Bodega(empleado);

        GUI interfaz = new GUI(args, compania);
        Thread ventanaInterfaz = new Thread(interfaz);
        ventanaInterfaz.start();
          
    }
}
