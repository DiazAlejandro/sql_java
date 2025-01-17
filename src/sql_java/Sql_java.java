/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sql_java;

import controlador.CtrlProfesor;
import modelo.ConsultasProfesor;
import modelo.Profesor;
import vista.FormProfesor;

/**
 *
 * @author nittos
 */
public class Sql_java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Profesor mod = new Profesor();
        ConsultasProfesor modC = new ConsultasProfesor();
        FormProfesor frm = new FormProfesor();

        CtrlProfesor ctrl = new CtrlProfesor(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
