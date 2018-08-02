package Model;

/**
 *
 * @author Jose_Gonzalez
 */
public class HistorialStock {
    
    private int Cod_Historial;
    private String Cod_ProductoFK;
    private int Id_UsuarioFK;
    private String Descripcion;
    private String Referencia;
    private int Cantidad_Nva;
    private String Fecha;

    public HistorialStock() {
    }

    public int getCod_Historial() {
        return Cod_Historial;
    }

    public void setCod_Historial(int Cod_Historial) {
        this.Cod_Historial = Cod_Historial;
    }

    public String getCod_ProductoFK() {
        return Cod_ProductoFK;
    }

    public void setCod_ProductoFK(String Cod_ProductoFK) {
        this.Cod_ProductoFK = Cod_ProductoFK;
    }

    public int getId_UsuarioFK() {
        return Id_UsuarioFK;
    }

    public void setId_UsuarioFK(int Id_UsuarioFK) {
        this.Id_UsuarioFK = Id_UsuarioFK;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public int getCantidad_Nva() {
        return Cantidad_Nva;
    }

    public void setCantidad_Nva(int Cantidad_Nva) {
        this.Cantidad_Nva = Cantidad_Nva;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
