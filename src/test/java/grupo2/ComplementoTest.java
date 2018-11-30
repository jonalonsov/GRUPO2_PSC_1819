package grupo2;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;

import grupo2.LN.Complemento;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ComplementoTest {

	private Complemento instance;

	@Before
	public void setUp() {

		instance = new Complemento(5, "Pulsera", "Azul", null, "Gorka");
	}
	
	@After
	public void tearDown() throws Exception {
		instance = null;

	}
		
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	

	@Test
	@PerfTest(invocations = 5000, threads = 5000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 3000, median=5000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testGetNombre() {
	
		String expResult = "Pulsera";
		String result = instance.getNombre();
		
		assertEquals(expResult, result);
	}

	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1000, average = 300, median=500)  //Required define las requisitos d
	public void testSetNombre() {
		String expResult = "Pendientes";
		
		instance.setNombre("Pendientes");
		String result = instance.getNombre();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetColor() {
		String expResult = "Azul";
		String result = instance.getColor();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetColor() {
		String expResult = "Rojo";
		
		instance.setColor("Rojo");
		String result = instance.getColor();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetId() {
		int expResult = 5;
		
		int result = instance.getId();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetId() {
		int expResult = 3;
		
		instance.setId(3);
		int result = instance.getId();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetUsuario() {
		String expResult = "Gorka";
		
		String result = instance.getUsuario();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetUsuario() {
		String expResult = "Leire";
		
		instance.setUsuario("Leire");
		
		String result = instance.getUsuario();
		
		assertEquals(expResult, result);
	}

}
