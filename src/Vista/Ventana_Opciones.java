/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class Ventana_Opciones extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    public Ventana_Opciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngreso = new javax.swing.JButton();
        btnEgreso = new javax.swing.JButton();
        btnSaldoActual = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnGestionar = new javax.swing.JButton();
        btnConfigurarPerfil = new javax.swing.JButton();
        btnRecordatorios = new javax.swing.JButton();
        btnPresupuestos = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        btnCambiarUser = new javax.swing.JLabel();
        exitTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngreso.setBackground(new java.awt.Color(104, 198, 102));
        btnIngreso.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnIngreso.setText("INGRESO");
        btnIngreso.setBorder(null);
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 160, 150));

        btnEgreso.setBackground(new java.awt.Color(255, 51, 102));
        btnEgreso.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnEgreso.setText("EGRESO");
        btnEgreso.setBorder(null);
        btnEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 160, 150));

        btnSaldoActual.setBackground(new java.awt.Color(255, 102, 102));
        btnSaldoActual.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnSaldoActual.setForeground(new java.awt.Color(255, 255, 255));
        btnSaldoActual.setText("<html><center>SALDO<br> ACTUAL<html>");
        btnSaldoActual.setBorder(null);
        btnSaldoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoActualActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaldoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 160, 150));

        btnReporte.setBackground(new java.awt.Color(255, 204, 51));
        btnReporte.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("Ver Estado de Cuenta");
        btnReporte.setBorder(null);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 260, 40));

        btnGestionar.setBackground(new java.awt.Color(0, 153, 255));
        btnGestionar.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnGestionar.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionar.setText("<html><center>GESTIONAR INGRESO<br><html>");
        btnGestionar.setBorder(null);
        btnGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 230, 70));

        btnConfigurarPerfil.setBackground(new java.awt.Color(255, 204, 51));
        btnConfigurarPerfil.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnConfigurarPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnConfigurarPerfil.setText("Configurar Perfil");
        btnConfigurarPerfil.setBorder(null);
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
        jPanel1.add(btnConfigurarPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 260, 40));

        btnRecordatorios.setBackground(new java.awt.Color(0, 153, 255));
        btnRecordatorios.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnRecordatorios.setForeground(new java.awt.Color(255, 255, 255));
        btnRecordatorios.setText("RECORDATORIOS");
        btnRecordatorios.setBorder(null);
        btnRecordatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordatoriosActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecordatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 230, 70));

        btnPresupuestos.setBackground(new java.awt.Color(0, 153, 255));
        btnPresupuestos.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        btnPresupuestos.setForeground(new java.awt.Color(255, 255, 255));
        btnPresupuestos.setText("PRESUPUESTOS");
        btnPresupuestos.setBorder(null);
        btnPresupuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresupuestosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPresupuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 230, 70));

        header.setBackground(new java.awt.Color(36, 48, 60));
        header.setForeground(new java.awt.Color(255, 255, 255));
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

        exitBtn.setBackground(new java.awt.Color(36, 48, 60));
        exitBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        header.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        btnCambiarUser.setFont(new java.awt.Font("FG Virgil", 1, 18)); // NOI18N
        btnCambiarUser.setForeground(new java.awt.Color(62, 82, 102));
        btnCambiarUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCambiarUser.setText("<--- Cambiar usuario");
        btnCambiarUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCambiarUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCambiarUserMouseExited(evt);
            }
        });
        header.add(btnCambiarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -10, 50, 50));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 590, 600));

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

    private void btnGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGestionarActionPerformed

    private void btnConfigurarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfigurarPerfilActionPerformed

    private void btnConfigurarPerfilComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnConfigurarPerfilComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfigurarPerfilComponentMoved

    private void btnRecordatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordatoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecordatoriosActionPerformed

    private void btnPresupuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresupuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPresupuestosActionPerformed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void btnCambiarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarUserMouseClicked
        this.dispose();
        Ventana_Login frm_ventana_login = new Ventana_Login();
        frm_ventana_login.setVisible(true);
    }//GEN-LAST:event_btnCambiarUserMouseClicked

    private void btnCambiarUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarUserMouseEntered
        btnCambiarUser.setForeground(new Color(12, 133, 153));
    }//GEN-LAST:event_btnCambiarUserMouseEntered

    private void btnCambiarUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarUserMouseExited
        btnCambiarUser.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_btnCambiarUserMouseExited

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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCambiarUser;
    public javax.swing.JButton btnConfigurarPerfil;
    public javax.swing.JButton btnEgreso;
    public javax.swing.JButton btnGestionar;
    public javax.swing.JButton btnIngreso;
    public javax.swing.JButton btnPresupuestos;
    public javax.swing.JButton btnRecordatorios;
    public javax.swing.JButton btnReporte;
    public javax.swing.JButton btnSaldoActual;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
