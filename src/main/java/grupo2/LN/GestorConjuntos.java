package grupo2.LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import grupo2.LD.BaseDeDatos;

public class GestorConjuntos {

	//<--GOE--> HACER LO MISMO QUE HE HECHO CON GESTORCOMPLEMENTOS Y GESTORPRENDAS, NO CREAR UN NUEVO OBJETO
	private Statement st;
	private GestorUsuario gusuario;
	public GestorConjuntos(){
		st=BaseDeDatos.getStatement();
		
	}
	public int maxIdConjunto() {
		//SELECT
		Statement st=BaseDeDatos.getStatement();
		int id=0;
				String sentSQL = "SELECT idC from Conjunto ORDER BY idC DESC LIMIT 1 ";
				System.out.println( sentSQL ); 
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("idC");	
						    System.out.println(id);
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
				System.out.println( sentSQL ); 
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("idP");	
						    System.out.println(id);
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
				System.out.println( sentSQL ); 
				
				ResultSet rs;
				try {
					rs = st.executeQuery( sentSQL );
						    id = rs.getInt("id");	
						    System.out.println(id);
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
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
            
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
			
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
			System.out.println( sentSQL ); 
			
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
		System.out.println(conjuntos.size());
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
			System.out.println( sentSQL ); 
			
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
		System.out.println(conjuntos.size());
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
			System.out.println( sentSQL ); 
			
			ResultSet rs = st.executeQuery( sentSQL );
			while (rs.next()) {
				
				//Añadimos los id-s de los conjuntos que son favoritos
				int año = rs.getInt(4);
				String mes = rs.getString(5);
				System.out.println("MEEEEEEES" +rs.getString(5));
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
				System.out.println( sentSQL ); 
				
				//sentSQL = "select * from PROPUESTAS  where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
				//System.out.println( sentSQL );
				
				ResultSet rs = st.executeQuery( sentSQL );
				while (rs.next()) {
					
					//Añadimos los id-s de los conjuntos que son favoritos
					propuestas.add(new Conjunto(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),rs.getInt(5)));				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
				
			}
		 
		 	System.out.println(propuestas.size());
			Conjunto[] Arrpropuesta = new Conjunto[propuestas.size()];
			Arrpropuesta = propuestas.toArray(Arrpropuesta);
		 
		 //Creamos el arrayList de los que cumplen la condición de ser favoritos
		ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
		try {
			String sentSQL = "select * from CONJUNTO where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
			System.out.println( sentSQL ); 
			
			//sentSQL = "select * from PROPUESTAS  where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
			//System.out.println( sentSQL );
			
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
		System.out.println(conjuntos.size());
		Conjunto[] Arrconjuntos = new Conjunto[conjuntos.size()];
		Arrconjuntos = conjuntos.toArray(Arrconjuntos);
		
		//Arrconjuntos = [].concat(Arrconjuntos, Arrpropuesta);
		//Array.prototype.push.apply(Arrconjuntos, Arrpropuesta);
		//Arrpropuesta=Arrpropuesta.concat(Arrconjuntos);
		
		return Arrconjuntos;
		
	}
	public Conjunto[] selectPropuestaFav() {
		
		 Statement st=BaseDeDatos.getStatement();
		 gusuario = new GestorUsuario();
		
		 ArrayList<Conjunto> propuestas = new ArrayList<Conjunto>();
		 try {
				String sentSQL = "select * from PROPUESTAS where ( usuario = '" + gusuario.nombreUsuario() + "' and favorito = '" + 1 + "')";
				System.out.println( sentSQL ); 
				
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
		System.out.println(propuestas.size());
		Conjunto[] Arrpropuestas = new Conjunto[propuestas.size()];
		Arrpropuestas = propuestas.toArray(Arrpropuestas);
		
		//Arrconjuntos = [].concat(Arrconjuntos, Arrpropuesta);
		//Array.prototype.push.apply(Arrconjuntos, Arrpropuesta);
		//Arrpropuesta=Arrpropuesta.concat(Arrconjuntos);
		
		return Arrpropuestas;
		
	}
	public Conjunto conjuntoconID(int id) {
		//SELECT
		 Statement st=BaseDeDatos.getStatement();
		 Conjunto objConjunto = null;
			try {
				
				String sentSQL = "select * from CONJUNTO where ( idC = '" + id + "')";
				System.out.println( sentSQL ); 
				
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
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
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
			
			
		 String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Pantalones') ORDER BY RANDOM () LIMIT 1 "; 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id1 = rs.getInt("id");	
				    System.out.println("Radom 1:"+ id1);
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
			
			String sentSQL = "SELECT id from PRENDA where (usuario = '" + gusuario.nombreUsuario() + "' and nombre = 'Jersey' or nombre ='Camiseta' or nombre = 'Camisa') ORDER BY RANDOM () LIMIT 1 "; 			 							
				try {
					ResultSet rs = st.executeQuery( sentSQL );
					id2 = rs.getInt("id");	
				    System.out.println("Radom 2:"+ id2);
				} catch (SQLException e) {
					 
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						  		    
   		return id2;
			
		}
}
