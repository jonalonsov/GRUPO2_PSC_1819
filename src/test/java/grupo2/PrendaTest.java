package grupo2;

import static org.junit.Assert.*;
import grupo2.LN.Prenda;
import grupo2.LN.usuario;

import org.junit.Test;

public class PrendaTest {

	@Test
	public void testPrenda() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		System.out.println("getNombre");
		Prenda instance = new Prenda (0, null, null, null, null, null);
		String expResult = "";
		instance.setNombre("");
		String result = instance.getNombre();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetNombre() {
		System.out.println("setNombre");
		String nombre ="";
		Prenda instance = new Prenda(0, nombre, nombre, nombre, nombre, nombre);
		instance.setNombre(nombre);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetColor() {
		System.out.println("getColor");
		Prenda instance = new Prenda (0, null, null, null, null, null);
		String expResult = "";
		instance.setColor("");
		String result = instance.getColor();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetColor() {
		System.out.println("setColor");
		String color ="";
		Prenda instance = new Prenda(0, color, color, color, color, color);
		instance.setColor(color);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetImagen() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetImagen() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetTejido() {
		System.out.println("getTejido");
		Prenda instance = new Prenda (0, null, null, null, null, null);
		String expResult = "";
		instance.setTejido("");
		String result = instance.getTejido();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetTejido() {
		System.out.println("setTejido");
		String tejido ="";
		Prenda instance = new Prenda(0, tejido, tejido, tejido, tejido, tejido);
		instance.setTejido(tejido);
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
	public void testGetUsuario() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetUsuario() {
		//fail("Not yet implemented");
	}

}
