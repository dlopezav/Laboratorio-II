
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
    private TreeMap<Integer, Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Pedido> pedidos;

    public Tienda(String nombre, Empleado[] empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.bodega = new Bodega(empleados[0]);
        this.clientes = new TreeMap<>();
        this.productos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.system = new Sistema(this.bodega.getRobotsOrganizadores(), this.bodega.getEstantes());
        this.system.setPedidosPorFacturar(this.pedidos);
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

    public TreeMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setCliente(int id, Cliente cliente) {
        this.clientes.put(id, cliente);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProducto(Producto producto) {
        this.productos.add(producto);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    
    
    
    public void mostrarCatalogo(){
        System.out.println("/t Catalogo");
        for (int i = 0; i < this.productos.size(); i++) {
            System.out.println((i+1) + ". " + this.productos.get(i).getDescripcion());
        }
    }
    
    public void tomarPedido(int idCliente, int[] productos){
        Pedido pedido = new Pedido(this.clientes.get(idCliente), this.productos.get(productos[0]));
        if (productos.length > 1) {
            for (int i = 1; i < productos.length; i++) {
                pedido.setProducto(this.productos.get(productos[i]));
            }
        }
        this.pedidos.add(pedido);
    }
}
