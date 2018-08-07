/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.DB_Manager;
import Model.Configuracion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose_Gonzalez
 */
public class DAO_Configuracion {
    
    DB_Manager db_manager;
    Connection connection;

    public DAO_Configuracion() {
        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
    }
    
    public float getValueDollar() {
        float valor = 0;
        try {
            String SQL = "SELECT * FROM configuracion WHERE idConfiguracion = 1";
            PreparedStatement ps = connection.prepareCall(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valor = rs.getFloat(2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }   
        return valor;
    }
    
    public boolean updateValueDollar(Configuracion conf) {
        try {
            String SQL = "UPDATE Configuracion SET valorDolar = '"+conf.getValorDolar()+"' WHERE idConfiguracion = 1;";
            PreparedStatement ps = connection.prepareCall(SQL);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }  
    }
}
