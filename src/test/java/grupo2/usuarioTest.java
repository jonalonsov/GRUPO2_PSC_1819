package grupo2;

import static org.junit.Assert.*;
import grupo2.LN.usuario;

import org.junit.Test;

public class usuarioTest {

	@Test
	public void testUsuario() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		System.out.println("getNombre");
		usuario instance = new usuario (null, null);
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
		usuario instance = new usuario(nombre, nombre);
		instance.setNombre(nombre);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetContrasenya() {
		System.out.println("getContrasenya");
		usuario instance = new usuario (null, null);
		String expResult = "";
		instance.setContrasenya("");
		String result = instance.getContrasenya();
		assertEquals(expResult, result);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetContrasenya() {
		System.out.println("setContrasenya");
		String contrasenya ="";
		usuario instance = new usuario(contrasenya, contrasenya);
		instance.setContrasenya(contrasenya);
		//fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		//fail("Not yet implemented");
	}

}
