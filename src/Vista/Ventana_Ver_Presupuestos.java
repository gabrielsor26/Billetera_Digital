/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlMenu_Opciones;
import Modelo.Datos_Fechas;
import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class Ventana_Ver_Presupuestos extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    public Ventana_Ver_Presupuestos() {
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
        cbxFecha = new javax.swing.JComboBox<>();
        txtBienvenida1 = new javax.swing.JLabel();
        txtBienvenida8 = new javax.swing.JLabel();
        btnRegistrarIngreso = new javax.swing.JPanel();
        txtFiltrar = new javax.swing.JLabel();
        txtBienvenida2 = new javax.swing.JLabel();
        bgTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPresupuestoIngreso = new javax.swing.JTable();
        bgTabla1 = new javax.swing.JPanel();
        txtBienvenida = new javax.swing.JLabel();
        txtBienvenida9 = new javax.swing.JLabel();
        bgTabla2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPresupuestoEgreso = new javax.swing.JTable();
        bgTabla3 = new javax.swing.JPanel();
        txtBienvenida4 = new javax.swing.JLabel();
        txtBienvenida10 = new javax.swing.JLabel();
        txtBienvenida3 = new javax.swing.JLabel();
        bgTabla4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtIngresoReal = new javax.swing.JTable();
        bgTabla5 = new javax.swing.JPanel();
        txtBienvenida5 = new javax.swing.JLabel();
        txtBienvenida11 = new javax.swing.JLabel();
        bgTabla6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtEgresoReal = new javax.swing.JTable();
        bgTabla7 = new javax.swing.JPanel();
        txtBienvenida6 = new javax.swing.JLabel();
        txtBienvenida12 = new javax.swing.JLabel();
        txtBienvenida7 = new javax.swing.JLabel();
        txtBienvenida13 = new javax.swing.JLabel();

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
        headercrema.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, -10, 40, 50));

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

        jPanel1.add(headercrema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 40));

        cbxFecha.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        cbxFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(cbxFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 190, 40));

        txtBienvenida1.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida1.setFont(new java.awt.Font("Roboto Mono", 0, 36)); // NOI18N
        txtBienvenida1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida1.setText("MIS PRESUPUESTOS");
        jPanel1.add(txtBienvenida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 450, 50));

        txtBienvenida8.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida8.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtBienvenida8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida8.setText("SELECCIONE EL RANGO");
        jPanel1.add(txtBienvenida8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 230, 40));

        btnRegistrarIngreso.setBackground(new java.awt.Color(255, 113, 3));
        btnRegistrarIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFiltrar.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        txtFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFiltrar.setText("<html><center>FILTRAR<br>MES-AÑO<html>");
        btnRegistrarIngreso.add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jPanel1.add(btnRegistrarIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 140, 40));

        txtBienvenida2.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida2.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtBienvenida2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida2.setText("REAL");
        jPanel1.add(txtBienvenida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 70, 50));

        bgTabla.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        jtPresupuestoIngreso.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        jtPresupuestoIngreso.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPresupuestoIngreso.setGridColor(new java.awt.Color(255, 255, 255));
        jtPresupuestoIngreso.setMaximumSize(new java.awt.Dimension(0, 0));
        jtPresupuestoIngreso.setMinimumSize(new java.awt.Dimension(0, 0));
        jtPresupuestoIngreso.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jtPresupuestoIngreso.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtPresupuestoIngreso);

        bgTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 340, 170));

        jPanel1.add(bgTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 320, 140));

        bgTabla1.setBackground(new java.awt.Color(25, 113, 194));
        bgTabla1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida.setText("MONTO PRESUPUESTO");
        bgTabla1.add(txtBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 190, 40));

        txtBienvenida9.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida9.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida9.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida9.setText("CATEGORIA");
        bgTabla1.add(txtBienvenida9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel1.add(bgTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 320, 40));

        bgTabla2.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(null);

        jtPresupuestoEgreso.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        jtPresupuestoEgreso.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPresupuestoEgreso.setGridColor(new java.awt.Color(255, 255, 255));
        jtPresupuestoEgreso.setMaximumSize(new java.awt.Dimension(0, 0));
        jtPresupuestoEgreso.setMinimumSize(new java.awt.Dimension(0, 0));
        jtPresupuestoEgreso.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jtPresupuestoEgreso.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jtPresupuestoEgreso);

        bgTabla2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 350, 190));

        jPanel1.add(bgTabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 320, 160));

        bgTabla3.setBackground(new java.awt.Color(47, 158, 68));
        bgTabla3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBienvenida4.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida4.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida4.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida4.setText("MONTO PRESUPUESTO");
        bgTabla3.add(txtBienvenida4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 190, 40));

        txtBienvenida10.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida10.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida10.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida10.setText("CATEGORIA");
        bgTabla3.add(txtBienvenida10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel1.add(bgTabla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 320, 40));

        txtBienvenida3.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida3.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtBienvenida3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida3.setText("EGRESO");
        jPanel1.add(txtBienvenida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 100, 50));

        bgTabla4.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);

        jtIngresoReal.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        jtIngresoReal.setModel(new javax.swing.table.DefaultTableModel(
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
        jtIngresoReal.setGridColor(new java.awt.Color(255, 255, 255));
        jtIngresoReal.setMaximumSize(new java.awt.Dimension(0, 0));
        jtIngresoReal.setMinimumSize(new java.awt.Dimension(0, 0));
        jtIngresoReal.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jtIngresoReal.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jtIngresoReal);

        bgTabla4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 340, 170));

        jPanel1.add(bgTabla4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 320, 140));

        bgTabla5.setBackground(new java.awt.Color(25, 113, 194));
        bgTabla5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBienvenida5.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida5.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida5.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida5.setText("MONTO REAL");
        bgTabla5.add(txtBienvenida5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 120, 40));

        txtBienvenida11.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida11.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida11.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida11.setText("CATEGORIA");
        bgTabla5.add(txtBienvenida11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel1.add(bgTabla5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 320, 40));

        bgTabla6.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(null);

        jtEgresoReal.setFont(new java.awt.Font("Roboto Mono", 0, 14)); // NOI18N
        jtEgresoReal.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEgresoReal.setGridColor(new java.awt.Color(255, 255, 255));
        jtEgresoReal.setMaximumSize(new java.awt.Dimension(0, 0));
        jtEgresoReal.setMinimumSize(new java.awt.Dimension(0, 0));
        jtEgresoReal.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jtEgresoReal.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(jtEgresoReal);

        bgTabla6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 350, 190));

        jPanel1.add(bgTabla6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 320, 160));

        bgTabla7.setBackground(new java.awt.Color(47, 158, 68));
        bgTabla7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBienvenida6.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida6.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida6.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida6.setText("MONTO REAL");
        bgTabla7.add(txtBienvenida6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 160, 40));

        txtBienvenida12.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida12.setFont(new java.awt.Font("Roboto Mono", 0, 16)); // NOI18N
        txtBienvenida12.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida12.setText("CATEGORIA");
        bgTabla7.add(txtBienvenida12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel1.add(bgTabla7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 320, 40));

        txtBienvenida7.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida7.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtBienvenida7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida7.setText("PROYECTADO");
        jPanel1.add(txtBienvenida7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 160, 50));

        txtBienvenida13.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida13.setFont(new java.awt.Font("Roboto Mono", 0, 18)); // NOI18N
        txtBienvenida13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida13.setText("INGRESO");
        jPanel1.add(txtBienvenida13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 100, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 690));

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
        Ventana_Opciones_Presupuesto opciones_presupuesto = new Ventana_Opciones_Presupuesto();
        opciones_presupuesto.setVisible(true);
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
            java.util.logging.Logger.getLogger(Ventana_Ver_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ver_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ver_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Ver_Presupuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Ver_Presupuestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bgTabla;
    public javax.swing.JPanel bgTabla1;
    public javax.swing.JPanel bgTabla2;
    public javax.swing.JPanel bgTabla3;
    public javax.swing.JPanel bgTabla4;
    public javax.swing.JPanel bgTabla5;
    public javax.swing.JPanel bgTabla6;
    public javax.swing.JPanel bgTabla7;
    public javax.swing.JLabel btnAtras;
    public javax.swing.JPanel btnRegistrarIngreso;
    public javax.swing.JComboBox<Datos_Fechas> cbxFecha;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel headercrema;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jtEgresoReal;
    public javax.swing.JTable jtIngresoReal;
    public javax.swing.JTable jtPresupuestoEgreso;
    public javax.swing.JTable jtPresupuestoIngreso;
    public javax.swing.JLabel txtBienvenida;
    public javax.swing.JLabel txtBienvenida1;
    public javax.swing.JLabel txtBienvenida10;
    public javax.swing.JLabel txtBienvenida11;
    public javax.swing.JLabel txtBienvenida12;
    public javax.swing.JLabel txtBienvenida13;
    public javax.swing.JLabel txtBienvenida2;
    public javax.swing.JLabel txtBienvenida3;
    public javax.swing.JLabel txtBienvenida4;
    public javax.swing.JLabel txtBienvenida5;
    public javax.swing.JLabel txtBienvenida6;
    public javax.swing.JLabel txtBienvenida7;
    public javax.swing.JLabel txtBienvenida8;
    public javax.swing.JLabel txtBienvenida9;
    public javax.swing.JLabel txtFiltrar;
    // End of variables declaration//GEN-END:variables
}
