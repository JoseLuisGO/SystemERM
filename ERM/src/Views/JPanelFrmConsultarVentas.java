/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import static Views.FrmConsultaCliente.Comprueba;
import DAO.DAO_Venta;
import java.awt.CardLayout;
import java.awt.Component;
import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose_Gonzalez
 */
public class JPanelFrmConsultarVentas extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFrmConsultarVentas
     */
    CardLayout card;
    
    public JPanelFrmConsultarVentas() {
        initComponents();
        
        cambiarColorBtn(jPanelvENTA, btnVenta);
        
        card = (CardLayout) FrmPrincipal.jPanelBranch.getLayout();
        
        mostrar();
        
        txtTotal_venta.setEditable(false);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        txtCod_venta.setEditable(false);
        txtActivaCliente.setVisible(false);
        txtNombre_cliente.setEditable(false);
        txtComprobante.setEditable(false);

        jTabla.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                 l.setBackground(new java.awt.Color(255, 255, 255));
                l.setForeground(new java.awt.Color(0, 0, 0));
                l.setFont(new java.awt.Font("Dialog", 3, 14));
                return l;
            }
        });
    }
    
    public void mostrar() {
        txtCod_cliente.setVisible(false);
        txtCod_usuario.setVisible(false);
        try {
            DefaultTableModel modelo;
            DAO_Venta funcion = new DAO_Venta();
            modelo = funcion.mostrar();

            jTabla.setModel(modelo);

            lblTotalRegistros.setText("Total Registros " + Integer.toString(funcion.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ocultar_columnas();
    }

    public void Buscar(String buscar) {
        try {
            DefaultTableModel modelo;
            DAO_Venta funcion = new DAO_Venta();
            modelo = funcion.Buscar(buscar);

            jTabla.setModel(modelo);

            lblTotalRegistros.setText("Total Registros " + Integer.toString(funcion.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ocultar_columnas();
    }

    public void ocultar_columnas() {
        jTabla.getColumnModel().getColumn(3).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(3).setMinWidth(0);
        jTabla.getColumnModel().getColumn(3).setPreferredWidth(0);

        jTabla.getColumnModel().getColumn(5).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(5).setMinWidth(0);
        jTabla.getColumnModel().getColumn(5).setPreferredWidth(0);
    }

    public void limpiar() {
        txtCod_cliente.setText("");
        txtCod_usuario.setText("");
        txtNombre_cliente.setText("");
        txtCod_venta.setText("");
        txtTotal_venta.setText("");
        txtComprobante.setText("");
        txtBuscar.setText("");
    }
    
    public void cambiarColorBtn(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
        btn.setForeground(new java.awt.Color(255, 50, 0));
    }
    
    public void cambiarColorLinea(JPanel panel) {
        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBackground(new java.awt.Color(255, 50, 0));
    }
    
    public void cambiarColorLineaDefecto() {
        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
    }
    
    public void cambiarPanelContenedorBranch(JPanel panel, String name) {
        FrmPrincipal.jPanelBranch.add(panel, name);
        card.show(FrmPrincipal.jPanelBranch, name);
    }
    
    public void cambiarColorMenu(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
        btn.setForeground(new java.awt.Color(0, 0, 0));
    }
    
    public void cambiarColorMenuDefecto(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(0, 0, 0));
        btn.setForeground(new java.awt.Color(255, 255, 255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre_usuario = new javax.swing.JLabel();
        txtCod_usuario = new javax.swing.JTextField();
        txtCod_cliente = new javax.swing.JTextField();
        txtActivaCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCod_venta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre_cliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotal_venta = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        txtComprobante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNum_factura = new javax.swing.JTextField();
        dcFecha_venta = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        lineaBusqueda = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanelvENTA = new javax.swing.JPanel();
        btnVenta = new javax.swing.JLabel();
        jPanelDolar = new javax.swing.JPanel();
        btnDolar = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 65)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENTAS REGISTRADAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 29, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USUARIO DE VENTA :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 29, -1, -1));

        txtNombre_usuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtNombre_usuario.setText("nombre");
        jPanel2.add(txtNombre_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 29, 188, -1));
        jPanel2.add(txtCod_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 27, 15, -1));
        jPanel2.add(txtCod_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 27, -1, -1));

        txtActivaCliente.setText("1");
        jPanel2.add(txtActivaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 27, 15, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Código Venta :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 11, 100, 30));

        txtCod_venta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCod_venta.setText(" ");
        txtCod_venta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtCod_venta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtCod_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 233, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 13, 60, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Cliente :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, 30));

        txtNombre_cliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombre_cliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtNombre_cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtNombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 164, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 61, 60, -1));

        txtTotal_venta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtTotal_venta.setText("0");
        txtTotal_venta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtTotal_venta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotal_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotal_ventaKeyTyped(evt);
            }
        });
        jPanel4.add(txtTotal_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 245, 30));

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(57, 30));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 64, -1));

        txtComprobante.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtComprobante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtComprobante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 233, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setText("Comprobante :");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setText("Numero :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, 30));

        txtNum_factura.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNum_factura.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtNum_factura.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtNum_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 245, 30));

        dcFecha_venta.setBackground(new java.awt.Color(36, 33, 33));
        dcFecha_venta.setForeground(new java.awt.Color(207, 207, 207));
        dcFecha_venta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jPanel4.add(dcFecha_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 245, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 790, 160));

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
        jTabla.setRowHeight(20);
        jTabla.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTabla.setSelectionForeground(new java.awt.Color(0, 102, 102));
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 270, 790, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(65, 139, 66));
        jLabel7.setText("Nombre Cliente :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 8, -1, 30));

        txtBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        jPanel3.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 360, 30));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, 30));

        lblTotalRegistros.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblTotalRegistros.setForeground(new java.awt.Color(65, 139, 66));
        lblTotalRegistros.setText("TOTAL REGISTROS");
        jPanel3.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 137, 30));

        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda.setPreferredSize(new java.awt.Dimension(360, 2));

        javax.swing.GroupLayout lineaBusquedaLayout = new javax.swing.GroupLayout(lineaBusqueda);
        lineaBusqueda.setLayout(lineaBusquedaLayout);
        lineaBusquedaLayout.setHorizontalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        lineaBusquedaLayout.setVerticalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.add(lineaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 790, 50));

        jPanel1.setBackground(new java.awt.Color(65, 139, 66));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 305));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 830, 610));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelvENTA.setBackground(new java.awt.Color(0, 0, 0));
        jPanelvENTA.setPreferredSize(new java.awt.Dimension(130, 50));

        btnVenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVenta.setText("Herramientas de venta");
        btnVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelvENTALayout = new javax.swing.GroupLayout(jPanelvENTA);
        jPanelvENTA.setLayout(jPanelvENTALayout);
        jPanelvENTALayout.setHorizontalGroup(
            jPanelvENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelvENTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelvENTALayout.setVerticalGroup(
            jPanelvENTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelvENTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanelvENTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        jPanelDolar.setBackground(new java.awt.Color(0, 0, 0));

        btnDolar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnDolar.setForeground(new java.awt.Color(255, 255, 255));
        btnDolar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDolar.setText("Actualizar Costo Dolar");
        btnDolar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDolarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDolarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDolarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelDolarLayout = new javax.swing.GroupLayout(jPanelDolar);
        jPanelDolar.setLayout(jPanelDolarLayout);
        jPanelDolarLayout.setHorizontalGroup(
            jPanelDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDolarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDolar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDolarLayout.setVerticalGroup(
            jPanelDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDolarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDolar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanelDolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 170, 50));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotal_ventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal_ventaKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)
            && (c != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTotal_ventaKeyTyped

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed

        FrmConsultaCliente form = new FrmConsultaCliente();
        Comprueba = 1;
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked

        /*btnEliminar.setEnabled(true);
        btnEditar.setEnabled(true);*/

        int fila = jTabla.rowAtPoint(evt.getPoint());

        txtCod_venta.setText(jTabla.getValueAt(fila, 0).toString());
        dcFecha_venta.setDate(Date.valueOf(jTabla.getValueAt(fila, 1).toString()));
        txtTotal_venta.setText(jTabla.getValueAt(fila, 2).toString());

        txtCod_usuario.setText(jTabla.getValueAt(fila, 3).toString());
        txtNombre_usuario.setText(jTabla.getValueAt(fila, 4).toString());

        txtCod_cliente.setText(jTabla.getValueAt(fila, 5).toString());
        txtNombre_cliente.setText(jTabla.getValueAt(fila, 6).toString());
        txtComprobante.setText(jTabla.getValueAt(fila, 7).toString());
        txtNum_factura.setText(jTabla.getValueAt(fila, 8).toString());

    }//GEN-LAST:event_jTablaMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        cambiarColorLinea(lineaBusqueda);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtBuscarFocusLost

    private void btnVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseClicked
        
    }//GEN-LAST:event_btnVentaMouseClicked

    private void btnVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseEntered
        
    }//GEN-LAST:event_btnVentaMouseEntered

    private void btnVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseExited
        
    }//GEN-LAST:event_btnVentaMouseExited

    private void btnDolarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDolarMouseClicked
        JPanelFrmDolar panel = new JPanelFrmDolar();
        cambiarPanelContenedorBranch(panel, "Dolar");
    }//GEN-LAST:event_btnDolarMouseClicked

    private void btnDolarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDolarMouseEntered
        cambiarColorMenu(jPanelDolar, btnDolar);
    }//GEN-LAST:event_btnDolarMouseEntered

    private void btnDolarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDolarMouseExited
        cambiarColorMenuDefecto(jPanelDolar, btnDolar);
    }//GEN-LAST:event_btnDolarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JLabel btnDolar;
    private javax.swing.JLabel btnVenta;
    private com.toedter.calendar.JDateChooser dcFecha_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelDolar;
    private javax.swing.JPanel jPanelvENTA;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JPanel lineaBusqueda;
    public static javax.swing.JTextField txtActivaCliente;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtCod_cliente;
    private javax.swing.JTextField txtCod_usuario;
    public static javax.swing.JTextField txtCod_venta;
    private javax.swing.JTextField txtComprobante;
    public static javax.swing.JTextField txtNombre_cliente;
    private javax.swing.JLabel txtNombre_usuario;
    private javax.swing.JTextField txtNum_factura;
    private javax.swing.JTextField txtTotal_venta;
    // End of variables declaration//GEN-END:variables
}
