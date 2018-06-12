
package componente;

import java.util.EventListener;
import java.util.EventObject;


public interface DatosListener extends EventListener{
    
    public void cambio (EventObject e);
}
