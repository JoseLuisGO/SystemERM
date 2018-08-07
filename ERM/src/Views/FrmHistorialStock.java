package Views;

import Model.HistorialStock;
import Model.Producto;
import DAO.DAO_HistorialStock;
import DAO.DAO_Producto;
import java.awt.Component;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FrmHistorialStock extends javax.swing.JInternalFrame {

    public FrmHistorialStock() {
        initComponents();
        jrbAumentar.setSelected(true);
        this.setLocation(500, 100);
        this.setMaximizable(false);
        this.setResizable(false);
        txtUsu.setVisible(false);
        dcFecha.setVisible(false);
        txtCod_Producto.setEditable(false);
        txtProveedor.setEditable(false);
        txtPrecio.setEditable(false);
        txtExistencia.setEditable(false);
        Calendar c2 = new GregorianCalendar();
        dcFecha.setCalendar(c2);
                
        jTabla.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                l.setBackground(new java.awt.Color(255, 255, 255));
                l.setForeground(new java.awt.Color(0, 0, 0));
                l.setFont(new java.awt.Font("Cambria", 3, 14));
                return l;
            }
        });
    }

    public void mostrar(String id) {
        try {
            DefaultTableModel modelo;
            DAO_HistorialStock funcion = new DAO_HistorialStock();
            modelo = funcion.Mostrar(id);
            jTabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al agregar stock.");
        }
    }

    public void habilitar() {
        btnAceptarValores.setEnabled(true);
        txtValor.setEditable(true);
        txtPrecio.setText("");
        txtExistencia.setText("");
        txtValor.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        dcFecha_venta = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jrbAumentar = new javax.swing.JRadioButton();
        jrbDisminuir = new javax.swing.JRadioButton();
        txtValor = new javax.swing.JTextField();
        btnAceptarValores = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCod_Producto = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUsu = new javax.swing.JTextField();
        dcFecha = new com.toedter.calendar.JDateChooser();

        dcFecha_venta.setBackground(new java.awt.Color(36, 33, 33));
        dcFecha_venta.setForeground(new java.awt.Color(207, 207, 207));
        dcFecha_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setVisible(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(25, 118, 210));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jTabla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jTabla.setGridColor(new java.awt.Color(204, 204, 204));
        jTabla.setRowHeight(20);
        jTabla.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTabla.setSelectionForeground(new java.awt.Color(0, 102, 0));
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTabla);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jrbAumentar.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(jrbAumentar);
        jrbAumentar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jrbAumentar.setForeground(new java.awt.Color(25, 118, 210));
        jrbAumentar.setText("Agregar");

        jrbDisminuir.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(jrbDisminuir);
        jrbDisminuir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jrbDisminuir.setForeground(new java.awt.Color(25, 118, 210));
        jrbDisminuir.setText("Disminuir");

        txtValor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtValor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        btnAceptarValores.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptarValores.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAceptarValores.setForeground(new java.awt.Color(25, 118, 210));
        btnAceptarValores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/guardar.png"))); // NOI18N
        btnAceptarValores.setText("Guardar");
        btnAceptarValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarValoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbAumentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbDisminuir, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValor)
                .addGap(18, 18, 18)
                .addComponent(btnAceptarValores, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptarValores))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jrbAumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jrbDisminuir, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 118, 210));
        jLabel4.setText("Codigo :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 118, 210));
        jLabel2.setText("Proveedor :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(25, 118, 210));
        jLabel7.setText("Existencia :");

        txtCod_Producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCod_Producto.setText(" ");
        txtCod_Producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtCod_Producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtProveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtProveedor.setText(" ");
        txtProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtProveedor.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtPrecio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtExistencia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtExistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtExistencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(25, 118, 210));
        jLabel6.setText("Precio Venta :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCod_Producto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 118, 210));
        jLabel10.setText("STOCK DE PRODUCTOS");

        txtUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuActionPerformed(evt);
            }
        });

        dcFecha.setBackground(new java.awt.Color(36, 33, 33));
        dcFecha.setForeground(new java.awt.Color(207, 207, 207));
        dcFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(txtUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel10)
                .addGap(71, 71, 71)
                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMousePressed
        
    }//GEN-LAST:event_jTablaMousePressed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked

    }//GEN-LAST:event_jTablaMouseClicked

    private void btnAceptarValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarValoresActionPerformed
        
        if (txtValor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar el valor a agregar.");
            txtValor.requestFocus();
            return;
        }
        
        Producto datos = new Producto();
        DAO_Producto funcion = new DAO_Producto();
        int valor = 0;
        int stock;
        
        datos.setCod_Producto(txtCod_Producto.getText());
        stock = Integer.parseInt(txtExistencia.getText());
        valor = Integer.parseInt(txtValor.getText());
        
        HistorialStock datos2 = new HistorialStock();
        DAO_HistorialStock funcion2 = new DAO_HistorialStock();
        datos2.setCod_ProductoFK(txtCod_Producto.getText());
        datos2.setId_UsuarioFK(Integer.parseInt(txtUsu.getText()));
        
        Calendar cal;
        int d, m, a;
        cal = dcFecha.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        datos2.setFecha(new Date(a,m,d));
        
        datos2.setReferencia(JOptionPane.showInputDialog("Ingrese una referencia."));
        if (jrbAumentar.isSelected() == true) {
            datos2.setDescripcion("Agrego producto al stock.");
        } else {
            datos2.setDescripcion("Resto producto al stock.");
        }
        if (jrbDisminuir.isSelected() == true) {
            if (stock < valor) {
                JOptionPane.showMessageDialog(null, "Valor supera stock. ");
                txtValor.setText("");
                txtValor.requestFocus();
                return;
            }
        }

        datos2.setCantidad_Nva(Integer.parseInt(txtValor.getText()));
        if (funcion2.insertar(datos2)) {

            if (jrbAumentar.isSelected() == true) {
                stock = stock + valor;

                datos.setExistencia(stock);

                funcion.ModificarStockProductos(datos);
                JOptionPane.showMessageDialog(null, "Stock total del producto : " + stock);
                txtExistencia.setText(String.valueOf(stock));
            }

            if (jrbDisminuir.isSelected() == true) {
                if (stock >= valor) {
                    stock = stock - valor;
                    datos.setExistencia(stock);
                    funcion.ModificarStockProductos(datos);
                    JOptionPane.showMessageDialog(null, "Stock total del producto : " + stock);
                    txtExistencia.setText(String.valueOf(stock));
                }
            }
            txtValor.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No se ingresaron datos al stock.");
        }
        mostrar(txtCod_Producto.getText());        
    }//GEN-LAST:event_btnAceptarValoresActionPerformed

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyPressed
    }//GEN-LAST:event_txtValorKeyPressed

    private void txtUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHistorialStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarValores;
    private javax.swing.ButtonGroup btnGroup;
    private com.toedter.calendar.JDateChooser dcFecha;
    private com.toedter.calendar.JDateChooser dcFecha_venta;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JRadioButton jrbAumentar;
    private javax.swing.JRadioButton jrbDisminuir;
    public javax.swing.JTextField txtCod_Producto;
    public javax.swing.JTextField txtExistencia;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtProveedor;
    public javax.swing.JTextField txtUsu;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}