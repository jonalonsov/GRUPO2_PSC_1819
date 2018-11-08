

	package grupo2;

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertFalse;
	import static org.junit.Assert.assertTrue;

import java.sql.Statement;

import org.junit.Before;
	import org.junit.Test;

	import grupo2.LD.BaseDeDatos;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorPrendas;

	import grupo2.LN.Prenda;



	/**

	 * Unit test for GestorUsuario.

	 */

	public class GestorPrendaTest {

		@Before 
		
		public void setUp() { 
			
			BaseDeDatos.initBD("miarmarioTest.bd");
			
			BaseDeDatos.crearTablaBDPrenda();
			BaseDeDatos.crearTablaBDConjunto();
			BaseDeDatos.crearTablaBDUsuario();
			BaseDeDatos.crearTablaUsuarioSesion();
			
			GestorPrendas pr = new GestorPrendas();
			
			Prenda prenda1 = new Prenda('1' ,"Camiseta", "gris", "Algodón", " ", "leire" ); 
			Prenda prenda2 = new Prenda('2' ,"Pantalón", "azul", "Vaquero", " ", "leire" ); 
			Prenda prenda3 = new Prenda('3' ,"Camisa", "blanco", "Lino", " ", "leire" ); 
			
			pr.anyadirPrenda(BaseDeDatos.getStatement(), prenda1);
			pr.anyadirPrenda(BaseDeDatos.getStatement(), prenda2);
			pr.anyadirPrenda(BaseDeDatos.getStatement(), prenda3);
			
			
			Conjunto conjunto1 = new Conjunto('1', '3', '2', "leire", '0');  
			Conjunto conjunto2 = new Conjunto( '2', '1', '2', "leire", '0'); 
			
			pr.anyadirConjunto(BaseDeDatos.getStatement(), conjunto1);
			pr.anyadirConjunto(BaseDeDatos.getStatement(), conjunto2);
	    }

	    @Test
	    public void testchequearYaEnTabla()
	    {
	    	GestorPrendas gp = new GestorPrendas(); 
	    	int max = gp.maxIdConjunto();
	        assertTrue( max == 2 );
	    }
	    
	    
	    
	}