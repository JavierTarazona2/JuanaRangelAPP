/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.Inventario;

import app.Facturacion.AgregarCliente;
import app.Inicio.Incio;
import app.bd_conexion.*;
import app.datos.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * Clase para el panel de inventario.
 * Permite gestionar productos, proveedores, pedidos y reportes.
 */
public final class inventario extends javax.swing.JPanel {
    private Incio inicio; // Referencia al objeto Incio
    private final DefaultTableModel modelo;
    private final DefaultTableModel modelo1;
    private final DefaultTableModel modelo2;
    private final DefaultTableModel modelo3;
    private final producto_cbd pcbd; // Objeto para manejar productos en la base de datos
    private final proveedor_cbd prcbd; // Objeto para manejar proveedores en la base de datos

    /**
     * Constructor del panel de inventario.
     * Inicializa componentes y refresca tablas con datos actuales.
     * 
     * @param inicio Referencia al objeto Incio
     */
    public inventario(Incio inicio) {
        this.inicio = inicio;
        initComponents();

        // Inicialización de modelos de tablas
        modelo = (DefaultTableModel) listaProductos.getModel();
        modelo1 = (DefaultTableModel) listaProveedor.getModel();
        modelo2 = (DefaultTableModel) txtLista_pedidos.getModel();
        modelo3 = (DefaultTableModel) listaReportes.getModel();

        // Inicialización de objetos de base de datos
        pcbd = new producto_cbd();
        prcbd = new proveedor_cbd();

        // Refrescar tablas con datos actuales de la base de datos
        refrescarTablaProductos(pcbd.ListarProductos());
        refrescarTablaProveedores(prcbd.ListadoProveedores());
        refrescarTablaPedidos(prcbd.ListadoPedidos());
        refrescarTablaReportes(prcbd.ListarReportes());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu_inventario = new javax.swing.JTabbedPane();
        producto = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JTable();
        proveedor = new javax.swing.JPanel();
        txtproveedor = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProveedor = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        pedido = new javax.swing.JPanel();
        txtpedidos = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtLista_pedidos = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        Reportes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaReportes = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        menu_inventario.setBackground(new java.awt.Color(255, 255, 255));
        menu_inventario.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        menu_inventario.setMinimumSize(new java.awt.Dimension(800, 650));
        menu_inventario.setPreferredSize(new java.awt.Dimension(800, 650));

        producto.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscar.setText("Buscar por id o nombre");
        txtBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtBuscar.setMinimumSize(new java.awt.Dimension(400, 30));
        txtBuscar.setPreferredSize(new java.awt.Dimension(400, 30));

        jButton1.setBackground(new java.awt.Color(182, 11, 11));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(182, 11, 11));
        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Agregar Producto");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        listaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Medida", "Categoria", "Valor de Compra", "Valor de Venta", "Fecha Vencimiento", "Fecha Ingreso", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaProductos);

        javax.swing.GroupLayout productoLayout = new javax.swing.GroupLayout(producto);
        producto.setLayout(productoLayout);
        productoLayout.setHorizontalGroup(
            productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(productoLayout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        productoLayout.setVerticalGroup(
            productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(productoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        menu_inventario.addTab("Productos", producto);

        proveedor.setBackground(new java.awt.Color(255, 255, 255));

        txtproveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtproveedor.setText("Buscar por  nombre el proveedor");
        txtproveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtproveedor.setMinimumSize(new java.awt.Dimension(400, 30));
        txtproveedor.setPreferredSize(new java.awt.Dimension(400, 30));
        txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedorActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(182, 11, 11));
        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Buscar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(182, 11, 11));
        jButton4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Agregar Provedor");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        listaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Telefono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listaProveedor);

        jButton11.setBackground(new java.awt.Color(182, 11, 11));
        jButton11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Info");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton11.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton11.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout proveedorLayout = new javax.swing.GroupLayout(proveedor);
        proveedor.setLayout(proveedorLayout);
        proveedorLayout.setHorizontalGroup(
            proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proveedorLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proveedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(proveedorLayout.createSequentialGroup()
                        .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        proveedorLayout.setVerticalGroup(
            proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proveedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        menu_inventario.addTab("Proveedores", proveedor);

        pedido.setBackground(new java.awt.Color(255, 255, 255));

        txtpedidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtpedidos.setText("Buscar por  codigo del pedido");
        txtpedidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtpedidos.setMinimumSize(new java.awt.Dimension(400, 30));
        txtpedidos.setPreferredSize(new java.awt.Dimension(400, 30));
        txtpedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpedidosActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(182, 11, 11));
        jButton5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Buscar");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton5.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(182, 11, 11));
        jButton6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Agregar Pedido");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtLista_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Proveedor", "Productos", "Valor", "Fecha Realizacion", "Fecha Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(txtLista_pedidos);

        jButton12.setBackground(new java.awt.Color(182, 11, 11));
        jButton12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Info");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton12.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton12.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pedidoLayout = new javax.swing.GroupLayout(pedido);
        pedido.setLayout(pedidoLayout);
        pedidoLayout.setHorizontalGroup(
            pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addComponent(txtpedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        pedidoLayout.setVerticalGroup(
            pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        menu_inventario.addTab("pedidos", pedido);

        Reportes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Reportes de Productos Dañados");

        jButton7.setBackground(new java.awt.Color(182, 11, 11));
        jButton7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Agregar Reporte");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton7.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton7.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        listaReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "codigo", "cantidad productos", "Detalles", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(listaReportes);

        jButton8.setBackground(new java.awt.Color(177, 11, 11));
        jButton8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Informacion");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReportesLayout = new javax.swing.GroupLayout(Reportes);
        Reportes.setLayout(ReportesLayout);
        ReportesLayout.setHorizontalGroup(
            ReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesLayout.createSequentialGroup()
                .addGroup(ReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReportesLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel1))
                    .addGroup(ReportesLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReportesLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        ReportesLayout.setVerticalGroup(
            ReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(ReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        menu_inventario.addTab("Reportes", Reportes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menu_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menu_inventario.getAccessibleContext().setAccessibleName("Productos\n");
    }// </editor-fold>//GEN-END:initComponents

    private void txtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorActionPerformed

    private void txtpedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpedidosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
inicio.mostrar(new AgregarProducto(inicio));    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        inicio.mostrar(new AgregarProveedor(inicio));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        inicio.mostrar(new Pedido_proveedor(inicio));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         inicio.mostrar(new Reportes_daños(inicio));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Buscar y refrescar la tabla de productos según el nombre ingresado
    String nombre_producto = txtBuscar.getText();
    refrescarTablaProductos(pcbd.buscadoListarProductos(nombre_producto));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     // Buscar y refrescar la tabla de proveedores según el nombre ingresado
    String nombre_proveedor = txtproveedor.getText();
    refrescarTablaProveedores(prcbd.ListadoProveedores(nombre_proveedor));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     // Buscar y refrescar la tabla de pedidos según el texto ingresado
    String buscarp = txtpedidos.getText();
    refrescarTablaPedidos(prcbd.ListadoPedidos(buscarp));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
     // Obtener y mostrar los detalles del proveedor seleccionado en la tabla
    DefaultTableModel modelo1 = (DefaultTableModel) listaProveedor.getModel();
    int filaSeleccionada = listaProveedor.getSelectedRow();
    
    if (filaSeleccionada != -1) {
        String nombre = (String) modelo1.getValueAt(filaSeleccionada, 0);
        proveedor clienteSeleccionado = prcbd.ListadoProveedor(nombre);
        
        if (clienteSeleccionado != null) {
            AgregarProveedor AP = new AgregarProveedor(inicio, clienteSeleccionado);
            inicio.mostrar(AP);
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila en la tabla.");
    }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
          // Obtener y mostrar los detalles del proveedor seleccionado en la tabla
    DefaultTableModel modelo2 = (DefaultTableModel) txtLista_pedidos.getModel();
    int filaSeleccionada = txtLista_pedidos.getSelectedRow();
    
    if (filaSeleccionada != -1) {
        String nombre = (String) modelo2.getValueAt(filaSeleccionada, 0);
        proveedor_pedido clienteSeleccionado = prcbd.ListadoPedido(nombre);
        
        if (clienteSeleccionado != null) {
            Pedido_proveedor AP = new Pedido_proveedor(inicio, clienteSeleccionado);
            inicio.mostrar(AP);
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila en la tabla.");
    }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       // Obtener y mostrar los detalles del proveedor seleccionado en la tabla
    DefaultTableModel modelo3 = (DefaultTableModel) listaReportes.getModel();
    int filaSeleccionada = listaReportes.getSelectedRow();
    
    if (filaSeleccionada != -1) {
        Integer codigo = (Integer) modelo3.getValueAt(filaSeleccionada, 0);
        reportes clienteSeleccionado = prcbd.ListaReporte(codigo);
        
        if (clienteSeleccionado != null) {
            Reportes_daños AP = new Reportes_daños(inicio, clienteSeleccionado);
            inicio.mostrar(AP);
        } else {
            JOptionPane.showMessageDialog(inicio, "Cliente no encontrado.");
        }
    } else {
        JOptionPane.showMessageDialog(inicio, "Seleccione una fila en la tabla.");
    }
    }//GEN-LAST:event_jButton8ActionPerformed
     /**
     * Refresca la tabla de productos con una lista de productos.
     * @param productos Lista de productos a mostrar en la tabla.
     */
    public void refrescarTablaProductos(ArrayList<producto> productos) {
        modelo.setRowCount(0); // Limpia la tabla antes de actualizarla
        for (producto p : productos) {
            Object[] fila = {
                p.getCodigo(),
                p.getNombre(),
                p.getMedida(),
                p.getCategoria(),
                p.getPrecio_entrada(),
                p.getPrecio_salida(),
                p.getFeche_vencimiento(),
                p.getFecha_ingreso(),
                p.getCantidad()
            };
            modelo.addRow(fila);
        }
    }

    /**
     * Refresca la tabla de proveedores con una lista de proveedores.
     * @param proveedores Lista de proveedores a mostrar en la tabla.
     */
    public void refrescarTablaProveedores(ArrayList<proveedor> proveedores) {
        modelo1.setRowCount(0); // Limpia la tabla antes de actualizarla
        for (proveedor p : proveedores) {
            Object[] fila = {
                p.getNombre(),
                p.getTelefono(),
                p.getCorreo()
            };
            modelo1.addRow(fila);
        }
    }

    /**
     * Refresca la tabla de pedidos con una lista de pedidos.
     * @param pedidos Lista de pedidos a mostrar en la tabla.
     */
    public void refrescarTablaPedidos(ArrayList<proveedor_pedido> pedidos) {
        modelo2.setRowCount(0); // Limpia la tabla antes de actualizarla
        
        for (proveedor_pedido p : pedidos) {
            Object[] fila = {
                p.getCodigo(),
                p.getproveedor().getNombre(),
                p.getProductos().size(),
                p.getValor_total(),
                p.getFecha_realizacion(),
                p.getFecha_entrega(),
                estadoss(p)
            };
            modelo2.addRow(fila);
        }
    }
    private String estadoss (proveedor_pedido pp){
        
        String estafo = null;
        
        if(pp.getEstado().equals(true)){
            estafo = "Entregado";
        }else{
            estafo = "No entregado";
        }
        return estafo;
    }
    /**
     * Refresca la tabla de reportes con una lista de reportes.
     * @param reportes Lista de reportes a mostrar en la tabla.
     */
    public void refrescarTablaReportes(ArrayList<reportes> reportes) {
        modelo3.setRowCount(0); // Limpia la tabla antes de actualizarla
        for (reportes r : reportes) {
            Object[] fila = {
                r.getCodigo(),
                r.getProductos().size(),
                r.getDetalles(),
                r.getFecha().toString()
            };
            modelo3.addRow(fila);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Reportes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable listaProductos;
    private javax.swing.JTable listaProveedor;
    private javax.swing.JTable listaReportes;
    private javax.swing.JTabbedPane menu_inventario;
    private javax.swing.JPanel pedido;
    private javax.swing.JPanel producto;
    private javax.swing.JPanel proveedor;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTable txtLista_pedidos;
    private javax.swing.JTextField txtpedidos;
    private javax.swing.JTextField txtproveedor;
    // End of variables declaration//GEN-END:variables
}
