/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

//import javax.swing.JTable;


/**
 *
 * @author Usuario
 */
public class Ventana_Asignar_Recursos extends javax.swing.JFrame {


    public Ventana_Asignar_Recursos() {
        initComponents();
        //jtMetas = new JTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMetas = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnObtener = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtMetas.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jtMetas.setToolTipText("");
        jScrollPane1.setViewportView(jtMetas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 83, 867, 356));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 160, 40));

        btnObtener.setBackground(new java.awt.Color(255, 204, 0));
        btnObtener.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnObtener.setForeground(new java.awt.Color(255, 255, 255));
        btnObtener.setText("OBTENER");
        btnObtener.setBorder(null);
        btnObtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerActionPerformed(evt);
            }
        });
        jPanel1.add(btnObtener, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 140, 96));

        btnAgregar.setBackground(new java.awt.Color(26, 177, 136));
        btnAgregar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR FONDOS");
        btnAgregar.setBorder(null);
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 210, 96));

        btnQuitar.setBackground(new java.awt.Color(204, 0, 102));
        btnQuitar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("QUITAR FONDOS");
        btnQuitar.setBorder(null);
        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, 210, 96));

        btnAtras.setBackground(new java.awt.Color(36, 48, 60));
        btnAtras.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 153, 153));
        btnAtras.setText("<-");
        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, -1));

        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 46)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ASIGNAR RECURSOS A UNA META");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObtenerActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnObtener;
    public javax.swing.JButton btnQuitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtMetas;
    // End of variables declaration//GEN-END:variables
}
