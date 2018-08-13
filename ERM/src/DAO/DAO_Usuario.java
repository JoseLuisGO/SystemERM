package DAO;

import Views.JPanelFrmUsuario;
import Model.Usuario;
import Connection.DB_Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO_Usuario {

    DB_Manager db_manager;
    Connection connection;

    public DAO_Usuario() {
        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
    }
    
    private String SQL = ""; //Sentencia SQL    
    public Integer totalRegistros; // Obtener los registros

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"Id_Usuario", "Nombre",
            "Usuario", "Contraseña", "Telefono","Estado", "Tipo"};
        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        SQL = "SELECT Id_Usuario, Nombre, Usuario, Contrasenia, "
                + "Telefono , Estado, Tipo FROM "
                + "Usuario WHERE Nombre LIKE '%" + buscar + "%' ORDER BY Id_Usuario DESC";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registros[0] = rs.getString("Id_Usuario");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Usuario");
                registros[3] = rs.getString("Contrasenia");
                registros[4] = rs.getString("Telefono");
                registros[5] = rs.getString("Estado");
                registros[6] = rs.getString("Tipo");                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    /**
     * *Cierre Funcion Mostrar**
     */
    
    /**
     * Cierre Funcion Mostrar
     *
     * @param datos
     */
    
    public boolean insertar(Usuario datos) {

        SQL = "INSERT INTO Usuario (Id_Usuario,Nombre,Usuario,Contrasenia,Telefono,Estado,Tipo)"
                + " VALUES (null,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);            

            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getUsuario());
            pst.setString(3, datos.getContraseña());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getEstado());
            pst.setString(6, datos.getTipo());            

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
    }//Cierre Función Insertar


    public boolean editar(Usuario datos) {

        SQL = "UPDATE Usuario SET Nombre = ?,Usuario = ?,"
                + "Contrasenia = ?,Telefono = ?,Estado = ?,Tipo = ? WHERE Id_Usuario = ? ";
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);            

            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getUsuario());
            pst.setString(3, datos.getContraseña());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getEstado());
            pst.setString(6, datos.getTipo()); 
            pst.setInt(7, datos.getId_Usuario());
            
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
    }//Cierre Función Editar


    public boolean eliminar(Usuario datos) {

        SQL = "DELETE FROM Usuario WHERE Id_Usuario = ?";        
        try {
            PreparedStatement pst = connection.prepareStatement(SQL);            

            pst.setInt(1, datos.getId_Usuario());            

            int N = pst.executeUpdate();            

            if (N != 0 ) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    } //Cierre Función Eliminar

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"Id_Usuario", "Nombre",
            "Usuario", "Contraseña", "Telefono","Estado", "Tipo"};
        String[] registro = new String[7];      

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        SQL = "SELECT Id_Usuario , Nombre , Usuario ,"
                + "Contrasenia , Telefono , Estado , Tipo FROM Usuario "
                + "WHERE Usuario ='" + login + "' "
                + " AND Contrasenia ='" + password + "' AND Estado = 'Activo'";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registro[0] = rs.getString("Id_Usuario");
                registro[1] = rs.getString("Nombre");
                registro[2] = rs.getString("Usuario");
                registro[3] = rs.getString("Contrasenia");
                registro[4] = rs.getString("Telefono");
                registro[5] = rs.getString("Estado");
                registro[6] = rs.getString("Tipo");                

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public int contarUsuarios() {

        SQL = "SELECT COUNT(*)AS cantidadUsuarios FROM Usuario";

        try {
            int codigo_venta = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                codigo_venta = rs.getInt("cantidadUsuarios");
            }
            return codigo_venta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public int verificarLogin() {
        String login = JPanelFrmUsuario.txtLogin.getText();
        SQL = "SELECT COUNT(Usuario) AS Usuario FROM Usuario WHERE Usuario = " + login;

        try {
            int loginResultante = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                loginResultante = rs.getInt("Usuario");
            }
            return loginResultante;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public ArrayList<String> llenar_combo() {
        ArrayList<String> lista = new ArrayList<String>();
        SQL = "SELECT Nombre FROM usuario";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                lista.add(rs.getString("Nombre"));              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
}