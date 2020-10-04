
/**
 * Write a description of class AppGrafica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AppGrafica{
    private InterfazGrafica interfaz;
    private Habitacion tartarus;
    private Habitacion mementos;
    private Habitacion abyss;
    private Jugador player;
    private Cartas cartaEnemiga;
    private Cartas cartaJugador;
    private Resultados resultados;
    
    public AppGrafica(){
        interfaz = new InterfazGrafica();
        tartarus = new Habitacion();
        mementos = new Habitacion();
        abyss = new Habitacion();
        player = new Jugador();
        resultados = new Resultados();
    }
    private void conseguirCarta(int cartaElegida1){
        if(cartaElegida1 == 0){
            this.cartaJugador = player.getCartaMago();
        }
        if(cartaElegida1 ==1){
            this.cartaJugador = player.getCartaEspada();
        }
        if(cartaElegida1 == 2){
            this.cartaJugador = player.getCartaDragon();
        }
    }
    private void conseguirCartaHabitacion(int numeroHabitacion){
        if (numeroHabitacion == 1){
        this.cartaEnemiga = tartarus.getCartaEnemiga();
    }
        if (numeroHabitacion == 2){
        this.cartaEnemiga = mementos.getCartaEnemiga();
    }
        if (numeroHabitacion == 3){
        this.cartaEnemiga = abyss.getCartaEnemiga();
    }
}
    private void trianguloArmas(Cartas cartaEnemiga, Cartas cartaJugador, int numeroAtaques){
        double vida = 0.0;
        for(int i = 0; i < numeroAtaques; i++){
            if (cartaEnemiga.getTipo().equals(cartaJugador.getTipo()) && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque() + cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
            if (cartaEnemiga.getTipo().equals("MAGO") && cartaJugador.getTipo().equals("DRAGON") && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if (cartaEnemiga.getTipo().equals("ESPADA") && cartaJugador.getTipo().equals("MAGO") && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if (cartaEnemiga.getTipo().equals("DRAGON") && cartaJugador.getTipo().equals("ESPADA") && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if (cartaEnemiga.getTipo().equals("MAGO") && cartaJugador.getTipo().equals("ESPADA") && cartaJugador.getVida() > 0){
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque()+ cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
            if (cartaEnemiga.getTipo().equals("ESPADA") && cartaJugador.getTipo().equals("DRAGON") && cartaJugador.getVida() > 0){
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque()+ cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
            if (cartaEnemiga.getTipo().equals("DRAGON") && cartaJugador.getTipo().equals("MAGO") && cartaJugador.getVida() > 0){
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque()+ cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
        }
    }
    private void actualizarCartas(Cartas cartaElegida, Cartas cartaEnemiga, int cartaElegida1, int habitacionActual){
        if (cartaElegida1 == 0){
            player.setCartaMago(cartaElegida);
        }
        else if (cartaElegida1 == 1){
            player.setCartaEspada(cartaElegida);
        }
        else if (cartaElegida1 == 2){
           player.setCartaDragon(cartaElegida);
        }  
        if(habitacionActual == 1){
            tartarus.setCartaEnemiga(cartaEnemiga);
        }
        else if (habitacionActual ==2){
            mementos.setCartaEnemiga(cartaEnemiga);
        }
        else if (habitacionActual == 3){
            abyss.setCartaEnemiga(cartaEnemiga);
        }
    }
    private void secuenciaAtaques(int habitacionActual){
        int numeroAtaques = 0;
        int cartaElegida1 = 0;
        cartaElegida1 = interfaz.eleccionDeCartas();
        numeroAtaques = interfaz.cantidadAtaques();
        conseguirCarta(cartaElegida1);
        conseguirCartaHabitacion(habitacionActual);
        trianguloArmas(cartaJugador, cartaEnemiga, numeroAtaques);
        actualizarCartas(cartaJugador, cartaEnemiga, cartaElegida1, habitacionActual);
        player.agregarMovimiento();
        actualizarResultados(cartaJugador, cartaEnemiga, habitacionActual);
    }
    private void actualizarResultados(Cartas cartaJugador, Cartas cartaEnemiga, int habitacionActual){
        double letalidad = 0.0;
	double nivelAgua = 0.0;
        double vida = player.getVida();
	int movimiento = player.getMovimientos();
	String nombre = player.getNombre();
	int numeroHabitacion = habitacionActual;
	if (habitacionActual == 1){
	     letalidad = tartarus.getLetalidad();
}
        else if(habitacionActual ==2){
             letalidad = mementos.getLetalidad();
}
        else if(habitacionActual == 3){
            letalidad = abyss.getLetalidad();    
}
if (habitacionActual == 1){
	     nivelAgua = tartarus.getNivelAgua();
}
        else if(habitacionActual ==2){
             nivelAgua = mementos.getNivelAgua();
}
        else if(habitacionActual == 3){
            nivelAgua = abyss.getNivelAgua();    
}
resultados.actualizarResultados(vida,movimiento, nombre, habitacionActual, letalidad, nivelAgua, cartaEnemiga, cartaJugador);
}
    public void ejecutar(){
        boolean jugar = true;
        String nombre = "";
        int opcionInicial = 0;
        int habitacionActual = 1;
        int opcionesInGame = 0;
        String records = "";
        nombre = interfaz.pedirNombre();
        player.setNombre(nombre);
        opcionInicial = interfaz.opcionesIniciales();
        while (jugar == true){
            if(opcionInicial == 1){
                jugar = false;
                interfaz.abandona(opcionInicial);
            }
            else if (opcionInicial == 2){
            records = resultados.toString();
            opcionInicial = interfaz.records(records);
        }
            else if (opcionInicial == 0){
                opcionesInGame = interfaz.antesDeMover();
                if (opcionesInGame == 0){
                secuenciaAtaques(habitacionActual);
            }
                else if (opcionesInGame == 1){
                    records = resultados.registroHistorico();
                    opcionesInGame = interfaz.registroJuego(records);
                }
                else if (opcionesInGame == 2){
                    jugar = false;
                    interfaz.abandona(opcionesInGame);
                    jugar = interfaz.volverAJugar();
                }
            }
        }
    }
}


