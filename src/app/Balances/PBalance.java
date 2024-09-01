package app.Balances;

import app.datos.balance;
import app.bd_conexion.*;
import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class PBalance extends javax.swing.JPanel {
    balance_cbd bcdb = new balance_cbd();
    public PBalance() {
        initComponents();
         configurarListaBalance(bcdb.listarBalances());
         txtUtilidad.setText(bcdb.utilidad(bcdb.listarBalances()).toString());
         Saldo(bcdb.utilidad(bcdb.listarBalances()));
         agregaraño();
    }
    private void configurarListaBalance(ArrayList<balance> balancess) {
    ArrayList<balance> balances = balancess;

    // Convertir la lista a un DefaultListModel para el JList
    DefaultListModel<balance> balanceListModel = new DefaultListModel<>();
    for (balance b : balances) {
        balanceListModel.addElement(b);
    }

    // Crear el JList con el DefaultListModel
    txtBalance = new JList<>(balanceListModel);

    // Establecer el renderer personalizado
    txtBalance.setCellRenderer(new BalanceRenderer());

    // Añadir el JList a un JScrollPane existente
    jScrollPane3.setViewportView(txtBalance);
}
    private void Saldo (Double d){
        if(d == 0){
            txtsaldo.setText("No hay saldo");
            txtsaldo.setForeground(Color.black);
        }else if(d < 0 ){
            txtsaldo.setText("Saldo negativo");
            txtsaldo.setForeground(Color.red);
        }else if(d > 0 ){
            txtsaldo.setText("Saldo positivo");
            txtsaldo.setForeground(Color.GREEN);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBalance = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        txtsaldo = new javax.swing.JLabel();
        txtaño = new javax.swing.JComboBox<>();
        txtmes = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(750, 400));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("La utilidad total es de:");

        txtUtilidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUtilidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUtilidad.setText("a");

        txtBalance.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        txtBalance.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        txtBalance.setCellRenderer(null);
        jScrollPane3.setViewportView(txtBalance);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Balance");

        txtsaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtsaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtsaldo.setText("a");

        txtaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtañoActionPerformed(evt);
            }
        });

        txtmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jButton1.setBackground(new java.awt.Color(117, 11, 11));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUtilidad)
                        .addGap(166, 166, 166)
                        .addComponent(txtsaldo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel4)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUtilidad)
                    .addComponent(txtsaldo))
                .addGap(30, 30, 30))
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

    private void txtañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtañoActionPerformed
        actualizarMeses();
    }//GEN-LAST:event_txtañoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Integer año = Integer.valueOf(txtaño.getSelectedItem().toString());
        
        Integer mes = mesNumero(txtmes.getSelectedItem().toString());
        
        configurarListaBalance(bcdb.listarBalances(año, mes));
         txtUtilidad.setText(bcdb.utilidad(bcdb.listarBalances(año, mes)).toString());
         Saldo(bcdb.utilidad(bcdb.listarBalances(año, mes)));
    }//GEN-LAST:event_jButton1ActionPerformed
    private void agregaraño(){
        Integer año = 2024;
       
        
        // Formatear la fecha
        Integer añoactual = LocalDate.now().getYear();
        
        
        if(año <= añoactual){
            Integer diferencia = añoactual - año;
            txtaño.removeAllItems();
            for(Integer i = 0; i <= diferencia;i ++){
                txtaño.addItem(String.valueOf(año));
                año += 1;
            }
        }
        
    }
     // Método para actualizar los meses según el año seleccionado
    private void actualizarMeses() {
        String añoSeleccionado = (String) txtaño.getSelectedItem();
        if (añoSeleccionado != null) {
            int año = Integer.parseInt(añoSeleccionado);
            int mesActual = LocalDate.now().getMonthValue(); // Obtener el mes actual
            
            // Limpiar el JComboBox de los meses
            txtmes.removeAllItems();

            // Agregar solo los meses que han pasado hasta la fecha actual si es el año presente
            for (int i = 1; i <= (año == LocalDate.now().getYear() ? mesActual : 12); i++) {
                if(año == 2024){
                    if(i >= 7){
                        txtmes.addItem(mesNombre(i));
                    }
                }else{
                    txtmes.addItem(mesNombre(i));
                }
            }
        }
    }

    // Método auxiliar para convertir el número del mes en su nombre
    private String mesNombre(int mes) {
        switch (mes) {
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "";
        }
    }
    private Integer mesNumero(String mes) {
        switch (mes) {
            case "Enero": return 1;
            case "Febrero": return 2;
            case "Marzo": return 3;
            case "Abril": return 4;
            case "Mayo": return 5;
            case "Junio": return 6;
            case "Julio": return 7;
            case "Agosto": return 8;
            case"Septiembre": return 9;
            case "Octubre": return 10;
            case "Noviembre": return 11;
            case "Diciembre": return 12;
            default: return 0;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList txtBalance;
    private javax.swing.JLabel txtUtilidad;
    private javax.swing.JComboBox<String> txtaño;
    private javax.swing.JComboBox<String> txtmes;
    private javax.swing.JLabel txtsaldo;
    // End of variables declaration//GEN-END:variables
}
