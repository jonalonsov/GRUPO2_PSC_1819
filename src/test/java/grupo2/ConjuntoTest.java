package grupo2;

import static org.junit.Assert.*;
import grupo2.LN.Conjunto;
import grupo2.LN.Prenda;

import org.junit.Test;

public class ConjuntoTest {

	@Test
	public void testConjunto() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testGetPrenda1() {
		//fail("Not yet implemented");
		System.out.println("getPrenda1");
		Conjunto instance = new Conjunto (0, 0, 0, null, 0);
		String expResult = "";
		//instance.setPrenda1();
		int result = instance.getPrenda1();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetPrenda1() {
		System.out.println("setPrenda1");
		int prenda1 =0;
		Conjunto instance = new Conjunto(prenda1, prenda1, prenda1, null, prenda1);
		instance.setPrenda1(prenda1);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPrenda2() {
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSetPrenda2() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUsuario() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetUsuario() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetFavorito() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetFavorito() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
	}

}
