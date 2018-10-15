package grupo2;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.Principal;

public class Main {
	public static void main(String[] args) {

		BaseDeDatos.initBD("miarmario.bd");
		
		BaseDeDatos.crearTablaBDUsuario();
		BaseDeDatos.crearTablaBDPrenda();
		BaseDeDatos.inicializarValores();
		//BaseDeDatos.insertarUsuario(BaseDeDatos.getStatement());

//		AQUI SE VA A INICIALIZAR LA PRIMERA VENTANA DEL PROGRAMA DEL SIGUIENTE MODO
		Principal objpanel = new Principal();
		objpanel.setVisible(true);
		
	
		

//Commentary para ver comprobar el correcto funcionamiento de Git --> GORKA
	}	
	
}
