package grupo2.LN;

import java.sql.SQLException;
import java.sql.Statement;

public class GestorComplemento {
	String Complemento;
	String Color1;
	
	public GestorComplemento(String Complemento, String Color1){
		
		
		this.Complemento =Complemento;
		this.Color1 =Color1;
		
}
	public boolean anyadirComplemento(Statement st, String Complemento, String Color1) {

		try {
			
				String sentSQL = "insert into COMPLEMENTO values(" + "'" + Complemento + "', " + "'" + Color1 + "')"; 
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
