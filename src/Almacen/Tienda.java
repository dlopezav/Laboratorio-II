
package Almacen;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 
 * @version 1.0
 */
public class Tienda {
    private String nombre;
    private Sistema system;
    private Empleado[] empleados;
    private Bodega bodega;
    private ArrayList<Producto> productos;;

    public Tienda(String nombre, Empleado[] empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.bodega = new Bodega(empleados[0]);
        this.productos = new ArrayList<>();
        this.system = new Sistema(this.bodega.getRobotsOrganizadores(), this.bodega.getEstantes());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sistema getSystem() {
        return system;
    }

    public void setSystem(Sistema system) {
        this.system = system;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void mostrarCatalogo(){
        System.out.println("/t Catalogo");
        for (int i = 0; i < this.productos.size(); i++) {
            System.out.println((i+1) + ". " + this.productos.get(i).getDescripcion());
        }
    }
    
    
}
