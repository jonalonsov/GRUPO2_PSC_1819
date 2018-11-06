package grupo2.LD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BaseDeDatos {
	
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
			System.out.println( "Error!! Nombre: " + nombreBD + " / Contrasenya incorreta");
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
			System.out.println ("Tabla creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
	public static void crearTablaBDPrenda() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists PRENDA ( id int, nombre string, color string, tejido string, imagen string )");
			System.out.println ("Tabla creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
	public static void crearTablaBDComplemento() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table if not exists COMPLEMENTO ( id int, nombre string, color string )");
			System.out.println ("Tabla creada");
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
			System.out.println ("Tabla creada");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya existia (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}


	public static void inicializarValores() {
		// TODO Auto-generated method stub
		
	}
	

	public static void insertarUsuario (String usuario, String contraseña){
			
			
			try {
				String Query = "INSERT INTO USUARIO VALUES("
		                + " ' " + usuario + " ', "
		                + " ' " + contraseña + " ')";
		        Statement st = connection.createStatement();
		        st.executeUpdate(Query);
		        JOptionPane.showMessageDialog(null, "Nuevo usuario almacenado de forma exitosa");
		        
				} catch (SQLException ex) {
		        JOptionPane.showMessageDialog(null, "Error al almacenar el nuevo usuario. ");
		    }
		}
	
	
public static void insertarComplemento (String nombre, String color){
		
		
		try {
			String Query = "INSERT INTO COMPLEMENTO VALUES("
	                + " ' " + nombre + " ', "
	                + " ' " + color + " ')";
	      
			Statement st = connection.createStatement();
	        st.executeUpdate(Query);
	        JOptionPane.showMessageDialog(null, "Nuevo complemento almacenado de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error al insertar una nueva prenda. ");
	    }
	}
	
	public boolean chequearYaEnTabla( Statement st, String nombre ) {
		//SELECT
			try {

				String sentSQL = "select * from USUARIO where (nombre = '" + nombre + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqui solo hay que ver si ya existe
					rs.close();
					JOptionPane.showMessageDialog(null, "El usuario ya existe, prueba con otro nombre","Mensaje de error",JOptionPane.ERROR_MESSAGE);
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	
	}