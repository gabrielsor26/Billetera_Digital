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
public class Ventana_Ahorros extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    public Ventana_Ahorros() {
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
        jLabel1 = new javax.swing.JLabel();
        bgTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAhorro = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JPanel();
        txtAgregar = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JPanel();
        txtQuitar = new javax.swing.JLabel();

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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, -10, 50, 50));

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

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DINERO AHORRADO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 540, 40));

        bgTabla.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jtAhorro.setBackground(new java.awt.Color(36, 48, 60));
        jtAhorro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtAhorro.setFont(new java.awt.Font("Roboto Mono", 0, 48)); // NOI18N
        jtAhorro.setForeground(new java.awt.Color(255, 255, 255));
        jtAhorro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtAhorro.setGridColor(new java.awt.Color(0, 0, 0));
        jtAhorro.setMaximumSize(new java.awt.Dimension(0, 0));
        jtAhorro.setMinimumSize(new java.awt.Dimension(0, 0));
        jtAhorro.setSelectionBackground(new java.awt.Color(36, 48, 60));
        jtAhorro.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jtAhorro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAhorroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAhorro);

        bgTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 360, 120));

        jPanel1.add(bgTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 360, 100));

        jLabel12.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DINERO DESTINADO PARA AHORROS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 380, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 153, 153));
        btnAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAgregar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtAgregar.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAgregar.setText("Agregar");
        txtAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.add(txtAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 140, 50));

        btnQuitar.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQuitar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtQuitar.setForeground(new java.awt.Color(255, 255, 255));
        txtQuitar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtQuitar.setText("Quitar");
        txtQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.add(txtQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));

        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 370));

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
        Ventana_Gestionar_Recursos frm_gestionar_recursos = new Ventana_Gestionar_Recursos();
        frm_gestionar_recursos.setVisible(true);;
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

    private void jtAhorroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAhorroMouseClicked

    }//GEN-LAST:event_jtAhorroMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana_Ahorros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ahorros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ahorros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ahorros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Ahorros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bgTabla;
    public javax.swing.JPanel btnAgregar;
    private javax.swing.JLabel btnAtras;
    public javax.swing.JPanel btnQuitar;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtAhorro;
    public javax.swing.JLabel txtAgregar;
    public javax.swing.JLabel txtQuitar;
    // End of variables declaration//GEN-END:variables
}
