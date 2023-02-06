package repoblacion.modelo;

import java.util.Random;

public class Bosque {

	public final int MAX_ALTURA = 500;
	public int MINIMO = 10;
	public final int MAX_ANCHURA = 1000;
	public final int MAX_ESPECIES = 4;

	private Random numAleatorios;
	
	private int ancho;
	private int alto;
	private int poblacion;
	
	


	private Arbol[] arboles;
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;

	/*crea una clase Bosque que recibe tres parámetros: ancho, alto y población.
	 *  Verifica que cada uno cumpla con unos requisitos específicos,
	 *  lanzando una excepción si algún valor es inválido. Si todos los valores son válidos, 
	 *  asigna los valores a las variables de la clase y llama a los métodos checkPoblacion y repoblar.*/
	
	public Bosque(int ancho, int alto, int poblacion) {
		  if (ancho < 10 || ancho > MAX_ANCHURA || alto < 10 || alto > MAX_ALTURA || poblacion <= 1) {
		    throw new IllegalArgumentException("ERROR: Argumentos inválidos");
		  }
		  setAncho(ancho);;
		  setAlto(alto);;
		  setPoblacion(poblacion);
		  arboles = new Arbol[poblacion];
		  checkPoblacion(poblacion);
		  repoblar();
		}
/*
 *  crea una copia de un array de objetos 'Arbol' llamado 'arboles', y devuelve el nuevo array 'copiaBosque'.*/
	
	public Arbol[] duplicaBosque() {
	    Arbol[] copiaBosque = new Arbol[poblacion];
	    for (int i = 0; i < poblacion - 1; i++) {
	        copiaBosque[i] = arboles[i];
	    }
	    return copiaBosque;
	}

//getters y setters
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	
	public int getAncho() {
		return ancho;
	}

	
	public void setAlto(int alto) {
		this.alto = alto;
	}

	
	public int getAlto() {
		return alto;
	}
	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * genera una nueva población de árboles en una posición aleatoria dentro del área del bosque y con una especie aleatoria. 
	 * Para especies específicas, como el alamo y el olivo, se selecciona una especie compatible entre un conjunto de especies compatibles previamente definidas.
	 *  El método utiliza un objeto de la clase "Random" para generar valores aleatorios de posición y especie.
	 */
	private void repoblar() {
	    Random random = new Random();
	    Especie[] especiesCompatiblesAlamo = {Especie.ALAMO, Especie.ENCINA, Especie.PINO, Especie.ROBLE};
	    Especie[] especiesCompatiblesOlivo = {Especie.OLIVO, Especie.CIPRES, Especie.PINO, Especie.ROBLE};
	    
	    for (int i = 0; i < arboles.length - 1; i++) {
	        Posicion posicionAleatoria = new Posicion(random.nextDouble(getAncho()) + 0, random.nextDouble(getAlto()) + 0);
	        Especie especieAleatoria = Especie.values()[random.nextInt(7)];
	        
	        if (especieAleatoria == Especie.ALAMO) {
	            especieAleatoria = especiesCompatiblesAlamo[random.nextInt(MAX_ESPECIES)];
	        } else if (especieAleatoria == Especie.OLIVO) {
	            especieAleatoria = especiesCompatiblesOlivo[random.nextInt(MAX_ESPECIES)];
	        }
	    }
	}


	
	public void checkPoblacion(int poblacion) {
		// Calculamos el perímetro y comprabamos si la poblacion es mayor o igual al perímetro y si es mayor lanzamos una excepción.
		int perimetro = ancho * 2 + alto * 2;
		if (poblacion > perimetro) {
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}
	}

	
	public void realizarCalculos() {
		Arbol mayor = arboles[0];
		Arbol menor = arboles[0];

		for (int i = 1; i < arboles.length - 1; i++) {
			double distancia = arboles[i].getPosicion().distancia(new Posicion(0, 0));

			if (distancia > mayor.getPosicion().distancia(new Posicion(0, 0))) {
				mayor = arboles[i];
			} else if (distancia < menor.getPosicion().distancia(new Posicion(0, 0))) {
				menor = arboles[i];
			}
		}

		arbolMasCentrado = menor;
		arbolMasAlejado = mayor;
	}



	
	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}

	
	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}

}
