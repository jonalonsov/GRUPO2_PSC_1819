package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import grupo2.LD.BaseDeDatos;

public class GestorConjuntos {

	//<--GOE--> HACER LO MISMO QUE HE HECHO CON GESTORCOMPLEMENTOS Y GESTORPRENDAS, NO CREAR UN NUEVO OBJETO
	private Statement st;
	private GestorUsuario gusuario;
	public GestorConjuntos(){
		st=BaseDeDatos.getStatement();
		
	}
	public int maxIdConjunto() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT idC from Conjunto ORDER BY idC DESC LIMIT 1 ";
				System.out.println( sentSQL ); 
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("idC");	
						    System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					id=0;
				} 
		return id;
	}
	
	public boolean anyadirConjunto(Conjunto conjunto) {
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		int id = maxIdConjunto() + 1;
		int val;
		try {
				
				String sentSQL = "insert into CONJUNTO values(" + "'" + id + "', " + "'" + conjunto.getPrenda1() + "', " + "'" + conjunto.getPrenda2() + "', "+"'" + gusuario.nombreUsuario() + "', "+"'" + conjunto.getFavorito() + "')"; 
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean modifFavConjunto(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "update CONJUNTO set "+ 
					"favorito = 1 where ( idC = '" + id + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean modifNoFavConjunto(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "update CONJUNTO set "+ 
					"favorito = 0 where ( idC = '" + id + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public Conjunto[] selectConjuntos() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select * from CONJUNTO  where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 0 + "')";
			System.out.println( sentSQL ); 
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				conjuntos.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		//Pasamos de ArrayList a Array
		System.out.println(conjuntos.size());
		Conjunto[] Arrconjuntos = new Conjunto[conjuntos.size()];
		Arrconjuntos = conjuntos.toArray(Arrconjuntos);
		
		return Arrconjuntos;
		
	}
	public Conjunto[] selectConjuntosFav() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select * from CONJUNTO  where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
			System.out.println( sentSQL ); 
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				conjuntos.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		//Pasamos de ArrayList a Array
		System.out.println(conjuntos.size());
		Conjunto[] Arrconjuntos = new Conjunto[conjuntos.size()];
		Arrconjuntos = conjuntos.toArray(Arrconjuntos);
		
		return Arrconjuntos;
		
	}
	public Conjunto conjuntoconID(int id) {
		//SELECT
		 Statement st=BaseDeDatos.getStatement();
			try {
				
				String sentSQL = "select * from CONJUNTO where ( id = '" + id + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				
					return (Conjunto) rs;
					//Añadimos los id-s de los conjuntos que son favoritos

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
	
}