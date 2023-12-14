package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Datos_Egreso;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Modelo.Datos_Egreso;
import Vista.Ventana_Asignar_Recursos;
import Vista.Ventana_Metas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ctrl_Asignar_Recursos_Metas implements ActionListener {

    private final Datos_Egreso datos;
    private final Consulta_Datos_Egreso consultas;
    private final Ventana_Asignar_Recursos vista;
    private final Consulta_Obtener_Suma_Ingresos consultaSumaIngresos;
    private final Consulta_Obtener_Suma_Egresos consultaSumaEgresos;
    private final Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados;
    private final Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado;
    private final Consulta_Obtener_Dinero_Inversion consultaDineroInversion;
    private final int usuario_id;
    DefaultTableModel modelo = new DefaultTableModel();

    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return column != 0 && column != 4 && column != 5; // La columna 0, 1, 5 (ID) no será editable
        }
    }

    public Ctrl_Asignar_Recursos_Metas(Datos_Egreso datos, Consulta_Datos_Egreso consultas, Ventana_Asignar_Recursos vista, Consulta_Obtener_Suma_Ingresos consultaSumaIngresos, Consulta_Obtener_Suma_Egresos consultaSumaEgresos, Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados, Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado, Consulta_Obtener_Dinero_Inversion consultaDineroInversion, int usuario_id) {
        this.datos = datos;
        this.consultas = consultas;
        this.vista = vista;
        this.consultaSumaIngresos = consultaSumaIngresos;
        this.consultaSumaEgresos = consultaSumaEgresos;
        this.consultaSumaRecursosAsignados = consultaSumaRecursosAsignados;
        this.consultaDineroAhorrado = consultaDineroAhorrado;
        this.consultaDineroInversion = consultaDineroInversion;
        this.usuario_id = usuario_id;

        //Botones
        //this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnObtener.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnQuitar.addActionListener(this);
    }

    public void mostrarTablaMetas() {

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        try {
            MyTableModel modelotabla = new MyTableModel(new Object[][]{}, new Object[]{"ID_META", "NOMBRE_META", "MONTO_META", "FECHA_LIMITE_META", "RECURSOS_ASIGNADOS", "ESTADO_META", "usuario_id"});
            this.vista.jtMetas.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_META, NOMBRE_META, MONTO_META, FECHA_LIMITE_META, RECURSOS_ASIGNADOS, ESTADO_META, usuario_id FROM meta WHERE usuario_id = ?";
            ps2 = con.prepareStatement(sql);
            ps2.setInt(1, usuario_id);
            rs2 = ps2.executeQuery();

            ResultSetMetaData rsMd2 = (ResultSetMetaData) rs2.getMetaData();
            int cantidadColumnas = rsMd2.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 200, 50, 50, 50, 50, 50};
            this.vista.jtMetas.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtMetas.getColumnCount(); i++) {
                this.vista.jtMetas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtMetas.getColumnCount(); i++) {
                vista.jtMetas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs2.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs2.getObject(i + 1);
                    System.out.print(rs2.getObject(i + 1) + " ");
                }
                System.out.println();
                modelotabla.addRow(filas);

            }

            javax.swing.table.TableColumnModel columnModel = vista.jtMetas.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn6 = columnModel.getColumn(6);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn6.setMinWidth(0);
            idColumn6.setMaxWidth(0);
            idColumn6.setPreferredWidth(0);
            idColumn6.setResizable(false);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtMetas.getTableHeader().setVisible(false);
        this.vista.jtMetas.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtMetas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
    }

    public void iniciar() {
        vista.setTitle("Asignar Recursos");
        vista.setLocationRelativeTo(null);
        mostrarTablaMetas();

    }

    public double obtenerTotalMensualCategoria() {
        //Categoria
        String categoria = "Gastos Varios";
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
        String categoria = "Gastos Varios";
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


        if (e.getSource() == vista.btnEliminar) {

            if (vista.jtMetas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla antes de eliminar alguna meta.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del manejador de eventos si no se selecciona una fila
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar esta meta?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                // El usuario confirmó la eliminación
                PreparedStatement ps = null;

                try {
                    Conexion objCon = new Conexion();
                    Connection conn = objCon.getConexion();

                    int fila = this.vista.jtMetas.getSelectedRow();
                    String codigo = this.vista.jtMetas.getValueAt(fila, 0).toString();

                    ps = conn.prepareStatement("DELETE FROM meta WHERE ID_META=?");
                    ps.setString(1, codigo);
                    ps.execute();

                    ((MyTableModel) this.vista.jtMetas.getModel()).removeRow(fila);
                    //modelo.removeRow(fila);
                    JOptionPane.showMessageDialog(null, "Meta Eliminado");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar Meta");
                    System.out.println(ex.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Eliminación Cancelada");
            }

        }

        if (e.getSource() == vista.btnAgregar) {

            boolean metaLograda = false;
            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double dineroinversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);
            double dineroahorros = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);

            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - dineroinversion - dineroahorros;

            if (vista.jtMetas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla antes de agregar recursos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del manejador de eventos si no se selecciona una fila
            }

            int Fila = this.vista.jtMetas.getSelectedRow();
            int ID_META = (int) this.vista.jtMetas.getValueAt(Fila, 0);
            Double MONTO_META = (Double) this.vista.jtMetas.getValueAt(Fila, 2);
            Double RECURSOS_ASIGNADOS = (Double) this.vista.jtMetas.getValueAt(Fila, 4);
            Double RECURSO = 0.0;

            String input = JOptionPane.showInputDialog("Indique el monto que desea agregar a la meta");

            if (input != null && !input.isEmpty()) {
                try {
                    RECURSO = Double.parseDouble(input);

                    if (RECURSO >= 0 && !metaLograda) {
                        if (RECURSO <= saldo_disponible) {
                            if (!Objects.equals(MONTO_META, RECURSOS_ASIGNADOS) && (RECURSOS_ASIGNADOS + RECURSO) <= MONTO_META) {
                                RECURSOS_ASIGNADOS = RECURSOS_ASIGNADOS + RECURSO;

                                PreparedStatement ps = null;
                                try {
                                    Conexion objCon = new Conexion();
                                    Connection conn = objCon.getConexion();
                                    ps = conn.prepareStatement("UPDATE meta SET RECURSOS_ASIGNADOS=? WHERE ID_META=?");

                                    ps.setDouble(1, RECURSOS_ASIGNADOS);
                                    ps.setInt(2, ID_META);

                                    ps.execute();

                                    JOptionPane.showMessageDialog(null, "Meta Modificado");
                                    this.vista.jtMetas.setValueAt(RECURSOS_ASIGNADOS, Fila, 4);

                                    if (Objects.equals(MONTO_META, RECURSOS_ASIGNADOS)) {
                                        String ESTADO_META = "LOGRADO";
                                        this.vista.jtMetas.setValueAt(ESTADO_META, Fila, 5);
                                        System.out.println("Estado meta es: " + ESTADO_META);
                                        metaLograda = true;  // Marcar la meta como "LOGRADA"
                                        ps = conn.prepareStatement("UPDATE meta SET ESTADO_META=? WHERE ID_META=?");
                                        ps.setString(1, ESTADO_META);
                                        ps.setInt(2, ID_META);
                                        System.out.println("Aqui la ID_META es: " + ID_META);
                                        ps.execute();
                                    } else {
                                        String ESTADO_META = "EN PROCESO";
                                        this.vista.jtMetas.setValueAt(ESTADO_META, Fila, 5);
                                        System.out.println("Estado meta es: " + ESTADO_META);
                                        metaLograda = false;
                                        ps = conn.prepareStatement("UPDATE meta SET ESTADO_META=? WHERE ID_META=?");
                                        ps.setString(1, ESTADO_META);
                                        ps.setInt(2, ID_META);
                                        ps.execute();
                                        System.out.println("Se ejecuto el estado meta que tiene por valor" + ESTADO_META);
                                    }
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Error al Modificar Meta");
                                    System.out.println(ex);
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Los recursos no pueden superar la meta o la meta ya está lograda.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "<html><center>No tiene el suficiente saldo para agregar esta cantidad de recursos. <br> Su saldo disponible actual es: " + saldo_disponible + " <html>");
                        }
                    } else if (metaLograda) {
                        JOptionPane.showMessageDialog(null, "La meta ya está lograda. No se pueden agregar más recursos.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número mayor o igual que 0");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
                }
            } else {
                // Maneja el caso en el que el usuario cancela el diálogo de entrada
            }

        }

        if (e.getSource() == vista.btnQuitar) {

            if (vista.jtMetas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla antes de quitar recursos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del manejador de eventos si no se selecciona una fila
            }

            boolean metaLograda = false;  // Variable para rastrear si la meta ya está "LOGRADA"

            int Fila = this.vista.jtMetas.getSelectedRow();
            int ID_META = (int) this.vista.jtMetas.getValueAt(Fila, 0);
            Double MONTO_META = (Double) this.vista.jtMetas.getValueAt(Fila, 2);
            Double RECURSOS_ASIGNADOS = (Double) this.vista.jtMetas.getValueAt(Fila, 4);
            Double RECURSO = 0.0;

            String input = JOptionPane.showInputDialog("Indique el monto que desea retirar de la meta");

            if (input != null && !input.isEmpty()) {
                try {
                    RECURSO = Double.parseDouble(input);

                    if (RECURSO >= 0 && !metaLograda) {

                        if (RECURSO >= 0 && RECURSO <= RECURSOS_ASIGNADOS) {
                            RECURSOS_ASIGNADOS = RECURSOS_ASIGNADOS - RECURSO;

                            PreparedStatement ps = null;
                            try {
                                Conexion objCon = new Conexion();
                                Connection conn = objCon.getConexion();
                                ps = conn.prepareStatement("UPDATE meta SET RECURSOS_ASIGNADOS=? WHERE ID_META=?");

                                ps.setDouble(1, RECURSOS_ASIGNADOS);
                                ps.setInt(2, ID_META);

                                ps.execute();

                                JOptionPane.showMessageDialog(null, "Meta Modificado");
                                this.vista.jtMetas.setValueAt(RECURSOS_ASIGNADOS, Fila, 4);

                                if (Objects.equals(MONTO_META, RECURSOS_ASIGNADOS)) {
                                    String ESTADO_META = "LOGRADO";
                                    this.vista.jtMetas.setValueAt(ESTADO_META, Fila, 5);
                                    System.out.println("Estado meta es: " + ESTADO_META);
                                    metaLograda = true;  // Marcar la meta como "LOGRADA"
                                    ps = conn.prepareStatement("UPDATE meta SET ESTADO_META=? WHERE ID_META=?");
                                    ps.setString(1, ESTADO_META);
                                    ps.setInt(2, ID_META);
                                    System.out.println("Aqui la ID_META es: " + ID_META);
                                    ps.execute();
                                } else {
                                    String ESTADO_META = "EN PROCESO";
                                    this.vista.jtMetas.setValueAt(ESTADO_META, Fila, 5);
                                    System.out.println("Estado meta es: " + ESTADO_META);
                                    metaLograda = false;
                                    ps = conn.prepareStatement("UPDATE meta SET ESTADO_META=? WHERE ID_META=?");
                                    ps.setString(1, ESTADO_META);
                                    ps.setInt(2, ID_META);
                                    ps.execute();
                                }

                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Error al Modificar Meta");
                                System.out.println(ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un número mayor o igual que 0 y no mayor que los recursos asignados.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
                }
            } else {
                // Maneja el caso en el que el usuario cancela el diálogo de entrada
            }

        }

        if (e.getSource() == vista.btnObtener) {

            if (vista.jtMetas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla antes de obtener alguna meta.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del manejador de eventos si no se selecciona una fila
            }

            int Fila = this.vista.jtMetas.getSelectedRow();
            int ID_META = (int) this.vista.jtMetas.getValueAt(Fila, 0);
            String NOMBRE_META = (String) this.vista.jtMetas.getValueAt(Fila, 1);
            Double MONTO_META = (Double) this.vista.jtMetas.getValueAt(Fila, 2);
            Double RECURSOS_ASIGNADOS = (Double) this.vista.jtMetas.getValueAt(Fila, 4);
            String ESTADO_META = (String) this.vista.jtMetas.getValueAt(Fila, 5);
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

            //CONTROL DEL PRESUPUESTO
            int IDFecha = obtenerIDFecha();
            Double TotalMensualCategoria = obtenerTotalMensualCategoria();
            Double PresupuestoMensualCategoria = obtenerPresupuestoMensualCategoria();

            System.out.println("obtenerTotalMensualCategoria:" + TotalMensualCategoria);
            System.out.println("obtenerIDFecha:" + IDFecha);
            System.out.println("obtenerPresupuestoMensualCategoria:" + PresupuestoMensualCategoria);

            if (ESTADO_META == "LOGRADO") {

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas obtener esta meta?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {

                    // Verificar si PresupuestoMensualCategoria es nulo o si monto_egreso + TotalMensualCategoria supera el PresupuestoMensualCategoria
                    if (PresupuestoMensualCategoria == null || MONTO_META + TotalMensualCategoria > PresupuestoMensualCategoria) {
                        // Pregunta al usuario si desea continuar
                        int respuesta1 = JOptionPane.showConfirmDialog(null, "El monto de egreso haria que se supere el presupuesto mensual en GASTOS VARIOS o el presupuesto no está definido. ¿Desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (respuesta1 == JOptionPane.NO_OPTION) {

                            return; // Salir del método actionPerformed
                        }
                        // Si la respuesta es YES, continúa con la ejecución
                    }

                    datos.setMONTO_EGRESO(RECURSOS_ASIGNADOS);

                    datos.setFECHA_EGRESO((java.sql.Date) date);

                    String cadenaAdicional = NOMBRE_META;
                    datos.setTIPO_EGRESO("Gastos Varios - Meta - " + cadenaAdicional);

                    if (consultas.registrar(datos, usuario_id)) {
                        JOptionPane.showMessageDialog(null, "Meta Cumplida y registrada con existo");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar Registro de Meta cumplida");
                    }

                    PreparedStatement ps = null;

                    try {
                        int fila = this.vista.jtMetas.getSelectedRow();
                        String codigo = this.vista.jtMetas.getValueAt(fila, 0).toString();
                        Conexion objCon = new Conexion();
                        Connection conn = objCon.getConexion();
                        ps = conn.prepareStatement("DELETE FROM meta WHERE ID_META=?");
                        ps.setString(1, codigo);
                        ps.execute();
                        ((MyTableModel) this.vista.jtMetas.getModel()).removeRow(fila);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al Eliminar Objetivo Cumplido");
                        System.out.println(ex.toString());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Obtención Cancelada");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Aun no ha asignado recursos suficientes para cumplir esta meta");
            }

        }

    }

}
