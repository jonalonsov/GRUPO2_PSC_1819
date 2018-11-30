

	package grupo2;

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
	import org.junit.Test;

	import grupo2.LD.BaseDeDatos;
	import grupo2.LN.Conjunto;
	import grupo2.LN.GestorConjuntos;
	import grupo2.LN.GestorPrendas;
import grupo2.LN.GestorUsuario;
import grupo2.LN.Prenda;
import grupo2.LN.usuario;



	/**

	 * Unit test for GestorUsuario.

	 */

	public class GestorPrendaTest {

	private static boolean setUpIsDone = false;
		
		@Before 
		public void setUp() { 
			if (setUpIsDone) {
		        return;
		    }
			BaseDeDatos.initBD("miarmarioTest.bd");
			
			BaseDeDatos.crearTablaBDPrenda();
			BaseDeDatos.crearTablaBDConjunto();
			BaseDeDatos.crearTablaBDUsuario();
			BaseDeDatos.crearTablaUsuarioSesion();
			
			GestorPrendas pr = new GestorPrendas();
//			GestorConjuntos gc = new GestorConjuntos();
			
			Prenda prenda1 = new Prenda('1' ,"Camiseta", "gris", "Algodón", " ", "leire" ); 
			Prenda prenda2 = new Prenda('1' ,"Pantalón", "azul", "Vaquero", " ", "leire" ); 
			Prenda prenda3 = new Prenda('1' ,"Camisa", "blanco", "Lino", " ", "leire" ); 
			
			pr.anyadirPrenda(BaseDeDatos.getStatement(), prenda1);
			pr.anyadirPrenda(BaseDeDatos.getStatement(), prenda2);
			pr.anyadirPrenda(BaseDeDatos.getStatement(), prenda3);
			
//			
//			Conjunto conjunto1 = new Conjunto('1', '3', '2', "leire", '0');  
//			Conjunto conjunto2 = new Conjunto( '2', '1', '2', "leire", '0'); 
//			
//			gc.anyadirConjunto(conjunto1);
//			gc.anyadirConjunto(conjunto2);
			
			setUpIsDone = true;
	    }

	   
	    
	    @Test
	    public void testanyadirPrendaP()
	    {
	    	Prenda prenda4 = new Prenda('4' ,"Pantalon", "Azul", "Algodón", " ", "Andrea" );
	    	GestorPrendas gp = new GestorPrendas(); 
	    	gp.anyadirPrenda(BaseDeDatos.getStatement(), prenda4);
	    	assertEquals( prenda4.getUsuario(), "Andrea" );
	    }
	    
	    @Test
	    public void testmaxIdPrenda()
	    {
	    	GestorPrendas gp = new GestorPrendas(); 
	    	int max = gp.maxIdPrenda();
	        assertTrue( max == 4 );
	    }
	    
	    @Test
	    public void testnombrePrendaconID()
	    {
	    	GestorPrendas gu = new GestorPrendas();
	    	
	    	String nombre = gu.nombrePrendaconID(1);
	    
	    	assertTrue( nombre == "leire" );
	    
	    }
	    
	    @Test
	    public void testselectPrendas()
	    {
	    	GestorPrendas gp = new GestorPrendas();
	    	GestorUsuario gu = new GestorUsuario();
	    	usuario usuario = new usuario("leire", "leire"); 
	    	
	    	gu.anyadirFilaATablauUsuario(usuario);
	    	gu.modificarUsuarioSistema(usuario);
	    	Prenda[] prenda = gp.selectPrendas();
	    
	    	assertEquals( prenda.length, 4 );
	    
	    }
	    
	    @Test
	    public void testselectFavoritos()
	    {
	    	GestorPrendas gp = new GestorPrendas();
	    	GestorUsuario gu = new GestorUsuario();
	    	usuario usuario = new usuario("leire", "leire"); 
	    	
	    	gu.anyadirFilaATablauUsuario(usuario);
	    	gu.modificarUsuarioSistema(usuario);
	    	Conjunto[] favoritos = gp.selectFavoritos(null);
	    
	    	assertEquals( favoritos.length, 4 );
	    
	    }
	    
	  
	    
	    
	}