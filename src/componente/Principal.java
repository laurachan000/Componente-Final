package componente;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Interleaved25;


public class Principal extends JFrame implements Serializable {
    
    DefaultTableModel model;

    
    JButton btnGuardar;
    JButton btnEvento;
    JLabel lblNombre;
    JLabel lblCantidad;
    JLabel lblPrecio;
    JLabel lblCodigo;
    
    JTextField txtNombre;
    JTextField txtCantidad;
    JTextField txtPrecio;
    JTextField txtCodigo;
    
    JTable tabla;
    JScrollPane scroll;
    JLabel lblcodigo;
    ImageIcon barras;
   
    JBarcodeBean barcode = new JBarcodeBean();
    public static BufferedImage image = null;
    


    public Principal () {
        
        super("Trabajo final");
            
            Container contenedorPrincipal = getContentPane();
            contenedorPrincipal.setLayout(new GridLayout(0,1));
            
            JPanel panelarriba = new JPanel();
            panelarriba.setLayout(new GridLayout(1,2));
            
            JPanel panelRegistro = new JPanel();
            panelRegistro.setBackground(Color.lightGray);
            panelRegistro.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
            panelRegistro.setLayout(new GridLayout(5,2) );
            
            lblNombre = new JLabel("Nombre del producto:");
            txtNombre = new JTextField("");
            
            lblCantidad = new JLabel("Cantidad:");
            txtCantidad = new JTextField("");
            
            lblPrecio = new JLabel("Precio $:");
            txtPrecio = new JTextField("");
            
            lblCodigo = new JLabel("Codigo");
            txtCodigo = new JTextField("");
            
            btnEvento = new JButton("Evento");
            btnGuardar = new JButton("Guardar");
            tabla = new JTable ();
            scroll = new JScrollPane(tabla);
            lblcodigo = new JLabel();
           
            panelRegistro.add(lblNombre);
            panelRegistro.add(txtNombre);
            panelRegistro.add(lblCantidad);
            panelRegistro.add(txtCantidad);
            panelRegistro.add(lblPrecio);
            panelRegistro.add(txtPrecio);
            panelRegistro.add(lblCodigo);
            panelRegistro.add(txtCodigo);
            panelRegistro.add(btnEvento);
            panelRegistro.add(btnGuardar);
            
            JPanel panelalado = new JPanel();
            panelalado.setBackground(Color.LIGHT_GRAY);
            panelalado.setBorder(BorderFactory.createEmptyBorder(40,0,0,40));
            
             
            ImageIcon icon =  new  ImageIcon ("descarga.png");  
            lblcodigo.setIcon(icon);
            panelalado.add(lblcodigo);
            
            panelarriba.add(panelRegistro);
            panelarriba.add(panelalado);
            
            JPanel paneltabla = new JPanel();
            paneltabla.setBackground(Color.lightGray);
            paneltabla.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
            paneltabla.add(scroll);
            
            contenedorPrincipal.add(panelarriba);
            contenedorPrincipal.add(paneltabla);
            cargar();
            
             
            
            //Creación de objetos oyentes
            AccionBotonGuardar oyenteBtnGuardar = new AccionBotonGuardar();
            AccionBotonCre oyenteBtnEvento = new AccionBotonCre();
            
            //Vincular los oyentes a los objetos que generan el evento
            btnGuardar.addActionListener(oyenteBtnGuardar);
            btnEvento.addActionListener(oyenteBtnEvento);
       


    }

    
    private void cargar()  {
        
        try {
        String [] titulos = {"NOMBRE","CANTIDAD","PRECIO","CODIGO"};
        String [] registros = new String[4];
        String sql ="SELECT * FROM registros";
        model = new DefaultTableModel(null,titulos);
        ConexionBD cc = new ConexionBD();
        Connection cn=cc.conexion();
        
        
        Statement st = (Statement)cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            registros[0]=rs.getString("Nombre");
            registros[1]=rs.getString("Cantidad");
            registros[2]=rs.getString("Precio");
            registros[3]=rs.getString("Codigo");
            model.addRow(registros);
        }
        tabla.setModel(model);
        }
        catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    private void generarCodigo()  {
       
        barcode.setCodeType(new Interleaved25());
        barcode.setCode(txtCodigo.getText());
        barcode.setCheckDigit(true);
        
        image = barcode.draw(new BufferedImage(150,150,BufferedImage.TYPE_INT_RGB));
        
        barras = new ImageIcon (image);
        this.lblcodigo.setIcon(barras);
        
         
    }
   
    
    public static void main(String []args){
        Principal ventana = new Principal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(new Dimension(800,500));
        ventana.setVisible(true);
        
        Thread t = new Thread(new Hilo());
        t.start();
      
    }
    public void eventollegar (){
        ClaseDatos regis = new ClaseDatos();
        DatosRegistro regis2 = new DatosRegistro();
        regis2.addRegistroListener(regis);
        
        String n = txtNombre.getText();
        int ca= Integer.parseInt(txtCantidad.getText());
        int pre= Integer.parseInt(txtPrecio.getText());
        int co = Integer.parseInt(txtCodigo.getText());
        
        regis2.setDatos(n,ca,pre,co);
    }
    
    
 
    class AccionBotonGuardar implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if ((JButton) e.getSource() == btnGuardar) {
                
                ConexionBD cnx = new ConexionBD();
                Connection registro = cnx.conexion();
                String sql = "INSERT INTO registros (Nombre,Cantidad,Precio,Codigo) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = (PreparedStatement) registro.prepareStatement(sql);
            pst.setString(1, txtNombre.getText());
            pst.setInt(2, Integer.parseInt(txtCantidad.getText()));
            pst.setInt(3, Integer.parseInt(txtPrecio.getText()));
            pst.setInt(4, Integer.parseInt(txtCodigo.getText()));
            int numero_datos = pst.executeUpdate();
            if (numero_datos > 0) {
                cargar();
                generarCodigo();
                JOptionPane.showMessageDialog(null, "Se ingresaron  Correctamente los datos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Campos vacios\n Ingrese sus datos", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
            }
        }
        
    }
    class AccionBotonCre implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //mandar a llamar a la ventana
            
           eventollegar();
            
            
            
        }
    
        
    }
    
    
}


