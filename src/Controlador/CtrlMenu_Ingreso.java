
package Controlador;

import Modelo.Consulta_Datos_Ingreso;
import Modelo.Datos_Ingreso;
import Vista.Ventana_Historial_Ingreso;
import Vista.Ventana_Ingreso;
import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Opciones;
import Vista.Ventana_Registrar_Ingreso;
import Vista.Ventana_Registrar_Ingreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrlMenu_Ingreso implements ActionListener{

    private final Ventana_Ingreso vista;

    public CtrlMenu_Ingreso(Ventana_Ingreso vista) {
        this.vista = vista;
        this.vista.btnRegistrarIngreso.addActionListener(this);
        this.vista.btnAtras.addActionListener(this);
        this.vista.btnConsultarHistorial.addActionListener(this);

    }

    public void iniciar() {
        vista.setTitle("Ingreso");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistrarIngreso) {
            
            vista.dispose();
          
            Datos_Ingreso mod_ingreso = new Datos_Ingreso();
            
            usuario_id = Ventana_Login.usuario_id;
            System.out.println("3: " + usuario_id);
            
            Consulta_Datos_Ingreso modC_ingreso = new Consulta_Datos_Ingreso();

            Ventana_Registrar_Ingreso frm_registar_ingreso_new = new Ventana_Registrar_Ingreso();
            
            
            
            CtrlDatos_Ingreso ctrl_datos_ingreso = new CtrlDatos_Ingreso(mod_ingreso, usuario_id, modC_ingreso, frm_registar_ingreso_new);
            
            ctrl_datos_ingreso.iniciar();
            frm_registar_ingreso_new.setVisible(true);

        }
        
        //btnConsultarHistorial
        if (e.getSource() == vista.btnConsultarHistorial) {
            
            vista.dispose();
            
            Ventana_Historial_Ingreso frm_historial_ingreso = new Ventana_Historial_Ingreso();
            frm_historial_ingreso.setVisible(true);

        }
        
        
        
        if (e.getSource() == vista.btnAtras) {
            
            vista.dispose();
            
            Ventana_Opciones frm_opciones = new Ventana_Opciones();
            
            CtrlMenu_Opciones ctrlmenu_opciones = new CtrlMenu_Opciones(frm_opciones);
            
            ctrlmenu_opciones.iniciar();
            frm_opciones.setVisible(true);

        } 

    }
    
    
    
}
