package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Fechas_Select;
import Modelo.Datos_Fechas;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Ver_Presupuestos;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Ctrl_Ver_Presupuestos implements MouseListener {

    private final Ventana_Ver_Presupuestos vista;

    public Ctrl_Ver_Presupuestos(Ventana_Ver_Presupuestos vista) {
        this.vista = vista;

        //Botones
        this.vista.txtFiltrar.addMouseListener(this);
    }

    public void iniciar() {

        vista.setLocationRelativeTo(null);
        llenarDatos_Fechas();
        seleccionarMesAnoActualCbx();
        mostrarPresupuestoIngreso();
        mostrarPresupuestoEgreso();
        mostrarIngresoReal();
        mostrarEgresoReal();

    }

    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return !(column == 1 || column == 2);
        }
    }

    public class MyTableModel2 extends DefaultTableModel {

        public MyTableModel2(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return false; // La columna 0, 1, 5 (ID) no será editable
        }
    }

    public class MyTableModel3 extends DefaultTableModel {

        public MyTableModel3(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return false; // La columna 0, 1, 5 (ID) no será editable
        }
    }

    public class MyTableModel4 extends DefaultTableModel {

        public MyTableModel4(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return false; // La columna 0, 1, 5 (ID) no será editable
        }
    }

    private void seleccionarMesAnoActualCbx() {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            // Obtén la fecha actual
            LocalDate currentDate = LocalDate.now();

            // Define el formato deseado con la primera letra del mes en mayúscula
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendText(ChronoField.MONTH_OF_YEAR, TextStyle.FULL_STANDALONE)
                    .appendLiteral(' ')
                    .appendValue(ChronoField.YEAR, 4)
                    .toFormatter(Locale.ENGLISH);

            // Formatea la fecha según el formato
            String formattedDate = currentDate.format(formatter);

            // Imprime en pantalla
            System.out.println(formattedDate);

            String sql = "SELECT ID_FECHA FROM fechas WHERE MES_ANO = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, formattedDate);
            rs = ps.executeQuery();
            rs.next();

            int id_fecha = rs.getInt(1);
            System.out.println("ID_FECHA_ACTUAL: " + id_fecha);

            vista.cbxFecha.setSelectedIndex(id_fecha - 1);

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public void llenarDatos_Fechas() {
        Consulta_Fechas_Select consulta_fechas_select = new Consulta_Fechas_Select();
        ArrayList<Datos_Fechas> listaDatos_Fechas = consulta_fechas_select.getDatos_Fechas();
        vista.cbxFecha.removeAllItems();
        for (int i = 0; i < listaDatos_Fechas.size(); i++) {
            vista.cbxFecha.addItem(new Datos_Fechas(listaDatos_Fechas.get(i).getID_FECHA(), listaDatos_Fechas.get(i).getLIMITE_INFERIOR(), listaDatos_Fechas.get(i).getLIMITE_SUPERIOR(), listaDatos_Fechas.get(i).getMES_ANO()));
        }
    }

    public void mostrarPresupuestoIngreso() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            MyTableModel modelotabla = new MyTableModel(new Object[][]{}, new Object[]{"ID_PRESUPUESTOS", "CATEGORIA", "MONTO_PRESUPUESTO", "ID_FECHA"});
            this.vista.jtPresupuestoIngreso.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_PRESUPUESTOS, CATEGORIA, MONTO_PRESUPUESTO, ID_FECHA, TIPO, usuario_id \n"
                    + "FROM presupuestos \n"
                    + "WHERE usuario_id = ? AND TIPO = 'Ingreso' AND ID_FECHA = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setInt(2, fecha.getID_FECHA());
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 50};
            this.vista.jtPresupuestoIngreso.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtPresupuestoIngreso.getColumnCount(); i++) {
                this.vista.jtPresupuestoIngreso.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtPresupuestoIngreso.getColumnCount(); i++) {
                vista.jtPresupuestoIngreso.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla.addRow(filas);

            }

            javax.swing.table.TableColumnModel columnModel = vista.jtPresupuestoIngreso.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn3 = columnModel.getColumn(3);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn3.setMinWidth(0);
            idColumn3.setMaxWidth(0);
            idColumn3.setPreferredWidth(0);
            idColumn3.setResizable(false);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtPresupuestoIngreso.getTableHeader().setVisible(false);
        this.vista.jtPresupuestoIngreso.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtPresupuestoIngreso.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
    }

    public void mostrarPresupuestoEgreso() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            MyTableModel2 modelotabla = new MyTableModel2(new Object[][]{}, new Object[]{"ID_PRESUPUESTOS", "CATEGORIA", "MONTO_PRESUPUESTO", "ID_FECHA"});
            this.vista.jtPresupuestoEgreso.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_PRESUPUESTOS, CATEGORIA, MONTO_PRESUPUESTO, ID_FECHA, TIPO, usuario_id \n"
                    + "FROM presupuestos \n"
                    + "WHERE usuario_id = ? AND TIPO = 'Egreso' AND ID_FECHA = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setInt(2, fecha.getID_FECHA());
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 50};
            this.vista.jtPresupuestoEgreso.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtPresupuestoEgreso.getColumnCount(); i++) {
                this.vista.jtPresupuestoEgreso.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtPresupuestoEgreso.getColumnCount(); i++) {
                vista.jtPresupuestoEgreso.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla.addRow(filas);

            }

            javax.swing.table.TableColumnModel columnModel = vista.jtPresupuestoEgreso.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn3 = columnModel.getColumn(3);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn3.setMinWidth(0);
            idColumn3.setMaxWidth(0);
            idColumn3.setPreferredWidth(0);
            idColumn3.setResizable(false);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtPresupuestoEgreso.getTableHeader().setVisible(false);
        this.vista.jtPresupuestoEgreso.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtPresupuestoEgreso.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane2.getViewport().setBackground(new Color(255, 255, 255));
    }

    public void mostrarIngresoReal() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            MyTableModel3 modelotabla = new MyTableModel3(new Object[][]{}, new Object[]{"TIPO_INGRESO", "MONTO_TOTAL"});
            this.vista.jtIngresoReal.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT *\n"
                    + "FROM (\n"
                    + "    SELECT\n"
                    + "        i.DESCRIPCION_INGRESO,\n"
                    + "        SUM(i.MONTO_INGRESO) AS MONTO_TOTAL\n"
                    + "    FROM ingreso i\n"
                    + "    INNER JOIN categoria_ingreso ci ON i.DESCRIPCION_INGRESO = ci.TIPO_INGRESO\n"
                    + "    WHERE i.usuario_id = ?\n"
                    + "      AND i.FECHA_INGRESO BETWEEN ? AND ?\n"
                    + "    GROUP BY i.DESCRIPCION_INGRESO\n"
                    + "\n"
                    + "    UNION\n"
                    + "\n"
                    + "    SELECT\n"
                    + "        'Otros' AS DESCRIPCION_INGRESO,\n"
                    + "        SUM(i.MONTO_INGRESO) AS MONTO_TOTAL\n"
                    + "    FROM ingreso i\n"
                    + "    WHERE i.usuario_id = ?\n"
                    + "      AND i.FECHA_INGRESO BETWEEN ? AND ?\n"
                    + "      AND NOT EXISTS (\n"
                    + "        SELECT 1\n"
                    + "        FROM categoria_ingreso ci\n"
                    + "        WHERE i.DESCRIPCION_INGRESO = ci.TIPO_INGRESO\n"
                    + "      )\n"
                    + ") AS combined_result\n"
                    + "ORDER BY CASE WHEN DESCRIPCION_INGRESO = 'Otros' THEN 1 ELSE 0 END, DESCRIPCION_INGRESO;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setDate(2, fecha.getLIMITE_INFERIOR());
            ps.setDate(3, fecha.getLIMITE_SUPERIOR());
            ps.setInt(4, usuario_id);
            ps.setDate(5, fecha.getLIMITE_INFERIOR());
            ps.setDate(6, fecha.getLIMITE_SUPERIOR());

            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50};
            this.vista.jtIngresoReal.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtIngresoReal.getColumnCount(); i++) {
                this.vista.jtIngresoReal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtIngresoReal.getColumnCount(); i++) {
                vista.jtIngresoReal.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla.addRow(filas);

            }
            /*
            javax.swing.table.TableColumnModel columnModel = vista.jtIngresoReal.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn3 = columnModel.getColumn(3);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn3.setMinWidth(0);
            idColumn3.setMaxWidth(0);
            idColumn3.setPreferredWidth(0);
            idColumn3.setResizable(false);
             */
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtIngresoReal.getTableHeader().setVisible(false);
        this.vista.jtIngresoReal.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtIngresoReal.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane3.getViewport().setBackground(new Color(255, 255, 255));
    }

    public void mostrarEgresoReal() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            MyTableModel4 modelotabla = new MyTableModel4(new Object[][]{}, new Object[]{"TIPO_EGRESO", "MONTO_TOTAL"});
            this.vista.jtEgresoReal.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT\n"
                    + "    CASE\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Comida%' THEN 'Comida'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Transporte%' THEN 'Transporte'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Entretenimiento%' THEN 'Entretenimiento'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Servicios%' THEN 'Servicios'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Gastos Varios%' THEN 'Gastos Varios'\n"
                    + "        ELSE 'Otros'\n"
                    + "    END AS CATEGORIA,\n"
                    + "    SUM(MONTO_EGRESO) AS MONTO_TOTAL\n"
                    + "FROM egreso\n"
                    + "WHERE usuario_id = ?\n"
                    + "  AND FECHA_EGRESO BETWEEN ? AND ?\n"
                    + "GROUP BY CATEGORIA;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setDate(2, fecha.getLIMITE_INFERIOR());
            ps.setDate(3, fecha.getLIMITE_SUPERIOR());

            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50};
            this.vista.jtEgresoReal.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtEgresoReal.getColumnCount(); i++) {
                this.vista.jtEgresoReal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtEgresoReal.getColumnCount(); i++) {
                vista.jtEgresoReal.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla.addRow(filas);

            }
            /*
            javax.swing.table.TableColumnModel columnModel = vista.jtIngresoReal.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn3 = columnModel.getColumn(3);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn3.setMinWidth(0);
            idColumn3.setMaxWidth(0);
            idColumn3.setPreferredWidth(0);
            idColumn3.setResizable(false);
             */
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtIngresoReal.getTableHeader().setVisible(false);
        this.vista.jtIngresoReal.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtIngresoReal.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane4.getViewport().setBackground(new Color(255, 255, 255));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.txtFiltrar) {

            mostrarPresupuestoIngreso();
            mostrarPresupuestoEgreso();
            mostrarIngresoReal();
            mostrarEgresoReal();

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
