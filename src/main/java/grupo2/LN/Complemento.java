package grupo2.LN;

public class Complemento  implements Comparable<Object> {

	private int id;
	private String nombre;
	private String color;
	private String  usuario;
	
	
	public Complemento(int id, String nombre, String color, String usuario){
		
		this.id=id; 
		this.nombre = nombre;
		this.color = color;
		this.setUsuario(usuario);
				
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

}