package grupo2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
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
	
	@Test
	public void testGestorEuskalmet() {
		
		assertTrue(mockIEuskalmet.isPositive(temp));
		assertEquals(mockIEuskalmet.litrosMetro(litros, met2),12);				
		assertEquals(mockIEuskalmet.sensacionTermica(temp, humedad),25);


	}

	

}
