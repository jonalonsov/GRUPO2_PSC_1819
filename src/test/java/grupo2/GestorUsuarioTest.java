package grupo2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.GestorUsuario;
import grupo2.LN.usuario;



/**

 * Unit test for GestorUsuario.

 */

public class GestorUsuarioTest {

	@Before 
	
	public void setUp() { 
		
		BaseDeDatos.initBD("miarmario.bd");
		
		BaseDeDatos.crearTablaBDUsuario();
		
		GestorUsuario gu = new GestorUsuario();
		
		usuario usu1 = new usuario("jon", "jon"); 
		usuario usu2 = new usuario("leire", "leire"); 
		usuario usu3 = new usuario("gorka", "gorka"); 
		
		gu.anyadirUsuario(usu1);
		gu.anyadirUsuario(usu2);
		gu.anyadirUsuario(usu3);
    }

    @Test
    public void testchequearYaEnTabla()
    {
    	GestorUsuario gu = new GestorUsuario(); 
    	boolean expected = gu.chequearYaEnTabla("leire");
        assertTrue( expected == true );

    }
    
    @Test
    public void testchequearYaEnTabla2()
    {
    	GestorUsuario gu = new GestorUsuario();
    	boolean expected = gu.chequearYaEnTabla("Miren");
        assertFalse( expected == true );

    }

}