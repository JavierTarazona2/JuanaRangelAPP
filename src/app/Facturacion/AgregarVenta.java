package app.Facturacion;

import app.Inicio.Incio;
import app.bd_conexion.balance_cbd;
import app.bd_conexion.producto_cbd;
import app.bd_conexion.venta_cbd;
import app.datos.Ventas;
import app.datos.balance;
import app.datos.cliente;
import app.datos.pdf;
import app.datos.pedido;
import app.datos.producto;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class AgregarVenta extends javax.swing.JPanel {
       public ArrayList<Double> valors = new ArrayList<>();
       private Incio inicio;
       private final DefaultTableModel modelo;
       public Ventas venta = new Ventas();
       public producto_cbd bdProducto = new producto_cbd ();
       public venta_cbd bdVenta = new venta_cbd();
       public String detalle;
       public balance_cbd bcdb = new balance_cbd();
       public balance balance = new balance ();
       public AgregarVenta(Incio inicio,String codigoV) {
           this.inicio = inicio;
           initComponents();
           modelo = (DefaultTableModel) listaProducto.getModel();
           actualizarProveedores();
           txtcodigof.setText(codigoV);
       }
       public AgregarVenta(Incio inicio,Ventas venta) {
           this.inicio = inicio;
           this.venta = venta;
           initComponentes();
           modelo = (DefaultTableModel) listaProducto.getModel();
           mostrarventa(venta);
       }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponentes() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtclientes = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfecha1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfechaentrega = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdetalles = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProducto = new javax.swing.JTable();
        txttipo = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Venta");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cliente");

        txtclientes.setEditable(false);
        txtclientes.setText("txtcliente");
        jButton3.setBackground(new java.awt.Color(177, 11, 11));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Volver");
        jButton3.setMinimumSize(new java.awt.Dimension(100, 40)); // Tamaño mínimo
        jButton3.setPreferredSize(new java.awt.Dimension(120, 50)); // Tamaño preferido
        jButton3.setMaximumSize(new java.awt.Dimension(150, 60)); // Tamaño máximo
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fecha");

        txtfecha.setEditable(false);
        txtfecha.setText("txtcliente");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Valor");

        txtfecha1.setEditable(false);
        txtfecha1.setText("txtcliente");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tipo");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fecha entrega");

        txtfechaentrega.setEditable(false);
        txtfechaentrega.setText("txtcliente");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Detalles");

        txtdetalles.setEditable(false);
        txtdetalles.setColumns(20);
        txtdetalles.setRows(5);
        jScrollPane1.setViewportView(txtdetalles);
        listaProducto.setAutoCreateRowSorter(true);
        listaProducto.setBackground(new java.awt.Color(245, 22, 22));
        listaProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaProducto.setForeground(new java.awt.Color(255, 255, 255));
        listaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Codigo", "Nombre", "Cantiidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listaProducto);

        txttipo.setEditable(false);
        txttipo.setText("txtcliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(341, 341, 341))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfechaentrega)
                            .addComponent(txtfecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(txttipo, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))))
                .addGap(171, 171, 171))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtclientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(55, 55, 55))
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
    }// </editor-fold>        
       
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JComboBox<>();
        txtproducto = new javax.swing.JComboBox<>();
        txtcodigof = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtrecibido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProducto = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Venta");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cliente");

        jButton3.setBackground(new java.awt.Color(177, 11, 11));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Descartar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Producto por nombre");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Producto por codigo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Codigo factura");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Valor de la factura");

        txtvalor.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cantidad recibida");

        txtcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtcodigof.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Cantidad");

        jButton1.setBackground(new java.awt.Color(177, 11, 11));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar  Cantidad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listaProducto.setAutoCreateRowSorter(true);
        listaProducto.setBackground(new java.awt.Color(245, 22, 22));
        listaProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaProducto.setForeground(new java.awt.Color(255, 255, 255));
        listaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Codigo", "Producto", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaProducto);

        jButton2.setBackground(new java.awt.Color(177, 11, 11));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Crear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtproducto, 0, 326, Short.MAX_VALUE)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtcantidad))
                            .addComponent(txtcodigof, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtcodigof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtrecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        inicio.mostrar(new venta(inicio));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                    // Obtiene los valores de los campos de texto
         String codigo = txtcodigo.getText();
         String nombre = txtproducto.getSelectedItem().toString();
         String cantidadStr = txtcantidad.getText();

         // Verifica si los campos están vacíos
         if (codigo.isEmpty() || nombre.isEmpty() || cantidadStr.isEmpty()) {
             JOptionPane.showMessageDialog(inicio, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
             return; // Sale del método si alguno de los campos está vacío
         }

         // Intenta convertir la cantidad a un entero
         Integer cantidad;
         try {
             cantidad = Integer.valueOf(cantidadStr);
             if (cantidad <= 0) {
                 JOptionPane.showMessageDialog(inicio, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                 return; // Sale del método si la cantidad no es válida
             }
         } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(inicio, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
             return; // Sale del método si la cantidad no es un número válido
         }

         // Busca el producto en la base de datos
         producto pppp = bdProducto.buscadoListarProductos(nombre, codigo);

         if (pppp == null) {
             JOptionPane.showMessageDialog(inicio, "El producto no se encuentra en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
             return; // Sale del método si el producto no se encuentra
         }

         // Verifica la cantidad disponible
         if (pppp.getCantidad() >= cantidad) {
             venta.setProductos(pppp, cantidad);
             valors.add(pppp.getPrecio_entrada() * cantidad);
             refrescarTablaProductos(venta.getProductos(), venta.getCantidades());
             txtvalor.setText(String.valueOf(calcularNuevoValorTotal()));
         } else if (pppp.getCantidad() == 0) {
             JOptionPane.showMessageDialog(inicio, "No hay existencias de este producto.", "Error", JOptionPane.ERROR_MESSAGE);
         } else {
             // Si no hay suficiente cantidad, solicita una nueva cantidad al usuario
             String nuevaCantidadStr = JOptionPane.showInputDialog(inicio, "No hay suficiente existencia del producto. Ingrese una nueva cantidad:");

             if (nuevaCantidadStr != null && !nuevaCantidadStr.isEmpty()) {
                 try {
                     int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
                     if (nuevaCantidad > 0 && pppp.getCantidad() >= nuevaCantidad) {
                         // Si la nueva cantidad es válida, procede con la venta
                         venta.setProductos(pppp, nuevaCantidad);
                         valors.add(pppp.getPrecio_entrada() * nuevaCantidad);
                         refrescarTablaProductos(venta.getProductos(), venta.getCantidades());
                         txtvalor.setText(String.valueOf(calcularNuevoValorTotal()));
                     } else {
                         // Si la nueva cantidad sigue siendo mayor que la existencia, muestra un mensaje de error
                         JOptionPane.showMessageDialog(inicio,
                                 "La cantidad ingresada sigue siendo mayor que la existencia disponible.",
                                 "Error",
                                 JOptionPane.ERROR_MESSAGE);
                     }
                 } catch (NumberFormatException e) {
                     // Si la entrada no es un número válido, muestra un mensaje de error
                     JOptionPane.showMessageDialog(inicio,
                             "Por favor ingrese un número válido.",
                             "Error",
                             JOptionPane.ERROR_MESSAGE);
                 }
             } else {
                 // Si el usuario no ingresa una nueva cantidad, muestra un mensaje de advertencia
                 JOptionPane.showMessageDialog(inicio, "No se ha ingresado una nueva cantidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
             }
         }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            // Obtiene los valores de los campos
       String clienteNombre = txtcliente.getSelectedItem().toString();
       String codigoFactura = txtcodigof.getText();
       String valorStr = txtvalor.getText();

       // Verifica si los campos están vacíos
       if (clienteNombre.isEmpty() || codigoFactura.isEmpty() || valorStr.isEmpty()) {
           JOptionPane.showMessageDialog(inicio, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
           return; // Sale del método si alguno de los campos está vacío
       }

       // Intenta convertir el valor a un Double
       Double valor;
       try {
           valor = Double.valueOf(valorStr);
           if (valor <= 0) {
               JOptionPane.showMessageDialog(inicio, "El valor debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
               return; // Sale del método si el valor no es válido
           }
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(inicio, "El valor debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
           return; // Sale del método si el valor no es un número válido
       }

       // Verifica si hay productos en la venta
       if (venta.getProductos().isEmpty() || venta.getCantidades().isEmpty()) {
           JOptionPane.showMessageDialog(inicio, "Debe agregar al menos un producto a la venta.", "Error", JOptionPane.ERROR_MESSAGE);
           return; // Sale del método si no hay productos en la venta
       }

       // Actualiza la información de los productos y realiza la venta
       Integer i = 0;
       for (producto pp : venta.getProductos()) {
           // Obtiene el producto actualizado desde la base de datos
           pp = bdProducto.buscarProductoPorId(bdProducto.obtenerIdProducto(pp.getCodigo()));

           // Verifica si la cantidad disponible es suficiente
           if (pp.getCantidad() < venta.getCantidades().get(i)) {
               JOptionPane.showMessageDialog(inicio, "No hay suficiente existencia del producto: " + pp.getNombre(), "Error", JOptionPane.ERROR_MESSAGE);
               return; // Sale del método si no hay suficiente existencia
           }

           // Actualiza la cantidad del producto
           pp.setCantidad(pp.getCantidad() - venta.getCantidades().get(i));
           bdProducto.ActualizarProducto(pp);
           i++;
       }

       // Registra la venta en la base de datos
       venta.setCliente(bdVenta.ListarCliente(clienteNombre));
       venta.setCodigo(codigoFactura);
       venta.setFecha_realizado(LocalDate.now());
       venta.setTipo_venta(1);
       venta.setValor(valor);

       bdVenta.registrarVenta(venta);
       detalle= "Venta realizado para " + venta.getCliente().getNombre();
            
       balance.setDetalles(detalle);
       balance.setFecha(LocalDate.now());
       balance.setTipo("Ingreso");
       balance.setValor(venta.getValor());
       bcdb.registrarBalance(balance);
      
       

       // Muestra la interfaz de ventas
       inicio.mostrar(new venta(inicio));
        pdf pdf = new pdf();
       pdf.CrearPdf(venta);

    }//GEN-LAST:event_jButton2ActionPerformed
     public void refrescarTablaProductos(ArrayList<producto> productoaa,ArrayList<Integer> cantidades){
        modelo.setRowCount(0); // Limpia la tabla antes de actualizarla
        Integer id = 0;
        Integer i = 0;
        if(productoaa.size() == cantidades.size()){
        for (producto plt : productoaa) {
            Object[] p = {
                    id += 1,
                    plt.getCodigo(),
                    plt.getNombre(), 
                    cantidades.get(i)};
            i+=1;
            modelo.addRow(p);
        }
        }else{
            JOptionPane.showInputDialog(inicio,"No es la misma cantidad de productos a la de cantidades");
        }
    }
    public void actualizarProveedores() {
        try {
            ArrayList<cliente> listaCategorias = bdVenta.ListarCliente();
            ArrayList<producto> listaProductos = bdProducto.ListarProductos();
            // Limpiar el contenido actual del JComboBox
            txtcliente.removeAllItems();
            txtproducto.removeAllItems();
            txtproducto.addItem("NONE");
            // Agregar cada nombre de categoría al JComboBox
            for (cliente c : listaCategorias) {
                txtcliente.addItem(c.getNombre());
            }
            for(producto p : listaProductos){
                txtproducto.addItem(p.getNombre());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(inicio, "Error al actualizar las categorías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Método para calcular el nuevo valor total del pedido
    public double calcularNuevoValorTotal() {
        double nuevoValorTotal = 0.0;
        for (int i = 0; i < venta.getProductos().size(); i++) {
            producto p = venta.getProductos().get(i);
            int cantidad = venta.getCantidades().get(i);
            nuevoValorTotal += p.getPrecio_entrada()* cantidad; 
        }
        return nuevoValorTotal;
    }
    public void mostrarventa(Object p){
        if(p instanceof pedido){
             pedido pedido = (pedido) p;
            txtclientes.setText(pedido.getCliente().getNombre());
            txtfechaentrega.setText(pedido.getFecha_entrega().toString());
            txtfecha.setText(pedido.getFecha_realizado().toString());
            txtfecha1.setText(pedido.getValor().toString());
            refrescarTablaProductos(pedido.getProductos(), pedido.getCantidades());
            txtdetalles.setText(pedido.getDetalles());
            jLabel1.setText("Pedido " + pedido.getCodigo() );
            txttipo.setText("pedido");
        }else if(p instanceof Ventas){
            
            Ventas venta = (Ventas) p; 
            txtclientes.setText(venta.getCliente().getNombre());
            txtfecha.setText(venta.getFecha_realizado().toString());
            txtfecha1.setText(venta.getValor().toString());
            refrescarTablaProductos(venta.getProductos(), venta.getCantidades());
            jLabel1.setText("Venta " + venta.getCodigo());
            txtfechaentrega.setText("None");
            txttipo.setText("venta");
        }
        
    }     
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtdetalles;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtfecha1;
    private javax.swing.JTextField txtfechaentrega;
    private javax.swing.JTextField txttipo;
    private javax.swing.JTextField txtclientes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaProducto;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JComboBox<String> txtcliente;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcodigof;
    private javax.swing.JComboBox<String> txtproducto;
    private javax.swing.JTextField txtrecibido;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
