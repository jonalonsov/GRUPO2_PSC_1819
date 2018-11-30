package grupo2;

import static org.junit.Assert.*;
import grupo2.LD.BaseDeDatos;
import grupo2.LN.Complemento;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorComplemento;
import grupo2.LN.GestorConjuntos;
import grupo2.LN.GestorUsuario;
import grupo2.LN.usuario;

import org.junit.Before;
import org.junit.Test;

public class GestorComplementoTest {
	private static boolean setUpIsDone = false;
	@Before 
	public void setUp() { 
		if(setUpIsDone){
			return;
		}
		
		BaseDeDatos.initBD("miarmarioTest.bd");
		
		BaseDeDatos.crearTablaBDPrenda();
		BaseDeDatos.crearTablaBDConjunto();
		BaseDeDatos.crearTablaBDUsuario();
		BaseDeDatos.crearTablaUsuarioSesion();
		
		GestorComplemento com = new GestorComplemento();
		
		
		Complemento com1 = new Complemento('1' ,"Rojo", "Pulsera", "leire", null ); 
		 
		com.anyadirComplemento(BaseDeDatos.getStatement(), com1);
		
		
    }
	@Test
	public void testGestorComplemento() {
		//fail("Not yet implemented");
	}

	@Test
	public void testMaxIdComp() {
		//fail("Not yet implemented");
		 GestorComplemento gcom = new GestorComplemento(); 
	    	int max = gcom.maxIdComp();
	        assertTrue( max == 2 );
	}

	@Test
	public void testAnyadirComplemento() {
		Complemento complemento2 = new Complemento('1' ,"Azul", "Collar", "Amaia", null );
    	GestorComplemento gc = new GestorComplemento(); 
    	gc.anyadirComplemento(BaseDeDatos.getStatement(), complemento2);
    	assertEquals( complemento2.getUsuario(), "Amaia" );
		//fail("Not yet implemented");
	}
	
	@Test
	public void testAnyadirComplemento2() {
		Complemento complemento3 = new Complemento('1' ,"Verde", "Collar", "Jon", null );
    	GestorComplemento gc = new GestorComplemento(); 
    	gc.anyadirComplemento(BaseDeDatos.getStatement(), complemento3);
    	assertEquals( complemento3.getUsuario(), "Jon" );
		//fail("Not yet implemented");
	}

	@Test
	public void testSelectComplementos() {
		//fail("Not yet implemented");
		GestorComplemento gcom = new GestorComplemento();
    	GestorUsuario gu = new GestorUsuario();
    	usuario usuario = new usuario("leire", "leire"); 
    	
    	gu.anyadirFilaATablauUsuario(usuario);
    	gu.modificarUsuarioSistema(usuario);
    	Complemento[] complemento = gcom.selectComplementos();
    
    	assertEquals( complemento.length, 2 );
	}

}
