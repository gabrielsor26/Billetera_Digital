/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlMenu_Opciones;
import Controlador.Ctrl_Ver_Presupuestos;

/**
 *
 * @author Usuario
 */
public class Ventana_Opciones_Presupuesto extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Opciones_Presupuesto
     */
    public Ventana_Opciones_Presupuesto() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        btnFijarPresupuestos = new javax.swing.JButton();
        btnVerPresupuestos = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFijarPresupuestos.setBackground(new java.awt.Color(0, 102, 102));
        btnFijarPresupuestos.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnFijarPresupuestos.setForeground(new java.awt.Color(255, 255, 255));
        btnFijarPresupuestos.setText("Fijar Presupuesto");
        btnFijarPresupuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFijarPresupuestosActionPerformed(evt);
            }
        });
        jPanel1.add(btnFijarPresupuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 330, -1));

        btnVerPresupuestos.setBackground(new java.awt.Color(0, 102, 102));
        btnVerPresupuestos.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnVerPresupuestos.setForeground(new java.awt.Color(255, 255, 255));
        btnVerPresupuestos.setText("Ver Presupuestos");
        btnVerPresupuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPresupuestosActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerPresupuestos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 330, -1));

        btnAtras.setBackground(new java.awt.Color(0, 102, 102));
        btnAtras.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 162, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFijarPresupuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFijarPresupuestosActionPerformed

        this.dispose();
        Ventana_Opciones_Fijar_Presupuesto opciones_fijar = new Ventana_Opciones_Fijar_Presupuesto();
        opciones_fijar.setVisible(true);

    }//GEN-LAST:event_btnFijarPresupuestosActionPerformed

    private void btnVerPresupuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPresupuestosActionPerformed
        
        this.dispose();
        Ventana_Ver_Presupuestos frm_ver_presupuestos = new Ventana_Ver_Presupuestos();
        Ctrl_Ver_Presupuestos ctrl_ver_presupuestos = new Ctrl_Ver_Presupuestos(frm_ver_presupuestos);
        ctrl_ver_presupuestos.iniciar();
        frm_ver_presupuestos.setVisible(true);


    }//GEN-LAST:event_btnVerPresupuestosActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed

        this.dispose();

        Ventana_Opciones frm_opciones = new Ventana_Opciones();

        CtrlMenu_Opciones ctrlmenu_opciones = new CtrlMenu_Opciones(frm_opciones);

        ctrlmenu_opciones.iniciar();
        frm_opciones.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Opciones_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Opciones_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Opciones_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Opciones_Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Opciones_Presupuesto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnFijarPresupuestos;
    public javax.swing.JButton btnVerPresupuestos;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
