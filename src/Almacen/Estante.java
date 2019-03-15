
package Almacen;

import becker.robots.Thing;

/**
 * 
 * @version 1.0
 */
public class Estante {
    private int numero;
    private Caja[] cajas;
    private Thing thing;
    private boolean estado;

    public Estante(int numero, Thing thing) {
        this.numero = numero;
        this.cajas = new Caja[3];
        for (int i = 0; i < this.cajas.length; i++) {
            this.cajas[i] = new Caja(i+1);
        }
        this.thing = thing;
        this.estado = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Thing getThing() {
        return thing;
    }

    public Caja[] getCajas() {
        return cajas;
    }

    public void setCajas(Caja[] cajas) {
        this.cajas = cajas;
    }
    
    public void setElementoCaja(Caja c, int i){
        this.cajas[i]=c;
    }
    
    public boolean setProducto(Producto p){
        boolean res = false;
        for (int i = 0; i < 3; i++) {
            if(this.cajas[i]==null){
                this.cajas[i].setProducto(p);
                res = true;
            }
                
        }
        return res;
    }

    public boolean isLleno() {
        for (Caja a : cajas) {
            if (!a.isLleno()) {
                return false;
            }
        }
        return true;
    }

    public boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }

}
