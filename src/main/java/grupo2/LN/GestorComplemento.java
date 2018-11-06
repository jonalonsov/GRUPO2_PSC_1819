package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import grupo2.LD.BaseDeDatos;

public class GestorComplemento {

	
	public GestorComplemento(){

	}
	
	public int maxIdComp() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT id from COMPLEMENTO ORDER BY id DESC LIMIT 1 ";
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
	
	public boolean anyadirComplemento(Statement st, Complemento complemento) {
		
		int id = maxIdComp() + 1;
		
		try {
	
				String sentSQL = "insert into COMPLEMENTO values(" + "'" + id + "', " + "'" + complemento.getNombre() + "', " + "'" + complemento.getColor() + "')"; 
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public Complemento[] selectComplementos() {
		
		 Statement st=BaseDeDatos.getStatement();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Complemento> complementos = new ArrayList<Complemento>();
		try {
			String sentSQL = "select * from COMPLEMENTO";
			System.out.println( sentSQL ); 
			
			ResultSet rs = st.executeQuery( sentSQL );
			
			while (rs.next()) {
				//Añadimos los id-s de los conjuntos que son favoritos
				complementos.add(new Complemento(rs.getInt(1), rs.getString(2), rs.getString(3)));
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

}
