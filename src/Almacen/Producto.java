
package Almacen;

/**
 * 
 * @version 1.0
 */
public class Producto {
    private String descripcion;
    private double costo;
    private int tipo;
    private int[] posicion;

    public Producto(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }
    
    public void setCosto(double costo){
        this.costo = costo;
    }

    public int getTipo() {
        return tipo;
    }
    
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }
}
