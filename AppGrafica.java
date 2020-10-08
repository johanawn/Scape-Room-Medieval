


public class AppGrafica{
    private int cartaMala = 0;
    private Cartas mago;
    private Cartas espada;
    private Cartas dragon;
    private Cartas cartaEnemiga;
    private Cartas cartaHabitacion1;
    private Cartas cartaHabitacion2;
    private Cartas cartaHabitacion3;
    private double nivelAguaFinalHab1 = 0.0;
	private double nivelAguaFinalHab2 = 0.0;
	private double nivelAguaFinalHab3 = 0.0;
	private int tipoHab1 =  0;
	private int tipoHab2 =  0;
	private int tipoHab3 =  0;

    Resultados resultados = new Resultados();
    InterfazGrafica interfaz = new InterfazGrafica();
    Habitacion habitacion = new Habitacion();
    Jugador maesito = new Jugador();
    String registroStatsApp = "";
	boolean jugar = true;
	boolean seguirJugando = true;
	String registroHistorico="";

	public void ejecutar(){
          
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
		  registroStatsApp = (resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3));
		  jugar = true;
      while(jugar == true){

		  if (habitacion.getNumeroHabitacion() == 3){
			  // LLAMAR A METODO DE INTERFAZ	
			  interfaz.ganar();
			  maesito.setVida(1.0);
			  mago = new Cartas();
			  espada = new Cartas();
			  dragon = new Cartas();
			  cartaHabitacion1 = new Cartas();
			  cartaHabitacion2 = new Cartas();
			  cartaHabitacion3 = new Cartas();
			  
			  registroStatsApp = (resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
			  
			  interfaz.mostrarEstadisticasJugador(registroStatsApp);
			  tipoHab1 =  0;
			  tipoHab2 =  0;
			  tipoHab3 =  0;
			  nivelAguaFinalHab1 = 0;
			  nivelAguaFinalHab2 = 0;
			  nivelAguaFinalHab3 = 0;
			  habitacion.setNumeroHabitacion(0);
			  habitacion.setLetalidad(0.15);
			  maesito.setMovimientos(0);
			  String nombre3 = interfaz.pedirNombre();
			  maesito.setNombre(nombre3);
			  seguirJugando = false;
			  jugar = true;
		  }


        int quiereJugar = interfaz.opcionesIniciales();
 
        if(quiereJugar == 1){

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

            habitacion.subirLetalidad();

            seguirJugando = true;
            while(seguirJugando == true) {

            	String stats = resultados.toStringStats(maesito.getNombre(), maesito.getVida(), mago.getVida(), espada.getVida(), dragon.getVida(), habitacion.getNumeroHabitacion(), maesito.getMovimientos(), habitacion.getNivelAgua(), habitacion.getLetalidad());
            	registroHistorico += stats;
            	resultados.registro(stats);
				
				interfaz.mostrarEstadisticasJugador(stats);
				// LLAMAR A METODO DE INTERFAZ

				int queHacer = interfaz.antesDeMover(stats);
				if (queHacer == 0) {
					if (habitacion.getNivelAgua() < 1.0) {
						habitacion.subirAgua(habitacion.getLetalidad());
					}
					else if (habitacion.getNivelAgua() >= 1.0) {
						habitacion.setNivelAgua(1.0);
					}
					if (habitacion.getNivelAgua() == 1.0) {
						maesito.setVida(maesito.getVida() -habitacion.getLetalidad());
					}

					int cartaElegida = interfaz.eleccionDeCartas();


					if(cartaElegida == 0 && mago.getVida() <=0){
						
						interfaz.cartaMuerta();
						seguirJugando = true;
					}
					else if(cartaElegida == 1 && espada.getVida() <=0){
						
						interfaz.cartaMuerta();
						seguirJugando = true;
					}
					else if(cartaElegida == 2 && dragon.getVida() <=0){
						
						interfaz.cartaMuerta();
						seguirJugando = true;
					}
					else {
						maesito.sumarMovimiento();

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
						// LLAMAR A METODO DE INTERFAZ
						
			        	
						interfaz.derrotaHabitacion(habitacion.getNumeroHabitacion());
						if(habitacion.getNumeroHabitacion() == 1){
							nivelAguaFinalHab1 = habitacion.getNivelAgua();
						}
						else if(habitacion.getNumeroHabitacion() == 2){
							nivelAguaFinalHab2 = habitacion.getNivelAgua();
						}
						else if(habitacion.getNumeroHabitacion() == 3){
							nivelAguaFinalHab3 = habitacion.getNivelAgua();
						}
						seguirJugando = false;
						jugar = true;

					}


					else if (((mago.getVida()<=0 && dragon.getVida()<=0 && espada.getVida()<=0) || maesito.getVida() <= 0)){
						// LLAMAR A METODO DE INTERFAZ
					
			        	
						interfaz.perderGitGud();
						maesito.setVida(1.0);
						mago = new Cartas();
						espada = new Cartas();
						dragon = new Cartas();
						cartaHabitacion1 = new Cartas();
						cartaHabitacion2 = new Cartas();
						cartaHabitacion3 = new Cartas();
						registroStatsApp = (resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
						interfaz.mostrarEstadisticasJugador(registroStatsApp);
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
						String nombre3 = interfaz.pedirNombre();
						maesito.setNombre(nombre3);
						seguirJugando = false;
						jugar = true;
					}

					else if((mago.getVida()< habitacion.getLetalidad() && dragon.getVida()< habitacion.getLetalidad() && espada.getVida()< habitacion.getLetalidad())){
						// LLAMAR A METODO DE INTERFAZ
						
			        	
						interfaz.perderGitGud();
   
						maesito.setVida(1.0);
						mago = new Cartas();
						espada = new Cartas();
						dragon = new Cartas();
						cartaHabitacion1 = new Cartas();
						cartaHabitacion2 = new Cartas();
						cartaHabitacion3 = new Cartas();
						registroStatsApp = (resultados.registroCartasJugador(mago.getVida(), mago.getAtaque(), mago.getDefensa(), espada.getVida(), espada.getAtaque(), espada.getDefensa(),dragon.getVida(), dragon.getAtaque(), dragon.getDefensa())+resultados.registrocartasHabitacion(cartaHabitacion1.getVida(), cartaHabitacion1.getAtaque(), cartaHabitacion1.getDefensa(),cartaHabitacion2.getVida(), cartaHabitacion2.getAtaque(), cartaHabitacion2.getDefensa(),cartaHabitacion3.getVida(), cartaHabitacion3.getAtaque(), cartaHabitacion3.getDefensa(),tipoHab1, tipoHab2, tipoHab3)+resultados.resultadosHabitacionesPerder(nivelAguaFinalHab1,nivelAguaFinalHab2,nivelAguaFinalHab3));
						
						interfaz.mostrarEstadisticasJugador(registroStatsApp);
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
						String nombre4 = interfaz.pedirNombre();
						maesito.setNombre(nombre4);
						seguirJugando = false;
						jugar = true;
					}



				}

				else if (queHacer == 2) {
					seguirJugando = false;
					jugar = false;
					 quiereJugar = interfaz.opcionesIniciales();

				} else if (queHacer == 1) {
					
					interfaz.registroJuego(registroHistorico);

				}
				else{
					seguirJugando = true;
				}

            }
        }
        else if(quiereJugar == 2){
          jugar = false;
        }else if (quiereJugar == 0) {
        	
        	interfaz.records(resultados.getRecord());
        	 quiereJugar = interfaz.opcionesIniciales();
        }
      
      }
      
      

    }
    
    

}


