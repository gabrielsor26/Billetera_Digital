/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Datos_Tipo_Servicio;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Ventana_Ver_Recordatorios extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    /**
     * Creates new form Ventana_Ver_Recordatorios
     */
    public Ventana_Ver_Recordatorios() {
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

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JPanel();
        txtEliminar = new javax.swing.JLabel();
        backgroundtabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtRecordatorios = new javax.swing.JTable();
        btnModificar = new javax.swing.JPanel();
        txtModificar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JPanel();
        txtPagar = new javax.swing.JLabel();
        cbxTipoServicio = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbxPrioridad = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(36, 48, 60));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, -10, 50, 50));

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

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MIS RECORDATORIOS");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1070, 40));

        btnEliminar.setBackground(new java.awt.Color(255, 1, 0));
        btnEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEliminar.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtEliminar.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEliminar.setText("ELIMINAR RECORDATORIO");
        txtEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEliminarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEliminarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtEliminarMouseReleased(evt);
            }
        });
        btnEliminar.add(txtEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 60));

        background.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, 260, 60));

        backgroundtabla.setBackground(new java.awt.Color(0, 92, 75));
        backgroundtabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 92, 75));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jScrollPane2.setColumnHeaderView(null);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(null);
        jScrollPane2.setWheelScrollingEnabled(false);

        jtRecordatorios.setBackground(new java.awt.Color(206, 212, 218));
        jtRecordatorios.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jtRecordatorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtRecordatorios.setGridColor(new java.awt.Color(206, 212, 218));
        jtRecordatorios.setSelectionBackground(new java.awt.Color(206, 212, 218));
        jtRecordatorios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jtRecordatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRecordatoriosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtRecordatorios);

        backgroundtabla.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 760, 360));

        background.add(backgroundtabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 760, 340));

        btnModificar.setBackground(new java.awt.Color(121, 80, 242));
        btnModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModificar.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtModificar.setForeground(new java.awt.Color(255, 255, 255));
        txtModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtModificar.setText("MODIFICAR");
        txtModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtModificarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtModificarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtModificarMouseReleased(evt);
            }
        });
        btnModificar.add(txtModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        background.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 110, 40));

        jLabel5.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ESTADO");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TIPO SERVICIO");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MONTO");
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        txtMonto.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtMonto.setCaretColor(new java.awt.Color(255, 255, 255));
        txtMonto.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtMonto.setSelectionColor(new java.awt.Color(0, 204, 153));
        background.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, 190, 40));

        jLabel8.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FECHA");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PRIORIDAD");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MODIFICAR");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, -1, 20));

        jLabel11.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MONTO");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("FECHA");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PRIORIDAD");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        btnPagar.setBackground(new java.awt.Color(26, 177, 136));
        btnPagar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPagar.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtPagar.setForeground(new java.awt.Color(255, 255, 255));
        txtPagar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPagar.setText("PAGAR RECORDATORIO");
        txtPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPagarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPagarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPagarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtPagarMouseReleased(evt);
            }
        });
        btnPagar.add(txtPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 60));

        background.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 260, 60));

        cbxTipoServicio.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        cbxTipoServicio.setBorder(null);
        background.add(cbxTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 190, 40));

        jLabel14.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("TIPO SERVICIO");
        background.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, -1));

        cbxPrioridad.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        cbxPrioridad.setBorder(null);
        background.add(cbxPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, 190, 40));

        jDateChooser.setBackground(new java.awt.Color(36, 48, 60));
        jDateChooser.setDateFormatString("yyyy-MM-dd");
        jDateChooser.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        background.add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 190, 40));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 610));

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

    private void txtEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseClicked

    }//GEN-LAST:event_txtEliminarMouseClicked

    private void txtEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseEntered
        btnEliminar.setBackground(new Color(255, 81, 81));
    }//GEN-LAST:event_txtEliminarMouseEntered

    private void txtEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseExited
        btnEliminar.setBackground(new Color(255, 1, 0));
    }//GEN-LAST:event_txtEliminarMouseExited

    private void txtEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMousePressed
        btnEliminar.setBackground(new Color(255, 113, 113));
    }//GEN-LAST:event_txtEliminarMousePressed

    private void txtEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseReleased
        btnEliminar.setBackground(new Color(255, 81, 81));
    }//GEN-LAST:event_txtEliminarMouseReleased

    private void jtRecordatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRecordatoriosMouseClicked

    }//GEN-LAST:event_jtRecordatoriosMouseClicked

    private void txtModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseClicked

    }//GEN-LAST:event_txtModificarMouseClicked

    private void txtModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseEntered
        btnModificar.setBackground(new Color(149, 117, 244));
    }//GEN-LAST:event_txtModificarMouseEntered

    private void txtModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseExited
        btnModificar.setBackground(new Color(121, 80, 242));
    }//GEN-LAST:event_txtModificarMouseExited

    private void txtModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMousePressed
        btnModificar.setBackground(new Color(166, 139, 245));
    }//GEN-LAST:event_txtModificarMousePressed

    private void txtModificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseReleased
        btnModificar.setBackground(new Color(149, 117, 244));
    }//GEN-LAST:event_txtModificarMouseReleased

    private void txtPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagarMouseClicked

    private void txtPagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagarMouseEntered

    private void txtPagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagarMouseExited

    private void txtPagarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagarMousePressed

    private void txtPagarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPagarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagarMouseReleased

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
            java.util.logging.Logger.getLogger(Ventana_Ver_Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ver_Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ver_Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ver_Recordatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Ver_Recordatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel backgroundtabla;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnModificar;
    private javax.swing.JPanel btnPagar;
    public javax.swing.JComboBox<String> cbxPrioridad;
    public javax.swing.JComboBox<Datos_Tipo_Servicio> cbxTipoServicio;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    public com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jtRecordatorios;
    private javax.swing.JLabel txtEliminar;
    private javax.swing.JLabel txtModificar;
    public javax.swing.JTextField txtMonto;
    private javax.swing.JLabel txtPagar;
    // End of variables declaration//GEN-END:variables

}