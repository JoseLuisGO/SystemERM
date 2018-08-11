/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import DAO.DAO_Configuracion;
import Model.Configuracion;
import java.awt.CardLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Jose_Gonzalez
 */
public class JPanelFrmDolar extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFrmDolar
     */
    CardLayout card;
    
    public JPanelFrmDolar() {
        initComponents();
        
        cambiarColorBtn(jPanelDolar, btnDolar);
        
        card = (CardLayout) FrmPrincipal.jPanelBranch.getLayout();
        
        txtAnterior.setEnabled(false);
        txtAnterior.setForeground(new java.awt.Color(255, 255, 255));
        valorAnterior();
    }
    
    public void valorAnterior() {
        DAO_Configuracion funcion = new DAO_Configuracion();
        float dolar = funcion.getValueDollar();
        txtAnterior.setText(""+dolar);
    }
    
    public void cambiarColorBtn(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
        btn.setForeground(new java.awt.Color(255, 50, 0));
    }
    
    public void cambiarColorLinea(JPanel panel) {
        lineaAnterior.setBackground(new java.awt.Color(153, 153, 153));
        lineaNueva.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBackground(new java.awt.Color(255, 50, 0));
    }
    
    public void cambiarColorLineaDefecto() {
        lineaAnterior.setBackground(new java.awt.Color(153, 153, 153));
        lineaNueva.setBackground(new java.awt.Color(153, 153, 153));
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

        jPanel5 = new javax.swing.JPanel();
        jPanelvENTA = new javax.swing.JPanel();
        btnVenta = new javax.swing.JLabel();
        jPanelDolar = new javax.swing.JPanel();
        btnDolar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtAnterior = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNuevo = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        lineaAnterior = new javax.swing.JPanel();
        lineaNueva = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(65, 139, 66));
        jLabel10.setText("Actualizar costo del Dolar");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("Costo Nuevo:        $");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 130, 30));

        txtAnterior.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtAnterior.setBorder(null);
        txtAnterior.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 160, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Costo Anterior:    $");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 120, 30));

        txtNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNuevo.setBorder(null);
        txtNuevo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNuevoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNuevoFocusLost(evt);
            }
        });
        jPanel1.add(txtNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 160, 30));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/acceso.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        lineaAnterior.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaAnteriorLayout = new javax.swing.GroupLayout(lineaAnterior);
        lineaAnterior.setLayout(lineaAnteriorLayout);
        lineaAnteriorLayout.setHorizontalGroup(
            lineaAnteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        lineaAnteriorLayout.setVerticalGroup(
            lineaAnteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(lineaAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 160, 2));

        lineaNueva.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaNuevaLayout = new javax.swing.GroupLayout(lineaNueva);
        lineaNueva.setLayout(lineaNuevaLayout);
        lineaNuevaLayout.setHorizontalGroup(
            lineaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        lineaNuevaLayout.setVerticalGroup(
            lineaNuevaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(lineaNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 830, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        DAO_Configuracion funcion = new DAO_Configuracion();
        try {
            MaskFormatter format = new MaskFormatter("##.##");
            JFormattedTextField txt = new JFormattedTextField(format);
            txt.setValue(new Float(txtNuevo.getText()));

            float nuevo = (float) txt.getValue();

            Configuracion conf = new Configuracion();
            conf.setValorDolar(nuevo);

            if (funcion.updateValueDollar(conf)) {
                JOptionPane.showMessageDialog(null, "Valor del Dolar Actualizado");
                valorAnterior();;
                txtNuevo.setText("");
            }
        } catch (Exception e) {
            System.err.println("Error:" + e);
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el valor");
            txtNuevo.setText("");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseClicked
        JPanelFrmConsultarVentas panel = new JPanelFrmConsultarVentas();
        cambiarPanelContenedorBranch(panel, "ConsultarVentas");
    }//GEN-LAST:event_btnVentaMouseClicked

    private void btnVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseEntered
        cambiarColorMenu(jPanelvENTA, btnVenta);
    }//GEN-LAST:event_btnVentaMouseEntered

    private void btnVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentaMouseExited
        cambiarColorMenuDefecto(jPanelvENTA, btnVenta);
    }//GEN-LAST:event_btnVentaMouseExited

    private void btnDolarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDolarMouseClicked
        
    }//GEN-LAST:event_btnDolarMouseClicked

    private void btnDolarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDolarMouseEntered
        
    }//GEN-LAST:event_btnDolarMouseEntered

    private void btnDolarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDolarMouseExited
        
    }//GEN-LAST:event_btnDolarMouseExited

    private void txtNuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNuevoFocusGained
        cambiarColorLinea(lineaNueva);
    }//GEN-LAST:event_txtNuevoFocusGained

    private void txtNuevoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNuevoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtNuevoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel btnDolar;
    private javax.swing.JLabel btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelDolar;
    private javax.swing.JPanel jPanelvENTA;
    private javax.swing.JPanel lineaAnterior;
    private javax.swing.JPanel lineaNueva;
    private javax.swing.JTextField txtAnterior;
    private javax.swing.JTextField txtNuevo;
    // End of variables declaration//GEN-END:variables
}