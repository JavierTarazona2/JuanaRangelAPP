/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.Inicio;

import app.Facturacion.venta;
import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class configuracion extends javax.swing.JPanel {
    private final Incio inicio;

    /**
     * Creates new form configuracion
     * @param inicio
     */
    public configuracion(Incio inicio) {
        this.inicio = inicio;
        initComponents();
        mostrarUsuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtprecio1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        txtncontraseña1 = new javax.swing.JPasswordField();
        txtncontraseña2 = new javax.swing.JPasswordField();
        txtacontraseña = new javax.swing.JPasswordField();

        setMaximumSize(new java.awt.Dimension(800, 650));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Correo");

        txtprecio1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtprecio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtprecio1.setText("Antigua Contraseña");

        jButton11.setBackground(new java.awt.Color(182, 11, 11));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Actualizar");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");

        txtuser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informacion Usuario");

        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtprecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtprecio.setText("Confirme Contraseña");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nueva Contraseña");

        txtcorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(182, 11, 11));
        jButton22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Descartar");
        jButton22.setBorder(null);
        jButton22.setBorderPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        txtncontraseña1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtncontraseña1ActionPerformed(evt);
            }
        });

        txtncontraseña2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtncontraseña2ActionPerformed(evt);
            }
        });

        txtacontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtacontraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtuser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(txtncontraseña1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtncontraseña2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtacontraseña))
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtncontraseña1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprecio)
                    .addComponent(txtncontraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprecio1)
                    .addComponent(txtacontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(315, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    // Obtiene las contraseñas ingresadas como arrays de caracteres
    char[] contraseñaIngresada = txtacontraseña.getPassword();
    char[] nuevaContraseña1 = txtncontraseña1.getPassword();
    char[] nuevaContraseña2 = txtncontraseña2.getPassword();

    // Convierte los arrays de caracteres a Strings para compararlos
    String contraseñaIngresadaStr = new String(contraseñaIngresada);
    String nuevaContraseña1Str = new String(nuevaContraseña1);
    String nuevaContraseña2Str = new String(nuevaContraseña2);
    

    // Verifica si la contraseña ingresada es correcta
    if (!contraseñaIngresadaStr.equals(inicio.getUser().getContraseña())) {
        // Manejo de error si la contraseña ingresada es incorrecta
        JOptionPane.showMessageDialog(inicio, "La contraseña ingresada es incorrecta.");
        return; // Salir del método si la contraseña es incorrecta
    }

    // Verifica si las nuevas contraseñas no están vacías
    if (nuevaContraseña1Str.isEmpty() || nuevaContraseña2Str.isEmpty()) {
        JOptionPane.showMessageDialog(inicio, "Las nuevas contraseñas no pueden estar vacías.");
        return; // Salir del método si alguna de las nuevas contraseñas está vacía
    }

    // Verifica si las nuevas contraseñas coinciden
    if (!nuevaContraseña1Str.equals(nuevaContraseña2Str)) {
        // Manejo de error si las nuevas contraseñas no coinciden
        JOptionPane.showMessageDialog(inicio, "Las nuevas contraseñas no coinciden.");
        return; // Salir del método si las nuevas contraseñas no coinciden
    }
// Verifica si los campos están vacíos
    if (txtcorreo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(inicio, "El nombre de usuario no puede estar vacío.");
        return; // Salir del método si el nombre de usuario está vacío
    }

    if ( contraseñaIngresadaStr .isEmpty() ||nuevaContraseña1Str.isEmpty() || nuevaContraseña2Str.isEmpty()) {
        JOptionPane.showMessageDialog(inicio, "La contraseña no puede estar vacía.");
        return; // Salir del método si la contraseña está vacía
    }
    // Actualiza el correo electrónico del usuario
    inicio.getUser().setCorreo(txtcorreo.getText());

    // Actualiza la contraseña del usuario
    inicio.getUser().setContraseña(nuevaContraseña1Str);

    // Continúa con el flujo normal si todo es correcto
    inicio.mostrar(new venta(inicio));
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed

    }//GEN-LAST:event_txtuserActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        inicio.mostrar(new venta(inicio));
    }//GEN-LAST:event_jButton22ActionPerformed

    private void txtncontraseña1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtncontraseña1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtncontraseña1ActionPerformed

    private void txtncontraseña2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtncontraseña2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtncontraseña2ActionPerformed

    private void txtacontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtacontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtacontraseñaActionPerformed
    private void mostrarUsuario(){
        txtuser.setText(inicio.getUser().getUser());
        txtcorreo.setText(inicio.getUser().getCorreo());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton22;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtacontraseña;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JPasswordField txtncontraseña1;
    private javax.swing.JPasswordField txtncontraseña2;
    private javax.swing.JLabel txtprecio;
    private javax.swing.JLabel txtprecio1;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
