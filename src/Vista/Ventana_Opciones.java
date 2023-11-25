/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Usuario
 */
public class Ventana_Opciones extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Opciones
     */
    public Ventana_Opciones() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngreso = new javax.swing.JButton();
        btnEgreso = new javax.swing.JButton();
        btnSaldoActual = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnCambiarUsuario = new javax.swing.JButton();
        btnGestionar = new javax.swing.JButton();
        btnConfigurarPerfil = new javax.swing.JButton();
        Recordatorios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngreso.setBackground(new java.awt.Color(0, 102, 102));
        btnIngreso.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnIngreso.setText("Ingreso");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 162, 144));

        btnEgreso.setBackground(new java.awt.Color(0, 102, 102));
        btnEgreso.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnEgreso.setText("Egreso");
        btnEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 162, 144));

        btnSaldoActual.setBackground(new java.awt.Color(0, 102, 102));
        btnSaldoActual.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnSaldoActual.setForeground(new java.awt.Color(255, 255, 255));
        btnSaldoActual.setText("<html><center>Saldo<br> Actual<html>");
        btnSaldoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoActualActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaldoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 162, 144));

        btnReporte.setBackground(new java.awt.Color(0, 102, 102));
        btnReporte.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("Ver Estado de Cuenta");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 330, -1));

        btnCambiarUsuario.setBackground(new java.awt.Color(0, 102, 102));
        btnCambiarUsuario.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnCambiarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarUsuario.setText("<- Cambiar Usuario");
        btnCambiarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        btnGestionar.setBackground(new java.awt.Color(0, 102, 102));
        btnGestionar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnGestionar.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionar.setText("<html><center>Gestionar<br> Ingreso<html>");
        btnGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 230, 145));

        btnConfigurarPerfil.setBackground(new java.awt.Color(0, 102, 102));
        btnConfigurarPerfil.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnConfigurarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnConfigurarPerfil.setText("Configurar Perfil");
        btnConfigurarPerfil.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                btnConfigurarPerfilComponentMoved(evt);
            }
        });
        btnConfigurarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfigurarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 330, -1));

        Recordatorios.setBackground(new java.awt.Color(0, 102, 102));
        Recordatorios.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        Recordatorios.setForeground(new java.awt.Color(255, 255, 255));
        Recordatorios.setText("Recordatorios");
        Recordatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordatoriosActionPerformed(evt);
            }
        });
        jPanel1.add(Recordatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 230, 144));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 930, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed

    }//GEN-LAST:event_btnIngresoActionPerformed

    private void btnEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEgresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEgresoActionPerformed

    private void btnSaldoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaldoActualActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCambiarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarUsuarioActionPerformed

  
    }//GEN-LAST:event_btnCambiarUsuarioActionPerformed

    private void btnGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGestionarActionPerformed

    private void btnConfigurarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfigurarPerfilActionPerformed

    private void btnConfigurarPerfilComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnConfigurarPerfilComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfigurarPerfilComponentMoved

    private void RecordatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordatoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecordatoriosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Recordatorios;
    public javax.swing.JButton btnCambiarUsuario;
    public javax.swing.JButton btnConfigurarPerfil;
    public javax.swing.JButton btnEgreso;
    public javax.swing.JButton btnGestionar;
    public javax.swing.JButton btnIngreso;
    public javax.swing.JButton btnReporte;
    public javax.swing.JButton btnSaldoActual;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
