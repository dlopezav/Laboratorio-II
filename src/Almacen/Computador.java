
package Almacen;

import becker.robots.Thing;

/**
 * 
 * @version 1.0
 */
public class Computador {
    private Thing pc;
    private Sistema sistema;

    public Computador(Sistema sistema) {
        this.sistema = sistema;
    }

    
    public Thing getPc() {
        return pc;
    }

    public void setPc(Thing pc) {
        this.pc = pc;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
  
}
