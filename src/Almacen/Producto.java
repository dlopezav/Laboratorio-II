
package Almacen;

/**
 * 
 * @version 1.0
 */
public class Producto {
    private String descripcion;
    private double costo;

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

    
}
