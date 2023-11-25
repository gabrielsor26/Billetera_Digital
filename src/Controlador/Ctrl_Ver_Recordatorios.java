package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Tipo_Servicio_Select;
import Modelo.Datos_Recordatorio;
import Modelo.Datos_Tipo_Servicio;
import Vista.Ventana_Ver_Recordatorios;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ctrl_Ver_Recordatorios implements MouseListener {

    private final Ventana_Ver_Recordatorios vista;
    private final int usuario_id;
    DefaultTableModel modelo = new DefaultTableModel();

    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return column != 0; // La columna 0, 1, 5 (ID) no será editable
        }
    }

    public Ctrl_Ver_Recordatorios(Ventana_Ver_Recordatorios vista, int usuario_id) {
        this.vista = vista;
        this.usuario_id = usuario_id;
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
                    + "ORDER BY PRIORIDAD DESC;";
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

            this.vista.jScrollPane2.getViewport().setBackground(new Color(206, 212, 218));

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

    @Override
    public void mouseClicked(MouseEvent e) {
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
