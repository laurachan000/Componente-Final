
package componente;


import java.util.EventObject;


public class DatosEvent extends EventObject{
private String nombre;
private int cantidad,precio,codigo;

	public DatosEvent(Object fuente,String nombre, int cantidad,int precio,int codigo) {
		super(fuente);
		this.nombre = nombre;
                this.cantidad = cantidad;
                this.precio = precio;
                this.codigo = codigo;
		
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
}

