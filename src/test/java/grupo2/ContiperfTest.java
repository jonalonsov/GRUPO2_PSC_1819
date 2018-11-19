	package grupo2;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;


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

	//Activa Contiperf cuando se lanza JUnit
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 1000, threads = 20, duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testchequearYaEnTablaP() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
	}
	
	
	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testchequearYaEnTablaU() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
	}
	

	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testanyadirPrenda() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
	}
	

	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testchequearYaEnTabla2U() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testanyadirFilaATablauUsuario() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testanyadirFilaATablauUsuario2() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
		Thread.sleep(200);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testchequearYaEnTablaLOGIN() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 300, average = 300, median=500)  //Required define las requisitos de rendimiento, si no los cumple --> rojo
	public void testmodificarUsuarioSistema() throws Exception{
		//Para que le de tiempo a ejecutar todas las invocations antes de hacer el análisis con contiperf
	}
	
	
}
