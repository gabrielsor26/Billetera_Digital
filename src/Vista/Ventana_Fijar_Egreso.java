/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Datos_Fechas;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class Ventana_Fijar_Egreso extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;
    
    public Ventana_Fijar_Egreso() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBienvenida1 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        txtBienvenida2 = new javax.swing.JLabel();
        txtBienvenida3 = new javax.swing.JLabel();
        txtBienvenida4 = new javax.swing.JLabel();
        cbxFecha2 = new javax.swing.JComboBox<>();
        txtBienvenida5 = new javax.swing.JLabel();
        txtBienvenida6 = new javax.swing.JLabel();
        txtMontoPresupuesto = new javax.swing.JTextField();
        btnRegistrarIngreso = new javax.swing.JPanel();
        txtPrevisualizarPresupuesto = new javax.swing.JLabel();
        txtBienvenida7 = new javax.swing.JLabel();
        cbxFecha1 = new javax.swing.JComboBox<>();
        btnRegistrarIngreso1 = new javax.swing.JPanel();
        txtFijarPresupuestoEgreso = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JPanel();
        txtEliminarP = new javax.swing.JLabel();
        btnFiltrar1 = new javax.swing.JPanel();
        txtModificarP = new javax.swing.JLabel();
        headercrema = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        bgTabla1 = new javax.swing.JPanel();
        txtBienvenida = new javax.swing.JLabel();
        txtBienvenida9 = new javax.swing.JLabel();
        bgTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPrevisualizar = new javax.swing.JTable();
        txtBienvenida8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBienvenida1.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida1.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        txtBienvenida1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida1.setText("PRESUPUESTO");
        jPanel1.add(txtBienvenida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 450, 50));

        cbxCategoria.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comida", "Transporte", "Entretenimiento", "Servicios", "Gastos Varios" }));
        cbxCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(cbxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 190, 40));

        txtBienvenida2.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida2.setFont(new java.awt.Font("Roboto Mono", 1, 30)); // NOI18N
        txtBienvenida2.setForeground(new java.awt.Color(47, 158, 68));
        txtBienvenida2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida2.setText("EGRESO");
        jPanel1.add(txtBienvenida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 450, 40));

        txtBienvenida3.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida3.setFont(new java.awt.Font("Roboto Mono", 0, 26)); // NOI18N
        txtBienvenida3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida3.setText("CATEGORIA");
        jPanel1.add(txtBienvenida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 180, 40));

        txtBienvenida4.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida4.setFont(new java.awt.Font("Roboto Mono", 0, 26)); // NOI18N
        txtBienvenida4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida4.setText("RANGO");
        jPanel1.add(txtBienvenida4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 40));

        cbxFecha2.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        cbxFecha2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(cbxFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 190, 40));

        txtBienvenida5.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida5.setFont(new java.awt.Font("Roboto Mono", 0, 26)); // NOI18N
        txtBienvenida5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida5.setText("PRESUPUESTO");
        jPanel1.add(txtBienvenida5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 180, 30));

        txtBienvenida6.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida6.setFont(new java.awt.Font("Roboto Mono", 0, 26)); // NOI18N
        txtBienvenida6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida6.setText("MONTO");
        jPanel1.add(txtBienvenida6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 180, 40));

        txtMontoPresupuesto.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtMontoPresupuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtMontoPresupuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMontoPresupuestoMousePressed(evt);
            }
        });
        jPanel1.add(txtMontoPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 190, 40));

        btnRegistrarIngreso.setBackground(new java.awt.Color(255, 113, 3));
        btnRegistrarIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrevisualizarPresupuesto.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtPrevisualizarPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        txtPrevisualizarPresupuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPrevisualizarPresupuesto.setText("<html><center>PREVISUALIZAR<br>PRESUPUESTO<html>");
        btnRegistrarIngreso.add(txtPrevisualizarPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jPanel1.add(btnRegistrarIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 110, 140, 40));

        txtBienvenida7.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida7.setFont(new java.awt.Font("Roboto Mono", 0, 26)); // NOI18N
        txtBienvenida7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida7.setText("(MES-AÑO)");
        jPanel1.add(txtBienvenida7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 180, 30));

        cbxFecha1.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        cbxFecha1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(cbxFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 190, 40));

        btnRegistrarIngreso1.setBackground(new java.awt.Color(47, 158, 68));
        btnRegistrarIngreso1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFijarPresupuestoEgreso.setFont(new java.awt.Font("Roboto Mono", 1, 22)); // NOI18N
        txtFijarPresupuestoEgreso.setForeground(new java.awt.Color(255, 255, 255));
        txtFijarPresupuestoEgreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFijarPresupuestoEgreso.setText("<html><center>FIJAR<br>PRESUPUESTO<html>");
        btnRegistrarIngreso1.add(txtFijarPresupuestoEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        jPanel1.add(btnRegistrarIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 180, 60));

        btnFiltrar.setBackground(new java.awt.Color(194, 37, 92));
        btnFiltrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEliminarP.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtEliminarP.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminarP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEliminarP.setText("ELIMINAR");
        txtEliminarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar.add(txtEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel1.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 440, 150, 40));

        btnFiltrar1.setBackground(new java.awt.Color(156, 54, 181));
        btnFiltrar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModificarP.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtModificarP.setForeground(new java.awt.Color(255, 255, 255));
        txtModificarP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtModificarP.setText("MODIFICAR");
        txtModificarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar1.add(txtModificarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel1.add(btnFiltrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 150, 40));

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
        headercrema.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 40, 50));

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

        jPanel1.add(headercrema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 40));

        bgTabla1.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida.setText("MONTO PRESUPUESTO");
        bgTabla1.add(txtBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 190, 40));

        txtBienvenida9.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida9.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtBienvenida9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida9.setText("CATEGORIA");
        bgTabla1.add(txtBienvenida9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 130, 40));

        jPanel1.add(bgTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 460, 40));

        bgTabla.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        jtPrevisualizar.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        jtPrevisualizar.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPrevisualizar.setGridColor(new java.awt.Color(255, 255, 255));
        jtPrevisualizar.setMaximumSize(new java.awt.Dimension(0, 0));
        jtPrevisualizar.setMinimumSize(new java.awt.Dimension(0, 0));
        jtPrevisualizar.setSelectionBackground(new java.awt.Color(47, 158, 68));
        jtPrevisualizar.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtPrevisualizar);

        bgTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 480, 210));

        jPanel1.add(bgTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 460, 180));

        txtBienvenida8.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida8.setFont(new java.awt.Font("Roboto Mono", 0, 26)); // NOI18N
        txtBienvenida8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida8.setText("MES-AÑO");
        jPanel1.add(txtBienvenida8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMontoPresupuestoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMontoPresupuestoMousePressed

    }//GEN-LAST:event_txtMontoPresupuestoMousePressed

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

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked

        this.dispose();
        Ventana_Opciones_Fijar_Presupuesto opciones_fijar = new Ventana_Opciones_Fijar_Presupuesto();
        opciones_fijar.setVisible(true);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        btnAtras.setForeground(new Color(12, 133, 153));
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
        btnAtras.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_btnAtrasMouseExited

    private void headercremaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headercremaMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headercremaMouseDragged

    private void headercremaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headercremaMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headercremaMousePressed

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
            java.util.logging.Logger.getLogger(Ventana_Fijar_Egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Fijar_Egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Fijar_Egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Fijar_Egreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Fijar_Egreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bgTabla;
    public javax.swing.JPanel bgTabla1;
    public javax.swing.JLabel btnAtras;
    public javax.swing.JPanel btnFiltrar;
    public javax.swing.JPanel btnFiltrar1;
    public javax.swing.JPanel btnRegistrarIngreso;
    public javax.swing.JPanel btnRegistrarIngreso1;
    public javax.swing.JComboBox<String> cbxCategoria;
    public javax.swing.JComboBox<Datos_Fechas> cbxFecha1;
    public javax.swing.JComboBox<Datos_Fechas> cbxFecha2;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel headercrema;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtPrevisualizar;
    public javax.swing.JLabel txtBienvenida;
    public javax.swing.JLabel txtBienvenida1;
    public javax.swing.JLabel txtBienvenida2;
    public javax.swing.JLabel txtBienvenida3;
    public javax.swing.JLabel txtBienvenida4;
    public javax.swing.JLabel txtBienvenida5;
    public javax.swing.JLabel txtBienvenida6;
    public javax.swing.JLabel txtBienvenida7;
    public javax.swing.JLabel txtBienvenida8;
    public javax.swing.JLabel txtBienvenida9;
    public javax.swing.JLabel txtEliminarP;
    public javax.swing.JLabel txtFijarPresupuestoEgreso;
    public javax.swing.JLabel txtModificarP;
    public javax.swing.JTextField txtMontoPresupuesto;
    public javax.swing.JLabel txtPrevisualizarPresupuesto;
    // End of variables declaration//GEN-END:variables
}
