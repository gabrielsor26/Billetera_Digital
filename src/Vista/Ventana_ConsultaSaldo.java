
package Vista;

import Controlador.CtrlMenu_Opciones;
import javax.swing.JLabel;

public class Ventana_ConsultaSaldo extends javax.swing.JFrame {

    
    public Ventana_ConsultaSaldo() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabelMontoSaldoTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelMontoSaldoDisponible = new javax.swing.JLabel();
        jLabelMontoSaldoDestinadoInversion = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jLabelMontoSaldoDestinadoMetas1 = new javax.swing.JLabel();
        jLabelMontoSaldoDestinadoAhorros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(36, 48, 60));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMontoSaldoTotal.setFont(new java.awt.Font("Roboto Mono", 1, 16)); // NOI18N
        jLabelMontoSaldoTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMontoSaldoTotal.setText("jLabelMontoSaldoTotal");
        jPanel5.add(jLabelMontoSaldoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Resumen:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabelSaldo.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabelSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSaldo.setText("Hola!! ");
        jPanel5.add(jLabelSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabelNombre.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(0, 204, 153));
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setText("jLabelNombre");
        jPanel5.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 540, 51));

        jLabelMontoSaldoDisponible.setFont(new java.awt.Font("Roboto Mono", 1, 24)); // NOI18N
        jLabelMontoSaldoDisponible.setForeground(new java.awt.Color(255, 204, 0));
        jLabelMontoSaldoDisponible.setText("jLabelMontoSaldoDisponible");
        jPanel5.add(jLabelMontoSaldoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabelMontoSaldoDestinadoInversion.setFont(new java.awt.Font("Roboto Mono", 1, 16)); // NOI18N
        jLabelMontoSaldoDestinadoInversion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMontoSaldoDestinadoInversion.setText("jLabelMontoSaldoDestinadoInversion");
        jPanel5.add(jLabelMontoSaldoDestinadoInversion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        btnAtras.setBackground(new java.awt.Color(36, 48, 60));
        btnAtras.setFont(new java.awt.Font("Roboto Mono", 1, 36)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 153, 153));
        btnAtras.setText("<-");
        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel5.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 30));

        jLabelMontoSaldoDestinadoMetas1.setFont(new java.awt.Font("Roboto Mono", 1, 16)); // NOI18N
        jLabelMontoSaldoDestinadoMetas1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMontoSaldoDestinadoMetas1.setText("jLabelMontoSaldoDestinadoMetas");
        jPanel5.add(jLabelMontoSaldoDestinadoMetas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabelMontoSaldoDestinadoAhorros.setFont(new java.awt.Font("Roboto Mono", 1, 16)); // NOI18N
        jLabelMontoSaldoDestinadoAhorros.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMontoSaldoDestinadoAhorros.setText("jLabelMontoSaldoDestinadoAhorros");
        jPanel5.add(jLabelMontoSaldoDestinadoAhorros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        
        
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtras;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabelMontoSaldoDestinadoAhorros;
    public javax.swing.JLabel jLabelMontoSaldoDestinadoInversion;
    public javax.swing.JLabel jLabelMontoSaldoDestinadoMetas1;
    public javax.swing.JLabel jLabelMontoSaldoDisponible;
    public javax.swing.JLabel jLabelMontoSaldoTotal;
    public javax.swing.JLabel jLabelNombre;
    public javax.swing.JLabel jLabelSaldo;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
