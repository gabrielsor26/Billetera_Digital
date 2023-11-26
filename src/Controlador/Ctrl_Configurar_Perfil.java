/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Categoria_Ingreso_Insert;
import Modelo.Consulta_Familia_Insert;
import Modelo.Consulta_Nombre_Ventana_Saldo;
import Modelo.Consulta_Tipo_Servicio_Insert;
import Modelo.Datos_Categoria_Ingreso;
import Modelo.Datos_Familia;
import Modelo.Datos_Recordatorio;
import Modelo.Datos_Tipo_Servicio;
import Vista.Ventana_Configurar_Perfil;
import static Vista.Ventana_Login.usuario_id;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ctrl_Configurar_Perfil implements MouseListener {

    private final Datos_Categoria_Ingreso modelo;
    private final Consulta_Categoria_Ingreso_Insert consultas;
    private final Datos_Familia modelofamilia;
    private final Consulta_Familia_Insert consultafamilia;
    private final Datos_Tipo_Servicio modeloservicio;
    private final Consulta_Tipo_Servicio_Insert consultaservicio;
    private final Ventana_Configurar_Perfil vista;
    private final int usuario_id;
    private final Consulta_Nombre_Ventana_Saldo consultaNombre;

    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return false; // La columna 0, 1, 5 (ID) no será editable
        }
    }

    public class MyTableModel1 extends DefaultTableModel {

        public MyTableModel1(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return false; // La columna 0, 1, 5 (ID) no será editable
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

    public Ctrl_Configurar_Perfil(Datos_Categoria_Ingreso modelo, Consulta_Categoria_Ingreso_Insert consultas, Datos_Familia modelofamilia, Consulta_Familia_Insert consultafamilia, Datos_Tipo_Servicio modeloservicio, Consulta_Tipo_Servicio_Insert consultaservicio, Ventana_Configurar_Perfil vista, int usuario_id, Consulta_Nombre_Ventana_Saldo consultaNombre) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.modelofamilia = modelofamilia;
        this.consultafamilia = consultafamilia;
        this.modeloservicio = modeloservicio;
        this.consultaservicio = consultaservicio;
        this.vista = vista;
        this.usuario_id = usuario_id;
        this.consultaNombre = consultaNombre;

        //Botones
        this.vista.txtModificarUsuario.addMouseListener(this);
        this.vista.txtAgregar.addMouseListener(this);
        this.vista.txtEliminar.addMouseListener(this);
        this.vista.txtAgregarFamilia.addMouseListener(this);
        this.vista.txtEliminarFamilia.addMouseListener(this);
        this.vista.txtAgregarServicio.addMouseListener(this);
        this.vista.txtEliminarServicio.addMouseListener(this);

    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);

        PreparedStatement ps = null;
        ResultSet rs = null;

        //Nombre en la parte superior
        String nombre = consultaNombre.obtenerNombreUsuario(usuario_id);
        int r = 26;
        int g = 177;
        int b = 136;
        String colorHex = String.format("#%02X%02X%02X", r, g, b);
        vista.txtBienvenida.setText("<html>Perfil de <font color='" + colorHex + "'>" + "[" + nombre + "]" + "</font></html>");

        //Llenado de datos de usuario
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            ps = conn.prepareStatement("SELECT usuario_id, nombre, apellido, email, pass, tipo_nivel FROM usuarios WHERE usuario_id=?");
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            while (rs.next()) {

                vista.txtNombre.setText(rs.getString("nombre"));
                vista.txtApellido.setText(rs.getString("apellido"));
                vista.txtEmail.setText(rs.getString("email"));
                vista.txtContraseña.setText(rs.getString("pass"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        //Tabla Categorizar Ingreso
        mostrarTablaCategoria();
        mostrarTablaFamilia();
        mostrarTablaServicios();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Manejar el evento de clic en el JLabel txtModificar aquí
        if (e.getSource() == vista.txtModificarUsuario) {

            PreparedStatement ps = null;
            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                ps = conn.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?, email=?, pass=? WHERE usuario_id=?");

                ps.setString(1, vista.txtNombre.getText());
                ps.setString(2, vista.txtApellido.getText());
                ps.setString(3, vista.txtEmail.getText());
                ps.setString(4, vista.txtContraseña.getText());
                ps.setInt(5, usuario_id);

                ps.execute();

                JOptionPane.showMessageDialog(null, "Usuario Modificado");
                //jtUsuarios.setValueAt(txtCodigo.getText(), Fila, 0);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Modificar Usuario");
                System.out.println(ex);
            }
        }

        if (e.getSource() == vista.txtAgregar) {

            String tipo_ingreso_recurrente = JOptionPane.showInputDialog("Ingrese el Tipo de Ingreso Recurrente");
            Double monto_ingreso_recurrente = Double.valueOf(JOptionPane.showInputDialog("Ingrese el monto recurrente del Ingreso"));

            modelo.setTIPO_INGRESO(tipo_ingreso_recurrente);
            modelo.setMONTO_INGRESO_FIJO(monto_ingreso_recurrente);

            if (consultas.registrar(modelo, usuario_id)) {
                mostrarTablaCategoria();
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }

        }

        if (e.getSource() == vista.txtEliminar) {

            int Fila = vista.jtCategoriaIngreso.getSelectedRow();

            if (Fila < 0) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila antes de eliminar.");
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                PreparedStatement ps = null;
                int codigo = (int) vista.jtCategoriaIngreso.getValueAt(Fila, 0);

                try {
                    Conexion objCon = new Conexion();
                    Connection conn = objCon.getConexion();

                    ps = conn.prepareStatement("DELETE FROM categoria_ingreso WHERE ID_CATEGORIA_INGRESO=?");
                    ps.setString(1, String.valueOf(codigo));
                    ps.execute();

                    ((MyTableModel) vista.jtCategoriaIngreso.getModel()).removeRow(Fila);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar Usuario");
                    System.out.println(ex.toString());
                }
            }
            mostrarTablaCategoria();
        }

        if (e.getSource() == vista.txtAgregarFamilia) {

            String nombre_familiar = JOptionPane.showInputDialog("Ingrese el nombre del miembro familiar");
            String parentesco_familiar = JOptionPane.showInputDialog("Ingrese la relacion de parentesco con el familiar");

            String miembro = nombre_familiar + " - " + parentesco_familiar;
            modelofamilia.setRELACION_FAMILIAR(miembro);

            if (consultafamilia.registrar(modelofamilia, usuario_id)) {
                mostrarTablaFamilia();
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }

        }

        if (e.getSource() == vista.txtEliminarFamilia) {

            int Fila = vista.jtFamilia.getSelectedRow();

            if (Fila < 0) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila antes de eliminar.");
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                PreparedStatement ps = null;
                int codigo = (int) vista.jtFamilia.getValueAt(Fila, 0);

                try {
                    Conexion objCon = new Conexion();
                    Connection conn = objCon.getConexion();

                    ps = conn.prepareStatement("DELETE FROM familia WHERE ID_FAMILIA=?");
                    ps.setString(1, String.valueOf(codigo));
                    ps.execute();

                    ((MyTableModel1) vista.jtFamilia.getModel()).removeRow(Fila);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar Usuario");
                    System.out.println(ex.toString());
                }
            }
            mostrarTablaFamilia();
        }

        if (e.getSource() == vista.txtAgregarServicio) {

            String servicio = JOptionPane.showInputDialog("Ingrese un servicio que paga recurrentemente");

            modeloservicio.setTIPO_SERVICIO(servicio);

            if (consultaservicio.registrar(modeloservicio, usuario_id)) {
                mostrarTablaServicios();
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }

        }

        if (e.getSource() == vista.txtEliminarServicio) {

            int Fila = vista.jtTipoServicio.getSelectedRow();

            if (Fila < 0) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila antes de eliminar.");
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                PreparedStatement ps = null;
                int codigo = (int) vista.jtTipoServicio.getValueAt(Fila, 0);

                try {
                    Conexion objCon = new Conexion();
                    Connection conn = objCon.getConexion();

                    ps = conn.prepareStatement("DELETE FROM tipo_servicio WHERE ID_SERVICIO=?");
                    ps.setString(1, String.valueOf(codigo));
                    ps.execute();

                    ((MyTableModel1) vista.jtTipoServicio.getModel()).removeRow(Fila);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar Usuario");
                    System.out.println(ex.toString());
                }
            }
            mostrarTablaServicios();
        }

    }

    public void mostrarTablaCategoria() {

        PreparedStatement ps1 = null;
        ResultSet rs1 = null;

        try {
            MyTableModel modelotabla = new MyTableModel(new Object[][]{}, new Object[]{"ID_CATEGORIA_INGRESO", "TIPO_INGRESO", "MONTO_INGRESO_FIJO", "usuario_id"});
            this.vista.jtCategoriaIngreso.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_CATEGORIA_INGRESO, TIPO_INGRESO, MONTO_INGRESO_FIJO, usuario_id FROM categoria_ingreso WHERE usuario_id = ?";
            ps1 = con.prepareStatement(sql);
            ps1.setInt(1, usuario_id);
            rs1 = ps1.executeQuery();

            ResultSetMetaData rsMd1 = (ResultSetMetaData) rs1.getMetaData();
            int cantidadColumnas = rsMd1.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 50};
            this.vista.jtCategoriaIngreso.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtCategoriaIngreso.getColumnCount(); i++) {
                this.vista.jtCategoriaIngreso.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtCategoriaIngreso.getColumnCount(); i++) {
                vista.jtCategoriaIngreso.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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

            javax.swing.table.TableColumnModel columnModel = vista.jtCategoriaIngreso.getColumnModel();
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

        this.vista.jtCategoriaIngreso.getTableHeader().setVisible(false);
        this.vista.jtCategoriaIngreso.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtCategoriaIngreso.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane1.getViewport().setBackground(new Color(0, 92, 75));
    }

    public void mostrarTablaFamilia() {

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        try {
            MyTableModel1 modelotabla2 = new MyTableModel1(new Object[][]{}, new Object[]{"ID_FAMILIA", "RELACION_FAMILIAR", "usuario_id"});
            this.vista.jtFamilia.setModel(modelotabla2);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_FAMILIA, RELACION_FAMILIAR, usuario_id FROM familia WHERE usuario_id = ?";
            ps2 = con.prepareStatement(sql);
            ps2.setInt(1, usuario_id);
            rs2 = ps2.executeQuery();

            ResultSetMetaData rsMd2 = (ResultSetMetaData) rs2.getMetaData();
            int cantidadColumnas = rsMd2.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 50};
            this.vista.jtFamilia.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtFamilia.getColumnCount(); i++) {
                this.vista.jtFamilia.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtFamilia.getColumnCount(); i++) {
                vista.jtFamilia.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs2.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs2.getObject(i + 1);
                    System.out.print(rs2.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla2.addRow(filas);

            }

            javax.swing.table.TableColumnModel columnModel = vista.jtFamilia.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn2 = columnModel.getColumn(2);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn2.setMinWidth(0);
            idColumn2.setMaxWidth(0);
            idColumn2.setPreferredWidth(0);
            idColumn2.setResizable(false);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtFamilia.getTableHeader().setVisible(false);
        this.vista.jtFamilia.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtFamilia.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane3.getViewport().setBackground(new Color(0, 92, 75));
    }

    public void mostrarTablaServicios() {

        PreparedStatement ps3 = null;
        ResultSet rs3 = null;

        try {
            MyTableModel2 modelotabla = new MyTableModel2(new Object[][]{}, new Object[]{"ID_SERVICIO", "TIPO_SERVICIO", "usuario_id"});
            this.vista.jtTipoServicio.setModel(modelotabla);
            //PreparedStatement ps = null;
            //ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_SERVICIO, TIPO_SERVICIO, usuario_id FROM tipo_servicio WHERE usuario_id = ?";
            ps3 = con.prepareStatement(sql);
            ps3.setInt(1, usuario_id);
            rs3 = ps3.executeQuery();

            ResultSetMetaData rsMd3 = (ResultSetMetaData) rs3.getMetaData();
            int cantidadColumnas = rsMd3.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 50};
            this.vista.jtTipoServicio.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtTipoServicio.getColumnCount(); i++) {
                this.vista.jtTipoServicio.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < vista.jtTipoServicio.getColumnCount(); i++) {
                vista.jtTipoServicio.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs3.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs3.getObject(i + 1);
                    System.out.print(rs3.getObject(i + 1) + " ");
                }

                System.out.println();
                modelotabla.addRow(filas);

            }

            javax.swing.table.TableColumnModel columnModel = vista.jtTipoServicio.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn2 = columnModel.getColumn(2);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn2.setMinWidth(0);
            idColumn2.setMaxWidth(0);
            idColumn2.setPreferredWidth(0);
            idColumn2.setResizable(false);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        this.vista.jtTipoServicio.getTableHeader().setVisible(false);
        this.vista.jtTipoServicio.setBorder(BorderFactory.createEmptyBorder());
        this.vista.jtTipoServicio.setIntercellSpacing(new java.awt.Dimension(0, 0));
        this.vista.jScrollPane4.getViewport().setBackground(new Color(0, 92, 75));
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
