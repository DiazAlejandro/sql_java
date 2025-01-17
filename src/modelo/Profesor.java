/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author nittos
 */
public class Profesor {
    private String dni_profesor;
    private String nombre;
    private String apellidos;
    private String titulo ;
    private int experiencia;

    public Profesor(String dni_profesor, String nombre, String apellidos, String titulo, int experiencia) {
        this.dni_profesor = dni_profesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.titulo = titulo;
        this.experiencia = experiencia;
    }

    public Profesor() {

    }

    public String getDni_profesor() {
        return dni_profesor;
    }

    public void setDni_profesor(String dni_profesor) {
        this.dni_profesor = dni_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Profesor{" + "dni_profesor=" + dni_profesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", titulo=" + titulo + ", experiencia=" + experiencia + '}';
    }
    
    
}
