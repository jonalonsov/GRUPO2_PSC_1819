package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.Principal;

public class GestorComplemento {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	private Statement st;
	private GestorUsuario gusuario;
	public GestorComplemento(){

	}
	
	public int maxIdComp() {
		//SELECT
		st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT id from COMPLEMENTO1 ORDER BY id DESC LIMIT 1 ";
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("id");	
						  
						    //System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					id=0;
				} 
		return id;
	}
	
	public boolean anyadirComplemento(Statement st, Complemento complemento) {
		
		int id = maxIdComp() + 1;
		
		try {
	
				String sentSQL = "insert into COMPLEMENTO1 values(" + "'" + id + "', " + "'" + complemento.getNombre() + "', " + "'" + complemento.getColor() + "',"+"'" + complemento.getImagen() + "', " + "'" + complemento.getUsuario() + "')"; 
				
				log.trace("Mensaje: El complemento " +id+ " se ha añadido");
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
public boolean anyadirComplemento2(Statement st, Integer id1, String nombre, String color, String imagen,String usuario) {
		
		int id = maxIdComp() + 1;
		
		try {
	
				String sentSQL = "insert into COMPLEMENTO1 values(" + "'" + id + "', " + "'" + nombre + "', " + "'" + color + "',"+"'" + imagen + "', " + "'" + usuario + "')"; 
				
				log.trace("Mensaje: El complemento " +id+ " se ha añadido");
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public Complemento[] selectComplementos() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Complemento> complementos = new ArrayList<Complemento>();
		try {
			String sentSQL = "select * from COMPLEMENTO1 where ( usuario = '" + gusuario.nombreUsuario() + "')";
			
			ResultSet rs = st.executeQuery( sentSQL );
			
			while (rs.next()) {
				//Añadimos los id-s de los conjuntos que son favoritos
				complementos.add(new Complemento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		//Pasamos de ArrayList a Array
		
		Complemento[] Arrcomplementos = new Complemento[complementos.size()];
		Arrcomplementos = complementos.toArray(Arrcomplementos);
		
		return Arrcomplementos;
	}

	public boolean EliminarComplemento(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "delete from COMPLEMENTO1 where ( id = '" + id + "')";
			
			log.trace("Mensaje: El complemento " +id+ " se ha eliminado");
			
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}

}
