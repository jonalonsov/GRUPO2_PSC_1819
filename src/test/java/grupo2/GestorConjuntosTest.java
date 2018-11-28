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

}
