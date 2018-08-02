package Model;

/**
 *
 * @author Jose_Gonzalez
 */
public class Almacen {
    
    private int Cod_Almacen;
    private String Nombre_Almacen;
    private String Descripcion;

    public Almacen() {
    }

    public int getCod_Almacen() {
        return Cod_Almacen;
    }

    public void setCod_Almacen(int Cod_Almacen) {
        this.Cod_Almacen = Cod_Almacen;
    }

    public String getNombre_Almacen() {
        return Nombre_Almacen;
    }

    public void setNombre_Almacen(String Nombre_Almacen) {
        this.Nombre_Almacen = Nombre_Almacen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
