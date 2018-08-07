package Views;

import static Views.FrmPrincipal.MenuProductos;
import Model.Producto;
import DAO.DAO_Producto;
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
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public final class FrmProductos extends javax.swing.JInternalFrame {

    private File file;
    private List<JTable> tabla;
    private List<String> nom_files;

    public FrmProductos() {
        initComponents();
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

    public FrmProductos(File file, List<JTable> tabla, List<String> nom_files)
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
    }

    public void inhabilitar() {

        txtCod_Producto.setEditable(false);
        txtRazon_Social.setEditable(false);
        txtNombre_Producto.setEditable(false);
        txtDescripcion.setEditable(false);
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
        txtPrecio_Venta.setText("");
        txtPrecio_Compra.setText("");
        txtExistencia.setText("");       
    }

    public void habilitar() {
        
        txtCod_Producto.setEditable(true);
        txtRazon_Social.setEditable(true);
        txtNombre_Producto.setEditable(true);        
        txtDescripcion.setEditable(true);
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
        jPanel3 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
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
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(822, 479));

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

        jLabel12.setText(" ");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtBuscar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(25, 118, 210));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(25, 118, 210));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/eliminar.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnExportar.setBackground(new java.awt.Color(204, 204, 204));
        btnExportar.setForeground(new java.awt.Color(25, 118, 210));
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(25, 118, 210));
        jLabel20.setText("Nombre de Pieza :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(4, 4, 4)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 118, 210));
        jLabel4.setText("Codigo :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 118, 210));
        jLabel2.setText("Proveedor :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(25, 118, 210));
        jLabel5.setText("Número Parte :");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(25, 118, 210));
        jLabel6.setText("Descripción :");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(25, 118, 210));
        jLabel13.setText("Precio Venta :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(25, 118, 210));
        jLabel7.setText("Precio Compra :");

        txtPrecio_Compra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecio_Compra.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtPrecio_Compra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio_Compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio_CompraKeyTyped(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        txtRazon_Social.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtRazon_Social.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtRazon_Social.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtCod_Producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCod_Producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtCod_Producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
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

        txtPrecio_Venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecio_Venta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtPrecio_Venta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
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

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(25, 118, 210));
        jLabel9.setText("Existencia :");

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Ubicación" }));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(25, 118, 210));
        jLabel11.setText("Almacen :");

        txtNombre_Producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombre_Producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtNombre_Producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtExistencia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtExistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtExistencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExistenciaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio_Compra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrecio_Venta)
                    .addComponent(txtCod_Producto)
                    .addComponent(txtRazon_Social)
                    .addComponent(txtDescripcion)
                    .addComponent(txtNombre_Producto)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtExistencia))
                .addGap(143, 143, 143))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRazon_Social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrecio_Venta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio_Compra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(25, 118, 210));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(25, 118, 210));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(204, 204, 204));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(25, 118, 210));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/editar.png"))); // NOI18N
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
                .addGap(17, 17, 17)
                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jLabel10.setFont(new java.awt.Font("Cambria", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 118, 210));
        jLabel10.setText("GESTIÓN DE PRODUCTOS PARA VENTA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jLabel10)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        /* PASAMOS TXT A DATOS*/
        Producto datos = new Producto();
        DAO_Producto funcion = new DAO_Producto();
        
        datos.setCod_Producto(txtCod_Producto.getText());
        datos.setProveedor(txtRazon_Social.getText());
        datos.setNombre_Producto(txtNombre_Producto.getText());        
        datos.setDescripcion(txtDescripcion.getText());
        
        String Precio_Venta = txtPrecio_Venta.getText();
        datos.setPrecio_Venta(Float.parseFloat(Precio_Venta));
        
        String Precio_Compra = txtPrecio_Compra.getText();
        datos.setPrecio_Compra(Float.parseFloat(Precio_Compra));
        
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

        if (txtExistencia.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "Debe ingresar la existencia actual.");
            txtExistencia.requestFocus();
            return;
        }        

        if (jComboBox1.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la ubicación del almacen.");
            MenuProductos.requestFocus();
            this.dispose();
            return;
        }
        
        Producto datos = new Producto();
        DAO_Producto funcion = new DAO_Producto();

        datos.setCod_Producto(txtCod_Producto.getText());
        datos.setProveedor(txtRazon_Social.getText());
        datos.setNombre_Producto(txtNombre_Producto.getText());        
        datos.setDescripcion(txtDescripcion.getText());
        
        String Precio_Venta = txtPrecio_Venta.getText();
        datos.setPrecio_Venta(Float.parseFloat(Precio_Venta));
        
        String Precio_Compra = txtPrecio_Compra.getText();
        datos.setPrecio_Compra(Float.parseFloat(Precio_Compra));
        
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
        txtPrecio_Venta.setText(jTabla.getValueAt(fila, 4).toString());
        txtPrecio_Compra.setText(jTabla.getValueAt(fila, 5).toString());
        txtExistencia.setText(jTabla.getValueAt(fila, 6).toString());        
        jComboBox1.setSelectedItem(jTabla.getValueAt(fila, 7).toString());

    }//GEN-LAST:event_jTablaMouseClicked

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

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();            
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtPrecio_VentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio_VentaKeyTyped
        
    }//GEN-LAST:event_txtPrecio_VentaKeyTyped

    private void txtCod_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_ProductoKeyTyped
        
    }//GEN-LAST:event_txtCod_ProductoKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtPrecio_CompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio_CompraKeyTyped
        
    }//GEN-LAST:event_txtPrecio_CompraKeyTyped

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
                    FrmProductos e = new FrmProductos(new File(file), tb, nom);
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

    private void txtExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExistenciaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistenciaKeyTyped

    private void txtPrecio_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio_VentaActionPerformed

    private void txtCod_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCod_ProductoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>       
        //</editor-fold>       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCod_Producto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtNombre_Producto;
    private javax.swing.JTextField txtPrecio_Compra;
    private javax.swing.JTextField txtPrecio_Venta;
    private javax.swing.JTextField txtRazon_Social;
    // End of variables declaration//GEN-END:variables
}