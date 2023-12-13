package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Fechas_Select;
import Modelo.Datos_Fechas;
import static Vista.Ventana_Login.usuario_id;
import Vista.Ventana_Ver_Presupuestos;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.legend.LegendTitle;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.swing.ChartPanel;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

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
        generarGraficoEgreso();
        generarGraficoIngreso();

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
                    + "FROM\n"
                    + "    egreso\n"
                    + "WHERE\n"
                    + "    usuario_id = ?\n"
                    + "    AND FECHA_EGRESO BETWEEN ? AND ?\n"
                    + "GROUP BY\n"
                    + "    CASE\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Comida%' THEN 'Comida'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Transporte%' THEN 'Transporte'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Entretenimiento%' THEN 'Entretenimiento'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Servicios%' THEN 'Servicios'\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Gastos Varios%' THEN 'Gastos Varios'\n"
                    + "        ELSE 'Otros'\n"
                    + "    END\n"
                    + "ORDER BY\n"
                    + "    CASE\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Comida%' THEN 1\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Transporte%' THEN 2\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Entretenimiento%' THEN 3\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Servicios%' THEN 4\n"
                    + "        WHEN TIPO_EGRESO LIKE 'Gastos Varios%' THEN 5\n"
                    + "        ELSE 6  -- Ajusta según sea necesario\n"
                    + "    END;";
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

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtEgresoReal.getTableHeader().setVisible(false);
        this.vista.jtEgresoReal.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtEgresoReal.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane4.getViewport().setBackground(new Color(255, 255, 255));
    }

    //GRAFICO Y DATOS INGRESO
    //Datos Ingreso
    public ArrayList<String> getCategoriasIngreso() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> listaCategoriasIngreso = new ArrayList<>();

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT \n"
                    + "    COALESCE(combined_result.DESCRIPCION_INGRESO, 'Otros') AS DESCRIPCION_INGRESO,\n"
                    + "    COALESCE(presupuestos.MONTO_PRESUPUESTO, 0) AS MONTO_PRESUPUESTO,\n"
                    + "    COALESCE(combined_result.MONTO_TOTAL, 0) AS MONTO_TOTAL\n"
                    + "FROM (\n"
                    + "    SELECT\n"
                    + "        i.DESCRIPCION_INGRESO,\n"
                    + "        COALESCE(SUM(i.MONTO_INGRESO), 0) AS MONTO_TOTAL\n"
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
                    + "        COALESCE(SUM(i.MONTO_INGRESO), 0) AS MONTO_TOTAL\n"
                    + "    FROM ingreso i\n"
                    + "    WHERE i.usuario_id = ?\n"
                    + "      AND i.FECHA_INGRESO BETWEEN ? AND ?\n"
                    + "      AND NOT EXISTS (\n"
                    + "        SELECT 1\n"
                    + "        FROM categoria_ingreso ci\n"
                    + "        WHERE i.DESCRIPCION_INGRESO = ci.TIPO_INGRESO\n"
                    + "      )\n"
                    + ") AS combined_result\n"
                    + "LEFT JOIN presupuestos ON combined_result.DESCRIPCION_INGRESO = presupuestos.CATEGORIA\n"
                    + "                      AND presupuestos.TIPO = 'Ingreso'\n"
                    + "                      AND presupuestos.ID_FECHA = ?\n"
                    + "                      AND presupuestos.usuario_id = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setDate(2, fecha.getLIMITE_INFERIOR());
            ps.setDate(3, fecha.getLIMITE_SUPERIOR());
            ps.setInt(4, usuario_id);
            ps.setDate(5, fecha.getLIMITE_INFERIOR());
            ps.setDate(6, fecha.getLIMITE_SUPERIOR());
            ps.setInt(7, fecha.getID_FECHA());
            ps.setInt(8, usuario_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String categoriasingreso = rs.getString("DESCRIPCION_INGRESO");
                listaCategoriasIngreso.add(categoriasingreso);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaCategoriasIngreso;

    }

    public ArrayList<Double> getPresupuestoIngreso() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Double> listaPresupuestoIngreso = new ArrayList<>();

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT \n"
                    + "    COALESCE(combined_result.DESCRIPCION_INGRESO, 'Otros') AS DESCRIPCION_INGRESO,\n"
                    + "    COALESCE(presupuestos.MONTO_PRESUPUESTO, 0) AS MONTO_PRESUPUESTO,\n"
                    + "    COALESCE(combined_result.MONTO_TOTAL, 0) AS MONTO_TOTAL\n"
                    + "FROM (\n"
                    + "    SELECT\n"
                    + "        i.DESCRIPCION_INGRESO,\n"
                    + "        COALESCE(SUM(i.MONTO_INGRESO), 0) AS MONTO_TOTAL\n"
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
                    + "        COALESCE(SUM(i.MONTO_INGRESO), 0) AS MONTO_TOTAL\n"
                    + "    FROM ingreso i\n"
                    + "    WHERE i.usuario_id = ?\n"
                    + "      AND i.FECHA_INGRESO BETWEEN ? AND ?\n"
                    + "      AND NOT EXISTS (\n"
                    + "        SELECT 1\n"
                    + "        FROM categoria_ingreso ci\n"
                    + "        WHERE i.DESCRIPCION_INGRESO = ci.TIPO_INGRESO\n"
                    + "      )\n"
                    + ") AS combined_result\n"
                    + "LEFT JOIN presupuestos ON combined_result.DESCRIPCION_INGRESO = presupuestos.CATEGORIA\n"
                    + "                      AND presupuestos.TIPO = 'Ingreso'\n"
                    + "                      AND presupuestos.ID_FECHA = ?\n"
                    + "                      AND presupuestos.usuario_id = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setDate(2, fecha.getLIMITE_INFERIOR());
            ps.setDate(3, fecha.getLIMITE_SUPERIOR());
            ps.setInt(4, usuario_id);
            ps.setDate(5, fecha.getLIMITE_INFERIOR());
            ps.setDate(6, fecha.getLIMITE_SUPERIOR());
            ps.setInt(7, fecha.getID_FECHA());
            ps.setInt(8, usuario_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Double presupuestoingreso = rs.getDouble("MONTO_PRESUPUESTO");
                listaPresupuestoIngreso.add(presupuestoingreso);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaPresupuestoIngreso;

    }

    public ArrayList<Double> getMontoMensualIngreso() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Double> listaMontoMensualIngreso = new ArrayList<>();

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT \n"
                    + "    COALESCE(combined_result.DESCRIPCION_INGRESO, 'Otros') AS DESCRIPCION_INGRESO,\n"
                    + "    COALESCE(presupuestos.MONTO_PRESUPUESTO, 0) AS MONTO_PRESUPUESTO,\n"
                    + "    COALESCE(combined_result.MONTO_TOTAL, 0) AS MONTO_TOTAL\n"
                    + "FROM (\n"
                    + "    SELECT\n"
                    + "        i.DESCRIPCION_INGRESO,\n"
                    + "        COALESCE(SUM(i.MONTO_INGRESO), 0) AS MONTO_TOTAL\n"
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
                    + "        COALESCE(SUM(i.MONTO_INGRESO), 0) AS MONTO_TOTAL\n"
                    + "    FROM ingreso i\n"
                    + "    WHERE i.usuario_id = ?\n"
                    + "      AND i.FECHA_INGRESO BETWEEN ? AND ?\n"
                    + "      AND NOT EXISTS (\n"
                    + "        SELECT 1\n"
                    + "        FROM categoria_ingreso ci\n"
                    + "        WHERE i.DESCRIPCION_INGRESO = ci.TIPO_INGRESO\n"
                    + "      )\n"
                    + ") AS combined_result\n"
                    + "LEFT JOIN presupuestos ON combined_result.DESCRIPCION_INGRESO = presupuestos.CATEGORIA\n"
                    + "                      AND presupuestos.TIPO = 'Ingreso'\n"
                    + "                      AND presupuestos.ID_FECHA = ?\n"
                    + "                      AND presupuestos.usuario_id = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setDate(2, fecha.getLIMITE_INFERIOR());
            ps.setDate(3, fecha.getLIMITE_SUPERIOR());
            ps.setInt(4, usuario_id);
            ps.setDate(5, fecha.getLIMITE_INFERIOR());
            ps.setDate(6, fecha.getLIMITE_SUPERIOR());
            ps.setInt(7, fecha.getID_FECHA());
            ps.setInt(8, usuario_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Double montomensualingreso = rs.getDouble("MONTO_TOTAL");
                listaMontoMensualIngreso.add(montomensualingreso);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaMontoMensualIngreso;
    }

    //Graficos Ingreso
    private void generarGraficoIngreso() {
        // Limpiar el contenido anterior
        vista.panelIngreso.removeAll();
        vista.panelIngreso.revalidate();
        vista.panelIngreso.repaint();

        // Obtener el conjunto de datos actualizado
        DefaultCategoryDataset datos = obtenerDatosIngreso();

        // Crear y configurar el gráfico con el conjunto de datos actualizado
        JFreeChart grafico_barras = crearGraficoIngreso(datos);
        configurarRendererIngreso(grafico_barras);

        // Crear el panel del gráfico y agregarlo al contenedor
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400, 350));

        vista.panelIngreso.setLayout(new BorderLayout());
        vista.panelIngreso.add(panel, BorderLayout.NORTH);

        vista.pack();
        vista.repaint();
    }

    private DefaultCategoryDataset obtenerDatosIngreso() {

        ArrayList<String> listaCategoriasIngreso = getCategoriasIngreso();
        ArrayList<Double> listaPresupuestoIngreso = getPresupuestoIngreso();
        ArrayList<Double> listaMontoMensualIngreso = getMontoMensualIngreso();

        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        // Agregar datos de la serie "Real"
        for (int i = 0; i < listaMontoMensualIngreso.size(); i++) {
            String categoriaingreso = listaCategoriasIngreso.get(i);
            double valor = listaMontoMensualIngreso.get(i);
            datos.addValue(valor, "Real", categoriaingreso);
        }

        // Agregar datos de la serie "Presupuesto"
        for (int i = 0; i < listaPresupuestoIngreso.size(); i++) {
            String categoriaingreso = listaCategoriasIngreso.get(i);
            double valor = listaPresupuestoIngreso.get(i);
            datos.addValue(valor, "Proyectado", categoriaingreso);
        }

        return datos;
    }

    private JFreeChart crearGraficoIngreso(DefaultCategoryDataset datos) {

        Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

        return ChartFactory.createBarChart(
                "Comparación de Ingresos Reales y Proyectados en el periodo " + fecha.getMES_ANO(),
                "Categoria",
                "Monto",
                datos,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);
    }

    private void configurarRendererIngreso(JFreeChart chart) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Cambiar el color de las barras
        renderer.setSeriesPaint(0, new Color(33, 135, 226));
        renderer.setSeriesPaint(1, new Color(15, 67, 115));

        // Desactivar el efecto de iluminado 3D
        renderer.setBarPainter(new StandardBarPainter());

        // Desactivar cualquier efecto de sombra
        renderer.setShadowVisible(false);

        // Desactivar el borde de las barras
        renderer.setDrawBarOutline(false);

        // Dejar el color y el trazo del contorno en blanco
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        renderer.setSeriesOutlineStroke(0, new BasicStroke(0.0f));

        // Ajustar otras propiedades si es necesario
        renderer.setMaximumBarWidth(0.1); // Ancho máximo de las barras (ajusta según sea necesario)
        renderer.setItemMargin(0.1);      // Margen entre las barras

        // Establecer el color de fondo del área de los ejes
        plot.setBackgroundPaint(Color.WHITE);

        // Establecer el color de fondo del panel
        ChartPanel panel = new ChartPanel(chart);
        panel.setBackground(Color.BLACK);

        // Cambiar la fuente del texto en el eje X
        Font font = new Font("Roboto Mono", Font.PLAIN, 12);
        Font font1 = new Font("Roboto Mono", Font.PLAIN, 10);
        Font titleFont = new Font("Roboto Mono", Font.BOLD, 18);
        Font legendFont = new Font("Roboto Mono", Font.PLAIN, 16);

        // Establecer el color de fondo de los ejes
        plot.getDomainAxis().setAxisLinePaint(Color.BLACK);
        plot.getRangeAxis().setAxisLinePaint(Color.BLACK);

        // Establecer el color de fondo de las etiquetas del eje X
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);

        // Establecer el color de fondo de las etiquetas del eje Y
        plot.getRangeAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);

        // Obtener el título del gráfico
        TextTitle chartTitle = chart.getTitle();
        // Cambiar la fuente del título
        chartTitle.setFont(titleFont);

        // Cambiar la fuente de la leyenda
        LegendTitle legend = chart.getLegend();
        legend.setItemFont(legendFont);

        // Configurar la fuente y color del texto en los ejes y la leyenda
        plot.getDomainAxis().setLabelFont(font1);
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(font1);
        plot.getRangeAxis().setLabelFont(font);
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setTickLabelFont(font);

    }

    //GRAFICO Y DATOS EGRESO
    //Datos
    public ArrayList<Double> getDatosPresupuestoEgreso() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Double> listaDatosPresupuestoEgreso = new ArrayList<>();

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT CATEGORIA, MONTO_PRESUPUESTO \n"
                    + "FROM presupuestos \n"
                    + "WHERE usuario_id = ? AND TIPO = 'Egreso' AND ID_FECHA = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setInt(2, fecha.getID_FECHA());
            rs = ps.executeQuery();

            while (rs.next()) {
                double montoPresupuesto = rs.getDouble("MONTO_PRESUPUESTO");
                listaDatosPresupuestoEgreso.add(montoPresupuesto);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaDatosPresupuestoEgreso;
    }

    public ArrayList<Double> getDatosRealEgreso() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Double> listaDatosRealEgreso = new ArrayList<>();

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT\n"
                    + "    categorias.CATEGORIA,\n"
                    + "    COALESCE(SUM(COALESCE(egreso.MONTO_EGRESO, 0)), 0.00) AS MONTO_TOTAL\n"
                    + "FROM\n"
                    + "    (\n"
                    + "        SELECT 'Comida' AS CATEGORIA\n"
                    + "        UNION SELECT 'Transporte'\n"
                    + "        UNION SELECT 'Entretenimiento'\n"
                    + "        UNION SELECT 'Servicios'\n"
                    + "        UNION SELECT 'Gastos Varios'\n"
                    + "    ) categorias\n"
                    + "LEFT JOIN\n"
                    + "    egreso ON\n"
                    + "    categorias.CATEGORIA =\n"
                    + "        CASE\n"
                    + "            WHEN egreso.TIPO_EGRESO LIKE 'Comida%' THEN 'Comida'\n"
                    + "            WHEN egreso.TIPO_EGRESO LIKE 'Transporte%' THEN 'Transporte'\n"
                    + "            WHEN egreso.TIPO_EGRESO LIKE 'Entretenimiento%' THEN 'Entretenimiento'\n"
                    + "            WHEN egreso.TIPO_EGRESO LIKE 'Servicios%' THEN 'Servicios'\n"
                    + "            WHEN egreso.TIPO_EGRESO LIKE 'Gastos Varios%' THEN 'Gastos Varios'\n"
                    + "        END\n"
                    + "    AND egreso.usuario_id = ?\n"
                    + "    AND egreso.FECHA_EGRESO BETWEEN ? AND ?\n"
                    + "GROUP BY categorias.CATEGORIA\n"
                    + "ORDER BY\n"
                    + "    CASE categorias.CATEGORIA\n"
                    + "        WHEN 'Comida' THEN 1\n"
                    + "        WHEN 'Transporte' THEN 2\n"
                    + "        WHEN 'Entretenimiento' THEN 3\n"
                    + "        WHEN 'Servicios' THEN 4\n"
                    + "        WHEN 'Gastos Varios' THEN 5\n"
                    + "    END;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setDate(2, fecha.getLIMITE_INFERIOR());
            ps.setDate(3, fecha.getLIMITE_SUPERIOR());
            rs = ps.executeQuery();

            while (rs.next()) {
                double montoReal = rs.getDouble("MONTO_TOTAL");
                listaDatosRealEgreso.add(montoReal);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaDatosRealEgreso;
    }

    //Grafico
    private void generarGraficoEgreso() {
        // Limpiar el contenido anterior
        vista.panelEgreso.removeAll();
        vista.panelEgreso.revalidate();
        vista.panelEgreso.repaint();

        // Obtener el conjunto de datos actualizado
        DefaultCategoryDataset datos = obtenerDatosEgreso();

        // Crear y configurar el gráfico con el conjunto de datos actualizado
        JFreeChart grafico_barras = crearGraficoEgreso(datos);
        configurarRendererEgreso(grafico_barras);

        // Crear el panel del gráfico y agregarlo al contenedor
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400, 350));

        vista.panelEgreso.setLayout(new BorderLayout());
        vista.panelEgreso.add(panel, BorderLayout.NORTH);

        vista.pack();
        vista.repaint();
    }

    private DefaultCategoryDataset obtenerDatosEgreso() {
        ArrayList<Double> listaDatosPresupuestoEgreso = getDatosPresupuestoEgreso();
        ArrayList<Double> listaDatosRealEgreso = getDatosRealEgreso();

        String[] categorias = {"Comida", "Transporte", "Entrenimiento", "Servicios", "Gastos Varios"};

        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        // Agregar datos de la serie "Real"
        for (int i = 0; i < listaDatosRealEgreso.size(); i++) {
            String categoria = categorias[i];
            double valor = listaDatosRealEgreso.get(i);
            datos.addValue(valor, "Real", categoria);
        }

        // Agregar datos de la serie "Presupuesto"
        for (int i = 0; i < listaDatosPresupuestoEgreso.size(); i++) {
            String categoria = categorias[i];
            double valor = listaDatosPresupuestoEgreso.get(i);
            datos.addValue(valor, "Proyectado", categoria);
        }

        return datos;
    }

    private JFreeChart crearGraficoEgreso(DefaultCategoryDataset datos) {

        Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha.getSelectedItem();

        return ChartFactory.createBarChart(
                "Comparación de Gastos Reales y Proyectados en el periodo " + fecha.getMES_ANO(),
                "Categoria",
                "Monto",
                datos,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);
    }

    //new Color(26,177,136)
    private void configurarRendererEgreso(JFreeChart chart) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Cambiar el color de las barras
        renderer.setSeriesPaint(0, new Color(55, 185, 81));
        renderer.setSeriesPaint(1, new Color(38, 128, 56));

        // Desactivar el efecto de iluminado 3D
        renderer.setBarPainter(new StandardBarPainter());

        // Desactivar cualquier efecto de sombra
        renderer.setShadowVisible(false);

        // Desactivar el borde de las barras
        renderer.setDrawBarOutline(false);

        // Dejar el color y el trazo del contorno en blanco
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        renderer.setSeriesOutlineStroke(0, new BasicStroke(0.0f));

        // Ajustar otras propiedades si es necesario
        renderer.setMaximumBarWidth(0.1); // Ancho máximo de las barras (ajusta según sea necesario)
        renderer.setItemMargin(0.1);      // Margen entre las barras

        // Establecer el color de fondo del área de los ejes
        plot.setBackgroundPaint(Color.WHITE);

        // Establecer el color de fondo del panel
        ChartPanel panel = new ChartPanel(chart);
        panel.setBackground(Color.BLACK);

        // Cambiar la fuente del texto en el eje X
        Font font = new Font("Roboto Mono", Font.PLAIN, 12);
        Font font1 = new Font("Roboto Mono", Font.PLAIN, 10);
        Font titleFont = new Font("Roboto Mono", Font.BOLD, 18);
        Font legendFont = new Font("Roboto Mono", Font.PLAIN, 16);

        // Establecer el color de fondo de los ejes
        plot.getDomainAxis().setAxisLinePaint(Color.BLACK);
        plot.getRangeAxis().setAxisLinePaint(Color.BLACK);

        // Establecer el color de fondo de las etiquetas del eje X
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);

        // Establecer el color de fondo de las etiquetas del eje Y
        plot.getRangeAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);

        // Obtener el título del gráfico
        TextTitle chartTitle = chart.getTitle();
        // Cambiar la fuente del título
        chartTitle.setFont(titleFont);

        // Cambiar la fuente de la leyenda
        LegendTitle legend = chart.getLegend();
        legend.setItemFont(legendFont);

        // Configurar la fuente y color del texto en los ejes y la leyenda
        plot.getDomainAxis().setLabelFont(font1);
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(font1);
        plot.getRangeAxis().setLabelFont(font);
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setTickLabelFont(font);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.txtFiltrar) {

            mostrarPresupuestoIngreso();
            mostrarPresupuestoEgreso();
            mostrarIngresoReal();
            mostrarEgresoReal();
            generarGraficoEgreso();
            generarGraficoIngreso();
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
