/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql_java;

/**
 *
 * @author Alejandro Diaz
 */
import java.sql.*;

public class ConexionBD {
    public static void main(String[] args) {
        // 1. Establecer la conexión a la base de datos
        String url = "jdbc:postgresql://localhost:5432/proyectos_investigacion";
        String usuario = "administrador";
        String clave = "admin_password";

        try (Connection con = DriverManager.getConnection(url, usuario, clave)) {
            
            // 2. Crear la sentencia SQL
            String query = "SELECT * FROM proyecto";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                // 3. Asignar valores a los parámetros
                // 4. Ejecutar la consulta
                ResultSet rs = stmt.executeQuery();
                
                // 5. Procesar los resultados
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("codigo_proyecto") + ", Nombre: " + rs.getString("nombre"));
                }

            } catch (SQLException e) {
                System.out.println("Error en la consulta SQL: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}

