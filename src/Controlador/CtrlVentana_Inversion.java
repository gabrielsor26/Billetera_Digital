package Controlador;

import Modelo.Conexion;
import Modelo.Consulta_Obtener_Dinero_Ahorrado;
import Modelo.Consulta_Obtener_Dinero_Inversion;
import Modelo.Consulta_Obtener_Suma_Egresos;
import Modelo.Consulta_Obtener_Suma_Ingresos;
import Modelo.Consulta_Obtener_Suma_Recursos_Asignados_Metas;
import Vista.Ventana_Inversion;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CtrlVentana_Inversion implements MouseListener {

    private final Ventana_Inversion vista;
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
            return column != 1; // La columna 0, 1, 5 (ID) no será editable
        }

    }

    public CtrlVentana_Inversion(Ventana_Inversion vista,
            Consulta_Obtener_Suma_Ingresos consultaSumaIngresos,
            Consulta_Obtener_Suma_Egresos consultaSumaEgresos,
            Consulta_Obtener_Suma_Recursos_Asignados_Metas consultaSumaRecursosAsignados,
            Consulta_Obtener_Dinero_Ahorrado consultaDineroAhorrado,
            Consulta_Obtener_Dinero_Inversion consultaDineroInversion, int usuario_id) {
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.txtAgregar) {

            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
            double obtenerDineroInversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);
            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado - obtenerDineroInversion;

            int ID_INVERSION = (int) this.vista.jtInversion.getValueAt(0, 0);
            Double DINERO_INVERSION = (Double) this.vista.jtInversion.getValueAt(0, 1);
            Double RECURSO = 0.0;

            String input = JOptionPane.showInputDialog("Indique el monto que desea agregar a inversion");

            if (input != null && !input.isEmpty()) {
                try {
                    RECURSO = Double.parseDouble(input);

                    if (RECURSO >= 0) {
                        if (RECURSO <= saldo_disponible) {
                            DINERO_INVERSION = DINERO_INVERSION + RECURSO;

                            PreparedStatement ps = null;
                            try {
                                Conexion objCon = new Conexion();
                                Connection conn = objCon.getConexion();
                                ps = conn.prepareStatement("UPDATE inversion SET DINERO_INVERSION=? WHERE ID_INVERSION=?");

                                ps.setDouble(1, DINERO_INVERSION);
                                ps.setInt(2, ID_INVERSION);

                                ps.execute();

                                JOptionPane.showMessageDialog(null, "Inversion Modificada");
                                this.vista.jtInversion.setValueAt(DINERO_INVERSION, 0, 1);

                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Error al Modificar Inversion");
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

            System.out.println(ID_INVERSION);
            System.out.println(DINERO_INVERSION);

        }

        if (e.getSource() == vista.txtQuitar) {

            double sumaIngresos = consultaSumaIngresos.obtenerSumaIngresos(usuario_id);
            double sumaEgresos = consultaSumaEgresos.obtenerSumaEgresos(usuario_id);
            double sumaRecursosAsignados = consultaSumaRecursosAsignados.obtenerRecursosAsignados(usuario_id);
            double obtenerDineroAhorrado = consultaDineroAhorrado.obtenerDineroAhorrado(usuario_id);
            double obtenerDineroInversion = consultaDineroInversion.obtenerDineroInversion(usuario_id);
            double saldo_disponible = sumaIngresos - sumaEgresos - sumaRecursosAsignados - obtenerDineroAhorrado - obtenerDineroInversion;

            int ID_INVERSION = (int) this.vista.jtInversion.getValueAt(0, 0);
            Double DINERO_INVERSION = (Double) this.vista.jtInversion.getValueAt(0, 1);
            Double RECURSO = 0.0;

            String input = JOptionPane.showInputDialog("Indique el monto que desea quitar de inversion");

            if (input != null && !input.isEmpty()) {
                try {
                    RECURSO = Double.parseDouble(input);

                    if (RECURSO >= 0) {
                        if (RECURSO <= obtenerDineroInversion) {
                            DINERO_INVERSION = DINERO_INVERSION - RECURSO;

                            PreparedStatement ps = null;
                            try {
                                Conexion objCon = new Conexion();
                                Connection conn = objCon.getConexion();
                                ps = conn.prepareStatement("UPDATE inversion SET DINERO_INVERSION=? WHERE ID_INVERSION=?");

                                ps.setDouble(1, DINERO_INVERSION);
                                ps.setInt(2, ID_INVERSION);

                                ps.execute();

                                JOptionPane.showMessageDialog(null, "Inversion Modificada");
                                this.vista.jtInversion.setValueAt(DINERO_INVERSION, 0, 1);

                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Error al Modificar Inversion");
                                System.out.println(ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "<html><center>El monto a retirar tiene que ser menor que el dinero ahorrado. <br> Dinero destinado para inversion actual es: " + obtenerDineroInversion + " <html>");
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

            System.out.println(ID_INVERSION);
            System.out.println(DINERO_INVERSION);
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

    public void iniciar() {
        vista.setLocationRelativeTo(null);

        try {
            MyTableModel modelo = new MyTableModel(new Object[][]{}, new Object[]{"ID_INVERSION", "DINERO_INVERSION"});
            this.vista.jtInversion.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_INVERSION, DINERO_INVERSION, usuario_id FROM inversion WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 20;
            int[] anchos = {50, 50, 50};
            this.vista.jtInversion.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtInversion.getColumnCount(); i++) {
                this.vista.jtInversion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

            for (int i = 0; i < this.vista.jtInversion.getColumnCount(); i++) {
                this.vista.jtInversion.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.print(rs.getObject(i + 1) + " ");
                }

                System.out.println();
                modelo.addRow(filas);

                javax.swing.table.TableColumnModel columnModel = this.vista.jtInversion.getColumnModel();
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
