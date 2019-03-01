
package Almacen;

import becker.robots.*;
import java.awt.Color;

/**
 * 
 * @version 1.0
 */
public class Bodega {
    private City espacio;
    private Estante[] estantes;
    private RobotOrganizador[] robotsOrganizadores;
    private Empleado encargado;

    public Bodega(Empleado encargado) {
        this.espacio = new City();
        // Estantes
        String label = "";
        int cont = 0;
        Color color = new Color(83, 87, 115);
        this.estantes = new Estante[20];
        Thing[] things = new Thing[this.estantes.length];
        for (int i = 0; i < this.estantes.length/4; i++) {
            for (int j = 0; j < this.estantes.length/5; j++) {
            label = "Est" + (cont + 1);
            things[cont] = new Thing(this.espacio, (3+i), (j+1));
            things[cont].getIcon().setColor(color);
            things[cont].getIcon().setLabel(label);
            cont++;
            }
        }
        for (int i = 0; i < this.estantes.length; i++) {
            this.estantes[i] = new Estante(i+1, things[i]);
        }
        
        
        
        this.encargado = encargado;
        Robot e = new Robot(espacio, 9, 10, Direction.NORTH);
        e.setLabel(this.encargado.getNombre());
        this.encargado.setRobot(e);
 
        // Cajas empleado
        Thing[] empaques = new Thing[20];
        for (int i = 0; i < empaques.length; i++) {
            empaques[i] = new Thing(this.encargado.getRobot());
        }
        
        this.robotsOrganizadores = new RobotOrganizador[10];
        //Zona de parqueo
        for (int i = 0; i < this.robotsOrganizadores.length; i++) {
            Wall wall = new Wall(espacio, 1, (i+1), Direction.NORTH);
        }
        for (int i = 0; i < this.robotsOrganizadores.length; i++) {
            Wall wall = new Wall(espacio, 1, (i+1), Direction.WEST);
            Wall wall2 = new Wall(espacio, 1, (i+1), Direction.EAST);
        }
        
        // Robots organizadores
        String label2;
        Color colorR = new Color(255, 131, 28);
        for (int i = 0; i < this.robotsOrganizadores.length; i++) {
            label2 = "R" + (i+1);
            Robot robot = new Robot(espacio, 1, (i+1), Direction.SOUTH);
            robot.setLabel(label2);
            robot.setColor(colorR);
            this.robotsOrganizadores[i] = new RobotOrganizador(i+1, robot);
        }
        // Zona empleado
        Wall wallE = new Wall(espacio, 9, 9, Direction.WEST);
        wallE = new Wall(espacio, 9, 9, Direction.NORTH);
        wallE = new Wall(espacio, 9, 10, Direction.SOUTH);
        wallE = new Wall(espacio, 9, 9, Direction.SOUTH);
        
        
        
        //Zona envio
        Wall wallZE = new Wall(espacio, 3, 12, Direction.NORTH);
        for (int i = 0; i < 4; i++) {
            wallZE = new Wall(espacio, (4+i), 12, Direction.EAST);
        }
        for (int i = 0; i < 4; i++) {
            wallZE = new Wall(espacio, (3+i), 12, Direction.WEST);
        }
        wallZE = new Wall(espacio, 7, 12, Direction.SOUTH);
        //Thing y = new Thing(espacio, 3, 12);
    }
    
    public void thingPC(){
        //Computador empleado
        Thing pc = new Thing(espacio, 9, 9);
        pc.getIcon().setLabel("PC");
        pc.getIcon().setColor(Color.GRAY);
        this.encargado.getComputador().setPc(pc);
        //this.encargado.getComputador().setPc(pc);
    }

    public Estante[] getEstantes() {
        return estantes;
    }

    public RobotOrganizador[] getRobotsOrganizadores() {
        return robotsOrganizadores;
    }

    public City getEspacio() {
        return espacio;
    }

    public void setEspacio(City espacio) {
        this.espacio = espacio;
    }

    public Empleado getEncargado() {
        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }

    public void setEstantes(Estante[] estantes) {
        this.estantes = estantes;
    }

    public void setRobotsOrganizadores(RobotOrganizador[] robotsOrganizadores) {
        this.robotsOrganizadores = robotsOrganizadores;
    }
    
    public void setElementoEstante(Estante e, int i){
        this.estantes[i]=e;
    }
    
    public void setProducto(Producto p){
        for (int i = 0; i < 20; i++) {
            if(this.estantes[i]==null){
                this.estantes[i].setProducto(p);
                return;
            }
        }
    }
  
}
