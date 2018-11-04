package grupo2.LN;

public class complemento  implements Comparable<Object> {

	static int count = 0; 
	int id;
	private String nombre;
	private String color;
	
	
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

	

}