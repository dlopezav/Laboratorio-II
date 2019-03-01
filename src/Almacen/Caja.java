
package Almacen;

/**
 * 
 * @version 1.0
 */
public class Caja {
    private int numero;
    private Producto[] productosGuardados;

    public Caja(int numero) {
        this.numero = numero;
        this.productosGuardados = new Producto[7];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Producto[] getProductosGuardados() {
        return productosGuardados;
    }
    
    public boolean setProducto(Producto producto){
        boolean flag = false;
        for (int i = 0; i < this.productosGuardados.length; i++) {
            if(this.productosGuardados[i]==null){
                this.productosGuardados[i] = producto;
                flag = true;
                break;
            }
        }
        return flag;
    }
}
