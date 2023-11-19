/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Vista.Ventana_Ahorros;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CtrlVentana_Ahorros implements MouseListener {

    private final Ventana_Ahorros vista;
    private final Consulta_Obtener_Suma_Ingresos consultaSumaIngresos;
    private final Consulta_Obtener_Suma_Egresos consultaSumaEgresos;
    private final Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados;
    private final Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado;
    private final Consulta_Obtener_Dinero_Inversion consultaDineroInversion;
    private final int usuario_id;
    DefaultTableModel modelo = new DefaultTableModel();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.txtAgregar) {

            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
            double obtenerDineroInversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);
            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado - obtenerDineroInversion;

            int ID_AHORRO = (int) this.vista.jtAhorros.getValueAt(0, 0);
            Double DINERO_AHORRADO = (Double) this.vista.jtAhorros.getValueAt(0, 1);
            Double RECURSO = 0.0;

            String input = JOptionPane.showInputDialog("Indique el monto que desea agregar a dinero ahorrado");

            if (input != null && !input.isEmpty()) {
                try {
                    RECURSO = Double.parseDouble(input);

                    if (RECURSO >= 0) {
                        if (RECURSO <= saldo_disponible) {
                            DINERO_AHORRADO = DINERO_AHORRADO + RECURSO;

                            PreparedStatement ps = null;
                            try {
                                Conexion objCon = new Conexion();
                                Connection conn = objCon.getConexion();
                                ps = conn.prepareStatement("UPDATE ahorros SET DINERO_AHORRADO=? WHERE ID_AHORRO=?");

                                ps.setDouble(1, DINERO_AHORRADO);
                                ps.setInt(2, ID_AHORRO);

                                ps.execute();

                                JOptionPane.showMessageDialog(null, "Ahorro Modificado");
                                this.vista.jtAhorros.setValueAt(DINERO_AHORRADO, 0, 1);

                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Error al Modificar Ahorro");
                                System.out.println(ex);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "<html><center>No tiene el suficiente saldo para agregar esta cantidad de recursos. <br> Su saldo disponible actual es: " + saldo_disponible + " <html>");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número mayor o igual que 0");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
                }
            } else {
                // Maneja el caso en el que el usuario cancela el diálogo de entrada
            }

            System.out.println(ID_AHORRO);
            System.out.println(DINERO_AHORRADO);

        }

        if (e.getSource() == vista.txtQuitar) {
            
            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado;

            int ID_AHORRO = (int) this.vista.jtAhorros.getValueAt(0, 0);
            Double DINERO_AHORRADO = (Double) this.vista.jtAhorros.getValueAt(0, 1);
            Double RECURSO = 0.0;

            String input = JOptionPane.showInputDialog("Indique el monto que desea retirar a dinero ahorrado");

            if (input != null && !input.isEmpty()) {
                try {
                    RECURSO = Double.parseDouble(input);

                    if (RECURSO >= 0) {
                        if (RECURSO <= obtenerDineroAhorrado) {
                            DINERO_AHORRADO = DINERO_AHORRADO - RECURSO;

                            PreparedStatement ps = null;
                            try {
                                Conexion objCon = new Conexion();
                                Connection conn = objCon.getConexion();
                                ps = conn.prepareStatement("UPDATE ahorros SET DINERO_AHORRADO=? WHERE ID_AHORRO=?");

                                ps.setDouble(1, DINERO_AHORRADO);
                                ps.setInt(2, ID_AHORRO);

                                ps.execute();

                                JOptionPane.showMessageDialog(null, "Ahorro Modificado");
                                this.vista.jtAhorros.setValueAt(DINERO_AHORRADO, 0, 1);

                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Error al Modificar Ahorro");
                                System.out.println(ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "<html><center>El monto a retirar tiene que ser menor que el dinero ahorrado. <br> Dinero ahorrado actual es: " + obtenerDineroAhorrado + " <html>");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número mayor o igual que 0 y no mayor al dinero ahorrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
                }
            } else {
                // Maneja el caso en el que el usuario cancela el diálogo de entrada
            }

            System.out.println(ID_AHORRO);
            System.out.println(DINERO_AHORRADO);
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
            return column != 1; // La columna 0, 1, 5 (ID) no será editable
        }

    }

    public CtrlVentana_Ahorros(Ventana_Ahorros vista,
            Consulta_Obtener_Suma_Ingresos consultaSumaIngresos,
            Consulta_Obtener_Suma_Egresos consultaSumaEgresos,
            Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados,
            Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado,
            Consulta_Obtener_Dinero_Inversion consultaDineroInversion,
            int usuario_id) {

        this.vista = vista;
        this.consultaSumaIngresos = consultaSumaIngresos;
        this.consultaSumaEgresos = consultaSumaEgresos;
        this.consultaSumaRecursosAsignados = consultaSumaRecursosAsignados;
        this.consultaDineroAhorrado = consultaDineroAhorrado;
        this.consultaDineroInversion = consultaDineroInversion;
        this.usuario_id = usuario_id;

        //Botones
        this.vista.txtAgregar.addMouseListener(this);
        this.vista.txtQuitar.addMouseListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);

        try {
            MyTableModel modelo = new MyTableModel(new Object[][]{}, new Object[]{"ID_AHORROS", "DINERO_AHORRADO"});
            this.vista.jtAhorros.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_AHORRO, DINERO_AHORRADO, usuario_id FROM ahorros WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 20;
            int[] anchos = {50, 50, 50};
            this.vista.jtAhorros.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtAhorros.getColumnCount(); i++) {
                this.vista.jtAhorros.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

            for (int i = 0; i < this.vista.jtAhorros.getColumnCount(); i++) {
                this.vista.jtAhorros.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelo.addRow(filas);

                javax.swing.table.TableColumnModel columnModel = this.vista.jtAhorros.getColumnModel();
                javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
                idColumn.setMinWidth(0);
                idColumn.setMaxWidth(0);
                idColumn.setPreferredWidth(0);
                idColumn.setResizable(false);

            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

}
