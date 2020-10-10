/**
 * App interfaz scanner
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/10/2020
 */
public class App{
	/**
	 * Se crean tres instancias de Cartas par las cartas del jugador
	 * Se instancian tres cartas para las cartas de cada habitacion
	 * Se instancia 1 carta que va a servir como la carta de la habitacion actual
	 * Las variables nivelAguaFinalHab1, nivelAguaFinalHab2 y nivelAguaFinalHab3 sirven para indicar el nivel del agua final de cada habitacion en el momento que este abre la puerta para pasar a la siguiente habitacion o ganar
	 * tipoHab1,tipoHab2 y tipoHab3 indican el tipo de la carta de cada habitacion 0 si es mago, 1 si es espada y 2 si es dragon
	 * vidaJugadorFinal indica la vida final de cada jugadora al terminar la partida
	 * movimientosJugadorFinal indica la cantidad de movimientos que realizo el jugador a lo largo de la partida
	 * numeroHabitacionFinal indica la habitacion en la que perdio o gano el jugador
	 * nombreFinal va a ir variando cada vez que un jugador nuevo entre a la partida
	 *  @see  class Cartas
	 *  @see class Jugador
	 *  @see class Habitacion
	 *  @see class Resultados
	 */
    int cartaMala = 0;
    Cartas mago;
    Cartas espada;
    Cartas dragon;
    Cartas cartaEnemiga;
    Cartas cartaHabitacion1;
    Cartas cartaHabitacion2;
    Cartas cartaHabitacion3;
    double nivelAguaFinalHab1 = 0.0;
	double nivelAguaFinalHab2 = 0.0;
	double nivelAguaFinalHab3 = 0.0;
	int tipoHab1 =  0;
	int tipoHab2 =  0;
	int tipoHab3 =  0;
	double vidaJugadorFinal = 0;
	int movimientosJugadorFinal = 0;
	int numeroHabitacionFinal = 0;
	String nombreFinal = "SIN RECORD AUN";
	boolean gano = false;

	/**
	 * Se crea una instancia de la clase Resultados
	 * Se crea una instancia de la clase Interfaz Scanner
	 * Se crea una instancia de la clase Jugador
	 * jugar es la variable que indica si no se ha salido de la partida el jugador
	 * seguirJugando indica si el jugador sigue dentro de la misma partida
	 * registroHistorico se va air actualizando conforme se vayan haciendo movimientos, para asi generar un registro de movimientos
	 */
    Resultados resultados = new Resultados();
    InterfazScanner interfaz = new InterfazScanner();
    Habitacion habitacion = new Habitacion();
    Jugador maesito = new Jugador();
    String registroStatsApp = "";
	boolean jugar = true;
	boolean seguirJugando = true;
	String registroHistorico="";

