package grupo2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import grupo2.LN.IEuskalment;


public class MockTestEuskalmet {
	
	
	IEuskalment objEuskalmet;
	private static boolean setUpIsDone = false;
	
	@Mock
	IEuskalment objIEuskalmet;
	
	@Before 
	public void setUp() { 
		if(setUpIsDone){
			return;
		}

		objIEuskalmet = Mockito.mock(IEuskalment.class);
		Mockito.when(objIEuskalmet.prevMet(25, "Buena previsión")).thenReturn("Va a hacer buen tiempo, con una temperatura de 20º");
		Mockito.when(objIEuskalmet.probLluvia(20, 15, 1)).thenReturn(25);
		Mockito.when(objIEuskalmet.sensacionTermica(25, 25/12/2018)).thenReturn(28);
		
    }
	
	
	@Test
	public void testGestorComplemento() {
		//fail("Not yet implemented");
	}

	

}
