/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.Inicio;

import app.bd_conexion.usuario_cbd;
import app.datos.usuario;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author javie
 */
public class bienvenidas extends javax.swing.JPanel {
    private final bienvenida bienv;
    private usuario_cbd bd_usuario = new usuario_cbd();
    /**
     * Creates new form bienvenidas
     * @param bienv
     */
    public bienvenidas(bienvenida bienv) {
        this.bienv = bienv;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        titulo1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        titulo4 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        titulo2 = new javax.swing.JLabel();
        titulo3 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(177, 11, 11));
        jButton2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Ingresar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 220, 50));

        titulo1.setBackground(new java.awt.Color(0, 0, 0));
        titulo1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("Juana Rangel");
        add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 240, 50));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 400, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 400, 10));

        titulo4.setBackground(new java.awt.Color(0, 0, 0));
        titulo4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        titulo4.setForeground(new java.awt.Color(255, 255, 255));
        titulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo4.setText("Panaderia");
        add(titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, 50));

        titulo.setBackground(new java.awt.Color(0, 0, 0));
        titulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titulo.setText("Contraseña");
        titulo.setName(""); // NOI18N
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 260, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_bienvenida.jpg"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 500));

        titulo2.setBackground(new java.awt.Color(0, 0, 0));
        titulo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titulo2.setText("Nombre de Usuario");
        add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 260, 50));

        titulo3.setBackground(new java.awt.Color(0, 0, 0));
        titulo3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo3.setText("Iniciar Sesión");
        add(titulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 260, 50));

        txtuser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtuser.setBorder(null);
        add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 410, 40));

        txtcontraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcontraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcontraseña.setText("jPasswordField1");
        txtcontraseña.setAutoscrolls(false);
        txtcontraseña.setBorder(null);
        add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 302, 410, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// Obtiene el texto del campo de nombre de usuario
    String correo = txtuser.getText();
    
    // Obtiene la contraseña ingresada como un array de caracteres
    char[] contraseñaArray = txtcontraseña.getPassword();
    String contraseña = new String(contraseñaArray);

    // Verifica si los campos están vacíos
    if (correo.isEmpty()) {
        JOptionPane.showMessageDialog(bienv, "El nombre de usuario no puede estar vacío.");
        return; // Salir del método si el nombre de usuario está vacío
    }

    if (contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(bienv, "La contraseña no puede estar vacía.");
        return; // Salir del método si la contraseña está vacía
    }

    // Intentar autenticar al usuario
    usuario user = bd_usuario.login(correo, contraseña);
    if (user != null) {
        // Si las credenciales son correctas, proceder
        Incio inicio = new Incio(user);
        bienv.dispose();
    } else {
        // Si las credenciales son incorrectas, mostrar mensaje de error
        JOptionPane.showMessageDialog(bienv, "Credenciales incorrectas");
    }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo4;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
