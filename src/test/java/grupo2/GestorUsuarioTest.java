package grupo2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import grupo2.LD.BaseDeDatos;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorConjuntos;
import grupo2.LN.GestorUsuario;
import grupo2.LN.usuario;



/**

 * Unit test for GestorUsuario.

 */

public class GestorUsuarioTest {
		
	private static boolean setUpIsDone = false;
	
	@Before	
	public void setUp() { 
		 if (setUpIsDone) {
		        return;
		    }
		BaseDeDatos.initBD("miarmarioTest.bd");
		
		BaseDeDatos.crearTablaBDUsuario();
		BaseDeDatos.crearTablaUsuarioSesion();
		
		GestorUsuario gu = new GestorUsuario();
		
		usuario usu1 = new usuario("jon", "jon"); 
		usuario usu2 = new usuario("leire", "leire"); 
		usuario usu3 = new usuario("gorka", "gorka"); 
		
		gu.anyadirUsuario(usu1);
		gu.anyadirUsuario(usu2);
		gu.anyadirUsuario(usu3);
		
		usuario usu4 = new usuario("irati", "irati"); 
		gu.modificarUsuarioSistema(usu4);
		
		setUpIsDone = true;
    }

    @Test
    public void testchequearYaEnTablaU()
    {
    	GestorUsuario gu = new GestorUsuario(); 
    	boolean expected = gu.chequearYaEnTabla("leire");
        assertTrue( expected == true );

    }
    
    @Test
    public void testanyadirUsuario()
    {
    	usuario usuario1 = new usuario("Amaia", "Amaia");
    	GestorUsuario gu = new GestorUsuario(); 
    	gu.anyadirUsuario(usuario1);
    	assertEquals( usuario1.getNombre(), "Amaia" );

    }
    
    @Test
    public void testanyadirFilaATablauUsuario()
    {
    	usuario usuario2 = new usuario("Iker", "Iker");
    	GestorUsuario gu = new GestorUsuario(); 
    	gu.anyadirFilaATablauUsuario(usuario2);
    	assertEquals( usuario2.getNombre(), "Iker" );

    }
    
    @Test
    public void testmodificarUsuarioSistema()
    {
    	usuario usuario3 = new usuario("Unai", "Unai");
    	GestorUsuario gu = new GestorUsuario(); 
    	gu.modificarUsuarioSistema(usuario3);
    	assertEquals( usuario3.getNombre(), "Unai" );

    }
}