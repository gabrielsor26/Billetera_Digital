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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;
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
        this.vista.btnAtras.addActionListener(this);
        //this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnObtener.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnQuitar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Asignar Recursos");
        vista.setLocationRelativeTo(null);

        try {
            MyTableModel modelo = new MyTableModel(new Object[][]{}, new Object[]{"ID_META", "NOMBRE_META", "MONTO_META", "FECHA_LIMITE_META", "RECURSOS_ASIGNADOS", "ESTADO_META"});
            this.vista.jtMetas.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_META, NOMBRE_META, MONTO_META, FECHA_LIMITE_META, RECURSOS_ASIGNADOS, ESTADO_META, usuario_id FROM meta WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            int altoFila = 20;
            int[] anchos = {50, 50, 50, 50, 50, 50, 50};
            this.vista.jtMetas.setRowHeight(altoFila);

            for (int i = 0; i < this.vista.jtMetas.getColumnCount(); i++) {
                this.vista.jtMetas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnAtras) {
            vista.dispose();
            Ventana_Metas frm_metas = new Ventana_Metas();

            Ctrl_Metas ctrl_metas = new Ctrl_Metas(frm_metas);

            ctrl_metas.iniciar();
            frm_metas.setVisible(true);
        }
/*
        if (e.getSource() == vista.btnModificar) {

            if (vista.jtMetas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila de la tabla antes de modificar alguna meta.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del manejador de eventos si no se selecciona una fila
            }

            int Fila = this.vista.jtMetas.getSelectedRow();
            int ID_META = (int) this.vista.jtMetas.getValueAt(Fila, 0);
            String NOMBRE_META = (String) this.vista.jtMetas.getValueAt(Fila, 1);
            Double MONTO_META = (Double) this.vista.jtMetas.getValueAt(Fila, 2);
            java.sql.Date FECHA_LIMITE_META = (java.sql.Date) this.vista.jtMetas.getValueAt(Fila, 3);

            System.out.println(Fila);

            PreparedStatement ps = null;
            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();
                ps = conn.prepareStatement("UPDATE meta SET NOMBRE_META=?, MONTO_META=?, FECHA_LIMITE_META=? WHERE ID_META=?");

                ps.setString(1, NOMBRE_META);
                ps.setDouble(2, MONTO_META);
                ps.setDate(3, FECHA_LIMITE_META);
                ps.setInt(4, ID_META);

                ps.execute();

                JOptionPane.showMessageDialog(null, "Meta Modificado");
                //jtIngresos.setValueAt(txtCodigo.getText(), Fila, 0);
                this.vista.jtMetas.setValueAt(NOMBRE_META, Fila, 1);
                this.vista.jtMetas.setValueAt(MONTO_META, Fila, 2);
                this.vista.jtMetas.setValueAt(FECHA_LIMITE_META, Fila, 3);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Modificar Meta");
                System.out.println(ex);
            }

        }
*/
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

            int Fila = this.vista.jtMetas.getSelectedRow();
            int ID_META = (int) this.vista.jtMetas.getValueAt(Fila, 0);
            String NOMBRE_META = (String) this.vista.jtMetas.getValueAt(Fila, 1);
            Double MONTO_META = (Double) this.vista.jtMetas.getValueAt(Fila, 2);
            Double RECURSOS_ASIGNADOS = (Double) this.vista.jtMetas.getValueAt(Fila, 4);
            String ESTADO_META = (String) this.vista.jtMetas.getValueAt(Fila, 5);
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

            if (ESTADO_META == "LOGRADO") {

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas obtener esta meta?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    datos.setMONTO_EGRESO(RECURSOS_ASIGNADOS);

                    datos.setFECHA_EGRESO((java.sql.Date) date);

                    String cadenaAdicional = NOMBRE_META;
                    datos.setTIPO_EGRESO("Meta - " + cadenaAdicional);

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
