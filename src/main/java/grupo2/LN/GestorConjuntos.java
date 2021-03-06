package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import grupo2.LD.BaseDeDatos;
import grupo2.LP.Principal;

public class GestorConjuntos {

	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	//<--GOE--> HACER LO MISMO QUE HE HECHO CON GESTORCOMPLEMENTOS Y GESTORPRENDAS, NO CREAR UN NUEVO OBJETO
	private Statement st;
	private GestorUsuario gusuario;
	private static ResultSet rs;
	public GestorConjuntos(){
		st=BaseDeDatos.getStatement();
		
	}
	public int maxIdConjunto() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT idC from Conjunto ORDER BY idC DESC LIMIT 1 ";
				//System.out.println( sentSQL ); 

				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("idC");	
						  //  System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					id=0;
				} 
		return id;
	}
	
	public int maxIdPropuesta() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT idP from PROPUESTAS ORDER BY idP DESC LIMIT 1 ";
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("idP");	
						   // System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					id=0;
				} 
		return id;
	}
	
	public int maxIdCalendario() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT id from CALENDARIO ORDER BY id DESC LIMIT 1 ";
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("id");	
						   // System.out.println(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					id=0;
				} 
		return id;
	}
	
	public boolean anyadirConjunto(Conjunto conjunto) {
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		int id = maxIdConjunto() + 1;
		int val;
		try {
				
				String sentSQL = "insert into CONJUNTO values(" + "'" + id + "', " + "'" + conjunto.getPrenda1() + "', " + "'" + conjunto.getPrenda2() + "', "+"'" + gusuario.nombreUsuario() + "', "+"'" + conjunto.getFavorito() + "')"; 
				log.trace("Mensaje: El conjunto " +id+ " se ha añadido");
			
				val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean anyadirConjuntoA(Conjunto conjunto) {
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		int id = maxIdPropuesta() + 1;
		int val;
		try {
				
				String sentSQL = "insert into PROPUESTAS values(" + "'" + id + "', " + "'" + conjunto.getPrenda1() + "', " + "'" + conjunto.getPrenda2() + "', "+"'" + gusuario.nombreUsuario() + "', "+"'" + conjunto.getFavorito() + "')"; 
				log.trace("Mensaje: La propuesta " +id+ " se ha añadido");
				
				val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean anyadirConjuntoCalendario(int idConjunto) {
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int val0=0;
		 String valNulo = "";
		 int id = maxIdCalendario() + 1;

		 
		try {
				String sentSQL = "insert into CALENDARIO values(" + "'" + id + "', " + "'" + idConjunto + "', " + "'" + gusuario.nombreUsuario() + "', " + "'" + val0 + "', "+"'" + valNulo + "', "+"'" + val0 + "')"; 
				log.trace("Mensaje: El conjunto " +id+ " se ha añadido al calendario");
				
				val0 = st.executeUpdate( sentSQL );
				if (val0!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean anyadriFechaCalendario(int año, String mes, int dia) {
		 st=BaseDeDatos.getStatement();
		try {
			 String sentSQL = "UPDATE CALENDARIO SET año = '" + año + "', mes= " + "'" + mes+ "', dia= " + "'" + dia+ "' where ( id = '" + maxIdCalendario() + "')";
            
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean modifFavConjunto(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "update CONJUNTO set "+ 
					"favorito = 1 where ( idC = '" + id + "')";
				
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean modifNoFavConjunto(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "update CONJUNTO set "+ 
					"favorito = 0 where ( idC = '" + id + "')";
				
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean deleteCalendario(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "delete from CALENDARIO where ( id = '" + id + "')";
			log.trace("Mensaje: El conjunto " +id+ " se ha añadido del calendario");
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	
	
	public Conjunto[] selectConjuntos() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select * from CONJUNTO  where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 0 + "')";
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				conjuntos.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		//Pasamos de ArrayList a Array
		Conjunto[] Arrconjuntos = new Conjunto[conjuntos.size()];
		Arrconjuntos = conjuntos.toArray(Arrconjuntos);
		
		return Arrconjuntos;
		
	}
	public Conjunto[] selectPropuestas() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select * from PROPUESTAS  where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 0 + "')";
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				conjuntos.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		//Pasamos de ArrayList a Array
		
		Conjunto[] Arrconjuntos = new Conjunto[conjuntos.size()];
		Arrconjuntos = conjuntos.toArray(Arrconjuntos);
		
		return Arrconjuntos;
		
	}
	
	public Calendario[] selectCalendario() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 
		//Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Calendario> calendarios = new ArrayList<Calendario>();
		Fecha fecha;
		try {
			String sentSQL = "select * from CALENDARIO  where ( usuario = '" + gusuario.nombreUsuario() + "')";
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				int año = rs.getInt(4);
				String mes = rs.getString(5);
				//System.out.println("MEEEEEEES" +rs.getString(5));
				int dia = rs.getInt(6);
				int mesNum;
				
				if(mes.equals("Enero")) { mesNum=1;
				} else if ( mes.equals("Febrero")){ mesNum=2;
				} else if ( mes.equals("Marzo")){ mesNum=3;
				} else if ( mes.equals("Abril")){ mesNum=4;
				} else if ( mes.equals("Mayo")){ mesNum=5;
				} else if ( mes.equals("Junio")){ mesNum=6;
				} else if ( mes.equals("Julio")){ mesNum=7;
				} else if ( mes.equals("Agosto")){ mesNum=8;
				} else if ( mes.equals("Septiembre")){ mesNum=9;
				} else if ( mes.equals("Octubre")){ mesNum=10;
				} else if ( mes.equals("Noviembre")){ mesNum=11;
				} else mesNum=12;
				
				
				fecha = new Fecha(año, mesNum, dia);
				
										
				calendarios.add(new Calendario(rs.getInt(1), rs.getInt(2), rs.getString(3),fecha));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		//Pasamos de ArrayList a Array
		Calendario[] Arrcalendarios = new Calendario[calendarios.size()];
		Arrcalendarios = calendarios.toArray(Arrcalendarios);
		
		return Arrcalendarios;
		
	}
	
	public Conjunto[] selectConjuntosFav() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		
		 ArrayList<Conjunto> propuestas = new ArrayList<Conjunto>();
		 try {
				String sentSQL = "select * from PROPUESTAS where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
								
				ResultSet rs = st.executeQuery( sentSQL );
				while (rs.next()) {
					
					//Añadimos los id-s de los conjuntos que son favoritos
					propuestas.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
				
			}
		 
		 	
			Conjunto[] Arrpropuesta = new Conjunto[propuestas.size()];
			Arrpropuesta = propuestas.toArray(Arrpropuesta);
		 
		 //Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select * from CONJUNTO where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
			
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				conjuntos.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
				//Pasamos de ArrayList a Array
		
		Conjunto[] Arrconjuntos = new Conjunto[conjuntos.size()];
		Arrconjuntos = conjuntos.toArray(Arrconjuntos);
					
		return Arrconjuntos;
		
	}
	public Conjunto[] selectPropuestaFav() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		
		 ArrayList<Conjunto> propuestas = new ArrayList<Conjunto>();
		 try {
				String sentSQL = "select * from PROPUESTAS where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
				
				ResultSet rs = st.executeQuery( sentSQL );
				while (rs.next()) {
					
					//Añadimos los id-s de los conjuntos que son favoritos
					propuestas.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
				
			}
		 
				//Pasamos de ArrayList a Array
		
		Conjunto[] Arrpropuestas = new Conjunto[propuestas.size()];
		Arrpropuestas = propuestas.toArray(Arrpropuestas);
		
				
		return Arrpropuestas;
		
	}
	public Conjunto conjuntoconID(int id) {
		//SELECT
		 Statement st=BaseDeDatos.getStatement();
		 Conjunto objConjunto = null;
			try {
				
				String sentSQL = "select * from CONJUNTO where ( idC = '" + id + "')";
				
				ResultSet rs = st.executeQuery( sentSQL );
				while (rs.next()) {
					
					objConjunto = new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5));				
					return objConjunto;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
				
			}
			return objConjunto;
			
		}
	
	public boolean modifFavAleatorio(int id) {
		// TODO Auto-generated method stub
		st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "update PROPUESTAS set "+ 
					"favorito = 1 where ( idP = '" + id + "')";
			log.trace("Mensaje: La propuesta  " +id+ " se ha añadido como favorito");
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		
	}
	public boolean modifNoFavAleatorio(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "update PROPUESTAS set "+ 
					"favorito = 0 where ( idP = '" + id + "')";
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	public int crearAleatorio1() {
				
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id1=0;
			
		
		 String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Pantalon largo' or nombre = 'Pantalon corto' or nombre = 'Falda') ORDER BY RANDOM () LIMIT 1 "; 							
		 log.trace("Mensaje: Se quiere crear un conjunto aleatorio");

		 try {
					ResultSet rs = st.executeQuery( sentSQL );
					id1 = rs.getInt("id");	
					log.trace("Mensaje: Se ha creado un conjunto aleatorio con el id1"+id1);
				  
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			    
    		return id1;
			
		}
	public int crearAleatorio2() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id2=0;
			
			String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Jersey'  or nombre ='Camiseta corta' or nombre ='Camiseta tirantes' or nombre ='Camiseta larga' or nombre = 'Camisa' or nombre = 'Chaqueta' or nombre = 'Sudadera' or nombre = 'Polo' or nombre = 'Americana' or nombre = 'Abrigo') ORDER BY RANDOM () LIMIT 1 "; 			 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id2 = rs.getInt("id");	
					log.trace("Mensaje: Se ha creado un conjunto aleatorio con el id2"+ id2);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  		    
   		return id2;
			
		}
	
	public int crearLluvia1() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id1=0;
			
			
		 String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Pantalon largo') ORDER BY RANDOM () LIMIT 1 "; 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id1 = rs.getInt("id");	
				    
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			    
   		return id1;
			
		}
	
	public int crearLluvia2() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id2=0;
			
			String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Chaqueta' or nombre = 'Abrigo' and tejido = 'impermeable') ORDER BY RANDOM () LIMIT 1 "; 			 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id2 = rs.getInt("id");	
				  
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  		    
  		return id2;
			
		}
	
	public int crearCalor1() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id1=0;
			
			
		 String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'falda' or nombre = 'Pantalon corto') ORDER BY RANDOM () LIMIT 1 "; 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id1 = rs.getInt("id");	
				    //System.out.println("Radom 1:"+ id1);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			    
  		return id1;
			
		}
	
	public int crearCalor2() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id2=0;
			
			String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Camiseta corta' or nombre = 'Camiseta tirantes' or nombre = 'polo') ORDER BY RANDOM () LIMIT 1 "; 			 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id2 = rs.getInt("id");	
				    //System.out.println("Radom 2:"+ id2);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  		    
 		return id2;
			
		}
	
	public int crearFrio1() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id1=0;
			
			
		 String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Pantalon largo' and tejido <> 'Lino') ORDER BY RANDOM () LIMIT 1 "; 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id1 = rs.getInt("id");	
				    //System.out.println("Radom 1:"+ id1);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			    
  		return id1;
			
		}
	
	public int crearFrio2() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id2=0;
			
			String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Jersey' or nombre = 'Abrigo' or nombre = 'Chaqueta' or nombre = 'Jersey' or nombre = 'Camiseta larga') ORDER BY RANDOM () LIMIT 1 "; 			 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id2 = rs.getInt("id");	
				    //System.out.println("Radom 2:"+ id2);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  		    
 		return id2;
			
		}
	
	public int crearUrbano1() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id1=0;
			
			
		 String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Pantalon largo' or nombre = 'Pantalon corto') ORDER BY RANDOM () LIMIT 1 "; 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id1 = rs.getInt("id");	
				    //System.out.println("Radom 1:"+ id1);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			    
 		return id1;
			
		}
	
	public int crearUrbano2() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id2=0;
			
			String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Jersey' or nombre ='Camiseta corta' or nombre ='Camiseta tirantes' or nombre = 'Sudadera') ORDER BY RANDOM () LIMIT 1 "; 			 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id2 = rs.getInt("id");	
				    //System.out.println("Radom 2:"+ id2);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  		    
		return id2;
			
		}
	
	public int crearFormal1() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id1=0;
			
			
		 String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Pantalon largo' and color ='Negro' and tejido <> 'Vaquero') ORDER BY RANDOM () LIMIT 1 "; 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id1 = rs.getInt("id");	
				    //System.out.println("Radom 1:"+ id1);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			    
		return id1;
			
		}
	
	public int crearFormal2() {
		
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		 int id2=0;
			
			String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre ='Camisa' or nombre ='Polo' and color ='Blanco' or color ='Negro') ORDER BY RANDOM () LIMIT 1 "; 			 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id2 = rs.getInt("id");	
				    //System.out.println("Radom 2:"+ id2);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  		    
		return id2;
			
		}
	
	
	public boolean EliminarConjunto(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "delete from CONJUNTO where ( idC = '" + id + "')";
			log.trace("Mensaje: El conjunto " +id+ " se ha eliminado");
			
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	public boolean EliminarPropuesta(int id) {
		 st=BaseDeDatos.getStatement();
		try {
				
			String sentSQL = "delete from PROPUESTAS where ( idP = '" + id + "')";
			log.trace("Mensaje: La propuesta " +id+ " se ha eliminado");
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	public boolean modifConjAleatorio(int indice4) {
		 st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		
		int val;
		try {
				
				String sentSQL = "insert into CONJUNTO select * from PROPUESTAS where (idP = '" + indice4 + "')";
				val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
}
