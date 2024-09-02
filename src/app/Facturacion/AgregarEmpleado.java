package app.Facturacion;

import app.Facturacion.venta;
import app.Inventario.*;
import app.Inicio.Incio;
import app.bd_conexion.*;
import app.datos.empleado;
import app.datos.pdf;
import app.datos.proveedor;
import app.datos.usuario;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class AgregarEmpleado extends javax.swing.JPanel {
    private Incio inicio;
    public empleado_cbd ecbd = new empleado_cbd();
    public empleado empleado;
    private usuario_cbd user = new usuario_cbd();
    
    public AgregarEmpleado(Incio inicio) {
        this.inicio = inicio;
        initComponents();
    }
    
     public AgregarEmpleado(Incio inicio, empleado empleado) {
         this.empleado = empleado;
        this.inicio = inicio;
        initComponentes();
        mostrar(empleado);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        txtdirecion = new javax.swing.JTextField();
        txtidentificacion = new javax.swing.JTextField();
        txtingreso = new javax.swing.JTextField();
        txtnacimiento = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cuentau = new javax.swing.JCheckBox();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 650));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Telefono");

        txttelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Correo");

        txtcorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Empleado");

        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        jButton11.setBackground(new java.awt.Color(182, 11, 11));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Guardar");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
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

        txtdirecion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdirecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdirecionActionPerformed(evt);
            }
        });

        txtidentificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidentificacionActionPerformed(evt);
            }
        });

        txtingreso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresoActionPerformed(evt);
            }
        });

        txtnacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnacimientoActionPerformed(evt);
            }
        });

        txtsueldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsueldoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Direcion");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Identificacion");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Fecha Ingreso");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Fecha Nacimiento");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sueldo");

        cuentau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cuentau.setText("Crear usuario para el empleado");
        cuentau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdirecion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidentificacion)
                            .addComponent(txtingreso)
                            .addComponent(txtnacimiento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cuentau)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(246, 246, 246))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdirecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(19, 19, 19)
                .addComponent(cuentau)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
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
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponentes() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BActualizar = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        txtdirecion = new javax.swing.JTextField();
        txtidentificacion = new javax.swing.JTextField();
        txtingreso = new javax.swing.JTextField();
        txtnacimiento = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        activo = new javax.swing.JCheckBox();
        inactivo = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 650));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Teléfono");

        txttelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Correo");

        txtcorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Empleado");

        txtnombre.setEditable(false);
        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        BActualizar.setBackground(new java.awt.Color(182, 11, 11));
        BActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BActualizar.setForeground(new java.awt.Color(255, 255, 255));
        BActualizar.setText("Actualizar");
        BActualizar.setBorder(null);
        BActualizar.setBorderPainted(false);
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(182, 11, 11));
        jButton22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Volver");
        jButton22.setBorder(null);
        jButton22.setBorderPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        txtdirecion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdirecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdirecionActionPerformed(evt);
            }
        });

        txtidentificacion.setEditable(false);
        txtidentificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidentificacionActionPerformed(evt);
            }
        });

        txtingreso.setEditable(false);
        txtingreso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresoActionPerformed(evt);
            }
        });

        txtnacimiento.setEditable(false);
        txtnacimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnacimientoActionPerformed(evt);
            }
        });

        txtsueldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsueldoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dirección");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Identificación");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Fecha Ingreso");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Fecha Nacimiento");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sueldo");

        activo.setText("Activo");
        activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (activo.isSelected()) {
                    inactivo.setSelected(false);
                } else if (!inactivo.isSelected()) {
                    activo.setSelected(true); // Asegura que al menos uno esté seleccionado
                }
            }
        });

        inactivo.setText("Inactivo");
        inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (inactivo.isSelected()) {
                    activo.setSelected(false);
                } else if (!activo.isSelected()) {
                    inactivo.setSelected(true); // Asegura que al menos uno esté seleccionado
                }
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Estado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdirecion, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(activo)
                                .addGap(18, 18, 18)
                                .addComponent(inactivo)))
                        .addGap(198, 198, 198))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdirecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(activo)
                    .addComponent(inactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
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
    } // </editor-fold>                        
                     
    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed

    }//GEN-LAST:event_txtnombreActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       // Registro del proveedor
