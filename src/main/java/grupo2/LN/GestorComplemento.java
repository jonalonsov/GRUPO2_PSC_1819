package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import grupo2.LD.BaseDeDatos;

public class GestorComplemento {

	
private Statement st;
private GestorUsuario gusuario;
	public GestorComplemento(){

	}
	
	public int maxIdComp() {
		//SELECT
		st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT id from COMPLEMENTO1 ORDER BY id DESC LIMIT 1 ";
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
	
				String sentSQL = "insert into COMPLEMENTO1 values(" + "'" + id + "', " + "'" + complemento.getNombre() + "', " + "'" + complemento.getColor() + "',"+"'" + complemento.getImagen() + "', " + "'" + complemento.getUsuario() + "')"; 
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
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Complemento> complementos = new ArrayList<Complemento>();
		try {
			String sentSQL = "select * from COMPLEMENTO1 where ( usuario = '" + gusuario.nombreUsuario() + "')";
			System.out.println( sentSQL ); 
			
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
		System.out.println("AQUI VA EL TAMAÑOOOOO");
		System.out.println(complementos.size());
		Complemento[] Arrcomplementos = new Complemento[complementos.size()];
		Arrcomplementos = complementos.toArray(Arrcomplementos);
		
		return Arrcomplementos;
	}

}
