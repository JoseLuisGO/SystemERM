/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.Proveedor;
import DAO.DAO_Proveedor;
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
public class JPanelFrmProveedor extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFrmProveedor
     */
    CardLayout card;
    
    public JPanelFrmProveedor() {
        initComponents();
        card = (CardLayout) FrmPrincipal.jPanelBranch.getLayout(); 
        
        cambiarColorBtn(jPanelProveedores, btnProveedores);
        inhabilitar();
        mostrar("");       
      
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
    
    public void ocultar_columnas() {
        jTabla.getColumnModel().getColumn(0).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(0).setMinWidth(0);
        jTabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void inhabilitar() {

        txtId_Proveedor.setVisible(false);
        txtRazon_Social.setEditable(false);        
        txtContacto.setEditable(false);
        txtTelefono.setEditable(false);
        txtCorreo.setEditable(false);
        txtDireccion.setEditable(false);
        txtBuscar.setEditable(false);

        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        
        txtId_Proveedor.setText("");
        txtRazon_Social.setText("");        
        txtContacto.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtBuscar.setText("");
    }

    public void habilitar() {

        txtRazon_Social.setEditable(true);
        txtContacto.setEditable(true);
        txtTelefono.setEditable(true);
        txtCorreo.setEditable(true);
        txtDireccion.setEditable(true);
        txtBuscar.setEditable(true);
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        
        txtId_Proveedor.setText("");
        txtRazon_Social.setText("");
        txtContacto.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtBuscar.setText("");
    }

    public void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            DAO_Proveedor funcion = new DAO_Proveedor();
            modelo = funcion.mostrar(buscar);
            jTabla.setModel(modelo);
            ocultar_columnas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cambiarColorBtn(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(204, 204, 204));
        btn.setForeground(new java.awt.Color(255, 50, 0));
    }
    
    public void cambiarColorLinea(JPanel panel) {
        lineaRazonSocial.setBackground(new java.awt.Color(153, 153, 153));
        lineaContacto.setBackground(new java.awt.Color(153, 153, 153));
        lineaTelefono.setBackground(new java.awt.Color(153, 153, 153));
        lineaCorreo.setBackground(new java.awt.Color(153, 153, 153));
        lineaDireccion.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBackground(new java.awt.Color(255, 50, 0));
    }
    
    public void cambiarColorLineaDefecto() {
        lineaRazonSocial.setBackground(new java.awt.Color(153, 153, 153));
        lineaContacto.setBackground(new java.awt.Color(153, 153, 153));
        lineaTelefono.setBackground(new java.awt.Color(153, 153, 153));
        lineaCorreo.setBackground(new java.awt.Color(153, 153, 153));
        lineaDireccion.setBackground(new java.awt.Color(153, 153, 153));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jPanelClientes = new javax.swing.JPanel();
        btnClientes = new javax.swing.JLabel();
        jPanelUsuarios = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JLabel();
        jPanelProveedores = new javax.swing.JPanel();
        btnProveedores = new javax.swing.JLabel();
        jPanelContenedor = new javax.swing.JPanel();
        txtId_Proveedor = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanelDatos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtContacto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRazon_Social = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lineaRazonSocial = new javax.swing.JPanel();
        lineaContacto = new javax.swing.JPanel();
        lineaTelefono = new javax.swing.JPanel();
        lineaCorreo = new javax.swing.JPanel();
        lineaDireccion = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lineaBusqueda = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelClientes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelClientes.setPreferredSize(new java.awt.Dimension(130, 50));

        btnClientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClientes.setText("Clientes");
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelClientesLayout = new javax.swing.GroupLayout(jPanelClientes);
        jPanelClientes.setLayout(jPanelClientesLayout);
        jPanelClientesLayout.setHorizontalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelClientesLayout.setVerticalGroup(
            jPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMenu.add(jPanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jPanelUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUsuarios.setPreferredSize(new java.awt.Dimension(130, 41));

        btnUsuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuariosLayout = new javax.swing.GroupLayout(jPanelUsuarios);
        jPanelUsuarios.setLayout(jPanelUsuariosLayout);
        jPanelUsuariosLayout.setHorizontalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelUsuariosLayout.setVerticalGroup(
            jPanelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMenu.add(jPanelUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, 50));

        jPanelProveedores.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProveedores.setPreferredSize(new java.awt.Dimension(130, 41));

        btnProveedores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProveedores.setText("Proveedores");
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelProveedoresLayout = new javax.swing.GroupLayout(jPanelProveedores);
        jPanelProveedores.setLayout(jPanelProveedoresLayout);
        jPanelProveedoresLayout.setHorizontalGroup(
            jPanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelProveedoresLayout.setVerticalGroup(
            jPanelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelMenu.add(jPanelProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, 50));

        add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));

        jPanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtId_Proveedor.setText(" ");
        jPanelContenedor.add(txtId_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.setActionCommand("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanelContenedor.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 560, -1, -1));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanelContenedor.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        btnEditar.setBackground(new java.awt.Color(204, 204, 204));
        btnEditar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanelContenedor.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, -1, -1));

        jTabla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTabla.setGridColor(new java.awt.Color(204, 204, 204));
        jTabla.setOpaque(true);
        jTabla.setRowHeight(20);
        jTabla.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTabla.setSelectionForeground(new java.awt.Color(0, 102, 0));
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabla);

        jPanelContenedor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 50, 530, 470));

        jPanelDatos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Contacto:");
        jPanelDatos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Teléfono:");
        jPanelDatos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setText("Correo:");
        jPanelDatos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCorreo.setBorder(null);
        txtCorreo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanelDatos.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 210, 30));

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtTelefono.setBorder(null);
        txtTelefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanelDatos.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 30));

        txtContacto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtContacto.setBorder(null);
        txtContacto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtContacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContactoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactoFocusLost(evt);
            }
        });
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        jPanelDatos.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Razon Social:");
        jPanelDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtRazon_Social.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtRazon_Social.setText(" ");
        txtRazon_Social.setBorder(null);
        txtRazon_Social.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRazon_Social.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRazon_SocialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRazon_SocialFocusLost(evt);
            }
        });
        txtRazon_Social.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazon_SocialActionPerformed(evt);
            }
        });
        txtRazon_Social.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazon_SocialKeyTyped(evt);
            }
        });
        jPanelDatos.add(txtRazon_Social, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/usuario.png"))); // NOI18N
        jLabel1.setText(" ");
        jPanelDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 50, 30, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/direccion.png"))); // NOI18N
        jLabel10.setText(" ");
        jPanelDatos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/telefono.png"))); // NOI18N
        jLabel9.setText(" ");
        jPanelDatos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/login.png"))); // NOI18N
        jLabel11.setText(" ");
        jPanelDatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 30, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel12.setText("Dirección:");
        jPanelDatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtDireccion.setBorder(null);
        txtDireccion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanelDatos.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 210, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/correo.png"))); // NOI18N
        jLabel13.setText(" ");
        jPanelDatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, 30));

        lineaRazonSocial.setBackground(new java.awt.Color(153, 153, 153));
        lineaRazonSocial.setPreferredSize(new java.awt.Dimension(230, 2));

        javax.swing.GroupLayout lineaRazonSocialLayout = new javax.swing.GroupLayout(lineaRazonSocial);
        lineaRazonSocial.setLayout(lineaRazonSocialLayout);
        lineaRazonSocialLayout.setHorizontalGroup(
            lineaRazonSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        lineaRazonSocialLayout.setVerticalGroup(
            lineaRazonSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanelDatos.add(lineaRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        lineaContacto.setBackground(new java.awt.Color(153, 153, 153));
        lineaContacto.setPreferredSize(new java.awt.Dimension(230, 2));

        javax.swing.GroupLayout lineaContactoLayout = new javax.swing.GroupLayout(lineaContacto);
        lineaContacto.setLayout(lineaContactoLayout);
        lineaContactoLayout.setHorizontalGroup(
            lineaContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        lineaContactoLayout.setVerticalGroup(
            lineaContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanelDatos.add(lineaContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lineaTelefono.setBackground(new java.awt.Color(153, 153, 153));
        lineaTelefono.setPreferredSize(new java.awt.Dimension(230, 2));

        javax.swing.GroupLayout lineaTelefonoLayout = new javax.swing.GroupLayout(lineaTelefono);
        lineaTelefono.setLayout(lineaTelefonoLayout);
        lineaTelefonoLayout.setHorizontalGroup(
            lineaTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        lineaTelefonoLayout.setVerticalGroup(
            lineaTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanelDatos.add(lineaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        lineaCorreo.setBackground(new java.awt.Color(153, 153, 153));
        lineaCorreo.setPreferredSize(new java.awt.Dimension(230, 2));

        javax.swing.GroupLayout lineaCorreoLayout = new javax.swing.GroupLayout(lineaCorreo);
        lineaCorreo.setLayout(lineaCorreoLayout);
        lineaCorreoLayout.setHorizontalGroup(
            lineaCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        lineaCorreoLayout.setVerticalGroup(
            lineaCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanelDatos.add(lineaCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        lineaDireccion.setBackground(new java.awt.Color(153, 153, 153));
        lineaDireccion.setPreferredSize(new java.awt.Dimension(230, 2));

        javax.swing.GroupLayout lineaDireccionLayout = new javax.swing.GroupLayout(lineaDireccion);
        lineaDireccion.setLayout(lineaDireccionLayout);
        lineaDireccionLayout.setHorizontalGroup(
            lineaDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        lineaDireccionLayout.setVerticalGroup(
            lineaDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanelDatos.add(lineaDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jPanelContenedor.add(jPanelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 270, 390));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(65, 139, 66));
        jLabel20.setText("Búsqueda Cliente :");
        jPanelContenedor.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, -1, 33));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanelContenedor.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanelContenedor.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanelContenedor.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 150, 33));

        jPanel2.setBackground(new java.awt.Color(65, 139, 66));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GESTIÓN DE PROVEEDORES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(565, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addContainerGap(253, Short.MAX_VALUE))
        );

        jPanelContenedor.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 310));

        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda.setPreferredSize(new java.awt.Dimension(180, 2));

        javax.swing.GroupLayout lineaBusquedaLayout = new javax.swing.GroupLayout(lineaBusqueda);
        lineaBusqueda.setLayout(lineaBusquedaLayout);
        lineaBusquedaLayout.setHorizontalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        lineaBusquedaLayout.setVerticalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelContenedor.add(lineaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 593, 150, 2));

        add(jPanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 830, 610));
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked

        habilitar();
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(true);

        int fila = jTabla.rowAtPoint(evt.getPoint());
        txtId_Proveedor.setText(jTabla.getValueAt(fila, 0).toString());
        txtRazon_Social.setText(jTabla.getValueAt(fila, 1).toString());
        txtContacto.setText(jTabla.getValueAt(fila, 2).toString());
        txtTelefono.setText(jTabla.getValueAt(fila, 3).toString());
        txtCorreo.setText(jTabla.getValueAt(fila, 4).toString());
        txtDireccion.setText(jTabla.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_jTablaMouseClicked

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        txtCorreo.transferFocus();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        txtContacto.transferFocus();
    }//GEN-LAST:event_txtContactoActionPerformed

    private void txtRazon_SocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazon_SocialActionPerformed
        txtRazon_Social.transferFocus();
    }//GEN-LAST:event_txtRazon_SocialActionPerformed

    private void txtRazon_SocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazon_SocialKeyTyped

    }//GEN-LAST:event_txtRazon_SocialKeyTyped

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        txtDireccion.transferFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        txtRazon_Social.requestFocus();
        mostrar("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtRazon_Social.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese razon social.");
            txtRazon_Social.requestFocus();
            return;
        }

        if (txtContacto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese contacto de la razon social.");
            txtContacto.requestFocus();
            return;
        }

        if (txtTelefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese número telefónico del contacto.");
            txtTelefono.requestFocus();
            return;
        }

        if (txtCorreo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese correo electrónico del contacto.");
            txtCorreo.requestFocus();
            return;
        }

        if (txtDireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese dirección de la razon social.");
            txtDireccion.requestFocus();
            return;
        }

        Proveedor datos = new Proveedor();
        DAO_Proveedor funcion = new DAO_Proveedor();

        datos.setRazon_Social(txtRazon_Social.getText());
        datos.setContacto(txtContacto.getText());
        datos.setTelefono(txtTelefono.getText());
        datos.setCorreo(txtCorreo.getText());
        datos.setDireccion(txtDireccion.getText());

        if (funcion.insertar(datos)) {
            JOptionPane.showMessageDialog(null, "Proveedor registrado exitosamente.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar al cliente.");
            mostrar("");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (txtRazon_Social.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese razon social.");
            txtRazon_Social.requestFocus();
            return;
        }

        if (txtContacto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese contacto de la razon social.");
            txtContacto.requestFocus();
            return;
        }

        if (txtTelefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese número telefónico del contacto.");
            txtTelefono.requestFocus();
            return;
        }

        if (txtCorreo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese correo electrónico del contacto.");
            txtCorreo.requestFocus();
            return;
        }

        if (txtDireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese dirección de la razon social.");
            txtDireccion.requestFocus();
            return;
        }

        Proveedor datos = new Proveedor();
        DAO_Proveedor funcion = new DAO_Proveedor();

        datos.setRazon_Social(txtRazon_Social.getText());
        datos.setContacto(txtContacto.getText());
        datos.setTelefono(txtTelefono.getText());
        datos.setCorreo(txtCorreo.getText());
        datos.setDireccion(txtDireccion.getText());

        datos.setId_Proveedor(Integer.parseInt(txtId_Proveedor.getText()));

        if (funcion.editar(datos)) {
            JOptionPane.showMessageDialog(null, "Proveedor modificado exitosamente.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar al cliente.");
            mostrar("");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (txtId_Proveedor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione el proveedor que desea eliminar");
            return;
        }
        int codigoProveedor = Integer.parseInt(txtId_Proveedor.getText());
        String nombreProveedor = txtRazon_Social.getText();

        int i = JOptionPane.showConfirmDialog(this,
            "¿Seguro qué desea eliminar al proveedor?", "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            if (!txtId_Proveedor.getText().equals("")) {
                DAO_Proveedor funcion = new DAO_Proveedor();
                Proveedor datos = new Proveedor();
                datos.setId_Proveedor(Integer.parseInt(txtId_Proveedor.getText()));
                funcion.eliminar(datos);
                mostrar("");
                inhabilitar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        JPanelFrmCliente panel = new JPanelFrmCliente();
        cambiarPanelContenedorBranch(panel, "Clientes");
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
        cambiarColorMenu(jPanelClientes, btnClientes);
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        cambiarColorMenuDefecto(jPanelClientes, btnClientes);
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseEntered
        //cambiarColorMenu(jPanelProveedores, btnProveedores);
    }//GEN-LAST:event_btnProveedoresMouseEntered

    private void btnProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseExited
        //cambiarColorMenuDefecto(jPanelProveedores, btnProveedores);
    }//GEN-LAST:event_btnProveedoresMouseExited

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        JPanelFrmUsuario panel = new JPanelFrmUsuario();
        cambiarPanelContenedorBranch(panel, "Usuarios");
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        cambiarColorMenu(jPanelUsuarios, btnUsuarios);
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        cambiarColorMenuDefecto(jPanelUsuarios, btnUsuarios);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void txtRazon_SocialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRazon_SocialFocusGained
        cambiarColorLinea(lineaRazonSocial);
    }//GEN-LAST:event_txtRazon_SocialFocusGained

    private void txtRazon_SocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRazon_SocialFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtRazon_SocialFocusLost

    private void txtContactoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactoFocusGained
        cambiarColorLinea(lineaContacto);
    }//GEN-LAST:event_txtContactoFocusGained

    private void txtContactoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtContactoFocusLost

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        cambiarColorLinea(lineaTelefono);
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        cambiarColorLinea(lineaCorreo);
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        cambiarColorLinea(lineaDireccion);
    }//GEN-LAST:event_txtDireccionFocusGained

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        cambiarColorLinea(lineaBusqueda);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtBuscarFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnClientes;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel btnProveedores;
    private javax.swing.JLabel btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProveedores;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JPanel lineaBusqueda;
    private javax.swing.JPanel lineaContacto;
    private javax.swing.JPanel lineaCorreo;
    private javax.swing.JPanel lineaDireccion;
    private javax.swing.JPanel lineaRazonSocial;
    private javax.swing.JPanel lineaTelefono;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId_Proveedor;
    private javax.swing.JTextField txtRazon_Social;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