try {
    // Validar los datos ingresados
    ValidarDatos();

    // Obtiene y valida los datos del empleado
    String nombre = txtnombre.getText().trim();
    String telefono = txttelefono.getText().trim();
    String correo = txtcorreo.getText().trim();
    String direccion = txtdirecion.getText().trim();
    String identificacionStr = txtidentificacion.getText().trim();
    String fechaIngresoStr = txtingreso.getText().trim();
    String fechaNacimientoStr = txtnacimiento.getText().trim();
    String sueldoStr = txtsueldo.getText().trim();

    // Verificar campos vacíos
    if (nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() || direccion.isEmpty() ||
        identificacionStr.isEmpty() || fechaIngresoStr.isEmpty() || fechaNacimientoStr.isEmpty() || sueldoStr.isEmpty()) {
        JOptionPane.showMessageDialog(inicio, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar identificación
    Integer identificacion;
    try {
        identificacion = Integer.valueOf(identificacionStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(inicio, "La identificación debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar fechas
    LocalDate fechaIngreso;
    LocalDate fechaNacimiento;
    try {
        fechaIngreso = LocalDate.parse(fechaIngresoStr);
        fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this, "Las fechas deben estar en el formato correcto (YYYY-MM-DD).", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar sueldo
    Double sueldo;
    try {
        sueldo = Double.valueOf(sueldoStr);
        if (sueldo <= 0) {
            JOptionPane.showMessageDialog(this, "El sueldo debe ser un número mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El sueldo debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear y configurar el objeto empleado
    empleado e = new empleado();
    e.setNombre(nombre);
    e.setTelefono(telefono);
    e.setCorreo(correo);
    e.setDireccion(direccion);
    e.setIdentificacion(identificacion);
    e.setFecha_ingreso(fechaIngreso);
    e.setFecha_nacimiento(fechaNacimiento);
    e.setSueldo(sueldo);
    e.setEstado(true);
    e.setEdad();

    // Registrar el usuario si se ha seleccionado la opción
    if (cuentau.isSelected()) {
        usuario nuevoUsuario = new usuario();
        nuevoUsuario.setUser(e.getNombre());
        nuevoUsuario.setContraseña("c" + e.getIdentificacion() + e.getEdad());
        nuevoUsuario.setCorreo(e.getCorreo());
        nuevoUsuario.setEmpleado(e);
        nuevoUsuario.setAdministrador(false);

        usuario_cbd bd = new usuario_cbd();
        bd.registrarUsuario(nuevoUsuario);

        pdf pdf = new pdf();
        pdf.EnviarCorreo(nuevoUsuario);
    }

    // Registrar el empleado
    ecbd.registrarEmpleado(e);

    // Mostrar la interfaz de ventas
    inicio.mostrar(new venta(inicio));

} catch (IllegalArgumentException e) {
    JOptionPane.showMessageDialog(inicio, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
} catch (Exception e) {
    JOptionPane.showMessageDialog(inicio, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        inicio.mostrar(new venta(inicio));
    }//GEN-LAST:event_jButton22ActionPerformed

    private void txtdirecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdirecionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdirecionActionPerformed

    private void txtidentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidentificacionActionPerformed

    private void txtingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtingresoActionPerformed

    private void txtnacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnacimientoActionPerformed

    private void txtsueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsueldoActionPerformed

    private void cuentauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuentauActionPerformed

    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt){
        
        empleado.setTelefono(txttelefono.getText());
        
        empleado.setCorreo(txtcorreo.getText());
        
        empleado.setDireccion(txtdirecion.getText());
        
        empleado.setSueldo(Double.valueOf(txtsueldo.getText()));
        
        if(Boolean.TRUE.equals(activo.isSelected())){
            empleado.setEstado(true);
        }else if (Boolean.TRUE.equals(inactivo.isSelected())){
            empleado.setEstado(false);
        }
        ecbd.actualizarEmpleado(empleado);
        empleado.setEdad();
        inicio.mostrar(new inventario(inicio));
    }
     //Validar que no existan campos vacios en el registro
        private void ValidarDatos(){
            if(txtnombre.getText().isEmpty() || txttelefono.getText().isEmpty() || txtcorreo.getText().isEmpty()){
                throw new IllegalArgumentException("Todos los campos son obligatorios. Por favor, complete la información.");
            }
        }
    public void  mostrar(empleado ee){
        txtnombre.setText(ee.getNombre());
        txttelefono.setText(ee.getTelefono());
        txtcorreo.setText(ee.getCorreo());
        txtdirecion.setText(ee.getDireccion());
        txtidentificacion.setText(String.valueOf(ee.getIdentificacion()));
        txtingreso.setText(String.valueOf(ee.getFecha_ingreso()));
        txtnacimiento.setText(String.valueOf(ee.getFecha_nacimiento()));
        txtsueldo.setText(ee.getSueldo().toString());
        if(ee.getEstado().equals(Boolean.TRUE)){
            activo.setSelected(Boolean.TRUE);
        }else{
            inactivo.setSelected(true);
        }
    }
    
    private javax.swing.JButton BActualizar;
    private javax.swing.JCheckBox activo;
    private javax.swing.JCheckBox inactivo;
    private javax.swing.JLabel jLabel12;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cuentau;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton22;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdirecion;
    private javax.swing.JTextField txtidentificacion;
    private javax.swing.JTextField txtingreso;
    private javax.swing.JTextField txtnacimiento;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsueldo;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
