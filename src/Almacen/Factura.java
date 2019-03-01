
package Almacen;

/**
 * 
 * @version 1.0
 */
public class Factura {
    private Producto[] productosComprados;
    private double valorAPagar;
    private Cliente comprador;
    private Fecha fecha;

    public Factura(Producto[] productosComprados, Cliente comprador) {
        this.productosComprados = productosComprados;
        this.valorAPagar = 0;
        this.comprador = comprador;
    }

    public Producto[] getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(Producto[] productosComprados) {
        this.productosComprados = productosComprados;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(int[] datos) {
        this.fecha = new Fecha(datos[0], datos[1], datos[2]);
    }
    
    public String mostrarDatos(){
        String datos = "Articulos comprados\n";
        for(int i=0;i<productosComprados.length;i++){
            datos += (i+1) + ". " + productosComprados[i].getDescripcion() + " - " + productosComprados[i].getCosto() + "\n";
        }
        datos += "Fecha: " + this.fecha.getDia() +"/"+ this.fecha.getMes() +"/"+ this.fecha.getYear() + "\n";
        datos += "\n";
        datos += comprador.getNombre() + " " + comprador.getApellido();
        datos += "\nValor a pagar: " + this.valorAPagar;
        
        
        return datos;
    }
}
