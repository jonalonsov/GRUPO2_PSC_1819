package grupo2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

	
	@RunWith(Suite.class)
	@Suite.SuiteClasses({ 

	    // package1
	    CalendarioTest.class,
	    ComplementoTest.class,
	    ConjuntoTest.class,
	    FechaTest.class,
	    GestorComplementoTest.class,
	    GestorConjuntosTest.class,
	    GestorPrendaTest.class,
	    GestorUsuarioTest.class,
	    MockTestEuskalmet.class,
	    PrendaTest.class,
	    usuarioTest.class,
	    ContiperfTest.class,
	    })

	public class AllTests {
	    // Junit tests
	}