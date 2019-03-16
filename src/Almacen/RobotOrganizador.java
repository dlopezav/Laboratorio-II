package Almacen;

import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @version 1.0
 */
public class RobotOrganizador implements Runnable {

    private int codigo;
    private Estante estanteAsignado;
    private Boolean ocupado;
    private final Robot robot;
    private RobotOrganizador[] robots;
    private boolean suspender;
    private final Empleado empleado;
    private String action;

    public RobotOrganizador(int codigo, Robot robot, Empleado empleado, RobotOrganizador[] robots) {
        this.codigo = codigo;
        this.robot = robot;
        this.ocupado = false;
        this.suspender = false;
        this.empleado = empleado;
        this.robots = robots;
        this.action = "";
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

    public boolean isSuspender() {
        return suspender;
    }

    public void setSuspender(boolean suspender) {
        this.suspender = suspender;
    }

    public RobotOrganizador[] getRobots() {
        return robots;
    }

    public void setRobots(RobotOrganizador[] robots) {
        this.robots = robots;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estante getEstanteAsignado() {
        return estanteAsignado;
    }

    public void setEstanteAsignado(Estante estanteAsignado) {
        this.estanteAsignado = estanteAsignado;
    }

    public Robot getRobot() {
        return robot;
    }

    public void transportarEstante(int num) throws InterruptedException {
        this.ocupado = true;
        while (this.estanteAsignado.getEstado()) {
            Thread.sleep(1);
        }
        this.estanteAsignado.setEstado(true);
        int r = this.codigo;
        int x = 0;
        int y = 0;

        while (!this.FrenteLimpio()) {
            Thread.yield();
        }
        this.robot.move();

        if (num >= 1 && num <= 4) {
            y = 3;
        } else if (num >= 5 && num <= 8) {
            y = 4;
        } else if (num >= 9 && num <= 12) {
            y = 5;
        } else if (num >= 13 && num <= 16) {
            y = 6;
        } else if (num >= 17 && num <= 20) {
            y = 7;
        }

        switch (num % 4) {
            case 1:
                x = 1;
                break;
            case 2:
                x = 2;
                break;
            case 3:
                x = 3;
                break;
            case 0:
                x = 4;
                break;
        }

        if (r < x) {
            this.robot.turnLeft();
            while (this.robot.getAvenue() != x) {
                while (!this.FrenteLimpio()) {
                    Thread.yield();
                }
                this.robot.move();
            }
        } else if (r > x) {
            this.robot.turnLeft();
            this.robot.turnLeft();
            this.robot.turnLeft();
            while (this.robot.getAvenue() != x) {
                while (!this.FrenteLimpio()) {
                    Thread.yield();
                }
                this.robot.move();
            }
        }

        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }

        while (this.robot.getStreet() != y) {
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
        }
        if (this.robot.canPickThing()) {
            this.robot.pickThing();
        }

        while (this.robot.getDirection() != Direction.EAST) {
            this.robot.turnLeft();
        }

        while (this.robot.getAvenue() != 10) {
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }

        while (this.robot.getStreet() != 8) {
            while (!this.FrenteLimpio()) {
                Thread.yield();
            }
            this.robot.move();
        }

        this.robot.putThing();

        this.empleado.setOcupado(true);

        this.robot.turnLeft();
        this.robot.turnLeft();
        this.robot.turnLeft();

        while (!this.FrenteLimpio()) {
            Thread.yield();
        }
        this.robot.move();
        this.robot.turnLeft();
        this.robot.turnLeft();
        this.ocupado = false;
    }

    public void volverAParquedero(int num) throws InterruptedException {
        this.ocupado = true;
        int r = this.codigo;
        int x = 0;
        int y = 0;
        if (num >= 1 && num <= 4) {
            y = 3;
        } else if (num >= 5 && num <= 8) {
            y = 4;
        } else if (num >= 9 && num <= 12) {
            y = 5;
        } else if (num >= 13 && num <= 16) {
            y = 6;
        } else if (num >= 17 && num <= 20) {
            y = 7;
        }
        switch (num % 4) {
            case 1:
                x = 1;
                break;
            case 2:
                x = 2;
                break;
            case 3:
                x = 3;
                break;
            case 0:
                x = 4;
                break;
        }
        while (!this.FrenteLimpio()) {
            Thread.sleep(1);
        }
        this.robot.move();
        if (this.robot.canPickThing()) {
            this.robot.pickThing();
        }
        while (!this.FrenteLimpio()) {
            Thread.sleep(1);
        }
        this.robot.move();
        while (this.robot.getDirection() != Direction.NORTH) {
            this.robot.turnLeft();
        }
        while (this.robot.getStreet() != y) {
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
        }
        while (this.robot.getDirection() != Direction.WEST) {
            this.robot.turnLeft();
        }
        while (this.robot.getAvenue() != x) {
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
        }
        this.robot.putThing();
        while (this.robot.getDirection() != Direction.NORTH) {
            this.robot.turnLeft();
        }
        while (this.robot.getStreet() != 2) {
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
        }

        if (r < x) {
            while (this.robot.getDirection() != Direction.WEST) {
                this.robot.turnLeft();
            }
            while (this.robot.getAvenue() != r) {
                while (!this.FrenteLimpio()) {
                    Thread.sleep(1);
                }
                this.robot.move();
            }

            while (this.robot.getDirection() != Direction.NORTH) {
                this.robot.turnLeft();
            }
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
            while (this.robot.getDirection() != Direction.NORTH) {
                this.robot.turnLeft();
            }
        } else if (r > x) {
            while (this.robot.getDirection() != Direction.EAST) {
                this.robot.turnLeft();
            }
            while (this.robot.getAvenue() != r) {
                while (!this.FrenteLimpio()) {
                    Thread.sleep(1);
                }
                this.robot.move();
            }
            this.robot.turnLeft();
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
            while (this.robot.getDirection() != Direction.NORTH) {
                this.robot.turnLeft();
            }
        } else if (r == x) {
            while (this.robot.getStreet() != 0) {

                while (!this.FrenteLimpio()) {
                    Thread.sleep(1);
                }
                this.robot.move();
            }
        }
        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }
        this.ocupado = false;
        this.estanteAsignado.setEstado(false);
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public void run() {

        switch (this.action) {
            case "LlevarEstante":
                try {
                    this.transportarEstante(this.estanteAsignado.getNumero());
                    this.empleado.ponerProducto();
                    this.volverAParquedero(this.estanteAsignado.getNumero());
                } catch (InterruptedException ex) {

                }
                break;
            case "LlevarEstanteProducto":
                try {
                    this.transportarEstante(this.estanteAsignado.getNumero());
                    this.empleado.TomarProductos();
                    this.volverAParquedero(this.estanteAsignado.getNumero());
                    this.empleado.DejarPedido();
                    this.LlevarPredido();
                } catch (InterruptedException ex) {

                }
                break;
        }

    }

    public boolean FrenteLimpio() {
        try {
            for (RobotOrganizador r : robots) {
                switch (this.robot.getDirection()) {
                    case NORTH:
                        if (this.robot.getAvenue() == r.getRobot().getAvenue() && this.robot.getStreet() - 1 == r.getRobot().getStreet()) {
                            return false;
                        }
                        break;
                    case EAST:
                        if (this.robot.getAvenue() + 1 == r.getRobot().getAvenue() && this.robot.getStreet() == r.getRobot().getStreet()) {
                            return false;
                        }
                        break;
                    case SOUTH:
                        if (this.robot.getAvenue() == r.getRobot().getAvenue() && this.robot.getStreet() + 1 == r.getRobot().getStreet()) {
                            return false;
                        }
                        break;
                    case WEST:
                        if (this.robot.getAvenue() - 1 == r.getRobot().getAvenue() && this.robot.getStreet() == r.getRobot().getStreet()) {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
                if (null != this.robot.getDirection()) {
                    switch (this.robot.getDirection()) {
                        case NORTH:
                            if (this.robot.getStreet() - 1 == r.getRobot().getStreet() && this.robot.getAvenue() - 1 == r.getRobot().getAvenue() && r.getRobot().getDirection() == Direction.EAST) {
                                return false;
                            } else if (this.robot.getStreet() - 1 == r.getRobot().getStreet() && this.robot.getAvenue() + 1 == r.getRobot().getAvenue() && r.getRobot().getDirection() == Direction.WEST) {
                                return false;
                            }
                            break;
                        case SOUTH:
                            if (this.robot.getStreet() + 1 == r.getRobot().getStreet() && this.robot.getAvenue() - 1 == r.getRobot().getAvenue() && r.getRobot().getDirection() == Direction.EAST) {
                                return false;
                            } else if (this.robot.getStreet() + 1 == r.getRobot().getStreet() && this.robot.getAvenue() + 1 == r.getRobot().getAvenue() && r.getRobot().getDirection() == Direction.WEST) {
                                return false;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            if (this.robot.getAvenue() == 10 && this.robot.getStreet() == 7 && this.empleado.isOcupado() && this.robot.getDirection() == Direction.SOUTH) {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }
        return true;
    }

    public void LlevarPredido() throws InterruptedException {
        this.ocupado = true;
        int r = this.codigo;

        while (!this.FrenteLimpio()) {
            Thread.yield();
        }
        this.robot.move();

        while (this.robot.getDirection() != Direction.EAST) {
            this.robot.turnLeft();
        }
        while (this.robot.getAvenue() != 10) {
            while (!this.FrenteLimpio()) {
                Thread.yield();
            }

            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }

        while (this.robot.getStreet() != 8) {
            while (!this.FrenteLimpio()) {
                Thread.yield();
            }
            this.robot.move();
        }

        if (this.robot.canPickThing()) {
            this.robot.pickThing();
        }

        while (this.robot.getDirection() != Direction.EAST) {
            this.robot.turnLeft();
        }

        while (this.robot.getAvenue() != 11) {
            while (!this.FrenteLimpio()) {
                Thread.sleep(1);
            }
            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.NORTH) {
            this.robot.turnLeft();
        }

        while (this.robot.getStreet() != 7) {
            while (!this.FrenteLimpio()) {
                Thread.yield();
            }
            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.EAST) {
            this.robot.turnLeft();
        }

        while (!this.FrenteLimpio()) {
            Thread.yield();
        }
        this.robot.move();

        if (!this.robot.canPickThing()) {
            this.robot.putThing();
        } else {
            while (this.robot.getDirection() != Direction.NORTH) {
                this.robot.turnLeft();
            }
            while (!this.FrenteLimpio()) {
                Thread.yield();
            }
            this.robot.move();

            if (!this.robot.canPickThing()) {
                this.robot.putThing();
            } else {
                while (this.robot.getDirection() != Direction.NORTH) {
                    this.robot.turnLeft();
                }
                while (!this.FrenteLimpio()) {
                    Thread.yield();
                }
                this.robot.move();

                if (!this.robot.canPickThing()) {
                    this.robot.putThing();
                } else {
                    while (this.robot.getDirection() != Direction.NORTH) {
                        this.robot.turnLeft();
                    }
                    while (!this.FrenteLimpio()) {
                        Thread.yield();
                    }
                    this.robot.move();

                    if (!this.robot.canPickThing()) {
                        this.robot.putThing();
                    } else {
                        while (this.robot.getDirection() != Direction.NORTH) {
                            this.robot.turnLeft();
                        }
                        while (!this.FrenteLimpio()) {
                            Thread.yield();
                        }
                        this.robot.move();

                        if (!this.robot.canPickThing()) {
                            this.robot.putThing();
                        }
                    }
                }
            }

        }

        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }

        while (this.robot.frontIsClear()) {
            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.WEST) {
            this.robot.turnLeft();
        }

        while (!this.FrenteLimpio()) {
            Thread.yield();
        }
        this.robot.move();
        while (!this.FrenteLimpio()) {
            Thread.yield();
        }
        this.robot.move();

        while (this.robot.getDirection() != Direction.NORTH) {
            this.robot.turnLeft();
        }

        while (this.robot.getStreet() != 2) {
            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.WEST) {
            this.robot.turnLeft();
        }

        while (this.robot.getAvenue() != this.codigo) {
            while (!this.FrenteLimpio()) {
                Thread.yield();
            }
            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.NORTH) {
            this.robot.turnLeft();
        }

        while (this.robot.getStreet() != 0) {
            while (!this.FrenteLimpio()) {
                Thread.yield();
            }
            this.robot.move();
        }

        while (this.robot.getDirection() != Direction.SOUTH) {
            this.robot.turnLeft();
        }

        this.ocupado = false;
    }

}
