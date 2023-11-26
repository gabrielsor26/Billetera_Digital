package Controlador;

import Modelo.Consulta_Categoria_Ingreso_Select;
import Modelo.Consulta_Datos_Ingreso;
import Modelo.Consulta_Email_Notificacion;
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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class CtrlDatos_Ingreso implements MouseListener, ItemListener {

    private final Datos_Ingreso modelo;
    private final int usuario_id;
    private final Consulta_Datos_Ingreso consultas;
    private final Consulta_Email_Notificacion consultaEmail;
    private final Ventana_Registrar_Ingreso vista;

    public CtrlDatos_Ingreso(Datos_Ingreso modelo, int usuario_id, Consulta_Datos_Ingreso consultas, Consulta_Email_Notificacion consultaEmail, Ventana_Registrar_Ingreso vista) {
        this.modelo = modelo;
        this.usuario_id = usuario_id;
        this.consultas = consultas;
        this.consultaEmail = consultaEmail;
        this.vista = vista;
        //Botones
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
                if (monto_ingreso <= 0 || monto_ingreso > 10000) {
                    mostrarError("El monto debe ser mayor que cero y no debe ser mayor a 10000.");
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

                    System.out.println(modelo);

                    Datos_Ingreso cuerpoDatosIngreso = modelo;

                    enviarmail(cuerpoDatosIngreso);

                    limpiar();
                    java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
                    vista.txtFECHA_INGRESO.setForeground(new Color(255, 113, 17));
                    vista.txtFECHA_INGRESO.setText(String.valueOf(date));
                } else {
                    mostrarError("Error al Guardar");
                }
            } catch (NumberFormatException ex) {
                mostrarError("Error en el formato de monto.");
            } catch (IllegalArgumentException ex) {
                mostrarError("Error en el formato de fecha.");
            }
        }

    }

    public void enviarmail(Datos_Ingreso cuerpoDatosIngreso) {
        String remitente = "gabrielsortestersor@gmail.com";
        String clave = "qdfc diak skwx gceu";
        String destino = "" + consultaEmail.obtenerEmailUsuario(usuario_id);
        String asunto = "INGRESO REGISTRADO";
        String cuerpo = "Buenas, acaba de registrarse un ingreso\n\n"
                + "Con los siguientes datos\n"
                + cuerpoDatosIngreso;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);

        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session);

        try {
            mensaje.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "Correo Enviado");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
