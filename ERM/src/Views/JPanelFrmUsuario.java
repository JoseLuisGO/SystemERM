/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.Usuario;
import static Views.JPanelFrmUsuario.txtLogin;
import DAO.DAO_Usuario;
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
public class JPanelFrmUsuario extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFrmUsuario
     */
    CardLayout card;
    
    public JPanelFrmUsuario() {
        initComponents();
        card = (CardLayout) FrmPrincipal.jPanelBranch.getLayout();
        
        cambiarColorBtn(jPanelUsuarios, btnUsuarios);
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
                l.setFont(new java.awt.Font("Dialog", 3, 14));
                return l;
            }
        });
    }
    
    public void cambiarColorBtn(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(204, 204, 204));
        btn.setForeground(new java.awt.Color(255, 50, 0));
    }
    
    public void ocultar_columnas() {
        jTabla.getColumnModel().getColumn(0).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(0).setMinWidth(0);
        jTabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void inhabilitar() {

        txtId_Usuario.setVisible(false);
        txtNombre.setEditable(false);
        txtLogin.setEditable(false);
        txtPassword.setEditable(false);
        txtTelefono.setEditable(false);      

        txtBuscar.setEditable(false);

        btnBuscar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);

        txtId_Usuario.setText("");
        txtNombre.setText("");
        txtLogin.setText("");
        txtPassword.setText("");
        txtTelefono.setText("");
        
        txtBuscar.setText("");
    }

    public void habilitar() {

        txtNombre.setEditable(true);
        txtLogin.setEditable(true);
        txtPassword.setEditable(true);
        txtTelefono.setEditable(true);
        
        txtBuscar.setEditable(true);

        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);

        btnNuevo.setEnabled(false);

        txtId_Usuario.setText("");
        txtNombre.setText("");
        txtLogin.setText("");
        txtPassword.setText("");
        txtTelefono.setText("");
               
        txtBuscar.setText("");
    }

    public void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            DAO_Usuario func = new DAO_Usuario();
            modelo = func.mostrar(buscar);
            jTabla.setModel(modelo);
            ocultar_columnas();           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cambiarColorLinea(JPanel panel) {
        lineaNombre.setBackground(new java.awt.Color(153, 153, 153));
        lineaLogin.setBackground(new java.awt.Color(153, 153, 153));
        lineaContraseña.setBackground(new java.awt.Color(153, 153, 153));
        lineaTelefono.setBackground(new java.awt.Color(153, 153, 153));
        lineaEstado.setBackground(new java.awt.Color(153, 153, 153));
        lineaAcceso.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBackground(new java.awt.Color(255, 50, 0));
    }
    
    public void cambiarColorLineaDefecto() {
        lineaNombre.setBackground(new java.awt.Color(153, 153, 153));
        lineaLogin.setBackground(new java.awt.Color(153, 153, 153));
        lineaContraseña.setBackground(new java.awt.Color(153, 153, 153));
        lineaTelefono.setBackground(new java.awt.Color(153, 153, 153));
        lineaEstado.setBackground(new java.awt.Color(153, 153, 153));
        lineaAcceso.setBackground(new java.awt.Color(153, 153, 153));
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel4 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lineaBusqueda = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanelClientes = new javax.swing.JPanel();
        btnClientes = new javax.swing.JLabel();
        jPanelUsuarios = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JLabel();
        jPanelProveedores = new javax.swing.JPanel();
        btnProveedores = new javax.swing.JLabel();
        txtId_Usuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lineaEstado = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        lineaNombre = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lineaLogin = new javax.swing.JPanel();
        lineaContraseña = new javax.swing.JPanel();
        lineaAcceso = new javax.swing.JPanel();
        lineaTelefono = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cboAcceso = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(822, 521));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        });
        jScrollPane2.setViewportView(jTabla);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 460, 481));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(317, 47));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar.setBackground(new java.awt.Color(204, 204, 204));
        btnEditar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 20, -1, -1));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 330, 70));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(317, 47));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(65, 139, 66));
        jLabel20.setText("Nombre del Usuario :");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, -1, 30));

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.setSelectedTextColor(new java.awt.Color(0, 0, 0));
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
        jPanel5.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 17, 150, 30));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 17, 110, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(207, 207, 207));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 17, 51, -1));

        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));

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

        jPanel5.add(lineaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 47, 150, 2));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, 480, 70));

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

        jPanel2.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));

        txtId_Usuario.setText(" ");
        jPanel2.add(txtId_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 50, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(255, 87, 34));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("GESTIÓN DE USUARIOS");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 310, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText(" Nombre :");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/usuario.png"))); // NOI18N
        jLabel1.setText(" ");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 30));

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(null);
        txtNombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, 30));

        lineaEstado.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaEstadoLayout = new javax.swing.GroupLayout(lineaEstado);
        lineaEstado.setLayout(lineaEstadoLayout);
        lineaEstadoLayout.setHorizontalGroup(
            lineaEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        lineaEstadoLayout.setVerticalGroup(
            lineaEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(lineaEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 270, 2));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel8.setText("Login :");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtLogin.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtLogin.setBorder(null);
        txtLogin.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginFocusLost(evt);
            }
        });
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        jPanel7.add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/login.png"))); // NOI18N
        jLabel24.setText(" ");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, 30));

        lineaNombre.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaNombreLayout = new javax.swing.GroupLayout(lineaNombre);
        lineaNombre.setLayout(lineaNombreLayout);
        lineaNombreLayout.setHorizontalGroup(
            lineaNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        lineaNombreLayout.setVerticalGroup(
            lineaNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(lineaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 2));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setText("Password :");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPassword.setBorder(null);
        txtPassword.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel7.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 240, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/contraseña.png"))); // NOI18N
        jLabel18.setText(" ");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 23, 30));

        lineaLogin.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaLoginLayout = new javax.swing.GroupLayout(lineaLogin);
        lineaLogin.setLayout(lineaLoginLayout);
        lineaLoginLayout.setHorizontalGroup(
            lineaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        lineaLoginLayout.setVerticalGroup(
            lineaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(lineaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 270, 2));

        lineaContraseña.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaContraseñaLayout = new javax.swing.GroupLayout(lineaContraseña);
        lineaContraseña.setLayout(lineaContraseñaLayout);
        lineaContraseñaLayout.setHorizontalGroup(
            lineaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        lineaContraseñaLayout.setVerticalGroup(
            lineaContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(lineaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 270, 2));

        lineaAcceso.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaAccesoLayout = new javax.swing.GroupLayout(lineaAcceso);
        lineaAcceso.setLayout(lineaAccesoLayout);
        lineaAccesoLayout.setHorizontalGroup(
            lineaAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        lineaAccesoLayout.setVerticalGroup(
            lineaAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(lineaAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 270, 2));

        lineaTelefono.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaTelefonoLayout = new javax.swing.GroupLayout(lineaTelefono);
        lineaTelefono.setLayout(lineaTelefonoLayout);
        lineaTelefonoLayout.setHorizontalGroup(
            lineaTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        lineaTelefonoLayout.setVerticalGroup(
            lineaTelefonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel7.add(lineaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Telefono :");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtTelefono.setBorder(null);
        txtTelefono.setSelectedTextColor(new java.awt.Color(0, 0, 0));
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
        jPanel7.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 240, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/telefono.png"))); // NOI18N
        jLabel22.setText(" ");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, 30));

        cboAcceso.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboAcceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Administrador", "Vendedor" }));
        cboAcceso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboAccesoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboAccesoFocusLost(evt);
            }
        });
        cboAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAccesoActionPerformed(evt);
            }
        });
        jPanel7.add(cboAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 240, 30));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel11.setText("Acceso :");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/acceso.png"))); // NOI18N
        jLabel17.setText(" ");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 23, 30));

        cboEstado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Activo", "Inactivo" }));
        cboEstado.setBorder(null);
        cboEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboEstadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboEstadoFocusLost(evt);
            }
        });
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });
        jPanel7.add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 240, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel10.setText("Estado :");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/estado.png"))); // NOI18N
        jLabel25.setText(" ");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, 30));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 310, 390));

        jPanel6.setBackground(new java.awt.Color(65, 139, 66));
        jPanel6.setPreferredSize(new java.awt.Dimension(830, 305));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 305));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 830, 610));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 660));
    }// </editor-fold>//GEN-END:initComponents

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked

        habilitar();
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(true);

        int fila = jTabla.rowAtPoint(evt.getPoint());

        txtId_Usuario.setText(jTabla.getValueAt(fila, 0).toString());
        txtNombre.setText(jTabla.getValueAt(fila, 1).toString());
        txtLogin.setText(jTabla.getValueAt(fila, 2).toString());
        txtPassword.setText(jTabla.getValueAt(fila, 3).toString());
        txtTelefono.setText(jTabla.getValueAt(fila, 4).toString());

        cboEstado.setSelectedItem(jTabla.getValueAt(fila, 5).toString());
        cboAcceso.setSelectedItem(jTabla.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_jTablaMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void cboAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAccesoActionPerformed

    }//GEN-LAST:event_cboAccesoActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
        cboEstado.transferFocus();
    }//GEN-LAST:event_cboEstadoActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        txtPassword.transferFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        txtLogin.transferFocus();
    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre de usuario");
            txtNombre.requestFocus();
            return;
        }

        if (txtLogin.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese identificador del usuario");
            txtLogin.requestFocus();
            return;
        }

        if (txtPassword.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese contraseña del usuario");
            txtPassword.requestFocus();
            return;
        }

        if (txtTelefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese teléfono del usuario");
            txtTelefono.requestFocus();
            return;
        }

        Usuario datos = new Usuario();
        DAO_Usuario funcion = new DAO_Usuario();

        datos.setNombre(txtNombre.getText());
        datos.setUsuario(txtLogin.getText());
        datos.setContraseña(txtPassword.getText());
        datos.setTelefono(txtTelefono.getText());

        int estado = cboEstado.getSelectedIndex();
        datos.setEstado((String) cboEstado.getItemAt(estado));

        int acceso = cboAcceso.getSelectedIndex();
        datos.setTipo((String) cboAcceso.getItemAt(acceso));

        datos.setId_Usuario(Integer.parseInt(txtId_Usuario.getText()));

        if (funcion.editar(datos)) {
            JOptionPane.showMessageDialog(null, "Los datos del trabajador fueron modificados exitosamente.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos.");
            mostrar("");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre de usuario");
            txtNombre.requestFocus();
            return;
        }

        if (txtLogin.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese identificador del usuario");
            txtLogin.requestFocus();
            return;
        }

        if (txtPassword.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese contraseña del usuario");
            txtPassword.requestFocus();
            return;
        }

        if (txtTelefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese teléfono del usuario");
            txtTelefono.requestFocus();
            return;
        }

        Usuario datos = new Usuario();
        DAO_Usuario funcion = new DAO_Usuario();
        int login = funcion.verificarLogin();
        if (login == 1) {
            JOptionPane.showMessageDialog(null, "Este Identificador : " + txtLogin.getText() + " ya esta ocupado por otro usuario.");
            txtLogin.setText("");
            txtLogin.requestFocus();
            return;
        }

        datos.setNombre(txtNombre.getText());
        datos.setUsuario(txtLogin.getText());
        datos.setContraseña(txtPassword.getText());
        datos.setTelefono(txtTelefono.getText());

        int estado = cboEstado.getSelectedIndex();
        datos.setEstado((String) cboEstado.getItemAt(estado));

        int acceso = cboAcceso.getSelectedIndex();
        datos.setTipo((String) cboAcceso.getItemAt(acceso));

        if (funcion.insertar(datos)) {
            JOptionPane.showMessageDialog(null, "El usuario fue registrado exitosamente al sistema.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario.");
            mostrar("");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
        txtNombre.requestFocus();
        mostrar("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (txtId_Usuario.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione el registro a eliminar");
            return;
        }

        int i = JOptionPane.showConfirmDialog(this,
            "¿Seguro qué desea eliminar al usuario?", "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION);
        if (i == 0) {

            if (!txtId_Usuario.getText().equals("")) {
                DAO_Usuario funcion = new DAO_Usuario();
                Usuario datos = new Usuario();

                datos.setId_Usuario(Integer.parseInt(txtId_Usuario.getText()));
                funcion.eliminar(datos);
                mostrar("");
                inhabilitar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        cambiarColorLinea(lineaNombre);
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusGained
        cambiarColorLinea(lineaLogin);
    }//GEN-LAST:event_txtLoginFocusGained

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtLoginFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        cambiarColorLinea(lineaContraseña);
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        cambiarColorLinea(lineaTelefono);
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtTelefonoFocusLost

    private void cboEstadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboEstadoFocusGained
        cambiarColorLinea(lineaEstado);
    }//GEN-LAST:event_cboEstadoFocusGained

    private void cboEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboEstadoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_cboEstadoFocusLost

    private void cboAccesoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboAccesoFocusGained
        cambiarColorLinea(lineaAcceso);
    }//GEN-LAST:event_cboAccesoFocusGained

    private void cboAccesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboAccesoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_cboAccesoFocusLost

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        cambiarColorLinea(lineaBusqueda);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtBuscarFocusLost

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
        JPanelFrmProveedor panel = new JPanelFrmProveedor();
        cambiarPanelContenedorBranch(panel, "Provedor");
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseEntered
       cambiarColorMenu(jPanelProveedores, btnProveedores);
    }//GEN-LAST:event_btnProveedoresMouseEntered

    private void btnProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseExited
        cambiarColorMenuDefecto(jPanelProveedores, btnProveedores);
    }//GEN-LAST:event_btnProveedoresMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnClientes;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel btnProveedores;
    private javax.swing.JLabel btnUsuarios;
    private javax.swing.JComboBox<String> cboAcceso;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProveedores;
    private javax.swing.JPanel jPanelUsuarios;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JPanel lineaAcceso;
    private javax.swing.JPanel lineaBusqueda;
    private javax.swing.JPanel lineaContraseña;
    private javax.swing.JPanel lineaEstado;
    private javax.swing.JPanel lineaLogin;
    private javax.swing.JPanel lineaNombre;
    private javax.swing.JPanel lineaTelefono;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId_Usuario;
    public static javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
