package Controlador;

import Modelo.Consulta_Categoria_Ingreso_Select;
import Modelo.Consulta_Datos_Ingreso;
import Modelo.Datos_Categoria_Ingreso;
import Modelo.Datos_Ingreso;
import Vista.Ventana_Ingreso;
import Vista.Ventana_Registrar_Ingreso;
import Vista.Ventana_Registrar_Ingreso;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlDatos_Ingreso implements MouseListener, ItemListener {

    private final Datos_Ingreso modelo;
    private final int usuario_id;
    private final Consulta_Datos_Ingreso consultas;
    private final Ventana_Registrar_Ingreso vista;

    public CtrlDatos_Ingreso(Datos_Ingreso modelo, int usuario_id, Consulta_Datos_Ingreso consultas, Ventana_Registrar_Ingreso vista) {
        this.modelo = modelo;
        this.usuario_id = usuario_id;
        this.consultas = consultas;
        this.vista = vista;
        //this.vista.btnRegistrar.addActionListener(this);
        //this.vista.btnAtras.addActionListener(this);
        this.vista.txtRegistrarIngreso.addMouseListener(this);
        this.vista.cbxTipoIngreso.addItemListener(this);

    }

    public void iniciar() {
        vista.setTitle("Registrar Ingreso");
        vista.setLocationRelativeTo(null);
        llenarDatos_Categoria_Ingreso();

        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        vista.txtFECHA_INGRESO.setForeground(new Color(255, 113, 17));
        vista.txtFECHA_INGRESO.setText(String.valueOf(date));

    }

    public void llenarDatos_Categoria_Ingreso() {

        Consulta_Categoria_Ingreso_Select consulta_categoria_ingreso_select = new Consulta_Categoria_Ingreso_Select();
        ArrayList<Datos_Categoria_Ingreso> listaDatos_Categoria_Ingreso = consulta_categoria_ingreso_select.getDatos_Categoria_Ingreso();

        vista.cbxTipoIngreso.removeAllItems();

        vista.cbxTipoIngreso.addItem(new Datos_Categoria_Ingreso("Seleccione ..."));

        for (int i = 0; i < listaDatos_Categoria_Ingreso.size(); i++) {

            vista.cbxTipoIngreso.addItem(new Datos_Categoria_Ingreso(listaDatos_Categoria_Ingreso.get(i).getID_CATEGORIA_INGRESO(), listaDatos_Categoria_Ingreso.get(i).getTIPO_INGRESO(), listaDatos_Categoria_Ingreso.get(i).getMONTO_INGRESO_FIJO()));

        }
        vista.cbxTipoIngreso.addItem(new Datos_Categoria_Ingreso("Otros"));

        vista.cbxTipoIngreso.setSelectedItem("Seleccione ...");

    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void limpiar() {
        vista.txtMONTO_INGRESO.setText(null);
        vista.txtFECHA_INGRESO.setText(null);
        vista.cbxTipoIngreso.setSelectedItem(null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.txtRegistrarIngreso) {
            try {
                double monto_ingreso = Double.parseDouble(vista.txtMONTO_INGRESO.getText());
                if (monto_ingreso <= 0) {
                    mostrarError("El monto debe ser mayor que cero.");
                } else {
                    modelo.setMONTO_INGRESO(monto_ingreso);
                }

                String fechaTexto = vista.txtFECHA_INGRESO.getText();
                java.sql.Date fechaIngreso = java.sql.Date.valueOf(fechaTexto);
                modelo.setFECHA_INGRESO(fechaIngreso);

                Datos_Categoria_Ingreso categoriaSeleccionada = (Datos_Categoria_Ingreso) vista.cbxTipoIngreso.getSelectedItem();
                if ("Seleccione ...".equals(categoriaSeleccionada.getTIPO_INGRESO())) {
                    mostrarError("Debe seleccionar un tipo de ingreso.");
                } else if ("Otros".equals(categoriaSeleccionada.getTIPO_INGRESO())) {
                    String cadenaAdicional = JOptionPane.showInputDialog(null, "Escriba de qué tipo fue el ingreso:");
                    if (cadenaAdicional != null && !cadenaAdicional.isEmpty()) {
                        modelo.setDESCRIPCION_INGRESO("Otros - " + cadenaAdicional);
                    } else {
                        mostrarError("Debe proporcionar una descripción para el ingreso 'Otros'.");
                    }
                } else {
                    modelo.setDESCRIPCION_INGRESO(categoriaSeleccionada.getTIPO_INGRESO());
                }

                if (consultas.registrar(modelo, usuario_id)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } else {
                    mostrarError("Error al Guardar");
                }
            } catch (NumberFormatException ex) {
                mostrarError("Error en el formato de monto.");
            } catch (IllegalArgumentException ex) {
                mostrarError("Error en el formato de fecha.");
            }
        }

        /*
        if (e.getSource() == vista.cbxTipoIngreso) {
            
            String tipoIngresoSeleccionado = (String) vista.cbxTipoIngreso.getSelectedItem();
            
            System.out.println(tipoIngresoSeleccionado);
            
        }
         */
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == vista.cbxTipoIngreso) {

                Datos_Categoria_Ingreso categoriaSeleccionada = (Datos_Categoria_Ingreso) vista.cbxTipoIngreso.getSelectedItem();

                if ("Seleccione ...".equals(categoriaSeleccionada.getTIPO_INGRESO()) || "Otros".equals(categoriaSeleccionada.getTIPO_INGRESO())) {
                    vista.txtMONTO_INGRESO.setText("");
                } else {
                    Double monto_ingreso_fijo = categoriaSeleccionada.getMONTO_INGRESO_FIJO();
                    vista.txtMONTO_INGRESO.setForeground(new Color(255, 113, 17));
                    vista.txtMONTO_INGRESO.setText(String.valueOf(monto_ingreso_fijo));
                }
            }
        }
    }
}
