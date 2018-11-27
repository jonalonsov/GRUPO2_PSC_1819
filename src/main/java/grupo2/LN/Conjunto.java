package grupo2.LN;

import grupo2.LP.Principal;

import org.apache.log4j.Logger;

public class Conjunto  implements Comparable<Object> {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	
	private int id;
	private int prenda1;
	private int prenda2;
	private String usuario;
	private int favorito; //1 será que es un conjunto favorito y 0 que no
	
	public Conjunto(int id, int prenda1, int prenda2, String usuario, int favorito){
		
		this.setId(id);
		this.setPrenda1(prenda1);
		this.setPrenda2(prenda2);
		this.setUsuario(usuario);
		this.setFavorito(favorito);
		
	}

	public int getPrenda1() {
		return prenda1;
	}

	public void setPrenda1(int prenda12) {
		this.prenda1 = prenda12;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrenda2() {
		return prenda2;
	}

	public void setPrenda2(int prenda22) {
		this.prenda2 = prenda22;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario2) {
		this.usuario = usuario2;
	}

	public int getFavorito() {
		return favorito;
	}

	public void setFavorito(int favorito) {
		this.favorito = favorito;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	


}