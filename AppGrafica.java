import javax.swing.JOptionPane;

public class AppGrafica{
    private  int cartaMala = 0;
    private Cartas mago;
    private boolean puerta;
    private Cartas espada;
    private Cartas dragon;
    private Cartas cartaEnemiga;
    private Resultados resultados = new Resultados();
    private InterfazGrafica interfaz = new InterfazGrafica();
    private Habitacion habitacion = new Habitacion();
    private Jugador maesito = new Jugador();
    private Object Cartas;  
    private String registroStatsApp = "";
    private String registroHistorico="";
    private String record = "";
private String k = "";
    public void ejecutar(){

        boolean salirDelJuego = false;
        mago = new Cartas();
        espada = new Cartas();
        dragon = new Cartas();
        registroStatsApp += resultados.registroMago(mago.getVida(), mago.getAtaque(), mago.getDefensa());
        registroStatsApp += resultados.registroEspada(espada.getVida(), espada.getAtaque(), espada.getDefensa());
        registroStatsApp += resultados.registroDragon(dragon.getVida(), dragon.getAtaque(), dragon.getDefensa());

        boolean jugar = true;
        boolean seguirJugando = false;
        String nombre = interfaz.pedirNombre();
        maesito.setNombre(nombre);
        int quiereJugar = interfaz.opcionesIniciales();

        while(jugar == true  ){

            if(quiereJugar == 1){

                cartaMala = interfaz.randomCartas();
                cartaEnemiga = new Cartas();
                habitacion.setNivelAgua(0.0);
                habitacion.cambiarNumeroHabitacion(true);
                if(habitacion.getNumeroHabitacion() <= 3){
                    registroStatsApp+= resultados.registroEnemiga(habitacion.getNumeroHabitacion(), cartaMala, cartaEnemiga.getVida(), cartaEnemiga.getAtaque(), cartaEnemiga.getDefensa());

                }
                // PERDE

                habitacion.subirLetalidad();

                if(habitacion.getNumeroHabitacion() > 3){
                	
                	
                    puerta=true;
                    jugar = false;
                    seguirJugando = false;
                    // LLAMAR A METODO DE INTERFAZ
                    puerta = false;
                    interfaz.ganar();
                    interfaz.mostrarEstadisticasJugador(registroStatsApp);
                    mago.setDefensa(Math.random() *0.4000000000000001 + 0.1);
                    mago.setAtaque((Math.random()*4.0000000000000001+6)*0.1);
                    dragon.setDefensa(Math.random() *0.4000000000000001 + 0.1);
                    dragon.setAtaque((Math.random()*4.0000000000000001+6)*0.1);
                    espada.setDefensa(Math.random() *0.4000000000000001 + 0.1);
                    espada.setAtaque((Math.random()*4.0000000000000001+6)*0.1);
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
                    registroHistorico += stats;
                    resultados.registro(stats);
                    
        
                    int queHacer = interfaz.antesDeMover(stats);
                    if (queHacer == 0) {
                        if (habitacion.getNivelAgua() < 1.0 ) {
                            habitacion.subirAgua(habitacion.getLetalidad());
                        } else if (habitacion.getNivelAgua() >= 1.0) {
                            habitacion.setNivelAgua(1.0);
                        }
                        if (habitacion.getNivelAgua() == 1.0 || habitacion.getNivelAgua() >= 1.0  ) {
                            habitacion.setAgua(1.0);
                            maesito.setVida(maesito.getVida() - (maesito.getVida() * habitacion.getLetalidad()));
                        }

                        int cartaElegida = interfaz.eleccionDeCartas();

                        if(cartaElegida == 0 && mago.getVida() <=0){
                            interfaz.cartaMuerta();
                            seguirJugando = false;
                        }
                        else if(cartaElegida == 1 && espada.getVida() <=0){
                            interfaz.cartaMuerta();
                            seguirJugando = false;
                        }
                        else if(cartaElegida == 2 && dragon.getVida() <=0){
                            interfaz.cartaMuerta();
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
                            puerta = true;
                            registroStatsApp += habitacion.toString(puerta);
                            puerta = false;
                            interfaz.derrotaHabitacion(habitacion.getNumeroHabitacion());
                            seguirJugando = false;
                            jugar = true;

                        }

                        else if((mago.getVida()<=0 || dragon.getVida()>0 || espada.getVida()>0)||(mago.getVida()<=0 || dragon.getVida()<=0 || espada.getVida()>0) || (mago.getVida()<=0 || dragon.getVida()>0 || espada.getVida()<=0) || (mago.getVida()>0 || dragon.getVida()>0 || espada.getVida()<=0) || (mago.getVida()>0 || dragon.getVida()<=0 || espada.getVida()>0) || (mago.getVida()>0 || dragon.getVida()>0 || espada.getVida()>0)){
                            seguirJugando = true;
                        }

                        if (((mago.getVida()<=0 && dragon.getVida()<=0 && espada.getVida()<=0) || maesito.getVida() <= 0)){
                            // LLAMAR A METODO DE INTERFAZ
                            interfaz.perderGitGud();
                           
                            JOptionPane.showMessageDialog(null, registroStatsApp);
                            quiereJugar = interfaz.opcionesIniciales();

                            seguirJugando = false;
                            jugar = false;
                        }

                        else if((mago.getVida()<= habitacion.getLetalidad() && dragon.getVida()<= habitacion.getLetalidad() && espada.getVida()<= habitacion.getLetalidad())){
                            // LLAMAR A METODO DE INTERFAZ
                        	
                            interfaz.perderGitGud();
                            seguirJugando = false;
                            jugar = false;
                            JOptionPane.showMessageDialog(null, registroStatsApp);
                            quiereJugar = interfaz.opcionesIniciales();

                        }


                    } else if (queHacer == 2) {

                        JOptionPane.showMessageDialog(null, registroStatsApp);

                        maesito.setVida(1.0);
                        mago.setVida(1.0);
                        espada.setVida(1.0);
                        dragon.setVida(1.0);
                        habitacion.setNumeroHabitacion(0);
                        habitacion.setNivelAgua(0.0);
                        habitacion.setLetalidad(0.2);
                        maesito.setMovimientos(0);

                        quiereJugar = interfaz.opcionesIniciales();

                        if(quiereJugar ==2) {
                            jugar = false;
                            seguirJugando = false;
                        }

                    } else if (queHacer == 1) {
                        interfaz.registroJuego(registroHistorico);

                    }

                }
            }
            else if(quiereJugar == 2){
                jugar = false;
                seguirJugando = false;

            }else if (quiereJugar == 0) {
            	
            	resultados.verificarRecord(maesito.getNombre(), habitacion.getNumeroHabitacion(), maesito.getMovimientos(), maesito.getVida());
            	JOptionPane.showMessageDialog(null, resultados.getRecord());
            	
            	 quiereJugar = interfaz.opcionesIniciales();
            }

        }


    }


}

