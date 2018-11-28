package grupo2;

import static org.junit.Assert.*;
import grupo2.LN.Calendario;
import grupo2.LN.Fecha;

import org.junit.Test;

public class FechaTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	@Test
	public void getAño() {
		Fecha instance = new Fecha (0, 0, 0);
		int expResult = 0;
		//instance.setPrenda1();
		int result = instance.getAño();
		assertEquals(expResult, result);
	}


	@Test
	public void setAño() {
		int Año =0;
		Fecha instance = new Fecha(Año, Año, Año);
		instance.setAño(Año);
	}
	@Test
	public void getMes() {
		Fecha instance = new Fecha (0, 0, 0);
		String expResult = "";
		instance.setMes((Integer) null);
		String result = instance.getMes();
		assertEquals(expResult, result);
	}


	@Test
	public void setMes() {
		int Mes =0;
		Fecha instance = new Fecha(Mes, Mes, Mes);
		instance.setAño(Mes);
	}
	@Test
	public void getDia() {
		Fecha instance = new Fecha (0, 0, 0);
		int expResult = 0;
		//instance.setPrenda1();
		int result = instance.getDia();
		assertEquals(expResult, result);
	}


	@Test
	public void setDia() {
		int Dia =0;
		Fecha instance = new Fecha(Dia, Dia, Dia);
		instance.setAño(Dia);
	}

}
