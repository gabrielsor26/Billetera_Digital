/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consulta_Datos_Metas;
import Modelo.Datos_Metas;
import Vista.Ventana_Crear_Metas;
import Vista.Ventana_Metas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Ctrl_Crear_Metas implements ActionListener {

    private final Datos_Metas modelo;
    private final Ventana_Crear_Metas vista;
    private final Consulta_Datos_Metas consultas;
    private final int usuario_id;

    public Ctrl_Crear_Metas(Datos_Metas modelo,
            Ventana_Crear_Metas vista,
            Consulta_Datos_Metas consultas,
            int usuario_id) {

        this.modelo = modelo;
        this.vista = vista;
        this.consultas = consultas;
        this.usuario_id = usuario_id;
        this.vista.btnCrearMeta.addActionListener(this);
        this.vista.btnAtras.addActionListener(this);

    }

    public void iniciar() {
        vista.setTitle("Crear Metas");
        vista.setLocationRelativeTo(null);
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        vista.jDateChooser.setDate(date);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnCrearMeta) {
            
            //Settear Nombre
            modelo.setNOMBRE_META(vista.txtNombreMeta.getText());

            //Settear Monto
            modelo.setMONTO_META(Double.valueOf(vista.txtMontoMeta.getText()));
            
            //Setter Fecha
            // FECHA
                Date fechaSeleccionada = vista.jDateChooser.getDate();
                java.sql.Date fechaEgreso = new java.sql.Date(fechaSeleccionada.getTime());

                modelo.setFECHA_LIMITE_META(fechaEgreso);

            //Registrar
            if (consultas.registrar(modelo, usuario_id)) {
                JOptionPane.showMessageDialog(null, "Meta Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar Meta");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnAtras) {

            vista.dispose();
            Ventana_Metas frm_metas = new Ventana_Metas();

            Ctrl_Metas ctrl_metas = new Ctrl_Metas(frm_metas);

            ctrl_metas.iniciar();
            frm_metas.setVisible(true);
        }

    }

    public void limpiar() {
        vista.txtNombreMeta.setText(null);
        vista.txtMontoMeta.setText(null);

    }

}
