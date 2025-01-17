/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nittos
 */
public class ConsultasProfesor extends Conexion {

    public boolean registrar(Profesor profesor) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO profesor (dni_profesor, nombre, apellidos, titulo, experiencia) VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, profesor.getDni_profesor());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getApellidos());
            ps.setString(4, profesor.getTitulo());
            ps.setInt(5, profesor.getExperiencia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public Profesor buscar(Profesor profesor) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM profesor WHERE dni_profesor LIKE ? ";
        System.out.println("SQL" + sql);
        try {
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, "%" + profesor.getDni_profesor() + "%");
            rs = ps.executeQuery();

            if (rs.next()) {
                profesor.setDni_profesor(rs.getString("dni_profesor"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellidos(rs.getString("apellidos"));
                profesor.setTitulo(rs.getString("titulo"));
                profesor.setExperiencia(Integer.parseInt(rs.getString("experiencia")));
                return profesor;
            }
            return null;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Profesor profesor) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE profesor SET nombre=?, apellidos=?, titulo=?, experiencia = ? WHERE dni_profesor = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellidos());
            ps.setString(3, profesor.getTitulo());
            ps.setInt(4, profesor.getExperiencia());
            ps.setString(5, profesor.getDni_profesor());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Profesor profesor) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM profesor WHERE dni_profesor = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, profesor.getDni_profesor());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public ArrayList<Profesor> listarTodos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM profesor";
        
        ArrayList<Profesor> lista = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profesor p = new Profesor();
                p.setDni_profesor(rs.getString("dni_profesor"));
                p.setNombre(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellidos"));
                p.setTitulo(rs.getString("titulo"));
                p.setExperiencia(rs.getInt("experiencia"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return lista;
    }
}
