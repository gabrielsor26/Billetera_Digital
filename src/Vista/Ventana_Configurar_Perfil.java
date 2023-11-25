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
public class Ventana_Configurar_Perfil extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    public Ventana_Configurar_Perfil() {
        initComponents();
        
        btnModificarUsuario.requestFocusInWindow();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBienvenida = new javax.swing.JLabel();
        btnModificarUsuario = new javax.swing.JPanel();
        txtModificarUsuario = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        bgTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCategoriaIngreso = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JPanel();
        txtEliminar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JPanel();
        txtAgregar = new javax.swing.JLabel();
        bgTabla1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtFamilia = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnEliminar1 = new javax.swing.JPanel();
        txtEliminarFamilia = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JPanel();
        txtAgregarFamilia = new javax.swing.JLabel();
        bgTabla2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTipoServicio = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnEliminar2 = new javax.swing.JPanel();
        txtEliminarServicio = new javax.swing.JLabel();
        btnAgregar2 = new javax.swing.JPanel();
        txtAgregarServicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setFont(new java.awt.Font("Roboto Mono", 1, 30)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        txtBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida.setText("Perfil de [USUARIO]");
        jPanel1.add(txtBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 500, 50));

        btnModificarUsuario.setBackground(new java.awt.Color(121, 80, 242));
        btnModificarUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModificarUsuario.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtModificarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtModificarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtModificarUsuario.setText("<html><center>Modificar<br>Usuario<html>");
        txtModificarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtModificarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtModificarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtModificarUsuarioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtModificarUsuarioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtModificarUsuarioMouseReleased(evt);
            }
        });
        btnModificarUsuario.add(txtModificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jPanel1.add(btnModificarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 120, 40));

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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -10, 50, 50));

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

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 40));

        bgTabla.setBackground(new java.awt.Color(0, 92, 75));
        bgTabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jtCategoriaIngreso.setBackground(new java.awt.Color(0, 92, 75));
        jtCategoriaIngreso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtCategoriaIngreso.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jtCategoriaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        jtCategoriaIngreso.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCategoriaIngreso.setGridColor(new java.awt.Color(0, 92, 75));
        jtCategoriaIngreso.setMaximumSize(new java.awt.Dimension(0, 0));
        jtCategoriaIngreso.setMinimumSize(new java.awt.Dimension(0, 0));
        jtCategoriaIngreso.setSelectionBackground(new java.awt.Color(26, 177, 136));
        jtCategoriaIngreso.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtCategoriaIngreso);

        bgTabla.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 280, 160));

        jPanel1.add(bgTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 280, 140));

        jLabel10.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TIPO DE INGRESO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 180, 30));

        jLabel7.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("NOMBRE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 70, 30));

        jLabel8.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("APELLIDO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 100, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EMAIL");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 60, 30));

        jLabel6.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CONTRASEÑA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, 30));

        txtNombre.setBackground(new java.awt.Color(36, 48, 60));
        txtNombre.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtNombre.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 180, 30));

        txtApellido.setBackground(new java.awt.Color(36, 48, 60));
        txtApellido.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtApellido.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 180, 30));

        txtEmail.setBackground(new java.awt.Color(36, 48, 60));
        txtEmail.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 180, 30));

        txtContraseña.setBackground(new java.awt.Color(36, 48, 60));
        txtContraseña.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtContraseña.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 180, 30));

        jPanel2.setBackground(new java.awt.Color(67, 89, 112));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEliminar.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtEliminar.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEliminar.setText("Eliminar");
        btnEliminar.add(txtEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 40));

        btnAgregar.setBackground(new java.awt.Color(45, 204, 112));
        btnAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAgregar.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtAgregar.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAgregar.setText("Agregar");
        txtAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAgregarMouseClicked(evt);
            }
        });
        btnAgregar.add(txtAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 120, 110));

        bgTabla1.setBackground(new java.awt.Color(0, 92, 75));
        bgTabla1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jtFamilia.setBackground(new java.awt.Color(0, 92, 75));
        jtFamilia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtFamilia.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jtFamilia.setForeground(new java.awt.Color(255, 255, 255));
        jtFamilia.setModel(new javax.swing.table.DefaultTableModel(
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
        jtFamilia.setGridColor(new java.awt.Color(0, 92, 75));
        jtFamilia.setMaximumSize(new java.awt.Dimension(0, 0));
        jtFamilia.setMinimumSize(new java.awt.Dimension(0, 0));
        jtFamilia.setSelectionBackground(new java.awt.Color(26, 177, 136));
        jtFamilia.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jtFamilia);

        bgTabla1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 280, 160));

        jPanel1.add(bgTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 280, 140));

        jLabel11.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("FAMILIA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 180, 30));

        jPanel3.setBackground(new java.awt.Color(67, 89, 112));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar1.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEliminarFamilia.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtEliminarFamilia.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminarFamilia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEliminarFamilia.setText("Eliminar");
        btnEliminar1.add(txtEliminarFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel3.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 40));

        btnAgregar1.setBackground(new java.awt.Color(45, 204, 112));
        btnAgregar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAgregarFamilia.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtAgregarFamilia.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregarFamilia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAgregarFamilia.setText("Agregar");
        txtAgregarFamilia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAgregarFamiliaMouseClicked(evt);
            }
        });
        btnAgregar1.add(txtAgregarFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel3.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 540, 120, 110));

        bgTabla2.setBackground(new java.awt.Color(0, 92, 75));
        bgTabla2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jtTipoServicio.setBackground(new java.awt.Color(0, 92, 75));
        jtTipoServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtTipoServicio.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jtTipoServicio.setForeground(new java.awt.Color(255, 255, 255));
        jtTipoServicio.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTipoServicio.setGridColor(new java.awt.Color(0, 92, 75));
        jtTipoServicio.setMaximumSize(new java.awt.Dimension(0, 0));
        jtTipoServicio.setMinimumSize(new java.awt.Dimension(0, 0));
        jtTipoServicio.setSelectionBackground(new java.awt.Color(26, 177, 136));
        jtTipoServicio.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(jtTipoServicio);

        bgTabla2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 280, 160));

        jPanel1.add(bgTabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, 280, 140));

        jLabel12.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("TIPO SERVICIO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 180, 30));

        jPanel4.setBackground(new java.awt.Color(67, 89, 112));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar2.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEliminarServicio.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtEliminarServicio.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminarServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEliminarServicio.setText("Eliminar");
        btnEliminar2.add(txtEliminarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel4.add(btnEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 40));

        btnAgregar2.setBackground(new java.awt.Color(45, 204, 112));
        btnAgregar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAgregarServicio.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtAgregarServicio.setForeground(new java.awt.Color(255, 255, 255));
        txtAgregarServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAgregarServicio.setText("Agregar");
        txtAgregarServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAgregarServicioMouseClicked(evt);
            }
        });
        btnAgregar2.add(txtAgregarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel4.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 730, 120, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 920));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtModificarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarUsuarioMouseClicked

    }//GEN-LAST:event_txtModificarUsuarioMouseClicked

    private void txtModificarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarUsuarioMouseEntered
        btnModificarUsuario.setBackground(new Color(149, 117, 244));
    }//GEN-LAST:event_txtModificarUsuarioMouseEntered

    private void txtModificarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarUsuarioMouseExited
        btnModificarUsuario.setBackground(new Color(121, 80, 242));
    }//GEN-LAST:event_txtModificarUsuarioMouseExited

    private void txtModificarUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarUsuarioMousePressed
        btnModificarUsuario.setBackground(new Color(166, 139, 245));
    }//GEN-LAST:event_txtModificarUsuarioMousePressed

    private void txtModificarUsuarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarUsuarioMouseReleased
        btnModificarUsuario.setBackground(new Color(149, 117, 244));
    }//GEN-LAST:event_txtModificarUsuarioMouseReleased

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

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headerMousePressed

    private void txtAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAgregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarMouseClicked

    private void txtAgregarFamiliaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAgregarFamiliaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarFamiliaMouseClicked

    private void txtAgregarServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAgregarServicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarServicioMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana_Configurar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Configurar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Configurar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Configurar_Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Configurar_Perfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bgTabla;
    public javax.swing.JPanel bgTabla1;
    public javax.swing.JPanel bgTabla2;
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnAgregar1;
    private javax.swing.JPanel btnAgregar2;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnEliminar1;
    private javax.swing.JPanel btnEliminar2;
    private javax.swing.JPanel btnModificarUsuario;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jtCategoriaIngreso;
    public javax.swing.JTable jtFamilia;
    public javax.swing.JTable jtTipoServicio;
    public javax.swing.JLabel txtAgregar;
    public javax.swing.JLabel txtAgregarFamilia;
    public javax.swing.JLabel txtAgregarServicio;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JLabel txtBienvenida;
    public javax.swing.JTextField txtContraseña;
    public javax.swing.JLabel txtEliminar;
    public javax.swing.JLabel txtEliminarFamilia;
    public javax.swing.JLabel txtEliminarServicio;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JLabel txtModificarUsuario;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
