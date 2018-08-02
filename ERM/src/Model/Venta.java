package Model;

/**
 *
 * @author Jose_Gonzalez
 */
public class Venta {
    
    private int Id_Venta;
    private int Id_UsuarioFK;
    private int Id_ClienteFK;
    private String Fecha_Venta ;
    private String Tipo_Comprobante;
    private String Factura;
    private String Tipo_Pago;
    private int Tipo_Cambio;
    private int Descuento;
    private float SubTotal;
    private float Total_Venta ;

    public Venta() {
    }

    public int getId_Venta() {
        return Id_Venta;
    }

    public void setId_Venta(int Id_Venta) {
        this.Id_Venta = Id_Venta;
    }

    public int getId_UsuarioFK() {
        return Id_UsuarioFK;
    }

    public void setId_UsuarioFK(int Id_UsuarioFK) {
        this.Id_UsuarioFK = Id_UsuarioFK;
    }

    public int getId_ClienteFK() {
        return Id_ClienteFK;
    }

    public void setId_ClienteFK(int Id_ClienteFK) {
        this.Id_ClienteFK = Id_ClienteFK;
    }

    public String getFecha_Venta() {
        return Fecha_Venta;
    }

    public void setFecha_Venta(String Fecha_Venta) {
        this.Fecha_Venta = Fecha_Venta;
    }

    public String getTipo_Comprobante() {
        return Tipo_Comprobante;
    }

    public void setTipo_Comprobante(String Tipo_Comprobante) {
        this.Tipo_Comprobante = Tipo_Comprobante;
    }

    public String getFactura() {
        return Factura;
    }

    public void setFactura(String Factura) {
        this.Factura = Factura;
    }

    public String getTipo_Pago() {
        return Tipo_Pago;
    }

    public void setTipo_Pago(String Tipo_Pago) {
        this.Tipo_Pago = Tipo_Pago;
    }

    public int getTipo_Cambio() {
        return Tipo_Cambio;
    }

    public void setTipo_Cambio(int Tipo_Cambio) {
        this.Tipo_Cambio = Tipo_Cambio;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public float getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(float SubTotal) {
        this.SubTotal = SubTotal;
    }

    public float getTotal_Venta() {
        return Total_Venta;
    }

    public void setTotal_Venta(float Total_Venta) {
        this.Total_Venta = Total_Venta;
    }
    
    
}
