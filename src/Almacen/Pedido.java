
package Almacen;

import becker.robots.Thing;
import java.util.ArrayList;

/**
 * @author 
 * @since 23/09/2018
 * @version 1.0
 */
public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private Fecha fecha;
    private Thing thing;

    public Pedido(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.productos.add(producto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public void setProducto(Producto producto){
        this.productos.add(producto);
    }
    
    public Fecha getFecha(){
        return this.fecha;
    }
    
    public void setFecha(int[] datos) {
        this.fecha = new Fecha(datos[0], datos[1], datos[2]);
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
}
