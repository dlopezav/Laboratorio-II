
package Almacen;

import java.util.ArrayList;

/**
 * 
 * @version 1.0
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private int id;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Factura> facturas;

    public Cliente(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.pedidos = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFactura(Factura factura) {
        this.facturas.add(factura);
    }
    
}
