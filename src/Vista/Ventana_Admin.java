package Vista;

import Modelo.Conexion;
import static Vista.Ventana_Login.usuario_id;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Ventana_Admin extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;

    DefaultTableModel modelo = new DefaultTableModel();

    // hacer que la columna cero no sea editable
    public class MyTableModel extends DefaultTableModel {

        public MyTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Aquí puedes especificar las columnas que no quieres que sean editables
            return false; // La columna 0 (ID) no será editable
        }
    }

    public Ventana_Admin() {
        initComponents();

        this.setLocationRelativeTo(null);

        try {

            Ventana_Admin.MyTableModel modelo = new Ventana_Admin.MyTableModel(new Object[][]{}, new Object[]{"ID", "NOMBRE", "APELLIDO", "EMAIL", "CONTRASEÑA", "TIPO DE USUARIO"});

            jtUsuarios.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT usuario_id, nombre, apellido, email, pass, tipo_nivel FROM usuarios";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            System.out.println("La cantidad de columnas es: " + cantidadColumnas);
            /*
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("EMAIL");
            modelo.addColumn("CONTRASEÑA");
            modelo.addColumn("TIPO DE USUARIO");
             */
            // jtUsuarios.removeColumn(jtUsuarios.getColumnModel().getColumn(0));  // 0 es el índice de la columna "usuario_id"

            int altoFila = 40;
            int[] anchos = {50, 200, 280, 420, 200, 190};

            jtUsuarios.setRowHeight(altoFila);

            for (int i = 0; i < jtUsuarios.getColumnCount(); i++) {
                jtUsuarios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

            for (int i = 0; i < jtUsuarios.getColumnCount(); i++) {
                jtUsuarios.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

            javax.swing.table.TableColumnModel columnModel = jtUsuarios.getColumnModel();
            javax.swing.table.TableColumn idColumn = columnModel.getColumn(0);
            idColumn.setMinWidth(0);
            idColumn.setMaxWidth(0);
            idColumn.setPreferredWidth(0);
            idColumn.setResizable(false);

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

        //Ver o no encabezado
        jtUsuarios.getTableHeader().setVisible(false);
        jtUsuarios.setBorder(BorderFactory.createEmptyBorder());
        jtUsuarios.setIntercellSpacing(new java.awt.Dimension(0, 0));

        jScrollPane2.getViewport().setBackground(new Color(0, 92, 75));
        usuario_id = Ventana_Login.usuario_id;
        System.out.println(usuario_id);

    }

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
        jtUsuarios = new javax.swing.JTable();
        btnModificar = new javax.swing.JPanel();
        txtModificar = new javax.swing.JLabel();
        jComboTipo_Usuario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
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
        header.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, -10, 50, 50));

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

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTIÓN DE USUARIOS");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1160, 40));

        btnEliminar.setBackground(new java.awt.Color(255, 1, 0));
        btnEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEliminar.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtEliminar.setForeground(new java.awt.Color(255, 255, 255));
        txtEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEliminar.setText("ELIMINAR");
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
        btnEliminar.add(txtEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        background.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 570, 140, 40));

        backgroundtabla.setBackground(new java.awt.Color(0, 92, 75));
        backgroundtabla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(0, 92, 75));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jScrollPane2.setColumnHeaderView(null);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(null);
        jScrollPane2.setWheelScrollingEnabled(false);

        jtUsuarios.setBackground(new java.awt.Color(0, 92, 75));
        jtUsuarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtUsuarios.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jtUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtUsuarios.setGridColor(new java.awt.Color(0, 92, 75));
        jtUsuarios.setSelectionBackground(new java.awt.Color(26, 177, 136));
        jtUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtUsuarios);

        backgroundtabla.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 760, 490));

        background.add(backgroundtabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 760, 470));

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
        btnModificar.add(txtModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        background.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 520, 140, 40));

        jComboTipo_Usuario.setBackground(new java.awt.Color(36, 48, 60));
        jComboTipo_Usuario.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jComboTipo_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jComboTipo_Usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "General" }));
        jComboTipo_Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jComboTipo_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipo_UsuarioActionPerformed(evt);
            }
        });
        background.add(jComboTipo_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 460, 280, 40));

        jLabel5.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TIPO");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));

        txtPass.setBackground(new java.awt.Color(36, 48, 60));
        txtPass.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtPass.setCaretColor(new java.awt.Color(255, 255, 255));
        background.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 280, 40));

        jLabel6.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRE");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

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
        background.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 280, 40));

        jLabel7.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("APELLIDO");
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        txtApellido.setBackground(new java.awt.Color(36, 48, 60));
        txtApellido.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtApellido.setCaretColor(new java.awt.Color(255, 255, 255));
        background.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 280, 40));

        jLabel8.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EMAIL");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        txtEmail.setBackground(new java.awt.Color(36, 48, 60));
        txtEmail.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        background.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, 280, 40));

        jLabel9.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CONTRASEÑA");
        background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 320, 540));

        jLabel10.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre");
        background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Apellido");
        background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email");
        background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Contraseña");
        background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Mono", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tipo de usuario");
        background.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, -1, -1));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboTipo_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipo_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTipo_UsuarioActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    //MODIFICAR 
    private void txtModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseEntered
        btnModificar.setBackground(new Color(149, 117, 244));
    }//GEN-LAST:event_txtModificarMouseEntered

    private void txtModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseExited
        btnModificar.setBackground(new Color(121, 80, 242));
    }//GEN-LAST:event_txtModificarMouseExited

    //ELIMINAR
    private void txtEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseEntered
        btnEliminar.setBackground(new Color(255, 81, 81));
    }//GEN-LAST:event_txtEliminarMouseEntered

    private void txtEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseExited
        btnEliminar.setBackground(new Color(255, 1, 0));
    }//GEN-LAST:event_txtEliminarMouseExited

    //MODIFICAR
    private void txtModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMousePressed
        btnModificar.setBackground(new Color(166, 139, 245));
    }//GEN-LAST:event_txtModificarMousePressed
    //ELIMINAR
    private void txtEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMousePressed
        btnEliminar.setBackground(new Color(255, 113, 113));
    }//GEN-LAST:event_txtEliminarMousePressed

    private void txtModificarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseReleased
        btnModificar.setBackground(new Color(149, 117, 244));
    }//GEN-LAST:event_txtModificarMouseReleased

    private void txtEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseReleased
        btnEliminar.setBackground(new Color(255, 81, 81));
    }//GEN-LAST:event_txtEliminarMouseReleased

    private void txtModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModificarMouseClicked
        int Fila = jtUsuarios.getSelectedRow();
        int ID_USUARIO = (int) jtUsuarios.getValueAt(Fila, 0);

        System.out.println("La fila es: " + Fila);

        PreparedStatement ps = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();
            ps = conn.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?, email=?, pass=?, tipo_nivel=? WHERE usuario_id=?");

            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtApellido.getText());
            ps.setString(3, txtEmail.getText());
            ps.setString(4, txtPass.getText());
            ps.setString(5, jComboTipo_Usuario.getSelectedItem().toString());
            ps.setString(6, String.valueOf(ID_USUARIO));

            System.out.println("Pass: " + txtPass.getText());
            System.out.println("Tipo usuario: " + jComboTipo_Usuario.getSelectedItem().toString());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Usuario Modificado");
            //jtUsuarios.setValueAt(txtCodigo.getText(), Fila, 0);
            jtUsuarios.setValueAt(txtNombre.getText(), Fila, 1);
            jtUsuarios.setValueAt(txtApellido.getText(), Fila, 2);
            jtUsuarios.setValueAt(txtEmail.getText(), Fila, 3);
            jtUsuarios.setValueAt(txtPass.getText(), Fila, 4);
            jtUsuarios.setValueAt(jComboTipo_Usuario.getSelectedItem().toString(), Fila, 5);

            limpiar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Modificar Usuario");
            System.out.println(ex);
        }
    }//GEN-LAST:event_txtModificarMouseClicked

    private void txtEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEliminarMouseClicked
        
        int Fila = jtUsuarios.getSelectedRow();

        if (Fila < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila antes de eliminar.");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este usuario?\n"
                + " Se eliminara todo registro de ingresos y egresos", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            PreparedStatement ps = null;
            int codigo = (int) jtUsuarios.getValueAt(Fila, 0);

            try {
                Conexion objCon = new Conexion();
                Connection conn = objCon.getConexion();

                ps = conn.prepareStatement("DELETE FROM usuarios WHERE usuario_id=?");
                ps.setString(1, String.valueOf(codigo));
                ps.execute();

                ((Ventana_Admin.MyTableModel) jtUsuarios.getModel()).removeRow(Fila);
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                limpiar();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Usuario");
                System.out.println(ex.toString());
            }
        }

    }//GEN-LAST:event_txtEliminarMouseClicked

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = objCon.getConexion();

            int Fila = jtUsuarios.getSelectedRow();

            String codigo = jtUsuarios.getValueAt(Fila, 0).toString();

            System.out.println("El valor de codigo es: " + codigo);

            ps = conn.prepareStatement("SELECT usuario_id, nombre, apellido, email, pass, tipo_nivel FROM usuarios WHERE usuario_id=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {

                //txtCodigo.setText(rs.getString("usuario_id"));
                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                txtEmail.setText(rs.getString("email"));
                txtPass.setText(rs.getString("pass"));

                String tipo_usuario = rs.getString("tipo_nivel"); // Reemplaza "nombre_de_la_ultima_columna" con el nombre de la columna real
                jComboTipo_Usuario.setSelectedItem(tipo_usuario);

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headerMouseDragged

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
        btnAtras.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_btnAtrasMouseExited

    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        btnAtras.setForeground(new Color(12, 133, 153));
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked

        this.dispose();
        Ventana_Login frm_ventana_login = new Ventana_Login();
        frm_ventana_login.setVisible(true);
    }//GEN-LAST:event_btnAtrasMouseClicked

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        //exitBtn.setBackground(new Color(36, 48, 60));
        exitTxt.setForeground(new Color(62, 82, 102));
    }//GEN-LAST:event_exitTxtMouseExited

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        //exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.red);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void limpiar() {
        //txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtPass.setText("");
        String txtvacio = "Admin";
        jComboTipo_Usuario.setSelectedItem(txtvacio);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel backgroundtabla;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JPanel btnModificar;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboTipo_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JLabel txtEliminar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtModificar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
