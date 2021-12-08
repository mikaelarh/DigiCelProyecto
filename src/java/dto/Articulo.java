
package dto;


/**
 *
 * @author xykukulkan
 */
public class Articulo {
    private Producto producto;
    private int cantidad;
    
    public Articulo(){
        super();
    }
    
    public Articulo(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * @return the idProducto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
