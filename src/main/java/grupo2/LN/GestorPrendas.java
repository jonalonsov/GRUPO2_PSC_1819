package grupo2.LN;

import java.sql.SQLException;
import java.sql.Statement;

public class GestorPrendas {

	String color;
	String nombre;
	String tejido;
	String imagen;
	
	
		
	public GestorPrendas(String nombre, String color, String tejido, String imagen){
		this.nombre = nombre;
		this.color = color;
		this.tejido = tejido;
		this.imagen = imagen;		
	}
	
	public boolean anyadirPrenda(Statement st, String nombre, String color, String tejido, String imagen) {

		try {
				prenda unaPrenda = new prenda( nombre, color, tejido, imagen );
				
				String sentSQL = "insert into PRENDA values(" + "'" + unaPrenda.id + "', " + "'" + nombre + "', " + "'" + color + "', "+"'" + tejido + "', "+"'" + imagen + "')"; 
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