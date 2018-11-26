package grupo2.LN;

public class Calendario  implements Comparable<Object> {

	private int id;
	private Conjunto conjunto;
	private String usuario;
	private Fecha fecha;

	public Calendario(int id, Conjunto conjunto, String usuario, Fecha fecha){
		
		this.setId(id);
		this.setConjunto(conjunto);
		this.setUsuario(usuario);
		this.setFecha(fecha);
		
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

	public void setUsuario(String usuario2) {
		this.usuario = usuario2;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Conjunto getConjunto() {
		return conjunto;
	}



	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}



	public Fecha getFecha() {
		return fecha;
	}



	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	
	


}