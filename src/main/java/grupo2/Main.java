package grupo2;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.ventanaPrincipal;

public class Main {

	public static void main(String[] args) {

		BaseDeDatos.initBD("miarmario.bd");

//		AQUI SE VA A INICIALIZAR LA PRIMERA VENTANA DEL PROGRAMA DEL SIGUIENTE MODO
		ventanaPrincipal objpanel = new ventanaPrincipal();
		objpanel.setVisible(true);
		

		

//Commentary para ver comprobar el correcto funcionamiento de Git --> GORKA
	}	
}