/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;

/**
 *
 * @author nittos
 */
public class Conexion {

    Connection con = null;

    String base = "proyectos_investigacion";
    String url = "jdbc:postgresql://localhost:5432/" + base;
    String user = "administrador";
    String password = "admin_password";

    public Connection getConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}

