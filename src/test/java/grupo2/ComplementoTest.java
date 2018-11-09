package grupo2;

import static org.junit.Assert.*;
import grupo2.LN.Complemento;
import grupo2.LN.Conjunto;
import grupo2.LN.usuario;

import org.junit.Test;

public class ComplementoTest {

	@Test
	public void testComplemento() {
				//fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		System.out.println("getNombre");
		Complemento instance = new Complemento (0, null, null, null);
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
		Complemento instance = new Complemento(0, nombre, nombre, nombre);
		instance.setNombre(nombre);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetColor() {
		System.out.println("getColor");
		Complemento instance = new Complemento (0, null, null, null);
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
		Complemento instance = new Complemento(0, color, color, color);
		instance.setColor(color);
		//fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		System.out.println("getId");
		Complemento instance = new Complemento (0, null, null, null);
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
		Complemento instance = new Complemento(id, null, null, null);
		instance.setId(id);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetUsuario() {
		System.out.println("getUsuario");
		Complemento instance = new Complemento (0, null, null, null);
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
		Complemento instance = new Complemento(0, usuario, usuario, usuario);
		instance.setUsuario(usuario);
		//fail("Not yet implemented");
	}

}
