package Views;

import Connection.DB_Manager;
import static Views.rptVentasFechas.comprobar;
import java.awt.Graphics;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicDesktopPaneUI;
import javax.swing.plaf.basic.BasicMenuBarUI;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FrmPrincipal extends javax.swing.JFrame {

    DB_Manager db_manager;
    Connection connection;

    public FrmPrincipal() {
        initComponents();

        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
        this.setLocationRelativeTo(null);
        lblId_Usuario.setVisible(false);
        this.setExtendedState(MAXIMIZED_BOTH);

        menuBar.setOpaque(true);

        menuBar.setUI(new BasicMenuBarUI() {
            public void paint(Graphics g, JComponent c) {
                g.setColor(new java.awt.Color(255, 255, 255));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });

        deskPricipal.setUI(new BasicDesktopPaneUI() {
            public void paintComponent(Graphics g) {
                g.setColor(new java.awt.Color(36, 33, 33));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskPricipal = new javax.swing.JDesktopPane();
        lblMsj = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblId_Usuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        MenuVentas = new javax.swing.JMenu();
        JmIVentas = new javax.swing.JMenuItem();
        MenuPersonal = new javax.swing.JMenu();
        JmIClientes = new javax.swing.JMenuItem();
        JmIUsuarios = new javax.swing.JMenuItem();
        JmIProveedores = new javax.swing.JMenuItem();
        MenuProductos = new javax.swing.JMenu();
        JmIProductos = new javax.swing.JMenuItem();
        JmIEntrada = new javax.swing.JMenuItem();
        JmIUbicacion = new javax.swing.JMenuItem();
        JmIStock = new javax.swing.JMenuItem();
        MenuInformes = new javax.swing.JMenu();
        JmIVentasPorFecha = new javax.swing.JMenuItem();
        JmIProdVendFEc = new javax.swing.JMenuItem();
        JmIVentasPorCategorias = new javax.swing.JMenuItem();
        JmIHistorial = new javax.swing.JMenuItem();
        JmiHerramientas = new javax.swing.JMenu();
        JmIControlVentas = new javax.swing.JMenuItem();
        jmIUpdateDollar = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(36, 33, 33));
        setIconImage( new ImageIcon(getClass().getResource("/ImanegesMenuBar/LOGO.png")).getImage());

        deskPricipal.setBackground(new java.awt.Color(255, 255, 255));
        deskPricipal.setToolTipText("");
        deskPricipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deskPricipal.setOpaque(true
        );

        lblMsj.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblMsj.setText("¡ Bienvenid@ !");
        deskPricipal.add(lblMsj);
        lblMsj.setBounds(30, 20, 100, 18);

        lblTipo.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        lblTipo.setText("TIPO USUARIO");
        deskPricipal.add(lblTipo);
        lblTipo.setBounds(30, 80, 170, 10);

        lblId_Usuario.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        lblId_Usuario.setText("CODIGO");
        deskPricipal.add(lblId_Usuario);
        lblId_Usuario.setBounds(140, 20, 120, 15);

        lblNombre.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        lblNombre.setText("NOMBRE");
        deskPricipal.add(lblNombre);
        lblNombre.setBounds(30, 50, 170, 15);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuBar.setForeground(new java.awt.Color(255, 255, 255));
        menuBar.setToolTipText("");
        menuBar.setAlignmentX(0.2F);
        menuBar.setAlignmentY(0.2F);
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuBar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuBar.setOpaque(true);

        MenuVentas.setBackground(new java.awt.Color(255, 255, 255));
        MenuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImanegesMenuBar/ventaMenu.png"))); // NOI18N
        MenuVentas.setText("Venta");
        MenuVentas.setToolTipText("");
        MenuVentas.setAlignmentX(0.0F);
        MenuVentas.setAlignmentY(0.0F);
        MenuVentas.setBorderPainted(true);
        MenuVentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuVentas.setOpaque(true
        );

        JmIVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        JmIVentas.setBackground(new java.awt.Color(255, 255, 255));
        JmIVentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIVentas.setText("Venta");
        JmIVentas.setOpaque(true);
        JmIVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIVentasActionPerformed(evt);
            }
        });
        MenuVentas.add(JmIVentas);

        menuBar.add(MenuVentas);

        MenuPersonal.setBackground(new java.awt.Color(255, 255, 255));
        MenuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImanegesMenuBar/usuarioMenu.png"))); // NOI18N
        MenuPersonal.setText("Personal");
        MenuPersonal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuPersonal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuPersonal.setOpaque(true);

        JmIClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        JmIClientes.setBackground(new java.awt.Color(255, 255, 255));
        JmIClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIClientes.setText("Clientes");
        JmIClientes.setOpaque(true);
        JmIClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIClientesActionPerformed(evt);
            }
        });
        MenuPersonal.add(JmIClientes);

        JmIUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        JmIUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        JmIUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIUsuarios.setText("Usuarios");
        JmIUsuarios.setOpaque(true);
        JmIUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIUsuariosActionPerformed(evt);
            }
        });
        MenuPersonal.add(JmIUsuarios);

        JmIProveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        JmIProveedores.setBackground(new java.awt.Color(255, 255, 255));
        JmIProveedores.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIProveedores.setText("Proveedores");
        JmIProveedores.setOpaque(true);
        JmIProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIProveedoresActionPerformed(evt);
            }
        });
        MenuPersonal.add(JmIProveedores);

        menuBar.add(MenuPersonal);

        MenuProductos.setBackground(new java.awt.Color(255, 255, 255));
        MenuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImanegesMenuBar/codigoMenu.png"))); // NOI18N
        MenuProductos.setText("Productos");
        MenuProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuProductos.setOpaque(true);
        MenuProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuProductosMouseClicked(evt);
            }
        });
        MenuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProductosActionPerformed(evt);
            }
        });

        JmIProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        JmIProductos.setBackground(new java.awt.Color(255, 255, 255));
        JmIProductos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIProductos.setText("Productos");
        JmIProductos.setOpaque(true);
        JmIProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIProductosActionPerformed(evt);
            }
        });
        MenuProductos.add(JmIProductos);

        JmIEntrada.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        JmIEntrada.setBackground(new java.awt.Color(255, 255, 255));
        JmIEntrada.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIEntrada.setText("Entrada / Salida");
        JmIEntrada.setOpaque(true);
        JmIEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIEntradaActionPerformed(evt);
            }
        });
        MenuProductos.add(JmIEntrada);

        JmIUbicacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        JmIUbicacion.setBackground(new java.awt.Color(255, 255, 255));
        JmIUbicacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIUbicacion.setText("Ubicación");
        JmIUbicacion.setOpaque(true);
        JmIUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIUbicacionActionPerformed(evt);
            }
        });
        MenuProductos.add(JmIUbicacion);

        JmIStock.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        JmIStock.setBackground(new java.awt.Color(255, 255, 255));
        JmIStock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIStock.setText("Stock");
        JmIStock.setOpaque(true);
        JmIStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIStockActionPerformed(evt);
            }
        });
        MenuProductos.add(JmIStock);

        menuBar.add(MenuProductos);

        MenuInformes.setBackground(new java.awt.Color(255, 255, 255));
        MenuInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImanegesMenuBar/reporteMenu.png"))); // NOI18N
        MenuInformes.setText("Informes");
        MenuInformes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        MenuInformes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuInformes.setOpaque(true);

        JmIVentasPorFecha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        JmIVentasPorFecha.setBackground(new java.awt.Color(255, 255, 255));
        JmIVentasPorFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIVentasPorFecha.setText("Ventas por fecha.");
        JmIVentasPorFecha.setOpaque(true);
        JmIVentasPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIVentasPorFechaActionPerformed(evt);
            }
        });
        MenuInformes.add(JmIVentasPorFecha);

        JmIProdVendFEc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        JmIProdVendFEc.setBackground(new java.awt.Color(255, 255, 255));
        JmIProdVendFEc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIProdVendFEc.setText("Venta de productos por fecha.");
        JmIProdVendFEc.setOpaque(true);
        JmIProdVendFEc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIProdVendFEcActionPerformed(evt);
            }
        });
        MenuInformes.add(JmIProdVendFEc);

        JmIVentasPorCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        JmIVentasPorCategorias.setBackground(new java.awt.Color(255, 255, 255));
        JmIVentasPorCategorias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIVentasPorCategorias.setText("Total de recaudación por almacén.");
        JmIVentasPorCategorias.setOpaque(true);
        JmIVentasPorCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIVentasPorCategoriasActionPerformed(evt);
            }
        });
        MenuInformes.add(JmIVentasPorCategorias);

        JmIHistorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        JmIHistorial.setBackground(new java.awt.Color(255, 255, 255));
        JmIHistorial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIHistorial.setText("Historial de modificación de stock de productos.");
        JmIHistorial.setOpaque(true);
        JmIHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIHistorialActionPerformed(evt);
            }
        });
        MenuInformes.add(JmIHistorial);

        menuBar.add(MenuInformes);

        JmiHerramientas.setBackground(new java.awt.Color(255, 255, 255));
        JmiHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImanegesMenuBar/toolsMenu.png"))); // NOI18N
        JmiHerramientas.setText("Herramientas");
        JmiHerramientas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JmiHerramientas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JmiHerramientas.setOpaque(true);

        JmIControlVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        JmIControlVentas.setBackground(new java.awt.Color(255, 255, 255));
        JmIControlVentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JmIControlVentas.setText("Herramientas De Venta");
        JmIControlVentas.setOpaque(true);
        JmIControlVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmIControlVentasActionPerformed(evt);
            }
        });
        JmiHerramientas.add(JmIControlVentas);

        jmIUpdateDollar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        jmIUpdateDollar.setBackground(new java.awt.Color(255, 255, 255));
        jmIUpdateDollar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jmIUpdateDollar.setText("Actualizar Costo Dolar");
        jmIUpdateDollar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIUpdateDollarActionPerformed(evt);
            }
        });
        JmiHerramientas.add(jmIUpdateDollar);

        menuBar.add(JmiHerramientas);

        jMenu5.setBackground(new java.awt.Color(255, 255, 255));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImanegesMenuBar/exitMenu.png"))); // NOI18N
        jMenu5.setText("Cerrar Sesión");
        jMenu5.setAutoscrolls(true);
        jMenu5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setOpaque(true);
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        menuBar.add(jMenu5);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(deskPricipal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, deskPricipal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProductosActionPerformed

    }//GEN-LAST:event_MenuProductosActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void MenuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuProductosMouseClicked

    }//GEN-LAST:event_MenuProductosMouseClicked

    private void JmIClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIClientesActionPerformed

        FrmCliente form = new FrmCliente();
        deskPricipal.add(form);
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {

        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIClientesActionPerformed

    private void JmIUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIUsuariosActionPerformed

        FrmUsuario form = new FrmUsuario();
        deskPricipal.add(form);
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {

        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIUsuariosActionPerformed

    private void JmIControlVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIControlVentasActionPerformed

        FrmMostrarVentas form = new FrmMostrarVentas();
        deskPricipal.add(form);
        try {
            form.setMaximum(true);
            form.setClosable(true);
            form.setIconifiable(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ");
        }
        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIControlVentasActionPerformed

    private void JmIVentasPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIVentasPorFechaActionPerformed

        rptVentasFechas form = new rptVentasFechas();
        deskPricipal.add(form);

        try {
            form.setMaximum(false);
            form.setClosable(true);
            form.setIconifiable(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ");
        }

        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        form.toFront();
        form.setVisible(true);
        comprobar = 2;

    }//GEN-LAST:event_JmIVentasPorFechaActionPerformed

    private void JmIProdVendFEcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIProdVendFEcActionPerformed

        rptVentasFechas form = new rptVentasFechas();
        deskPricipal.add(form);

        try {
            form.setMaximum(false);
            form.setClosable(true);
            form.setIconifiable(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ");
        }
        this.setLocationRelativeTo(null);
        form.toFront();
        form.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        comprobar = 1;

    }//GEN-LAST:event_JmIProdVendFEcActionPerformed

    private void JmIVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIVentasActionPerformed

        FrmVentaDetalle1 form = new FrmVentaDetalle1();
        deskPricipal.add(form);

        form.setClosable(true);
        form.setIconifiable(true);
        FrmVentaDetalle1.txtCod_usuario.setText(lblId_Usuario.getText());
        FrmVentaDetalle1.txtNombre_usuario.setText(lblNombre.getText());
        try {
            form.setMaximum(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ");
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIVentasActionPerformed

    private void JmIVentasPorCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIVentasPorCategoriasActionPerformed

        rptVentasPorAlmacen form = new rptVentasPorAlmacen();
        deskPricipal.add(form);
        try {
            form.setMaximum(false);
            form.setClosable(true);
            form.setIconifiable(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ");
        }
        this.setLocationRelativeTo(null);
        form.toFront();
        form.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIVentasPorCategoriasActionPerformed

    private void JmIHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIHistorialActionPerformed
        /*
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReportHistorial.class.getResource("/Reportes/RptHistorial.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error" + e);
        }
         */

        try {
            
            String ruta = System.getProperty("user.dir");
            ruta += "\\src\\ImagenesForm\\Logo (Gris, Actual).png";
            System.out.println("PATH: " + ruta);
            HashMap<String, Object> map = new HashMap<>();
            map.put("path", ruta);

            JasperReport jr = (JasperReport) JRLoader.loadObject(VistaReporte.class.getResource("/Report/RptHistorial.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, map, connection);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error" + e);
        }

    }//GEN-LAST:event_JmIHistorialActionPerformed

    private void JmIProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIProveedoresActionPerformed

        FrmProveedor form = new FrmProveedor();
        deskPricipal.add(form);

        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
            
        }
        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIProveedoresActionPerformed

    private void JmIProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIProductosActionPerformed

        FrmProductos form = new FrmProductos();
        deskPricipal.add(form);

        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        
        }
        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIProductosActionPerformed

    private void JmIEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIEntradaActionPerformed

        FrmStock form = new FrmStock();
        deskPricipal.add(form);

        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        
        }
        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIEntradaActionPerformed

    private void JmIUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIUbicacionActionPerformed

        FrmAlmacen form = new FrmAlmacen();
        deskPricipal.add(form);

        form.setClosable(true);
        form.setIconifiable(true);

        form.setMaximizable(false);
        form.setResizable(false);

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIUbicacionActionPerformed

    private void JmIStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmIStockActionPerformed

        FrmConsultaStock1 form = new FrmConsultaStock1();
        deskPricipal.add(form);

        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        
        }
        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_JmIStockActionPerformed

    private void jmIUpdateDollarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmIUpdateDollarActionPerformed
        FrmDolar form = new FrmDolar();
        deskPricipal.add(form);
        try {
            form.setMaximum(false);
            form.setClosable(true);
            form.setIconifiable(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ");
        }
        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }//GEN-LAST:event_jmIUpdateDollarActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //  UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem JmIClientes;
    public static javax.swing.JMenuItem JmIControlVentas;
    public static javax.swing.JMenuItem JmIEntrada;
    javax.swing.JMenuItem JmIHistorial;
    javax.swing.JMenuItem JmIProdVendFEc;
    public static javax.swing.JMenuItem JmIProductos;
    public static javax.swing.JMenuItem JmIProveedores;
    public static javax.swing.JMenuItem JmIStock;
    public static javax.swing.JMenuItem JmIUbicacion;
    public static javax.swing.JMenuItem JmIUsuarios;
    javax.swing.JMenuItem JmIVentas;
    javax.swing.JMenuItem JmIVentasPorCategorias;
    javax.swing.JMenuItem JmIVentasPorFecha;
    public static javax.swing.JMenu JmiHerramientas;
    public static javax.swing.JMenu MenuInformes;
    public static javax.swing.JMenu MenuPersonal;
    public static javax.swing.JMenu MenuProductos;
    public static javax.swing.JMenu MenuVentas;
    public static javax.swing.JDesktopPane deskPricipal;
    public static javax.swing.JMenu jMenu5;
    javax.swing.JMenuItem jmIUpdateDollar;
    public static javax.swing.JLabel lblId_Usuario;
    public static javax.swing.JLabel lblMsj;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblTipo;
    public static javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
