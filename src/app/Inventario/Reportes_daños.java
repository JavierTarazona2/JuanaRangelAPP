/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.Inventario;

import app.Inicio.Incio;
import app.bd_conexion.producto_cbd;
import app.bd_conexion.proveedor_cbd;
import app.datos.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javie
 */
public final class Reportes_daños extends javax.swing.JPanel {
    private final DefaultTableModel modelo;
    public proveedor_cbd prcdb = new proveedor_cbd();
    public producto_cbd pcdb = new producto_cbd();
    public reportes reporte = new reportes();
    private Incio inicio;
    public Reportes_daños(Incio inicio) {
        this.inicio = inicio;
        initComponents();
        actualizarProductos();
        modelo = (DefaultTableModel) listaProductos.getModel();
        
    }
    public Reportes_daños(Incio inicio,reportes report) {
        initComponentes();
        this.reporte = report;
        this.inicio = inicio;
        
        modelo = (DefaultTableModel) listaProductos.getModel();
        refrescarTablaProductos(report.getProductos());
        Mostrarreporte(report);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtProductos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdetalles = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Realizar Reporte");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 6, -1, 54));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Productos para los que se generará el reporte:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        txtcodigo.setText("codigo");
        txtcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 320, 30));

        txtProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductosActionPerformed(evt);
            }
        });
        jPanel1.add(txtProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 380, 30));

        jButton1.setBackground(new java.awt.Color(177, 11, 11));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 90, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ID o nombre del producto a reportar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        listaProductos.setBackground(new java.awt.Color(245, 22, 22));
        listaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 710, 150));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cantidad exitentes del producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 30));

        txtcantidad.setText("Cantidad");
        txtcantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 380, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Detalle lo que sucedió con los productos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 366, 604, 50));

        txtdetalles.setColumns(20);
        txtdetalles.setRows(5);
        txtdetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(txtdetalles);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 413, 710, 140));

        jButton2.setBackground(new java.awt.Color(177, 11, 11));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Crear Reporte");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 130, 40));

        jButton3.setBackground(new java.awt.Color(177, 11, 11));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Descartar Reporte");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 130, 40));

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
    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    listaProductos = new javax.swing.JTable();
    jLabel4 = new javax.swing.JLabel();
    txtcantidad = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtdetalles = new javax.swing.JTextArea();
    jButton3 = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    Perdidas = new javax.swing.JTextField();

    setMinimumSize(new java.awt.Dimension(800, 650));
    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel1.setText("Realizar Reporte");

    listaProductos.setAutoCreateRowSorter(true);
    listaProductos.setBackground(new java.awt.Color(245, 22, 22));
    listaProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    listaProductos.setForeground(new java.awt.Color(255, 255, 255));
    listaProductos.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "Codigo", "Nombre", "Cantidad"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    jScrollPane1.setViewportView(listaProductos);

    jLabel4.setText("Fecha del Reporte");

    txtcantidad.setText("Cantidad");

    jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("Detalle que fue lo que le ocurrio a los productos:");

    txtdetalles.setColumns(20);
    txtdetalles.setRows(5);
    jScrollPane2.setViewportView(txtdetalles);
    
    // Configuración de tamaño para el botón
    jButton3.setBackground(new java.awt.Color(177, 11, 11));
    jButton3.setForeground(new java.awt.Color(255, 255, 255));
    jButton3.setText("Volver");
    jButton3.setMinimumSize(new java.awt.Dimension(100, 40)); // Tamaño mínimo
    jButton3.setPreferredSize(new java.awt.Dimension(120, 50)); // Tamaño preferido
    jButton3.setMaximumSize(new java.awt.Dimension(150, 60)); // Tamaño máximo
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    jLabel6.setText("Perdidas");

    Perdidas.setText("Cantidad");

    // El resto del código del layout sigue igual
    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(102, 102, 102)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Perdidas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(349, 349, 349)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))) // Usar el tamaño preferido aquí
            .addContainerGap(102, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel4)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(9, 9, 9)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(Perdidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(57, 57, 57)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // Usar el tamaño preferido aquí
            .addGap(0, 92, Short.MAX_VALUE))
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
            // Validar que los detalles del reporte no estén vacíos
            validarCamposReporte();

            // Establecer los detalles del reporte
            reporte.setDetalles(txtdetalles.getText());
            
            reporte.setFecha(LocalDate.now());

            // Generar y establecer un código único para el reporte
            reporte.setCodigo(prcdb.ListarReportes().size() + 1);

            // Registrar el reporte en la base de datos
            prcdb.RegistrarReporte(reporte);

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
            // Validar que los campos del producto no estén vacíos y que la cantidad sea válida
            validarCamposProducto();

            // Buscar el producto en la base de datos por nombre o código
            producto producto = pcdb.buscadoListarProductos(txtProductos.getSelectedItem().toString(), txtcodigo.getText());

            // Establecer el producto y su cantidad en el reporte
            reporte.setProductos(producto, Integer.valueOf(txtcantidad.getText()));

            // Refrescar la tabla de productos en la interfaz
            refrescarTablaProductos(reporte.getProductos());

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(inicio, e.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(inicio, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductosActionPerformed
    // Método para refrescar la tabla de productos agregados en el reporte
    public void refrescarTablaProductos(ArrayList<producto> productos) {
        modelo.setRowCount(0); // Limpia la tabla antes de actualizarla
        Integer i = 0;
        for (producto p : productos){
            Object[] fila = {
                p.getCodigo(),
                p.getNombre(),
                reporte.getCantidad(i)
            };
            modelo.addRow(fila);
            i++;
        }
    }

    // Método para actualizar la lista de productos en el JComboBox
    public void actualizarProductos() {
        try {
            ArrayList<producto> listaProducts = pcdb.ListarProductos();

            // Limpiar el contenido actual del JComboBox
            txtProductos.removeAllItems();

            // Agregar cada nombre de producto al JComboBox
            for (producto p : listaProducts) {
                txtProductos.addItem(p.getNombre());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(inicio, "Error al actualizar los productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para validar que todos los campos del reporte estén completos
    private void validarCamposReporte() {
        if (txtdetalles.getText().isEmpty()) {
            throw new IllegalArgumentException("El campo de detalles es obligatorio. Por favor, complete la información.");
        }
    }

    // Método para validar que todos los campos de un producto estén completos y sean válidos
    private void validarCamposProducto() {
        if (txtProductos.getSelectedItem() == null || txtcodigo.getText().isEmpty() || txtcantidad.getText().isEmpty()) {
            throw new IllegalArgumentException("Todos los campos del producto son obligatorios. Por favor, complete la información.");
        }

        // Validar que la cantidad sea un número entero
        try {
            Integer.valueOf(txtcantidad.getText());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La cantidad debe ser un número entero válido.");
        }
    }
    
    public void Mostrarreporte(reportes t) {
     if (t == null) {
         JOptionPane.showMessageDialog(inicio, "El reporte es nulo", "Error", JOptionPane.ERROR_MESSAGE);
         return;
     }

     // Mostrar detalles
     txtdetalles.setText(t.getDetalles());

     // Mostrar fecha (asegúrate de tener un componente adecuado para mostrar la fecha)
     // Si txtcantidad no es el componente correcto para mostrar la fecha, usa un componente adecuado.
     txtcantidad.setText(t.getFecha().toString()); // Suponiendo que txtcantidad es un JTextField

     Double perdida = 0.0;
     Integer i = 0;
     for (producto pdxz : t.getProductos()) {
         if (pdxz != null) {
             Integer cantidad = t.getCantidad(i);
             if (cantidad != null) {
                 perdida += (pdxz.getPrecio_entrada() * cantidad);
             }
         }
         i++;
     }
     Perdidas.setText(perdida.toString());

     // Si tienes un componente para mostrar la pérdida, actualízalo aquí
     // Ejemplo: txtPerdida.setText(String.valueOf(perdida));
 }
    private javax.swing.JTextField Perdidas;
    private javax.swing.JLabel jLabel6;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaProductos;
    private javax.swing.JComboBox<String> txtProductos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextArea txtdetalles;
    // End of variables declaration//GEN-END:variables
}
