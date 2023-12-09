package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Datos_Egreso;
import Modelo.Consulta_Email_Notificacion;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Consulta_Tipo_Servicio_Select;
import Modelo.Datos_Egreso;
import Modelo.Datos_Recordatorio;
import Modelo.Datos_Tipo_Servicio;
import Vista.Ventana_Ver_Recordatorios;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ctrl_Ver_Recordatorios implements MouseListener {

    private final Datos_Egreso modelo;
    private final Consulta_Obtener_Suma_Ingresos consultaSumaIngresos;
    private final Consulta_Obtener_Suma_Egresos consultaSumaEgresos;
    private final Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados;
    private final Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado;
    private final Consulta_Obtener_Dinero_Inversion consultaDineroInversion;
    private final Consulta_Datos_Egreso consultas;
    private final Consulta_Email_Notificacion consultaEmail;
    private final Ventana_Ver_Recordatorios vista;
    private final int usuario_id;

    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return !(column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5); // La columna 0, 1, 5 (ID) no será editable
        }
    }

    public Ctrl_Ver_Recordatorios(Datos_Egreso modelo, Consulta_Obtener_Suma_Ingresos consultaSumaIngresos, Consulta_Obtener_Suma_Egresos consultaSumaEgresos, Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados, Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado, Consulta_Obtener_Dinero_Inversion consultaDineroInversion, Consulta_Datos_Egreso consultas, Consulta_Email_Notificacion consultaEmail, Ventana_Ver_Recordatorios vista, int usuario_id) {
        this.modelo = modelo;
        this.consultaSumaIngresos = consultaSumaIngresos;
        this.consultaSumaEgresos = consultaSumaEgresos;
        this.consultaSumaRecursosAsignados = consultaSumaRecursosAsignados;
        this.consultaDineroAhorrado = consultaDineroAhorrado;
        this.consultaDineroInversion = consultaDineroInversion;
        this.consultas = consultas;
        this.consultaEmail = consultaEmail;
        this.vista = vista;
        this.usuario_id = usuario_id;

        //MouseListener
        this.vista.jtRecordatorios.addMouseListener(this);
        this.vista.txtPagar.addMouseListener(this);
        this.vista.txtModificar.addMouseListener(this);
        this.vista.txtEliminar.addMouseListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        llenarPrioridad();
        llenarTipoServicio();
        llenar_tabla_recordatorios();

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

    private void llenar_tabla_recordatorios() {
        try {
            MyTableModel modelo = new MyTableModel(new Object[][]{}, new Object[]{"ID_RECORDATORIO", "TIPO_SERVICIO", "MONTO", "FECHA", "PRIORIDAD", "ESTADO"});
            this.vista.jtRecordatorios.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT * "
                    + "FROM recordatorios "
                    + "WHERE usuario_id = ? "
                    + "ORDER BY FECHA DESC;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 40;
            int[] anchos = {50, 50, 50, 50, 50, 50, 50};
            this.vista.jtRecordatorios.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtRecordatorios.getColumnCount(); i++) {
                this.vista.jtRecordatorios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 1; i <= cantidadColumnas; i++) {
                    filas[i - 1] = rs.getObject(i);  // Ajuste del índice aquí
                    System.out.print(rs.getObject(i) + " ");
                }

                System.out.println();
                modelo.addRow(filas);
            }

            //Ver o no encabezado
            this.vista.jtRecordatorios.getTableHeader().setVisible(false);
            this.vista.jtRecordatorios.setBorder(BorderFactory.createEmptyBorder());
            this.vista.jtRecordatorios.setIntercellSpacing(new java.awt.Dimension(0, 0));

            this.vista.jScrollPane2.getViewport().setBackground(new Color(255, 255, 255));

            javax.swing.table.TableColumnModel columnModel = this.vista.jtRecordatorios.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);

            javax.swing.table.TableColumn idColumn1 = columnModel.getColumn(0);
            idColumn1.setMinWidth(0);
            idColumn1.setMaxWidth(0);
            idColumn1.setPreferredWidth(0);
            idColumn1.setResizable(false);

            colorearFilas();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    private void colorearFilas() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Check the condition in the "Tipo" column (column index 0)
                String tipoValue = table.getModel().getValueAt(row, 5).toString();

                if (tipoValue.equals("PAGADA")) {
                    setForeground(new Color(156, 209, 46)); // Color for Incomes
                } else if (tipoValue.equals("PENDIENTE")) {
                    setForeground(new Color(230, 26, 82)); // Color for Expenses
                } else {
                    // Reset the color for other rows
                    setForeground(table.getForeground());
                }

                // Center-align the content
                setHorizontalAlignment(SwingConstants.CENTER);

                return this;
            }
        };

        // Apply the custom renderer to all columns
        for (int i = 0; i < this.vista.jtRecordatorios.getColumnCount(); i++) {
            this.vista.jtRecordatorios.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public double obtenerTotalMensualCategoria() {
        //Categoria
        String categoria = "Servicios";
        System.out.println("HOLA2:" + categoria);
        //Fecha
        // Fecha actual
        LocalDate fechaActual = LocalDate.now();
        ZoneId zonaHoraria = ZoneId.systemDefault();
        ZonedDateTime inicioMes = fechaActual.withDayOfMonth(1).atStartOfDay(zonaHoraria);
        ZonedDateTime finMes = fechaActual.withDayOfMonth(fechaActual.lengthOfMonth()).atTime(LocalTime.MAX).atZone(zonaHoraria);

// Convierte a java.sql.Date si es necesario
        java.sql.Date fechaLimiteInferior = java.sql.Date.valueOf(inicioMes.toLocalDate());
        java.sql.Date fechaLimiteSuperior = java.sql.Date.valueOf(finMes.toLocalDate());

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

            // Obtén la fecha actual
            LocalDate fechaActual = LocalDate.now();

            // Define el formato deseado en inglés
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

            // Formatea la fecha actual según el formato
            String formattedDate = fechaActual.format(formatter);

            // Imprime en pantalla
            System.out.println(formattedDate);

            String sql = "SELECT ID_FECHA FROM fechas WHERE MES_ANO = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, formattedDate);
            rs = ps.executeQuery();

            if (rs.next()) {
                resultado = rs.getInt(1);
            }

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
        String categoria = "Servicios";
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
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.txtPagar) {

            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
            double obtenerDineroInversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);
            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado - obtenerDineroInversion;

            //CONTROL DEL PRESUPUESTO
            int IDFecha = obtenerIDFecha();
            Double TotalMensualCategoria = obtenerTotalMensualCategoria();
            Double PresupuestoMensualCategoria = obtenerPresupuestoMensualCategoria();

            System.out.println("obtenerTotalMensualCategoria:" + TotalMensualCategoria);
            System.out.println("obtenerIDFecha:" + IDFecha);
            System.out.println("obtenerPresupuestoMensualCategoria:" + PresupuestoMensualCategoria);

            //SELECCION
            int Fila = this.vista.jtRecordatorios.getSelectedRow();
            int ID_RECORDATORIO = (int) this.vista.jtRecordatorios.getValueAt(Fila, 0);
            String TIPO_SERVICIO = (String) this.vista.jtRecordatorios.getValueAt(Fila, 1);
            Double MONTO = (Double) this.vista.jtRecordatorios.getValueAt(Fila, 2);
            Date FECHA = (Date) this.vista.jtRecordatorios.getValueAt(Fila, 3);
            String PRIORIDAD = (String) this.vista.jtRecordatorios.getValueAt(Fila, 4);
            String ESTADO = (String) this.vista.jtRecordatorios.getValueAt(Fila, 5);
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
            System.out.println("ESTADOO: " + ESTADO);

            if ("PENDIENTE".equals(ESTADO)) {

                // Validar si el monto es mayor que el saldo disponible
                if (MONTO > saldo_disponible) {
                    JOptionPane.showMessageDialog(null, "El monto supera el saldo disponible. No es posible realizar el pago.");
                    return; // Salir del método en caso de que el monto sea mayor que el saldo disponible
                }

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas pagar la factura?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {

                    // Verificar si PresupuestoMensualCategoria es nulo o si monto_egreso + TotalMensualCategoria supera el PresupuestoMensualCategoria
                    if (PresupuestoMensualCategoria == null || MONTO + TotalMensualCategoria > PresupuestoMensualCategoria) {
                        // Pregunta al usuario si desea continuar
                        int respuesta1 = JOptionPane.showConfirmDialog(null, "El monto de egreso haria que se supere el presupuesto mensual en SERVICIOS o el presupuesto no está definido. ¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (respuesta1 == JOptionPane.NO_OPTION) {

                            return; // Salir del método actionPerformed
                        }
                        // Si la respuesta es YES, continúa con la ejecución
                    }

                    modelo.setMONTO_EGRESO(MONTO);

                    modelo.setFECHA_EGRESO((java.sql.Date) date);

                    String cadenaAdicional = TIPO_SERVICIO;
                    modelo.setTIPO_EGRESO("Servicios - " + cadenaAdicional + " - Yo");

                    if (consultas.registrar(modelo, usuario_id)) {
                        JOptionPane.showMessageDialog(null, "Factura pagada y registrada con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar Registro");
                    }

                    PreparedStatement ps = null;

                    try {
                        int fila = this.vista.jtRecordatorios.getSelectedRow();
                        String codigo = this.vista.jtRecordatorios.getValueAt(fila, 0).toString();
                        Conexion objCon = new Conexion();
                        Connection conn = objCon.getConexion();
                        ps = conn.prepareStatement("UPDATE recordatorios SET ESTADO = 'PAGADA' WHERE ID_RECORDATORIO=?");
                        ps.setString(1, codigo);
                        ps.execute();
                        llenar_tabla_recordatorios();

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error updatear estado del recordatorio");
                        System.out.println(ex.toString());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Obtención Cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Esta factura ya esta pagada");
            }

        }

        if (e.getSource() == vista.jtRecordatorios) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();

                int Fila = vista.jtRecordatorios.getSelectedRow();

                String codigo = vista.jtRecordatorios.getValueAt(Fila, 0).toString();

                System.out.println("El valor de codigo es: " + codigo);

                ps = conn.prepareStatement("SELECT TIPO_SERVICIO, MONTO, FECHA, PRIORIDAD FROM recordatorios WHERE ID_RECORDATORIO=?");
                ps.setString(1, codigo);
                rs = ps.executeQuery();

                while (rs.next()) {
                    //TIPO_SERVICIO
                    // Obtén el valor de TIPO_SERVICIO desde la base de datos
                    String tipoServicio = rs.getString("TIPO_SERVICIO");

                    // Itera a través de los elementos en el JComboBox
                    for (int i = 0; i < vista.cbxTipoServicio.getItemCount(); i++) {
                        Datos_Tipo_Servicio servicio = (Datos_Tipo_Servicio) vista.cbxTipoServicio.getItemAt(i);

                        // Compara las cadenas de texto directamente
                        if (servicio.getTIPO_SERVICIO().equals(tipoServicio)) {
                            vista.cbxTipoServicio.setSelectedItem(servicio);
                            break;
                        }
                    }
                    //MONTO
                    vista.txtMonto.setText(rs.getString("MONTO"));
                    //FECHA
                    String fechaString = rs.getString("FECHA");
                    // Formatear la cadena de fecha a un objeto Date
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Ajusta el formato según tus necesidades
                    Date fecha = sdf.parse(fechaString);
                    // Establecer la fecha en el JDateChooser
                    vista.jDateChooser.setDate(fecha);
                    //PRIORIDAD
                    String tipoprioridad = rs.getString("PRIORIDAD");
                    for (int i = 0; i < vista.cbxPrioridad.getItemCount(); i++) {
                        String prioridad = (String) vista.cbxPrioridad.getItemAt(i);

                        // Compara las cadenas de texto directamente
                        if (prioridad.equals(tipoprioridad)) {
                            vista.cbxPrioridad.setSelectedItem(prioridad);
                            break;
                        }
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            } catch (ParseException ex) {
                Logger.getLogger(Ctrl_Ver_Recordatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == vista.txtModificar) {

            if (vista.jtRecordatorios.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla antes de modificar algun registro.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del manejador de eventos si no se selecciona una fila
            }

            PreparedStatement ps = null;
            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                ps = conn.prepareStatement("UPDATE recordatorios SET TIPO_SERVICIO=?, MONTO=?, FECHA=?, PRIORIDAD=? WHERE ID_RECORDATORIO=?");

                Datos_Tipo_Servicio tipo_servicio_seleccionado = (Datos_Tipo_Servicio) vista.cbxTipoServicio.getSelectedItem();

                double monto = Double.parseDouble(vista.txtMonto.getText());

                Date fechaSeleccionada = vista.jDateChooser.getDate();
                java.sql.Date fechaIngreso = new java.sql.Date(fechaSeleccionada.getTime());

                String prioridad_seleccionada = (String) vista.cbxPrioridad.getSelectedItem();

                int fila = this.vista.jtRecordatorios.getSelectedRow();
                String codigo = this.vista.jtRecordatorios.getValueAt(fila, 0).toString();

                ps.setString(1, tipo_servicio_seleccionado.getTIPO_SERVICIO());
                ps.setDouble(2, monto);
                ps.setDate(3, fechaIngreso);
                ps.setString(4, prioridad_seleccionada);
                ps.setString(5, codigo);
                ps.execute();

                JOptionPane.showMessageDialog(null, "Recordatorio Modificado");
                //jtUsuarios.setValueAt(txtCodigo.getText(), Fila, 0);
                llenar_tabla_recordatorios();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Modificar Recordatorio");
                System.out.println(ex);
            }

        }

        if (e.getSource() == vista.txtEliminar) {

            if (vista.jtRecordatorios.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla antes de eliminar algun registro.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del manejador de eventos si no se selecciona una fila
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                // El usuario confirmó la eliminación
                PreparedStatement ps = null;

                try {
                    Conexion objCon = new Conexion();
                    Connection conn = objCon.getConexion();

                    int fila = this.vista.jtRecordatorios.getSelectedRow();
                    String codigo = this.vista.jtRecordatorios.getValueAt(fila, 0).toString();

                    ps = conn.prepareStatement("DELETE FROM recordatorios WHERE ID_RECORDATORIO=?");
                    ps.setString(1, codigo);
                    ps.execute();

                    JOptionPane.showMessageDialog(null, "Recordatorio Eliminado");
                    llenar_tabla_recordatorios();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar Recordatorio");
                    System.out.println(ex.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Eliminación Cancelada");
            }

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
