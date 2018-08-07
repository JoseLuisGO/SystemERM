package DAO;

import Connection.DB_Manager;
import Model.HistorialStock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO_HistorialStock {

    DB_Manager db_manager;
    Connection connection;

    public DAO_HistorialStock() {
        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
    }

    private String sSQL = "";

    public DefaultTableModel Mostrar(String id) {

        DefaultTableModel modelo;
        String[] titulos = {"Fecha", "Usuario", "Descripción", "Cantidad Agregada", "Referencia"};

        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT h.Fecha ,p.Nombre ,h.Descripcion ,h.Cantidad_Nva ,h.Referencia FROM Historial_Stock h INNER JOIN Usuario p ON p.Id_Usuario = h.Id_UsuarioFK WHERE h.Cod_ProductoFK = '"+id+"' ORDER BY Cod_Historial DESC";
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
                        
                while (rs.next()) {

                registros[0] = rs.getString("Fecha");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Descripcion");
                registros[3] = rs.getString("Cantidad_Nva");
                registros[4] = rs.getString("Referencia");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public boolean insertar(HistorialStock datos) {
        sSQL = "INSERT INTO Historial_Stock (Cod_ProductoFK,Id_UsuarioFK,Descripcion,Referencia,Cantidad_Nva,Fecha) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sSQL);

            pst.setString(1, datos.getCod_ProductoFK());
            pst.setInt(2, datos.getId_UsuarioFK());
            pst.setString(3, datos.getDescripcion());
            pst.setString(4, datos.getReferencia());
            pst.setInt(5, datos.getCantidad_Nva());
            pst.setDate(6, datos.getFecha());
            int N = pst.executeUpdate();

            if (N != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}