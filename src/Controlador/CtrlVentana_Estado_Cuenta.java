/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Fechas_Select;
import Modelo.Consulta_Limites_Fechas;
import Modelo.Datos_Fechas;
import Vista.Ventana_Estado_Cuenta;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class CtrlVentana_Estado_Cuenta implements MouseListener {

    private final Ventana_Estado_Cuenta vista;
    private final Consulta_Limites_Fechas consulta_limites_fechas;
    private final int usuario_id;
    DefaultTableModel modelo = new DefaultTableModel();

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.txtFiltrar) {

            String Mes_Ano = ((Datos_Fechas) vista.cbxFechas.getSelectedItem()).getMES_ANO();

            if (Mes_Ano != null) {
                System.out.println("MES_ANO seleccionado: " + Mes_Ano);
                ArrayList<java.util.Date> limitesFechas = consulta_limites_fechas.getLimitesFechas(Mes_Ano);

                java.util.Date limite_inferior = limitesFechas.get(0);
                java.util.Date limite_superior = limitesFechas.get(1);
                System.out.println(limitesFechas);
                System.out.println("limite_inferior: " + limite_inferior);
                System.out.println("limite_superior: " + limite_superior);

                llenar_tabla_por_mes(limite_inferior, limite_superior);
            }

        }

        if (e.getSource() == vista.txtMostrarTodo) {

            System.out.println("Procediendo a llenar todo la tabla");
            llenar_tabla_mostrar_todo();
        }

        if (e.getSource() == vista.txtImprimirPDF) {

            generarPDF();
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

    public CtrlVentana_Estado_Cuenta(Ventana_Estado_Cuenta vista, Consulta_Limites_Fechas consulta_limites_fechas, int usuario_id) {
        this.vista = vista;
        this.consulta_limites_fechas = consulta_limites_fechas;
        this.usuario_id = usuario_id;

        //Botones
        this.vista.txtFiltrar.addMouseListener(this);
        this.vista.txtMostrarTodo.addMouseListener(this);
        this.vista.txtImprimirPDF.addMouseListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        llenarDatos_Fechas();
        llenar_tabla_mostrar_todo();

    }

    private void llenar_tabla_por_mes(java.util.Date limite_inferior, java.util.Date limite_superior) {
        try {
            MyTableModel modelo = new MyTableModel(new Object[][]{}, new Object[]{"Tipo", "ID", "MONTO", "FECHA", "DESCRIPCION"});
            this.vista.jtEstadoCuenta.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT 'Ingreso' AS Tipo, ID AS ID, MONTO_INGRESO AS MONTO, FECHA_INGRESO AS FECHA, DESCRIPCION_INGRESO AS DESCRIPCION, usuario_id\n"
                    + "FROM ingreso\n"
                    + "WHERE usuario_id = ? AND FECHA_INGRESO BETWEEN ? AND ? -- Personalizar el usuario_id y el rango de fechas según tus necesidades\n"
                    + "UNION\n"
                    + "SELECT 'Egreso' AS Tipo, ID_EGRESO AS ID, MONTO_EGRESO AS MONTO, FECHA_EGRESO AS FECHA, TIPO_EGRESO AS DESCRIPCION, usuario_id\n"
                    + "FROM egreso\n"
                    + "WHERE usuario_id = ? AND FECHA_EGRESO BETWEEN ? AND ? -- Personalizar el usuario_id y el rango de fechas según tus necesidades\n"
                    + "ORDER BY FECHA DESC;";

            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setDate(2, new java.sql.Date(limite_inferior.getTime()));
            ps.setDate(3, new java.sql.Date(limite_superior.getTime()));
            ps.setInt(4, usuario_id);
            ps.setDate(5, new java.sql.Date(limite_inferior.getTime()));
            ps.setDate(6, new java.sql.Date(limite_superior.getTime()));
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 40;
            int[] anchos = {50, 50, 50, 50, 300};
            this.vista.jtEstadoCuenta.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtEstadoCuenta.getColumnCount(); i++) {
                this.vista.jtEstadoCuenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelo.addRow(filas);

            }

            //Ver o no encabezado
            this.vista.jtEstadoCuenta.getTableHeader().setVisible(false);
            this.vista.jtEstadoCuenta.setBorder(BorderFactory.createEmptyBorder());
            this.vista.jtEstadoCuenta.setIntercellSpacing(new java.awt.Dimension(0, 0));

            this.vista.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));

            javax.swing.table.TableColumnModel columnModel = this.vista.jtEstadoCuenta.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);

            javax.swing.table.TableColumn idColumn1 = columnModel.getColumn(1);
            idColumn1.setMinWidth(0);
            idColumn1.setMaxWidth(0);
            idColumn1.setPreferredWidth(0);
            idColumn1.setResizable(false);

            colorearFilas();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    private void llenar_tabla_mostrar_todo() {
        try {
            MyTableModel modelo = new MyTableModel(new Object[][]{}, new Object[]{"Tipo", "ID", "MONTO", "FECHA", "DESCRIPCION"});
            this.vista.jtEstadoCuenta.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT 'Ingreso' AS Tipo, ID AS ID, MONTO_INGRESO AS MONTO, FECHA_INGRESO AS FECHA, DESCRIPCION_INGRESO AS DESCRIPCION, usuario_id\n"
                    + "FROM ingreso\n"
                    + "WHERE usuario_id = ? -- Personalizar el usuario_id según tus necesidades\n"
                    + "UNION\n"
                    + "SELECT 'Egreso' AS Tipo, ID_EGRESO AS ID, MONTO_EGRESO AS MONTO, FECHA_EGRESO AS FECHA, TIPO_EGRESO AS DESCRIPCION, usuario_id\n"
                    + "FROM egreso\n"
                    + "WHERE usuario_id = ? -- Personalizar el usuario_id según tus necesidades\n"
                    + "ORDER BY FECHA DESC;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ps.setInt(2, usuario_id);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 40;
            int[] anchos = {50, 50, 50, 50, 300};
            this.vista.jtEstadoCuenta.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtEstadoCuenta.getColumnCount(); i++) {
                this.vista.jtEstadoCuenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelo.addRow(filas);

            }

            //Ver o no encabezado
            this.vista.jtEstadoCuenta.getTableHeader().setVisible(false);
            this.vista.jtEstadoCuenta.setBorder(BorderFactory.createEmptyBorder());
            this.vista.jtEstadoCuenta.setIntercellSpacing(new java.awt.Dimension(0, 0));

            this.vista.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));

            javax.swing.table.TableColumnModel columnModel = this.vista.jtEstadoCuenta.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);

            javax.swing.table.TableColumn idColumn1 = columnModel.getColumn(1);
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
                String tipoValue = table.getModel().getValueAt(row, 0).toString();

                if (tipoValue.equals("Ingreso")) {
                    setForeground(new Color(18, 184, 134)); // Color for Incomes
                } else if (tipoValue.equals("Egreso")) {
                    setForeground(new Color(194, 39, 94)); // Color for Expenses
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
        for (int i = 0; i < this.vista.jtEstadoCuenta.getColumnCount(); i++) {
            this.vista.jtEstadoCuenta.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void llenarDatos_Fechas() {

        Consulta_Fechas_Select consulta_fechas_select = new Consulta_Fechas_Select();
        ArrayList<Datos_Fechas> listaDatos_Fechas = consulta_fechas_select.getDatos_Fechas();

        vista.cbxFechas.removeAllItems();

        for (int i = 0; i < listaDatos_Fechas.size(); i++) {

            vista.cbxFechas.addItem(new Datos_Fechas(listaDatos_Fechas.get(i).getID_FECHA(), listaDatos_Fechas.get(i).getLIMITE_INFERIOR(), listaDatos_Fechas.get(i).getLIMITE_SUPERIOR(), listaDatos_Fechas.get(i).getMES_ANO()));

        }

    }

    private void generarPDF() {
        Document document = new Document();

        try {
            // Obtiene la ruta del escritorio de Windows
            String desktopPath = Paths.get(System.getProperty("user.home"), "Desktop").toString();

            // Ruta completa donde se guardará el archivo PDF en el escritorio
            String filePath = Paths.get(desktopPath, "Estado de Cuenta.pdf").toString();

            // Crea el documento PDF en la ruta del escritorio
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Añade el título al documento
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Paragraph title = new Paragraph("REPORTE DE ESTADO DE CUENTA", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Añade la descripción al documento con dos saltos de línea y alineación izquierda
            Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
            Paragraph content = new Paragraph("A continuación se detallan los ingresos y egresos por fecha.\n", contentFont);
            content.setAlignment(Element.ALIGN_LEFT);
            content.setSpacingBefore(10f); // Ajusta el espacio antes del párrafo
            content.setSpacingAfter(20f); // Ajusta el espacio después del párrafo según sea necesario
            document.add(content);

            // Añade los datos del jTable al documento
            PdfPTable pdfTable = new PdfPTable(4); // Número de columnas que deseas mostrar

            // Personaliza el ancho de las columnas
            float[] columnWidths = {2f, 2f, 2f, 2f}; // Puedes ajustar estos valores según tus necesidades

            // Configura el ancho de las columnas
            pdfTable.setWidths(columnWidths);

            // Añade las cabeceras de las columnas que deseas mostrar
            String[] columnHeaders = {"TIPO", "MONTO", "FECHA", "DESCRIPCION"}; // Reemplaza con los nombres reales de tus columnas
            for (String header : columnHeaders) {
                PdfPCell headerCell = new PdfPCell(new Phrase(header));

                // Configura la alineación de las cabeceras al centro
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                pdfTable.addCell(headerCell);
            }

            // Añade las filas con datos para las columnas seleccionadas
            for (int row = 0; row < this.vista.jtEstadoCuenta.getRowCount(); row++) {
                for (int column : new int[]{0, 2, 3, 4}) { // Columnas 2, 3 y 4
                    PdfPCell cell = new PdfPCell(new Phrase(this.vista.jtEstadoCuenta.getValueAt(row, column).toString()));

                    // Configura la alineación de las celdas al centro
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                    // Personaliza la altura de la celda
                    cell.setMinimumHeight(20f); // Puedes ajustar este valor según tus necesidades

                    // Añade la celda a la tabla
                    pdfTable.addCell(cell);
                }
            }

            document.add(pdfTable);

        } catch (DocumentException | java.io.IOException ex) {
            System.err.println("Error al generar el PDF: " + ex.getMessage());
        } finally {
            document.close();
            // Mensaje de confirmación
            JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente en el escritorio.", "Generación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            abrirPDF();
        }
    }

    private void abrirPDF() {
        try {
            String desktopPath = Paths.get(System.getProperty("user.home"), "Desktop").toString();
            String filePath = Paths.get(desktopPath, "Estado de Cuenta.pdf").toString();

            File file = new File(filePath);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("La apertura automática no es compatible en este sistema.");
            }
        } catch (Exception ex) {
            System.err.println("Error al abrir el PDF: " + ex.getMessage());
        }
    }

}
