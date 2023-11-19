package Controlador;

import Modelo.Consulta_Datos_Egreso;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Datos_Egreso;
import Vista.Ventana_Egreso;
import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Registrar_Egreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlDatos_Egreso implements ActionListener {

    private final Datos_Egreso modelo;
    private final int usuario_id;
    private final Consulta_Obtener_Suma_Ingresos consultaSumaIngresos;
    private final Consulta_Obtener_Suma_Egresos consultaSumaEgresos;
    private final Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados;
    private final Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado;
    private final Consulta_Obtener_Dinero_Inversion consultaDineroInversion;
    private final Consulta_Datos_Egreso consultas;
    private final Ventana_Registrar_Egreso vista;

    public CtrlDatos_Egreso(Datos_Egreso modelo, int usuario_id, Consulta_Obtener_Suma_Ingresos consultaSumaIngresos, Consulta_Obtener_Suma_Egresos consultaSumaEgresos, Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados, Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado, Consulta_Obtener_Dinero_Inversion consultaDineroInversion, Consulta_Datos_Egreso consultas, Ventana_Registrar_Egreso vista) {
        this.modelo = modelo;
        this.usuario_id = usuario_id;
        this.consultaSumaIngresos = consultaSumaIngresos;
        this.consultaSumaEgresos = consultaSumaEgresos;
        this.consultaSumaRecursosAsignados = consultaSumaRecursosAsignados;
        this.consultaDineroAhorrado = consultaDineroAhorrado;
        this.consultaDineroInversion = consultaDineroInversion;
        this.consultas = consultas;
        this.vista = vista;

        //Botones
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnAtras.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Registrar Egreso");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistrar) {

            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
            double obtenerDineroInversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);
            
            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado - obtenerDineroInversion;

            Double monto_egreso = Double.valueOf(vista.txtMONTO_EGRESO.getText());

            if (saldo_disponible >= monto_egreso) {

                if (monto_egreso <= 0) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de monto. El monto debe ser mayor que cero.");
                    limpiar();
                    return; // Salir del método actionPerformed si el monto es menor o igual a cero.
                } else {
                    modelo.setMONTO_EGRESO(Double.valueOf(vista.txtMONTO_EGRESO.getText()));
                }

                try {
                    String fechaTexto = vista.txtFECHA_EGRESO.getText();
                    java.sql.Date fechaEgreso = java.sql.Date.valueOf(fechaTexto);
                    modelo.setFECHA_EGRESO(fechaEgreso);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de fecha");
                    limpiar();
                    return; // Salir del método actionPerformed si hay un error de formato de fecha.
                }

                String tipoEgresoSeleccionado = (String) vista.ComboBoxTIPO_EGRESO.getSelectedItem();

                if ("Gastos Varios".equals(tipoEgresoSeleccionado)) {
                    // Si se selecciona "Gastos Varios", mostrar un JOptionPane para ingresar una cadena adicional
                    String cadenaAdicional = JOptionPane.showInputDialog(null, "Escriba de que tipo fue el egreso:");

                    // Comprobar si el usuario ingresó una cadena antes de asignarla al modelo
                    if (cadenaAdicional != null) {
                        modelo.setTIPO_EGRESO("Gastos Varios - " + cadenaAdicional);
                    }
                } else {
                    // Para otras selecciones, simplemente asignar el valor seleccionado al modelo
                    modelo.setTIPO_EGRESO(tipoEgresoSeleccionado);
                }

                if (consultas.registrar(modelo, usuario_id)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene ingresos suficientes para realizar este egreso");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnAtras) {

            vista.dispose();
            Ventana_Egreso frm_egreso = new Ventana_Egreso();
            CtrlMenu_Egreso ctrlmenu_egreso = new CtrlMenu_Egreso(frm_egreso);
            ctrlmenu_egreso.iniciar();
            frm_egreso.setVisible(true);;

        }

    }

    public void limpiar() {
        vista.txtMONTO_EGRESO.setText(null);
        vista.txtFECHA_EGRESO.setText(null);
        vista.ComboBoxTIPO_EGRESO.setSelectedItem(null);

    }

}
