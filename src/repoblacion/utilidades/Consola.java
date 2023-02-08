package repoblacion.utilidades;
import repoblacion.modelo.*;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	/*ñeer la anchura del bosque del usuario y verifica si el valor ingresado es válido.
	 *  Si el usuario ingresa un valor menor a 10 o mayor a 1000, se le notifica que hay un error y se le pide que vuelva a ingresar el valor.
	 *   Si el usuario ingresa un valor inválido o si hay un error en la entrada de datos,
	 *    se muestra un mensaje de error y se vuelve a pedir la anchura. Este proceso se repite hasta que se ingrese un valor válido.
	 * */
	
	
	
	
	public static int leerAnchura() {
		int anchura = 0;
		while (true) {
		System.out.println("Introduce la anchura del bosque: ");
		try {
		anchura = Entrada.entero();
		if (anchura >= 10 && anchura <= 1000) {
		break;
		} else {
		System.out.println("Error :  La anchura no puede ser menos a 10 o mayor que 1000.");
		}
		} catch (NumberFormatException e) {
		System.out.println("Error : Debe introducir un número.");
		}
		}
		return anchura;
		}
	
	
	
	
	
	
	public static int leerAltura() {
		int altura = 0;
		boolean error;
		do {
			error = false;
			System.out.println("Introduce la altura del bosque: ");
			try {
				altura = Entrada.entero();
				if (altura < 10 || altura > 500) {
					System.out.println("Error :  La altura debe estar entre 10 y 500.");
					error = true;
				}
			} catch (NullPointerException | IllegalArgumentException e) {
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);
		return altura;
	}

	
	
	
	
	public static int leerPoblacion() {

		int poblacion;

		do {System.out.println("Introduce la poblacion de especies: " );
			poblacion = Entrada.entero();

		}
		while(poblacion < 0 && poblacion > (2*(1000+500)));
		return poblacion;
	}
	

}
