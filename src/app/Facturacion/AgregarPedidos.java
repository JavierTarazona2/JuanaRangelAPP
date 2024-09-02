package app.Facturacion;

import app.Inicio.Incio;
import app.bd_conexion.balance_cbd;
import app.bd_conexion.producto_cbd;
import app.bd_conexion.venta_cbd;
import app.datos.balance;
import app.datos.cliente;
import app.datos.pdf;
import app.datos.pedido;
import app.datos.producto;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javie
 */
public class AgregarPedidos extends javax.swing.JPanel {
    public ArrayList<Double> valors = new ArrayList<>();
    private Incio inicio;
    private final DefaultTableModel modelo;
    public pedido pedido = new pedido();
    public producto_cbd bdProducto = new producto_cbd ();
    public venta_cbd bdVenta = new venta_cbd();
    private Boolean verificar;
    public String detalle;
       public balance_cbd bcdb = new balance_cbd();
       public balance balance = new balance ();
    public AgregarPedidos(Incio inicio, String codigoV) {
        this.inicio = inicio;
        initComponents();
         modelo = (DefaultTableModel) listaProducto.getModel();
         actualizarProveedores();
        codigofactura.setText(codigoV);
       
    }
    
    public AgregarPedidos(Incio inicio, pedido pedido) {
        this.inicio = inicio;
        initComponentes();
        modelo = (DefaultTableModel) listaProducto.getModel();
        this.pedido = pedido;
        mostrarpedido(pedido);
        if (pedido.getEstado().equals(Boolean.TRUE)) {
        entregado.setSelected(true);
        nentregado.setSelected(false);
        entregado.setEnabled(false); // Deshabilita el checkbox "Entregado"
        nentregado.setEnabled(false); // Evita cambiar el estado si ya se entregó
        } else {
            nentregado.setSelected(true);
            entregado.setEnabled(true); // Permite alternar entre los dos
            nentregado.setEnabled(true);
        }
        verificar = pedido.getEstado();
        inicio.getUser().desactivarboton(BActualizar);
        
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponentes() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProducto = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdetalles = new javax.swing.JTextArea();
        BActualizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfechaentrega = new javax.swing.JTextField();
        valorAgregado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtclientes = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtfecharealizado = new javax.swing.JTextField();
        BEliminar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        entregado = new javax.swing.JCheckBox();
        nentregado = new javax.swing.JCheckBox();

        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Pedido");

        listaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Codigo", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaProducto);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Detalles del pedido");

