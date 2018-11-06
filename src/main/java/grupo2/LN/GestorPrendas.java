package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import grupo2.LD.BaseDeDatos;

public class GestorPrendas {
		
	public GestorPrendas(){
		
	}
	
	
	public int maxIdPrenda() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT id from PRENDA ORDER BY id DESC LIMIT 1 ";
				System.out.println( sentSQL ); 
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("id");	
						    System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		return id;
	}

	public boolean anyadirPrenda(Statement st, Prenda prenda) {
	
		int id = maxIdPrenda() + 1;

		try {
				
				String sentSQL = "insert into PRENDA values(" + "'" + id + "', " + "'" + prenda.getNombre() + "', " + "'" + prenda.getColor() + "', "+"'" + prenda.getTejido() + "', "+"'" + prenda.getImagen() + "')"; 
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	

	
	public int maxIdConjunto() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT id from Conjunto ORDER BY id DESC LIMIT 1 ";
				System.out.println( sentSQL ); 
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("id");	
						    System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					id=0;
				} 
		return id;
	}
	
	public boolean anyadirConjunto(Statement st, Conjunto conjunto) {

		int id = maxIdConjunto() + 1;
		try {
				
				String sentSQL = "insert into CONJUNTO values(" + "'" + id + "', " + "'" + conjunto.getPrenda1() + "', " + "'" + conjunto.getPrenda2() + "', "+"'" + conjunto.getUsuario() + "', "+"'" + conjunto.getFavorito() + "')"; 
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public Prenda[] selectPrendas() {
		
		 Statement st=BaseDeDatos.getStatement();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		try {
			String sentSQL = "select * from PRENDA";
			System.out.println( sentSQL ); 
			
			ResultSet rs = st.executeQuery( sentSQL );
			
			while (rs.next()) {
				//Añadimos los id-s de los conjuntos que son favoritos
				prendas.add(new Prenda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		//Pasamos de ArrayList a Array
		Prenda[] Arrprendas = new Prenda[prendas.size()];
		Arrprendas = prendas.toArray(Arrprendas);
		
		return Arrprendas;
		
	}
	
	//Selecciona todos los conjuntos que están marcados como favoritos y devuelve un array con los id-s de esos conjuntos
	public Conjunto[] selectFavoritos(Statement st) {
	
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> favoritos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select id from CONJUNTO where favorito = 1)";
			System.out.println( sentSQL ); 
			
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


}