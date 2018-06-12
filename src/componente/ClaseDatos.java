
package componente;

import java.util.EventObject;
import javax.swing.JOptionPane;


public class ClaseDatos implements DatosListener {
    
public ClaseDatos() {
  }

    @Override
    public void cambio(EventObject e) {
        
        if(e instanceof DatosEvent){
        DatosEvent event=(DatosEvent)e;
        JOptionPane.showMessageDialog(null, "Nombre: "+event.getnombre()+"\n"+
                "Cantidad: "+event.getcantidad()+"\n"+"Precio $: "+event.getprecio()+"\n"+"Codigo: "+event.getcodigo(), "Datos:", JOptionPane.INFORMATION_MESSAGE);
        
       
    }
    }
  
}
