/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Ctrl_Metas;
import java.awt.Color;

public class Ventana_Asignar_Recursos extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    public Ventana_Asignar_Recursos() {
        initComponents();
        //jtMetas = new JTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnObtener = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bgTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMetas = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        btnAtras1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 160, 40));

        btnObtener.setBackground(new java.awt.Color(255, 204, 0));
        btnObtener.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnObtener.setForeground(new java.awt.Color(255, 255, 255));
        btnObtener.setText("OBTENER");
        btnObtener.setBorder(null);
        btnObtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerActionPerformed(evt);
            }
        });
        jPanel1.add(btnObtener, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 140, 96));

        btnAgregar.setBackground(new java.awt.Color(26, 177, 136));
        btnAgregar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR FONDOS");
        btnAgregar.setBorder(null);
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 210, 96));

        btnQuitar.setBackground(new java.awt.Color(204, 0, 102));
        btnQuitar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("QUITAR FONDOS");
        btnQuitar.setBorder(null);
        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 210, 96));

        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 46)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ASIGNAR RECURSOS A UNA META");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        bgTabla.setBackground(new java.awt.Color(255, 255, 255));
        bgTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jtMetas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtMetas.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jtMetas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtMetas.setGridColor(new java.awt.Color(0, 92, 75));
        jtMetas.setMaximumSize(new java.awt.Dimension(0, 0));
        jtMetas.setMinimumSize(new java.awt.Dimension(0, 0));
        jtMetas.setSelectionBackground(new java.awt.Color(255, 204, 0));
        jtMetas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtMetas);

        bgTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 880, 340));

        jPanel1.add(bgTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 880, 310));

        jLabel11.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("NOMBRE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, 30));

        jLabel12.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("MONTO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 140, 30));

        jLabel13.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ESTADO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 120, 30));

        jLabel14.setFont(new java.awt.Font("Roboto Mono", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("RECURSOS ASIGNADOS");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 140, 30));

        jLabel15.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("FECHA");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 120, 30));

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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, -10, 50, 50));

        btnAtras1.setFont(new java.awt.Font("FG Virgil", 1, 30)); // NOI18N
        btnAtras1.setForeground(new java.awt.Color(62, 82, 102));
        btnAtras1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtras1.setText("<---");
        btnAtras1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtras1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtras1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtras1MouseExited(evt);
            }
        });
        header.add(btnAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 40));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObtenerActionPerformed

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

    private void btnAtras1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtras1MouseClicked
        this.dispose();
        Ventana_Metas frm_metas = new Ventana_Metas();

        Ctrl_Metas ctrl_metas = new Ctrl_Metas(frm_metas);

        ctrl_metas.iniciar();
        frm_metas.setVisible(true);
    }//GEN-LAST:event_btnAtras1MouseClicked

    private void btnAtras1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtras1MouseEntered
        btnAtras1.setForeground(new Color(12, 133, 153));
    }//GEN-LAST:event_btnAtras1MouseEntered

    private void btnAtras1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtras1MouseExited
        btnAtras1.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_btnAtras1MouseExited

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headerMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bgTabla;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JLabel btnAtras1;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnObtener;
    public javax.swing.JButton btnQuitar;
    public javax.swing.JLabel exitTxt;
    public javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtMetas;
    // End of variables declaration//GEN-END:variables
}
