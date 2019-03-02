
package Almacen;

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
        
        
        for(RobotOrganizador r:compania.getRobotsOrganizadores()){
            r.setRobots(compania.getRobotsOrganizadores());
        }
        
        Thread[] hilos = new Thread[compania.getRobotsOrganizadores().length];
        for(int i=0;i<compania.getRobotsOrganizadores().length;i++){
            hilos[i]= new Thread(compania.getRobotsOrganizadores()[i]);
            hilos[i].start();
        }
        for(;;){
            for(int i=0;i<10;i++){
                System.out.println("Robot :"+compania.getRobotsOrganizadores()[i].getCodigo()+" En posición "+compania.getRobotsOrganizadores()[i].getRobot().getAvenue()+":"+compania.getRobotsOrganizadores()[i].getRobot().getStreet());
            }
        }
    }

    
}
