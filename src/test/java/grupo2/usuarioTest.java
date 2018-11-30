package grupo2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import grupo2.LN.usuario;

import org.junit.Test;

public class usuarioTest {
	private usuario instance;
	
	@Before
	public void setUp() {

		instance = new usuario("Jon", "a");
	}
	
	@After
	public void tearDown() throws Exception {
		instance = null;

	}
	
	@Test
	public void testGetNombre() {
		String expResult = "Jon";
		String result = instance.getNombre();
		
		assertEquals(expResult, result);
	}

	
	@Test
	public void testSetNombre() {
		String expResult = "Leire";
		
		instance.setNombre("Leire");
		String result = instance.getNombre();
		
		assertEquals(expResult, result);
	}
	

	@Test
	public void testGetContrasenya() {
		String expResult = "a";
		String result = instance.getContrasenya();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetContrasenya() {
		String expResult = "b";
		
		instance.setContrasenya("b");
		String result = instance.getContrasenya();
		
		assertEquals(expResult, result);
	}

}
