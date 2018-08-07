package Model;

/**
 *
 * @author Jose_Gonzalez
 */
public class DetalleVenta {
    
    private int Cod_Detalle;
    private long Cantidad_Detalle;
    private String Cod_ProductoFK ;
    private float Precio_Venta; 
    private int Id_VentaFK;
    private float Subtotal;

    public DetalleVenta() {
    }

    public int getCod_Detalle() {
        return Cod_Detalle;
    }

    public void setCod_Detalle(int Cod_Detalle) {
        this.Cod_Detalle = Cod_Detalle;
    }

    public long getCantidad_Detalle() {
        return Cantidad_Detalle;
    }

    public void setCantidad_Detalle(long Cantidad_Detalle) {
        this.Cantidad_Detalle = Cantidad_Detalle;
    }

    public String getCod_ProductoFK() {
        return Cod_ProductoFK;
    }

    public void setCod_ProductoFK(String Cod_ProductoFK) {
        this.Cod_ProductoFK = Cod_ProductoFK;
    }

    public float getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(float Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public int getId_VentaFK() {
        return Id_VentaFK;
    }

    public void setId_VentaFK(int Id_VentaFK) {
        this.Id_VentaFK = Id_VentaFK;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }
    
    
}
