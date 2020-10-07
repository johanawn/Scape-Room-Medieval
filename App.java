
public class App{
    int cartaMala = 0;
    Cartas mago;
    Cartas espada;
    Cartas dragon;
    Cartas cartaEnemiga;
    Resultados resultados = new Resultados();
    InterfazScanner interfaz = new InterfazScanner();
    Habitacion habitacion = new Habitacion();
    Jugador maesito = new Jugador();
    String registroStatsApp = "";
	boolean jugar = true;
	boolean seguirJugando = true;
	String registroHistorico="";

	public void ejecutar(){
		System.out.println("BIENVENIDO AL SCAPEROOM MEDIAVAL!!!\n");
          String nombre = interfaz.pedirNombre();
           maesito.setNombre(nombre);
          mago = new Cartas();
          espada = new Cartas();
          dragon = new Cartas();
         registroStatsApp += resultados.registroMago(mago.getVida(), mago.getAtaque(), mago.getDefensa());
         registroStatsApp += resultados.registroEspada(espada.getVida(), espada.getAtaque(), espada.getDefensa());
		 registroStatsApp += resultados.registroDragon(dragon.getVida(), dragon.getAtaque(), dragon.getDefensa());
          jugar = true;
      while(jugar == true){
		  if(habitacion.getNumeroHabitacion() == 3){
			  maesito.setVida(1.0);
			  mago.setVida(1.0);
			  espada.setVida(1.0);
			  dragon.setVida(1.0);
			  habitacion.setNumeroHabitacion(0);
			  habitacion.setNivelAgua(0.0);
			  habitacion.setLetalidad(0.2);
			  maesito.setMovimientos(0);
			  seguirJugando = false;
			  System.out.println("HAS GANADO! :)");
			  System.out.println(registroStatsApp);
			  System.out.println("");

		  }

        int quiereJugar = interfaz.quiereJugar();
 
        if(quiereJugar == 2){


            cartaMala = interfaz.randomCartas();
            cartaEnemiga = new Cartas();
            habitacion.setNivelAgua(0.0);
            habitacion.cambiarNumeroHabitacion(true);
			registroStatsApp+= resultados.registroEnemiga(habitacion.getNumeroHabitacion(), cartaMala, cartaEnemiga.getVida(), cartaEnemiga.getAtaque(), cartaEnemiga.getDefensa());


            // PERDE

            habitacion.subirLetalidad();

            seguirJugando = true;
            while(seguirJugando == true) {

            	String stats = resultados.toStringStats(maesito.getNombre(), maesito.getVida(), mago.getVida(), espada.getVida(), dragon.getVida(), habitacion.getNumeroHabitacion(), maesito.getMovimientos(), habitacion.getNivelAgua(), habitacion.getLetalidad());
            	registroHistorico += stats;
            	resultados.registro(stats);
				System.out.println(stats);
				// LLAMAR A METODO DE INTERFAZ

				int queHacer = interfaz.eleccionMovimiento();
				if (queHacer == 1) {
					if (habitacion.getNivelAgua() < 1.0) {
						habitacion.subirAgua(habitacion.getLetalidad());
					} else if (habitacion.getNivelAgua() >= 1.0) {
						habitacion.setNivelAgua(1.0);
					}
					if (habitacion.getNivelAgua() == 1.0) {
						maesito.setVida(maesito.getVida() -habitacion.getLetalidad());
					}

					int cartaElegida = interfaz.elegirCarta();


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


                          if (cartaElegida == 0) {
							  int cantidadAtaques = interfaz.cantidadAtaques();
							  mago.trianguloAfectacionMago(cartaEnemiga, cartaMala, cantidadAtaques);
						  }

                          else if(cartaElegida == 1){
							  int cantidadAtaques = interfaz.cantidadAtaques();
                          	  espada.trianguloAfectacionEspada(cartaEnemiga, cartaMala, cantidadAtaques);

						  }
                          else if(cartaElegida == 2){
							  int cantidadAtaques = interfaz.cantidadAtaques();
                          	dragon.trianguloAfectacionDragon(cartaEnemiga, cartaMala, cantidadAtaques);
                          }
					}

					if (cartaEnemiga.getVida() <= 0) {
						// LLAMAR A METODO DE INTERFAZ
						System.out.println("\nHAS DERROTADO A LA HABITACION  " + habitacion.getNumeroHabitacion() + "\n");
						seguirJugando = false;
						jugar = true;

					}

					else if (((mago.getVida()<=0 && dragon.getVida()<=0 && espada.getVida()<=0) || maesito.getVida() <= 0)){
						// LLAMAR A METODO DE INTERFAZ
						System.out.println("HAS PERDIDO :(");
						seguirJugando = false;
						jugar = false;
					}

					else if((mago.getVida()<= habitacion.getLetalidad() && dragon.getVida()<= habitacion.getLetalidad() && espada.getVida()<= habitacion.getLetalidad())){
						// LLAMAR A METODO DE INTERFAZ
						System.out.println("HAS PERDIDO :(");
						seguirJugando = false;
						jugar = false;
					}



				}

				else if (queHacer == 3) {
					seguirJugando = false;
					jugar = false;

				} else if (queHacer == 2) {
					System.out.println(registroHistorico);

				}

            }
        }
        else if(quiereJugar == 3){
          jugar = false;
        }
      
      }
      
      

    }
    
    

}
