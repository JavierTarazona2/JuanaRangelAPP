
package app.Inicio;

import app.Facturacion.AgregarPedidos;
import app.Inventario.Pedido_proveedor;
import app.bd_conexion.proveedor_cbd;
import app.bd_conexion.venta_cbd;
import app.datos.pedido;
import app.datos.proveedor_pedido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


    /**
     * Panel principal que gestiona la visualización de pedidos y proveedores.
     */

    public final class principal extends javax.swing.JPanel {
        
        private final DefaultTableModel modelo;
        private final DefaultTableModel modelo1;
        private final proveedor_cbd bdproveedor = new proveedor_cbd();
        private final venta_cbd bdventa = new venta_cbd();
        private final Incio inicio;
        private LocalDate fecha = LocalDate.now();

        /**
         * Constructor de la clase principal.
         * @param inicio Instancia de la clase Incio.
         */
        
        public principal(Incio inicio) {
            
            this.inicio = inicio;
            initComponents();
            modelo = (DefaultTableModel) pedidoCliente.getModel();
            modelo1 = (DefaultTableModel) pedidoProveedor.getModel();

            // Actualizar las tablas
            refrescarTablacliente();
            refrescarTablapedido();
            
            click();
        }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidoCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pedidoProveedor = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pedidoCliente.setAutoCreateRowSorter(true);
        pedidoCliente.setBackground(new java.awt.Color(245, 22, 22));
        pedidoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pedidoCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pedidoCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Codigo", "Fecha de entrega", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pedidoCliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 757, 190));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pedidos de clientes con fechas de entrega próximas.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 6, 688, 44));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Pedidos de proveedores con fechas de entrega próximas.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 284, 530, 50));

        pedidoProveedor.setBackground(new java.awt.Color(245, 22, 22));
        pedidoProveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pedidoProveedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pedidoProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Proveedor", "Codigo", "Feche de entrega", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pedidoProveedor.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jScrollPane2.setViewportView(pedidoProveedor);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 770, 220));

        jSeparator1.setBackground(new java.awt.Color(117, 11, 11));
        jSeparator1.setForeground(new java.awt.Color(117, 11, 11));
        jSeparator1.setToolTipText("");
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 550, 30));

        jSeparator2.setBackground(new java.awt.Color(117, 11, 11));
        jSeparator2.setForeground(new java.awt.Color(117, 11, 11));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 530, 30));

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
        
    private void pedidoClienteMouseClicked(java.awt.event.MouseEvent evt) {                                           
      if (evt.getClickCount() == 2) { // Verificar doble clic
          
        int filaSeleccionada = pedidoCliente.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtener el código del pedido seleccionado
            String codigoPedido = (String) modelo.getValueAt(filaSeleccionada, 1);
            
            // Obtener el objeto pedido usando el código
            pedido pedidoSeleccionado = bdventa.obtenerPedidoPorCodigo(codigoPedido);
            
            if (pedidoSeleccionado != null) {
                // Crear e iniciar la vista de detalle del pedido
                AgregarPedidos vistaPedido = new AgregarPedidos(inicio, pedidoSeleccionado);
                inicio.mostrar(vistaPedido);
            } else {
                // Mostrar mensaje de error si el pedido no se encuentra
                JOptionPane.showMessageDialog(inicio, "Pedido no encontrado.");
            }
        } else {
            // Mostrar mensaje de advertencia si no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(inicio, "Seleccione una fila en la tabla.");
        }
    }
      
    }                                          

    private void pedidoProveedorMouseClicked(java.awt.event.MouseEvent evt) {                                             
        if (evt.getClickCount() == 2) { // Verificar doble clic
        int filaSeleccionada = pedidoProveedor.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el código del pedido seleccionado
            String codigoPedido = (String) modelo1.getValueAt(filaSeleccionada, 1);
            System.out.println("Código de pedido seleccionado: " + codigoPedido); // Depuración

            // Obtener el objeto proveedor_pedido usando el código
            proveedor_pedido pedidoSeleccionado = bdproveedor.ListadoPedido(codigoPedido);

            if (pedidoSeleccionado != null) {
                // Crear e iniciar la vista de detalle del pedido
                Pedido_proveedor vistaPedidoProveedor = new Pedido_proveedor(inicio, pedidoSeleccionado);
                inicio.mostrar(vistaPedidoProveedor);
            } else {
                // Mostrar mensaje de error si el pedido no se encuentra
                JOptionPane.showMessageDialog(inicio, "Pedido no encontrado.");
                System.out.println("Pedido no encontrado con código: " + codigoPedido); // Depuración
            }
        } else {
            // Mostrar mensaje de advertencia si no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(inicio, "Seleccione una fila en la tabla.");
        }
    }
    }                  
    
    
        /**
     * Actualiza la tabla de clientes con los pedidos.
     */
    public void refrescarTablacliente() {

        ArrayList<pedido> pedidos = bdventa.ListadoPedidos(fecha);
        
        modelo.setRowCount(0); // Limpia la tabla antes de actualizarla
        
        pedidos.stream()
            .filter(p -> !p.getEstado()) // Filtra pedidos con estado false
            .forEach(p -> modelo.addRow(new Object[] {
                p.getCliente().getNombre(),
                p.getCodigo(),
                p.getFecha_entrega(),
                p.getValor()
            }));
    }
    
    /**
     * Actualiza la tabla de proveedores con los pedidos.
     */
    public void refrescarTablapedido() {
        
        ArrayList<proveedor_pedido> pedidos = bdproveedor.ListadoPedidos(fecha);
        
        modelo1.setRowCount(0); // Limpia la tabla antes de actualizarla
        
        pedidos.stream()
            .filter(p -> !p.getEstado()) // Filtra pedidos con estado false
            .forEach(p -> modelo1.addRow(new Object[] {
                p.getproveedor().getNombre(),
                p.getCodigo(),
                p.getFecha_entrega(),
                p.getValor_total()
            }));
    }
    private void click (){
        // Agregar MouseAdapter para pedidoCliente
        pedidoCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Verificar doble clic
                    pedidoClienteMouseClicked(evt);
                }
            }
        });

        // Agregar MouseAdapter para pedidoProveedor
        pedidoProveedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Verificar doble clic
                    pedidoProveedorMouseClicked(evt);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable pedidoCliente;
    private javax.swing.JTable pedidoProveedor;
    // End of variables declaration//GEN-END:variables
}
