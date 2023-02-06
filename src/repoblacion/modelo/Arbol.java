package repoblacion.modelo;

public class Arbol {
	Posicion posicion;
	Especie especie;
	
	public Arbol(Especie especie,Posicion posicion) {
		setEspecie(especie);
		setPosicion(posicion);
	}
	public Arbol(Arbol arbol) {
		if (arbol==null) {
			throw new NullPointerException("Error : La copia no puede ser nula");
		}
		this.especie=getEspecie();
		this.posicion=getPosicion();
	}
	
	
	@Override
	public String toString() {
		return "El arbol se encuentra en la posicion=" + posicion + " y pertenece a la  especie " + especie + " .";
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	
	

}
