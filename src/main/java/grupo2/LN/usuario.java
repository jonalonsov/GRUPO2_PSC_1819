package grupo2.LN;

import grupo2.LP.Principal;

import org.apache.log4j.Logger;

public class usuario  implements Comparable<Object> {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	static int count = 0; 
	int id;
	private String nombre;
	private String contrasenya;
	
	public usuario(String nombre, String contrasenya){
		
		id = ++count; 
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}