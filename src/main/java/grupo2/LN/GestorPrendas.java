package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.Principal;

public class GestorPrendas {
		
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	private Statement st;
	public GestorPrendas(){
		
	}
	
	private GestorUsuario gusuario;
	
	public int maxIdPrenda() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT id from PRENDA ORDER BY id DESC LIMIT 1 ";
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("id");	
						    //System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		return id;
	}

	public boolean anyadirPrenda(Statement st, Prenda prenda) {
	
		int id = maxIdPrenda() + 1;
	
		try {
				
				String sentSQL = "insert into PRENDA values(" + "'" + id + "', " + "'" + prenda.getNombre() + "', " + "'" + prenda.getColor() + "', "+"'" + prenda.getTejido() + "', "+"'" + prenda.getImagen() + "', "+"'" + prenda.getUsuario() + "')"; 
				log.trace("Mensaje: La prenda " +id+ " se ha añadido");
				st.executeUpdate( sentSQL );
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	

	
	public Prenda[] selectPrendas() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		try {
			String sentSQL = "select * from PRENDA  where ( usuario = '" + gusuario.nombreUsuario() + "')";
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				prendas.add(new Prenda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		
		Prenda[] Arrprendas = new Prenda[prendas.size()];
		Arrprendas = prendas.toArray(Arrprendas);
		
		return Arrprendas;
		
	}
	
	public String nombrePrendaconID(int id) {
		//SELECT
		 Statement st=BaseDeDatos.getStatement();
		 String nombreComp = null;
			try {
				
				String sentSQL = "select * from PRENDA where ( id = '" + id + "')";
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				if (rs.next()) { 
					
					//Añadimos los id-s de los conjuntos que son favoritos
					nombreComp = rs.getString(2) + ",  " +rs.getString(3);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return "";
			}
			return nombreComp;
		}
	
	//Selecciona todos los conjuntos que están marcados como favoritos y devuelve un array con los id-s de esos conjuntos
	public Conjunto[] selectFavoritos(Statement st) {
	
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> favoritos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select id from CONJUNTO where favorito = 1)";
			
			ResultSet rs = st.executeQuery( sentSQL );
			
			while (rs.next()) {
				//Añadimos los id-s de los conjuntos que son favoritos
				favoritos.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		//Pasamos de ArrayList a Array
		Conjunto[] Arrfavoritos = new Conjunto[favoritos.size()];
		Arrfavoritos = favoritos.toArray(Arrfavoritos);
		
		return Arrfavoritos;
		
	}

	public boolean EliminarPrenda(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "delete from PRENDA where ( id = '" + id + "')";
			
			log.trace("Mensaje: La prenda " +id+ " se ha eliminado");
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
			


}