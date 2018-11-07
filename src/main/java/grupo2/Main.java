package grupo2;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.Principal;

public class Main {
	public static void main(String[] args) {

		BaseDeDatos.initBD("miarmario.bd");
		
		BaseDeDatos.crearTablaBDUsuario();
		BaseDeDatos.crearTablaBDPrenda();
		BaseDeDatos.crearTablaBDComplemento();
		BaseDeDatos.crearTablaBDConjunto();
		BaseDeDatos.crearTablaUsuarioSesion();
		BaseDeDatos.inicializarValores();
		//BaseDeDatos.insertarUsuario(BaseDeDatos.getStatement());

//		AQUI SE VA A INICIALIZAR LA PRIMERA VENTANA DEL PROGRAMA DEL SIGUIENTE MODO
		Principal objpanel = new Principal();
		objpanel.setVisible(true);
		
//Para probar git con youtrack 3
		
	}	
	
}
