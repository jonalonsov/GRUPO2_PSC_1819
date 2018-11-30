package grupo2.LN;

import grupo2.LP.Principal;

import org.apache.log4j.Logger;

public class Calendario  {

	private final static Logger log = Logger.getLogger(Principal.class.getName());
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