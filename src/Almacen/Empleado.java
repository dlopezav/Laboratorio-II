
package Almacen;

import becker.robots.Robot;


/**
 * 
 * @version 1.0
 */
public class Empleado {
    private String nombre;
    private int id;
    private Robot robot;
    private Computador computador;

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }
    
    public boolean guardarProductos(Producto[] productos){
        return this.computador.getSistema().almacenarProductos(productos);
    }
    
    public boolean empacarPedido(Pedido pedido, int a){
        this.robot.move();
        this.robot.putThing();
        this.robot.turnLeft();
        this.robot.turnLeft();
        this.robot.move();
        this.robot.turnLeft();
        this.robot.turnLeft();
        return this.computador.getSistema().empacarPedido(pedido, a);
    }

}
