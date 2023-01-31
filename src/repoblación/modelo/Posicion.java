package repoblación.modelo;

public class Posicion {
	private double x;
	private double y;
	
	
	public Posicion(double x, double y) {
		
		setX(x);
		setY(y);
		
	}
	
	
	public Posicion(Posicion posicion) {
		if (posicion==null) {
			throw new NullPointerException("Error : No se puede copiar una posición nula");
		}
		this.x=posicion.getX(x);
		this.y=posicion.getY(y);
		
	}
	
	public  double distancia (Posicion posicion) {
	if(posicion==null) {
		throw new NullPointerException("Error : La posición no puede ser nula");
	}
	

	double puntox1=posicion.getX(x);
	double puntoy1=posicion.getY(y);
	double puntox2 = getX(x);
	double puntoy2 =getY(y);
	
	double puntoX=puntox1-puntox2;
	double puntoY=puntoy1-puntoy2;
	
	//calculamos la distancia con el teorema de euclides 
	
	double distancia = Math.sqrt((Math.pow(puntoX, 2)-Math.pow(puntoY, 2)));
	
	
	
	
	//devolvemos la distancia

	
	return distancia;
	
	
	
	
	
	}
	
	
	
	
	
	


	@Override
	public String toString() {
		return "La posicion en el punto X es de =" + x + "M y en el punto Y es de = " + y + "M ";
	}


	private void setX(double x) {
		this.x=x;
	}
	private void setY(double y) {
		this.y=y;
	}
	
	
	
	
	
	
	public  double getX(double x) {
		return x;
	}
	public double getY(double y) {
		return y;
	}
}
