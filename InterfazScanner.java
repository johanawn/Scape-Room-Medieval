
/**
 * Interfaz con scanner
 *
 * @author Johana Wu
 * @author Sabrina Brenes
 * @author Gabriel Bonilla
 * @version (ULTIMA VERSION)
 */

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class InterfazScanner{

	Scanner lector = new Scanner(System.in);
	Boolean iniciarJuego = false;
	boolean Jugar = false;


	/**
	 *Requiere: Que el usuario le ingrese un numero
	 *Efectua: El metodo quiereJugar lo que hace es que le pregunta al jugador si desea ver el record del juego, entrar a la habitacion o salir del juego
	 *@return un int, ya sea 1, 2 o 3
	 */

	public int quiereJugar(){


		System.out.println("\n1. Ver el historial del mejor juego hasta el momento.\n2. Entrar a la habitacion\n3. Salir y abandonar el juego ");
		int eleccion2 = 0;
		int eleccion;


		try {
			eleccion = lector.nextInt();
		}
		catch(Exception e) {
			System.out.println("Recuerda que el rango es de 1 a 3");
			eleccion = 0;
			lector.next();
		}


		if (eleccion == 1) {
			eleccion2 = eleccion;
		}
		else if (eleccion == 2) {
			eleccion2 = eleccion;
		}
		else if (eleccion == 3) {
			eleccion2 = eleccion;
			System.out.println("salistes");
		}
		else if (eleccion > 3 || eleccion <= 0) {
			System.out.println("Fuera de rango");
			quiereJugar();
		}
		return eleccion2;
	}














	/**
	 *Requiere: Que el usuario lo llame y le ingrese un String
	 *Efectua: el metodo pedirNombre le pide al usuario que ingrese un String
	 *@return el String que le ingreso el jugador
	 */
	public String pedirNombre() {
		System.out.println("Digite su nombre");
		String nombre = lector.next();
		System.out.println(nombre+" se le ha entregado 3 carta: 1 MAGO, 1 ESPADA, 1 DRAGÓN");
		return nombre;
	}
	/**
	 *Requiere: Que el usuario le ingrese un numero entre 1 y 3
	 *Efectua: El metodo eleccionMovimiento lo que hace es que le pregunta al jugador hacer un movimiento, ver el registro historico del juego, o si desea salir del juego
	 *@return un int, ya sea 1, 2 o 3
	 */

	public int eleccionMovimiento(){

		Scanner lector = new Scanner(System.in);
		System.out.println("\n1. Hacer un movimiento \n2. Ve registro histórico de su juego \n3.Abandonar el juego \n");
		int respuesta;
		int respuesta2 = 0;
		try {
			respuesta = lector.nextInt();
		}
		catch(Exception e) {
			System.out.println("Recuerda que el rango es de 1 a 3");
			respuesta = 0;
			lector.next();

		}



		if (respuesta == 1) {
			respuesta2 = respuesta;
		}else {
			if (respuesta == 2) {
				respuesta2 = respuesta;
			}else {
				if (respuesta == 3) {
					System.out.println("salistes");
					respuesta2 = respuesta;
				}else {
					if (respuesta > 3 || respuesta <= 0) {
						System.out.println("Fuera de rango");
					}
				}
			}
		}



		return respuesta2;
	}





	/**
	 *Requiere: Que el usuario le ingrese un numero entre 0 y 2
	 *Efectua: El metodo elegirCartas lo que hace es que le pide al usuario digitar un numero de 0 a 2 para elegir una carta
	 *@return un int, ya sea 0, 1 o 2
	 */
	public int elegirCarta() {
		System.out.println("\nELIJA LA CARTA PARA ATACAR \n Digite el numero de la opcion que desea \n\n 0.Mago \n 1.Espada \n 2.Dragon \n");
		int respuesta2;
		int respuesta3 = 0;
		try {
			respuesta2 = lector.nextInt();
		}
		catch(Exception e) {
			System.out.println("Recuerda que el rango es de 0 a 2");
			respuesta2 = 0;
			lector.next();

		}
		if (respuesta2 == 0) {
			respuesta3 = respuesta2;
		}else {
			if (respuesta2 == 1) {
				respuesta3 = respuesta2;
			}else {
				if (respuesta2 == 2) {
					respuesta3 = respuesta2;
				}else {
					if (respuesta2 == 3) {
						respuesta3 = respuesta2;
						System.out.println("Salistes");

					}else {
						if(respuesta2> 3 || respuesta2 < 0) {
							System.out.println("Fuera de rango");
							elegirCarta();
						}
					}
				}
			}
		}


		return respuesta2;
	}

	/**
	 *Requiere: Que el usuario le ingrese un numero Integer
	 *Efectua: Le pide al usuario que digite un numero entero, si este digita un numero menor o igual a cero, se le asigna un 1
	 *@return un int, el numero digitado, o 1
	 */
	public int cantidadAtaques() {
		System.out.println("\nDIGITE LA CANTIDAD DE ATAQUES QUE QUIERE REALIZAR\n");
		int cantidadDeAtaques;
		try {
			cantidadDeAtaques = lector.nextInt();
		}
		catch (Exception e){
			cantidadDeAtaques = 1;
		}
		if ( cantidadDeAtaques < 0){
			cantidadDeAtaques = cantidadDeAtaques * -1;
		}
		return cantidadDeAtaques;
	}




	/**
	 *Requiere: Ser llamado
	 *Efectua: El metodo randomCartas elige un numero aleatorio entre 0 y 2
	 *@return un int, ya sea 0, 1 o 2
	 */
	public int randomCartas(){
		int numRandom = (int) (Math.random()*3);

		return numRandom;
	}



}

