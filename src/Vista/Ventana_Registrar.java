package Vista;

import Modelo.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Ventana_Registrar extends javax.swing.JFrame {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Modelo.Conexion con = new Conexion();
    java.sql.Connection cn = con.getConexion();

    private Ventana_Login ventanaLogin;

    public Ventana_Registrar(Ventana_Login ventanaLogin) {
        this.ventanaLogin = ventanaLogin;

        initComponents();
        this.setTitle("Registrar Usuario");
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Muestra la ventana de inicio de sesión al cerrar la ventana de registro

                volverAInicioSesion();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combotipo = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 48, 60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRAR USUARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 410, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        txtnombre.setBackground(new java.awt.Color(36, 48, 60));
        txtnombre.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(255, 255, 255));
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtnombre.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 384, -1));

        txtapellido.setBackground(new java.awt.Color(36, 48, 60));
        txtapellido.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtapellido.setForeground(new java.awt.Color(255, 255, 255));
        txtapellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtapellido.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 384, -1));

        txtemail.setBackground(new java.awt.Color(36, 48, 60));
        txtemail.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtemail.setForeground(new java.awt.Color(255, 255, 255));
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtemail.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 384, -1));

        txtpassword.setBackground(new java.awt.Color(36, 48, 60));
        txtpassword.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtpassword.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 384, -1));

        jLabel6.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        combotipo.setBackground(new java.awt.Color(36, 48, 60));
        combotipo.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        combotipo.setForeground(new java.awt.Color(255, 255, 255));
        combotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione . . .", "Admin", "General" }));
        combotipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(combotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 380, -1));

        btnRegistrar.setBackground(new java.awt.Color(0, 204, 153));
        btnRegistrar.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String email = txtemail.getText();
        String pass = txtpassword.getText();
        String tipousuario = combotipo.getSelectedItem().toString();

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            if (tipousuario.equalsIgnoreCase("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR UN TIPO DE USUARIO");
            } else {
                if (pass.length() < 7 || !containsNumber(pass)) {
                    JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 7 caracteres y contener al menos un número.");
                } else {
                    try {
                        // Consulta para verificar si el correo electrónico ya está registrado
                        String consultaEmailExistente = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
                        PreparedStatement psEmailExistente = cn.prepareStatement(consultaEmailExistente);
                        psEmailExistente.setString(1, email);
                        ResultSet rs = psEmailExistente.executeQuery();
                        rs.next();
                        int count = rs.getInt(1);

                        if (count > 0) {
                            JOptionPane.showMessageDialog(null, "El correo electrónico ya está registrado.");
                        } else {
                            // Si el correo electrónico no está registrado, realiza la inserción
                            String consulta = "INSERT INTO usuarios (nombre, apellido, email, pass, tipo_nivel) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement ps = cn.prepareStatement(consulta);
                            ps.setString(1, nombre);
                            ps.setString(2, apellido);
                            ps.setString(3, email);
                            ps.setString(4, pass);
                            ps.setString(5, tipousuario);
                            ps.executeUpdate();
                            limpiar();
                            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CON ÉXITO");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR EL USUARIO" + e);
                    }
                }
            }
        }

        //this.dispose();

// Restaura la visibilidad de la ventana de inicio de sesión
        //ventanaLogin.setVisible(true);

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private boolean containsNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }


    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void volverAInicioSesion() {
        this.dispose();
        ventanaLogin.setVisible(true);
    }

    void limpiar() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtemail.setText("");
        txtpassword.setText("");

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> combotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtemail;
    public javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpassword;
    // End of variables declaration//GEN-END:variables
}
