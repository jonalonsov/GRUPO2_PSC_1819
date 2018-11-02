package grupo2.LN;

public class complemento  implements Comparable<Object> {

	static int count = 0; 
	int id;
	private String nombre;
	private String color;
	private String tejido;
	
	public complemento(String nombre, String color){
		
		id = ++count; 
		this.nombre = nombre;
		this.color = color;
				
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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