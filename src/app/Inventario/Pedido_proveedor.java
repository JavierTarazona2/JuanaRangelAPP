package app.Inventario;

import app.Inicio.Incio;
import app.bd_conexion.*;
import app.datos.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public final class Pedido_proveedor extends javax.swing.JPanel {
    private final proveedor_cbd prcdb = new proveedor_cbd();
    private final producto_cbd pcdb = new producto_cbd();
    private final ArrayList<Double> valors = new ArrayList<>();
    private final Incio inicio;
    private final DefaultTableModel modelo;
    private final balance_cbd bcdb = new balance_cbd();
    private final balance balance = new balance();
    private Boolean verificar;
    private proveedor_pedido pe = new proveedor_pedido();

    /**
     * Constructor para el panel de pedidos del proveedor.
     * Inicializa los componentes y actualiza la lista de proveedores.
     * 
     * @param inicio Referencia al objeto Incio
     */
    
    public Pedido_proveedor(Incio inicio) {
        this.inicio = inicio;
        initComponents();
        modelo = (DefaultTableModel) txtProductos.getModel();
        actualizarProveedores();
    }

    /**
     * Constructor que recibe un proveedor_pedido.
     * Inicializa los componentes, muestra el proveedor y configura el estado de entrega.
     * 
     * @param inicio Referencia al objeto Incio
     * @param sdds Objeto proveedor_pedido a mostrar en el panel
     */
    
    public Pedido_proveedor(Incio inicio, proveedor_pedido sdds) {
        this.inicio = inicio;
        this.pe = sdds;
        initComponentes();
        modelo = (DefaultTableModel) txtProductos.getModel();
        mostrarProveedor(sdds);
        configurarEstadoEntrega(sdds.getEstado());
        verificar = sdds.getEstado();
        inicio.getUser().desactivarboton(BActualizar);
    }

    
    /**
     * Configura el estado de entrega en base al estado proporcionado.
     * 
     * @param estado Estado de entrega del pedido
     */
    
    private void configurarEstadoEntrega(Boolean estado) {
        if (estado.equals(Boolean.TRUE)) {
            entregado.setSelected(true);
            entregado.setEnabled(false); // Deshabilita el checkbox "Entregado"
            nentregado.setEnabled(false); // Evita cambiar el estado si ya se entregó
        } else {
            nentregado.setSelected(true);
            entregado.setEnabled(true); // Permite alternar entre los dos
            nentregado.setEnabled(true);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtproveedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtProductos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfehaEntrega = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcodigof = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Pedido Realizado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Elegir proveedor a cargo del pedido:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 28));

        txtproveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtproveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 261, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Productos por codigo o por nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 28));

        txtnombre.setText("nombre");
        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 260, 30));

        jButton1.setBackground(new java.awt.Color(177, 11, 11));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 153, 90, 30));

        txtProductos.setAutoCreateRowSorter(true);
        txtProductos.setBackground(new java.awt.Color(245, 22, 22));
        txtProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtProductos.setForeground(new java.awt.Color(255, 255, 255));
        txtProductos.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Codigo", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(txtProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 750, 260));

        jButton2.setBackground(new java.awt.Color(177, 11, 11));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Crear pedido");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 110, 40));

        jButton3.setBackground(new java.awt.Color(177, 11, 11));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("descartar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 110, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Que cantidad desea del producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 28));

        txtcantidad.setText("cantidad");
        txtcantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 152, 260, 30));

        txtcodigo.setText("codigo");
        txtcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de entrega del pedido:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 28));

        txtfehaEntrega.setText("YYYY-MM-DD");
        txtfehaEntrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtfehaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 260, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Codigo de la factura:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 28));

        txtcodigof.setText("Codigo factura");
        txtcodigof.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcodigof, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 370, 30));

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
    // Inicialización de componentes
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    txtProductos = new javax.swing.JTable();
    BActualizar = new javax.swing.JButton();
    BVolver = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    txtfehaEntregaE = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    txtcodigoF = new javax.swing.JTextField();
    proveedorE = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    txtfeharealizado = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    ValorE = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    entregado = new javax.swing.JCheckBox();
    nentregado = new javax.swing.JCheckBox();
    jLabel10 = new javax.swing.JLabel();
    BEliminar = new javax.swing.JButton();

    setBackground(new java.awt.Color(255, 255, 255));
    setMinimumSize(new java.awt.Dimension(800, 650));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); 
    jLabel1.setText("Pedido Realizado");

    jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); 
    jLabel2.setText("Proveedor a cargo del pedido:");
    
    // Configuración de la tabla
    txtProductos.setAutoCreateRowSorter(true);
    txtProductos.setBackground(new java.awt.Color(245, 22, 22));
    txtProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    txtProductos.setForeground(new java.awt.Color(255, 255, 255));
    txtProductos.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Id", "Código", "Nombre", "Cantidad"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, true, true
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    });
    jScrollPane1.setViewportView(txtProductos);

    // Configuración de los botones con tamaño aumentado
    BActualizar.setBackground(new java.awt.Color(177, 11, 11));
    BActualizar.setForeground(new java.awt.Color(255, 255, 255));
    BActualizar.setText("Actualizar");
    BActualizar.setMinimumSize(new java.awt.Dimension(100, 40)); // Tamaño mínimo
    BActualizar.setPreferredSize(new java.awt.Dimension(120, 50)); // Tamaño preferido
    BActualizar.setMaximumSize(new java.awt.Dimension(150, 60)); // Tamaño máximo
    BActualizar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BActualizarActionPerformed(evt);
        }
    });

    BVolver.setBackground(new java.awt.Color(177, 11, 11));
    BVolver.setForeground(new java.awt.Color(255, 255, 255));
    BVolver.setText("Volver");
    BVolver.setMinimumSize(new java.awt.Dimension(100, 40)); // Tamaño mínimo
    BVolver.setPreferredSize(new java.awt.Dimension(120, 50)); // Tamaño preferido
    BVolver.setMaximumSize(new java.awt.Dimension(150, 60)); // Tamaño máximo
    BVolver.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BVolverActionPerformed(evt);
        }
    });

    BEliminar.setBackground(new java.awt.Color(177, 11, 11));
    BEliminar.setForeground(new java.awt.Color(255, 255, 255));
    BEliminar.setText("Eliminar");
    BEliminar.setMinimumSize(new java.awt.Dimension(100, 40)); // Tamaño mínimo
    BEliminar.setPreferredSize(new java.awt.Dimension(120, 50)); // Tamaño preferido
    BEliminar.setMaximumSize(new java.awt.Dimension(150, 60)); // Tamaño máximo
    BEliminar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            BEliminarActionPerformed(evt);
        }
    });

    // Continuar con la configuración de otros componentes y layout...


    jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel5.setText("Fecha de entrega del pedido");

    txtfehaEntregaE.setText("YYYY-MM-DD");

    jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel6.setText("Código de la factura");

    txtcodigoF.setText("Código factura");
    txtcodigoF.setEditable(false); // No editable

    proveedorE.setText("Nombre del proveedor");
    proveedorE.setEditable(false); // No editable

    jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel7.setText("Fecha de realizado del pedido");

    txtfeharealizado.setText("YYYY-MM-DD");
    txtfeharealizado.setEditable(false); // No editable

    jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel8.setText("Valor del pedido");

    ValorE.setText("Valor del pedido");
    ValorE.setEditable(false); // No editable

    jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel9.setText("Estado del pedido");

    entregado.setText("Entregado");
    nentregado.setText("No entregado");

    // Configurar los ActionListeners para que los CheckBoxes sean exclusivos
    entregado.addActionListener(evt -> {
        if (entregado.isSelected()) {
            nentregado.setSelected(false);
        }
    });

    nentregado.addActionListener(evt -> {
        if (nentregado.isSelected()) {
            entregado.setSelected(false);
        }
    });

    jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel10.setText("Para los productos no entregados en el pedido, seleccione y luego oprima el botón de eliminar.");

    // Configuración del diseño (Layout)
    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(115, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(BActualizar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BVolver)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BEliminar)
                    .addGap(332, 332, 332))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(22, 22, 22)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(76, 76, 76)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(entregado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nentregado))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(proveedorE)
                                    .addComponent(txtfehaEntregaE)
                                    .addComponent(txtfeharealizado)
                                    .addComponent(txtcodigoF)
                                    .addComponent(ValorE, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
                        .addComponent(jLabel7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(151, 151, 151))))
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(300, 300, 300)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jLabel10)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(proveedorE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtfehaEntregaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtfeharealizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtcodigoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ValorE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(entregado)
                .addComponent(nentregado))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel10)
            .addGap(27, 27, 27)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BActualizar)
                .addComponent(BVolver)
                .addComponent(BEliminar))
            .addContainerGap(45, Short.MAX_VALUE))
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
}
// </editor-fold>  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        inicio.mostrar(new inventario(inicio));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           try {
            // Validar que todos los campos necesarios estén completos y sean válidos
            validarCamposPedido();

            // Establecer el proveedor basado en la selección del JComboBox
            pe.setProveedor(prcdb.ListadoProveedor(txtproveedor.getSelectedItem().toString()));

            // Establecer las fechas de realización y entrega del pedido
            pe.setFecha_realizacion(LocalDate.now());
            pe.setFecha_entrega(LocalDate.parse(txtfehaEntrega.getText()));

            // Establecer el código del pedido
            pe.setCodigo(txtcodigof.getText());

            // Calcular el valor total del pedido sumando todos los valores
            Double valor = valors.stream().mapToDouble(Double::doubleValue).sum();
            pe.setValor_total(valor);
            pe.setEstado(false);

            // Registrar el pedido en la base de datos
            prcdb.RegistrarPedidos(pe);

            

            // Mostrar el panel de inventario
            inicio.mostrar(new inventario(inicio));

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(inicio, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(inicio, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Validar que los campos de producto estén completos y sean válidos
            validarCamposProducto();

            String codigo = txtcodigo.getText();
            String nombre = txtnombre.getText();
            Integer cantidad = Integer.valueOf(txtcantidad.getText());

            // Buscar el producto en la base de datos por nombre o código
            producto p = pcdb.buscadoListarProductos(nombre, codigo);

            // Agregar el producto al pedido y actualizar la lista de valores
            pe.setProductos(p, cantidad);
            valors.add(p.getPrecio_entrada() * cantidad);

            // Refrescar la tabla de productos en la interfaz
            refrescarTablaProductos(pe.getProductos(), pe.getCantidades());

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(inicio, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(inicio, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        
    
   private void BActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                            
    // Validar campos y actualizar el objeto pedido
    actualizarPedido();
    
    // Guardar los cambios en la base de datos
    prcdb.actualizarPedido(pe);
    
    // Muestra el panel de inventario después de actualizar
    inicio.mostrar(new inventario(inicio));  
    }  

   
    private void actualizarPedido() {
        // Actualiza la fecha de entrega si ha cambiado
        LocalDate nuevaFechaEntrega = LocalDate.parse(txtfehaEntregaE.getText());
        if (!pe.getFecha_entrega().equals(nuevaFechaEntrega)) {
            pe.setFecha_entrega(nuevaFechaEntrega);
        }

        // Actualiza el valor total si ha cambiado
        double nuevoValorTotal = Double.parseDouble(ValorE.getText());
        if (!Objects.equals(pe.getValor_total(), nuevoValorTotal)) {
            pe.setValor_total(nuevoValorTotal);
        }

        // Actualiza el estado del pedido según el estado del checkbox
        pe.setEstado(entregado.isSelected());
        verificarEstado();
    }       

    
    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                          
    int filaSeleccionada = txtProductos.getSelectedRow();

    if (filaSeleccionada != -1) {
        eliminarProducto(filaSeleccionada);
        refrescarTablaProductos(pe.getProductos(), pe.getCantidades());
        ValorE.setText(String.valueOf(calcularNuevoValorTotal()));
    } else {
        JOptionPane.showMessageDialog(inicio, "Por favor, seleccione un producto para eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
    }
    }

    
    private void eliminarProducto(int filaSeleccionada) {
        String codigoProducto = (String) txtProductos.getValueAt(filaSeleccionada, 1);

        for (int i = 0; i < pe.getProductos().size(); i++) {
            producto p = pe.getProductos().get(i);
            if (p.getCodigo().equals(codigoProducto)) {
                pe.getProductos().remove(i);
                pe.getCantidades().remove(i);
                break;
            }
        }
    }


    // Método para calcular el nuevo valor total del pedido
    private double calcularNuevoValorTotal() {
        double nuevoValorTotal = 0.0;
        for (int i = 0; i < pe.getProductos().size(); i++) {
            producto p = pe.getProductos().get(i);
            int cantidad = pe.getCantidades().get(i);
            nuevoValorTotal += p.getPrecio_entrada() * cantidad; // Suponiendo que producto tiene un método getPrecio_entrada()
        }
        return nuevoValorTotal;
    }

    
    private void BVolverActionPerformed(ActionEvent evt) {
        // Muestra el panel de inventario al hacer clic en "Volver"
        inicio.mostrar(new inventario(inicio));     
    }
// Método para refrescar la tabla de productos agregados en el pedido
   
    public void refrescarTablaProductos(ArrayList<producto> productos, ArrayList<Integer> cantidades) {
    modelo.setRowCount(0); // Limpia la tabla antes de actualizarla

    if (productos.size() == cantidades.size()) {
        for (int i = 0; i < productos.size(); i++) {
            producto p = productos.get(i);
            Object[] fila = {
                i + 1, // Índice de la fila
                p.getCodigo(),
                p.getNombre(),
                cantidades.get(i)
            };
            modelo.addRow(fila);
        }
    } else {
        JOptionPane.showMessageDialog(inicio, "La cantidad de productos y cantidades no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }

    
    
    // Método para actualizar la lista de proveedores en el JComboBox
    
    public void actualizarProveedores() {
    try {
        ArrayList<proveedor> listaProveedores = prcdb.ListadoProveedores();
        txtproveedor.removeAllItems();
        for (proveedor p : listaProveedores) {
            txtproveedor.addItem(p.getNombre());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(inicio, "Error al actualizar los proveedores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }


    // Método para validar que todos los campos de un pedido estén completos
    private void validarCamposPedido() {
        if (txtproveedor.getSelectedItem() == null || txtfehaEntrega.getText().isEmpty() || txtcodigof.getText().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos del pedido son obligatorios. Por favor, complete la información.");
        }
    }

    // Método para validar que todos los campos de un producto estén completos
    private void validarCamposProducto() {
        if (txtcodigo.getText().isEmpty() || txtnombre.getText().isEmpty() || txtcantidad.getText().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos del producto son obligatorios. Por favor, complete la información.");
        }

        // Validar que la cantidad sea un número entero
        try {
            Integer.valueOf(txtcantidad.getText());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La cantidad debe ser un número entero válido.");
        }
    }
    
    private void mostrarProveedor(proveedor_pedido prrr){
        
       proveedorE.setText(prrr.getproveedor().getNombre());
       
       txtfehaEntregaE.setText(prrr.getFecha_entrega().toString());
       
       txtcodigoF.setText(prrr.getCodigo());
       
       txtfeharealizado.setText(prrr.getFecha_realizacion().toString());
       
       ValorE.setText(prrr.getValor_total().toString());
       
       if(prrr.getEstado().equals(Boolean.TRUE)){
           entregado.setSelected(Boolean.TRUE);
       }else{
           nentregado.setSelected(Boolean.TRUE);
       }
       
       refrescarTablaProductos(prrr.getProductos(),prrr.getCantidades());
    }
    private void verificarEstado(){
        if(verificar.equals(false)){
            if(entregado.isSelected()){
            // Detallar el pedido en el balance
            balance.setDetalles("Pedido Realizado a " + pe.getproveedor().getNombre());
            balance.setFecha(LocalDate.now());
            balance.setTipo("Gasto");
            balance.setValor(pe.getValor_total());
            bcdb.registrarBalance(balance);
            Integer i = 0;
            
           
            for(producto pp : pe.getProductos()){
                pp = pcdb.buscarProductoPorId(pcdb.obtenerIdProducto(pp.getCodigo()));
                Integer cantidad =  pp.getCantidad() + pe.getCantidades().get(i);
                pp.setCantidad(cantidad);
                pcdb.ActualizarProducto( pp);
                i++;
            }
        }}
    }
    
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BVolver;
    private javax.swing.JTextField ValorE;
    private javax.swing.JCheckBox entregado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JCheckBox nentregado;
    private javax.swing.JTextField proveedorE;
    private javax.swing.JTextField txtcodigoF;
    private javax.swing.JTextField txtfehaEntregaE;
    private javax.swing.JTextField txtfeharealizado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable txtProductos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcodigof;
    private javax.swing.JTextField txtfehaEntrega;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JComboBox<String> txtproveedor;
    // End of variables declaration//GEN-END:variables
}
