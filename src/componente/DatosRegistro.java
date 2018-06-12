/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import java.util.*;

public class DatosRegistro{
  private Vector DatosListeners=new Vector();
  private int cantidad,precio,codigo=0;
  private String nombre;

  public DatosRegistro() {
  
  }

  public void setDatos(String nombre,int cantidad,int precio,int codigo){
	  
      int codigoA = this.codigo;
      this.nombre = nombre;
      this.cantidad=cantidad;
      this.precio=precio;
      this.codigo=codigo;

    if(codigoA!=this.codigo){
        DatosEvent event=new DatosEvent(this,nombre ,cantidad,precio,codigo );
        notificarCambio(event);
    }
  }
  
  public String getnombre(){
	return this.nombre;
}
	
public int getcantidad(){
	return this.cantidad;
}

public int getprecio(){
	return this.precio;
}

public int getcodigo(){
	return this.codigo;
}

  public synchronized void addRegistroListener(DatosListener listener){
	  DatosListeners.addElement(listener);
  }
  public synchronized void removeCompasListener(DatosListener listener){
	  DatosListeners.removeElement(listener);
  }

  private void notificarCambio(DatosEvent event){
    Vector lista;
    synchronized(this){
        lista=(Vector)DatosListeners.clone();
    }
    for(int i=0; i<lista.size(); i++){
        DatosListener listener=(DatosListener)lista.elementAt(i);
        listener.cambio(event);
    }
  }
  
  
}

