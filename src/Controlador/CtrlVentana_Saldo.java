/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consulta_Nombre_Ventana_Saldo;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Datos_Egreso;
import Modelo.Datos_Ingreso;
import Vista.Ventana_ConsultaSaldo;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Login;
import Vista.Ventana_Opciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class CtrlVentana_Saldo implements ActionListener {

    private final Datos_Egreso modeloEgreso;
    private final Datos_Ingreso modeloIngreso;
    private final Consulta_Obtener_Suma_Ingresos consultaSumaIngresos;
    private final Consulta_Obtener_Suma_Egresos consultaSumaEgresos;
    private final Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados;
    private final Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado;
    private final Consulta_Obtener_Dinero_Inversion consultaDineroInversion;
    private final Consulta_Nombre_Ventana_Saldo consultaNombre;
    private final Ventana_ConsultaSaldo vista;

    public CtrlVentana_Saldo(Datos_Egreso modeloEgreso,
            Datos_Ingreso modeloIngreso,
            Consulta_Obtener_Suma_Ingresos consultaSumaIngresos,
            Consulta_Obtener_Suma_Egresos consultaSumaEgresos,
            Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados,
            Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado,
            Consulta_Obtener_Dinero_Inversion consultaDineroInversion,
            Consulta_Nombre_Ventana_Saldo consultaNombre,
            Ventana_ConsultaSaldo vista) {
        this.modeloEgreso = modeloEgreso;
        this.modeloIngreso = modeloIngreso;
        this.consultaSumaIngresos = consultaSumaIngresos;
        this.consultaSumaEgresos = consultaSumaEgresos;
        this.consultaSumaRecursosAsignados = consultaSumaRecursosAsignados;
        this.consultaDineroAhorrado = consultaDineroAhorrado;
        this.consultaDineroInversion = consultaDineroInversion;
        this.consultaNombre = consultaNombre;
        this.vista = vista;
        this.vista.btnAtras.addActionListener(this);
    }

    public void iniciar() {
        //usuario_id = Ventana_Login.usuario_id;

        double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
        double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
        double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
        double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
        double obtenerDineroInversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);
        double saldototal = 0;
        double saldodisponible = 0;
        double saldodestinadometas = 0;
        double saldodestinadoahorros = 0;
        double saldodestinadoinversion = 0;
        
        //SaldoTotal
        saldototal = sumaIngresos - sumaEgresos;
        vista.jLabelMontoSaldoTotal.setText("Saldo Total o Real: S/. " + saldototal);
        System.out.println(saldototal);

        //Saldo Disponible
        saldodisponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado - obtenerDineroInversion;
        vista.jLabelMontoSaldoDisponible.setText("Su saldo disponible es: S/. " + saldodisponible);

        //Saldo destinado para Metas        
        saldodestinadometas = sumaRecursosAsignados;
        vista.jLabelMontoSaldoDestinadoMetas1.setText("Saldo Destinado para Metas: S/. " + saldodestinadometas);
        
        //Saldo destinado para Ahorros        
        saldodestinadoahorros = obtenerDineroAhorrado;
        vista.jLabelMontoSaldoDestinadoAhorros.setText("Saldo Destinado para Ahorros: S/. " + saldodestinadoahorros);
        
        //Saldo destinado para Inversion        
        saldodestinadoahorros = obtenerDineroAhorrado;
        vista.jLabelMontoSaldoDestinadoInversion.setText("Saldo Destinado para Inversion: S/. " + saldodestinadoinversion);
        
        
        String nombre = consultaNombre.obtenerNombreUsuario(usuario_id);

        vista.jLabelNombre.setText(String.valueOf(nombre));
        vista.setTitle("Consulta Saldo");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnAtras) {

            vista.dispose();

            Ventana_Opciones frm_opciones = new Ventana_Opciones();

            CtrlMenu_Opciones ctrlmenu_opciones = new CtrlMenu_Opciones(frm_opciones);

            ctrlmenu_opciones.iniciar();
            frm_opciones.setVisible(true);

        }

    }
}
