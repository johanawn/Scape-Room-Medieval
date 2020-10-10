
/**
 * clase cartas
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/10/2020
 */
public class Cartas{
	private String tipo;
	private double vida;
	private double defensa;
	private double ataque;
	/**
	 * Constructor con parámetro, se inicia los atributos de la clase Cartas
	 *
	 */
	public Cartas(int numeroCarta){
		if (numeroCarta ==0){
			setTipo("MAGO");
		}
		else if (numeroCarta == 1){
			setTipo("ESPADA");
		}
		else if (numeroCarta == 2){
			setTipo("DRAGON");
		}
		setVida(1.0);
		setDefensa(  (Math.random() *5+1)*0.1);
		setAtaque((Math.random()*4+6)*0.1);
	}
	/**
	 * Constructor sin parámetro, se inicializa los atributos de la vida, defensa y ataque de la clase Cartas
	 *
	 */
	public Cartas(){
		setVida(1.0);
		setDefensa(Math.random() *0.4000000000000001 + 0.1);
		setAtaque((Math.random()*4.0000000000000001+6)*0.1);
	}

	/**
	 * Método que indica la afectación de la carta local y la cartaEnemiga de clase Cartas, que depende de número de la varibale int cartaMala, el número int de Ataques y de la cartaEnemiga de la clase Cartas
	 * Efectúa : el método trianguloAfectacionMago calcula la cantidad en la cual será restado a la vida de la carta local o la cartaEnemiga de la clase Cartas dependiendo de los parámetros introducidos
	 *@param  cartaEnemiga - carta secreta de la habitación
	 *@param cartaMala - número que indica el tipo de la cartaEnemiga
	 *@param  numeroAtaques - Cantidad de ataques
	 * Modifica : la carta local y la cartaEnemiga de la clase Cartas
	 */
	public void trianguloAfectacionMago(Cartas cartaEnemiga, int cartaMala, int numeroAtaques){

		if (cartaMala == 1 ) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
			}
		}
		else if (cartaMala == 0) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		}
		else if ( cartaMala == 2) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		}

	}

	/**
	 * Método que indica la afectación de la carta local y la cartaEnemiga de clase Cartas, que depende de número de la varibale int cartaMala, el número int de Ataques y de la cartaEnemiga de la clase Cartas
	 *Efectúa : el método trianguloAfectacionEspada calcula y resta la vida de la carta local o la cartaEnemiga de la clase Cartas dependiendo de los parámetros introducidos
	 *@param  cartaEnemiga - carta secreta de la Habitación
	 *@param  cartaMala - número que indica el tipo de la cartaEnemiga
	 *@param  numeroAtaques - cantidad de ataques efectuados
	 * Modifica : la carta local y la cartaEnemiga de la clase Cartas
	 */
	public void trianguloAfectacionEspada(Cartas cartaEnemiga, int cartaMala, int numeroAtaques){

		if (  cartaMala == 2) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
			}
		} else if ( cartaMala == 1 ) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		} else if (  cartaMala == 0) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		}

	}

	/**
	 * Método que indica la afectación de la carta local y la cartaEnemiga de clase Cartas, que depende de número de la varibale int cartaMala, el número int de Ataques y de la cartaEnemiga de la clase Cartas
	 *Efectúa : el método trianguloAfectacionDragon calcula y resta la vida de la carta local o la cartaEnemiga de la clase Cartas dependiendo de los parámetros introducidos
	 *@param  cartaEnemiga - carta secreta de la Habitación
	 *@param  cartaMala - número que indica el tipo de la cartaEnemiga
	 *@ int numeroAtaques - cantidad de ataques efectuados
	 * Modifica : la carta local y la cartaEnemiga de la clase Cartas
	 */
	public void trianguloAfectacionDragon(Cartas cartaEnemiga, int cartaMala, int numeroAtaques){

		if (cartaMala == 0) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
			}
		} else if ( cartaMala == 2) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		} else if (cartaMala == 1) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		}

	}

	/**
	 * Método para para conseguir la vida del la clase Cartas
	 *
	 * @return double vida - vida de la clase Cartas
	 *
	 */
	public double getVida(){
		return vida;
	}
	/**
	 * Método para para conseguir la defensa del la clase Cartas
	 *
	 * @return double defensa - defensa de la clase Cartas
	 *
	 */
	public double getDefensa(){
		return defensa;
	}
	/**
	 * Método para para conseguir el ataque del la clase Cartas
	 *
	 * @return double el ataque - el ataque de la clase Cartas
	 *
	 */
	public double getAtaque(){
		return ataque;
	}
	/**
	 * Método para para conseguir el tipo del la clase Cartas
	 *
	 * @return String tipo - tipo de la clase Cartas
	 *
	 */
	public String getTipo(){
		return tipo;
	}

	/**
	 * Método para modificar el tipo de la clase Cartas
	 *
	 * @param  tipo - tipo de carta
	 *
	 * Modifica : el tipo de la clase Cartas por el valor del parámetro
	 */
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	/**
	 * Método para modificar la vida de la clase Cartas
	 *
	 * @param  vida -vida del jugador
	 *
	 * Modifica : la vida de la clase Cartas por el valor del parámetro
	 */
	public void setVida(double vida){
		this.vida = vida;
	}
	/**
	 * Método para modificar la defensa de la clase Cartas
	 *
	 * @param  defensa -defensa de la carta
	 *
	 * Modifica : la defensa de la clase Cartas por el valor del parámetro
	 */
	public void setDefensa(double defensa){
		this.defensa = defensa;
	}

	/**
	 * Método para modificar el ataque de la clase Cartas
	 *
	 * @param  ataque -ataque de la carta
	 *
	 * Modifica : el ataque de la clase Cartas por el valor del parámetro
	 */
	public void setAtaque(double ataque){
		this.ataque = ataque;
	}

	/**
	 * Método para mostrar la información que contiene el atributo vida de la clase Cartas.
	 * Efectua : el método toStringEnJuego, muestra un mensaje que enseña la vida de la clase Cartas, si la vida se encuentra menor o igual a 0, se le asigna un 0 del valor, por lo contrario se mostrará la vida multiplica por cien.
	 * @return String - mensaje:"VIDA: "+vidaMostrar
	 * Modifica : la vida de la clase Cartas
	 */
	public String toStringEnJuego(){
		int vidaMostrar;
		if (vida <= 0){
			vidaMostrar = 0;
		}
		else {
			vidaMostrar = (int)(vida*100);
		}
		return "VIDA: "+vidaMostrar;
	}

	/**
	 * Método para mostrar la información que contiene el atributo vida, tipo, ataque y defensa de la clase Cartas.
	 * Efectua : el método toStringFinalHabitacion, muestra un mensaje que enseña el tipo, el ataque multiplicado por ciente, la defensa multiplica por cien y la vida de la clase Cartas, si la vida se encuentra menor o igual a 0, se le asigna un 0 del valor, por lo contrario se mostrará la vida multiplica por cien.
	 * @return String - mensaje: "TIPO: "+tipo+ " VIDA: "+vidaMostrar+"%  ATAQUE: "+(int)(ataque*100)+"%  DEFENSA: "+(int)(defensa*100)+"%"
	 * Modifica : la vida, el ataque y la defensa de la clase Cartas
	 */
	public String toStringFinalHabitacion (){
		int vidaMostrar;
		if (vida <= 0){
			vidaMostrar = 0;
		}
		else {
			vidaMostrar = (int)(vida*100);
		}
		return "TIPO: "+tipo+ " VIDA: "+vidaMostrar+"%  ATAQUE: "+(int)(ataque*100)+"%  DEFENSA: "+(int)(defensa*100)+"%";
	}

	/**
	 * Método para mostrar la información que contiene el atributo vida, tipo, ataque y defensa de la clase Cartas.
	 * Efectua : el método toStringFinal, muestra un mensaje que enseña el tipo, el ataque, la defensa y la vida de la clase Cartas multiplicados por cien, si la vida se encuentra menor o igual a 0, se le asigna un 0 del valor, por lo contrario se mostrará la vida multiplica por cien.
	 * @return String - mensaje: "VIDA: "+vidaMostrar+"%  ATAQUE: "+(int)(ataque*100)+"%  DEFENSA: "+(int)(defensa*100)+"%"
	 */
	public String toStringFinal (){
		int vidaMostrar;
		if (vida <= 0){
			vidaMostrar = 0;
		}
		else {
			vidaMostrar = (int)(vida*100);
		}
		return "VIDA: "+vidaMostrar+"%  ATAQUE: "+(int)(ataque*100)+"%  DEFENSA: "+(int)(defensa*100)+"%";
	}
}
