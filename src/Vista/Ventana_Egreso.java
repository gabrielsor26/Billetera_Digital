/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


public class Ventana_Egreso extends javax.swing.JFrame {

    public Ventana_Egreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnRegistrarEgreso = new javax.swing.JButton();
        btnConsultarHistorial = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnCategorizarEgreso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(36, 48, 60));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarEgreso.setBackground(new java.awt.Color(0, 102, 102));
        btnRegistrarEgreso.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnRegistrarEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarEgreso.setText("Registrar Egreso");
        btnRegistrarEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEgresoActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrarEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 490, -1));

        btnConsultarHistorial.setBackground(new java.awt.Color(0, 102, 102));
        btnConsultarHistorial.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnConsultarHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarHistorial.setText("Consultar Historial de Egreso");
        btnConsultarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarHistorialActionPerformed(evt);
            }
        });
        jPanel3.add(btnConsultarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 490, -1));

        btnAtras.setBackground(new java.awt.Color(0, 102, 102));
        btnAtras.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel3.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 300, -1));

        btnCategorizarEgreso.setBackground(new java.awt.Color(0, 102, 102));
        btnCategorizarEgreso.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnCategorizarEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorizarEgreso.setText("Categorizar Egreso");
        btnCategorizarEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategorizarEgresoActionPerformed(evt);
            }
        });
        jPanel3.add(btnCategorizarEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 490, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 578, 374));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEgresoActionPerformed

    }//GEN-LAST:event_btnRegistrarEgresoActionPerformed

    private void btnConsultarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarHistorialActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed

    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnCategorizarEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategorizarEgresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategorizarEgresoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnCategorizarEgreso;
    public javax.swing.JButton btnConsultarHistorial;
    public javax.swing.JButton btnRegistrarEgreso;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
