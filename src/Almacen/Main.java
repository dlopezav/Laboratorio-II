
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
            //if(i!=1 && i!=9 && i!=5) continue;
            hilos[i]= new Thread(compania.getRobotsOrganizadores()[i]);
            hilos[i].start();
        }
        
        for(;;){
            for (RobotOrganizador robotsOrganizadore : compania.getRobotsOrganizadores()) {
                if (robotsOrganizadore.FrenteLimpio() && robotsOrganizadore.isSuspender()) {
                    robotsOrganizadore.reanudar();
                    System.out.println("prueba");
                }
                if (!robotsOrganizadore.FrenteLimpio()) {
                    robotsOrganizadore.suspender();
                    System.out.println("prueba2");
                }
            }
        }
        
        
    }
}
