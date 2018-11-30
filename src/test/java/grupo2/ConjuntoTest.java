package grupo2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import grupo2.LN.Conjunto;
import org.junit.Test;

public class ConjuntoTest {
	
	private Conjunto instance;
	
	@Before
	public void setUp() {

		instance = new Conjunto(8, 4, 10, "Jon", 0);
	}
	
	@After
	public void tearDown() throws Exception {
		instance = null;

	}
	
	@Test
	public void testGetPrenda1() {
		int expResult = 4;
		
		int result = instance.getPrenda1();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetPrenda1() {
		int expResult = 3;
		
		instance.setPrenda1(3);
		int result = instance.getPrenda1();
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetPrenda2() {
		int expResult = 10;
		
		int result = instance.getPrenda2();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetPrenda2() {
		int expResult = 3;
		
		instance.setPrenda2(3);
		int result = instance.getPrenda2();
		
		assertEquals(expResult, result);
	}
	

	@Test
	public void testGetId() {
		int expResult = 8;
		
		int result = instance.getId();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetId() {
		int expResult = 3;
		
		instance.setId(3);
		int result = instance.getId();
		
		assertEquals(expResult, result);
	}



	@Test
	public void testGetUsuario() {
		String expResult = "Jon";
		
		String result = instance.getUsuario();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetUsuario() {
		String expResult = "Leire";
		
		instance.setUsuario("Leire");
		
		String result = instance.getUsuario();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetFavorito() {
		int expResult = 0;
		
		int result = instance.getFavorito();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetFavorito() {
		int expResult = 1;
		
		instance.setFavorito(1);
		int result = instance.getFavorito();
		
		assertEquals(expResult, result);
	}

}
