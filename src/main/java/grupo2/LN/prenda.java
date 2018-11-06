package grupo2.LN;

public class prenda  implements Comparable<Object> {

	static int count = 0; 
	static int id;
	private String nombre;
	private String color;
	private String tejido;
	private String imagen;
	
	public prenda(String nombre, String color, String tejido, String imagen){
		
		id = ++count; 
		this.nombre = nombre;
		this.color = color;
		this.setTejido(tejido);
		this.imagen = imagen;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getContrasenya() {
		return color;
	}

	public void setContrasenya(String color) {
		this.color = color;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTejido() {
		return tejido;
	}

	public void setTejido(String tejido) {
		this.tejido = tejido;
	}
	


}