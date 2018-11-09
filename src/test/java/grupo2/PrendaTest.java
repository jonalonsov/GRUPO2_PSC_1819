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
		System.out.println("getImagen");
		Prenda instance = new Prenda (0, null, null, null, null, null);
		String expResult = "";
		instance.setImagen("");
		String result = instance.getImagen();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetImagen() {
		System.out.println("setImagen");
		String imagen ="";
		Prenda instance = new Prenda(0, imagen, imagen, imagen, imagen, imagen);
		instance.setImagen(imagen);
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
		System.out.println("getId");
		Prenda instance = new Prenda (0, null, null, null, null, null);
		int expResult = 0;
		instance.setUsuario("");
		int result = instance.getId();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		System.out.println("setId");
		int id =0;
		Prenda instance = new Prenda(id, null, null, null, null, null);
		instance.setId(id);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUsuario() {
		System.out.println("getUsuario");
		Prenda instance = new Prenda (0, null, null, null, null, null);
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
		Prenda instance = new Prenda(0, usuario, usuario, usuario, usuario, usuario);
		instance.setUsuario(usuario);
		//fail("Not yet implemented");
	}

}
