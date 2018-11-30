package grupo2;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import grupo2.LN.Fecha;

import org.junit.Test;

public class FechaTest {
	private Fecha instance;
	private Fecha fecha2;

	@Before
	public void setUp() {
		instance = new Fecha(2018, 1, 25);
		fecha2 = new Fecha(2020,6,1);

	}
	
	@After
	public void tearDown() throws Exception {
		instance = null;
		fecha2=null;
	}
	
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	

	@Test
	@PerfTest(invocations = 10000, threads = 5000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1000, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void getAño() {
		int expResult = 2018;
		
		int result = instance.getAño();
		assertEquals(expResult, result);
	}


	@Test
	public void setAño() {
		int expResult = 2020;
		
		instance.setAño(fecha2.getAño());
		int result = instance.getAño();
		
		assertEquals(expResult, result);
		
	}
	
	@Test
	@PerfTest(invocations = 10000, threads = 50000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1000, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void getMes() {
		String expResult = "Enero";
		
		String result = instance.getMes();
		assertEquals(expResult, result);
	}


	@Test
	public void setMes() {
		int expResult = 6;
		
		instance.setMes(6);
		int result = 0;
		String mes= instance.getMes();
		if(mes.equals("Junio")) result =6;
		
		assertEquals(expResult, result);
	}
	
	
	@Test
	public void getDia() {
		int expResult = 25;
		
		int result = instance.getDia();
		assertEquals(expResult, result);
	}


	@Test
	public void setDia() {
		int expResult = 1;
		
		instance.setAño(fecha2.getDia());
		int result = instance.getDia();
		
		assertEquals(expResult, result);
	}

}
