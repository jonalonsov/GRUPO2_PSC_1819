package grupo2;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.Principal;
import org.apache.log4j.Logger;


public class Main {
	
	private final static Logger log = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {

		BaseDeDatos.initBD("miarmario.bd");
		
		BaseDeDatos.crearTablaBDUsuario();
		BaseDeDatos.crearTablaBDPrenda();
		BaseDeDatos.crearTablaBDComplemento();
		BaseDeDatos.crearTablaBDConjunto();
		BaseDeDatos.crearTablaBDPropuestas();
		BaseDeDatos.crearTablaUsuarioSesion();
		BaseDeDatos.inicializarValores();
		//BaseDeDatos.insertarUsuario(BaseDeDatos.getStatement());
		log.trace("Mensaje: Tablas creadas y base de datos inicializada");

//		AQUI SE VA A INICIALIZAR LA PRIMERA VENTANA DEL PROGRAMA DEL SIGUIENTE MODO
		Principal objpanel = new Principal();
		objpanel.setVisible(true);
		
//Para probar git con youtrack 3
		
	}	
	
}
