package DAO;

import Connection.DB_Manager;
import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO_Producto {

    DB_Manager db_manager;
    Connection connection;

    public DAO_Producto() {
        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
    }

    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Código","Proveedor", "Número Parte",
                    "Descripción", "Precio Venta",
                    "Precio Compra", "Existencia",
                    "Ubicación"};

        String[] registros = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Cod_Producto,Proveedor,Nombre_Producto,Descripcion,Precio_Venta ,Precio_Compra ,Existencia,(SELECT Nombre_Almacen FROM Almacen WHERE Cod_Almacen = Cod_AlmacenFK) AS Nombre_Almacen FROM Producto WHERE Descripcion LIKE '%" + buscar + "%' ORDER BY Cod_Producto DESC";

        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("Cod_Producto"); 
                registros[1] = rs.getString("Proveedor");
                registros[2] = rs.getString("Nombre_Producto");
                registros[3] = rs.getString("Descripcion");
                registros[4] = rs.getString("Precio_Venta");
                registros[5] = rs.getString("Precio_Compra");
                registros[6] = rs.getString("Existencia");
                registros[7] = rs.getString("Nombre_Almacen");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar(Producto datos,String nombre) {
        
        sSQL = "INSERT INTO Producto (Cod_Producto,Proveedor"
                + ",Nombre_Producto,Descripcion,Precio_Venta,Precio_Compra,Existencia,Cod_AlmacenFK)"
                + " VALUES (?,?,?,?,?,?,?,"
                + "(SELECT Cod_Almacen FROM Almacen WHERE Nombre_Almacen LIKE '%" + nombre + "%'))";
        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setString(1, datos.getCod_Producto());
            pst.setString(2, datos.getProveedor());
            pst.setString(3, datos.getNombre_Producto());
            pst.setString(4, datos.getDescripcion());
            pst.setFloat(5, datos.getPrecio_Venta());
            pst.setFloat(6, datos.getPrecio_Compra());            
            pst.setInt(7, datos.getExistencia());           
            
            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//cierre funcion

    public boolean editar(Producto datos, String nombre) {

        sSQL = "UPDATE Producto SET Proveedor = ?, Nombre_Producto = ?, Descripcion = ?  , Precio_Venta = ? , Precio_Compra = ? , Existencia = ? , Cod_AlmacenFK =(SELECT Cod_Almacen FROM Almacen WHERE Nombre_Almacen LIKE '%" + nombre + "%' LIMIT 1) WHERE Cod_Producto =? ";

        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setString(1, datos.getProveedor());
            pst.setString(2, datos.getNombre_Producto());
            pst.setString(3, datos.getDescripcion());
            pst.setFloat(4, datos.getPrecio_Venta());
            pst.setFloat(5, datos.getPrecio_Compra());            
            pst.setInt(6, datos.getExistencia());

            pst.setString(7, datos.getCod_Producto());

            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//cierre funcion

    public boolean eliminar(Producto datos) {
        sSQL = "DELETE FROM Producto WHERE Cod_Producto = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setString(1, datos.getCod_Producto());
            int N = pst.executeUpdate();

            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }//cierre funcion

    /**
     * ***** FUNCION STOCK ****
     */
    public boolean ModificarStockProductos(Producto datos) {

        sSQL = "UPDATE Producto SET Existencia = ? WHERE Cod_Producto = ?";
        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setInt(1, datos.getExistencia());

            pst.setString(2, datos.getCod_Producto());

            int N = pst.executeUpdate();
            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public long productoIgual(String codigo) {

        sSQL = "SELECT Cod_Producto FROM Producto WHERE Cod_Producto = " + codigo;

        try {
            long cod = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cod = rs.getLong("Cod_Producto");
            }
            return cod;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public DefaultTableModel mostrarExportar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos
                = {"Código", "Proveedor",
                    "Número Parte", "Descripción", "Precio Venta",
                    "Precio Compra", "Existencia"};

        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Cod_Producto , Proveedor , Nombre_Producto , Descripcion , Precio_Venta ,  Precio_Compra , Existencia FROM Producto WHERE Descripcion LIKE '%" + buscar + "%' ORDER BY Cod_Producto DESC";

        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("Cod_Producto");
                registros[1] = rs.getString("Proveedor");                
                registros[2] = rs.getString("Nombre_Producto");
                registros[3] = rs.getString("Descripcion");
                registros[4] = rs.getString("Precio_Venta");
                registros[5] = rs.getString("Precio_Compra");
                registros[6] = rs.getString("Existencia");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public ArrayList<String> llenar_combo() {
        ArrayList<String> lista = new ArrayList<String>();
        sSQL = "SELECT Nombre_Almacen FROM Almacen";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                lista.add(rs.getString("Nombre_Almacen"));              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
}