package grupo2;

import static org.junit.Assert.*;
import grupo2.LN.Calendario;
import grupo2.LN.Conjunto;
import grupo2.LN.Fecha;
import grupo2.LN.usuario;

import org.junit.Test;

public class CalendarioTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	@Test
	public void testGetId() {
		//fail("Not yet implemented");
		Calendario instance = new Calendario (0, 0, null, null);
		int expResult = 0;
		//instance.setPrenda1();
		int result = instance.getId();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetId() {
		
		int id =0;
		Calendario instance = new Calendario(id, id, null, null);
		instance.setId(id);
		//fail("Not yet implemented");
	}
	@Test
	public void testGetUsuario() {
		//fail("Not yet implemented");
		Calendario instance = new Calendario (0, 0, null, null);
		String expResult = "";
		instance.setUsuario("");;
		String result = instance.getUsuario();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetusuario() {
		
		String usuario ="";
		Calendario instance = new Calendario (0, 0, null, null);
		instance.setUsuario(usuario);
		//fail("Not yet implemented");
	}
	@Test
	public void getFecha() {
		Calendario instance = new Calendario (0, 0, null, null);
		Fecha expResult = null;
		instance.setFecha(null);;
		Fecha result = instance.getFecha();
		assertEquals(expResult, result);
	}


	@Test
	public void setFecha() {
		Fecha fecha =null;
		Calendario instance = new Calendario (0, 0, null, null);
		instance.setFecha(fecha);
	}
	@Test
	public void getIdConjunto() {
		Calendario instance = new Calendario (0, 0, null, null);
		int expResult = 0;
		//instance.setPrenda1();
		int result = instance.getIdConjunto();
		assertEquals(expResult, result);
	}

	@Test
	public void setIdConjunto() {
		int idConjunto =0;
		Calendario instance = new Calendario(idConjunto, idConjunto, null, null);
		instance.setIdConjunto(idConjunto);
	}


}