	/**
	 * Efectua: El metodo ejecutar es el que ejecuta el juego con la interfaz Scanner, se instancia en el main
	 * @return void
	 */
	public void ejecutar(){
		/**
		 * Se le da la bienvenida al jugador por primera vez
		 * Se crean las cartas 3 cartas del jugador, mago, espada y dragon
		 * Se crean las 3 cartas de cada habitacion
		 */
		 System.out.println("BIENVENIDO AL SCAPEROOM MEDIEVAL!!!");
          String nombre = interfaz.pedirNombre();
          maesito.setNombre(nombre);
          mago = new Cartas();
          espada = new Cartas();
          dragon = new Cartas();
		  cartaHabitacion1 = new Cartas();
		  cartaHabitacion2 = new Cartas();
		  cartaHabitacion3 = new Cartas();
		  tipoHab1 =  0;
		  tipoHab2 =  0;
		  tipoHab3 =  0;
		  registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3));

		 jugar = true;
      while(jugar == true){
		  /**
		   *Se inicia un ciclo mientras jugar = true, si jugar se convierte a falso, el juego termina por completo

		   */


		  if (habitacion.getNumeroHabitacion() == 3){
		  	/**
			*  Si el numero de habitacion = 3 significa que el jugador gano, por lo que se crean nuevas cartas, tanto del jugador como de la habitacion
		    * Asimismo se devuelven todas las variables y atributos de las Clase Jugador y Habitacion a su estado original
		    * Y se sale del ciclo seguirJugando, lo cual le volveria a indicar al jugador si desea jugar o salir, pero esta vez con atributos nuevos, en otras palabras, se empieza una nueva partida
			 */
			  // LLAMAR A METODO DE INTERFAZ
			  System.out.println("HAS GANADO");
			  maesito.setGano(true);
			  /**
			   * Se hace una comparacion si el jugador que acaba de jugar tiene mejores estadisticas que el que mantiene el record, si las tiene, se cambia a que el jugador actual sea el del record
			   */
			  if(resultados.comparar(numeroHabitacionFinal, movimientosJugadorFinal, vidaJugadorFinal, habitacion.getNumeroHabitacion(), maesito.getMovimientos(), maesito.getVida(), gano, maesito.getGano()) == true){
				  numeroHabitacionFinal = habitacion.getNumeroHabitacion();
				  movimientosJugadorFinal = maesito.getMovimientos();
				  vidaJugadorFinal = maesito.getVida();
				  nombreFinal = maesito.getNombre() ;
				  gano = maesito.getGano();
			  }
			  /**
			   *  Es en esta parte donde se les da el valor inicial a los atributos de Jugador y Habitacion, y donde se crean las nuevas cartas
			   *  Y tambien se les da el valor de 0 a todas las variables de la clase App
			   */
			  maesito.setVida(1.0);
			  maesito.setGano(false);
			  registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionGanar(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
			  System.out.println(registroStatsApp);
			  mago = new Cartas();
			  espada = new Cartas();
			  dragon = new Cartas();
			  cartaHabitacion1 = new Cartas();
			  cartaHabitacion2 = new Cartas();
			  cartaHabitacion3 = new Cartas();
			  tipoHab1 =  0;
			  tipoHab2 =  0;
			  tipoHab3 =  0;
              nivelAguaFinalHab1 = 0;
			  nivelAguaFinalHab2 = 0;
			  nivelAguaFinalHab3 = 0;
			  habitacion.setNumeroHabitacion(0);
			  habitacion.setLetalidad(0.15);
			  maesito.setMovimientos(0);
			  System.out.println("");
			  System.out.println("TU PARTIDA HA TERMINADO, DIGITA TU NOMBRE PARA INCIAR UNA PARTIDA, LUEGO SE TE DARAN OPCIONES DE LO QUIERAS HACER");
			  System.out.println("");
			  System.out.println("BIENVENIDO AL SCAPEROOM MEDIEVAL!!!");
			  System.out.println("");
			  String nombre3 = interfaz.pedirNombre();
			  maesito.setNombre(nombre3);
			  seguirJugando = false;
			  jugar = true;
		  }


        int quiereJugar = interfaz.quiereJugar();

		  /**
		   * Se le pregunta al jugador si desea entrar a la habitacion, mostrar el jugador que tiene el record, o si desea salir.
		   */
        if(quiereJugar == 2){
			/**
			 * Si el jugador elige la opcion dos, entra a la habitacion
			 * Se crea la carta "borrador", a la cual se le van a ir asignando los diferentes atributos de las cartas de cada habitacion dependiendo de la habitacion ebn la que se encuentre el jugador
			 * Se crea la variable cartaMala, la cual genera automatica y aleatoriamente el tipo de las cartas de cada habitacion.
			 */




            cartaEnemiga = new Cartas();
            habitacion.setNivelAgua(0.0);
            habitacion.cambiarNumeroHabitacion(true);
			cartaMala = interfaz.randomCartas();
			if(habitacion.getNumeroHabitacion() == 1){
				tipoHab1 = cartaMala;
			}
			if(habitacion.getNumeroHabitacion() == 2){
				tipoHab2 = cartaMala;
			}
			if(habitacion.getNumeroHabitacion() == 3){
				tipoHab3 = cartaMala;
			}

            if(habitacion.getNumeroHabitacion() == 1){
            	cartaEnemiga.setAtaque(cartaHabitacion1.getAtaque());
            	cartaEnemiga.setDefensa(cartaHabitacion1.getDefensa());
			}
			else if(habitacion.getNumeroHabitacion() == 2){
				cartaEnemiga.setAtaque(cartaHabitacion2.getAtaque());
				cartaEnemiga.setDefensa(cartaHabitacion2.getDefensa());
			}
			else if(habitacion.getNumeroHabitacion() == 3){
				cartaEnemiga.setAtaque(cartaHabitacion3.getAtaque());
				cartaEnemiga.setDefensa(cartaHabitacion3.getDefensa());
			}
			/**
			 * Cada vez que el jugador entre a una habitacion se le sube la letalidad a la clase Habitacion en 0.05
			 */
            habitacion.subirLetalidad();

            seguirJugando = true;
            while(seguirJugando == true) {
				/**
				 * Se crea un ciclo while que mientras la variable seguirJugando sea true, se le pregunta la jugador si desea hacer un movimeinto, mostrar el registro historico de su juego o si desea salir, en cada iteracion
				 */
            	String stats = resultados.toStringStats(maesito.getNombre(), maesito.getVida(), mago.getVida(), espada.getVida(), dragon.getVida(), habitacion.getNumeroHabitacion(), maesito.getMovimientos(), habitacion.getNivelAgua(), habitacion.getLetalidad());
            	registroHistorico += stats;
				System.out.println(stats);
				/**
				 * Se crea una variable llamada stats, la cual va a incluir las estadisticas de la partidda actual, y se va actualizando con cada movimiento
				 * A la variable registroHistorico se le concatena la variable stats, para asi, mas adelante poder mostrar el registro Historico de la partida
				 */

				registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3));
				/**
				 * Se actualiza la variable registroStatsApp, para que cuando el jugador pierda o gane, se le muestre las estadisticas de todos los atributos de todas las diferentes habitaciones cartas, y del mismo jugador
				 */
				int queHacer = interfaz.eleccionMovimiento();
				/**
				 * Se le pregunta al jugador que desea hacer, 1 para hacer un movimiento, 2 para imprimir el registro Historico o 3 para salir del juego.
				 */
				if (queHacer == 1) {
					/**
					 * Si el jugador decide hacer un movimiento, se verifica si el nivel del agua es menor a 1, para subirlo proporcionalmente a la letalidad de la habitacion
					 * Si el nivel del agua es mayor o igual a 1, se hace un setNivelAgua, para que no pase de 1
					 * Posteriormente se verifica el nivel del agua, si este es igual a 1, se le baja la vida al jugador proporcional a la letalidad de la habitacion en la que se encuentra
					 */
					if (habitacion.getNivelAgua() < 1.0) {
						habitacion.subirAgua(habitacion.getLetalidad());
					}
					else if (habitacion.getNivelAgua() >= 1.0) {
						habitacion.setNivelAgua(1.0);
					}
					if (habitacion.getNivelAgua() == 1.0) {
						maesito.setVida(maesito.getVida() -habitacion.getLetalidad());
					}

					int cartaElegida = interfaz.elegirCarta();
					/**
					 * Se le pide al jugador que elija la carta con la que desea atacar, 0 Mago, 1 Espada y 2 Dragon
					 * Si la vida de la carta que eligio es menor o igual a 0, se le impide al jugador realizar un movimiento.
					 */

					if(cartaElegida == 0 && mago.getVida() <=0){
						System.out.println("LA CARTA ELEGIDA NO TIENE VIDA");
						seguirJugando = true;
					}
					else if(cartaElegida == 1 && espada.getVida() <=0){
						System.out.println("LA CARTA ELEGIDA NO TIENE VIDA");
						seguirJugando = true;
					}
					else if(cartaElegida == 2 && dragon.getVida() <=0){
						System.out.println("LA CARTA ELEGIDA NO TIENE VIDA");
						seguirJugando = true;
					}
					else {
						maesito.sumarMovimiento();
						/**
						 * Si la carta elegida tiene vida, se le permite al jugador realizar un ataque con la misma, y se le suma un movimiento al atributo "movimientos" del Jugador
						 * Se realiza una comparacion del tipo de la carta elegida y la carta enemiga, y de acuerdo a la relacion entre los tipos, se le baja vida a una de las dos o a ambas
						 */
							if (cartaElegida == 0) {
								int cantidadAtaques = interfaz.cantidadAtaques();
								mago.trianguloAfectacionMago(cartaEnemiga, cartaMala, cantidadAtaques);
							} else if (cartaElegida == 1) {
								int cantidadAtaques = interfaz.cantidadAtaques();
								espada.trianguloAfectacionEspada(cartaEnemiga, cartaMala, cantidadAtaques);

							} else if (cartaElegida == 2) {
								int cantidadAtaques = interfaz.cantidadAtaques();
								dragon.trianguloAfectacionDragon(cartaEnemiga, cartaMala, cantidadAtaques);
							}




                     }

					if (cartaEnemiga.getVida() <=0) {
						/**
						 * @code Una vez realizado el ataque o ataques respectivos, se verifica si la carta enemiga quedo con vida, si esta quedo sin vida, se le indica al jugador que derroto a la habitacion en la que se encontraba
						 */
						System.out.println("\nHAS DERROTADO A LA HABITACION  " + habitacion.getNumeroHabitacion() + "\n");
						/**
						 * @code Se verifica en que habitacion estaba el jugador, para asi asignar el nivel del agua en el momento en que derroto a dicha habitacion
						 */
						if(habitacion.getNumeroHabitacion() == 1){
							nivelAguaFinalHab1 = habitacion.getNivelAgua();
						}
						else if(habitacion.getNumeroHabitacion() == 2){
							nivelAguaFinalHab2 = habitacion.getNivelAgua();
						}
						else if(habitacion.getNumeroHabitacion() == 3){
							nivelAguaFinalHab3 = habitacion.getNivelAgua();
						}
						/**
						 * Se sale del ciclo donde le pide al jugador hacer movimientos, pero continua en el ciclo donde le pregunta si desea entrar a la habitacion
						 */
						seguirJugando = false;
						jugar = true;

					}


					else if (((mago.getVida()<=0 && dragon.getVida()<=0 && espada.getVida()<=0) || maesito.getVida() <= 0)){
						/**
						 * Si todas las cartas perdieron la vida, o el jugador, se le indica al jugador que ha perdido
						 *
						 */
						System.out.println("\nHAS PERDIDO :(");
						/**
						 *  Se realiza una comparacion entre las estadisticas del mismo con las del jugador que tiene el record, para ver si el jugador va a tener el nuevo record
						 */
						if(resultados.comparar(numeroHabitacionFinal, movimientosJugadorFinal, vidaJugadorFinal, habitacion.getNumeroHabitacion(), maesito.getMovimientos(), maesito.getVida(), gano, maesito.getGano()) == true){
							numeroHabitacionFinal = habitacion.getNumeroHabitacion();
							movimientosJugadorFinal = maesito.getMovimientos();
							vidaJugadorFinal = maesito.getVida();
							nombreFinal = maesito.getNombre() ;
							gano = maesito.getGano();
						}
						/**
						 *  Se realiza una verificacion de en cual habitacion es en la que perdio, para determinar que puertas se muestran habiertas y cuales no
						 */
						if(habitacion.getNumeroHabitacion() == 1){

							registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder1(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
							System.out.println(registroStatsApp);
						}
						else if(habitacion.getNumeroHabitacion() == 2){
							registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder2(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
							System.out.println(registroStatsApp);
						}
						else if(habitacion.getNumeroHabitacion() == 3){
							registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder3(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
							System.out.println(registroStatsApp);
						}
						/**
						 *  Se crean nuevas cartas del jugador y nuevas cartas enemigas
						 *  Se devuelven todos los atributos de las clases Jugador y Habitacion y las variables dentro de la App a su estado original, para empezar una nueva partida
						 */

						maesito.setGano(false);
						maesito.setVida(1.0);
						mago = new Cartas();
						espada = new Cartas();
						dragon = new Cartas();
						cartaHabitacion1 = new Cartas();
						cartaHabitacion2 = new Cartas();
						cartaHabitacion3 = new Cartas();
						tipoHab1 =  0;
						tipoHab2 =  0;
						tipoHab3 =  0;
						nivelAguaFinalHab1 = 0;
		    			nivelAguaFinalHab2 = 0;
						nivelAguaFinalHab3 = 0;
						habitacion.setNumeroHabitacion(0);
						habitacion.setNivelAgua(0.0);
						habitacion.setLetalidad(0.15);
						maesito.setMovimientos(0);
						System.out.println("");
						System.out.println("DIGITA TU NOMBRE PARA EMPEZAR NUEVA PARTIDA, EN LA PROXIMA PANTALLA PODRAS SEGUIR JUGANDO O SALIR");
						System.out.println("");
						System.out.println("BIENVENIDO AL SCAPEROOM MEDIEVAL!!!");
						System.out.println("");
						/**
						 *  Se le pide al nuevo jugador que indique su nombre y se le da la bienvenida a la nueva partida
						 */
						String nombre3 = interfaz.pedirNombre();
						maesito.setNombre(nombre3);
						/**
						 * Se sale del ciclo donde le pide al jugador hacer movimientos, pero continua en el ciclo donde le pregunta si desea entrar a la habitacion
						 */
						seguirJugando = false;
						jugar = true;
					}

					else if((mago.getVida()< habitacion.getLetalidad() && dragon.getVida()< habitacion.getLetalidad() && espada.getVida()< habitacion.getLetalidad())){
						/**
						 *  SI la vida de todas las cartas del jugador se encuentra por debajo de la letalidad de la habitacion, el jugador automaticamente pierde, y se le indica eso mismo
						 */
						System.out.println("\nHAS PERDIDO, LA VIDA DE TUS CARTAS SE ENCONTRABA POR DEBAJO DE LA LETALIDAD");
						/**
						 *  Se realiza una comparacion entre las estadisticas del mismo con las del jugador que tiene el record, para ver si el jugador va a tener el nuevo record
						 */
						if(resultados.comparar(numeroHabitacionFinal, movimientosJugadorFinal, vidaJugadorFinal, habitacion.getNumeroHabitacion(), maesito.getMovimientos(), maesito.getVida(), gano, maesito.getGano()) == true){
							numeroHabitacionFinal = habitacion.getNumeroHabitacion();
							movimientosJugadorFinal = maesito.getMovimientos();
							vidaJugadorFinal = maesito.getVida();
							nombreFinal = maesito.getNombre() ;
							gano = maesito.getGano();
						}
						/**
						 *  Se realiza una verificacion de en cual habitacion es en la que perdio, para determinar que puertas se muestran habiertas y cuales no
						 */
						if(habitacion.getNumeroHabitacion() == 1){
							registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder1(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
							System.out.println(registroStatsApp);
						}
						else if(habitacion.getNumeroHabitacion() == 2){
							registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder2(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
							System.out.println(registroStatsApp);
						}
						else if(habitacion.getNumeroHabitacion() == 3){
							registroStatsApp = (resultados.atributosJugador(maesito.getVida(), maesito.getNombre())+resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder3(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
							System.out.println(registroStatsApp);
						}
						/**
						 *  Se crean nuevas cartas del jugador y enemigas
						 *  Se devuelven a su estado original todas las variables de la clase App, asi como los atributos de todas las clases
						 */
						maesito.setGano(false);
						maesito.setVida(1.0);
						mago = new Cartas();
						espada = new Cartas();
						dragon = new Cartas();
						cartaHabitacion1 = new Cartas();
						cartaHabitacion2 = new Cartas();
						cartaHabitacion3 = new Cartas();

						tipoHab1 =  0;
						tipoHab2 =  0;
						tipoHab3 =  0;
						nivelAguaFinalHab1 = 0;
						nivelAguaFinalHab2 = 0;
						nivelAguaFinalHab3 = 0;
						habitacion.setNumeroHabitacion(0);
						habitacion.setNivelAgua(0.0);
						habitacion.setLetalidad(0.15);
						maesito.setMovimientos(0);
						System.out.println("");
						System.out.println("DIGITA TU NOMBRE PARA EMPEZAR NUEVA PARTIDA, EN LA PROXIMA PANTALLA PODRAS SEGUIR JUGANDO O SALIR");
						System.out.println("");
						System.out.println("BIENVENIDO AL SCAPEROOM MEDIEVAL!!!");
						System.out.println("");
						/**
						 *  Se le pide al nuevo jugador que indique su nombre y se le da la bienvenida a la nueva partida
						 */
						String nombre4 = interfaz.pedirNombre();
						maesito.setNombre(nombre4);
						/**
						 * Se sale del ciclo donde le pide al jugador hacer movimientos, pero continua en el ciclo donde le pregunta si desea entrar a la habitacion
						 */
						seguirJugando = false;
						jugar = true;
					}



				}

				else if (queHacer == 3) {
					/**
					 *  Si el jugador, en el menu de los movimientos, elige la opcion 3, se sale del juego
					 */
					seguirJugando = false;
					jugar = false;

				} else if (queHacer == 2) {
					/**
					 *  Si el jugador, en el menu de los movimientos, elige la opcion 3, se le muestra el registro Historico de todos los movimientos en su partida
					 */
					System.out.println("------------------------------------");
					System.out.println(registroHistorico);
					System.out.println("------------------------------------");

				}
				else{
					/**
					 * SI el jugador comete un error al elegir otra opcion, que no sea 1, 2 o 3, se le vuelve a presentar el menu de los movimientos
					 */
					seguirJugando = true;
				}

            }
        }
        else if(quiereJugar == 1){
			/**
			 *  Si el jugador, en el primer menu, elige la opcion 1, se le muestra el nombre del jugador del record, asi como a la habitacion que llego, el numero de movimientos que realizo, su vida y si gano la partida o no.
			 */
        	System.out.println(nombreFinal + " | HABITACION: "+numeroHabitacionFinal+" | CANTIDAD MOVIMIENTOS: "+ movimientosJugadorFinal + " | VIDA: "+ vidaJugadorFinal+ " | GANO: "+ gano);

		}
        else if(quiereJugar == 3){
			/**
			 *  Si el jugador, en el primer menu, elige la opcion 3, sale del juego
			 *  Esto porque se sale de ambos ciclos
			 */
          jugar = false;
        }
      }
    }
    
    

}
