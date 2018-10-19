package grupo2.LN;

public class prenda  implements Comparable<Object> {

	static int count = 0; 
	int id;
	private String nombre;
	private String color;
	
	public prenda(String nombre, String color){
		
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
	
	public String getContrasenya() {
		return color;
	}

	public void setContrasenya(String color) {
		this.color = color;
	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}