/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import static Views.FrmConsultaProducto.comprobarProducto;
import static Views.FrmConsultaCliente.Comprueba;
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
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jose_Gonzalez
 */
public class JPanelFrmVenta extends javax.swing.JPanel {

    int foco;
    DB_Manager db_manager;
    Connection connection;
    DAO_Configuracion function;

    public JPanelFrmVenta() {
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

    public boolean agregarProducto() {
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

        if (FrmConsultaProducto.jTabla.getRowCount() > 0) {
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

    public void cambiarColorBtn(JPanel panel, JLabel btn) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
        btn.setForeground(new java.awt.Color(255, 50, 0));
    }

    public void cambiarColorLinea(JPanel panel) {
        lineaCodigo.setBackground(new java.awt.Color(153, 153, 153));
        lineaCliente.setBackground(new java.awt.Color(204, 204, 204));
        lineaBusqueda1.setBackground(new java.awt.Color(204, 204, 204));
        lineaDescuento.setBackground(new java.awt.Color(153, 153, 153));
        lineaFactura.setBackground(new java.awt.Color(153, 153, 153));
        lineaPrecio.setBackground(new java.awt.Color(153, 153, 153));
        lineaProducto.setBackground(new java.awt.Color(153, 153, 153));
        lineaCantidad.setBackground(new java.awt.Color(153, 153, 153));
        panel.setBackground(new java.awt.Color(255, 50, 0));
    }

    public void cambiarColorLineaDefecto() {
        lineaCodigo.setBackground(new java.awt.Color(153, 153, 153));
        lineaCliente.setBackground(new java.awt.Color(204, 204, 204));
        lineaBusqueda1.setBackground(new java.awt.Color(204, 204, 204));
        lineaDescuento.setBackground(new java.awt.Color(153, 153, 153));
        lineaFactura.setBackground(new java.awt.Color(153, 153, 153));
        lineaPrecio.setBackground(new java.awt.Color(153, 153, 153));
        lineaProducto.setBackground(new java.awt.Color(153, 153, 153));
        lineaCantidad.setBackground(new java.awt.Color(153, 153, 153));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelVenta = new javax.swing.JPanel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
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
        lineaCodigo = new javax.swing.JPanel();
        lineaCantidad = new javax.swing.JPanel();
        lineaProducto = new javax.swing.JPanel();
        lineaPrecio = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        lineaBusqueda4 = new javax.swing.JPanel();
        lineaBusqueda5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cboFormaPago = new javax.swing.JComboBox<>();
        cboTipoCambio = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lineaDescuento = new javax.swing.JPanel();
        lineaFactura = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        lineaCliente = new javax.swing.JPanel();
        lineaBusqueda1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnRegistrarVenta = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelVenta.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanelVenta.setPreferredSize(new java.awt.Dimension(830, 660));
        jPanelVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelVenta.add(txtCod_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 29, -1, -1));
        jPanelVenta.add(txtCod_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 29, 15, -1));

        txtCod_ventaFK.setText(" ");
        jPanelVenta.add(txtCod_ventaFK, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 29, -1, -1));

