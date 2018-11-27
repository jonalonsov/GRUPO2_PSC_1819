package grupo2.LN;

public class Prenda  implements Comparable<Object> {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String color;
	private String tejido;
	private String imagen;
	private String usuario;
	
	public Prenda(int id, String nombre, String color, String tejido, String imagen, String usuario){
		
		this.id=id;
		this.nombre = nombre;
		this.color = color;
		this.setTejido(tejido);
		this.imagen = imagen;
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