package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.Principal;

public class GestorUsuario {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	private Statement st;
	
	public GestorUsuario(){
		st=BaseDeDatos.getStatement();
		
	}

	/** Comprueba si un usuario ya esta en la tabla USUARIO de BD,considerando la trayectoria completa del disco como informacion clave.
	 * @param st	Sentencia ya abierta de base de datos
	 * @return	true si el usuario ya esta en la tabla, false en caso contrario
	 */
	public boolean chequearYaEnTabla(String nombre) {
		
			try {

				String sentSQL = "select * from USUARIO where (nombre = '" + nombre + "')";
								
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
	
	public boolean chequearYaEnTablaLOGIN(String nombre, String contrasenya ) {
		//SELECT
			try {

				String sentSQL = "select * from USUARIO where ( nombre = '" + nombre + "' and contrasenya = '" + contrasenya + "')";
								
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
	public boolean anyadirFilaATablauUsuario( usuario user ) {
	//INSERT

		if (chequearYaEnTabla(user.getNombre())) {  // Si esta ya en la tabla
			return modificarFilaEnTablaUsuario(user);
		}
		// Insercion normal
		try {
			String sentSQL = "insert into USUARIO values(" + "'" + user.getNombre() + "', " + "'" + user.getContrasenya() + "')"; 
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean anyadirUsuario( usuario user ) {
		//INSERT

			if (chequearYaEnTabla( user.getNombre())) {  // Si esta ya en la tabla
				return false;
			}
			// Insercion normal
			try {
				String sentSQL = "insert into USUARIO values(" + "'" + user.getNombre() + "', " + "'" + user.getContrasenya() + "')"; 
				log.trace("Mensaje: El usuario" +user.getNombre()+ " se quiere añadir");
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
	public boolean modificarFilaEnTablaUsuario( usuario user ) {
	//UPDATE
		int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(resp==1) {
			try {		
				String sentSQL = "update USUARIO set "+ 
						"nombre = '" + user.getNombre() + "', " +
						"contrasenya = '" + user.getContrasenya() + "'";
			
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que modificar 1, error si no
				return true;
			
			} catch (SQLException e) {
				e.printStackTrace();
			return false;
			}
		} else return false;
	}
	
	public boolean eliminarUsuarioSistema( ) {
		//meter a la tabla temporal de usuario para saber durante la sesión qué usuario está en el sistema	
			try {		
					String sentSQL = "delete from USUARIO_SESION";
					
					int val = st.executeUpdate( sentSQL );
					if (val!=1) return false;  // Se tiene que modificar 1, error si no
					return true;
				
				} catch (SQLException e) {
					e.printStackTrace();
				return false;
				}

		}
	public boolean modificarUsuarioSistema(usuario user) {
		eliminarUsuarioSistema();
		// Insercion normal
		try {
			String sentSQL = "insert into USUARIO_SESION values(" + "'" + user.getNombre() + "', " + "'" + user.getContrasenya() + "')"; 
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public String nombreUsuario( ) {
		//SELECT
		try {
				String sentSQL = "select * from USUARIO_SESION";
				
				ResultSet rs = st.executeQuery( sentSQL );

				return rs.getString(1);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
				
			}				
		
	}
}