package DAO;

import Connection.DB_Manager;
import Model.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DAO_Proveedor {

    DB_Manager db_manager;
    Connection connection;

    public DAO_Proveedor() {
        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
    }
    
    private String sSQL = ""; //Sentencia SQL    
    public Integer totalRegistros; // Obtener los registros

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"No. Proveedor", "Razon Social",
            "Contacto", "Teléfono", "Correo", "Dirección"};

        String[] registros = new String[6];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT Id_Proveedor,Razon_Social,Contacto"
                + " ,Telefono,Correo,Direccion FROM Proveedor "                
                + " WHERE Razon_Social LIKE '%" + buscar + "%' ORDER BY Id_Proveedor DESC";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registros[0] = rs.getString("Id_Proveedor");
                registros[1] = rs.getString("Razon_Social");                
                registros[2] = rs.getString("Contacto");
                registros[3] = rs.getString("Telefono");
                registros[4] = rs.getString("Correo");
                registros[5] = rs.getString("Direccion");

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
    public boolean insertar(Proveedor datos) {
        
        sSQL = "INSERT INTO Proveedor (Id_Proveedor,Razon_Social,Contacto,Telefono,Correo,Direccion)"
                + "VALUES (null,?,?,?,?,?)";
        
        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);            

            pst.setString(1, datos.getRazon_Social());            
            pst.setString(2, datos.getContacto());
            pst.setString(3, datos.getTelefono());
            pst.setString(4, datos.getCorreo());
            pst.setString(5, datos.getDireccion());

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


    public boolean editar(Proveedor datos) {

        sSQL = "UPDATE Proveedor SET Razon_Social = ? ,Contacto = ? ,"
                + "Telefono = ?, Correo = ?, Direccion = ? WHERE Id_Proveedor = ? ";        

        try {
            
            PreparedStatement pst = connection.prepareStatement(sSQL);            

            pst.setString(1, datos.getRazon_Social());
            pst.setString(2, datos.getContacto());
            pst.setString(3, datos.getTelefono());
            pst.setString(4, datos.getCorreo());
            pst.setString(5, datos.getDireccion());
            pst.setInt(6, datos.getId_Proveedor());            

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

    public boolean eliminar(Proveedor datos) {

        sSQL = "DELETE FROM Proveedor WHERE Id_Proveedor = ? ";
        
        try {

            PreparedStatement pst = connection.prepareStatement(sSQL);            
            
            pst.setInt(1, datos.getId_Proveedor());            

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
        
        sSQL= "SELECT COUNT(Id_Proveedor) AS cantidad FROM Proveedor ";
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
        
        sSQL = "INSERT INTO Proveedor (Id_Proveedor,Razon_Social,Contacto,Telefono,Correo,Direccion)"
                + "VALUES (null,?,?,?,?,?)";
        try{
            PreparedStatement pst = connection.prepareStatement(sSQL);        
            
            pst.executeUpdate();            
        }catch(Exception e){            
            
        }
      return true;
    }/*CIERRE FUNCION INSERTAR*/
}