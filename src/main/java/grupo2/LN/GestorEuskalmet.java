package grupo2.LN;

import org.apache.log4j.Logger;

import grupo2.LP.Principal;


public class GestorEuskalmet {

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(Principal.class.getName());
	private IEuskalment objIEuskalmet;
	
	public IEuskalment getIEuskalment() {
		return objIEuskalmet;
	}
	public IEuskalment setIEuskalment(IEuskalment objIEuskalmet) {
		return this.objIEuskalmet=objIEuskalmet;
	}
	public boolean isPositive(int temp) {
		// TODO Auto-generated method stub
		return objIEuskalmet.isPositive(temp);
	}
	public int litrosMetro(int litros, int met2) {
		// TODO Auto-generated method stub
		return objIEuskalmet.litrosMetro(litros, met2);
	}
	public int sensacionTermica(int temp, int humedad) {
		// TODO Auto-generated method stub
		return objIEuskalmet.sensacionTermica(temp, humedad);
		
	}



}
