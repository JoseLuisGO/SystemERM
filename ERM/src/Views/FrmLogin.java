package Views;

import DAO.DAO_Usuario;
import Model.Usuario;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        contarUsuarios();

        jScrollPane1.setVisible(false);
        this.setLocationRelativeTo(null);
        btnIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                btnIngresarMouseClicked(null);
            }
        });
    }

    int x, y;

    public void contarUsuarios() {
        DAO_Usuario funcion = new DAO_Usuario();
        int cantidadUsuarios = funcion.contarUsuarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInicio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        lblInicioSesion = new javax.swing.JLabel();
        jLabelContra = new javax.swing.JLabel();
        jLabelContra1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lineaUsuario = new javax.swing.JPanel();
        txtContraseña = new javax.swing.JPasswordField();
        lineaContra = new javax.swing.JPanel();
        jPanelInicia = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JLabel();
        jPanelNaranja = new javax.swing.JPanel();
        jPanelMinimizar = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        jPanelCerrar = new javax.swing.JPanel();
        jLabelCerrar = new javax.swing.JLabel();
        jPanelBlanco = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/Images/Principal/Icono.png")).getImage());
        setMinimumSize(new java.awt.Dimension(310, 380));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInicio.setBackground(new java.awt.Color(255, 255, 255));
        jPanelInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanelInicio.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jPanelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablalistado);

        jPanelInicio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 30, 15));

        lblInicioSesion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInicioSesion.setForeground(new java.awt.Color(65, 139, 66));
        lblInicioSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInicioSesion.setText("INICIO DE SESION");
        jPanelInicio.add(lblInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 30));

        jLabelContra.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabelContra.setForeground(new java.awt.Color(65, 139, 66));
        jLabelContra.setText("Usuario");
        jPanelInicio.add(jLabelContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 20));

        jLabelContra1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabelContra1.setForeground(new java.awt.Color(65, 139, 66));
        jLabelContra1.setText("Contraseña");
        jPanelInicio.add(jLabelContra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 210, 20));

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(null);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanelInicio.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 28));

        lineaUsuario.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaUsuarioLayout = new javax.swing.GroupLayout(lineaUsuario);
        lineaUsuario.setLayout(lineaUsuarioLayout);
        lineaUsuarioLayout.setHorizontalGroup(
            lineaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        lineaUsuarioLayout.setVerticalGroup(
            lineaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanelInicio.add(lineaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 118, 200, 2));

        txtContraseña.setForeground(new java.awt.Color(51, 51, 51));
        txtContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContraseña.setBorder(null);
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusLost(evt);
            }
        });
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanelInicio.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 28));

        lineaContra.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaContraLayout = new javax.swing.GroupLayout(lineaContra);
        lineaContra.setLayout(lineaContraLayout);
        lineaContraLayout.setHorizontalGroup(
            lineaContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        lineaContraLayout.setVerticalGroup(
            lineaContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanelInicio.add(lineaContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 188, 200, 2));

        jPanelInicia.setBackground(new java.awt.Color(255, 255, 255));
        jPanelInicia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIngresar.setText("I N G R E S A R");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        jPanelInicia.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 5, 150, 20));

        jPanelInicio.add(jPanelInicia, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 250, 160, 30));

        getContentPane().add(jPanelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 320));

        jPanelNaranja.setBackground(new java.awt.Color(65, 139, 66));
        jPanelNaranja.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelNaranjaMouseDragged(evt);
            }
        });
        jPanelNaranja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelNaranjaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelNaranjaMouseReleased(evt);
            }
        });
        jPanelNaranja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMinimizar.setBackground(new java.awt.Color(65, 139, 66));

        btnMinimizar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        btnMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimizar.setText("_");
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelMinimizarLayout = new javax.swing.GroupLayout(jPanelMinimizar);
        jPanelMinimizar.setLayout(jPanelMinimizarLayout);
        jPanelMinimizarLayout.setHorizontalGroup(
            jPanelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMinimizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMinimizarLayout.setVerticalGroup(
            jPanelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMinimizarLayout.createSequentialGroup()
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelNaranja.add(jPanelMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 1, 20, 18));

        jPanelCerrar.setBackground(new java.awt.Color(65, 139, 66));

        jLabelCerrar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabelCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCerrar.setText("X");
        jLabelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelCerrarLayout = new javax.swing.GroupLayout(jPanelCerrar);
        jPanelCerrar.setLayout(jPanelCerrarLayout);
        jPanelCerrarLayout.setHorizontalGroup(
            jPanelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCerrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCerrarLayout.setVerticalGroup(
            jPanelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
        );

        jPanelNaranja.add(jPanelCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 1, 20, 18));

        getContentPane().add(jPanelNaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 190));

        jPanelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBlanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanelBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanelBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 310, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        lineaUsuario.setBackground(new java.awt.Color(65,139,66));
        lineaContra.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        lineaContra.setBackground(new java.awt.Color(153, 153, 153));
        lineaUsuario.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusGained
        lineaContra.setBackground(new java.awt.Color(65,139,66));
        lineaUsuario.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_txtContraseñaFocusGained

    private void txtContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusLost
        lineaContra.setBackground(new java.awt.Color(153, 153, 153));
        lineaUsuario.setBackground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_txtContraseñaFocusLost

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        jPanelInicia.setBackground(new java.awt.Color(65,139,66));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        jPanelInicia.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        this.setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseEntered
        jPanelMinimizar.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btnMinimizarMouseEntered

    private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseExited
        jPanelMinimizar.setBackground(new java.awt.Color(65,139,66));
    }//GEN-LAST:event_btnMinimizarMouseExited

    private void jLabelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCerrarMouseClicked

    private void jLabelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseEntered
        jPanelCerrar.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_jLabelCerrarMouseEntered

    private void jLabelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCerrarMouseExited
        jPanelCerrar.setBackground(new java.awt.Color(65,139,66));
    }//GEN-LAST:event_jLabelCerrarMouseExited

    private void jPanelNaranjaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNaranjaMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jPanelNaranjaMouseDragged

    private void jPanelNaranjaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNaranjaMousePressed
        setOpacity((float)0.8);
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanelNaranjaMousePressed

    private void jPanelNaranjaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNaranjaMouseReleased
        setOpacity((float)1.0);
    }//GEN-LAST:event_jPanelNaranjaMouseReleased

    private void btnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseClicked
        if (txtUsuario.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre de usuario.");
            txtUsuario.requestFocus();
            return;
        }

        if (txtContraseña.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese su contraseña.");
            txtContraseña.requestFocus();
            return;
        }

        try {
            DefaultTableModel modelo;

            DAO_Usuario func = new DAO_Usuario();
            Usuario dts = new Usuario();

            dts.setUsuario(txtUsuario.getText());
            dts.setContraseña(txtContraseña.getText());

            modelo = func.login(dts.getUsuario(), dts.getContraseña());

            tablalistado.setModel(modelo);

            if (func.totalRegistros > 0) {
                this.dispose();
                FrmPrincipal form = new FrmPrincipal();
                form.toFront();
                form.setVisible(true);
                FrmPrincipal.lblId_Usuario.setText(tablalistado.getValueAt(0, 0).toString());
                FrmPrincipal.lblNombre.setText(tablalistado.getValueAt(0, 1).toString());
                FrmPrincipal.lblTipo.setText(tablalistado.getValueAt(0, 6).toString());               

                if (!FrmPrincipal.lblTipo.getText().equals("Administrador")) {
                    
                    JPanelFrmCliente.btnUsuarios.setEnabled(false);
                    JPanelFrmCliente.btnProveedores.setEnabled(false);
                    
                    //FrmPrincipal.JmIProductos.setEnabled(false);
                    //FrmPrincipal.JmIEntrada.setEnabled(false);
                    //FrmPrincipal.JmIUbicacion.setEnabled(false);
                    //FrmPrincipal.JmIStock.setEnabled(true);                   
                    
                    //FrmPrincipal.JmiHerramientas.setEnabled(false);    
                }                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario y/o contraseña incorrectos", "¡ Alerta !", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e);
        }
    }//GEN-LAST:event_btnIngresarMouseClicked

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtUsuario.transferFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        txtContraseña.transferFocus();
    }//GEN-LAST:event_txtContraseñaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnIngresar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel jLabelCerrar;
    public javax.swing.JLabel jLabelContra;
    public javax.swing.JLabel jLabelContra1;
    private javax.swing.JPanel jPanelBlanco;
    private javax.swing.JPanel jPanelCerrar;
    private javax.swing.JPanel jPanelInicia;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JPanel jPanelMinimizar;
    private javax.swing.JPanel jPanelNaranja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInicioSesion;
    private javax.swing.JPanel lineaContra;
    private javax.swing.JPanel lineaUsuario;
    private javax.swing.JTable tablalistado;
    public javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
