
package Vista;

public class Ventana_Crear_Metas extends javax.swing.JFrame {

    
    public Ventana_Crear_Metas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreMeta = new javax.swing.JTextField();
        txtMontoMeta = new javax.swing.JTextField();
        btnCrearMeta = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREAR META");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MONTO ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 40));

        jLabel3.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FECHA LIMITE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txtNombreMeta.setFont(new java.awt.Font("Roboto Mono", 0, 24)); // NOI18N
        txtNombreMeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNombreMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreMetaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreMeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 270, 40));

        txtMontoMeta.setFont(new java.awt.Font("Roboto Mono", 0, 24)); // NOI18N
        txtMontoMeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(txtMontoMeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 270, 40));

        btnCrearMeta.setBackground(new java.awt.Color(0, 204, 102));
        btnCrearMeta.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnCrearMeta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearMeta.setText("Crear Meta");
        btnCrearMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMetaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearMeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        btnAtras.setBackground(new java.awt.Color(36, 48, 60));
        btnAtras.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 153, 153));
        btnAtras.setText("<-");
        btnAtras.setBorder(null);
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 62, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jDateChooser.setBackground(new java.awt.Color(36, 48, 60));
        jDateChooser.setDateFormatString("yyyy-MM-dd");
        jDateChooser.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jPanel1.add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 270, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreMetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMetaActionPerformed
        
    }//GEN-LAST:event_txtNombreMetaActionPerformed

    private void btnCrearMetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMetaActionPerformed
        
    }//GEN-LAST:event_btnCrearMetaActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnCrearMeta;
    public com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtMontoMeta;
    public javax.swing.JTextField txtNombreMeta;
    // End of variables declaration//GEN-END:variables
}
