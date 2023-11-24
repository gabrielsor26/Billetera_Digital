
package Vista;

import Controlador.CtrlMenu_Opciones;
import Modelo.Conexion;
import static Vista.Ventana_Login.usuario_id;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Ventana_Login extends javax.swing.JFrame {

    int xMouse, yMouse;
    int xMouseCrema, yMouseCrema;
    //Para el contador
    private static int contadorInstancias = 0;
    //public static Ventana_Registrar fr;
    public static int usuario_id;

    PreparedStatement ps = null;
    ResultSet rs = null;
    Modelo.Conexion con = new Conexion();
    java.sql.Connection cn = con.getConexion();

    public Ventana_Login() {
        initComponents();
        this.setLocationRelativeTo(null);

        btnIniciar.requestFocusInWindow();
        contadorInstancias++;
    }

    public static int getContadorInstancias() {
        return contadorInstancias;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        fondogris = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JPanel();
        txtIngresar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JPanel();
        txtRegistrar = new javax.swing.JLabel();
        fondocrema = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        headercrema = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(36, 48, 60));
        header.setForeground(new java.awt.Color(255, 255, 255));
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

        exitBtn.setBackground(new java.awt.Color(36, 48, 60));
        exitBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 470, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 40));

        fondogris.setBackground(new java.awt.Color(36, 48, 60));
        fondogris.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Billetera Digital");
        fondogris.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 330, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Billetera.png"))); // NOI18N
        fondogris.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Roboto Mono", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INICIAR SESIÓN");
        fondogris.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto Mono", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CONTRASEÑA");
        fondogris.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Roboto Mono", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Puede registrarse aqui");
        fondogris.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        txtContraseña.setBackground(new java.awt.Color(36, 48, 60));
        txtContraseña.setFont(new java.awt.Font("Roboto Mono", 1, 20)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(52, 69, 86));
        txtContraseña.setText("********");
        txtContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseñaMousePressed(evt);
            }
        });
        fondogris.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 380, 40));

        txtEmail.setBackground(new java.awt.Color(36, 48, 60));
        txtEmail.setFont(new java.awt.Font("Roboto Mono", 1, 20)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(52, 69, 86));
        txtEmail.setText("Ingrese su email*");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        fondogris.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 380, 40));

        btnIniciar.setBackground(new java.awt.Color(26, 177, 136));

        txtIngresar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtIngresar.setForeground(new java.awt.Color(255, 255, 255));
        txtIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIngresar.setText("INGRESAR");
        txtIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtIngresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIngresarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtIngresarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout btnIniciarLayout = new javax.swing.GroupLayout(btnIniciar);
        btnIniciar.setLayout(btnIniciarLayout);
        btnIniciarLayout.setHorizontalGroup(
            btnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnIniciarLayout.setVerticalGroup(
            btnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        fondogris.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 170, 50));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Roboto Mono", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("EMAIL");
        fondogris.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dedo.png"))); // NOI18N
        fondogris.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, 30));

        btnRegistrar.setBackground(new java.awt.Color(0, 92, 75));

        txtRegistrar.setFont(new java.awt.Font("Roboto Mono", 1, 14)); // NOI18N
        txtRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        txtRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegistrar.setText("REGISTRARSE");
        txtRegistrar.setToolTipText("");
        txtRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtRegistrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRegistrarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btnRegistrarLayout = new javax.swing.GroupLayout(btnRegistrar);
        btnRegistrar.setLayout(btnRegistrarLayout);
        btnRegistrarLayout.setHorizontalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnRegistrarLayout.setVerticalGroup(
            btnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        fondogris.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 120, 30));

        bg.add(fondogris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 500));

        fondocrema.setBackground(new java.awt.Color(255, 255, 204));
        fondocrema.setToolTipText("");
        fondocrema.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DINERO 1.png"))); // NOI18N
        fondocrema.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 230, 310));

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
        headercrema.add(exitTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, -10, 40, 50));

        fondocrema.add(headercrema, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 40));

        bg.add(fondocrema, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 330, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static int getUsuarioId() {
        return usuario_id;
    }

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

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

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        if (txtEmail.getText().equals("Ingrese su email*")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.white);
        }
        if (String.valueOf(txtContraseña.getPassword()).isEmpty()) {
            txtContraseña.setText("********");
            txtContraseña.setForeground(new Color(52, 69, 86));
        }
    }//GEN-LAST:event_txtEmailMousePressed

    private void headercremaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headercremaMousePressed
        xMouseCrema = evt.getXOnScreen() - this.getX();
        yMouseCrema = evt.getYOnScreen() - this.getY();
    }//GEN-LAST:event_headercremaMousePressed

    private void headercremaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headercremaMouseDragged
        int x1 = evt.getXOnScreen() - xMouseCrema;
        int y1 = evt.getYOnScreen() - yMouseCrema;
        this.setLocation(x1, y1);
    }//GEN-LAST:event_headercremaMouseDragged

    private void txtIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIngresarMouseEntered
        btnIniciar.setBackground(new Color(30, 202, 154));
    }//GEN-LAST:event_txtIngresarMouseEntered

    private void txtIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIngresarMouseExited
        btnIniciar.setBackground(new Color(26, 177, 136));
    }//GEN-LAST:event_txtIngresarMouseExited

    private void txtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMousePressed
        if (String.valueOf(txtContraseña.getPassword()).equals("********")) {
            txtContraseña.setText("");
            txtContraseña.setForeground(Color.white);
        }
        if (txtEmail.getText().isEmpty()) {
            txtEmail.setText("Ingrese su email*");
            txtEmail.setForeground(new Color(52, 69, 86));
        }
    }//GEN-LAST:event_txtContraseñaMousePressed

    private void txtIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIngresarMouseClicked
        String usuario = txtEmail.getText();
        String pass = txtContraseña.getText();
        if (!usuario.equals("") || !pass.equals("")) {
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT usuario_id, tipo_nivel FROM usuarios WHERE email='" + usuario + "' and pass='" + pass + "'");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                }
                usuario_id = rs.getInt("usuario_id");

                System.out.println("1: " + usuario_id);
                String tiponivel = rs.getString("tipo_nivel");

                //ADMINISTRADOR
                if (tiponivel.equalsIgnoreCase("Admin")) {
                    dispose();
                    
                    Ventana_Admin frm_ventana_admin = new Ventana_Admin();
                    //Ventana_Admin frm_ventana_admin = new Ventana_Admin();
                    frm_ventana_admin.setVisible(true);

                    // GENERAL
                } else if (tiponivel.equalsIgnoreCase("General")) {
                    dispose();
                    Ventana_Opciones frm_opciones = new Ventana_Opciones();
                    CtrlMenu_Opciones ctrlmenu_opciones = new CtrlMenu_Opciones(frm_opciones);
                    ctrlmenu_opciones.iniciar();
                    frm_opciones.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "USUARIO Y CONTRASEÑA INCORRECTOS");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL INICIAR SESION" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }
    }//GEN-LAST:event_txtIngresarMouseClicked

    private void txtRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarMouseEntered
        btnRegistrar.setBackground(new Color(0, 147, 121));
    }//GEN-LAST:event_txtRegistrarMouseEntered

    private void txtRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarMouseExited
        btnRegistrar.setBackground(new Color(0,92,75));
    }//GEN-LAST:event_txtRegistrarMouseExited

    private void txtRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarMouseClicked
        this.setVisible(true);
        
        Ventana_Registrar frm_registrar = new Ventana_Registrar(this);
        frm_registrar.setVisible(true);
    }//GEN-LAST:event_txtRegistrarMouseClicked

    private void txtIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIngresarMousePressed
        btnIniciar.setBackground(new Color(68, 227, 184));
    }//GEN-LAST:event_txtIngresarMousePressed

    private void txtIngresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIngresarMouseReleased
        btnIniciar.setBackground(new Color(30, 202, 154));
    }//GEN-LAST:event_txtIngresarMouseReleased

    private void txtRegistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarMousePressed
        btnRegistrar.setBackground(new Color(0,198,163));
    }//GEN-LAST:event_txtRegistrarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnIniciar;
    private javax.swing.JPanel btnRegistrar;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel fondocrema;
    private javax.swing.JPanel fondogris;
    private javax.swing.JPanel header;
    private javax.swing.JPanel headercrema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtIngresar;
    private javax.swing.JLabel txtRegistrar;
    // End of variables declaration//GEN-END:variables
}