        txtCod_detalle.setText(" ");
        jPanelVenta.add(txtCod_detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 29, -1, -1));

        txtCod_venta.setText(" ");
        jPanelVenta.add(txtCod_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 29, -1, -1));
        jPanelVenta.add(txtStockDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 29, 22, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USUARIO :");
        jPanelVenta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, -1, -1));

        txtNombre_usuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtNombre_usuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre_usuario.setText("Vendedor");
        jPanelVenta.add(txtNombre_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 29, 293, -1));

        btnClick.setText("prod");
        btnClick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClickActionPerformed(evt);
            }
        });
        jPanelVenta.add(btnClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 28, -1, -1));
        jPanelVenta.add(txtSubPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 29, 14, -1));

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

        jPanelVenta.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 594, 312));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Cantidad :");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 42, -1, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Precio :");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 78, -1, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Producto :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 78, -1, 20));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Código :");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, -1, 20));

        txtCod_producto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCod_producto.setBorder(null);
        txtCod_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCod_producto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCod_productoCaretUpdate(evt);
            }
        });
        txtCod_producto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCod_productoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCod_productoFocusLost(evt);
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
        jPanel4.add(txtCod_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 41, 170, 25));

        txtNombre_producto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombre_producto.setBorder(null);
        txtNombre_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre_producto.setPreferredSize(new java.awt.Dimension(2, 25));
        txtNombre_producto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre_productoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre_productoFocusLost(evt);
            }
        });
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
        jPanel4.add(txtNombre_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 77, 170, -1));

        txtPrecio_producto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtPrecio_producto.setBorder(null);
        txtPrecio_producto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecio_producto.setPreferredSize(new java.awt.Dimension(2, 25));
        txtPrecio_producto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecio_productoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecio_productoFocusLost(evt);
            }
        });
        txtPrecio_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio_productoActionPerformed(evt);
            }
        });
        jPanel4.add(txtPrecio_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 77, 172, -1));

        txtCantidadProducto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCantidadProducto.setBorder(null);
        txtCantidadProducto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCantidadProducto.setPreferredSize(new java.awt.Dimension(2, 25));
        txtCantidadProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadProductoFocusLost(evt);
            }
        });
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
        jPanel4.add(txtCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 41, 172, -1));

        btnAgregarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/agregar.png"))); // NOI18N
        btnAgregarProducto.setMnemonic('a');
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 41, 109, 30));

        btnbuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnbuscarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnbuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnbuscarProducto.setText(" ");
        btnbuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarProductoActionPerformed(evt);
            }
        });
        jPanel4.add(btnbuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 5, 109, 30));

        btnQuitarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarProducto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnQuitarProducto.setForeground(new java.awt.Color(207, 207, 207));
        btnQuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/quitar.png"))); // NOI18N
        btnQuitarProducto.setMnemonic('s');
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });
        jPanel4.add(btnQuitarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 77, 109, 30));

        cboModoIngreso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cboModoIngreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad" }));
        cboModoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboModoIngresoActionPerformed(evt);
            }
        });
        jPanel4.add(cboModoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 9, 99, -1));

        lblModo.setBackground(new java.awt.Color(255, 255, 255));
        lblModo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblModo.setText("Modo :");
        jPanel4.add(lblModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 12, -1, -1));
        jPanel4.add(txtStockDetalle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 10, 55, -1));

        lineaCodigo.setBackground(new java.awt.Color(153, 153, 153));
        lineaCodigo.setPreferredSize(new java.awt.Dimension(170, 2));

        javax.swing.GroupLayout lineaCodigoLayout = new javax.swing.GroupLayout(lineaCodigo);
        lineaCodigo.setLayout(lineaCodigoLayout);
        lineaCodigoLayout.setHorizontalGroup(
            lineaCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        lineaCodigoLayout.setVerticalGroup(
            lineaCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 66, -1, -1));

        lineaCantidad.setBackground(new java.awt.Color(153, 153, 153));
        lineaCantidad.setPreferredSize(new java.awt.Dimension(172, 2));

        javax.swing.GroupLayout lineaCantidadLayout = new javax.swing.GroupLayout(lineaCantidad);
        lineaCantidad.setLayout(lineaCantidadLayout);
        lineaCantidadLayout.setHorizontalGroup(
            lineaCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        lineaCantidadLayout.setVerticalGroup(
            lineaCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 66, -1, -1));

        lineaProducto.setBackground(new java.awt.Color(153, 153, 153));
        lineaProducto.setPreferredSize(new java.awt.Dimension(170, 2));

        javax.swing.GroupLayout lineaProductoLayout = new javax.swing.GroupLayout(lineaProducto);
        lineaProducto.setLayout(lineaProductoLayout);
        lineaProductoLayout.setHorizontalGroup(
            lineaProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        lineaProductoLayout.setVerticalGroup(
            lineaProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 102, -1, -1));

        lineaPrecio.setBackground(new java.awt.Color(153, 153, 153));
        lineaPrecio.setPreferredSize(new java.awt.Dimension(172, 2));

        javax.swing.GroupLayout lineaPrecioLayout = new javax.swing.GroupLayout(lineaPrecio);
        lineaPrecio.setLayout(lineaPrecioLayout);
        lineaPrecioLayout.setHorizontalGroup(
            lineaPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        lineaPrecioLayout.setVerticalGroup(
            lineaPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel4.add(lineaPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 102, -1, -1));

        jPanelVenta.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 590, 120));
        jPanelVenta.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 31, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("SUBTOTAL");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        txtSubTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtSubTotal.setText("0");
        txtSubTotal.setBorder(null);
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
        jPanel6.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 160, 34));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("TOTAL DE VENTA");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        txtTotalVenta.setEditable(false);
        txtTotalVenta.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalVenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalVenta.setText("0");
        txtTotalVenta.setBorder(null);
        txtTotalVenta.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTotalVenta.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel6.add(txtTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 91, 160, 29));

        lineaBusqueda4.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda4.setPreferredSize(new java.awt.Dimension(160, 2));

        javax.swing.GroupLayout lineaBusqueda4Layout = new javax.swing.GroupLayout(lineaBusqueda4);
        lineaBusqueda4.setLayout(lineaBusqueda4Layout);
        lineaBusqueda4Layout.setHorizontalGroup(
            lineaBusqueda4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        lineaBusqueda4Layout.setVerticalGroup(
            lineaBusqueda4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel6.add(lineaBusqueda4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, -1, -1));

        lineaBusqueda5.setBackground(new java.awt.Color(153, 153, 153));
        lineaBusqueda5.setPreferredSize(new java.awt.Dimension(160, 2));

        javax.swing.GroupLayout lineaBusqueda5Layout = new javax.swing.GroupLayout(lineaBusqueda5);
        lineaBusqueda5.setLayout(lineaBusqueda5Layout);
        lineaBusqueda5Layout.setHorizontalGroup(
            lineaBusqueda5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        lineaBusqueda5Layout.setVerticalGroup(
            lineaBusqueda5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel6.add(lineaBusqueda5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jPanelVenta.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 180, 130));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 139, 66)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("FORMA DE PAGO");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("TIPO DE CAMBIO");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtFactura.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtFactura.setBorder(null);
        txtFactura.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtFactura.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtFactura.setVerifyInputWhenFocusTarget(false);
        txtFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFacturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFacturaFocusLost(evt);
            }
        });
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
        jPanel7.add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 160, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 147, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setText("NO FACTURA");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        cboFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opcion...", "Contado", "Pagos", "Transferencia" }));
        jPanel7.add(cboFormaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 24));

        cboTipoCambio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opcion...", "Pesos", "Dolares" }));
        cboTipoCambio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTipoCambioItemStateChanged(evt);
            }
        });
        jPanel7.add(cboTipoCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("DESCUENTO");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 84, -1));

        txtDescuento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtDescuento.setBorder(null);
        txtDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusLost(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });
        jPanel7.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 84, 20));

        jLabel21.setText("%");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        lineaDescuento.setBackground(new java.awt.Color(153, 153, 153));
        lineaDescuento.setPreferredSize(new java.awt.Dimension(84, 2));

        javax.swing.GroupLayout lineaDescuentoLayout = new javax.swing.GroupLayout(lineaDescuento);
        lineaDescuento.setLayout(lineaDescuentoLayout);
        lineaDescuentoLayout.setHorizontalGroup(
            lineaDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
        lineaDescuentoLayout.setVerticalGroup(
            lineaDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel7.add(lineaDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, -1, -1));

        lineaFactura.setBackground(new java.awt.Color(153, 153, 153));
        lineaFactura.setPreferredSize(new java.awt.Dimension(160, 2));

        javax.swing.GroupLayout lineaFacturaLayout = new javax.swing.GroupLayout(lineaFactura);
        lineaFactura.setLayout(lineaFacturaLayout);
        lineaFacturaLayout.setHorizontalGroup(
            lineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        lineaFacturaLayout.setVerticalGroup(
            lineaFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel7.add(lineaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 112, -1, -1));

        jPanelVenta.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 180, 240));

        jPanel2.setBackground(new java.awt.Color(65, 139, 66));

        jPanel3.setBackground(new java.awt.Color(65, 139, 66));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dcFecha_venta.setBackground(new java.awt.Color(255, 255, 255));
        dcFecha_venta.setForeground(new java.awt.Color(207, 207, 207));
        dcFecha_venta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jPanel3.add(dcFecha_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 179, 23));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  Fecha :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 60, -1));

        cboComprobante.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        jPanel3.add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 79, 179, 24));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("N° :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 71, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Cliente :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 38));

        txtNombre_cliente.setBackground(new java.awt.Color(65, 139, 66));
        txtNombre_cliente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNombre_cliente.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre_cliente.setBorder(null);
        txtNombre_cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre_cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre_clienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre_clienteFocusLost(evt);
            }
        });
        jPanel3.add(txtNombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 260, 38));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/guardar.png"))); // NOI18N
        btnGuardar.setMnemonic('x');
        btnGuardar.setText("Iniciar ");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, 38));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("    Tipo :");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 60, -1));

        txtNoVenta.setBackground(new java.awt.Color(65, 139, 66));
        txtNoVenta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtNoVenta.setForeground(new java.awt.Color(255, 255, 255));
        txtNoVenta.setBorder(null);
        txtNoVenta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNoVenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNoVentaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNoVentaFocusLost(evt);
            }
        });
        txtNoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoVentaKeyTyped(evt);
            }
        });
        jPanel3.add(txtNoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 70, 159, 30));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/nuevo.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 99, 38));

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/buscar.png"))); // NOI18N
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(57, 38));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 53, -1));

        lineaCliente.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout lineaClienteLayout = new javax.swing.GroupLayout(lineaCliente);
        lineaCliente.setLayout(lineaClienteLayout);
        lineaClienteLayout.setHorizontalGroup(
            lineaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        lineaClienteLayout.setVerticalGroup(
            lineaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.add(lineaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 48, 260, 2));

        lineaBusqueda1.setBackground(new java.awt.Color(204, 204, 204));
        lineaBusqueda1.setPreferredSize(new java.awt.Dimension(159, 2));

        javax.swing.GroupLayout lineaBusqueda1Layout = new javax.swing.GroupLayout(lineaBusqueda1);
        lineaBusqueda1.setLayout(lineaBusqueda1Layout);
        lineaBusqueda1Layout.setHorizontalGroup(
            lineaBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        lineaBusqueda1Layout.setVerticalGroup(
            lineaBusqueda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.add(lineaBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 100, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("FORMULARIO DE VENTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(293, 293, 293))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jPanelVenta.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 330));

        btnRegistrarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarVenta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Views/dinero.png"))); // NOI18N
        btnRegistrarVenta.setMnemonic('c');
        btnRegistrarVenta.setText("Registrar");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        jPanelVenta.add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 610, 170, 38));

        add(jPanelVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 660));
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtNoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoVentaKeyTyped

    }//GEN-LAST:event_txtNoVentaKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        FrmConsultaCliente form = new FrmConsultaCliente();
        Comprueba = 2;
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

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

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void txtSubTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubTotalKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSubTotalKeyTyped

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void txtFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyTyped

    }//GEN-LAST:event_txtFacturaKeyTyped

    private void cboTipoCambioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTipoCambioItemStateChanged

    }//GEN-LAST:event_cboTipoCambioItemStateChanged

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        if (txtDescuento.getText().equals("")) {

        } else {
            if (Integer.parseInt(txtDescuento.getText()) > 100) {
                JOptionPane.showMessageDialog(null, "El descuento no puede ser mayor al 100%");
                txtDescuento.setText("");
            }
        }
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed

        if (jTabla.getRowCount() > 0) {
            if (registrarVenta() && registrarDetalle()) {
                JOptionPane.showMessageDialog(null, "Venta registrada Exitosamente");
                btnNuevo.setEnabled(true);
                nuevo();
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
                    /*
                    try {
                        int codigo = Integer.parseInt(txtCod_venta.getText());

                        JasperReport jr = (JasperReport) JRLoader.loadObject(VistaReporte.class
                            .getResource("/Report/RptVenta.jasper"));

                        String ruta = System.getProperty("user.dir");
                        ruta += "\\src\\Images\\Report\\Logo (Gris, Actual).png";
                        System.out.println("PATH: " + ruta);

                        HashMap<String, Object> parametro = new HashMap<>();
                        parametro.put("path", ruta);
                        parametro.put("cod_venta", codigo);
                        System.out.println(codigo);

                        
                        //Obtener utilidad
                        
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
                        JOptionPane.showMessageDialog(null, "error" + e);
                    }
                     */
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la Venta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Venta no generada ya que no posee registros.");
        }
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void txtCod_productoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCod_productoCaretUpdate

    }//GEN-LAST:event_txtCod_productoCaretUpdate

    private void txtCod_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_productoActionPerformed
        btnClickActionPerformed(evt);
    }//GEN-LAST:event_txtCod_productoActionPerformed

    private void txtCod_productoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_productoKeyTyped

    }//GEN-LAST:event_txtCod_productoKeyTyped

    private void txtNombre_productoMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_txtNombre_productoMouseWheelMoved

    }//GEN-LAST:event_txtNombre_productoMouseWheelMoved

    private void txtNombre_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_productoActionPerformed

    private void txtPrecio_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio_productoActionPerformed

    }//GEN-LAST:event_txtPrecio_productoActionPerformed

    private void txtCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadProductoActionPerformed

    }//GEN-LAST:event_txtCantidadProductoActionPerformed

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

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

        if (FrmConsultaProducto.jTabla.getRowCount() > 0) {
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
                            if (cantT > Stock) {
                                JOptionPane.showMessageDialog(null, "La cantidad a vender supera el stock existente del producto disponible en almácen.");
                                txtCantidadProducto.setText("");
                            } else {
                                //String mostrar0 = formatea.format(resultado);
                                txtSubTotal.setText(String.valueOf(resultado));

                                //String mostrar3 = formatea.format(resultadoDescuento);
                                txtTotalVenta.setText(String.valueOf(resultadoDescuento));

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

                        //String mostrar0 = formatea.format(resultado);
                        txtSubTotal.setText(String.valueOf(resultado));

                        //String mostrar3 = formatea.format(resultadoDescuento);
                        txtTotalVenta.setText(String.valueOf(resultadoDescuento));
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

    private void btnbuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarProductoActionPerformed

        comprobarProducto = 2;
        FrmConsultaProducto form = new FrmConsultaProducto();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscarProductoActionPerformed

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

    private void btnClickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClickActionPerformed

        seleccionProd();
        if (foco == 1) {
            txtCantidadProducto.requestFocus();
        } else if (foco == 0) {
            txtCod_producto.requestFocus();
        }
    }//GEN-LAST:event_btnClickActionPerformed

    private void txtNombre_clienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre_clienteFocusGained
        cambiarColorLinea(lineaCliente);
    }//GEN-LAST:event_txtNombre_clienteFocusGained

    private void txtNombre_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre_clienteFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtNombre_clienteFocusLost

    private void txtNoVentaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNoVentaFocusGained
        cambiarColorLinea(lineaBusqueda1);
    }//GEN-LAST:event_txtNoVentaFocusGained

    private void txtNoVentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNoVentaFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtNoVentaFocusLost

    private void txtDescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusGained
        cambiarColorLinea(lineaDescuento);
    }//GEN-LAST:event_txtDescuentoFocusGained

    private void txtDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtDescuentoFocusLost

    private void txtFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFacturaFocusGained
        cambiarColorLinea(lineaFactura);
    }//GEN-LAST:event_txtFacturaFocusGained

    private void txtFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFacturaFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtFacturaFocusLost

    private void txtCod_productoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCod_productoFocusGained
        cambiarColorLinea(lineaCodigo);
    }//GEN-LAST:event_txtCod_productoFocusGained

    private void txtCod_productoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCod_productoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtCod_productoFocusLost

    private void txtCantidadProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadProductoFocusGained
        cambiarColorLinea(lineaCantidad);
    }//GEN-LAST:event_txtCantidadProductoFocusGained

    private void txtCantidadProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadProductoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtCantidadProductoFocusLost

    private void txtPrecio_productoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecio_productoFocusGained
        cambiarColorLinea(lineaPrecio);
    }//GEN-LAST:event_txtPrecio_productoFocusGained

    private void txtPrecio_productoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecio_productoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtPrecio_productoFocusLost

    private void txtNombre_productoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre_productoFocusGained
        cambiarColorLinea(lineaProducto);
    }//GEN-LAST:event_txtNombre_productoFocusGained

    private void txtNombre_productoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre_productoFocusLost
        cambiarColorLineaDefecto();
    }//GEN-LAST:event_txtNombre_productoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAgregarProducto;
    public static javax.swing.JButton btnBuscarCliente;
    public static javax.swing.JButton btnClick;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    public static javax.swing.JButton btnQuitarProducto;
    public static javax.swing.JButton btnRegistrarVenta;
    public static javax.swing.JButton btnbuscarProducto;
    public static javax.swing.JComboBox<String> cboComprobante;
    public static javax.swing.JComboBox<String> cboFormaPago;
    public static javax.swing.JComboBox<String> cboModoIngreso;
    public static javax.swing.JComboBox<String> cboTipoCambio;
    public static com.toedter.calendar.JDateChooser dcFecha_venta;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel jPanel7;
    public static javax.swing.JPanel jPanelVenta;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTabla;
    public static javax.swing.JLabel lblModo;
    public static javax.swing.JPanel lineaBusqueda1;
    public static javax.swing.JPanel lineaBusqueda4;
    public static javax.swing.JPanel lineaBusqueda5;
    public static javax.swing.JPanel lineaCantidad;
    public static javax.swing.JPanel lineaCliente;
    public static javax.swing.JPanel lineaCodigo;
    public static javax.swing.JPanel lineaDescuento;
    public static javax.swing.JPanel lineaFactura;
    public static javax.swing.JPanel lineaPrecio;
    public static javax.swing.JPanel lineaProducto;
    public static javax.swing.JTextField txtCantidadProducto;
    public static javax.swing.JTextField txtCod_cliente;
    public static javax.swing.JTextField txtCod_detalle;
    public static javax.swing.JTextField txtCod_producto;
    public static javax.swing.JTextField txtCod_usuario;
    public static javax.swing.JTextField txtCod_venta;
    public static javax.swing.JTextField txtCod_ventaFK;
    public static javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtFactura;
    public static javax.swing.JTextField txtNoVenta;
    public static javax.swing.JTextField txtNombre_cliente;
    public static javax.swing.JTextField txtNombre_producto;
    public static javax.swing.JLabel txtNombre_usuario;
    public static javax.swing.JTextField txtPrecio_producto;
    public static javax.swing.JTextField txtStockDetalle;
    public static javax.swing.JTextField txtStockDetalle1;
    public static javax.swing.JTextField txtSubPrecioCompra;
    public static javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables

    private void setClosable(boolean b) {

    }
}
