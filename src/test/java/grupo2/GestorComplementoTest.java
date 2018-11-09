package grupo2;

import static org.junit.Assert.*;
import grupo2.LD.BaseDeDatos;
import grupo2.LN.Complemento;
import grupo2.LN.GestorComplemento;

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
		
		
		Complemento com1 = new Complemento('1' ,"Rojo", "Pulsera", "leire" ); 
		 
		com.anyadirComplemento(BaseDeDatos.getStatement(), com1);
		
		
    }
	@Test
	public void testGestorComplemento() {
		//fail("Not yet implemented");
	}

	@Test
	public void testMaxIdComp() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAnyadirComplemento() {
		Complemento prenda2 = new Complemento('1' ,"Azul", "Collar", "Amaia" );
    	GestorComplemento gc = new GestorComplemento(); 
    	gc.anyadirComplemento(BaseDeDatos.getStatement(), prenda2);
    	assertEquals( prenda2.getUsuario(), "Amaia" );
		//fail("Not yet implemented");
	}

	@Test
	public void testSelectComplementos() {
		//fail("Not yet implemented");
	}

}
