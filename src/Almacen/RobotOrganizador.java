
package Almacen;

import becker.robots.Direction;
import becker.robots.Robot;

/**
 * 
 * @version 1.0
 */
public class RobotOrganizador implements Runnable{
    private int codigo;
    private Estante estanteAsignado;
    private Boolean ocupado;
    private Robot robot;

    public RobotOrganizador(int codigo, Robot robot) {
        this.codigo = codigo;
        this.robot = robot;
        this.ocupado = false;
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
    
    public void setEstanteAsignado(Estante estanteAsignado){
        this.estanteAsignado = estanteAsignado;
    }

    public Robot getRobot() {
        return robot;
    }
    
    public void transportarEstante(int num){
        int r = this.codigo;
        int x=0;
        int y=0;
        this.robot.move();
        if(num>=1&&num<=4){
            y=3;
        }else if(num>=5&&num<=8){
            y=4;
        }else if(num>=9&&num<=12){
            y=5;
        }else if(num>=13&&num<=16){
            y=6;
        }else if(num>=17&&num<=20){
            y=7;
        }
        
        switch (num%4) {
            case 1:
                x=1;
                break;
            case 2:
                x=2;
                break;
            case 3:
                x=3;
                break;
            case 0:
                x=4;
                break;
        }
        
        if(r<x){
            this.robot.turnLeft();
            while(this.robot.getAvenue()!=x){
                this.robot.move();
            }
        }else if(r>x){
            this.robot.turnLeft();
            this.robot.turnLeft();
            this.robot.turnLeft();
            while(this.robot.getAvenue()!=x){
                this.robot.move();
            }
        }
        
        while(this.robot.getDirection()!=Direction.SOUTH){
            this.robot.turnLeft();
        }
        
        while(this.robot.getStreet()!=y){
            this.robot.move();
        }
        this.robot.pickThing();
        
        while(this.robot.getDirection()!=Direction.EAST){
            this.robot.turnLeft();
        }
        
        while(this.robot.getAvenue()!=10){
            this.robot.move();
        }
        
        while(this.robot.getDirection()!=Direction.SOUTH){
            this.robot.turnLeft();
        }
        
        while(this.robot.getStreet()!=8){
            this.robot.move();
        }
        this.robot.putThing();
        while(this.robot.getDirection()!=Direction.WEST){
            this.robot.turnLeft();
        }
        this.robot.move();
        while(this.robot.getDirection()!=Direction.SOUTH){
            this.robot.turnLeft();
        }
    }
    
    public void volverAParquedero(int num){
        int r = this.codigo;
        int x=0;
        int y=0;
        if(num>=1&&num<=4){
            y=3;
        }else if(num>=5&&num<=8){
            y=4;
        }else if(num>=9&&num<=12){
            y=5;
        }else if(num>=13&&num<=16){
            y=6;
        }else if(num>=17&&num<=20){
            y=7;
        }
        switch (num%4) {
            case 1:
                x=1;
                break;
            case 2:
                x=2;
                break;
            case 3:
                x=3;
                break;
            case 0:
                x=4;
                break;
        }
        while(this.robot.getDirection()!=Direction.EAST){
            this.robot.turnLeft();
        }
        this.robot.move();
        this.robot.pickThing();
        while(this.robot.getDirection()!=Direction.NORTH){
            this.robot.turnLeft();
        }
        while(this.robot.getStreet()!=y){
            this.robot.move();
        }
        while(this.robot.getDirection()!=Direction.WEST){
            this.robot.turnLeft();
        }
        while(this.robot.getAvenue()!=x){
            this.robot.move();
        }
        this.robot.putThing();
        while(this.robot.getDirection()!=Direction.NORTH){
            this.robot.turnLeft();
        }
        while(this.robot.getStreet()!=2){
            this.robot.move();
        }
        
        if (r<x) {
            while(this.robot.getDirection()!=Direction.WEST){
                this.robot.turnLeft();
            }
            while(this.robot.getAvenue()!=r){
                this.robot.move();    
            }
            this.robot.turnLeft();
            this.robot.move();
            while(this.robot.getDirection()!=Direction.NORTH){
                this.robot.turnLeft();
            }
        }else if(r>x){
            while(this.robot.getDirection()!=Direction.EAST){
                this.robot.turnLeft();
            }
            while(this.robot.getAvenue()!=r){
                this.robot.move();
            }
            this.robot.turnLeft();
            this.robot.move();
            while(this.robot.getDirection()!=Direction.NORTH){
                this.robot.turnLeft();
            }
        }
        
        while(this.robot.getDirection()!=Direction.SOUTH){
            this.robot.turnLeft();
        }
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public void run() {
        
    }
    
}
