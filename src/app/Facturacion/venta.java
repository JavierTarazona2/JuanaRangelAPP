/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.Facturacion;

import app.Inicio.Incio;
import app.bd_conexion.empleado_cbd;
import app.bd_conexion.venta_cbd;
import app.datos.Ventas;
import app.datos.cliente;
import app.datos.empleado;
import app.datos.pedido;
import app.datos.proveedor;
import app.datos.proveedor_pedido;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class venta extends javax.swing.JPanel {
    venta_cbd vcbd = new venta_cbd();
    empleado_cbd ecbd = new empleado_cbd();
    private DefaultTableModel modelo;
    private DefaultTableModel modelo1;
    private DefaultTableModel modelo2;
    private DefaultTableModel modelo3;
    Incio inicio;
    public venta(Incio inicio) {
        this.inicio = inicio;
        initComponents();
        iniciotablas();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Venta_ = new javax.swing.JPanel();
        txtventa = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Listaventa = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        pedido = new javax.swing.JPanel();
        txtpedidos = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListaPedido = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        clientes = new javax.swing.JPanel();
        txtcliente = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listacliente = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtproveedor = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaempleado = new javax.swing.JTable();
        jButton29 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Venta_.setBackground(new java.awt.Color(255, 255, 255));

        txtventa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtventa.setText("Buscar por cliente de la venta");
        txtventa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtventa.setMinimumSize(new java.awt.Dimension(400, 30));
        txtventa.setPreferredSize(new java.awt.Dimension(400, 30));
        txtventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtventaActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(182, 11, 11));
        jButton5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Buscar");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
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
        jButton6.setText("Agregar Venta");
        jButton6.setBorder(null);
        jButton6.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        Listaventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cliente", "Valor", "Tipo", "productos", "realizacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Listaventa);

        jButton13.setBackground(new java.awt.Color(182, 11, 11));
        jButton13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("info");
        jButton13.setBorder(null);
        jButton13.setBorderPainted(false);
        jButton13.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton13.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton13.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Venta_Layout = new javax.swing.GroupLayout(Venta_);
        Venta_.setLayout(Venta_Layout);
        Venta_Layout.setHorizontalGroup(
            Venta_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Venta_Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(Venta_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Venta_Layout.createSequentialGroup()
                        .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        Venta_Layout.setVerticalGroup(
            Venta_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Venta_Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Venta_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Venta_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas ", Venta_);

        pedido.setBackground(new java.awt.Color(255, 255, 255));

        txtpedidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtpedidos.setText("Buscar por cliente del pedido");
        txtpedidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtpedidos.setMinimumSize(new java.awt.Dimension(400, 30));
        txtpedidos.setPreferredSize(new java.awt.Dimension(400, 30));
        txtpedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpedidosActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(182, 11, 11));
        jButton7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Buscar");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton7.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton7.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(182, 11, 11));
        jButton8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Crear Pedido");
        jButton8.setBorder(null);
        jButton8.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton8.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton8.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        ListaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Detalles", "Cliente", "cantidad", "Valor", "Fecha de realizado", "Fecha de entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(ListaPedido);

        jButton12.setBackground(new java.awt.Color(182, 11, 11));
        jButton12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Info");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
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
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pedidoLayout.createSequentialGroup()
                        .addComponent(txtpedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        pedidoLayout.setVerticalGroup(
            pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pedidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedido", pedido);

        clientes.setBackground(new java.awt.Color(255, 255, 255));

        txtcliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtcliente.setText("Buscar por  nombre del cliente");
        txtcliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtcliente.setMinimumSize(new java.awt.Dimension(400, 30));
        txtcliente.setPreferredSize(new java.awt.Dimension(400, 30));
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(182, 11, 11));
        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Buscar");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
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
        jButton4.setText("Agregar Cliente");
        jButton4.setBorder(null);
        jButton4.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        listacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Correo", "Telefona", "Identificacion", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listacliente);

        jButton11.setBackground(new java.awt.Color(182, 11, 11));
        jButton11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Info");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton11.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton11.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton11.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jButton11InputMethodTextChanged(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientesLayout = new javax.swing.GroupLayout(clientes);
        clientes.setLayout(clientesLayout);
        clientesLayout.setHorizontalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientesLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(clientesLayout.createSequentialGroup()
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        clientesLayout.setVerticalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", clientes);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 650));

        txtproveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtproveedor.setText("Buscar por  nombre el Empleado");
        txtproveedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtproveedor.setMinimumSize(new java.awt.Dimension(400, 30));
        txtproveedor.setPreferredSize(new java.awt.Dimension(400, 30));
        txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedorActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(182, 11, 11));
        jButton9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Buscar");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton9.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton9.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(182, 11, 11));
        jButton10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Agregar Empleado");
        jButton10.setBorder(null);
        jButton10.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton10.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton10.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        listaempleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Telefono", "Correo", "Identificacion", "Direccion", "Fecha ingreso", "Edad", "Estado", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaempleado);

        jButton29.setBackground(new java.awt.Color(182, 11, 11));
        jButton29.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Info");
        jButton29.setBorder(null);
        jButton29.setBorderPainted(false);
        jButton29.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton29.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton29.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         inicio.mostrar(new AgregarCliente(inicio));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtventaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        inicio.mostrar(new AgregarVenta(inicio, codigoVenta()));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtpedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpedidosActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       inicio.mostrar(new AgregarPedidos(inicio,codigoVenta()));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     String venta = txtventa.getText();
     refrescarTablaventas(vcbd.ListadoVentas(venta));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     String pedidoss = txtpedidos.getText();
     refrescarTablapedidos(vcbd.ListadoPedidos(pedidoss));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     String clientess = txtcliente.getText();
     refrescarTablaclientes(vcbd.ListarClientes(clientess));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        inicio.mostrar(new AgregarEmpleado(inicio));
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
      // Obtener el modelo de la tabla
     DefaultTableModel modelo = (DefaultTableModel) listacliente.getModel();
    
    // Obtener la fila seleccionada
    int filaSeleccionada = listacliente.getSelectedRow();
    
    // Verificar si se ha seleccionado alguna fila
    if (filaSeleccionada != -1) {
        // Obtener los datos de la fila seleccionada
        String nombre = (String) modelo.getValueAt(filaSeleccionada, 0);
        
        // Obtener el cliente usando el nombre
        cliente clienteSeleccionado = vcbd.ListarCliente(nombre);
        
        // Verificar que el cliente no sea null
        if (clienteSeleccionado != null) {
            // Crear la instancia de AgregarCliente y mostrarla
            AgregarCliente agregarCliente = new AgregarCliente(clienteSeleccionado);
            inicio.mostrar(agregarCliente);
        } else {
            // Mostrar un mensaje si el cliente no se encuentra
            JOptionPane.showMessageDialog(inicio, "Cliente no encontrado.");
        }
    } else {
        // Mostrar un mensaje si no se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(inicio, "Seleccione una fila en la tabla.");
    }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton11InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jButton11InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11InputMethodTextChanged

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
   // Obtener el modelo de la tabla
     DefaultTableModel modelo3 = (DefaultTableModel) listaempleado.getModel();
    
    // Obtener la fila seleccionada
    int filaSeleccionada = listaempleado.getSelectedRow();
    
    // Verificar si se ha seleccionado alguna fila
    if (filaSeleccionada != -1) {
        // Obtener los datos de la fila seleccionada
        String nombre = (String) modelo3.getValueAt(filaSeleccionada, 0);
        
        // Obtener el cliente usando el nombre
        empleado clienteSeleccionado = ecbd.ListarEmpleado(nombre);
        
        // Verificar que el cliente no sea null
        if (clienteSeleccionado != null) {
            // Crear la instancia de AgregarCliente y mostrarla
            AgregarEmpleado agregarCliente = new AgregarEmpleado(inicio,clienteSeleccionado);
            inicio.mostrar(agregarCliente);
        } else {
            // Mostrar un mensaje si el cliente no se encuentra
            JOptionPane.showMessageDialog(inicio, "Cliente no encontrado.");
        }
    } else {
        // Mostrar un mensaje si no se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(inicio, "Seleccione una fila en la tabla.");
    }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
     // Obtener el modelo de la tabla
     DefaultTableModel modelo1 = (DefaultTableModel) ListaPedido.getModel();
    
    // Obtener la fila seleccionada
    int filaSeleccionada = ListaPedido.getSelectedRow();
    
    // Verificar si se ha seleccionado alguna fila
    if (filaSeleccionada != -1) {
        // Obtener los datos de la fila seleccionada
        String nombre = (String) modelo1.getValueAt(filaSeleccionada, 0);
        
        // Obtener el cliente usando el nombre
        pedido clienteSeleccionado =  vcbd.obtenerPedidoPorCodigo(nombre);
        
        // Verificar que el cliente no sea null
        if (clienteSeleccionado != null) {
            // Crear la instancia de AgregarCliente y mostrarla
            AgregarPedidos agregarCliente = new AgregarPedidos(inicio,clienteSeleccionado);
            inicio.mostrar(agregarCliente);
        } else {
            // Mostrar un mensaje si el cliente no se encuentra
            JOptionPane.showMessageDialog(inicio, "Cliente no encontrado.");
        }
    } else {
        // Mostrar un mensaje si no se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(inicio, "Seleccione una fila en la tabla.");
    }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        
         // Obtener el modelo de la tabla
     DefaultTableModel modelo2= (DefaultTableModel) Listaventa.getModel();
    
    // Obtener la fila seleccionada
    int filaSeleccionada = Listaventa.getSelectedRow();
    
    // Verificar si se ha seleccionado alguna fila
    if (filaSeleccionada != -1) {
        // Obtener los datos de la fila seleccionada
        String nombre = (String) modelo2.getValueAt(filaSeleccionada, 0);
        
        // Obtener el cliente usando el nombre
        Ventas clienteSeleccionado = (Ventas) vcbd.obtenerVentaPorCodigo(nombre);
        
        // Verificar que el cliente no sea null
        if (clienteSeleccionado != null) {
            // Crear la instancia de AgregarCliente y mostrarla
            AgregarVenta agregarCliente = new AgregarVenta(inicio,clienteSeleccionado);
            inicio.mostrar(agregarCliente);
        } else {
            // Mostrar un mensaje si el cliente no se encuentra
            JOptionPane.showMessageDialog(inicio, "Cliente no encontrado.");
        }
    } else {
        // Mostrar un mensaje si no se ha seleccionado ninguna fila
        JOptionPane.showMessageDialog(inicio, "Seleccione una fila en la tabla.");
    }
    }//GEN-LAST:event_jButton13ActionPerformed
    // Método para refrescar la tabla de clientes
    public void refrescarTablaclientes(ArrayList<cliente> clientes) {
        modelo.setRowCount(0); // Limpia la tabla antes de actualizarla
        for (cliente cl : clientes) {
            Object[] fila = {
                cl.getNombre(),
                cl.getCorreo(),
                cl.getTelefono(),
                cl.getIdentificacion(),
                cl.getDireccion()
            };
            modelo.addRow(fila);
        }
    }

    // Método para refrescar la tabla de empleados
    public void refrescarTablaempleado(ArrayList<empleado> empleados) {
        modelo3.setRowCount(0); // Limpia la tabla antes de actualizarla
        for (empleado emp : empleados) {
            Object[] fila = {
                emp.getNombre(),
                emp.getTelefono(),
                emp.getCorreo(),
                emp.getIdentificacion(),
                emp.getDireccion(),
                emp.getFecha_ingreso(),
                emp.getEdad(),
                emp.getEstado(),
                emp.getSueldo()
            };
            modelo3.addRow(fila);
        }
    }

    // Método para refrescar la tabla de pedidos
    public void refrescarTablapedidos(ArrayList<pedido> pedidos) {
        modelo1.setRowCount(0); // Limpia la tabla antes de actualizarla
        for (pedido pd : pedidos) {
            Object[] fila = {
                pd.getCodigo(), // Se agrega el código del pedido
                pd.getDetalles(),
                pd.getCliente().getNombre(),
                pd.getProductos().size(),
                pd.getValor(),
                pd.getFecha_realizado(),
                pd.getFecha_entrega()
            };
            modelo1.addRow(fila);
        }
    }

    // Método para refrescar la tabla de ventas
    public void refrescarTablaventas(ArrayList<Ventas> ventas) {
        modelo2.setRowCount(0); // Limpia la tabla antes de actualizarla
        String tipo;
        for (Ventas v : ventas) {
            tipo = (v.getTipo_venta() == 1) ? "Pedido" : "Venta";
            Object[] fila = {
                v.getCodigo(), // Se agrega el código de la venta
                v.getCliente().getNombre(),
                v.getValor(),
                tipo,
                v.getProductos().size(),
                v.getFecha_realizado()
            };
            modelo2.addRow(fila);
        }
    }

    // Método para inicializar y actualizar las tablas con datos actuales
    private void iniciotablas() {
        modelo = (DefaultTableModel) listacliente.getModel();
        refrescarTablaclientes(vcbd.ListarCliente());

        modelo1 = (DefaultTableModel) ListaPedido.getModel();
        refrescarTablapedidos(vcbd.ListadoPedidos());

        modelo2 = (DefaultTableModel) Listaventa.getModel();
        refrescarTablaventas(vcbd.ListadoVentas());

        modelo3 = (DefaultTableModel) listaempleado.getModel();
        refrescarTablaempleado(ecbd.ListarEmpleados());
    }
    private String codigoVenta(){
        String codigo;
         // Obtener la hora actual
        LocalTime ahora = LocalTime.now();

        // Definir el formato de hora deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        
        // Formatear la hora
        String horaFormateada = ahora.format(formatter);
        
         // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Definir el formato de fecha deseado
        DateTimeFormatter formattesr = DateTimeFormatter.ofPattern("yyyyMM");


        // Formatear la fecha
        String fechaFormateada = fechaActual.format(formattesr);
        
        codigo = "COD" + fechaFormateada + horaFormateada;
        
        return codigo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListaPedido;
    private javax.swing.JTable Listaventa;
    private javax.swing.JPanel Venta_;
    private javax.swing.JPanel clientes;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable listacliente;
    private javax.swing.JTable listaempleado;
    private javax.swing.JPanel pedido;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtpedidos;
    private javax.swing.JTextField txtproveedor;
    private javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables
}
