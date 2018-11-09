package grupo2;

import static org.junit.Assert.*;
import grupo2.LN.Conjunto;
import grupo2.LN.Prenda;
import grupo2.LN.usuario;

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
		int expResult = 0;
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
		System.out.println("getId");
		Conjunto instance = new Conjunto (0, 0, 0, null, 0);
		int expResult = 0;
		//instance.setId("");
		int result = instance.getId();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		System.out.println("setId");
		int id =0;
		Conjunto instance = new Conjunto(id, id, id, null, id);
		instance.setId(id);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPrenda2() {
		System.out.println("getPrenda2");
		Conjunto instance = new Conjunto (0, 0, 0, null, 0);
		int expResult = 0;
		//instance.setPrenda1();
		int result = instance.getPrenda2();
		assertEquals(expResult, result);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSetPrenda2() {
		System.out.println("setPrenda2");
		int prenda2 =0;
		Conjunto instance = new Conjunto(prenda2, prenda2, prenda2, null, prenda2);
		instance.setPrenda1(prenda2);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUsuario() {
		System.out.println("getUsuario");
		Conjunto instance = new Conjunto (0, 0, 0, null, 0);
		String expResult = "";
		instance.setUsuario("");
		String result = instance.getUsuario();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetUsuario() {
		System.out.println("setUsuario");
		String usuario ="";
		Conjunto instance = new Conjunto(0, 0, 0, usuario, 0);
		instance.setUsuario(usuario);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetFavorito() {
		System.out.println("getFavorito");
		Conjunto instance = new Conjunto (0, 0, 0, null, 0);
		int expResult = 0;
		//instance.setPrenda1();
		int result = instance.getPrenda2();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetFavorito() {
		System.out.println("setFavorito");
		int favorito =0;
		Conjunto instance = new Conjunto(favorito, favorito, favorito, null, favorito);
		instance.setPrenda1(favorito);
		//fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
	}

}
