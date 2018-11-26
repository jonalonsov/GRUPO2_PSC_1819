package grupo2.LN;

public class Fecha  implements Comparable<Object> {

	private int año;
	private int mes;
	private int dia;
	
	
	
	public Fecha(int año, int mes, int dia){
		
		this.setAño(año);
		this.setMes(mes);
		this.setDia(dia);
		
	}



	public int getAño() {
		return año;
	}



	public void setAño(int año) {
		this.año = año;
	}



	public String getMes() {
		if(mes==1) { return "Enero";
		} else if ( mes==2){ return "Febrero";
		} else if ( mes==3){ return "Marzo";
		} else if ( mes==4){ return "Abril";
		} else if ( mes==5){ return "Mayo";
		} else if ( mes==6){ return "Junio";
		} else if ( mes==7){ return "Julio";
		} else if ( mes==8){ return "Agosto";
		} else if ( mes==9){ return "Septiembre";
		} else if ( mes==10){ return "Octubre";
		} else if ( mes==11){ return "Noviemre";
		} else return "Diciembre";
		
	}



	public void setMes(int mes) {		
		this.mes=mes;
		
	}



	public int getDia() {
		return dia;
	}



	public void setDia(int dia) {
		this.dia = dia;
	}



	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}