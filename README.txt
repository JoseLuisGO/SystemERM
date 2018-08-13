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

- Ejecutar el archivo 'SystemERM-Setup.exe' que se encuentra dentro de la carpeta 'Installation'.
	NOTA: Para que pueda crearse la BASE DE DATOS deberá de aceptar que se ejecute wampserver al finalizar la instalacion, en caso de que ya cuente con wampserver 	      debera iniciarlo antes de comezar la instalacion para que pueda cargar los complementos de la BASE (De no hacer esto debera ingresar la BASE DE DATOS 	      manualmente).
- Si desea instalar el sistema en otro equipo deberá tener todo el contenido que se encuentra dentro de la carpeta Installation.