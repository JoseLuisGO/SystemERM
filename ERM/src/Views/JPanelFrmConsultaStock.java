/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.DAO_Producto;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose_Gonzalez
 */
public class JPanelFrmConsultaStock extends javax.swing.JPanel {
static boolean desactivarProductos;
    /**
     * Creates new form JPanelFrmConsultaStock
     */
    CardLayout card;
    
    public JPanelFrmConsultaStock() {
        initComponents();
        
        card = (CardLayout) FrmPrincipal.jPanelBranch.getLayout();
        cambiarColorBtn(jPanelStock, btnStock);
        
        mostrar("");
        ocultar_columnasPrincipal();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
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
    
    public void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            DAO_Producto funcion = new DAO_Producto();
            modelo = funcion.mostrar(buscar);
            jTabla.setModel(modelo);
            if (desactivarProductos) {
                ocultar_columnas();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cambiarColorBtn(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(204, 204, 204));
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
        panel.setBackground(new java.awt.Color(102, 102, 102));
        btn.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    public void cambiarColorMenuDefecto(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
        btn.setForeground(new java.awt.Color(0, 0, 0));
    }
    
    public void ocultar_columnas() {
        jTabla.getColumnModel().getColumn(1).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(1).setMinWidth(0);
        jTabla.getColumnModel().getColumn(1).setPreferredWidth(0);
        jTabla.getColumnModel().getColumn(8).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(8).setMinWidth(0);
        jTabla.getColumnModel().getColumn(8).setPreferredWidth(0);
        jTabla.getColumnModel().getColumn(9).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(9).setMinWidth(0);
        jTabla.getColumnModel().getColumn(9).setPreferredWidth(0);
    }
    
    public void ocultar_columnasPrincipal() {
        jTabla.getColumnModel().getColumn(8).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(8).setMinWidth(0);
        jTabla.getColumnModel().getColumn(8).setPreferredWidth(0);
        jTabla.getColumnModel().getColumn(9).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(9).setMinWidth(0);
        jTabla.getColumnModel().getColumn(9).setPreferredWidth(0);
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
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lineaBusqueda = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanelProductos = new javax.swing.JPanel();
        btnProductos = new javax.swing.JLabel();
        jPanelEntradaSalida = new javax.swing.JPanel();
        btnEntradaSalida = new javax.swing.JLabel();
        jPanelUbicacion = new javax.swing.JPanel();
        btnUbicacion = new javax.swing.JLabel();
        jPanelStock = new javax.swing.JPanel();
        btnStock = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GESTIÓN DE STOCK DE PRODUCTOS");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBuscar.setPreferredSize(new java.awt.Dimension(2, 33));
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel6.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 360, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(25, 118, 210));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnBuscar.setText(" ");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 110, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(65, 139, 66));
        jLabel20.setText("Nombre de Pieza :");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 126, 33));

        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaBusquedaLayout = new javax.swing.GroupLayout(lineaBusqueda);
        lineaBusqueda.setLayout(lineaBusquedaLayout);
        lineaBusquedaLayout.setHorizontalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        lineaBusquedaLayout.setVerticalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(lineaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 33, 360, 2));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 780, 40));

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 790, 440));

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

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelProductos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductos.setPreferredSize(new java.awt.Dimension(130, 50));

        btnProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProductos.setText("Productos");
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMenu.add(jPanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jPanelEntradaSalida.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEntradaSalida.setPreferredSize(new java.awt.Dimension(130, 50));

        btnEntradaSalida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEntradaSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEntradaSalida.setText("Entrada/Salida");
        btnEntradaSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntradaSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntradaSalidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntradaSalidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntradaSalidaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelEntradaSalidaLayout = new javax.swing.GroupLayout(jPanelEntradaSalida);
        jPanelEntradaSalida.setLayout(jPanelEntradaSalidaLayout);
        jPanelEntradaSalidaLayout.setHorizontalGroup(
            jPanelEntradaSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEntradaSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEntradaSalida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEntradaSalidaLayout.setVerticalGroup(
            jPanelEntradaSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEntradaSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEntradaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMenu.add(jPanelEntradaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 120, 50));

        jPanelUbicacion.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUbicacion.setPreferredSize(new java.awt.Dimension(130, 50));

        btnUbicacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnUbicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUbicacion.setText("Ubicación");
        btnUbicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbicacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbicacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbicacionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelUbicacionLayout = new javax.swing.GroupLayout(jPanelUbicacion);
        jPanelUbicacion.setLayout(jPanelUbicacionLayout);
        jPanelUbicacionLayout.setHorizontalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelUbicacionLayout.setVerticalGroup(
            jPanelUbicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUbicacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUbicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMenu.add(jPanelUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jPanelStock.setBackground(new java.awt.Color(255, 255, 255));
        jPanelStock.setPreferredSize(new java.awt.Dimension(130, 50));

        btnStock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnStock.setText("Stock");
        btnStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStockMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelStockLayout = new javax.swing.GroupLayout(jPanelStock);
        jPanelStock.setLayout(jPanelStockLayout);
        jPanelStockLayout.setHorizontalGroup(
            jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStock, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelStockLayout.setVerticalGroup(
            jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMenu.add(jPanelStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 50));

        add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked

    }//GEN-LAST:event_jTablaMouseClicked

    private void jTablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMousePressed

    }//GEN-LAST:event_jTablaMousePressed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEntradaSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaSalidaMouseClicked
        if (desactivarProductos) {
            
        } else {
            JPanelFrmStock panel = new JPanelFrmStock();
            cambiarPanelContenedorBranch(panel, "EntradaSalida");
        }
    }//GEN-LAST:event_btnEntradaSalidaMouseClicked

    private void btnEntradaSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaSalidaMouseEntered
        if (desactivarProductos) {
            
        } else {
            cambiarColorMenu(jPanelEntradaSalida, btnEntradaSalida);
        }
    }//GEN-LAST:event_btnEntradaSalidaMouseEntered

    private void btnEntradaSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaSalidaMouseExited
        if (desactivarProductos) {
            
        } else {
            cambiarColorMenuDefecto(jPanelEntradaSalida, btnEntradaSalida);
        }
    }//GEN-LAST:event_btnEntradaSalidaMouseExited

    private void btnUbicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseClicked
        if (desactivarProductos) {
            
        } else {
            JPanelFrmAlmacen panel = new JPanelFrmAlmacen();
            cambiarPanelContenedorBranch(panel, "Almacen");
        }
    }//GEN-LAST:event_btnUbicacionMouseClicked

    private void btnUbicacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseEntered
        if (desactivarProductos) {
            
        } else {
            cambiarColorMenu(jPanelUbicacion, btnUbicacion);
        }
    }//GEN-LAST:event_btnUbicacionMouseEntered

    private void btnUbicacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseExited
        if (desactivarProductos) {
            
        } else {
            cambiarColorMenuDefecto(jPanelUbicacion, btnUbicacion);
        }
    }//GEN-LAST:event_btnUbicacionMouseExited

    private void btnStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStockMouseClicked

    private void btnStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseEntered
        
    }//GEN-LAST:event_btnStockMouseEntered

    private void btnStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseExited
        
    }//GEN-LAST:event_btnStockMouseExited

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        cambiarColorLinea(lineaBusqueda);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtBuscarFocusLost

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        if (desactivarProductos) {
            
        } else {
            JPanelFrmProductos panel = new JPanelFrmProductos();
            cambiarPanelContenedorBranch(panel, "Productos");
        }
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseEntered
        if (desactivarProductos) {
            
        } else {
            cambiarColorMenu(jPanelProductos, btnProductos);
        }
    }//GEN-LAST:event_btnProductosMouseEntered

    private void btnProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseExited
        if (desactivarProductos) {
            
        } else {
            cambiarColorMenuDefecto(jPanelProductos, btnProductos);
        }
    }//GEN-LAST:event_btnProductosMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnEntradaSalida;
    private javax.swing.JLabel btnProductos;
    private javax.swing.JLabel btnStock;
    private javax.swing.JLabel btnUbicacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelEntradaSalida;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelStock;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JPanel lineaBusqueda;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
