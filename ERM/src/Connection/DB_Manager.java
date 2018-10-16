package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Manager {

    private Connection connection;

    public DB_Manager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/inventario_erm";
            //String url = "jdbc:mysql://120.78.181.58:3306/refaccio_sistema_erm";

            this.connection = DriverManager.getConnection(url, "root", "");
            //this.connection = DriverManager.getConnection(url, "refacciones", "bVH$7mwI@kN");
            System.out.println("Conexion establecida a la base de datos...");
        } catch (Exception e) {
            System.out.println("Error al acceder a la base de datos...");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
