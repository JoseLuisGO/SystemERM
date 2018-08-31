/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.Producto;
import DAO.DAO_Producto;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Jose_Gonzalez
 */
public class JPanelFrmProductos extends javax.swing.JPanel {

    private File file;
    private List<JTable> tabla;
    private List<String> nom_files;
    CardLayout card;

    /**
     * Creates new form JPanelFrmProductos
     */
    public JPanelFrmProductos() {
        initComponents();

        card = (CardLayout) FrmPrincipal.jPanelBranch.getLayout();

        cambiarColorBtn(jPanelProductos, btnProductos);

        inhabilitar();
        mostrar("");
        ocultar_columnas();

        jTabla.getColumnModel().getColumn(1).setPreferredWidth(220);
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

    public JPanelFrmProductos(File file, List<JTable> tabla, List<String> nom_files)
            throws Exception {
        this.file = file;
        this.tabla = tabla;
        this.nom_files = nom_files;
        if (nom_files.size() != tabla.size()) {
            throw new Exception("Error");
        }
    }

    public boolean export() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            WritableWorkbook w = Workbook.createWorkbook(out);
            for (int index = 0; index < tabla.size(); index++) {
                JTable table = tabla.get(index);
                WritableSheet s = w.createSheet(nom_files.get(index), 0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    String NomCol = table.getColumnName(i);
                    s.addCell(new Label(i, 0, NomCol));

                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object object = table.getValueAt(j, i);
                        s.addCell(new Label(i, j + 1, String.valueOf(object))); //lo pone en la fila 0+1
                    }
                }
            }
            w.write();
            w.close();
            out.close();
            return true;
        } catch (IOException | WriteException e) {
            System.out.println("Error al exportar a Excel:" + e.getMessage());
            return false;
        }
    }

    public void ocultar_columnas() {
        jTabla.getColumnModel().getColumn(7).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(7).setMinWidth(0);
        jTabla.getColumnModel().getColumn(7).setPreferredWidth(0);
        jTabla.getColumnModel().getColumn(8).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(8).setMinWidth(0);
        jTabla.getColumnModel().getColumn(8).setPreferredWidth(0);
        jTabla.getColumnModel().getColumn(9).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(9).setMinWidth(0);
        jTabla.getColumnModel().getColumn(9).setPreferredWidth(0);
    }

    public void inhabilitar() {

        txtCod_Producto.setEditable(false);
        txtRazon_Social.setEditable(false);
        txtNombre_Producto.setEditable(false);
        txtDescripcion.setEditable(false);
        jComboBox2.setEditable(false);
        txtValorDolar.setEditable(false);
        txtPrecio_Venta.setEditable(false);
        txtPrecio_Compra.setEditable(false);
        txtExistencia.setEditable(false);

        txtBuscar.setEditable(false);

        btnBuscar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);

        btnNuevo.setEnabled(true);

        txtCod_Producto.setText("");
        txtRazon_Social.setText("");
        txtNombre_Producto.setText("");
        txtDescripcion.setText("");
        jComboBox2.setSelectedIndex(0);
        txtValorDolar.setText("");
        txtPrecio_Venta.setText("");
        txtPrecio_Compra.setText("");
        txtExistencia.setText("");
    }

    public void habilitar() {

        txtCod_Producto.setEditable(true);
        txtRazon_Social.setEditable(true);
        txtNombre_Producto.setEditable(true);
        txtDescripcion.setEditable(true);
        jComboBox2.setEditable(true);
        txtValorDolar.setEditable(true);
        txtPrecio_Venta.setEditable(true);
        txtPrecio_Compra.setEditable(true);
        txtExistencia.setEditable(true);
        txtBuscar.setEditable(true);

        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);

        txtCod_Producto.setText("");
        txtRazon_Social.setText("");
        txtNombre_Producto.setText("");
        txtDescripcion.setText("");
        jComboBox2.setSelectedIndex(0);
        txtValorDolar.setText("");
        txtPrecio_Venta.setText("");
        txtPrecio_Compra.setText("");
        txtExistencia.setText("");
    }

    public void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            DAO_Producto funcion = new DAO_Producto();
            modelo = funcion.mostrar(buscar);
            jTabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        DAO_Producto funcion = new DAO_Producto();
        jComboBox1.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();
        lista = funcion.llenar_combo();
        for (int i = 0; i < lista.size(); i++) {
            jComboBox1.addItem(lista.get(i));
        }
    }

    public void mostrarExportar(String buscar) {
        try {
            DefaultTableModel modelo;
            DAO_Producto funcion = new DAO_Producto();
            modelo = funcion.mostrarExportar(buscar);
            jTabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cambiarColorBtn(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(204, 204, 204));
        btn.setForeground(new java.awt.Color(255, 50, 0));
    }

    public void cambiarColorLinea(JPanel panel) {
        lineaCodigo.setBackground(new java.awt.Color(153, 153, 153));
        lineaProveedor.setBackground(new java.awt.Color(153, 153, 153));
        lineaNumero.setBackground(new java.awt.Color(153, 153, 153));
        lineaDescripcion.setBackground(new java.awt.Color(153, 153, 153));
        lineaValorDolar.setBackground(new java.awt.Color(153, 153, 153));
        lineaPrecioVenta.setBackground(new java.awt.Color(153, 153, 153));
        lineaPrecioCompra.setBackground(new java.awt.Color(153, 153, 153));
        lineaExistencia.setBackground(new java.awt.Color(153, 153, 153));
        lineaAlmacen.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBackground(new java.awt.Color(255, 50, 0));
    }

    public void cambiarColorLineaDefecto() {
        lineaCodigo.setBackground(new java.awt.Color(153, 153, 153));
        lineaProveedor.setBackground(new java.awt.Color(153, 153, 153));
        lineaNumero.setBackground(new java.awt.Color(153, 153, 153));
        lineaDescripcion.setBackground(new java.awt.Color(153, 153, 153));
        lineaValorDolar.setBackground(new java.awt.Color(153, 153, 153));
        lineaPrecioVenta.setBackground(new java.awt.Color(153, 153, 153));
        lineaPrecioCompra.setBackground(new java.awt.Color(153, 153, 153));
        lineaExistencia.setBackground(new java.awt.Color(153, 153, 153));
        lineaAlmacen.setBackground(new java.awt.Color(153, 153, 153));
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio_Compra = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtRazon_Social = new javax.swing.JTextField();
        txtCod_Producto = new javax.swing.JTextField();
        txtPrecio_Venta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txtNombre_Producto = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        lineaCodigo = new javax.swing.JPanel();
        lineaProveedor = new javax.swing.JPanel();
        lineaPrecioVenta = new javax.swing.JPanel();
        lineaDescripcion = new javax.swing.JPanel();
        lineaNumero = new javax.swing.JPanel();
        lineaPrecioCompra = new javax.swing.JPanel();
        lineaExistencia = new javax.swing.JPanel();
        lineaAlmacen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        txtValorDolar = new javax.swing.JTextField();
        lineaValorDolar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lineaBusqueda = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
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
        jPanel2.setPreferredSize(new java.awt.Dimension(830, 660));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel1.setPreferredSize(new java.awt.Dimension(822, 479));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 230));

        jLabel12.setText(" ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 534, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setText("Codigo :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Proveedor :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setText("Número Parte :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setText("Descripción :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 70, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel13.setText("Precio Venta :");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel7.setText("Precio Compra :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        txtPrecio_Compra.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPrecio_Compra.setBorder(null);
        txtPrecio_Compra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio_Compra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecio_CompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecio_CompraFocusLost(evt);
            }
        });
        txtPrecio_Compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio_CompraKeyTyped(evt);
            }
        });
        jPanel4.add(txtPrecio_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 150, 464, -1));

        txtDescripcion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtDescripcion.setBorder(null);
        txtDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jPanel4.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 70, 464, -1));

        txtRazon_Social.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        jPanel4.add(txtRazon_Social, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 30, 464, -1));

        txtCod_Producto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCod_Producto.setBorder(null);
        txtCod_Producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCod_Producto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCod_ProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCod_ProductoFocusLost(evt);
            }
        });
        txtCod_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_ProductoActionPerformed(evt);
            }
        });
        txtCod_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_ProductoKeyTyped(evt);
            }
        });
        jPanel4.add(txtCod_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 10, 464, -1));

        txtPrecio_Venta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPrecio_Venta.setBorder(null);
        txtPrecio_Venta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio_Venta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecio_VentaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecio_VentaFocusLost(evt);
            }
        });
        txtPrecio_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio_VentaActionPerformed(evt);
            }
        });
        txtPrecio_Venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio_VentaKeyTyped(evt);
            }
        });
        jPanel4.add(txtPrecio_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 130, 464, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setText("Existencia :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Ubicación" }));
        jComboBox1.setBorder(null);
        jComboBox1.setMinimumSize(new java.awt.Dimension(144, 18));
        jComboBox1.setPreferredSize(new java.awt.Dimension(144, 18));
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 190, 464, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel11.setText("Almacen :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        txtNombre_Producto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombre_Producto.setBorder(null);
        txtNombre_Producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre_Producto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre_ProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre_ProductoFocusLost(evt);
            }
        });
        jPanel4.add(txtNombre_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 50, 464, -1));

        txtExistencia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtExistencia.setBorder(null);
        txtExistencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtExistencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtExistenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtExistenciaFocusLost(evt);
            }
        });
        txtExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistenciaKeyTyped(evt);
            }
        });
        jPanel4.add(txtExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 170, 464, -1));

        lineaCodigo.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaCodigoLayout = new javax.swing.GroupLayout(lineaCodigo);
        lineaCodigo.setLayout(lineaCodigoLayout);
        lineaCodigoLayout.setHorizontalGroup(
            lineaCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaCodigoLayout.setVerticalGroup(
            lineaCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(lineaCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 26, 464, 2));

        lineaProveedor.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaProveedorLayout = new javax.swing.GroupLayout(lineaProveedor);
        lineaProveedor.setLayout(lineaProveedorLayout);
        lineaProveedorLayout.setHorizontalGroup(
            lineaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaProveedorLayout.setVerticalGroup(
            lineaProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 46, -1, -1));

        lineaPrecioVenta.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaPrecioVentaLayout = new javax.swing.GroupLayout(lineaPrecioVenta);
        lineaPrecioVenta.setLayout(lineaPrecioVentaLayout);
        lineaPrecioVentaLayout.setHorizontalGroup(
            lineaPrecioVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaPrecioVentaLayout.setVerticalGroup(
            lineaPrecioVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 146, -1, -1));

        lineaDescripcion.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaDescripcionLayout = new javax.swing.GroupLayout(lineaDescripcion);
        lineaDescripcion.setLayout(lineaDescripcionLayout);
        lineaDescripcionLayout.setHorizontalGroup(
            lineaDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaDescripcionLayout.setVerticalGroup(
            lineaDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 86, -1, -1));

        lineaNumero.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaNumeroLayout = new javax.swing.GroupLayout(lineaNumero);
        lineaNumero.setLayout(lineaNumeroLayout);
        lineaNumeroLayout.setHorizontalGroup(
            lineaNumeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaNumeroLayout.setVerticalGroup(
            lineaNumeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 66, -1, -1));

        lineaPrecioCompra.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaPrecioCompraLayout = new javax.swing.GroupLayout(lineaPrecioCompra);
        lineaPrecioCompra.setLayout(lineaPrecioCompraLayout);
        lineaPrecioCompraLayout.setHorizontalGroup(
            lineaPrecioCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaPrecioCompraLayout.setVerticalGroup(
            lineaPrecioCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 166, -1, -1));

        lineaExistencia.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaExistenciaLayout = new javax.swing.GroupLayout(lineaExistencia);
        lineaExistencia.setLayout(lineaExistenciaLayout);
        lineaExistenciaLayout.setHorizontalGroup(
            lineaExistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaExistenciaLayout.setVerticalGroup(
            lineaExistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 186, -1, -1));

        lineaAlmacen.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaAlmacenLayout = new javax.swing.GroupLayout(lineaAlmacen);
        lineaAlmacen.setLayout(lineaAlmacenLayout);
        lineaAlmacenLayout.setHorizontalGroup(
            lineaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaAlmacenLayout.setVerticalGroup(
            lineaAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 207, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setText("Tipo Moneda:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 90, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione tipo moneda", "Pesos", "Dolares" }));
        jComboBox2.setBorder(null);
        jComboBox2.setMinimumSize(new java.awt.Dimension(158, 18));
        jComboBox2.setPreferredSize(new java.awt.Dimension(158, 18));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox2FocusLost(evt);
            }
        });
        jPanel4.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 90, 464, -1));

        txtValorDolar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtValorDolar.setBorder(null);
        txtValorDolar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorDolarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorDolarFocusLost(evt);
            }
        });
        txtValorDolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorDolarActionPerformed(evt);
            }
        });
        jPanel4.add(txtValorDolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 110, 464, -1));

        lineaValorDolar.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout lineaValorDolarLayout = new javax.swing.GroupLayout(lineaValorDolar);
        lineaValorDolar.setLayout(lineaValorDolarLayout);
        lineaValorDolarLayout.setHorizontalGroup(
            lineaValorDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );
        lineaValorDolarLayout.setVerticalGroup(
            lineaValorDolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaValorDolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 126, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 810, 240));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBuscar.setPreferredSize(new java.awt.Dimension(33, 18));
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
        jPanel3.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 120, 33));

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(25, 118, 210));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(25, 118, 210));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 20, -1, -1));

        btnExportar.setBackground(new java.awt.Color(204, 204, 204));
        btnExportar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/acceso.png"))); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jPanel3.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 20, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(65, 139, 66));
        jLabel20.setText("Nombre de Pieza :");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 122, -1));

        lineaBusqueda.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda.setPreferredSize(new java.awt.Dimension(120, 2));

        javax.swing.GroupLayout lineaBusquedaLayout = new javax.swing.GroupLayout(lineaBusqueda);
        lineaBusqueda.setLayout(lineaBusquedaLayout);
        lineaBusquedaLayout.setHorizontalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        lineaBusquedaLayout.setVerticalGroup(
            lineaBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.add(lineaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 53, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 545, 480, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(204, 204, 204));
        btnEditar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 545, 330, 60));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("GESTIÓN DE PRODUCTOS PARA VENTA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel10.setBackground(new java.awt.Color(65, 139, 66));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 305));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 610));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 830, 610));

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelProductos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductos.setPreferredSize(new java.awt.Dimension(130, 50));

        btnProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProductos.setText("Productos");
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        habilitar();
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(true);
        txtCod_Producto.setEditable(false);

        int fila = jTabla.rowAtPoint(evt.getPoint());

        txtCod_Producto.setText(jTabla.getValueAt(fila, 0).toString());
        txtRazon_Social.setText(jTabla.getValueAt(fila, 1).toString());
        txtNombre_Producto.setText(jTabla.getValueAt(fila, 2).toString());
        txtDescripcion.setText(jTabla.getValueAt(fila, 3).toString());

        String Moneda = jTabla.getValueAt(fila, 8).toString();
        if (Moneda.equalsIgnoreCase("Dolares")) {
            String precio_venta = jTabla.getValueAt(fila, 4).toString();
            String precio_compra = jTabla.getValueAt(fila, 5).toString();
            String dolar = jTabla.getValueAt(fila, 9).toString();

            float precioVenta = Float.parseFloat(precio_venta);
            float precioCompra = Float.parseFloat(precio_compra);
            float dollar = Float.parseFloat(dolar);
            
            float precioVentaDolar = precioVenta / dollar;
            float precioCompraDolar = precioCompra / dollar;

            txtPrecio_Venta.setText(precioVentaDolar + "");
            txtPrecio_Compra.setText(precioCompraDolar + "");

        } else {
            txtPrecio_Venta.setText(jTabla.getValueAt(fila, 4).toString());
            txtPrecio_Compra.setText(jTabla.getValueAt(fila, 5).toString());
        }
        txtExistencia.setText(jTabla.getValueAt(fila, 6).toString());
        jComboBox1.setSelectedItem(jTabla.getValueAt(fila, 7).toString());
        jComboBox2.setSelectedItem(jTabla.getValueAt(fila, 8).toString());
        txtValorDolar.setText(jTabla.getValueAt(fila, 9).toString());
    }//GEN-LAST:event_jTablaMouseClicked

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

        if (txtCod_Producto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
            return;
        }
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el producto?", "Confirmar Eliminacion", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            if (!txtCod_Producto.getText().equals("")) {
                DAO_Producto funcion = new DAO_Producto();
                Producto datos = new Producto();
                datos.setCod_Producto(txtCod_Producto.getText());
                funcion.eliminar(datos);
                mostrar("");
                inhabilitar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el producto.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed

        if (jTabla.getRowCount() > 0) {
            mostrarExportar(txtBuscar.getText());
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                List<JTable> tb = new ArrayList<JTable>();

                List<String> nom = new ArrayList<String>();
                tb.add(jTabla);
                nom.add("Productos");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    JPanelFrmProductos e = new JPanelFrmProductos(new File(file), tb, nom);
                    if (e.export()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados en excel al directorio seleccionado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos para exportar", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
        mostrar(txtBuscar.getText());

    }//GEN-LAST:event_btnExportarActionPerformed

    private void txtPrecio_CompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio_CompraKeyTyped

    }//GEN-LAST:event_txtPrecio_CompraKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped

    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtCod_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_ProductoActionPerformed

    private void txtCod_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_ProductoKeyTyped

    }//GEN-LAST:event_txtCod_ProductoKeyTyped

    private void txtPrecio_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio_VentaActionPerformed

    private void txtPrecio_VentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio_VentaKeyTyped

    }//GEN-LAST:event_txtPrecio_VentaKeyTyped

    private void txtExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistenciaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistenciaKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        /*PARTE VALIDACION DE CAMPOS*/
        if (txtCod_Producto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar código del producto.");
            txtCod_Producto.requestFocus();
            return;
        }

        if (txtRazon_Social.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la razón social.");
            txtRazon_Social.requestFocus();
            return;
        }

        if (txtNombre_Producto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre del producto.");
            txtNombre_Producto.requestFocus();
            return;
        }

        if (txtDescripcion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar descripción del producto.");
            txtDescripcion.requestFocus();
            return;
        }

        if (jComboBox2.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un tipo de moneda.");
            jComboBox2.requestFocus();
            return;
        }

        if (jComboBox2.getSelectedIndex() == 2 && txtValorDolar.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el valor del dolar.");
            txtValorDolar.requestFocus();
            return;
        }

        if (txtPrecio_Venta.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio de venta.");
            txtPrecio_Venta.requestFocus();
            return;
        }

        if (txtPrecio_Compra.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio de venta.");
            txtPrecio_Compra.requestFocus();
            return;
        }

        if (txtExistencia.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la existencia actual.");
            txtExistencia.requestFocus();
            return;
        }

        if (jComboBox1.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la ubicación del almacen.");
            jComboBox1.requestFocus();
            return;
        }

        Producto datos = new Producto();
        DAO_Producto funcion = new DAO_Producto();

        datos.setCod_Producto(txtCod_Producto.getText());
        datos.setProveedor(txtRazon_Social.getText());
        datos.setNombre_Producto(txtNombre_Producto.getText());
        datos.setDescripcion(txtDescripcion.getText());

        String tipoMoneda = (String) jComboBox2.getSelectedItem();
        datos.setTipo_Moneda(tipoMoneda);
        
        

        if (tipoMoneda.equalsIgnoreCase("Dolares")) {
            float dolar = Float.parseFloat(txtValorDolar.getText());
            datos.setDolar(dolar);
            
            float Precio_Venta = Float.parseFloat(txtPrecio_Venta.getText());
            float precioVentaPesos = Precio_Venta * dolar;
            datos.setPrecio_Venta(precioVentaPesos);

            float Precio_Compra = Float.parseFloat(txtPrecio_Compra.getText());
            float precioCompraPesos = Precio_Compra * dolar;
            datos.setPrecio_Compra(precioCompraPesos);
        } else {
            datos.setPrecio_Venta(Float.parseFloat(txtPrecio_Venta.getText()));
            datos.setPrecio_Compra(Float.parseFloat(txtPrecio_Compra.getText()));
            datos.setDolar(Float.parseFloat("0"));
        }

        datos.setExistencia(Integer.parseInt(txtExistencia.getText()));

        int almacen = jComboBox1.getSelectedIndex();
        String categoria2 = ((String) jComboBox1.getItemAt(almacen));

        if (funcion.insertar(datos, categoria2)) {
            JOptionPane.showMessageDialog(null, "Producto registrado exitosamente.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al ingresar producto.");
            mostrar("");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        /* PASAMOS TXT A DATOS*/
        Producto datos = new Producto();
        DAO_Producto funcion = new DAO_Producto();

        datos.setCod_Producto(txtCod_Producto.getText());
        datos.setProveedor(txtRazon_Social.getText());
        datos.setNombre_Producto(txtNombre_Producto.getText());
        datos.setDescripcion(txtDescripcion.getText());

        String tipoMoneda = (String) jComboBox2.getSelectedItem();
        datos.setTipo_Moneda(tipoMoneda);

        if (tipoMoneda.equalsIgnoreCase("Dolares")) {
            float dolar = Float.parseFloat(txtValorDolar.getText());
            datos.setDolar(dolar);
            
            float Precio_Venta = Float.parseFloat(txtPrecio_Venta.getText());
            float precioVentaPesos = Precio_Venta * dolar;
            datos.setPrecio_Venta(precioVentaPesos);

            float Precio_Compra = Float.parseFloat(txtPrecio_Compra.getText());
            float precioCompraPesos = Precio_Compra * dolar;
            datos.setPrecio_Compra(precioCompraPesos);
        } else {
            datos.setPrecio_Venta(Float.parseFloat(txtPrecio_Venta.getText()));
            datos.setPrecio_Compra(Float.parseFloat(txtPrecio_Compra.getText()));
            datos.setDolar(Float.parseFloat("0"));
        }

        datos.setExistencia(Integer.parseInt(txtExistencia.getText()));

        int almacen = jComboBox1.getSelectedIndex();
        String categoria2 = ((String) jComboBox1.getItemAt(almacen));

        if (funcion.editar(datos, categoria2)) {
            JOptionPane.showMessageDialog(null, "Producto editado exitosamente.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al editar producto.");
            mostrar("");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEntradaSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaSalidaMouseClicked
        JPanelFrmStock panel = new JPanelFrmStock();
        cambiarPanelContenedorBranch(panel, "EntradaSalida");
    }//GEN-LAST:event_btnEntradaSalidaMouseClicked

    private void btnEntradaSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaSalidaMouseEntered
        cambiarColorMenu(jPanelEntradaSalida, btnEntradaSalida);
    }//GEN-LAST:event_btnEntradaSalidaMouseEntered

    private void btnEntradaSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaSalidaMouseExited
        cambiarColorMenuDefecto(jPanelEntradaSalida, btnEntradaSalida);
    }//GEN-LAST:event_btnEntradaSalidaMouseExited

    private void btnUbicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseClicked
        JPanelFrmAlmacen panel = new JPanelFrmAlmacen();
        cambiarPanelContenedorBranch(panel, "Almacen");
    }//GEN-LAST:event_btnUbicacionMouseClicked

    private void btnUbicacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseEntered
        cambiarColorMenu(jPanelUbicacion, btnUbicacion);
    }//GEN-LAST:event_btnUbicacionMouseEntered

    private void btnUbicacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbicacionMouseExited
        cambiarColorMenuDefecto(jPanelUbicacion, btnUbicacion);
    }//GEN-LAST:event_btnUbicacionMouseExited

    private void btnStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseClicked
        JPanelFrmConsultaStock panel = new JPanelFrmConsultaStock();
        cambiarPanelContenedorBranch(panel, "Stock");
    }//GEN-LAST:event_btnStockMouseClicked

    private void btnStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseEntered
        cambiarColorMenu(jPanelStock, btnStock);
    }//GEN-LAST:event_btnStockMouseEntered

    private void btnStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseExited
        cambiarColorMenuDefecto(jPanelStock, btnStock);
    }//GEN-LAST:event_btnStockMouseExited

    private void txtCod_ProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCod_ProductoFocusGained
        cambiarColorLinea(lineaCodigo);
    }//GEN-LAST:event_txtCod_ProductoFocusGained

    private void txtCod_ProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCod_ProductoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtCod_ProductoFocusLost

    private void txtRazon_SocialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRazon_SocialFocusGained
        cambiarColorLinea(lineaProveedor);
    }//GEN-LAST:event_txtRazon_SocialFocusGained

    private void txtRazon_SocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRazon_SocialFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtRazon_SocialFocusLost

    private void txtNombre_ProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre_ProductoFocusGained
        cambiarColorLinea(lineaNumero);
    }//GEN-LAST:event_txtNombre_ProductoFocusGained

    private void txtNombre_ProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre_ProductoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtNombre_ProductoFocusLost

    private void txtDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusGained
        cambiarColorLinea(lineaDescripcion);
    }//GEN-LAST:event_txtDescripcionFocusGained

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtPrecio_VentaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecio_VentaFocusGained
        cambiarColorLinea(lineaPrecioVenta);
    }//GEN-LAST:event_txtPrecio_VentaFocusGained

    private void txtPrecio_VentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecio_VentaFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtPrecio_VentaFocusLost

    private void txtPrecio_CompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecio_CompraFocusGained
        cambiarColorLinea(lineaPrecioCompra);
    }//GEN-LAST:event_txtPrecio_CompraFocusGained

    private void txtPrecio_CompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecio_CompraFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtPrecio_CompraFocusLost

    private void txtExistenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtExistenciaFocusGained
        cambiarColorLinea(lineaExistencia);
    }//GEN-LAST:event_txtExistenciaFocusGained

    private void txtExistenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtExistenciaFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtExistenciaFocusLost

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        cambiarColorLinea(lineaAlmacen);
    }//GEN-LAST:event_jComboBox1FocusGained

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_jComboBox1FocusLost

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        cambiarColorLinea(lineaBusqueda);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtBuscarFocusLost

    private void jComboBox2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2FocusGained

    private void jComboBox2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2FocusLost

    private void txtValorDolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorDolarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorDolarActionPerformed

    private void txtValorDolarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorDolarFocusGained
        cambiarColorLinea(lineaValorDolar);
    }//GEN-LAST:event_txtValorDolarFocusGained

    private void txtValorDolarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorDolarFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtValorDolarFocusLost

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if (jComboBox2.getSelectedItem().equals("Dolares")) {
            txtValorDolar.requestFocus();
            txtValorDolar.setEditable(true);
        } else {
            txtValorDolar.setEditable(false);
            txtValorDolar.setText("");
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel btnEntradaSalida;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel btnProductos;
    private javax.swing.JLabel btnStock;
    private javax.swing.JLabel btnUbicacion;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelEntradaSalida;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelStock;
    private javax.swing.JPanel jPanelUbicacion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JPanel lineaAlmacen;
    private javax.swing.JPanel lineaBusqueda;
    private javax.swing.JPanel lineaCodigo;
    private javax.swing.JPanel lineaDescripcion;
    private javax.swing.JPanel lineaExistencia;
    private javax.swing.JPanel lineaNumero;
    private javax.swing.JPanel lineaPrecioCompra;
    private javax.swing.JPanel lineaPrecioVenta;
    private javax.swing.JPanel lineaProveedor;
    private javax.swing.JPanel lineaValorDolar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCod_Producto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtNombre_Producto;
    private javax.swing.JTextField txtPrecio_Compra;
    private javax.swing.JTextField txtPrecio_Venta;
    private javax.swing.JTextField txtRazon_Social;
    private javax.swing.JTextField txtValorDolar;
    // End of variables declaration//GEN-END:variables
}
