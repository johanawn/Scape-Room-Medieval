
/**
 * clase habitacion
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/10/2020
 */
public class Habitacion{
	private int numeroHabitacion = 0;
	private double letalidad = 0.15;
	private double agua = 0.0;
	private boolean puertaAbierta = false;
	private int carta = (int)(Math.random()*2+1);
	private Cartas cartaEnemiga = new Cartas(carta);

	/**

	 * Efectua : el método cambiarNumeroHabitacion, se le suma un uno al atributo int numeroHabitación de la clase Habitación, si recibe como parámetro una referencia al true
	 * @param  abierto - hace referencia a la puerta de la habitación
	 * Modifica : int numeroHabitación de la clase Habitaciñon
	 */

	public void cambiarNumeroHabitacion(boolean abierto){
		if(abierto == true){
			numeroHabitacion += 1;
		}
	}

	/**
	 * Efectua : el método subirLetalidad, se le suma un 0.05 al atributo int letalidad de la clase Habitación
	 *
	 * Modifica : double letalidad de la clase Habitaciñon
	 */
	public void subirLetalidad(){
		letalidad += 0.05;

	}
	/**
	 * Efectua : el método subirAgua, se le suma al agua de la clase Habitación el valor de la letalidad de la clase Habitación
	 * Modifica : double agua de la clase Habitaciñon
	 */
	public void subirAgua(double nivelLetalidad){
		agua += nivelLetalidad;
	}
	/**
	 * Efectua : el método subirNivelAgua, se le suma al agua de la clase Habitación el valor de la letalidad de la clase Habitación
	 * Modifica : double agua de la clase Habitaciñon
	 */
	public void subirNivelAgua(double letalidad){
		agua += letalidad;
	}
	/**
	 * Método para modificar el atributo double agua de la clase Habitación
	 *
	 * @param  agua- el nivel del agua de la habitación
	 *
	 * Modifica : agua de la clase Habitación por el valor que se encuentra en el parámetro
	 */
	public void setNivelAgua(double agua){
		this.agua = agua;
	}


	/**
	 * Efectua : el método toString, que contiene un String estadoPuerta que contendrá el mensaje "Cerrada" si el estadoAbierta de la clase Habitación es equivalente a false,o "Abierta" si el estadoAbierta es true, muestra un mensaje que enseña el numeroHabitacion, el estadoPuerta, la letalidad multiplicado por cien, el agua multiplica por cien y la información de la cartaEnemiga de la clase Habitación enlazado al clase Cartas llamando el método toStringFinalHabitación que retorna un String.
	 * @return String - mensaje: "HABITACION: "+numeroHabitacion+" -LETALIDAD: "+(int)(letalidad*100)+"%  -NIVEL DE AGUA: "+(int)(agua*100)+"% -ESTADO DE LA PUERTA: "+estadoPuerta+" CARTA SECRETA: " +cartaEnemiga.toStringFinalHabitacion();
	}
	 * Modifica : la vida, el ataque y la defensa de la clase Cartas
	 */
	public String toString(){
		String estadoPuerta="";
		if (puertaAbierta == false){
			estadoPuerta = "Cerrada";
		}
		else{
			estadoPuerta = "Abierta";
		}
		return "HABITACION: "+numeroHabitacion+" -LETALIDAD: "+(int)(letalidad*100)+"%  -NIVEL DE AGUA: "+(int)(agua*100)+"% -ESTADO DE LA PUERTA: "+estadoPuerta+" CARTA SECRETA: " +cartaEnemiga.toStringFinalHabitacion();
	}

	/**
	 * Método para modificar el atributo numeroHabitacion de la clase Habitación
	 *
	 * @param  numeroHabitacion- numero de Habitación
	 *
	 * Modifica : el numeroHabitacion de la clase Habitacion por el valor del parámetro
	 */

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}


	/**
	 * Método abrirPuerta modifica la puertaAbierta a true de la clase Habitación
	 *
	 * Modifica : el boolean puertaAbierta de la clase Habitacón
	 */
	public void abrirPuerta(){
		puertaAbierta = true;
	}


	/**
	 * Método para modificar el atributo letalidad de la clase Habitación
	 *
	 * @param   letalidad - letalidad de la habitación
	 *
	 * Modifica : la letalidad de la clase Habitacion por el valor del parámetro
	 */
	public void setLetalidad(double letalidad) {
		this.letalidad = letalidad;
	}


	/**
	 * Método para conseguir el numeroHabitación de la clase Habitacion.
	 *
	 * @return return numeroHabitacion - el número de habitación
	 *
	 */
	public int getNumeroHabitacion(){
		return numeroHabitacion;
	}
	/**
	 * Método para conseguir el agua de la clase Habitacion.
	 *
	 * @return return agua - nivel del agua de la habitación
	 *
	 */
	public double getNivelAgua(){
		return agua;
	}
	/**
	 * Método para conseguir la letalidad de la clase Habitacion.
	 *
	 * @return letalidad - letalidad de la habitación
	 *
	 */
	public double getLetalidad(){
		return letalidad;
	}
	/**
	 * Método para conseguir el objeto cartaEnemiga de la clase Habitacion
	 * @return cartaEnemiga - el objeto cartaEnemiga de la clase Habitacion
	 */
	public Cartas getCartaEnemiga(){
		return cartaEnemiga;
	}
	/**
	 * Método para modificar el objeto cartaEnemiga de la clase Habitación
	 *
	 * @param   cartaEnemiga - carta secreta de la habitación
	 *
	 * Modifica : el objeto cartaEnemiga de la clase Habitacion por el valor del parámetro
	 */
	public void setCartaEnemiga(Cartas cartaEnemiga){
		this.cartaEnemiga = cartaEnemiga;
	}


}