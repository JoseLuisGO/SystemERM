package Model;

/**
 *
 * @author Jose_Gonzalez
 */
public class Producto {
    
    private String Cod_Producto;
    private String Proveedor;
    private String Nombre_Producto;
    private String Descripcion;
    private float Precio_Venta;
    private float Precio_Compra;       
    private int Existencia;
    private String Cod_AlmacenFK;
    private String Tipo_Moneda;
    private float Dolar;

    public Producto() {
    }
    
    public String getCod_Producto() {
        return Cod_Producto;
    }

    public void setCod_Producto(String Cod_Producto) {
        this.Cod_Producto = Cod_Producto;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(float Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public float getPrecio_Compra() {
        return Precio_Compra;
    }

    public void setPrecio_Compra(float Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public String getCod_AlmacenFK() {
        return Cod_AlmacenFK;
    }

    public void setCod_AlmacenFK(String Cod_AlmacenFK) {
        this.Cod_AlmacenFK = Cod_AlmacenFK;
    }

    public String getTipo_Moneda() {
        return Tipo_Moneda;
    }

    public void setTipo_Moneda(String Tipo_Moneda) {
        this.Tipo_Moneda = Tipo_Moneda;
    }

    public float getDolar() {
        return Dolar;
    }

    public void setDolar(float Dolar) {
        this.Dolar = Dolar;
    }
    
    
}
