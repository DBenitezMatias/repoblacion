package repoblacion;



import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp  {
	public static void main(String[] args) {

		Bosque bosque = null;

		int altura;
		int anchura;
		int poblacion;


		do {
			anchura = Consola.leerAnchura();
			altura = Consola.leerAltura();
			poblacion = Consola.leerPoblacion();

			try {

				bosque = new Bosque(anchura, altura, poblacion);

			} catch (IllegalArgumentException e) {
				System.out.println("-----ERROR-----");
			}

		} while (bosque == null);

		
		System.out.println(bosque.toString());
		
}
	}
