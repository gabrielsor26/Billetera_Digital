package Vista;

import Controlador.CtrlMenu_Ingreso;
import Modelo.Conexion;
import static Vista.Ventana_Login.usuario_id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ventana_Historial_Ingreso extends javax.swing.JFrame {

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
    
    
    
    public Ventana_Historial_Ingreso() {
        initComponents();

        this.setTitle("Consultar Historial de Ingreso");
        this.setLocationRelativeTo(null);

        try {
            
            MyTableModel modelo = new MyTableModel(new Object[][]{}, new Object[]{"ID", "MONTO DEL INGRESO", "FECHA DEL INGRESO", "DESCRIPCION DEL INGRESO"});
            
            jtIngresos.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT ID, MONTO_INGRESO, FECHA_INGRESO, DESCRIPCION_INGRESO, usuario_id FROM ingreso WHERE usuario_id = ?";  
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
/*
            modelo.addColumn("ID");
            modelo.addColumn("MONTO DEL INGRESO");
            modelo.addColumn("FECHA DEL INGRESO");
            modelo.addColumn("DESCRIPCION DEL INGRESO");
            //modelo.addColumn("usuario_id");
*/
            int altoFila = 20;
            int[] anchos = {50, 500, 500, 700, 500};

            jtIngresos.setRowHeight(altoFila);

            for (int i = 0; i < jtIngresos.getColumnCount(); i++) {
                jtIngresos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

            
            for (int i = 0; i < jtIngresos.getColumnCount(); i++) {
                jtIngresos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        jtIngresos.getTableHeader().setVisible(true);
        jtIngresos.setBorder(BorderFactory.createEmptyBorder());
        jtIngresos.setIntercellSpacing(new java.awt.Dimension(0, 0));

        //usuario_id = Ventana_Login.usuario_id;
        System.out.println(usuario_id);
/*
        System.out.println("Valor de usuario_id: " + usuario_id);
        for (int i = jtIngresos.getRowCount() - 1; i >= 0; i--) {
            String valorEnColumnaUsuarioId = jtIngresos.getValueAt(i, 4).toString(); // Suponiendo que la columna "usuario_id" es la quinta (índice 4)
            System.out.println("Valor en la columna 'usuario_id': " + valorEnColumnaUsuarioId);
            System.out.println("Valor de usuario_id: " + usuario_id);
            if (!valorEnColumnaUsuarioId.equals(usuario_id)) {
                // Si el valor en la columna "usuario_id" no coincide con el valor deseado, eliminamos la fila
                modelo.removeRow(i); // Eliminamos la fila del modelo
            }
        }
*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtIngresos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtIngresos.setBackground(new java.awt.Color(255, 255, 102));
        jtIngresos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jtIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jtIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtIngresosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtIngresos);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Precio");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Fecha");

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Descripción");

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setText("HISTORIAL DE INGRESO");

        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAtras.setText("<-");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel3)
                                .addGap(173, 173, 173)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel5)
                        .addContainerGap(310, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtPrecio)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnModificar)
                        .addGap(28, 28, 28)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnAtras)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtIngresosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtIngresosMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = jtIngresos.getSelectedRow();
            String codigo = jtIngresos.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("SELECT ID, MONTO_INGRESO, FECHA_INGRESO, DESCRIPCION_INGRESO, usuario_id FROM ingreso WHERE ID=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {

                //txtCodigo.setText(rs.getString("ID"));
                txtNombre.setText(rs.getString("MONTO_INGRESO"));
                txtPrecio.setText(rs.getString("FECHA_INGRESO"));
                txtCantidad.setText(rs.getString("DESCRIPCION_INGRESO"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtIngresosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        PreparedStatement ps = null;
        try {

            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = jtIngresos.getSelectedRow();
            String codigo = jtIngresos.getValueAt(Fila, 0).toString();

            ps = conn.prepareStatement("DELETE FROM ingreso WHERE ID=?");
            ps.setString(1, codigo);
            ps.execute();
            
            ((MyTableModel) jtIngresos.getModel()).removeRow(Fila);
            //modelo.removeRow(Fila);
            JOptionPane.showMessageDialog(null, "Ingreso Eliminado");
            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar Ingreso");
            System.out.println(ex.toString());
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int Fila = jtIngresos.getSelectedRow();
        int ID_INGRESO = (int) jtIngresos.getValueAt(Fila, 0);
        
        System.out.println(Fila);
        
        PreparedStatement ps = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("UPDATE ingreso SET MONTO_INGRESO=?, FECHA_INGRESO=?, DESCRIPCION_INGRESO=? WHERE ID=?");

            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtPrecio.getText());
            ps.setString(3, txtCantidad.getText());
            ps.setString(4, String.valueOf(ID_INGRESO));

            ps.execute();

            JOptionPane.showMessageDialog(null, "Ingreso Modificado");
            //jtIngresos.setValueAt(txtCodigo.getText(), Fila, 0);
            jtIngresos.setValueAt(txtNombre.getText(), Fila, 1);
            jtIngresos.setValueAt(txtPrecio.getText(), Fila, 2);
            jtIngresos.setValueAt(txtCantidad.getText(), Fila, 3);

            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar Ingreso");
            System.out.println(ex);
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed

        this.dispose();
        Ventana_Ingreso frm_ingreso = new Ventana_Ingreso();
        CtrlMenu_Ingreso ctrlmenu_ingreso = new CtrlMenu_Ingreso(frm_ingreso);
        ctrlmenu_ingreso.iniciar();
        frm_ingreso.setVisible(true);


    }//GEN-LAST:event_btnAtrasActionPerformed

    private void limpiar() {
        //txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtIngresos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
