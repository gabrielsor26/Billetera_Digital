package Controlador;

import Modelo.Consulta_Datos_Recordatorio;
import Modelo.Consulta_Email_Notificacion;
import Modelo.Consulta_Tipo_Servicio_Select;
import Modelo.Datos_Recordatorio;
import Modelo.Datos_Tipo_Servicio;
import Vista.Ventana_Crear_Recordatorio;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Ctrl_Crear_Recordatorio implements MouseListener {

    private final Datos_Recordatorio modelo;
    private final Consulta_Datos_Recordatorio consulta;
    private final Consulta_Email_Notificacion consultaEmail;
    private final Ventana_Crear_Recordatorio vista;
    private final int usuario_id;

    public Ctrl_Crear_Recordatorio(Datos_Recordatorio modelo, Consulta_Datos_Recordatorio consulta, Consulta_Email_Notificacion consultaEmail, Ventana_Crear_Recordatorio vista, int usuario_id) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.consultaEmail = consultaEmail;
        this.vista = vista;
        this.usuario_id = usuario_id;

        //Botones
        this.vista.txtCrearRecordatorio.addMouseListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        llenarPrioridad();
        llenarTipoServicio();

        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        vista.jDateChooser.setDate(date);

    }

    public void llenarPrioridad() {

        ArrayList<String> listaPrioridades = new ArrayList<>();

        Datos_Recordatorio.PrioridadEnum[] prioridades = Datos_Recordatorio.PrioridadEnum.values();

        for (Datos_Recordatorio.PrioridadEnum prioridad : prioridades) {
            listaPrioridades.add(prioridad.toString());
        }

        vista.cbxPrioridad.removeAllItems();

        for (int i = 0; i < listaPrioridades.size(); i++) {

            vista.cbxPrioridad.addItem(listaPrioridades.get(i));

        }

        System.out.println(listaPrioridades);

    }

    public void llenarTipoServicio() {

        Consulta_Tipo_Servicio_Select consulta_tipo_servicio_select = new Consulta_Tipo_Servicio_Select();
        ArrayList<Datos_Tipo_Servicio> listaDatos_Tipo_Servicio = consulta_tipo_servicio_select.getDatos_Tipo_Servicio();

        vista.cbxTipoServicio.removeAllItems();

        for (int i = 0; i < listaDatos_Tipo_Servicio.size(); i++) {

            vista.cbxTipoServicio.addItem(new Datos_Tipo_Servicio(listaDatos_Tipo_Servicio.get(i).getID_SERVICIO(), listaDatos_Tipo_Servicio.get(i).getTIPO_SERVICIO()));

        }

    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.txtCrearRecordatorio) {
            try {
                //MONTO
                double monto = Double.parseDouble(vista.txtMonto.getText());
                if (monto <= 0) {
                    mostrarError("El monto debe ser mayor que cero.");
                } else {
                    modelo.setMONTO(monto);
                }
                System.out.println(monto);
                // FECHA
                Date fechaSeleccionada = vista.jDateChooser.getDate();
                java.sql.Date fechaIngreso = new java.sql.Date(fechaSeleccionada.getTime());
                modelo.setFECHA(fechaIngreso);
                //TIPO_SERVICIO
                Datos_Tipo_Servicio tipo_servicio_seleccionado = (Datos_Tipo_Servicio) vista.cbxTipoServicio.getSelectedItem();
                modelo.setTIPO_SERVICIO(tipo_servicio_seleccionado.getTIPO_SERVICIO());

                //PRIORIDAD
                String prioridad_seleccionada = (String) vista.cbxPrioridad.getSelectedItem();
                modelo.setPRIORIDAD(Datos_Recordatorio.PrioridadEnum.valueOf(prioridad_seleccionada));

                //ESTADO
                Datos_Recordatorio.EstadoEnum estado_seleccionado = Datos_Recordatorio.EstadoEnum.PENDIENTE;
                modelo.setESTADO(estado_seleccionado);

                if (consulta.registrar(modelo, usuario_id)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");

                    String tipo_servicio = tipo_servicio_seleccionado.getTIPO_SERVICIO();
                    Date fecha = vista.jDateChooser.getDate();
                    java.sql.Date fechita = new java.sql.Date(fechaSeleccionada.getTime());
                    Double montorecordatorio = Double.valueOf(vista.txtMonto.getText());

                    enviarmail(tipo_servicio, fechita, montorecordatorio);
                    java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
                    vista.jDateChooser.setForeground(new Color(255, 113, 17));
                    vista.jDateChooser.setDate(date);

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

    public void enviarmail(String tipo_servicio, java.sql.Date fecha, Double montorecordatorio) {
        String remitente = "gabrielsortestersor@gmail.com";
        String clave = "qdfc diak skwx gceu";
        String destino = "" + consultaEmail.obtenerEmailUsuario(usuario_id);
        String asunto = "RECORDATORIO DE PAGO PROGRAMADO";
        String cuerpo = "<h5>Buen D\u00eda Estimado usuario</h5>"
                + "<br> se ha programado con exito su recordatorio de pago, a continuación el detalle: </br>"
                + "<p>"
                + "<br>Recordatorio para Pagar: " + tipo_servicio + "</br>"
                + "<br>Fecha a Pagar: " + fecha + "</br>"
                + "<br>Monto a Pagar: " + montorecordatorio + "</br>"
                + "</p>"
                + "<p>"
                + "<br>Saludos Cordiales </br>"
                + "Equipo Recordatorios de Pagos"
                + "</p>";

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
            mensaje.setText(cuerpo, "ISO-8859-1", "html");
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

}
