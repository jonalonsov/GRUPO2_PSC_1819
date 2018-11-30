	package grupo2;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorConjuntos;
import grupo2.LN.GestorPrendas;
import grupo2.LN.GestorUsuario;
import grupo2.LN.Prenda;
import grupo2.LN.usuario;


//Default performance behavior for all the @Test annotated methods
//@PerfTest(invocations = 5)
//@Required(max = 1200, average = 250)


//Para que se ejecute con el MoneyTest a la vez
//@RunWith(ContiPerfSuiteRunner.class)
//@SuiteClasses(MoneyTest.class)

public class ContiperfTest {

	/* TIPOS DE PERFEST
	 * invocations: número de veces que se invocará el @Test
	 * threads: hebras concurrentes sobre las que se distribuirán los invocations
	 * duration: tiempo durante el que se ejecutará el test en bucle (ms)
	 */
	
	
	/* TIPOS DE REQUIRED
	 * throughput: número de ejecuciones por segundo menor que …
	 * average: media del tiempo de ejecución menor que …
	 * median: al menos el 50% de las ejecuciones con un tiempo de ejecución menor 
	 * max: tiempo de ejecución de un test menor que …
	 * median: tiempo total de la ejecución de todos los test menor que …
	 * percentileX: al menos el X% de las ejecuciones con un tiempo de ejecución menor
	 */
	
	private Conjunto conj1;
	private GestorConjuntos gu;
	private Conjunto conj2;
	private Conjunto conj3;
	

	@Before 
	public void setUp() throws Exception { 
		BaseDeDatos.initBD("miarmarioTest.bd");
		
		BaseDeDatos.crearTablaBDCalendario();
		BaseDeDatos.crearTablaBDPropuestas();
		
		gu = new GestorConjuntos();
		
		conj1 = new Conjunto(1, 2, 3, "Gorka", 0);
		conj2 = new Conjunto(1, 2, 3, "Gorka", 0);
		conj3 = new Conjunto(3, 6, 8, "Gorka", 1);
		

	}
	
	@After
	public void tearDown() throws Exception {
		BaseDeDatos.close();
	}
	
	//Activa Contiperf cuando se lanza JUnit
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 1000, threads = 5000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 100, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testanyadirConjuntoA(){
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
		gu.anyadirConjunto(conj1);
		gu.anyadirConjunto(conj2);
		gu.anyadirConjunto(conj3);
			
	}
	
	

}
