package grupo2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import grupo2.LN.GestorEuskalmet;


public class MockTestEuskalmet {
	

	int temp;
	int litros;
	int met2;
	int humedad;
	
	@Mock
	GestorEuskalmet mockIEuskalmet;	
	
	@Before 
	public void setUp() { 

			MockitoAnnotations.initMocks(this);
			Mockito.when(mockIEuskalmet.sensacionTermica(temp, humedad)).thenReturn(25);
			Mockito.when(mockIEuskalmet.litrosMetro(litros, met2)).thenReturn(12);
			Mockito.when(mockIEuskalmet.isPositive(temp)).thenReturn(true);

    }
	
	@After
	public void tearDown() throws Exception {
		mockIEuskalmet = null;

	}
	
	@Rule
	public ContiPerfRule i = new ContiPerfRule();
	
	@Test
	@PerfTest(invocations = 1000, threads = 20000,  duration=2000)   //PerfTest convierte un JUnit en una prueba Contiperf. A definir número de iteraciones y los hilos que se disponen
	@Required(max = 1000, average = 300, median=500)  //Required define las requisitos d
	public void testGestorEuskalmet() {
		assertTrue(mockIEuskalmet.isPositive(temp));
		assertEquals(mockIEuskalmet.litrosMetro(litros, met2),12);				
		assertEquals(mockIEuskalmet.sensacionTermica(temp, humedad),25);


	}

	

}
