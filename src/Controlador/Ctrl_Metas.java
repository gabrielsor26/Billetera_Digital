/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consulta_Datos_Egreso;
import Modelo.Consulta_Datos_Metas;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Datos_Egreso;
import Modelo.Datos_Metas;
import Vista.Ventana_Asignar_Recursos;
import Vista.Ventana_Crear_Metas;
import Vista.Ventana_Gestionar_Recursos;
import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Metas;
import Vista.Ventana_Opciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class Ctrl_Metas implements ActionListener {

    private final Ventana_Metas vista;

    public Ctrl_Metas(Ventana_Metas vista) {
        this.vista = vista;
        this.vista.btnCrearMeta.addActionListener(this);
        this.vista.btnAsignarRecursos.addActionListener(this);
        this.vista.btnAtras.addActionListener(this);

    }

    public void iniciar() {
        vista.setTitle("Metas");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnCrearMeta) {

            vista.dispose();
            Datos_Metas datos_metas = new Datos_Metas();
            Ventana_Crear_Metas frm_crear_metas = new Ventana_Crear_Metas();

            Consulta_Datos_Metas consulta_datos_metas = new Consulta_Datos_Metas();
            usuario_id = Ventana_Login.usuario_id;

            Ctrl_Crear_Metas ctrl_crear_metas = new Ctrl_Crear_Metas(datos_metas, frm_crear_metas, consulta_datos_metas, usuario_id);

            ctrl_crear_metas.iniciar();
            frm_crear_metas.setVisible(true);

        }

        if (e.getSource() == vista.btnAsignarRecursos) {

            vista.dispose();
            Datos_Egreso mod_egreso = new Datos_Egreso();
            Consulta_Datos_Egreso modC_egreso = new Consulta_Datos_Egreso();
            Ventana_Asignar_Recursos frm_asignar_recursos = new Ventana_Asignar_Recursos();
            Consulta_Obtener_Suma_Ingresos consulta_obtener_suma_ingreso = new Consulta_Obtener_Suma_Ingresos();
            Consulta_Obtener_Suma_Egresos consulta_obtener_suma_egreso = new Consulta_Obtener_Suma_Egresos();
            Consulta_Obtener_Suma_Recursos_Asignados_Metas consulta_obtener_suma_recursos_asignados = new Consulta_Obtener_Suma_Recursos_Asignados_Metas();
            Ctrl_Asignar_Recursos_Metas ctrl_asignar_recursos_meta = new Ctrl_Asignar_Recursos_Metas(
                    mod_egreso,
                    modC_egreso,
                    frm_asignar_recursos,
                    consulta_obtener_suma_ingreso,
                    consulta_obtener_suma_egreso,
                    consulta_obtener_suma_recursos_asignados,
                    usuario_id);

            ctrl_asignar_recursos_meta.iniciar();
            frm_asignar_recursos.setVisible(true);

        }

        if (e.getSource() == vista.btnAtras) {

            vista.dispose();
            Ventana_Gestionar_Recursos frm_gestionar_recursos = new Ventana_Gestionar_Recursos();

            frm_gestionar_recursos.setVisible(true);

        }

    }

}
