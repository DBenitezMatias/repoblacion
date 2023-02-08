package repoblacion.modelo;

public enum Especie {
	ALAMO("Alamo"),ENCINA("Encina"),CASTANO("Castano"),CIPRES("Cipres"),PINO("Pino"),ROBLE("Roble"),OLIVO("Olivo");
	String cadenaAmostrar;
	Especie(String cadenaAmostrar){
		this.cadenaAmostrar=cadenaAmostrar;
	};
	
	public String toString() {
	    return " "+cadenaAmostrar;
	}
	

}
