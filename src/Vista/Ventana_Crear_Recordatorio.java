/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Datos_Recordatorio;
import Modelo.Datos_Tipo_Servicio;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class Ventana_Crear_Recordatorio extends javax.swing.JFrame {

    int xMouseCrema, yMouseCrema;

    /**
     * Creates new form Ventana_Crear_Recordatorio
     */
    public Ventana_Crear_Recordatorio() {
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
        header = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        cbxPrioridad = new javax.swing.JComboBox<>();
        txtBienvenida = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnRegistrarIngreso = new javax.swing.JPanel();
        txtCrearRecordatorio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxTipoServicio = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(36, 48, 60));
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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, -10, 50, 50));

        btnAtras.setFont(new java.awt.Font("FG Virgil", 1, 30)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(62, 82, 102));
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
        header.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 40));

        cbxPrioridad.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        cbxPrioridad.setBorder(null);
        jPanel1.add(cbxPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 260, 40));

        txtBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setFont(new java.awt.Font("Roboto Mono", 1, 30)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida.setText("CREAR RECORDATORIO");
        jPanel1.add(txtBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 470, 50));

        jLabel8.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("FECHA Y HORA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 40));

        jLabel9.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TIPO SERVICIO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 40));

        btnRegistrarIngreso.setBackground(new java.awt.Color(26, 177, 136));
        btnRegistrarIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCrearRecordatorio.setFont(new java.awt.Font("Roboto Mono", 1, 22)); // NOI18N
        txtCrearRecordatorio.setForeground(new java.awt.Color(255, 255, 255));
        txtCrearRecordatorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCrearRecordatorio.setText("<html><center>Crear<br>Recordatorio<html>");
        btnRegistrarIngreso.add(txtCrearRecordatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        jPanel1.add(btnRegistrarIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 180, 60));

        jLabel10.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MONTO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, 40));

        cbxTipoServicio.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        cbxTipoServicio.setBorder(null);
        jPanel1.add(cbxTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, 40));

        jDateChooser.setBackground(new java.awt.Color(36, 48, 60));
        jDateChooser.setDateFormatString("yyyy-MM-dd");
        jDateChooser.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jPanel1.add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 260, 40));

        jLabel11.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PRIORIDAD");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, 40));

        txtMonto.setBackground(new java.awt.Color(36, 48, 60));
        txtMonto.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(255, 255, 255));
        txtMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtMonto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtMonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMontoMousePressed(evt);
            }
        });
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 260, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 550));

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
        exitTxt.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_exitTxtMouseExited

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        this.dispose();
        Ventana_Opciones_Recordatorio opciones_Recordatorio = new Ventana_Opciones_Recordatorio();
        opciones_Recordatorio.setVisible(true);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        btnAtras.setForeground(new Color(12, 133, 153));
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
        btnAtras.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_btnAtrasMouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headerMousePressed

    private void txtMontoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMontoMousePressed
        txtMonto.setForeground(Color.white);
    }//GEN-LAST:event_txtMontoMousePressed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed

    }//GEN-LAST:event_txtMontoActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Crear_Recordatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Crear_Recordatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Crear_Recordatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Crear_Recordatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Crear_Recordatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras;
    public javax.swing.JPanel btnRegistrarIngreso;
    public javax.swing.JComboBox<String> cbxPrioridad;
    public javax.swing.JComboBox<Datos_Tipo_Servicio> cbxTipoServicio;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    public com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel txtBienvenida;
    public javax.swing.JLabel txtCrearRecordatorio;
    public javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

}
