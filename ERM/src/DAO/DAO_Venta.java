package DAO;

import Connection.DB_Manager;
import Model.Producto;
import Model.Venta;
import Views.FrmMostrarVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO_Venta {

    DB_Manager db_manager;
    Connection connection;

    public DAO_Venta() {
        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
    }
    
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar() {

        DefaultTableModel modelo;

        String[] titulos = {"Número Venta",
            "Fecha ", "Total", "Id Usuario",
            "Usuario", "Id Cliente", "Cliente", "Comprobante", "Factura", "Descuento"};

        String[] registros = new String[10];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Id_Venta , Fecha_Venta , Total_Venta  , Id_UsuarioFK,"
                + "(SELECT Nombre FROM Usuario WHERE Id_Usuario = Id_UsuarioFK)"
                + "AS usuarioNom,Id_ClienteFK ,"
                + "(SELECT Razon_Social FROM Cliente WHERE Id_Cliente = Id_ClienteFK)"
                + "AS clienteNom ,Tipo_Comprobante,Factura,Descuento FROM Venta ORDER BY Id_Venta DESC";
        
        /*sSQL2 = "SELECT Id_Venta, Fecha_Venta, Replace(Format(Total_Venta, 0), ',', '.') AS Total_Venta , Id_UsuarioFK,"
                + "(SELECT Nombre FROM Usuario WHERE Id_Usuario = Id_UsuarioFK)"
                + "AS usuarioNom,Id_ClienteFK,"
                + "(SELECT Razon_Social FROM Cliente WHERE Id_Cliente = Id_ClienteFK)"
                + "AS clienteNom ,Tipo_Comprobante,No_Factura,Descuento FROM Venta ORDER BY Id_Venta DESC";*/

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                
                registros[0] = rs.getString("Id_Venta");
                registros[1] = rs.getString("Fecha_Venta");
                registros[2] = rs.getString("Total_Venta");
                registros[3] = rs.getString("Id_UsuarioFK");
                registros[4] = rs.getString("usuarioNom");
                registros[5] = rs.getString("Id_ClienteFK");
                registros[6] = rs.getString("clienteNom");
                registros[7] = rs.getString("Tipo_Comprobante");
                registros[8] = rs.getString("Factura");
                registros[9] = rs.getString("Descuento");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(Venta datos) {

        sSQL = "INSERT INTO Venta "
                + "(Id_UsuarioFK,Id_ClienteFK,Fecha_Venta,Tipo_Comprobante,Factura,"
                + "Tipo_Pago,Tipo_Cambio,Descuento,Subtotal,Total_Venta)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setInt(1, datos.getId_UsuarioFK());
            pst.setInt(2, datos.getId_ClienteFK());
            pst.setDate(3, datos.getFecha_Venta());
            pst.setString(4, datos.getTipo_Comprobante());
            pst.setString(5, datos.getFactura());
            pst.setString(6, datos.getTipo_Pago());
            pst.setString(7, datos.getTipo_Cambio());
            pst.setFloat(8, datos.getDescuento());
            pst.setFloat(9, datos.getSubTotal());
            pst.setFloat(10, datos.getTotal_Venta());

            
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

    public boolean editar(Venta datos) {
        sSQL = "UPDATE Venta SET Fecha_Venta = ?, "
                + "Total_Venta = ? , Id_UsuarioFK = ?  , Id_ClienteFK = ? ,"
                + " Tipo_Comprobante =?,No_Factura=? , Descuento=? WHERE Id_Venta = ?";

        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setDate(1, datos.getFecha_Venta());
            pst.setFloat(2, datos.getTotal_Venta());
            pst.setInt(3, datos.getId_UsuarioFK());
            pst.setInt(4, datos.getId_ClienteFK());
            pst.setString(5, datos.getTipo_Comprobante());

            
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

    public boolean eliminar(Venta datos) {
        sSQL = "DELETE FROM Venta WHERE Id_Venta = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setInt(1, datos.getId_Venta());
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
    
      public boolean RestaurarProd(Venta datos) {
          
        int codigo = Integer.parseInt(FrmMostrarVentas.txtCod_venta.getText());
        
    /*******AL ELIMINAR UNA VENTA VUELVEN LOS PRODUCTOS AL STOCK ANTERIOR***********/
        
        sSQL2 = "SELECT Cod_ProductoFK,sum(Cantidad_Detalle) AS Cantidad_Detalle1,"
                + "(SELECT Existencia FROM Producto WHERE Cod_Producto = Cod_ProductoFK) "
                + "AS Existencia FROM Detalle_Venta WHERE Id_VentaFK =" + codigo + " GROUP"
                + "BY Cod_ProductoFK";
        try {
            String codigo_producto;
            int cantidad_detalle = 0;
            int stock = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL2);
            while (rs.next()) {
                codigo_producto = rs.getString("Cod_ProductoFK");
                cantidad_detalle = rs.getInt("Cantidad_Detalle1");
                stock = rs.getInt("Existencia");

               stock = stock + cantidad_detalle;
                
                Producto datos2 = new Producto();
                DAO_Producto funcion2 = new DAO_Producto();
                
                datos2.setCod_Producto(codigo_producto);
                datos2.setExistencia(stock);
                funcion2.ModificarStockProductos(datos2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        /**************** TERMINO FUNCIÓN DE VOLVER PRODUCTOS *****************/
        
        sSQL = "DELETE FROM Venta WHERE Id_Venta = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setInt(1, datos.getId_Venta());
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
      
    /************************* FUNCIONES ADICIONALES **************************/
      
    public DefaultTableModel Buscar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"Número Venta",
            "Fecha ", "Total", "Id Usuario",
            "Usuario", "Id Cliente", "Cliente", "Comprobante", "Factura", "Descuento"};

        String[] registros = new String[10];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Id_Venta , Fecha_Venta , Total_Venta ,Id_UsuarioFK, "
                + "(SELECT Nombre FROM Usuario WHERE Id_Usuario = Id_UsuarioFK) AS usuarioNom,"
                + "Id_ClienteFK , "
                + "(SELECT  Razon_Social FROM Cliente WHERE Id_Cliente = Id_ClienteFK) AS clienteNom ,"
                + "Tipo_Comprobante,Factura,Descuento FROM Venta "
                + "WHERE(SELECT Razon_Social FROM Cliente WHERE Id_Cliente = Id_ClienteFK) "
                + "LIKE '%"+buscar+"%' AND Id_UsuarioFK = (SELECT Id_Usuario "
                + "FROM Usuario WHERE Id_Usuario = Id_UsuarioFK ) "
                + "ORDER BY Id_Venta DESC;";

        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registros[0] = rs.getString("Id_Venta");
                registros[1] = rs.getString("Fecha_Venta");
                registros[2] = rs.getString("Total_Venta");
                registros[3] = rs.getString("Id_UsuarioFK");
                registros[4] = rs.getString("usuarioNom");
                registros[5] = rs.getString("Id_ClienteFK");
                registros[6] = rs.getString("clienteNom");
                registros[7] = rs.getString("Tipo_Comprobante");
                registros[8] = rs.getString("Factura");
                registros[9] = rs.getString("Descuento");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public int BuscarCodigoVenta() {

        sSQL = "SELECT Id_Venta FROM Venta ORDER BY Id_Venta DESC LIMIT 1 ";

        try {
            int codigo_venta = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                codigo_venta = rs.getInt("Id_Venta");
            }
            return codigo_venta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public boolean Total(Venta datos) {

        sSQL = "UPDATE Venta SET Total_Venta = ? WHERE Id_Venta = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setFloat(1, datos.getTotal_Venta());
            pst.setInt(2, datos.getId_Venta());

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

    public boolean Pago(Venta datos) {

        sSQL = "UPDATE Venta SET Pago = ? WHERE Id_Venta = ?";

        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setInt(2, datos.getId_Venta());

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

    public int BuscarNfacturas() {

        sSQL = "SELECT COUNT(*) as Nfactura FROM Venta WHERE Tipo_Comprobante ='Factura'";

        try {
            int Nfactura = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                Nfactura = rs.getInt("Nfactura");
            }
            return Nfactura;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
}