        txtdetalles.setColumns(20);
        txtdetalles.setRows(5);
        jScrollPane2.setViewportView(txtdetalles);
         BActualizar.setBackground(new java.awt.Color(177, 11, 11));
        BActualizar.setForeground(new java.awt.Color(255, 255, 255));
        BActualizar.setText("Volver");
        BActualizar.setMinimumSize(new java.awt.Dimension(100, 30)); // Tamaño mínimo
        BActualizar.setPreferredSize(new java.awt.Dimension(120, 30)); // Tamaño preferido
        BActualizar.setMaximumSize(new java.awt.Dimension(150, 30)); // Tamaño máximo
        BActualizar.setText("Actualizar");
        BActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActualizarActionPerformed(evt);
            }
        });
        
         jButton3.setBackground(new java.awt.Color(177, 11, 11));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Volver");
        jButton3.setMinimumSize(new java.awt.Dimension(100, 30)); // Tamaño mínimo
        jButton3.setPreferredSize(new java.awt.Dimension(120, 30)); // Tamaño preferido
        jButton3.setMaximumSize(new java.awt.Dimension(150, 30)); // Tamaño máximo
        jButton3.setText("Volver");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel6.setText("Cliente");

        jLabel9.setText("Fecha de entrega");

        txtfechaentrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaentregaActionPerformed(evt);
            }
        });

        valorAgregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorAgregadoActionPerformed(evt);
            }
        });

        jLabel10.setText("Valor agregado");

        

        jLabel11.setText("Fecha Realizado");

       
         BEliminar.setBackground(new java.awt.Color(177, 11, 11));
        BEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BEliminar.setText("Volver");
        BEliminar.setMinimumSize(new java.awt.Dimension(100, 30)); // Tamaño mínimo
        BEliminar.setPreferredSize(new java.awt.Dimension(120, 30)); // Tamaño preferido
        BEliminar.setMaximumSize(new java.awt.Dimension(150, 30)); // Tamaño máximo
        BEliminar.setText("Eliminar");
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });
        txtclientes.setEditable(false);
        txtfecharealizado.setEditable(false);

        jLabel12.setText("Estado del pedido");
      

        entregado.setText("Entregado");
        

        nentregado.setText("No entregado");
              // Preseleccionar el estado "No entregado"
        nentregado.setSelected(true);

        // Listeners para exclusión mutua
        entregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (entregado.isSelected()) {
                    nentregado.setSelected(false);
                } else {
                    nentregado.setSelected(true);
                }
            }
        });

        nentregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (nentregado.isSelected()) {
                    entregado.setSelected(false);
                } else {
                    entregado.setSelected(true);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtfecharealizado))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(valorAgregado, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtclientes))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(38, 38, 38)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(entregado)
                                .addComponent(nentregado))
                            .addGap(8, 8, 8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(194, 194, 194)
                                    .addComponent(BActualizar)
                                    .addGap(29, 29, 29)
                                    .addComponent(jButton3)
                                    .addGap(18, 18, 18)
                                    .addComponent(BEliminar))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(356, 356, 356)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(81, 81, 81))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtclientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(valorAgregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtfecharealizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(entregado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nentregado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BActualizar)
                    .addComponent(jButton3)
                    .addComponent(BEliminar))
                .addGap(0, 37, Short.MAX_VALUE))
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        txtcantidad1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProducto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdetalles = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtfechaentrega = new javax.swing.JTextField();
        txtproducto = new javax.swing.JTextField();
        valorAgregado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        codigofactura = new javax.swing.JTextField();

        jLabel13.setText("Cantidad");

        txtcantidad1.setText("Cantidad");

        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Realizar Pedido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, 53));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Añadir producto existente: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        txtcodigo.setText("codigo");
        txtcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 52, 330, 30));

        jButton1.setBackground(new java.awt.Color(177, 11, 11));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 53, 170, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Id o nombre de producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(listaProducto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 308, 700, 110));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cantidad del producto: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        txtcantidad.setText("Cantidad");
        txtcantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 132, 330, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Si es un encargo especial, por favor detalle el pedido realizado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 604, 26));

        txtdetalles.setColumns(20);
        txtdetalles.setRows(5);
        jScrollPane2.setViewportView(txtdetalles);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 471, 690, -1));

        jButton2.setBackground(new java.awt.Color(177, 11, 11));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Agregar Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 150, 40));

        jButton3.setBackground(new java.awt.Color(177, 11, 11));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Descartar Pedido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 150, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Seleccionar Cliente:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        txtcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtcliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 330, 30));

        jButton4.setBackground(new java.awt.Color(177, 11, 11));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Registrar Cliente Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 180, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Feha de entrega:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 20));

        txtfechaentrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtfechaentrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaentregaActionPerformed(evt);
            }
        });
        jPanel1.add(txtfechaentrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 108, -1));

        txtproducto.setText("producto");
        txtproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 92, 330, 30));

        valorAgregado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        valorAgregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorAgregadoActionPerformed(evt);
            }
        });
        jPanel1.add(valorAgregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 110, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Valor agregado:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Codigo del pedido:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        codigofactura.setEditable(false);
        codigofactura.setBackground(new java.awt.Color(255, 255, 255));
        codigofactura.setText("codigo");
        codigofactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(codigofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 330, 30));

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
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       pedido.setCliente(bdVenta.ListarCliente(txtcliente.getSelectedItem().toString()));
       pedido.setFecha_entrega(LocalDate.parse(txtfechaentrega.getText()));
       pedido.setFecha_realizado(LocalDate.now());
       pedido.setDetalles(txtdetalles.getText() + "  El valor agregado por la realizacion del pedido es de: " + valorAgregado.getText());
       pedido.setCodigo(codigofactura.getText());
       Double valor = 0.0;
       valor += Double.valueOf(valorAgregado.getText());
       for (Double i : valors){
           valor += i;
       }
       pedido.setValor(valor);
       pedido.setCodigo(codigofactura.getText());
       pedido.setTipo_venta(2);
       pdf pdf = new pdf();
       pdf.CrearPdf(pedido);
       bdVenta.registrarVenta(pedido);
        inicio.mostrar(new venta(inicio));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        inicio.mostrar(new venta(inicio));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        inicio.mostrar(new AgregarCliente(inicio));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtfechaentregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaentregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaentregaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String codigo = txtcodigo.getText();
            String nombre = txtproducto.getText();
            Integer cantidad = Integer.valueOf(txtcantidad.getText());
            producto pppp = bdProducto.buscadoListarProductos(nombre, codigo);
            if (pppp.getCantidad() >= cantidad) {
            pedido.setProductos(pppp, cantidad);
            valors.add(pppp.getPrecio_entrada()*cantidad);
            refrescarTablaProductos(pedido.getProductos(),pedido.getCantidades());
            } else if(pppp.getCantidad() == 0){
                JOptionPane.showConfirmDialog(inicio,"No hay existencias de este producto");
            }else  {
                // Si no hay suficiente cantidad, solicita una nueva cantidad al usuario
                String nuevaCantidadStr = JOptionPane.showInputDialog(inicio, "No hay suficiente existencia del producto. Ingrese una nueva cantidad:");

                if (nuevaCantidadStr != null && !nuevaCantidadStr.isEmpty()) {
                    try {
                        int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);
                        if (pppp.getCantidad() >= nuevaCantidad) {
                            // Si la nueva cantidad es válida, procede con la venta
                            pedido.setProductos(pppp, nuevaCantidad);
                            valors.add(pppp.getPrecio_entrada() * nuevaCantidad);
                            refrescarTablaProductos(pedido.getProductos(), pedido.getCantidades());
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
                }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void valorAgregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorAgregadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorAgregadoActionPerformed
    private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) { 
        pedido.setDetalles(txtdetalles.getText());
        pedido.setFecha_entrega(LocalDate.parse(txtfechaentrega.getText()));
        Double vaa = Double.valueOf(valorAgregado.getText());
        if(entregado.isSelected()){
        pedido.setEstado(Boolean.TRUE);
        verificarEstado();
        }
        if(vaa >= calcularNuevoValorTotal()){
            pedido.setValor(vaa);
        }else{
            JOptionPane.showMessageDialog(inicio, "Por favor, introduzca un valor mayor al valor de los productos del pedido ", "Error", JOptionPane.WARNING_MESSAGE);
        }
         bdVenta.actualizarpedido(pedido);
         inicio.mostrar(new venta(inicio));
    }
    
    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Obtener el índice de la fila seleccionada
    int filaSeleccionada = listaProducto.getSelectedRow();

    if (filaSeleccionada != -1) { // Verifica si se ha seleccionado una fila
        // Obtener el código del producto desde la tabla
        String codigoProducto = (String) listaProducto.getValueAt(filaSeleccionada, 1);

        // Buscar el producto en la lista de productos y eliminarlo
        for (int i = 0; i < pedido.getProductos().size(); i++) {
            producto p = pedido.getProductos().get(i);
            if (p.getCodigo().equals(codigoProducto)) {
                // Eliminar el producto y la cantidad asociada
                pedido.getProductos().remove(i);
                pedido.getCantidades().remove(i);
                break;
            }
        }

        // Actualizar la tabla con los productos restantes
        refrescarTablaProductos(pedido.getProductos(), pedido.getCantidades());

        // Actualizar el valor total del pedido después de eliminar productos
        double nuevoValorTotal = calcularNuevoValorTotal();
        valorAgregado.setText(String.valueOf(nuevoValorTotal));

        // Actualizar el objeto pedido en la base de datos (opcional)
        // ActualizarPedido(pe);
    } else {
        JOptionPane.showMessageDialog(inicio, "Por favor, seleccione un producto para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
    }
    }  
    
    // Método para calcular el nuevo valor total del pedido
    private double calcularNuevoValorTotal() {
        double nuevoValorTotal = 0.0;
        for (int i = 0; i < pedido.getProductos().size(); i++) {
            producto p = pedido.getProductos().get(i);
            int cantidad = pedido.getCantidades().get(i);
            nuevoValorTotal += p.getPrecio_entrada()* cantidad; // Suponiendo que producto tiene un método getPrecio()
        }
        return nuevoValorTotal;
    }
    
     
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
            // Limpiar el contenido actual del JComboBox
            txtcliente.removeAllItems();

            // Agregar cada nombre de categoría al JComboBox
            for (cliente c : listaCategorias) {
                txtcliente.addItem(c.getNombre());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(inicio, "Error al actualizar las categorías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrarpedido(pedido p){
        txtclientes.setText(p.getCliente().getNombre());
        txtfechaentrega.setText(p.getFecha_entrega().toString());
        txtfecharealizado.setText(p.getFecha_realizado().toString());
        valorAgregado.setText(p.getValor().toString());
        refrescarTablaProductos(p.getProductos(), p.getCantidades());
        txtdetalles.setText(p.getDetalles());
//        codigofactura.setText(p.getCodigo());
        jLabel1.setText("Pedido " + p.getCodigo() );
        if(p.getEstado().equals(Boolean.TRUE)){
            entregado.setSelected(true);
            
        }else{
            nentregado.setSelected(true);
        }
    }
    private void verificarEstado(){
        if(verificar.equals(false)){
            detalle = "Pedido realizado por " + pedido.getCliente().getNombre();
            balance.setDetalles(detalle);
            balance.setFecha(LocalDate.now());
            balance.setTipo("Ingreso");
            balance.setValor(pedido.getValor());
            bcdb.registrarBalance(balance);
             Integer i = 0;
            
           
            for(producto pp : pedido.getProductos()){
                pp = bdProducto.buscarProductoPorId(bdProducto.obtenerIdProducto(pp.getCodigo()));
                pp.setCantidad(pp.getCantidad() - pedido.getCantidades().get(i));
                bdProducto.ActualizarProducto( pp );
                i++;
            }
        }
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BEliminar;
    private javax.swing.JCheckBox entregado;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JCheckBox nentregado;
    private javax.swing.JTextField txtfecharealizado;
     private javax.swing.JTextField txtclientes;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigofactura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaProducto;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcantidad1;
    private javax.swing.JComboBox<String> txtcliente;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextArea txtdetalles;
    private javax.swing.JTextField txtfechaentrega;
    private javax.swing.JTextField txtproducto;
    private javax.swing.JTextField valorAgregado;
    // End of variables declaration//GEN-END:variables
}
