package Almacen;

import becker.robots.Direction;
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
    private boolean ocupado;

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.ocupado = false;
        //this.computador = new Computador(new Sistema(robots, estantesBodega));
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
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


    public boolean empacarPedido(Pedido pedido, int a) {
        this.robot.move();
        this.robot.putThing();
        this.robot.turnLeft();
        this.robot.turnLeft();
        this.robot.move();
        this.robot.turnLeft();
        this.robot.turnLeft();
        return this.computador.getSistema().empacarPedido(pedido, a);
    }

    public boolean ponerProducto(Producto producto) throws InterruptedException {
        this.robot.move();
        this.robot.pickThing();
        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }
        this.robot.move();
        while (this.robot.getDirection() != Direction.NORTH) {
            this.robot.turnLeft();
        }
        this.robot.setLabel("PUTTING");
        //Falta            

        Thread.sleep((long) (1000 / this.robot.getSpeed()));
        this.robot.setLabel("");
        this.robot.move();
        this.robot.putThing();
        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }
        this.robot.move();
        while (this.robot.getDirection() != Direction.NORTH) {
            this.robot.turnLeft();
        }

        this.setOcupado(false);
        return true;
    }

}
