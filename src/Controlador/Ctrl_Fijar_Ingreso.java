package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Categoria_Ingreso_Select;
import Modelo.Consulta_Datos_Presupuestos;
import Modelo.Consulta_Fechas_Select;
import Modelo.Datos_Categoria_Ingreso;
import Modelo.Datos_Fechas;
import Modelo.Datos_Presupuestos;
import Vista.Ventana_Fijar_Ingreso;
import static Vista.Ventana_Login.usuario_id;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ctrl_Fijar_Ingreso implements MouseListener {

    private final Datos_Presupuestos datos;
    private final Consulta_Datos_Presupuestos consulta;
    private final Ventana_Fijar_Ingreso vista;

    public Ctrl_Fijar_Ingreso(Datos_Presupuestos datos, Consulta_Datos_Presupuestos consulta, Ventana_Fijar_Ingreso vista) {
        this.datos = datos;
        this.consulta = consulta;
        this.vista = vista;

        //Botones
        this.vista.txtFijarPresupuestoIngreso.addMouseListener(this);
        this.vista.txtPrevisualizarPresupuesto.addMouseListener(this);
        this.vista.txtEliminarP.addMouseListener(this);
        this.vista.jtPrevisualizar.addMouseListener(this);
        this.vista.txtModificarP.addMouseListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        llenarDatos_Fechas();
        llenarDatos_Categoria();
        seleccionarMesAnoActualCbx();
        mostrarPrevisualizaciónCbxFecha1();

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

    public void mostrarPrevisualizaciónCbxFecha2() {

        PreparedStatement ps1 = null;
        ResultSet rs1 = null;

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha2.getSelectedItem();

            MyTableModel modelotabla = new MyTableModel(new Object[][]{}, new Object[]{"ID_PRESUPUESTOS", "CATEGORIA", "MONTO_PRESUPUESTO", "ID_FECHA"});
            this.vista.jtPrevisualizar.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_PRESUPUESTOS, CATEGORIA, MONTO_PRESUPUESTO, ID_FECHA, TIPO, usuario_id \n"
                    + "FROM presupuestos \n"
                    + "WHERE usuario_id = ? AND TIPO = 'Ingreso' AND ID_FECHA = ?;";
            ps1 = con.prepareStatement(sql);
            ps1.setInt(1, usuario_id);
            ps1.setInt(2, fecha.getID_FECHA());
            rs1 = ps1.executeQuery();

            ResultSetMetaData rsMd1 = (ResultSetMetaData) rs1.getMetaData();
            int cantidadColumnas = rsMd1.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 50};
            this.vista.jtPrevisualizar.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtPrevisualizar.getColumnCount(); i++) {
                this.vista.jtPrevisualizar.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtPrevisualizar.getColumnCount(); i++) {
                vista.jtPrevisualizar.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs1.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs1.getObject(i + 1);
                    System.out.print(rs1.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla.addRow(filas);

            }

            javax.swing.table.TableColumnModel columnModel = vista.jtPrevisualizar.getColumnModel();
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

        this.vista.jtPrevisualizar.getTableHeader().setVisible(false);
        this.vista.jtPrevisualizar.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtPrevisualizar.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
    }

    public void mostrarPrevisualizaciónCbxFecha1() {

        PreparedStatement ps1 = null;
        ResultSet rs1 = null;

        try {

            Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha1.getSelectedItem();

            MyTableModel modelotabla = new MyTableModel(new Object[][]{}, new Object[]{"ID_PRESUPUESTOS", "CATEGORIA", "MONTO_PRESUPUESTO", "ID_FECHA"});
            this.vista.jtPrevisualizar.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_PRESUPUESTOS, CATEGORIA, MONTO_PRESUPUESTO, ID_FECHA, TIPO, usuario_id \n"
                    + "FROM presupuestos \n"
                    + "WHERE usuario_id = ? AND TIPO = 'Ingreso' AND ID_FECHA = ?;";
            ps1 = con.prepareStatement(sql);
            ps1.setInt(1, usuario_id);
            ps1.setInt(2, fecha.getID_FECHA());
            rs1 = ps1.executeQuery();

            ResultSetMetaData rsMd1 = (ResultSetMetaData) rs1.getMetaData();
            int cantidadColumnas = rsMd1.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 50};
            this.vista.jtPrevisualizar.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtPrevisualizar.getColumnCount(); i++) {
                this.vista.jtPrevisualizar.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtPrevisualizar.getColumnCount(); i++) {
                vista.jtPrevisualizar.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs1.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs1.getObject(i + 1);
                    System.out.print(rs1.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla.addRow(filas);

            }

            javax.swing.table.TableColumnModel columnModel = vista.jtPrevisualizar.getColumnModel();
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

        this.vista.jtPrevisualizar.getTableHeader().setVisible(false);
        this.vista.jtPrevisualizar.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtPrevisualizar.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
    }

    public void llenarDatos_Categoria() {

        Consulta_Categoria_Ingreso_Select consulta_categoria_ingreso_select = new Consulta_Categoria_Ingreso_Select();
        ArrayList<Datos_Categoria_Ingreso> listaDatos_Categoria_Ingreso = consulta_categoria_ingreso_select.getDatos_Categoria_Ingreso();

        vista.cbxCategoria.removeAllItems();

        //vista.cbxCategoria.addItem(new Datos_Categoria_Ingreso("Seleccione ..."));
        for (int i = 0; i < listaDatos_Categoria_Ingreso.size(); i++) {

            vista.cbxCategoria.addItem(new Datos_Categoria_Ingreso(listaDatos_Categoria_Ingreso.get(i).getID_CATEGORIA_INGRESO(), listaDatos_Categoria_Ingreso.get(i).getTIPO_INGRESO(), listaDatos_Categoria_Ingreso.get(i).getMONTO_INGRESO_FIJO()));

        }
        //vista.cbxCategoria.addItem(new Datos_Categoria_Ingreso("Otros"));

        //vista.cbxCategoria.setSelectedItem("Seleccione ...");
    }

    public void llenarDatos_Fechas() {

        Consulta_Fechas_Select consulta_fechas_select = new Consulta_Fechas_Select();
        ArrayList<Datos_Fechas> listaDatos_Fechas = consulta_fechas_select.getDatos_Fechas();

        vista.cbxFecha1.removeAllItems();
        vista.cbxFecha2.removeAllItems();

        for (int i = 0; i < listaDatos_Fechas.size(); i++) {

            vista.cbxFecha1.addItem(new Datos_Fechas(listaDatos_Fechas.get(i).getID_FECHA(), listaDatos_Fechas.get(i).getLIMITE_INFERIOR(), listaDatos_Fechas.get(i).getLIMITE_SUPERIOR(), listaDatos_Fechas.get(i).getMES_ANO()));

        }

        for (int i = 0; i < listaDatos_Fechas.size(); i++) {

            vista.cbxFecha2.addItem(new Datos_Fechas(listaDatos_Fechas.get(i).getID_FECHA(), listaDatos_Fechas.get(i).getLIMITE_INFERIOR(), listaDatos_Fechas.get(i).getLIMITE_SUPERIOR(), listaDatos_Fechas.get(i).getMES_ANO()));

        }

    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void crearpresupuestoingreso() {
        //CATEGORIA            
        Datos_Categoria_Ingreso categoria = (Datos_Categoria_Ingreso) vista.cbxCategoria.getSelectedItem();
        datos.setCATEGORIA(categoria.getTIPO_INGRESO());
        System.out.println(categoria.getTIPO_INGRESO());
        // MONTO
        try {
            Double monto = Double.parseDouble(vista.txtMontoPresupuesto.getText());
            if (monto <= 0) {
                mostrarError("El monto debe ser mayor que cero.");
            } else {
                datos.setMONTO_PRESUPUESTO(monto);
            }
        } catch (NumberFormatException e) {
            mostrarError("Debe ingresar un valor valido no nulo en MONTO PRESUPUESTO");
        }

        //RANGO
        Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha1.getSelectedItem();
        datos.setID_FECHA(fecha.getID_FECHA());
        System.out.println(fecha.getID_FECHA());
        //TIPO = Ingreso
        datos.setTIPO("Ingreso");

        if (consulta.registrar(datos, usuario_id)) {

            JOptionPane.showMessageDialog(null, "Registro Guardado");
            mostrarPrevisualizaciónCbxFecha1();
            vista.cbxFecha2.setSelectedIndex(fecha.getID_FECHA() - 1);

        } else {
            mostrarError("Error al Guardar");
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

            vista.cbxFecha1.setSelectedIndex(id_fecha - 1);
            vista.cbxFecha2.setSelectedIndex(id_fecha - 1);

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.txtFijarPresupuestoIngreso) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {

                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                Datos_Categoria_Ingreso categoria = (Datos_Categoria_Ingreso) vista.cbxCategoria.getSelectedItem();
                Datos_Fechas fecha = (Datos_Fechas) vista.cbxFecha1.getSelectedItem();
                // Consulta para verificar si existe un registro con ese categoria - fecha
                String sql = "SELECT COUNT(*) \n"
                        + "FROM presupuestos \n"
                        + "WHERE CATEGORIA = ? AND ID_FECHA = ? AND TIPO = 'Ingreso';";
                ps = conn.prepareStatement(sql);
                ps.setString(1, categoria.getTIPO_INGRESO());
                ps.setInt(2, fecha.getID_FECHA());
                rs = ps.executeQuery();
                rs.next();

                System.out.println(categoria.getTIPO_INGRESO() + " " + fecha.getID_FECHA());

                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Ya existe un registro con esa categoria - fecha. Si desea modificarlo intentelo a la derecha");
                    mostrarPrevisualizaciónCbxFecha1();
                    vista.cbxFecha2.setSelectedIndex(fecha.getID_FECHA() - 1);

                } else {
                    crearpresupuestoingreso();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        }

        if (e.getSource() == vista.txtPrevisualizarPresupuesto) {

            mostrarPrevisualizaciónCbxFecha2();

        }

        if (e.getSource() == vista.txtEliminarP) {

            int Fila = vista.jtPrevisualizar.getSelectedRow();

            if (Fila < 0) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila antes de eliminar.");
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                PreparedStatement ps = null;
                int codigo = (int) vista.jtPrevisualizar.getValueAt(Fila, 0);

                try {
                    Conexion objCon = new Conexion();
                    Connection conn = objCon.getConexion();

                    ps = conn.prepareStatement("DELETE FROM presupuestos WHERE ID_PRESUPUESTOS=?");
                    ps.setString(1, String.valueOf(codigo));
                    ps.execute();

                    ((MyTableModel) vista.jtPrevisualizar.getModel()).removeRow(Fila);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar Registro");
                    System.out.println(ex.toString());
                }
            }
            mostrarPrevisualizaciónCbxFecha2();
        }

        if (e.getSource() == vista.jtPrevisualizar) {

            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();

                int Fila = vista.jtPrevisualizar.getSelectedRow();

                String codigo = vista.jtPrevisualizar.getValueAt(Fila, 0).toString();

                System.out.println("El valor de codigo es: " + codigo);

                ps = conn.prepareStatement("SELECT MONTO_PRESUPUESTO FROM presupuestos WHERE ID_PRESUPUESTOS=?");
                ps.setString(1, codigo);
                rs = ps.executeQuery();

                while (rs.next()) {

                    vista.txtMontoPresupuesto.setText(rs.getString("MONTO_PRESUPUESTO"));

                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

        }

        if (e.getSource() == vista.txtModificarP) {
            int Fila = vista.jtPrevisualizar.getSelectedRow();
            int ID_PRESUPUESTOS = (int) vista.jtPrevisualizar.getValueAt(Fila, 0);

            System.out.println("La fila es: " + Fila);

            PreparedStatement ps = null;
            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                ps = conn.prepareStatement("UPDATE presupuestos SET MONTO_PRESUPUESTO=? WHERE ID_PRESUPUESTOS=?");

                ps.setString(1, vista.txtMontoPresupuesto.getText());
                ps.setString(2, String.valueOf(ID_PRESUPUESTOS));

                ps.execute();

                JOptionPane.showMessageDialog(null, "Registro Modificado");
                //jtUsuarios.setValueAt(txtCodigo.getText(), Fila, 0);
                vista.jtPrevisualizar.setValueAt(vista.txtMontoPresupuesto.getText(), Fila, 2);

                vista.txtMontoPresupuesto.setText("");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Modificar Registro");
                System.out.println(ex);
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
