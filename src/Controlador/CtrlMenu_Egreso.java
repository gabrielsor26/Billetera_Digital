package Controlador;

import Modelo.Consulta_Datos_Egreso;
import Modelo.Consulta_Email_Notificacion;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Datos_Egreso;
import Vista.Ventana_Categorizar_Egreso;
import Vista.Ventana_Egreso;
import Vista.Ventana_Historial_Egreso;
import Vista.Ventana_Historial_Ingreso;
import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Opciones;
import Vista.Ventana_Registrar_Egreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlMenu_Egreso implements ActionListener {

    private final Ventana_Egreso vista;

    public CtrlMenu_Egreso(Ventana_Egreso vista) {
        this.vista = vista;
        this.vista.btnRegistrarEgreso.addActionListener(this);
        this.vista.btnConsultarHistorial.addActionListener(this);
        this.vista.btnCategorizarEgreso.addActionListener(this);

    }

    public void iniciar() {
        vista.setTitle("Egreso");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistrarEgreso) {

            vista.dispose();

            Datos_Egreso mod_egreso = new Datos_Egreso();

            usuario_id = Ventana_Login.usuario_id;

            Consulta_Obtener_Suma_Ingresos modC_sumaingreso = new Consulta_Obtener_Suma_Ingresos();

            Consulta_Obtener_Suma_Egresos modC_sumaegreso = new Consulta_Obtener_Suma_Egresos();

            Consulta_Datos_Egreso modC_egreso = new Consulta_Datos_Egreso();

            Consulta_Obtener_Suma_Recursos_Asignados_Metas modC_consulta_suma_recursos_asignados = new Consulta_Obtener_Suma_Recursos_Asignados_Metas();

            Consulta_Obtener_Dinero_Ahorrado consulta_obtener_dinero_ahorrado = new Consulta_Obtener_Dinero_Ahorrado();
            Consulta_Obtener_Dinero_Inversion consulta_obtener_dinero_inversion = new Consulta_Obtener_Dinero_Inversion();

            Consulta_Email_Notificacion email = new Consulta_Email_Notificacion();

            Ventana_Registrar_Egreso frm_registar_egreso = new Ventana_Registrar_Egreso();

            CtrlDatos_Egreso ctrl_datos_egreso = new CtrlDatos_Egreso(mod_egreso,
                    usuario_id,
                    modC_sumaingreso,
                    modC_sumaegreso,
                    modC_consulta_suma_recursos_asignados,
                    consulta_obtener_dinero_ahorrado,
                    consulta_obtener_dinero_inversion,
                    modC_egreso,
                    email,
                    frm_registar_egreso);
            ctrl_datos_egreso.iniciar();
            frm_registar_egreso.setVisible(true);

        }

        if (e.getSource() == vista.btnConsultarHistorial) {

            vista.dispose();
            Ventana_Historial_Egreso frm_historial_egreso = new Ventana_Historial_Egreso();
            frm_historial_egreso.setVisible(true);

        }

        if (e.getSource() == vista.btnCategorizarEgreso) {

            vista.dispose();
            Ventana_Categorizar_Egreso frm_categorizar_egreso = new Ventana_Categorizar_Egreso();
            frm_categorizar_egreso.setVisible(true);

        }

    }
}
