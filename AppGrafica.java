import javax.swing.JOptionPane;

public class AppGrafica{
   private  int cartaMala = 0;
    private Cartas mago;
    private Cartas espada;
    private Cartas dragon;
    private Cartas cartaEnemiga;
    private Resultados resultados = new Resultados();
    private InterfazGrafica interfaz = new InterfazGrafica();
    private Habitacion habitacion = new Habitacion();
   private  Jugador maesito = new Jugador();
	private Object Cartas;

	public boolean ejecutar(){
          boolean salirDelJuego = false;
          
          mago = new Cartas(0);
          espada = new Cartas(1);
          dragon = new Cartas(2);
          boolean ganar = false;
          boolean jugar = true;
          boolean seguirJugando = false;
          String nombre = interfaz.pedirNombre();
      	  maesito.setNombre(nombre);
          int quiereJugar = interfaz.opcionesIniciales();
         
      while(jugar == true  ||  quiereJugar != 1){
    	 
        if(quiereJugar == 0){
           
        	
            cartaMala = interfaz.randomCartas();
            cartaEnemiga = new Cartas(cartaMala);
            String infCartaEnemiga = "";
            if(cartaEnemiga == new Cartas(cartaMala)) {
            	   
            		infCartaEnemiga += cartaEnemiga.toString(cartaEnemiga);
            }
            habitacion.setNivelAgua(0.0);
            habitacion.cambiarNumeroHabitacion(true);
            habitacion.subirLetalidad();
            if(habitacion.getNumeroHabitacion() > 3){
                ganar= true;
                jugar = false;
                seguirJugando = false;
                // LLAMAR A METODO DE INTERFAZ
               
                
                JOptionPane.showMessageDialog(null, "La carta Enemiga = " +infCartaEnemiga+ "\nAliados:\n "+ mago.toString(mago)+espada.toString(espada)+dragon.toString(dragon));
				interfaz.ganar();
                
                maesito.setVida(1.0);
            	mago.setVida(1.0);
            	espada.setVida(1.0);
            	dragon.setVida(1.0);
            	habitacion.setNumeroHabitacion(1);
            	habitacion.setNivelAgua(0.0);
            	habitacion.setLetalidad(0.2);
            	maesito.setMovimientos(0);
                nombre = interfaz.pedirNombre();
          	  maesito.setNombre(nombre);
               quiereJugar = interfaz.opcionesIniciales();
                
            }
            seguirJugando = true;
            while(seguirJugando == true ) {
				String stats = resultados.toStringStats(maesito.getNombre(), maesito.getVida(), mago.getVida(), espada.getVida(), dragon.getVida(), habitacion.getNumeroHabitacion(), maesito.getMovimientos(), habitacion.getNivelAgua(), habitacion.getLetalidad());
			
				// LLAMAR A METODO DE INTERFAZ

				int queHacer = interfaz.antesDeMover(stats);
				if (queHacer == 0) {
					if (habitacion.getNivelAgua() < 1.0 ) {
						habitacion.subirAgua(habitacion.getLetalidad());
					} else if (habitacion.getNivelAgua() >= 1.0) {
						habitacion.setNivelAgua(1.0);
					}
					if (habitacion.getNivelAgua() == 1.0 || habitacion.getNivelAgua() >= 1.0 ) {
						habitacion.setAgua(1.0);
						maesito.setVida(maesito.getVida() - (maesito.getVida() * habitacion.getLetalidad()));

					}

					int cartaElegida = interfaz.eleccionDeCartas();

					if(cartaElegida == 0 && mago.getVida() <=0){
						System.out.println("LA CARTA ELEGIDA NO TIENE VIDA");
						seguirJugando = false;
					}
					else if(cartaElegida == 1 && espada.getVida() <=0){
						System.out.println("LA CARTA ELEGIDA NO TIENE VIDA");
						seguirJugando = false;
					}
					else if(cartaElegida == 2 && dragon.getVida() <=0){
						System.out.println("LA CARTA ELEGIDA NO TIENE VIDA");
						seguirJugando = false;
					}
					else {
						maesito.sumarMovimiento();
						int cantidadAtaques = interfaz.cantidadAtaques();
						for (int i = 1; i <= cantidadAtaques; i += 1) {

							if (cartaElegida == 0 && cartaMala == 1) {
								cartaEnemiga.setVida((cartaEnemiga.getVida() - mago.getAtaque()) + cartaEnemiga.getDefensa());
							} else if (cartaElegida == 0 && cartaMala == 0) {
								cartaEnemiga.setVida((cartaEnemiga.getVida() - mago.getAtaque()) + cartaEnemiga.getDefensa());
								mago.setVida((mago.getVida() - cartaEnemiga.getAtaque()) + mago.getDefensa());
							} else if (cartaElegida == 0 && cartaMala == 2) {
								mago.setVida((mago.getVida() - cartaEnemiga.getAtaque()) + mago.getDefensa());
							} else if (cartaElegida == 1 && cartaMala == 2) {
								cartaEnemiga.setVida((cartaEnemiga.getVida() - espada.getAtaque()) + cartaEnemiga.getDefensa());
							} else if (cartaElegida == 1 && cartaMala == 1) {
								cartaEnemiga.setVida((cartaEnemiga.getVida() - espada.getAtaque()) + cartaEnemiga.getDefensa());
								espada.setVida((espada.getVida() - cartaEnemiga.getAtaque()) + espada.getDefensa());
							} else if (cartaElegida == 1 && cartaMala == 0) {
								espada.setVida((espada.getVida() - cartaEnemiga.getAtaque()) + espada.getDefensa());
							} else if (cartaElegida == 2 && cartaMala == 0) {
								cartaEnemiga.setVida((cartaEnemiga.getVida() - dragon.getAtaque()) + cartaEnemiga.getDefensa());
							} else if (cartaElegida == 2 && cartaMala == 2) {
								cartaEnemiga.setVida((cartaEnemiga.getVida() - dragon.getAtaque()) + cartaEnemiga.getDefensa());
								dragon.setVida((dragon.getVida() - cartaEnemiga.getAtaque()) + dragon.getDefensa());
							} else if (cartaElegida == 2 && cartaMala == 1) {
								dragon.setVida((dragon.getVida() - cartaEnemiga.getAtaque()) + dragon.getDefensa());

							}


						}
					}

					if (cartaEnemiga.getVida() <= 0) {
						// LLAMAR A METODO DE INTERFAZ
				
						JOptionPane.showMessageDialog(null,"\nHAS DERROTADO A LA HABITACION  " + habitacion.getNumeroHabitacion() + "\n") ;
						seguirJugando = false;
						jugar = true;

					}

					else if((mago.getVida()<=0 || dragon.getVida()>0 || espada.getVida()>0)||(mago.getVida()<=0 || dragon.getVida()<=0 || espada.getVida()>0) || (mago.getVida()<=0 || dragon.getVida()>0 || espada.getVida()<=0) || (mago.getVida()>0 || dragon.getVida()>0 || espada.getVida()<=0) || (mago.getVida()>0 || dragon.getVida()<=0 || espada.getVida()>0) || (mago.getVida()>0 || dragon.getVida()>0 || espada.getVida()>0)){
						seguirJugando = true;
					}
					
					if (((mago.getVida()<=0 && dragon.getVida()<=0 && espada.getVida()<=0) || maesito.getVida() <= 0)){
						// LLAMAR A METODO DE INTERFAZ
						
						interfaz.perderGitGud();
						   
						   JOptionPane.showMessageDialog(null,"La carta Enemiga = " +infCartaEnemiga+ "\nAliados:\n "+ mago.toString(mago)+espada.toString(espada)+dragon.toString(dragon)) ;
						   quiereJugar = interfaz.opcionesIniciales();
						
						seguirJugando = false;
						jugar = false;
					}

					else if((mago.getVida()<= habitacion.getLetalidad() && dragon.getVida()<= habitacion.getLetalidad() && espada.getVida()<= habitacion.getLetalidad())){
						// LLAMAR A METODO DE INTERFAZ
						
						System.out.println("HAS PERDIDO :(");
						seguirJugando = false;
						jugar = false;
						interfaz.perderGitGud();
						JOptionPane.showMessageDialog(null,"La carta Enemiga = " +infCartaEnemiga+ "\nAliados:\n "+ mago.toString(mago)+espada.toString(espada)+dragon.toString(dragon)) ;
						quiereJugar = interfaz.opcionesIniciales();
						
					}



				} else if (queHacer == 2) {
					maesito.setVida(1.0);
	            	mago.setVida(1.0);
	            	espada.setVida(1.0);
	            	dragon.setVida(1.0);
	            	habitacion.setNumeroHabitacion(0);
	            	habitacion.setNivelAgua(0.0);
	            	habitacion.setLetalidad(0.2);
	            	maesito.setMovimientos(0);
					quiereJugar = interfaz.opcionesIniciales();
					
					seguirJugando = false;
					jugar = false;
					

				} else if (queHacer == 1) {
					
					JOptionPane.showMessageDialog(null,resultados.registro(stats)) ;
				}

            }
        }
        else if(quiereJugar == 1){
          jugar = false;
          seguirJugando = false;
          quiereJugar = interfaz.opcionesIniciales();
          
        }
      
      }
      
      return jugar;

    }
    
   

}

