
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

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMontoSaldoTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMontoSaldoTotal.setText("jLabelMontoSaldoTotal");
        jPanel5.add(jLabelMontoSaldoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Resumen:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 148, -1, -1));

        jLabelSaldo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelSaldo.setText("Hola!! ");
        jPanel5.add(jLabelSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelNombre.setText("jLabelNombre");
        jPanel5.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 240, 51));

        jLabelMontoSaldoDisponible.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelMontoSaldoDisponible.setText("jLabelMontoSaldoDisponible");
        jPanel5.add(jLabelMontoSaldoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 198, -1, -1));

        jLabelMontoSaldoDestinadoInversion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMontoSaldoDestinadoInversion.setText("jLabelMontoSaldoDestinadoInversion");
        jPanel5.add(jLabelMontoSaldoDestinadoInversion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel5.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 387, 162, -1));

        jLabelMontoSaldoDestinadoMetas1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMontoSaldoDestinadoMetas1.setText("jLabelMontoSaldoDestinadoMetas");
        jPanel5.add(jLabelMontoSaldoDestinadoMetas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabelMontoSaldoDestinadoAhorros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMontoSaldoDestinadoAhorros.setText("jLabelMontoSaldoDestinadoAhorros");
        jPanel5.add(jLabelMontoSaldoDestinadoAhorros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 490));

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
