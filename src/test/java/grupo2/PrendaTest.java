package grupo2;

import static org.junit.Assert.*;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import grupo2.LN.Prenda;
import org.junit.Test;

public class PrendaTest {

	private Prenda instance;
	@Before
	public void setUp() {

		instance = new Prenda(5, "Pantalon", "Azul", "Algodon", null, "Gorka");
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
		String expResult = "Pantalon";
		String result = instance.getNombre();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetNombre() {
		String expResult = "Camisa";
		
		instance.setNombre("Camisa");
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
	public void testGetImagen() {
		String expResult = null;
		String result = instance.getImagen();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetImagen() {
		String expResult = "https:\\";
		
		instance.setImagen(expResult);
		String result = instance.getImagen();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetTejido() {
		String expResult = "Algodon";
		String result = instance.getTejido();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testSetTejido() {
		String expResult = "Seda";
		
		instance.setTejido("Seda");
		
		String result = instance.getTejido();
		
		assertEquals(expResult, result);
	}

	@Test
	@PerfTest(invocations = 5000, threads = 5000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 3000, median=5000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
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
	@PerfTest(invocations = 5000, threads = 50000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 3000, average = 3000, median=5000)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
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
