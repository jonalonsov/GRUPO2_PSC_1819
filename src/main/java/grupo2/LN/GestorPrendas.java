package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorPrendas {
	

	
	
		
	public GestorPrendas(){
		
	}
	
	
	public int maxIdPrenda( Statement st) {
		//SELECT
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

	public boolean anyadirPrenda(Statement st, prenda prenda) {
	
		int id = maxIdPrenda(st) + 1;

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
	
	public int maxIdConjunto( Statement st) {
		//SELECT
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
				} 
		return id;
	}
	
	public boolean anyadirConjunto(Statement st, Conjunto conjunto) {

		int id = maxIdConjunto(st) + 1;
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
	

}