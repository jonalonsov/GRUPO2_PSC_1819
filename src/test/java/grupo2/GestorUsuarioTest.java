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
    
    @Test
    public void testanyadirFilaATablauUsuario()
    {
    	GestorUsuario gu = new GestorUsuario();
    	usuario usuario = new usuario("uxue", "uxue"); 
    	
    	boolean expected = gu.anyadirFilaATablauUsuario(usuario);
    	
    	
        assertEquals( expected, true );
        

    }
    
    @Test
    public void testanyadirFilaATablauUsuario2()
    {
    	GestorUsuario gu = new GestorUsuario();
    	usuario usuario = new usuario("Maider", "maider"); 
    	
    	gu.anyadirFilaATablauUsuario(usuario);
    	
        assertEquals( usuario.getNombre(), "Maider" );

    }
    
    @Test
    public void testchequearYaEnTablaLOGIN()
    {
    	GestorUsuario gu = new GestorUsuario();
    	
    	boolean expected = gu.chequearYaEnTablaLOGIN( "Maider", "maider");
    	
        assertEquals( expected, true );

    }
    
    @Test
    public void testmodificarUsuarioSistema()
    {
    	GestorUsuario gu = new GestorUsuario();
    	
    	usuario usuario = new usuario("Maider", "maider"); 
    	
    	//El usuario usando el sistema pasa a ser Maider
    	gu.modificarUsuarioSistema(usuario);
    	
    	//Compueba que es así
        assertEquals( gu.nombreUsuario(), "Maider" );

    }
    
    
}