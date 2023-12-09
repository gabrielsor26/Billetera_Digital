package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Datos_Egreso;
import Modelo.Consulta_Email_Notificacion;
import Modelo.Consulta_Familia_Select;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Datos_Egreso;
import Modelo.Datos_Familia;
import Vista.Ventana_Egreso;
import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Registrar_Egreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class CtrlDatos_Egreso implements ActionListener {

    private final int usuario_id;
    private final Datos_Egreso modelo;
    private final Consulta_Obtener_Suma_Ingresos consultaSumaIngresos;
    private final Consulta_Obtener_Suma_Egresos consultaSumaEgresos;
    private final Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados;
    private final Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado;
    private final Consulta_Obtener_Dinero_Inversion consultaDineroInversion;
    private final Consulta_Datos_Egreso consultas;
    private final Consulta_Email_Notificacion consultaEmail;
    private final Ventana_Registrar_Egreso vista;

    public CtrlDatos_Egreso(Datos_Egreso modelo, int usuario_id, Consulta_Obtener_Suma_Ingresos consultaSumaIngresos, Consulta_Obtener_Suma_Egresos consultaSumaEgresos, Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados, Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado, Consulta_Obtener_Dinero_Inversion consultaDineroInversion, Consulta_Datos_Egreso consultas, Consulta_Email_Notificacion consultaEmail, Ventana_Registrar_Egreso vista) {
        this.modelo = modelo;
        this.usuario_id = usuario_id;
        this.consultaSumaIngresos = consultaSumaIngresos;
        this.consultaSumaEgresos = consultaSumaEgresos;
        this.consultaSumaRecursosAsignados = consultaSumaRecursosAsignados;
        this.consultaDineroAhorrado = consultaDineroAhorrado;
        this.consultaDineroInversion = consultaDineroInversion;
        this.consultas = consultas;
        this.consultaEmail = consultaEmail;
        this.vista = vista;

        //Botones
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnAtras.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Registrar Egreso");
        vista.setLocationRelativeTo(null);
        llenarDatos_Familia();
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        vista.jDateChooser.setDate(date);
    }

    public void llenarDatos_Familia() {

        Consulta_Familia_Select consulta_familia_select = new Consulta_Familia_Select();
        ArrayList<Datos_Familia> listaDatos_Familia = consulta_familia_select.getDatos_Familia();

        vista.cbxDestinoFamiliar.removeAllItems();

        vista.cbxDestinoFamiliar.addItem(new Datos_Familia("Yo"));

        for (int i = 0; i < listaDatos_Familia.size(); i++) {

            vista.cbxDestinoFamiliar.addItem(new Datos_Familia(listaDatos_Familia.get(i).getID_FAMILIA(),
                    listaDatos_Familia.get(i).getRELACION_FAMILIAR()));

        }

        vista.cbxDestinoFamiliar.setSelectedItem("Yo");

    }

    public double obtenerTotalMensualCategoria() {
        //Categoria
        String categoria = (String) vista.ComboBoxTIPO_EGRESO.getSelectedItem();
        System.out.println("HOLA2:" + categoria);
        //Fecha
        // Fecha seleccionada
        Date fechaSeleccionada = vista.jDateChooser.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaSeleccionada);

        // Limite inferior del mes
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date limiteInferior = calendar.getTime();
        java.sql.Date fechaLimiteInferior = new java.sql.Date(limiteInferior.getTime());

        // Limite superior del mes
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date limiteSuperior = calendar.getTime();
        java.sql.Date fechaLimiteSuperior = new java.sql.Date(limiteSuperior.getTime());

        System.out.println("Limite Inferior: " + fechaLimiteInferior);
        System.out.println("Limite Superior: " + fechaLimiteSuperior);

        double resultado = 0.0;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT\n"
                    + "    ? AS CATEGORIA,\n"
                    + "    SUM(MONTO_EGRESO) AS MONTO_TOTAL\n"
                    + "FROM egreso\n"
                    + "WHERE usuario_id = ?\n"
                    + "  AND FECHA_EGRESO BETWEEN ? AND ?\n"
                    + "  AND TIPO_EGRESO LIKE ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, categoria);
            ps.setInt(2, usuario_id);
            ps.setDate(3, fechaLimiteInferior);
            ps.setDate(4, fechaLimiteSuperior);
            ps.setString(5, categoria + "%");

            rs = ps.executeQuery();
            rs.next();
            resultado = rs.getDouble("MONTO_TOTAL");

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            System.out.println("ERRORCITO NO SE IMPRIME NADA");
        } finally {
            // Asegúrate de cerrar el PreparedStatement y ResultSet en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    public Integer obtenerIDFecha() {

        int resultado = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            // Obtén la fecha seleccionada
            Date fechaSeleccionada = vista.jDateChooser.getDate();

            // Convierte la fecha seleccionada a LocalDate
            LocalDate selectedDate = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Define el formato deseado en inglés
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

            // Formatea la fecha según el formato
            String formattedDate = selectedDate.format(formatter);

            // Imprime en pantalla
            System.out.println(formattedDate);

            String sql = "SELECT ID_FECHA FROM fechas WHERE MES_ANO = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, formattedDate);
            rs = ps.executeQuery();
            rs.next();

            resultado = rs.getInt(1);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            System.out.println("ERRORCITO NO SE IMPRIME NADA");
        } finally {
            // Asegúrate de cerrar el PreparedStatement y ResultSet en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;

    }

    public Double obtenerPresupuestoMensualCategoria() {
        Double resultado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //Categoria
        String categoria = (String) vista.ComboBoxTIPO_EGRESO.getSelectedItem();
        //ID_FECHA
        int id_fecha = obtenerIDFecha();

        try {
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT MONTO_PRESUPUESTO FROM presupuestos WHERE usuario_id = ? AND CATEGORIA = ? AND ID_FECHA = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setString(2, categoria);
            ps.setInt(3, id_fecha);

            rs = ps.executeQuery();
            rs.next();
            resultado = rs.getDouble("MONTO_PRESUPUESTO");

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            System.out.println("ERRORCITO NO SE IMPRIME NADA");
        } finally {
            // Asegúrate de cerrar el PreparedStatement y ResultSet en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnRegistrar) {

            int IDFecha = obtenerIDFecha();
            Double TotalMensualCategoria = obtenerTotalMensualCategoria();
            Double PresupuestoMensualCategoria = obtenerPresupuestoMensualCategoria();

            System.out.println("obtenerTotalMensualCategoria:" + TotalMensualCategoria);
            System.out.println("obtenerIDFecha:" + IDFecha);
            System.out.println("obtenerPresupuestoMensualCategoria:" + PresupuestoMensualCategoria);

            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
            double obtenerDineroInversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);

            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado - obtenerDineroInversion;

            Double monto_egreso = Double.valueOf(vista.txtMONTO_EGRESO.getText());

            if (saldo_disponible >= monto_egreso) {

                // Verificar si PresupuestoMensualCategoria es nulo o si monto_egreso + TotalMensualCategoria supera el PresupuestoMensualCategoria
                if (PresupuestoMensualCategoria == null || monto_egreso + TotalMensualCategoria > PresupuestoMensualCategoria) {
                    // Pregunta al usuario si desea continuar
                    int respuesta = JOptionPane.showConfirmDialog(null, "El monto de egreso haria que se supere el presupuesto mensual o el presupuesto no está definido. ¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (respuesta == JOptionPane.NO_OPTION) {
                        // El usuario ha elegido no continuar, puedes hacer algo aquí si es necesario
                        limpiar();
                        return; // Salir del método actionPerformed
                    }
                    // Si la respuesta es YES, continúa con la ejecución
                }

                //MONTO
                if (monto_egreso <= 0) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de monto. El monto debe ser mayor que cero.");
                    limpiar();
                    return; // Salir del método actionPerformed si el monto es menor o igual a cero.
                } else {
                    modelo.setMONTO_EGRESO(Double.valueOf(vista.txtMONTO_EGRESO.getText()));
                }
                // FECHA
                Date fechaSeleccionada = vista.jDateChooser.getDate();
                java.sql.Date fechaEgreso = new java.sql.Date(fechaSeleccionada.getTime());

                modelo.setFECHA_EGRESO(fechaEgreso);

                //TIPO DE EGRESO
                String tipoEgresoSeleccionado = (String) vista.ComboBoxTIPO_EGRESO.getSelectedItem();
                Datos_Familia destinoFamiliar = (Datos_Familia) vista.cbxDestinoFamiliar.getSelectedItem();

                if ("Seleccione . . .".equals(tipoEgresoSeleccionado)) {
                    JOptionPane.showMessageDialog(null, "Seleccione el tipo de egreso");
                    limpiar();
                    return; // Salir del método actionPerformed si no se seleccionó un tipo de egreso.
                }

                if ("Gastos Varios".equals(tipoEgresoSeleccionado)) {
                    // Si se selecciona "Gastos Varios", mostrar un JOptionPane para ingresar una cadena adicional
                    String cadenaAdicional = JOptionPane.showInputDialog(null, "Escriba de que tipo fue el egreso:");

                    // Comprobar si el usuario ingresó una cadena antes de asignarla al modelo
                    if (cadenaAdicional != null) {
                        modelo.setTIPO_EGRESO("Gastos Varios - " + cadenaAdicional + " - " + destinoFamiliar);
                    }
                } else {
                    // Para otras selecciones, simplemente asignar el valor seleccionado al modelo
                    modelo.setTIPO_EGRESO(tipoEgresoSeleccionado + " - " + destinoFamiliar);
                }

                if (consultas.registrar(modelo, usuario_id)) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas enviar la información del EGRESO a su correo", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (opcion == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Registro Guardado");

                        Datos_Egreso cuerpoDatosEgreso = modelo;

                        enviarmail(cuerpoDatosEgreso);

                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Registro Guardado sin enviar el correo");
                        limpiar();
                    }
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

    public void enviarmail(Datos_Egreso cuerpoDatosEgreso) {
        String remitente = "gabrielsortestersor@gmail.com";
        String clave = "qdfc diak skwx gceu";
        String destino = "" + consultaEmail.obtenerEmailUsuario(usuario_id);
        String asunto = "EGRESO REGISTRADO";
        String cuerpo = "Buenas, acaba de registrarse un egreso\n\n"
                + "Con los siguientes datos\n"
                + cuerpoDatosEgreso;

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

    public void limpiar() {
        vista.txtMONTO_EGRESO.setText(null);
        vista.ComboBoxTIPO_EGRESO.setSelectedItem(null);
    }
}
