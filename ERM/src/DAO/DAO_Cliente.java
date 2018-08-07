package DAO;

import Connection.DB_Manager;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO_Cliente {

    DB_Manager db_manager;
    Connection connection;
    
    public DAO_Cliente() {
        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
    }
    
    private String sSQL = ""; //Sentencia SQL    
    public Integer totalRegistros; // Obtener los registros

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"No. Cliente", "Razon Social",
            "No. Estación", "Contacto", 
            "Teléfono", "Correo", "Dirección"};

        String[] registros = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Id_Cliente,Razon_Social,No_Estacion,Contacto"
                + " ,Telefono,Correo,Direccion FROM Cliente "                
                + " WHERE Razon_Social LIKE '%" + buscar + "%' ORDER BY Id_Cliente DESC";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registros[0] = rs.getString("Id_Cliente");
                registros[1] = rs.getString("Razon_Social");
                registros[2] = rs.getString("No_Estacion");
                registros[3] = rs.getString("Contacto");
                registros[4] = rs.getString("Telefono");
                registros[5] = rs.getString("Correo");
                registros[6] = rs.getString("Direccion");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    /**
     ****Cierre Funcion Mostrar******
     */
    public boolean insertar(Cliente datos) {
        
        sSQL = "INSERT INTO Cliente (Id_Cliente,Razon_Social,No_Estacion,Contacto,Telefono,Correo,Direccion)"
                + "VALUES (null,?,?,?,?,?,?)";
        
        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);            

            pst.setString(1, datos.getRazon_Social());
            pst.setString(2, datos.getNo_Estacion());
            pst.setString(3, datos.getContacto());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getCorreo());
            pst.setString(6, datos.getDireccion());

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
    }/*CIERRE FUNCION INSERTAR*/


    public boolean editar(Cliente datos) {

        sSQL = "UPDATE Cliente SET Razon_Social = ? ,No_Estacion = ? ,"
                + "Contacto = ? ,Telefono = ?, Correo = ?, Direccion = ? WHERE Id_Cliente = ? ";        

        try {
            
            PreparedStatement pst = connection.prepareStatement(sSQL);            

            pst.setString(1, datos.getRazon_Social());
            pst.setString(2, datos.getNo_Estacion());
            pst.setString(3, datos.getContacto());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getCorreo());
            pst.setString(6, datos.getDireccion());
            pst.setInt(7, datos.getId_Cliente());            

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
    }/*CIERRE FUNCION EDITAR*/

    public boolean eliminar(Cliente datos) {

        sSQL = "DELETE FROM Cliente WHERE Id_Cliente = ? ";
        
        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);            
            
            pst.setInt(1, datos.getId_Cliente());            

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
    }/*CIERRE FUNCION ELIMINAR*/
    
    /****CLIENTE GENERAL***/
    
    
    public int PrimerCliente() {
        
        sSQL= "SELECT COUNT(Id_Cliente) AS cantidad FROM Cliente ";
        try {
            int cantidad = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
            return cantidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }//cierre funcion */     
       
    public boolean insertarPrimercLiente() {
        
        sSQL = "INSERT INTO Cliente (Id_Cliente,Razon_Social,No_Estacion,Contacto,Telefono,Correo,Direccion)"
                + "VALUES (null,?,?,?,?,?,?)";
        try{
            PreparedStatement pst = connection.prepareStatement(sSQL);        
            
            pst.executeUpdate();            
        }catch(Exception e){            
            
        }
      return true;
    }/*CIERRE FUNCION INSERTAR*/
}