package grupo2.LD;


import grupo2.LP.Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class BaseDeDatos {
	
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	
	
	public BaseDeDatos() {
		
		//para inicializar la base de datos
	}
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	/** Inicializa una BD SQLITE y devuelve una conexion con ella. Debe llamarse a este 
	 * metodo antes que ningun otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexion con la base de datos indicada. Si hay algun error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC"); //.jar
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg. 
			//TIMEOUT: Si estamos esperando una respuesta y si no nos dan en 30 mseg (en este caso), dejamos de esperar.
				//JOptionPane.showMessageDialog( null, "Bien!! Nombre: " + nombreBD + " / la base de datos se ha conectado" , "BIEN", JOptionPane.INFORMATION_MESSAGE);
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error!! Nombre: " + nombreBD + " / no se ha conectado la base de datos" , "ERROR", JOptionPane.ERROR_MESSAGE );
			log.warn("Error!! Nombre: " + nombreBD + " / Contrasenya incorreta");
			return null;
		}
	}
	
	/** Cierra la conexion con la Base de Datos*/
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexion si ha sido establecida previamente (#initBD()).
	 * @return	Conexion con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexion si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}
	
	/** Crea una tabla en una base de datos, si no existia ya.
	 * Debe haberse inicializado la conexion correctamente.
	 */
	

	//TABLA USUARIO
	public static void crearTablaBDUsuario() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists USUARIO ( nombre string, contrasenya string )");
			log.trace("Mensaje: Tabla usuario creada");
			
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
	public static void crearTablaBDPrenda() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists PRENDA ( id int, nombre string, color string, tejido string, imagen string, usuario string )");
			
			log.trace("Mensaje: Tabla prenda creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
	public static void crearTablaBDComplemento() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists COMPLEMENTO1 ( id int, nombre string, color string, imagen string, usuario string )");
			
			log.trace("Mensaje: Tabla complemento creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
	public static void crearTablaUsuarioSesion() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists USUARIO_SESION ( nombre string, contrasenya string )");
			
			log.trace("Mensaje: Tabla usuario-sesion creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
	public static void crearTablaBDConjunto() {
		
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists CONJUNTO ( idC int, prenda1 int, prenda2 int, usuario string, favorito int)");
			
			log.trace("Mensaje: Tabla conjunto creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
public static void crearTablaBDPropuestas() {
		
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists PROPUESTAS ( idP int, prenda1 int, prenda2 int, usuario string, favorito int)");
			
			log.trace("Mensaje: Tabla propuesta creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
//Este es el calendario en el que se irán registrando todas las fechas que se han guardado
public static void crearTablaBDCalendario() {
	
	if (statement==null) return;
	try {
		statement.executeUpdate("create table if not exists CALENDARIO ( id int, idConjunto int, usuario string, año int, mes string, dia int)");
		
		log.trace("Mensaje: Tabla calendario creada");
	} catch (SQLException e) {
		// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
		if (!e.getMessage().equals("table interaccion already exists"))
			e.printStackTrace();  
	}
}


	public static void inicializarValores() {
		// TODO Auto-generated method stub
		
	}
	
	}