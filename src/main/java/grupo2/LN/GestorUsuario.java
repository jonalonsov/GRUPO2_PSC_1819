package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class GestorUsuario {

	//<--GOE--> HACER LO MISMO QUE HE HECHO CON GESTORCOMPLEMENTOS Y GESTORPRENDAS, NO CREAR UN NUEVO OBJETO
	String contrasenya;
	String nombre;
		
	public GestorUsuario(String nombre, String contrasenya){
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		
	}

	/** Comprueba si un usuario ya esta en la tabla USUARIO de BD,considerando la trayectoria completa del disco como informacion clave.
	 * @param st	Sentencia ya abierta de base de datos
	 * @return	true si el usuario ya esta en la tabla, false en caso contrario
	 */
	public boolean chequearYaEnTabla( Statement st, String nombre ) {
		//SELECT
			try {

				String sentSQL = "select * from USUARIO where (nombre = '" + nombre + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqui solo hay que ver si ya existe
					rs.close();
					JOptionPane.showMessageDialog(null, "El usuario ya existe, prueba con otro","Mensaje de error",JOptionPane.ERROR_MESSAGE);
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	
	public boolean chequearYaEnTablaLOGIN( Statement st, String nombre, String contrasenya ) {
		//SELECT
			try {

				String sentSQL = "select * from USUARIO where ( nombre = '" + nombre + "' and contrasenya = '" + contrasenya + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				if (rs.next()) { 
					rs.close();
					JOptionPane.showMessageDialog(null, "Nombre de usuario y/o contraseña correctos","Correcto",JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
				JOptionPane.showMessageDialog(null, "Usuario no registrado con este nombre","Mensaje de error",JOptionPane.ERROR_MESSAGE);
				return false;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Usuario no registrados con este nombre","Mensaje de error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return false;
			}
		}
	
		
	/** Añade un usuario a la tabla USUARIO de BD, 
	 * que debe estar abierta y tener el formato y los nombres de campos apropiados: (Sting nombre, String contrasenya)
	 * Usa la sentencia INSERT de SQL.
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public boolean anyadirFilaATablauUsuario( Statement st, String nombre ) {
	//INSERT

		if (chequearYaEnTabla(st, nombre)) {  // Si esta ya en la tabla
			return modificarFilaEnTablaUsuario(st);
		}
		// Insercion normal
		try {
			String sentSQL = "insert into USUARIO values(" + "'" + nombre + "', " + "'" + contrasenya + "')"; 
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean anyadirUsuario( Statement st, String nombre ) {
		//INSERT

			if (chequearYaEnTabla(st, nombre)) {  // Si esta ya en la tabla
				return false;
			}
			// Insercion normal
			try {
				String sentSQL = "insert into USUARIO values(" + "'" + nombre + "', " + "'" + contrasenya + "')"; 
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	
	/** Modifica los datos de un usuario en la tabla USUARIO de BD, 
	 * que debe estar abierta y tener el formato y los nombres de campos apropiados:(Sting nombre, String contrasenya)
	 * Usa la sentencia UPDATE de SQL.
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @return	true si la modificacion es correcta, false en caso contrario
	 */
	public boolean modificarFilaEnTablaUsuario( Statement st ) {
	//UPDATE
		int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(resp==1) {
			try {		
				String sentSQL = "update USUARIO set "+ 
						"nombre = '" + nombre + "', " +
						"contrasenya = '" + contrasenya + "'";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que modificar 1, error si no
				return true;
			
			} catch (SQLException e) {
				e.printStackTrace();
			return false;
			}
		} else return false;
	}
}