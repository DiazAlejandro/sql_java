/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasProfesor;
import modelo.Profesor;
import vista.FormProfesor;

/**
 *
 * @author nittos
 */
public class CtrlProfesor implements ActionListener {

    private final Profesor modelo;
    private final ConsultasProfesor consultas;
    private final FormProfesor vista;

    public CtrlProfesor(Profesor modelo, ConsultasProfesor consultas, FormProfesor vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBorrar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);

        this.vista.tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaSeleccionada = vista.tabla.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String dni = vista.tabla.getValueAt(filaSeleccionada, 0).toString();
                    String nombre = vista.tabla.getValueAt(filaSeleccionada, 1).toString();
                    String apellidos = vista.tabla.getValueAt(filaSeleccionada, 2).toString();
                    String titulo = vista.tabla.getValueAt(filaSeleccionada, 3).toString();
                    String experiencia = vista.tabla.getValueAt(filaSeleccionada, 4).toString();

                    // Asignar a los campos de texto
                    vista.txtDni.setText(dni);
                    vista.txtNombre.setText(nombre);
                    vista.txtApellidos.setText(apellidos);
                    vista.cmbTitulo.setSelectedItem(titulo);
                    vista.txtExperiencia.setText(experiencia);
                }
            }
        });
    }

    public void mostrarTodosLosProfesores() {
        ArrayList<Profesor> lista = consultas.listarTodos();
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tabla.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla
        for (Profesor profesor : lista) {
            modeloTabla.addRow(new Object[]{
                profesor.getDni_profesor(),
                profesor.getNombre(),
                profesor.getApellidos(),
                profesor.getTitulo(),
                profesor.getExperiencia()
            });
        }
    }

    public void iniciar() {
        vista.setTitle("Profesores");
        vista.setLocationRelativeTo(null);
        mostrarTodosLosProfesores();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            modelo.setDni_profesor(vista.txtDni.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setApellidos(vista.txtApellidos.getText());
            modelo.setTitulo(vista.cmbTitulo.getSelectedItem().toString());
            modelo.setExperiencia(Integer.parseInt(vista.txtExperiencia.getText()));

            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnActualizar) {
            modelo.setDni_profesor(vista.txtDni.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setApellidos(vista.txtApellidos.getText());
            modelo.setTitulo(vista.cmbTitulo.getSelectedItem().toString());
            modelo.setExperiencia(Integer.parseInt(vista.txtExperiencia.getText()));

            if (consultas.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            modelo.setDni_profesor(vista.txtDni.getText());
            Profesor p = consultas.buscar(modelo);
            if (p != null) {
                vista.txtDni.setText(p.getDni_profesor());
                vista.txtApellidos.setText(p.getApellidos());
                vista.txtNombre.setText(p.getNombre());
                vista.txtExperiencia.setText(p.getExperiencia() + "");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBorrar) {
            modelo.setDni_profesor(modelo.getDni_profesor());

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtDni.setText(null);
        vista.txtExperiencia.setText(null);
        vista.txtNombre.setText(null);
        vista.txtNombre.setText(null);
        vista.txtApellidos.setText(null);
        mostrarTodosLosProfesores();

    }
}
