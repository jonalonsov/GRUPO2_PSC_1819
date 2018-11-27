package grupo2.LN;

public class Calendario  implements Comparable<Object> {

	private int id;
	private int idConjunto;
	private String usuario;
	private Fecha fecha;

	public Calendario(int id, int idConjunto, String usuario, Fecha fecha){
		
		this.setId(id);
		this.setIdConjunto(idConjunto);
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


	public Fecha getFecha() {
		return fecha;
	}



	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}


	public int getIdConjunto() {
		return idConjunto;
	}


	public void setIdConjunto(int idConjunto) {
		this.idConjunto = idConjunto;
	}

	
	


}