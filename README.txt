# SystemERM

## Introduction

> El sistema (ERM) de Equipos y Refacciones Maldonado optimiza los tiempos de ejecución de los servicios que proporcionan, como ejemplo: El registro de los empleado, de los proveedores, el inventario de los productos, la generación de reportes, entre otros.

## Code Samples

private Connection connection;

    public DB_Manager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/inventario_erm";

            this.connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexion establecida a la base de datos...");
        } catch (Exception e) {
            System.out.println("Error al acceder a la base de datos...");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

## Installation

- Crear la base de datos llamada inventario_erm.
- Importar el respaldo sql en la base creada.
- Ejecutar el proyecto.