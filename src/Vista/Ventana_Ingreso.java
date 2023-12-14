/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlMenu_Opciones;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class Ventana_Ingreso extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    public Ventana_Ingreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrarIngreso = new javax.swing.JButton();
        btnConsultarHistorial = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        btnCambiarUser = new javax.swing.JLabel();
        exitTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarIngreso.setBackground(new java.awt.Color(0, 102, 102));
        btnRegistrarIngreso.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnRegistrarIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarIngreso.setText("<html><center>Registrar<br>Ingreso<html>");
        btnRegistrarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 190, 90));

        btnConsultarHistorial.setBackground(new java.awt.Color(0, 102, 102));
        btnConsultarHistorial.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnConsultarHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarHistorial.setText("<html><center>Historial<br>Ingreso<html>");
        btnConsultarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 190, 90));

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

        btnCambiarUser.setFont(new java.awt.Font("FG Virgil", 1, 30)); // NOI18N
        btnCambiarUser.setForeground(new java.awt.Color(62, 82, 102));
        btnCambiarUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCambiarUser.setText("<---");
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
        header.add(btnCambiarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, -10, 50, 50));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIngresoActionPerformed

    }//GEN-LAST:event_btnRegistrarIngresoActionPerformed

    private void btnConsultarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarHistorialActionPerformed

    private void btnCambiarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarUserMouseClicked
        this.dispose();
        Ventana_Opciones frm_opciones = new Ventana_Opciones();
        CtrlMenu_Opciones ctrlmenu_opciones = new CtrlMenu_Opciones(frm_opciones);
        ctrlmenu_opciones.iniciar();
        frm_opciones.setVisible(true);
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

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCambiarUser;
    public javax.swing.JButton btnConsultarHistorial;
    public javax.swing.JButton btnRegistrarIngreso;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
