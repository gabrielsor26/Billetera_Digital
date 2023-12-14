package Vista;

import Controlador.CtrlMenu_Egreso;
import Modelo.Conexion;
import static Vista.Ventana_Login.usuario_id;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ventana_Historial_Egreso extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;
    
    DefaultTableModel modelo = new DefaultTableModel();

    // hacer que la columna cero no sea editable
    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return column != 0; // La columna 0 (ID) no será editable
        }
    }

    public Ventana_Historial_Egreso() {
        initComponents();

        this.setTitle("Consultar Historial de Egreso");
        this.setLocationRelativeTo(null);
        mostrarTablaEgresos();

    }

    public void mostrarTablaEgresos() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            MyTableModel modelotabla = new MyTableModel(new Object[][]{}, new Object[]{"ID_EGRESO", "MONTO_EGRESO", "FECHA_EGRESO", "TIPO_EGRESO", "usuario_id"});
            jtEgresos.setModel(modelotabla);
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID_EGRESO, MONTO_EGRESO, FECHA_EGRESO, TIPO_EGRESO, usuario_id\n"
                    + "FROM egreso\n"
                    + "WHERE usuario_id = ?\n"
                    + "ORDER BY FECHA_EGRESO DESC;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd3 = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd3.getColumnCount();

            int altoFila = 30;
            int[] anchos = {50, 50, 50, 300, 50};
            jtEgresos.setRowHeight(altoFila);

            for (int i = 0; i < jtEgresos.getColumnCount(); i++) {
                jtEgresos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            //Centrar Texto
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            for (int i = 0; i < jtEgresos.getColumnCount(); i++) {
                jtEgresos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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

            javax.swing.table.TableColumnModel columnModel = jtEgresos.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            javax.swing.table.TableColumn idColumn4 = columnModel.getColumn(4);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);
            idColumn4.setMinWidth(0);
            idColumn4.setMaxWidth(0);
            idColumn4.setPreferredWidth(0);
            idColumn4.setResizable(false);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        jtEgresos.getTableHeader().setVisible(false);
        jtEgresos.setBorder(BorderFactory.createEmptyBorder());
        jtEgresos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bgTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEgresos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(36, 48, 60));
        txtNombre.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 90, 46));

        txtPrecio.setBackground(new java.awt.Color(36, 48, 60));
        txtPrecio.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtPrecio.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 140, 46));

        txtCantidad.setBackground(new java.awt.Color(36, 48, 60));
        txtCantidad.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtCantidad.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 340, 46));

        btnModificar.setBackground(new java.awt.Color(102, 51, 255));
        btnModificar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, 160, 50));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, 160, 50));

        jLabel5.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HISTORIAL DE EGRESO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        bgTabla.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jtEgresos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtEgresos.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jtEgresos.setForeground(new java.awt.Color(194, 39, 94));
        jtEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtEgresos.setGridColor(new java.awt.Color(255, 255, 255));
        jtEgresos.setMaximumSize(new java.awt.Dimension(0, 0));
        jtEgresos.setMinimumSize(new java.awt.Dimension(0, 0));
        jtEgresos.setSelectionBackground(new java.awt.Color(194, 39, 94));
        jtEgresos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jtEgresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEgresosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEgresos);

        bgTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 730, 370));

        jPanel1.add(bgTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 730, 340));

        jLabel11.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MONTO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 80, 30));

        jLabel12.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("FECHA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 100, 30));

        jLabel10.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CATEGORIA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 140, 30));

        header.setBackground(new java.awt.Color(36, 48, 60));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitTxt.setFont(new java.awt.Font("FG Virgil", 1, 48)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(62, 82, 102));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("x");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 50, 50));

        btnAtras.setFont(new java.awt.Font("FG Virgil", 1, 30)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(62, 82, 102));
        btnAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtras.setText("<---");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtrasMouseExited(evt);
            }
        });
        header.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        PreparedStatement ps = null;
        try {

            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = jtEgresos.getSelectedRow();
            String codigo = jtEgresos.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("DELETE FROM egreso WHERE ID_EGRESO=?");
            ps.setString(1, codigo);
            ps.execute();

            ((MyTableModel) jtEgresos.getModel()).removeRow(Fila);
            //modelo.removeRow(Fila);
            JOptionPane.showMessageDialog(null, "Egreso Eliminado");
            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar Egreso");
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int Fila = jtEgresos.getSelectedRow();
        int ID_EGRESO = (int) jtEgresos.getValueAt(Fila, 0);

        System.out.println("Valor de fila es: " + Fila);

        PreparedStatement ps = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("UPDATE egreso SET MONTO_EGRESO=?, FECHA_EGRESO=?, TIPO_EGRESO=? WHERE ID_EGRESO=?");

            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtPrecio.getText());
            ps.setString(3, txtCantidad.getText());
            ps.setString(4, String.valueOf(ID_EGRESO));

            ps.execute();

            JOptionPane.showMessageDialog(null, "Egreso Modificado");
            //jtEgresos.setValueAt(txtCodigo.getText(), Fila, 0);
            jtEgresos.setValueAt(txtNombre.getText(), Fila, 1);
            jtEgresos.setValueAt(txtPrecio.getText(), Fila, 2);
            jtEgresos.setValueAt(txtCantidad.getText(), Fila, 3);

            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar Egreso");
            System.out.println(ex);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jtEgresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEgresosMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = jtEgresos.getSelectedRow();
            String codigo = jtEgresos.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT ID_EGRESO, MONTO_EGRESO, FECHA_EGRESO, TIPO_EGRESO, usuario_id FROM egreso WHERE ID_EGRESO=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {

                txtNombre.setText(rs.getString("MONTO_EGRESO"));
                txtPrecio.setText(rs.getString("FECHA_EGRESO"));
                txtCantidad.setText(rs.getString("TIPO_EGRESO"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtEgresosMouseClicked

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        //exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.red);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        //exitBtn.setBackground(new Color(36, 48, 60));
        exitTxt.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_exitTxtMouseExited

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        this.dispose();
        Ventana_Egreso frm_egreso = new Ventana_Egreso();
        CtrlMenu_Egreso ctrlmenu_egreso = new CtrlMenu_Egreso(frm_egreso);
        ctrlmenu_egreso.iniciar();
        frm_egreso.setVisible(true);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        btnAtras.setForeground(new Color(12, 133, 153));
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
        btnAtras.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_btnAtrasMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headerMousePressed

    private void limpiar() {
        //txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bgTabla;
    public javax.swing.JLabel btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    public javax.swing.JLabel exitTxt;
    public javax.swing.JPanel header;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtEgresos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
