package grupo2.LN;

public class Complemento  implements Comparable<Object> {

	private int id;
	private String nombre;
	private String color;
	
	
	public Complemento(int id, String nombre, String color){
		
		this.id=id; 
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}