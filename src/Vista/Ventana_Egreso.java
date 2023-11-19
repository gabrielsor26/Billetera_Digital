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

        btnRegistrarEgreso.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegistrarEgreso.setText("Registrar Egreso");
        btnRegistrarEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEgresoActionPerformed(evt);
            }
        });

        btnConsultarHistorial.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnConsultarHistorial.setText("Consultar Historial de Egreso");
        btnConsultarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarHistorialActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnCategorizarEgreso.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCategorizarEgreso.setText("Categorizar Egreso");
        btnCategorizarEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategorizarEgresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultarHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                            .addComponent(btnRegistrarEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCategorizarEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(btnRegistrarEgreso)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarHistorial)
                .addGap(18, 18, 18)
                .addComponent(btnCategorizarEgreso)
                .addGap(18, 18, 18)
                .addComponent(btnAtras)
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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
