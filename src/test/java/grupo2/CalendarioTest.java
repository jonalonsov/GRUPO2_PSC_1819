package grupo2;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import grupo2.LN.Calendario;
import grupo2.LN.Fecha;
import org.junit.Test;

public class CalendarioTest {
	
	private Calendario instance;
	private Fecha fecha;
	private Fecha fecha2;
	
	@Before
	public void setUp() {
		fecha = new Fecha(2018, 1, 25);
		fecha2 = new Fecha(2020,1,1);
		instance = new Calendario (1, 2, "Gorka", fecha);
	}
	
	@After
	public void tearDown() throws Exception {
		instance = null;
		fecha = null;
		fecha2 = null;
	}
	
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	

	@Test
	@PerfTest(invocations = 1000, threads = 5000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1000, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testGetId() {
		int expResult = 1;
		
		int result = instance.getId();
		assertEquals(expResult, result);
	}

	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1000, average = 300, median=500)  //Required define las requisitos d
	public void testSetId() {
		int expResult = 3;
		
		instance.setId(3);
		int result = instance.getId();
		
		assertEquals(expResult, result);
		
	}
	@Test
	@PerfTest(invocations = 10000, threads = 5000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 50, average = 300, median=500)  //Required define las requisitos d
	public void testGetUsuario() {
		String expResult = "Gorka";
		
		String result = instance.getUsuario();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetusuario() {
		String expResult = "Leire";
		
		instance.setUsuario("Leire");
		
		String result = instance.getUsuario();
		
		assertEquals(expResult, result);
	}
	
	@Test
	public void getFecha() {
		int expResult = 2018;
		int result = instance.getFecha().getAño();

		assertEquals(expResult, result);
	}


	@Test
	public void setFecha() {
		int expResult = 2020;
		instance.setFecha(fecha2);
		
		int result = instance.getFecha().getAño();

		assertEquals(expResult, result);
	}
	
	
	@Test
	public void getIdConjunto() {
		int expResult = 2;
		
		int result = instance.getIdConjunto();
		assertEquals(expResult, result);
	}

	@Test
	public void setIdConjunto() {
		int expResult = 3;
		
		instance.setIdConjunto(3);
		int result = instance.getIdConjunto();
		
		assertEquals(expResult, result);
	}
}
