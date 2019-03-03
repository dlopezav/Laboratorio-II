package Almacen;

import java.util.ArrayList;

/**
 *
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ArrayIndexOutOfBoundsException {
        GUI interfaz = new GUI(args);
        Thread ventanaInterfaz = new Thread(interfaz);
        ventanaInterfaz.start();

        Empleado empleado = new Empleado("", 1);
        Bodega compania = new Bodega(empleado);

        for (RobotOrganizador r : compania.getRobotsOrganizadores()) {
            r.setRobots(compania.getRobotsOrganizadores());
        }

        Thread[] hilos = new Thread[compania.getRobotsOrganizadores().length];
        for (int i = 0; i < compania.getRobotsOrganizadores().length; i++) {
            if (i != 9 && i!=4 && i!=3 && i!=7) {
               continue;
            }
            hilos[i] = new Thread(compania.getRobotsOrganizadores()[i]);
            hilos[i].start();
            //boolean empacarPedido = empleado.empacarPedido(new Pedido(new Cliente("José", "Desaparecido", 1), new Producto("Sopa do macaco", 999999)), 1);
        }       
        
    }
}
