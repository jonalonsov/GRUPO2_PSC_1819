package grupo2;

import static org.junit.Assert.*;
import grupo2.LD.BaseDeDatos;
import grupo2.LN.Calendario;
import grupo2.LN.Conjunto;
import grupo2.LN.GestorConjuntos;
import grupo2.LN.GestorPrendas;
import grupo2.LN.GestorUsuario;
import grupo2.LN.Prenda;
import grupo2.LN.usuario;

import org.junit.Before;
import org.junit.Test;

public class GestorConjuntosTest {
	
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
		
		GestorConjuntos gc = new GestorConjuntos();
		
		
		Conjunto conjunto1 = new Conjunto('1', '3', '2', "leire", '0');  
		Conjunto conjunto2 = new Conjunto( '2', '1', '2', "leire", '0'); 
		
		gc.anyadirConjunto(conjunto1);
		gc.anyadirConjunto(conjunto2);
		
		setUpIsDone = true;
    }
	
	
	
	
	 @Test
	    public void testanyadirConjunto()
	    {
	    	Conjunto conjunto3 = new Conjunto('3' ,'2', '1', "Andrea", '0');
	    	GestorConjuntos gc = new GestorConjuntos(); 
	    	gc.anyadirConjunto(conjunto3);
	    	assertEquals( conjunto3.getUsuario(), "Andrea" );
	    }
	 @Test
	    public void testmaxIdConjunto()
	    {
		 GestorConjuntos gc = new GestorConjuntos(); 
	    	int max = gc.maxIdConjunto();
	       // assertTrue( max == 4 );
	    }
	 @Test
	    public void testmaxIdPropuesta()
	    {
		 GestorConjuntos gc = new GestorConjuntos(); 
	    	int max = gc.maxIdPropuesta();
	       // assertTrue( max == 1 );
	    }
	 @Test
	    public void testmaxIdCalendario()
	    {
		 GestorConjuntos gc = new GestorConjuntos(); 
	    	int max = gc.maxIdCalendario();
	        //assertTrue( max == 1 );
	    }
	 @Test
	    public void testanyadirConjuntoA()
	    {
	    	Conjunto conjunto4 = new Conjunto('4' ,'1', '1', "Jon", '0');
	    	GestorConjuntos gc = new GestorConjuntos(); 
	    	gc.anyadirConjuntoA(conjunto4);
	    	assertEquals( conjunto4.getUsuario(), "Jon" );
	    }
	 	
	 @Test
	    public void testselectConjuntos()
	    {
		 	GestorConjuntos gc = new GestorConjuntos();
	    	GestorUsuario gu = new GestorUsuario();
	    	usuario usuario = new usuario("leire", "leire"); 
	    	
	    	gu.anyadirFilaATablauUsuario(usuario);
	    	gu.modificarUsuarioSistema(usuario);
	    	Conjunto[] conjunto = gc.selectConjuntos();
	    
	    	assertEquals( conjunto.length, 4 );
	    
	    }
	 @Test
	    public void testselectPropuestas()
	    {
		 GestorConjuntos gc = new GestorConjuntos();
	    	GestorUsuario gu = new GestorUsuario();
	    	usuario usuario = new usuario("leire", "leire"); 
	    	
	    	gu.anyadirFilaATablauUsuario(usuario);
	    	gu.modificarUsuarioSistema(usuario);
	    	Conjunto[] propuestas = gc.selectPropuestas();
	    
	    	assertEquals( propuestas.length, 4 );
	    
	    }
	 @Test
	    public void testselectCalendario()
	    {
		 	GestorConjuntos gc = new GestorConjuntos();
	    	GestorUsuario gu = new GestorUsuario();
	    	usuario usuario = new usuario("leire", "leire"); 
	    	
	    	gu.anyadirFilaATablauUsuario(usuario);
	    	gu.modificarUsuarioSistema(usuario);
	    	Calendario[] calendario = gc.selectCalendario();
	    
	    	assertEquals( calendario.length, 4 );
	    
	    }
	 @Test
	    public void testselectConjuntosFav()
	    {
		 	GestorConjuntos gc = new GestorConjuntos();
	    	GestorUsuario gu = new GestorUsuario();
	    	usuario usuario = new usuario("leire", "leire"); 
	    	
	    	gu.anyadirFilaATablauUsuario(usuario);
	    	gu.modificarUsuarioSistema(usuario);
	    	Conjunto[] conjuntos = gc.selectConjuntosFav();
	    
	    	assertEquals( conjuntos.length, 4 );
	    
	    }
	 
	 @Test
	    public void testconjuntoconID()
	    {
		 	GestorConjuntos gc = new GestorConjuntos();
	    	
	    	Conjunto conjunto = gc.conjuntoconID(1);
	    
	    	//assertTrue( conjunto == "leire" );
	    
	    }
	 
	 @Test
	    public void testcrearAleatorio1()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda1 = new Prenda ( '0', "Pantalon largo", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda1);
			
	    	int exists = gc.crearAleatorio1();
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearAleatorio2()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda2 = new Prenda ( '0', "Jersey", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda2);
	    	int exists = gc.crearAleatorio2();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearLluvia1()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda3 = new Prenda ( '0', "Pantalon largo", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda3);
	    	int exists = gc.crearLluvia1();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearLluvia2()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda4 = new Prenda ( '0', "Chaqueta", "Negro", "impermeable", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda4); 
	    	int exists = gc.crearLluvia2();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearCalor1()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda5 = new Prenda ( '0', "falda", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda5); 
	    	int exists = gc.crearCalor1();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearCalor2()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda6 = new Prenda ( '0', "polo", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda6); 
	    	int exists = gc.crearCalor2();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
	    public void testcrearFrio1()
	    {
	    	GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda7 = new Prenda ( '0', "Pantalon largo", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda7);
	    	int exists = gc.crearFrio1();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearFrio2()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda8 = new Prenda ( '0', "Camiseta larga", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda8);
	    	int exists = gc.crearFrio2();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearUrbano1()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda9 = new Prenda ( '0', "Pantalon largo", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda9);
	    	int exists = gc.crearUrbano1();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearUrbano2()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda10 = new Prenda ( '0', "Camiseta tirantes", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda10);
	    	int exists = gc.crearUrbano2();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearFormal1()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda11 = new Prenda ( '0', "Pantalon largo", "Negro", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda11);
	    	int exists = gc.crearFormal1();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }
		
		@Test
	    public void testcrearFormal2()
	    {
			GestorConjuntos gc = new GestorConjuntos(); 
			GestorPrendas gp = new GestorPrendas();
			
			Prenda prenda12 = new Prenda ( '0', "Polo", "Blanco", "Algodón", "/", "j");
			
			
			gp.anyadirPrenda( BaseDeDatos.getStatement(), prenda12); 
	    	int exists = gc.crearFormal2();
	    	
	    	assertTrue( exists != 0 );
	    	
	    }

}
