
package Almacen;

import java.util.ArrayList;

/**
 * 
 */
public class Sistema {
    private Boolean[] estadoRobots;
    private RobotOrganizador[] robots;
    private Estante[] estantesBodega;
    private ArrayList<Pedido> pedidosClientes;
    private ArrayList<Factura> facturasGeneradas;

    public Sistema(RobotOrganizador[] robots, Estante[] estantesBodega) {
        this.robots = robots;
        this.estadoRobots = new Boolean[this.robots.length];
        for (int i = 0; i < this.robots.length; i++) {
            this.estadoRobots[i] = false;
        }
        this.pedidosClientes = new ArrayList<>();
        this.facturasGeneradas = new ArrayList<>();
        this.estantesBodega = estantesBodega;
    }

    public Boolean[] getEstadoRobots() {
        return estadoRobots;
    }

    public void setEstadoRobot(Boolean estado, int n) {
        this.estadoRobots[n-1] = estado;
    }

    public RobotOrganizador[] getRobots() {
        return robots;
    }

    public void setRobots(RobotOrganizador[] robots) {
        this.robots = robots;
    }

    public Estante[] getEstantesBodega() {
        return estantesBodega;
    }

    public void setEstantesBodega(Estante[] estantesBodega) {
        this.estantesBodega = estantesBodega;
    }

    public ArrayList<Pedido> getPedidosPorFacturar() {
        return pedidosClientes;
    }

    public void setPedidosPorFacturar(ArrayList<Pedido> pedidosPorFacturar) {
        this.pedidosClientes = pedidosPorFacturar;
    }

    public ArrayList<Factura> getFacturasGeneradas() {
        return facturasGeneradas;
    }

    public void setFactura(Producto[] productosComprados, Cliente comprador, int[] fecha) {
        Factura factura = new Factura(productosComprados, comprador);
        double precio = 0;
        for (Producto productosComprado : productosComprados) {
            precio += productosComprado.getCosto();
        }
        factura.setValorAPagar(precio);
        factura.setFecha(fecha);
        this.facturasGeneradas.add(factura);
    }
    
    public boolean hayEspacio(Estante estante){
        boolean flag = false;
        for (Caja caja : estante.getCajas()) {
            for (Producto producto : caja.getProductosGuardados()) {
                if(producto == null){
                    flag = true;
                    break;
                }  
            }
            if(flag){
                break;
            }
        }
        return flag;
    }
    
    public int robotLibre(){
        for(RobotOrganizador r:robots){
            if(!r.isOcupado()){
                return r.getCodigo();
            }
        }
        return 0;
    }
    
    public int[] tiposProductos(Producto[] productos){
        int[] tipos = new int[productos.length];
        for (int i = 0; i < tipos.length; i++) {
            tipos[i] = productos[i].getTipo();
        }
        return tipos;
    }
    
    public boolean almacenarProductos(Producto[] productos){
        int[] tipos = tiposProductos(productos);
        int aux;
        int posR;
        boolean flag = false;
        Estante estanteAsignado;
        for (Estante estantesBodega1 : this.estantesBodega) {
            aux = estantesBodega1.getNumero();
            for (int j = 0; j < tipos.length; j++) {
                if (aux == tipos[j] && hayEspacio(estantesBodega1)) {
                    this.estantesBodega[tipos[j]].setProducto(productos[j]);
                    estanteAsignado = this.estantesBodega[aux-1];
                    posR = robotLibre();
                    this.setEstadoRobot(true, posR);
                    this.robots[posR].setEstanteAsignado(estanteAsignado);
                    //this.robots[posR].transportarEstante(estanteAsignado.getNumero());
                    this.robots[posR].volverAParquedero(estanteAsignado.getNumero());
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    
    public boolean empacarPedido(Pedido pedido, int a){
        
        return true;
    }
    
    public void LlevarEstante(int num, int estante) throws InterruptedException{
        this.robots[num].transportarEstante(estante);
    }
    
}
