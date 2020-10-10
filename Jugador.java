/**
 * Clase Jugador
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/10/2020
 */
public class Jugador{

	private int movimientos;
	private double vida;
	private String nombre;
	private boolean ataca;
	private Cartas mago;
	private Cartas espada;
	private Cartas dragon;
	private boolean gano = false;
	/**
	 * Constructor de la clase Jugador sin parámentros, inicializa los atributos y objetos de la clase Jugador.
	 *
	 */
	public Jugador(){
		gano = false;
		setNombre("");
		setMovimientos(0);
		setVida(1.0);
		int construirCartas = 0;
		mago = new Cartas(construirCartas);
		construirCartas++;
		espada = new Cartas(construirCartas);
		construirCartas++;
		dragon = new Cartas(construirCartas);
	}

	/**
	 * Constructor de la clase Jugador con parámentros, se le asigna a los atributos de la clase Jugador el valor de los parámetros.
	 * @param vida2 - vida del jugador
	 * @param movimiento - movimiento del jugador
	 * @param nombre - nombre del jugador
	 * @param numeroHabitacion -numero de Habitación
	 * Modifica = las variables movimientos, vida y nombre de la clase Jugador.
	 */

	public Jugador(double vida2, int movimiento, String nombre, int numeroHabitacion) {
		this.movimientos = movimiento;
		this.vida = vida2;
		this.nombre = nombre;

	}

	/**
	 * Método para acumular los movimientos, cada vez que llame al método se le suma un 1 al atributo movimientos de la clase Jugador
	 *
	 * Modifica:movimientos de la clase Jugador.
	 */
	public void agregarMovimiento(){
		movimientos += 1;
	}

	/**
	 * Método para conseguir los movimientos de la clase Jugador.
	 * @return int movimientos - Los movimientos de la clase Jugador
	 *
	 */
	public int getMovimientos() {
		return movimientos;
	}

	/**
	 * Método para modificar la variable int movimientos de la clase Jugador
	 *
	 * @param  movimientos - movimientos del jugador
	 *
	 * Modifica : movimientos de la clase Jugador por el valor que se encuentra en el parámetro.
	 */
	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}

	/**
	 * Método para para conseguir la vida del la clase Jugador.
	 *
	 * @return return vida - vida de la clase jugador
	 *
	 */
	public double getVida() {
		return vida;
	}

	/**
	 * Método para modificar el atributo double vida de la clase Jugador
	 *
	 * @param  vida- vida del jugador
	 *
	 * Modifica : vida de la clase Jugador por el valor que se encuentra en el parámetro
	 */
	public void setVida(double vida) {
		this.vida = vida;
	}

	/**
	 * Método para conseguir el nombre de la clase Jugador
	 * @return String nombre - nombre de la clase jugador
	 */

	public String getNombre() {
		return nombre;
	}
	/**
	 * Método para modificar la variable String nombre de la clase Jugador
	 *
	 * @param  nombre -nombre dle jugador
	 *
	 * Modifica : el nombre de la clase Jugador por el valor del parámetro
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método para modificar mago de la clase Jugador
	 *
	 * @param  cartaMago - objeto de la clase Cartas
	 *
	 * Modifica : el mago de la clase Jugador por el valor del parámetro enlazado con la clase Cartas
	 */
	public void setCartaMago(Cartas cartaMago){
		this.mago = cartaMago;
	}

	/**
	 * Método para modificar la espada de la clase Jugador
	 *
	 * @param  cartaEspada - objeto de la clase Cartas
	 *
	 * Modifica : la espada de la clase Jugador por el valor del parámetro enlazado con la clase Cartas
	 */
	public void setCartaEspada(Cartas cartaEspada){
		this.espada = cartaEspada;
	}
	/**
	 * Método para conseguir el varible gano de la clase Jugador
	 * @return boolean gano - indica que el jugador ha ganado o no
	 *
	 */

	public boolean getGano(){return gano;}

	/**
	 * Método para modificar la varible gano de la clase Jugador
	 * @param  gano
	 * Modifica : el varible local boolean gano de la clase Jugador por el valor boolean de parámetro
	 *
	 */

	public void setGano(boolean gano){this.gano = gano;}
	/**
	 * Método para acumular los movimientos, cada vez que llame al método se le suma un 1 al atributo movimientos de la clase Jugador
	 *
	 * Modifica:movimientos de la clase Jugador.
	 */
	public void sumarMovimiento() {
		movimientos += 1;

	}
	/**
	 * Método para modificar el dragon de la clase Jugador
	 *
	 * @param  cartaDragon - objeto de la clase Cartas
	 *
	 * Modifica : el dragon de la clase Jugador por el valor del parámetro enlazado con la clase Cartas
	 */
	public void setCartaDragon(Cartas cartaDragon){
		this.dragon = cartaDragon;
	}

	/**
	 * Método para conseguir el objeto mago de la clase Jugador
	 * @return Cartas mago - el objeto mago de la clase jugador
	 */
	public Cartas getCartaMago(){
		return mago;
	}
	/**
	 * Método para conseguir el objeto espada de la clase Jugador
	 * @return Cartas espada - el objeto espada de la clase jugador
	 */
	public Cartas getCartaEspada(){
		return espada;
	}
	/**
	 * Método para conseguir el objeto dragon de la clase Jugador
	 * @return Cartas dragon - el objeto dragon de la clase jugador
	 */
	public Cartas getCartaDragon(){
		return dragon;
	}
	/**
	 * Método para mostrar la información que contiene los atributos nombre, vida y movimientos de la clase Jugador
	 * @return String - mensaje:"NOMBRE: "+nombre+" VIDA: "+(int)(vida*100)+"% MOVIMIENTOS: "+movimientos
	 */
	public String toString(){
		return "NOMBRE: "+nombre+" VIDA: "+(int)(vida*100)+"% MOVIMIENTOS: "+movimientos;
	}

}



