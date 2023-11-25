package Controlador;

import Modelo.Consulta_Categoria_Ingreso_Insert;
import Modelo.Consulta_Familia_Insert;
import Modelo.Consulta_Limites_Fechas;
import Modelo.Consulta_Nombre_Ventana_Saldo;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Consulta_Tipo_Servicio_Insert;
import Modelo.Datos_Categoria_Ingreso;
import Modelo.Datos_Egreso;
import Modelo.Datos_Familia;
import Modelo.Datos_Ingreso;
import Modelo.Datos_Tipo_Servicio;
import Vista.Ventana_Configurar_Perfil;
import Vista.Ventana_ConsultaSaldo;
import Vista.Ventana_Egreso;
import Vista.Ventana_Estado_Cuenta;
import Vista.Ventana_Gestionar_Recursos;
import Vista.Ventana_Ingreso;
import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Metas;
import Vista.Ventana_Opciones;
import Vista.Ventana_Opciones_Recordatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlMenu_Opciones implements ActionListener {

    private final Ventana_Opciones vista;

    public CtrlMenu_Opciones(Ventana_Opciones vista) {
        this.vista = vista;
        this.vista.btnIngreso.addActionListener(this);
        this.vista.btnEgreso.addActionListener(this);
        this.vista.btnSaldoActual.addActionListener(this);
        this.vista.btnCambiarUsuario.addActionListener(this);
        this.vista.btnGestionar.addActionListener(this);
        this.vista.btnConfigurarPerfil.addActionListener(this);
        this.vista.btnReporte.addActionListener(this);
        this.vista.btnRecordatorios.addActionListener(this);

    }

    public void iniciar() {
        vista.setTitle("Opciones");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnIngreso) {

            vista.dispose();
            Ventana_Ingreso frm_ingreso = new Ventana_Ingreso();
            CtrlMenu_Ingreso ctrlmenu_ingreso = new CtrlMenu_Ingreso(frm_ingreso);
            ctrlmenu_ingreso.iniciar();
            frm_ingreso.setVisible(true);
            usuario_id = Ventana_Login.getUsuarioId();
            System.out.println("2: " + usuario_id);

        }

        if (e.getSource() == vista.btnEgreso) {

            vista.dispose();
            Ventana_Egreso frm_egreso = new Ventana_Egreso();
            CtrlMenu_Egreso ctrlmenu_egreso = new CtrlMenu_Egreso(frm_egreso);
            ctrlmenu_egreso.iniciar();
            frm_egreso.setVisible(true);

        }

        if (e.getSource() == vista.btnSaldoActual) {

            vista.dispose();

            Datos_Egreso mod_egreso = new Datos_Egreso();
            Datos_Ingreso mod_ingreso = new Datos_Ingreso();
            Consulta_Obtener_Suma_Ingresos modC_consulta_suma_ingreso = new Consulta_Obtener_Suma_Ingresos();
            Consulta_Obtener_Suma_Egresos modC_consulta_suma_egreso = new Consulta_Obtener_Suma_Egresos();
            Consulta_Obtener_Suma_Recursos_Asignados_Metas modC_consulta_suma_recursos_asignados = new Consulta_Obtener_Suma_Recursos_Asignados_Metas();
            Consulta_Obtener_Dinero_Ahorrado dineroAhorrado = new Consulta_Obtener_Dinero_Ahorrado();
            Consulta_Obtener_Dinero_Inversion dineroInversion = new Consulta_Obtener_Dinero_Inversion();
            Consulta_Nombre_Ventana_Saldo modC_consulta_nombre = new Consulta_Nombre_Ventana_Saldo();
            Ventana_ConsultaSaldo frm_consulta_saldo = new Ventana_ConsultaSaldo();

            CtrlVentana_Saldo ctrl_ventana_saldo = new CtrlVentana_Saldo(
                    mod_egreso,
                    mod_ingreso,
                    modC_consulta_suma_ingreso,
                    modC_consulta_suma_egreso,
                    modC_consulta_suma_recursos_asignados,
                    dineroAhorrado,
                    dineroInversion,
                    modC_consulta_nombre,
                    frm_consulta_saldo);

            ctrl_ventana_saldo.iniciar();
            frm_consulta_saldo.setVisible(true);

        }

        if (e.getSource() == vista.btnCambiarUsuario) {

            vista.dispose();
            Ventana_Login frm_ventana_login = new Ventana_Login();
            frm_ventana_login.setVisible(true);

        }

        if (e.getSource() == vista.btnGestionar) {

            vista.dispose();
            Ventana_Gestionar_Recursos frm_gestionar_recursos = new Ventana_Gestionar_Recursos();

            frm_gestionar_recursos.setVisible(true);

        }

        if (e.getSource() == vista.btnConfigurarPerfil) {

            vista.dispose();
            Datos_Categoria_Ingreso datos_categoria_Ingreso = new Datos_Categoria_Ingreso();
            Consulta_Categoria_Ingreso_Insert consulta_datos_categoria_Ingreso = new Consulta_Categoria_Ingreso_Insert();
            Ventana_Configurar_Perfil frm_configurar_perfil = new Ventana_Configurar_Perfil();
            Consulta_Nombre_Ventana_Saldo consulta_nombre_ventana_saldo = new Consulta_Nombre_Ventana_Saldo();
            Datos_Familia dfamilia = new Datos_Familia();
            Consulta_Familia_Insert cfamilia = new Consulta_Familia_Insert();
            Datos_Tipo_Servicio dservicios = new Datos_Tipo_Servicio();
            Consulta_Tipo_Servicio_Insert cservicios = new Consulta_Tipo_Servicio_Insert();
            Ctrl_Configurar_Perfil ctrl_configurar_perfil = new Ctrl_Configurar_Perfil(datos_categoria_Ingreso,
                    consulta_datos_categoria_Ingreso,
                    dfamilia,
                    cfamilia,
                    dservicios,
                    cservicios,
                    frm_configurar_perfil,
                    usuario_id,
                    consulta_nombre_ventana_saldo);
            ctrl_configurar_perfil.iniciar();
            frm_configurar_perfil.setVisible(true);

        }

        if (e.getSource() == vista.btnReporte) {

            vista.dispose();
            Ventana_Estado_Cuenta frm_estado_cuenta = new Ventana_Estado_Cuenta();
            Consulta_Limites_Fechas consulta_limites_fechas = new Consulta_Limites_Fechas();
            CtrlVentana_Estado_Cuenta ctrl_estado_cuenta = new CtrlVentana_Estado_Cuenta(frm_estado_cuenta, consulta_limites_fechas, usuario_id);
            ctrl_estado_cuenta.iniciar();
            frm_estado_cuenta.setVisible(true);

        }

        if (e.getSource() == vista.btnRecordatorios) {

            vista.dispose();
            Ventana_Opciones_Recordatorio opciones_Recordatorio = new Ventana_Opciones_Recordatorio();
            opciones_Recordatorio.setVisible(true);

        }

    }

}
