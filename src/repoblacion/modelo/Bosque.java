package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;

public class Bosque {
    public static final int MAX_ALTURA = 500;
    public static final int MINIMO = 10;
    public static final int MAX_ANCHURA = 1000;
    public static final int MAX_ESPECIES = 4;
    
    
    private Arbol arbolMasAlejado;
    private Arbol arbolMasCentrado;
    private Random generador = new Random();
    private int ancho;
    private int alto;
    private Arbol[] arboles;

    
    // CONSTRUCTOR
    public Bosque(int ancho, int alto, int poblacion) {
        setAncho(ancho);
        setAlto(alto);
        checkPoblacion(poblacion);
        this.arboles = new Arbol[poblacion];
        repoblar();
        
    }

   

    
    public Arbol[] duplicaBosque() {
        return arboles.clone();
    }

    
    public void checkPoblacion(int poblacion) {
        int perimetro = 2 * (ancho + alto);
        if (poblacion <= 0) {
            throw new IllegalArgumentException("Error : La población debe ser mayor que cero.");
        }
        if (poblacion > perimetro) {
            throw new IllegalArgumentException("Error : La población no puede superar el perímetro del bosque.");
        }
    }

   
    private void repoblar() {
        for (int i = 0; i < arboles.length - 1; i++) {
            int numRandom = generador.nextInt(7);
            Especie especieAleatoria = null;
            switch (numRandom) {
                case 0:
                    especieAleatoria = Especie.ALAMO;
                    break;
                case 1:
                    especieAleatoria = Especie.CASTANO;
                    break;
                case 2:
                    especieAleatoria = Especie.CIPRES;
                    break;
                case 3:
                    especieAleatoria = Especie.ENCINA;
                    break;
                case 4:
                    especieAleatoria = Especie.OLIVO;
                    break;
                case 5:
                    especieAleatoria = Especie.PINO;
                    break;
                case 6:
                    especieAleatoria = Especie.ROBLE;
                    break;
            }
            Posicion posicionAleatoria = new Posicion(generador.nextDouble(getAncho()) + 0, generador.nextDouble(getAlto()) + 0);
            int seleccionarEspecie = generador.nextInt(MAX_ESPECIES);
            if (especieAleatoria == Especie.ALAMO) {
                switch (seleccionarEspecie) {
                    case 0:
                        especieAleatoria = Especie.ALAMO;
                        break;
                    case 1:
                        especieAleatoria = Especie.ENCINA;
                        break;
                    case 2:
                        especieAleatoria = Especie.PINO;
                        break;
                    case 3:
                        especieAleatoria = Especie.ROBLE;
                        break;
                }
            } else if (especieAleatoria == Especie.OLIVO) {
                switch (seleccionarEspecie) {
                    case 0:
                        especieAleatoria = Especie.OLIVO;
                        break;
                    case 1:
                        especieAleatoria = Especie.CIPRES;
                        break;
                    case 2:
                        especieAleatoria = Especie.PINO;
                        break;
                    case 3:
                        especieAleatoria = Especie.ROBLE;
                        break;
                }
            }
            arboles[i] = new Arbol(especieAleatoria, posicionAleatoria);
        }
    }


    

   
    // get y setters
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    /*public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}

	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}*/

    
    public void setAncho(int ancho) {
        if (ancho < MINIMO || ancho > MAX_ANCHURA) {
            throw new IllegalArgumentException("Error : Anchura no válida.");
        }
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        if (alto < MINIMO || alto > MAX_ALTURA) {
            throw new IllegalArgumentException("Error : Altura no válida.");
        }
        this.alto = alto;
    }
    
    @Override
    public String toString() {
    	
		for (Arbol e : arboles) {
			if(e!=null) {
			System.out.println(e);}
		}
		return "------------------- ";
	}

}