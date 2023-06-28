package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection con; // Objeto para establecer la conexión con la base de datos
    private String usuario = "root"; // Nombre de usuario de la base de datos
    private String clave = ""; // Contraseña de la base de datos

    // URL de conexión a la base de datos, que incluye el nombre de la base de datos y los parámetros de configuración
    private String url = "jdbc:mysql://localhost:3306/crudapp?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";


    public Conexion(){
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection(url,usuario, clave);
            System.out.println("Conexión establecida exitosamente!");
        } catch (Exception e) {
        System.err.println("Error al establecer la conexión: " + e);
    }
    }

    public Connection getConnection(){
        return con; // Devuelve la conexión establecida con la base de datos
    }
    
    
}
