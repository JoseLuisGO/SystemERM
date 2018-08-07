package Views;

import static Views.FrmPrincipal.deskPricipal;
import static Views.FrmConsultaProducto1.comprobarProducto;
import static Views.FrmConsultaCliente1.Comprueba;
import Model.Producto;
import Model.Venta;
import Model.DetalleVenta;
import DAO.DAO_Producto;
import DAO.DAO_Venta;
import Connection.DB_Manager;
import DAO.DAO_Configuracion;
import DAO.DAO_DetalleVenta;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public final class FrmVentaDetalle1 extends javax.swing.JInternalFrame {

    int foco;
    DB_Manager db_manager;
    Connection connection;
    DAO_Configuracion function;

    public FrmVentaDetalle1() {
        initComponents();

        db_manager = new DB_Manager();
        connection = db_manager.getConnection();
        function = new DAO_Configuracion();

        btnNuevo.setEnabled(false);
        btnRegistrarVenta.setEnabled(false);
        DetallesFormVenta();
        lblModo.setLabelFor(cboModoIngreso);
        lblModo.setDisplayedMnemonic('y');
        txtFactura.setFocusAccelerator('u');
        txtSubTotal.setFocusAccelerator('i');

        txtCantidadProducto.setFocusAccelerator('o');
        txtCod_producto.setFocusAccelerator('p');

        OcultaBotones();
        ocultar_columnas();
        Calendar c2 = new GregorianCalendar();
        dcFecha_venta.setCalendar(c2);
        txtStockDetalle.setVisible(false);
        txtStockDetalle1.setVisible(false);
        txtCantidadProducto.setEditable(false);

        txtSubTotal.setEditable(false);
        txtFactura.setEditable(true);
        txtDescuento.setEditable(true);

        btnClick.setVisible(false);

        txtNoVenta.setEditable(false);
        txtNoVenta.setText("0");
        btnBuscarCliente.requestFocus();

        txtSubPrecioCompra.setVisible(false);

        txtNombre_cliente.setText("Seleccione Cliente");
        txtCod_cliente.setText("");
        //mostrar("");

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
        jTabla.getColumnModel().getColumn(5).setMaxWidth(0);
        jTabla.getColumnModel().getColumn(5).setMinWidth(0);
        jTabla.getColumnModel().getColumn(5).setPreferredWidth(0);
    }

    public void limpiarProductosDetalle() {
        txtCod_producto.setText("");
        txtNombre_producto.setText("");
        txtCantidadProducto.setText("");
        txtPrecio_producto.setText("");
        txtStockDetalle1.setText("");
    }

    public void BuscarCodigoVenta() {

        DAO_Venta funcion = new DAO_Venta();
        int codigo = funcion.BuscarCodigoVenta();

        //ACA PODRIA PONER PARA EN UN LBL MOSTRAR EL NUMERO DE VENTA
        txtCod_venta.setText(String.valueOf(codigo));
        txtCod_ventaFK.setText(String.valueOf(codigo));
    }

    public void NfacturaAtxt() {
        DecimalFormat formateador = new DecimalFormat("000000");
        DAO_Venta funcion = new DAO_Venta();
        int Nfactura = funcion.BuscarNfacturas();

        Nfactura = Nfactura + 1;

        String format = formateador.format(Nfactura);

        txtNoVenta.setText(String.valueOf(format));
    }

    /**
     * ****BUSQUEDA SI EL CODIGO DEL PRODUCTO EXISTE**
     */
    public void seleccionProd() {

        DAO_DetalleVenta funcion = new DAO_DetalleVenta();
        long cod_producto = funcion.selecProd();

        if (cod_producto > 0) {
            txtCod_producto.setText(String.valueOf(cod_producto));

            String nombre_producto = funcion.SelectNombre();
            txtNombre_producto.setText(String.valueOf(nombre_producto));

            int stock_producto = funcion.selecStock();
            txtStockDetalle.setText(String.valueOf(stock_producto));

            float precio_producto = funcion.selectPrecio();
            txtPrecio_producto.setText(String.valueOf(precio_producto));

            float precio_compra = funcion.selectPrecioCompra();
            txtSubPrecioCompra.setText(String.valueOf(precio_compra));

            if (cboModoIngreso.getSelectedItem() == "Mayor") {
                txtCantidadProducto.setEditable(true);
                txtCantidadProducto.setText("");
                txtCod_producto.setEditable(false);
                foco = 1;
            } else if (cboModoIngreso.getSelectedItem() == "Unidad") {
                foco = 0;
                agregarProducto();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No existe el codigo en el sistema");
            txtCod_producto.requestFocus();
            txtCod_producto.setText("");
        }

    }

    public void DetallesFormVenta() {
        txtCod_usuario.setVisible(false);
        txtCod_cliente.setVisible(false);
        txtCod_venta.setVisible(false);
        txtNombre_cliente.setEditable(false);
        txtCod_detalle.setVisible(false);
        txtCod_ventaFK.setVisible(false);
        txtNombre_producto.setEditable(false);
        txtCantidadProducto.setEditable(false);
        txtPrecio_producto.setEditable(false);
        txtCod_producto.setEditable(false);
    }

    public void OcultaBotones() {
        btnbuscarProducto.setEnabled(false);
        btnAgregarProducto.setEnabled(false);
        btnQuitarProducto.setEnabled(false);
    }

    public void activaBotones() {
        btnbuscarProducto.setEnabled(true);
        btnAgregarProducto.setEnabled(true);
        btnQuitarProducto.setEnabled(true);
    }

    public boolean registrarVenta() {
        DAO_Venta funcion = new DAO_Venta();
        Calendar cal;
        int d, m, a;
        cal = dcFecha_venta.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        String comprobante = (String) cboComprobante.getSelectedItem();
        String tipoPago = (String) cboFormaPago.getSelectedItem();
        String tipoCambio = (String) cboTipoCambio.getSelectedItem();

        Venta datos = new Venta();
        datos.setId_UsuarioFK(Integer.parseInt(txtCod_usuario.getText()));
        datos.setId_ClienteFK(Integer.parseInt(txtCod_cliente.getText()));
        datos.setFecha_Venta(new Date(a, m, d));
        datos.setTipo_Comprobante(comprobante);
        datos.setFactura(txtFactura.getText());
        datos.setTipo_Pago(tipoPago);
        datos.setTipo_Cambio(tipoCambio);
        datos.setDescuento(Integer.parseInt(txtDescuento.getText()));
        datos.setSubTotal(Float.parseFloat(txtSubTotal.getText()));
        datos.setTotal_Venta(Float.parseFloat(txtTotalVenta.getText()));

        if (funcion.insertar(datos)) {
            BuscarCodigoVenta();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de datos de la venta.");
            return false;
        }
    }

    public boolean updateStock() {
        try {
            DAO_Producto funcion = new DAO_Producto();
            boolean returnV = false;
            for (int i = 0; i < jTabla.getRowCount(); i++) {
                String codProducto = (String) jTabla.getValueAt(i, 0);
                String cantidadd = (String) jTabla.getValueAt(i, 3);
                String stockk = (String) jTabla.getValueAt(i, 5);
                
                int cantidad = 0;
                int stock = Integer.parseInt(stockk);
                Producto datos = new Producto();
                datos.setCod_Producto(codProducto);

                cantidad = Integer.parseInt(cantidadd);
                stock = stock - cantidad;
                datos.setExistencia(stock);
                if (funcion.ModificarStockProductos(datos)) {
                    returnV = true;
                } else {
                    returnV = false;
                }
            }
            return returnV;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la actualizacion del stock" + e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean registrarDetalle() {
        try {
            DAO_DetalleVenta funcion = new DAO_DetalleVenta();
            boolean returnV = false;
            for (int i = 0; i < jTabla.getRowCount(); i++) {
                String codProducto = (String) jTabla.getValueAt(i, 0);
                String precio = (String) jTabla.getValueAt(i, 2);
                String cantidad = (String) jTabla.getValueAt(i, 3);
                String subtotal = (String) jTabla.getValueAt(i, 4);

                DetalleVenta datos = new DetalleVenta();
                datos.setCantidad_Detalle(Integer.parseInt(cantidad));
                datos.setCod_ProductoFK(codProducto);
                datos.setPrecio_Venta(Float.parseFloat(precio));
                datos.setId_VentaFK(Integer.parseInt(txtCod_ventaFK.getText()));
                datos.setSubtotal(Float.parseFloat(subtotal));

                if (funcion.insertar(datos) && updateStock()) {
                    returnV = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresaron datos del detalle de venta.");
                    returnV = false;
                }
            }
            return returnV;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de datos del detalle de venta" + e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean agregarProducto () {
        DecimalFormat formatea = new DecimalFormat("######.##");
        if (txtCod_producto.getText().length() == 0 || txtNombre_producto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
            btnbuscarProducto.requestFocus();
            return false;
        }
        if (txtCantidadProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese cantidad vendida");
            txtCantidadProducto.requestFocus();
            return false;
        }
        if (txtPrecio_producto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese precio del producto");
            txtPrecio_producto.requestFocus();
            return false;
        }

        int Cantidad = Integer.parseInt(txtCantidadProducto.getText());
        int Stock = Integer.parseInt(txtStockDetalle.getText());
        int Stockk = Integer.parseInt(txtStockDetalle1.getText());
        float var1 = Float.parseFloat(txtPrecio_producto.getText());
        float var2 = Float.parseFloat(txtCantidadProducto.getText());
        float resultadoDetalle = var1 * var2;
        float subTotal = resultadoDetalle;

        String valor = (String) cboTipoCambio.getSelectedItem();
        float total;
        if (valor.equalsIgnoreCase("Dolares")) {
            float st = subTotal;
            float dolar = function.getValueDollar();
            float dolares = (st * 1) / dolar;
            total = dolares;
        } else {
            float st = subTotal;
            total = st;
        }

        float valor2 = Float.parseFloat(txtSubTotal.getText());
        float resultado = total + valor2;

        int descuento = Integer.parseInt(txtDescuento.getText());
        float desc = (descuento * resultado) / 100;
        float resultadoDescuento = resultado - desc;

        if (FrmConsultaProducto1.jTabla.getRowCount() > 0) {
            try {
                DefaultTableModel modelo = (DefaultTableModel) jTabla.getModel();
                String[] dato = new String[6];

                if (Cantidad > Stock) {
                    JOptionPane.showMessageDialog(null, "La cantidad a vender supera el stock existente del producto disponible en almácen.");
                    txtCantidadProducto.setText("");
                } else {
                    int c = 0;
                    for (int i = 0; i < jTabla.getRowCount(); i++) {
                        Object codigo = jTabla.getValueAt(i, 0);
                        Object cant1 = jTabla.getValueAt(i, 3);
                        Object subt1 = jTabla.getValueAt(i, 4);
                        if (txtCod_producto.getText().equals(codigo)) {
                            int cantT = Cantidad + Integer.parseInt((String) cant1);
                            float subT = total + Float.parseFloat((String) subt1);
                            c++;
                            String mostrar0 = formatea.format(resultado);
                            txtSubTotal.setText(String.valueOf(mostrar0));

                            String mostrar3 = formatea.format(resultadoDescuento);
                            txtTotalVenta.setText(String.valueOf(mostrar3));
                            if (cantT > Stock) {
                                JOptionPane.showMessageDialog(null, "La cantidad a vender supera el stock existente del producto disponible en almácen.");
                            } else {
                                jTabla.setValueAt(String.valueOf(cantT), i, 3);
                                jTabla.setValueAt(String.valueOf(subT), i, 4);
                            }
                        }
                    }
                    if (c == 0) {
                        dato[0] = txtCod_producto.getText();
                        dato[1] = txtNombre_producto.getText();
                        dato[2] = txtPrecio_producto.getText();
                        dato[3] = txtCantidadProducto.getText();
                        dato[4] = "" + total;
                        dato[5] = "" + Stockk;

                        modelo.addRow(dato);
                        jTabla.setModel(modelo);

                        String mostrar0 = formatea.format(resultado);
                        txtSubTotal.setText(String.valueOf(mostrar0));

                        String mostrar3 = formatea.format(resultadoDescuento);
                        txtTotalVenta.setText(String.valueOf(mostrar3));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros", "PRODUCTOS", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        limpiarProductosDetalle();
        txtPrecio_producto.setEditable(false);
        txtCantidadProducto.setText("1");
        cboModoIngreso.setSelectedIndex(0);
        txtCod_producto.setEditable(true);
        txtCod_producto.requestFocus();
        txtCantidadProducto.setEditable(false);
        return true;
    }

    public void nuevo() {
        DefaultTableModel modelo = (DefaultTableModel) jTabla.getModel();
        for (int i = 0; i < jTabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        this.setClosable(true);
        txtSubTotal.setText("0");
        txtDescuento.setText("");
        txtDescuento.setEditable(true);
        txtFactura.setText("");
        txtFactura.setEditable(true);
        txtNoVenta.setText("");
        txtStockDetalle.setText("");
        txtStockDetalle1.setText("");
        txtCod_venta.setText("");
        txtCod_ventaFK.setText("");
        txtCod_detalle.setText("");

        txtSubTotal.setText("0");
        txtTotalVenta.setText("0");
        txtCod_producto.setText("");
        txtCod_producto.setEditable(false);
        txtNombre_producto.setText("");
        txtPrecio_producto.setText("");
        txtCantidadProducto.setText("");
        btnGuardar.setEnabled(true);
        txtNoVenta.setText("");
        btnNuevo.setEnabled(false);
        btnBuscarCliente.setEnabled(true);

        txtNombre_cliente.setText("Seleccione Cliente");
        txtCod_cliente.setText("");

        cboComprobante.setSelectedIndex(0);
        cboFormaPago.setSelectedIndex(0);
        cboTipoCambio.setSelectedIndex(0);

        btnQuitarProducto.setEnabled(false);
        btnbuscarProducto.setEnabled(false);
        btnAgregarProducto.setEnabled(false);
        btnRegistrarVenta.setEnabled(false);
        cboFormaPago.setEnabled(true);
        cboTipoCambio.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dcFecha_venta = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        cboComprobante = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre_cliente = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNoVenta = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cboFormaPago = new javax.swing.JComboBox<>();
        cboTipoCambio = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnRegistrarVenta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCod_producto = new javax.swing.JTextField();
        txtNombre_producto = new javax.swing.JTextField();
        txtPrecio_producto = new javax.swing.JTextField();
        txtCantidadProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnbuscarProducto = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();
        cboModoIngreso = new javax.swing.JComboBox<>();
        lblModo = new javax.swing.JLabel();
        txtStockDetalle1 = new javax.swing.JTextField();
        txtCod_cliente = new javax.swing.JTextField();
        txtCod_usuario = new javax.swing.JTextField();
        txtCod_ventaFK = new javax.swing.JTextField();
        txtCod_detalle = new javax.swing.JTextField();
        txtCod_venta = new javax.swing.JTextField();
        txtStockDetalle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombre_usuario = new javax.swing.JLabel();
        btnClick = new javax.swing.JButton();
        txtSubPrecioCompra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        jLabel19.setText("jLabel19");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        dcFecha_venta.setBackground(new java.awt.Color(36, 33, 33));
        dcFecha_venta.setForeground(new java.awt.Color(207, 207, 207));
        dcFecha_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 118, 210));
        jLabel2.setText("  Fecha :");

        cboComprobante.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reporte" }));
        cboComprobante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboComprobanteItemStateChanged(evt);
            }
        });
        cboComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboComprobanteActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 118, 210));
        jLabel4.setText("N° :");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(25, 118, 210));
        jLabel6.setText(" Cliente :");

        txtNombre_cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombre_cliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtNombre_cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(25, 118, 210));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/guardar.png"))); // NOI18N
        btnGuardar.setMnemonic('x');
        btnGuardar.setText("Iniciar ");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 118, 210));
        jLabel1.setText("    Tipo :");

        txtNoVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNoVenta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtNoVenta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoVentaKeyTyped(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(25, 118, 210));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/nuevo.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/buscar.png"))); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFecha_venta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboComprobante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNombre_cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNoVenta))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dcFecha_venta, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(5, 5, 5))))
                            .addComponent(btnBuscarCliente))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(cboComprobante))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabla.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Producto", "Nombre Producto", "Precio Venta", "Cantidad Vendida", "Subtotal", "stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabla.setGridColor(new java.awt.Color(204, 204, 204));
        jTabla.setRowHeight(20);
        jTabla.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTabla.setSelectionForeground(new java.awt.Color(0, 102, 0));
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabla);
        if (jTabla.getColumnModel().getColumnCount() > 0) {
            jTabla.getColumnModel().getColumn(0).setResizable(false);
            jTabla.getColumnModel().getColumn(1).setResizable(false);
            jTabla.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(238, 238, 238));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("SUBTOTAL");

        txtSubTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtSubTotal.setText("0");
        txtSubTotal.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });
        txtSubTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubTotalKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("TOTAL DE VENTA");

        txtTotalVenta.setEditable(false);
        txtTotalVenta.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVenta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtTotalVenta.setText("0");
        txtTotalVenta.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTotalVenta.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTotalVenta)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(4, 4, 4)
                .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(238, 238, 238));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("FORMA DE PAGO");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("TIPO DE CAMBIO");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu/coins17.png"))); // NOI18N

        txtFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtFactura.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtFactura.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtFactura.setVerifyInputWhenFocusTarget(false);
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });
        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("NO FACTURA");

        cboFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opcion...", "Contado", "Pagos", "Transferencia" }));

        cboTipoCambio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opcion...", "Pesos", "Dolares" }));
        cboTipoCambio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoCambioItemStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("DESCUENTO");

        txtDescuento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        jLabel21.setText("%");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addComponent(cboTipoCambio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel20)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                            .addComponent(txtDescuento))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        btnRegistrarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarVenta.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnRegistrarVenta.setForeground(new java.awt.Color(25, 118, 210));
        btnRegistrarVenta.setMnemonic('c');
        btnRegistrarVenta.setText("Registrar");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel13))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(25, 118, 210));
        jLabel11.setText("Cantidad :");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(25, 118, 210));
        jLabel12.setText("Precio :");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(25, 118, 210));
        jLabel7.setText("Producto :");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 118, 210));
        jLabel10.setText("Código :");

        txtCod_producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCod_producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtCod_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCod_producto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCod_productoCaretUpdate(evt);
            }
        });
        txtCod_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_productoActionPerformed(evt);
            }
        });
        txtCod_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_productoKeyTyped(evt);
            }
        });

        txtNombre_producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombre_producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtNombre_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre_producto.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                txtNombre_productoMouseWheelMoved(evt);
            }
        });
        txtNombre_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre_productoActionPerformed(evt);
            }
        });

        txtPrecio_producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPrecio_producto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtPrecio_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio_productoActionPerformed(evt);
            }
        });

        txtCantidadProducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCantidadProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        txtCantidadProducto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadProductoActionPerformed(evt);
            }
        });
        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });

        btnAgregarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/Agregarr.png"))); // NOI18N
        btnAgregarProducto.setMnemonic('a');
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnbuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnbuscarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnbuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/buscar.png"))); // NOI18N
        btnbuscarProducto.setText(" ");
        btnbuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarProductoActionPerformed(evt);
            }
        });

        btnQuitarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnQuitarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnQuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/Quitar.png"))); // NOI18N
        btnQuitarProducto.setMnemonic('s');
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });

        cboModoIngreso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cboModoIngreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad" }));
        cboModoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboModoIngresoActionPerformed(evt);
            }
        });

        lblModo.setBackground(new java.awt.Color(255, 255, 255));
        lblModo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblModo.setForeground(new java.awt.Color(25, 118, 210));
        lblModo.setText("Modo :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblModo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboModoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(252, 252, 252)
                                .addComponent(txtStockDetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtCod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboModoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModo)
                    .addComponent(txtStockDetalle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtCod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecio_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(btnQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );

        txtCod_ventaFK.setText(" ");

        txtCod_detalle.setText(" ");

        txtCod_venta.setText(" ");

        jLabel5.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(25, 118, 210));
        jLabel5.setText("USUARIO :");

        txtNombre_usuario.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        txtNombre_usuario.setForeground(new java.awt.Color(25, 118, 210));
        txtNombre_usuario.setText("Vendedor");

        btnClick.setText("prod");
        btnClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClickActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Cambria", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(25, 118, 210));
        jLabel16.setText("FORMULARIO DE VENTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClick)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtStockDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCod_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCod_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCod_ventaFK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCod_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 66, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod_ventaFK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre_usuario)
                    .addComponent(jLabel5)
                    .addComponent(btnClick)
                    .addComponent(txtSubPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        /*PARTE VALIDACION DE CAMPOS*/
        if (txtCod_cliente.getText().length() == 0 || txtNombre_cliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente.");
            btnBuscarCliente.requestFocus();
            return;
        }
        if (txtDescuento.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "El campo Descuento debe llevar un valor");
            txtDescuento.requestFocus();
            return;
        }
        if (txtFactura.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "El campo Factura debe llevar un valor");
            txtFactura.requestFocus();
            return;
        }
        if (cboFormaPago.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una Forma de Pago");
            cboFormaPago.requestFocus();
            return;
        }
        if (cboTipoCambio.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un Tipo de Cambio");
            cboTipoCambio.requestFocus();
            return;
        }

        this.setClosable(false);
        btnNuevo.setEnabled(true);
        txtDescuento.setEditable(false);
        activaBotones();
        btnGuardar.setEnabled(false);
        btnBuscarCliente.setEnabled(false);
        txtCod_producto.setEditable(true);
        txtCod_producto.requestFocus();
        txtCantidadProducto.setEditable(false);
        txtCantidadProducto.setText("1");
        btnRegistrarVenta.setEnabled(true);
        txtFactura.setEditable(false);
        cboFormaPago.setEnabled(false);
        cboTipoCambio.setEnabled(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnbuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarProductoActionPerformed

        comprobarProducto = 2;
        FrmConsultaProducto1 form = new FrmConsultaProducto1();
        deskPricipal.add(form);
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_btnbuscarProductoActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked

        txtCod_producto.setEditable(false);
        txtNombre_producto.setEditable(false);
        txtCantidadProducto.setEditable(false);
        txtPrecio_producto.setEditable(false);
        btnQuitarProducto.setEnabled(true);
        int fila = jTabla.rowAtPoint(evt.getPoint());
        txtCod_producto.setText(jTabla.getValueAt(fila, 0).toString());
        txtNombre_producto.setText(jTabla.getValueAt(fila, 1).toString());
        txtPrecio_producto.setText(jTabla.getValueAt(fila, 2).toString());
        txtCantidadProducto.setText(jTabla.getValueAt(fila, 3).toString());

    }//GEN-LAST:event_jTablaMouseClicked

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        DecimalFormat formatea = new DecimalFormat("######.##");
        if (txtCod_producto.getText().length() == 0 || txtNombre_producto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
            btnbuscarProducto.requestFocus();
            return;
        }
        if (txtCantidadProducto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese cantidad vendida");
            txtCantidadProducto.requestFocus();
            return;
        }
        if (txtPrecio_producto.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese precio del producto");
            txtPrecio_producto.requestFocus();
            return;
        }

        int Cantidad = Integer.parseInt(txtCantidadProducto.getText());
        int Stock = Integer.parseInt(txtStockDetalle.getText());
        int Stockk = Integer.parseInt(txtStockDetalle1.getText());
        float var1 = Float.parseFloat(txtPrecio_producto.getText());
        float var2 = Float.parseFloat(txtCantidadProducto.getText());
        float resultadoDetalle = var1 * var2;
        float subTotal = resultadoDetalle;

        String valor = (String) cboTipoCambio.getSelectedItem();
        float total;
        if (valor.equalsIgnoreCase("Dolares")) {
            float st = subTotal;
            float dolar = function.getValueDollar();
            float dolares = (st * 1) / dolar;
            total = dolares;
        } else {
            float st = subTotal;
            total = st;
        }

        float valor2 = Float.parseFloat(txtSubTotal.getText());
        float resultado = total + valor2;

        int descuento = Integer.parseInt(txtDescuento.getText());
        float desc = (descuento * resultado) / 100;
        float resultadoDescuento = resultado - desc;

        if (FrmConsultaProducto1.jTabla.getRowCount() > 0) {
            try {
                DefaultTableModel modelo = (DefaultTableModel) jTabla.getModel();
                String[] dato = new String[6];

                if (Cantidad > Stock) {
                    JOptionPane.showMessageDialog(null, "La cantidad a vender supera el stock existente del producto disponible en almácen.");
                    txtCantidadProducto.setText("");
                } else {
                    int c = 0;
                    for (int i = 0; i < jTabla.getRowCount(); i++) {
                        Object codigo = jTabla.getValueAt(i, 0);
                        Object cant1 = jTabla.getValueAt(i, 3);
                        Object subt1 = jTabla.getValueAt(i, 4);
                        if (txtCod_producto.getText().equals(codigo)) {
                            int cantT = Cantidad + Integer.parseInt((String) cant1);
                            float subT = total + Float.parseFloat((String) subt1);
                            c++;
                            String mostrar0 = formatea.format(resultado);
                            txtSubTotal.setText(String.valueOf(mostrar0));

                            String mostrar3 = formatea.format(resultadoDescuento);
                            txtTotalVenta.setText(String.valueOf(mostrar3));
                            if (cantT > Stock) {
                                JOptionPane.showMessageDialog(null, "La cantidad a vender supera el stock existente del producto disponible en almácen.");
                            } else {
                                jTabla.setValueAt(String.valueOf(cantT), i, 3);
                                jTabla.setValueAt(String.valueOf(subT), i, 4);
                            }
                        }
                    }
                    if (c == 0) {
                        dato[0] = txtCod_producto.getText();
                        dato[1] = txtNombre_producto.getText();
                        dato[2] = txtPrecio_producto.getText();
                        dato[3] = txtCantidadProducto.getText();
                        dato[4] = "" + total;
                        dato[5] = "" + Stockk;

                        modelo.addRow(dato);
                        jTabla.setModel(modelo);

                        String mostrar0 = formatea.format(resultado);
                        txtSubTotal.setText(String.valueOf(mostrar0));

                        String mostrar3 = formatea.format(resultadoDescuento);
                        txtTotalVenta.setText(String.valueOf(mostrar3));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros", "PRODUCTOS", JOptionPane.ERROR_MESSAGE);
        }
        limpiarProductosDetalle();
        txtPrecio_producto.setEditable(false);
        txtCantidadProducto.setText("1");
        cboModoIngreso.setSelectedIndex(0);
        txtCod_producto.setEditable(true);
        txtCod_producto.requestFocus();
        txtCantidadProducto.setEditable(false);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed

        DecimalFormat formatea = new DecimalFormat("######.##");
        if (!txtCod_producto.getText().equals("")) {

            DefaultTableModel modelo = (DefaultTableModel) jTabla.getModel();
            if (jTabla.getRowCount() > 0) {
                int fila = jTabla.getSelectedRow();
                if (fila >= 0) {
                    modelo.removeRow(fila);
                }
            }

            float valorProd = Float.parseFloat(txtPrecio_producto.getText());
            int cantidadProd = Integer.parseInt(txtCantidadProducto.getText());
            float valor2 = Float.parseFloat(txtSubTotal.getText());
            float resultadoDetalle = valorProd * cantidadProd;
            float subTotal = resultadoDetalle;
            String valor = (String) cboTipoCambio.getSelectedItem();
            float total;
            if (valor.equalsIgnoreCase("Dolares")) {
                float st = subTotal;
                float dolar = function.getValueDollar();
                float dolares = (st * 1) / dolar;
                total = dolares;
            } else {
                float st = subTotal;
                total = st;
            }
            float resultado = valor2 - total;

            int descuento = Integer.parseInt(txtDescuento.getText());
            float desc = (descuento * resultado) / 100;
            float resultadoDescuento = resultado - desc;

            String mostrar0 = formatea.format(resultado);
            txtSubTotal.setText(String.valueOf(mostrar0));

            String mostrar3 = formatea.format(resultadoDescuento);
            txtTotalVenta.setText(String.valueOf(mostrar3));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }
        limpiarProductosDetalle();
        txtPrecio_producto.setEditable(false);
        txtCantidadProducto.setEditable(false);
        txtCod_producto.setEditable(true);
        txtCantidadProducto.setText("1");
        txtCod_producto.setText("");
        txtCod_producto.requestFocus();
    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void txtNombre_productoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_txtNombre_productoMouseWheelMoved

    }//GEN-LAST:event_txtNombre_productoMouseWheelMoved

    private void btnClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClickActionPerformed

        seleccionProd();
        if (foco == 1) {
            txtCantidadProducto.requestFocus();
        } else if (foco == 0) {
            txtCod_producto.requestFocus();
        }

    }//GEN-LAST:event_btnClickActionPerformed

    private void txtCod_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_productoActionPerformed
        btnClickActionPerformed(evt);
    }//GEN-LAST:event_txtCod_productoActionPerformed

    private void txtCod_productoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCod_productoCaretUpdate

    }//GEN-LAST:event_txtCod_productoCaretUpdate


    private void txtCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadProductoActionPerformed

    }//GEN-LAST:event_txtCantidadProductoActionPerformed

    private void txtPrecio_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio_productoActionPerformed

    }//GEN-LAST:event_txtPrecio_productoActionPerformed

    private void txtCod_productoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_productoKeyTyped
        
    }//GEN-LAST:event_txtCod_productoKeyTyped

    private void cboComprobanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboComprobanteItemStateChanged

    }//GEN-LAST:event_cboComprobanteItemStateChanged

    private void cboComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboComprobanteActionPerformed

        if (cboComprobante.getSelectedItem() == "Factura") {
            NfacturaAtxt();
            txtNoVenta.setEditable(true);
        } else {
            txtNoVenta.setEditable(false);
            txtNoVenta.setText("0");
        }

    }//GEN-LAST:event_cboComprobanteActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed

        if (jTabla.getRowCount() > 0) {
            if (registrarVenta() && registrarDetalle()) {
                if (cboComprobante.getSelectedItem().equals("Factura")) {
                    /*
                    try {
                        int codigo = Integer.parseInt(txtCod_venta.getText());

                        JasperReport jr = (JasperReport) JRLoader.loadObject(VistaBoleta.class.getResource("/Reportes/RptFactura.jasper"));

                        String ruta = System.getProperty("user.dir");
                        ruta += "\\src\\ImagenesForm\\Logo (Gris, Actual).png";
                        System.out.println("PATH: " + ruta);

                        HashMap<String, Object> parametro = new HashMap<>();
                        parametro.put("path", ruta);
                        parametro.put("Id_Venta", codigo);

                        JasperPrint jp = JasperFillManager.fillReport(jr, parametro, cn);
                        JasperViewer jv = new JasperViewer(jp, false);
                        jv.show();
                        nuevo();
                        // JasperPrintManager.printReport( jp, true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "error" + e);
                    }
                     */
                } else if (cboComprobante.getSelectedItem().equals("Reporte")) {
                    try {
                        int codigo = Integer.parseInt(txtCod_venta.getText());

                        JasperReport jr = (JasperReport) JRLoader.loadObject(VistaReporte.class
                                .getResource("/Report/RptVenta.jasper"));

                        String ruta = System.getProperty("user.dir");
                        ruta += "\\src\\ImagenesForm\\Logo (Gris, Actual).png";
                        System.out.println("PATH: " + ruta);

                        HashMap<String, Object> parametro = new HashMap<>();
                        parametro.put("path", ruta);
                        parametro.put("cod_venta", codigo);
                        System.out.println(codigo);

                        /**
                         * Obtener utilidad
                         */
                        float utilidad = 0;
                        String SQL = "CALL getUtilidad(" + codigo + ")";
                        PreparedStatement ps = connection.prepareCall(SQL);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            utilidad = rs.getFloat(1);
                        }
                        parametro.put("utilidad", utilidad);

                        JasperPrint jp = JasperFillManager.fillReport(jr, parametro, connection);
                        JasperViewer jv = new JasperViewer(jp, false);
                        jv.setTitle("Venta" + codigo);
                        jv.show();
                        btnNuevo.setEnabled(true);
                        nuevo();
                    } catch (Exception e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(rootPane, "error" + e);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la Venta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Venta no generada ya que no posee registros.");
        }
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        FrmConsultaCliente1 form = new FrmConsultaCliente1();
        Comprueba = 2;
        deskPricipal.add(form);
        form.setIconifiable(true);
        form.setMaximizable(false);
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void cboModoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboModoIngresoActionPerformed

        if (cboModoIngreso.getSelectedItem() == "x Mayor") {
            txtCantidadProducto.setText("0");
            txtCantidadProducto.setEditable(false);
            txtNombre_producto.setEditable(false);
            txtStockDetalle.setEditable(false);
            txtPrecio_producto.setEditable(false);
            txtCod_producto.setEditable(true);
            txtCod_producto.requestFocus();
        } else if (cboModoIngreso.getSelectedItem() == "x Unidad") {
            txtCantidadProducto.setText("1");
            txtCod_producto.setEditable(true);
            txtCantidadProducto.setEditable(false);
            txtNombre_producto.setEditable(false);
            txtStockDetalle.setEditable(false);
            txtPrecio_producto.setEditable(false);
            txtCod_producto.requestFocus();
        }
    }//GEN-LAST:event_cboModoIngresoActionPerformed

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void txtNoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoVentaKeyTyped

    }//GEN-LAST:event_txtNoVentaKeyTyped

    private void txtFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyTyped

    }//GEN-LAST:event_txtFacturaKeyTyped

    private void txtSubTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubTotalKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSubTotalKeyTyped

    private void txtNombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_productoActionPerformed

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void cboTipoCambioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoCambioItemStateChanged
        
    }//GEN-LAST:event_cboTipoCambioItemStateChanged

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        if (txtDescuento.getText().equals("")) {

        } else {
            if (Integer.parseInt(txtDescuento.getText()) > 100) {
                JOptionPane.showMessageDialog(null, "El descuento no puede ser mayor al 100%");
                txtDescuento.setText("");
            }
        }
    }//GEN-LAST:event_txtDescuentoKeyReleased

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
            java.util.logging.Logger.getLogger(FrmVentaDetalle1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentaDetalle1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentaDetalle1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentaDetalle1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentaDetalle1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnClick;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnbuscarProducto;
    private javax.swing.JComboBox<String> cboComprobante;
    private javax.swing.JComboBox<String> cboFormaPago;
    private javax.swing.JComboBox<String> cboModoIngreso;
    private javax.swing.JComboBox<String> cboTipoCambio;
    private com.toedter.calendar.JDateChooser dcFecha_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabla;
    private javax.swing.JLabel lblModo;
    public static javax.swing.JTextField txtCantidadProducto;
    public static javax.swing.JTextField txtCod_cliente;
    private javax.swing.JTextField txtCod_detalle;
    public static javax.swing.JTextField txtCod_producto;
    public static javax.swing.JTextField txtCod_usuario;
    private javax.swing.JTextField txtCod_venta;
    private javax.swing.JTextField txtCod_ventaFK;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtNoVenta;
    public static javax.swing.JTextField txtNombre_cliente;
    public static javax.swing.JTextField txtNombre_producto;
    public static javax.swing.JLabel txtNombre_usuario;
    public static javax.swing.JTextField txtPrecio_producto;
    public static javax.swing.JTextField txtStockDetalle;
    public static javax.swing.JTextField txtStockDetalle1;
    public static javax.swing.JTextField txtSubPrecioCompra;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
