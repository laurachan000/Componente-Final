
package componente;

import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.jbarcodebean.JBarcodeBean;

/**
 *
 * @author chan oliva
 */


public class Propiedades extends Principal{

    public DefaultTableModel getModel() {
        return model;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public JLabel getLblCantidad() {
        return lblCantidad;
    }

    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    public JLabel getLblCodigo() {
        return lblCodigo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTable getTabla() {
        return tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JLabel getLblcodigo() {
        return lblcodigo;
    }

    public JBarcodeBean getBarcode() {
        return barcode;
    }

    public static BufferedImage getImage() {
        return image;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public void setLblCantidad(JLabel lblCantidad) {
        this.lblCantidad = lblCantidad;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        this.lblCodigo = lblCodigo;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public void setTxtCantidad(JTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public void setLblcodigo(JLabel lblcodigo) {
        this.lblcodigo = lblcodigo;
    }

    public void setBarcode(JBarcodeBean barcode) {
        this.barcode = barcode;
    }

    public static void setImage(BufferedImage image) {
        Principal.image = image;
    }
    
    
    
    
    
}
