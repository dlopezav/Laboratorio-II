
package Almacen;

/**
 * @author Jorge Aurelio Morales
 * @author Ricardo Andres Clavo
 * @author Julio Enrique Aguilera
 * @author Jhon Sebastian Rojas
 * @author Julio Andres Rodriguez 
 * @since 23/09/2018
 * @version 1.0
 */
public class Fecha {
    private final int dia;
    private final int mes;
    private final int year;

    public Fecha(int dia, int mes, int year) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getYear() {
        return year;
    }
    
}
