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
public class Ventana_Presupuestos extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    public Ventana_Presupuestos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headercrema = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headercrema.setBackground(new java.awt.Color(255, 255, 204));
        headercrema.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headercremaMouseDragged(evt);
            }
        });
        headercrema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headercremaMousePressed(evt);
            }
        });
        headercrema.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitTxt.setFont(new java.awt.Font("FG Virgil", 1, 48)); // NOI18N
        exitTxt.setForeground(new java.awt.Color(204, 204, 0));
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
        headercrema.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, -10, 40, 50));

        btnAtras.setFont(new java.awt.Font("FG Virgil", 1, 30)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(204, 204, 0));
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
        headercrema.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel1.add(headercrema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        //exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.red);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        //exitBtn.setBackground(new Color(36, 48, 60));
        exitTxt.setForeground(new Color(204, 204, 0));
    }//GEN-LAST:event_exitTxtMouseExited

    private void headercremaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headercremaMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headercremaMouseDragged

    private void headercremaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headercremaMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headercremaMousePressed

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked

        this.dispose();
        Ventana_Opciones frm_opciones = new Ventana_Opciones();
        CtrlMenu_Opciones ctrlmenu_opciones = new CtrlMenu_Opciones(frm_opciones);
        ctrlmenu_opciones.iniciar();
        frm_opciones.setVisible(true);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        btnAtras.setForeground(new Color(12, 133, 153));
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
        btnAtras.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_btnAtrasMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Presupuestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnAtras;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel headercrema;
    public javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
