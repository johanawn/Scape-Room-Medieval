
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
    
    public AppGrafica(){
        interfaz = new InterfazGrafica();
        tartarus = new Habitacion();
        mementos = new Habitacion();
        abyss = new Habitacion();
        player = new Jugador();
    }
    private Cartas conseguirCarta(int cartaElegida1){
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
    private Cartas conseguirCartaHabitacion(int numeroHabitacion){
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
    private Cartas trianguloArmas(Cartas cartaEnemiga, Cartas cartaElegida, int numeroAtaques){
        double vida = 0.0;
        for(int i = 0; i < numeroAtaques; i++){
            if (cartaEnemiga.getTipo() == cartaElegida.getTipo() && cartaElegida.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaElegida.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
                vida = cartaElegida.getVida() - cartaEnemiga.getAtaque() + cartaElegida.getDefensa();
                cartaElegida.setVida(vida);
            }
            if (cartaEnemiga.getTipo() == "MAGO" && cartaElegida.getTipo() == "DRAGON"){
                vida = cartaEnemiga.getVida() - cartaElegida.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if (cartaEnemiga.getTipo() == "ESPADA" && cartaElegida.getTipo() == "MAGO"){
                vida = cartaEnemiga.getVida() - cartaElegida.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if (cartaEnemiga.getTipo() == "DRAGON" && cartaElegida.getTipo() == "ESPADA"){
                vida = cartaEnemiga.getVida() - cartaElegida.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if (cartaEnemiga.getTipo() == "MAGO" && cartaElegida.getTipo() == "ESPADA"){
                vida = cartaElegida.getVida() - cartaEnemiga.getAtaque()+ cartaElegida.getDefensa();
                cartaElegida.setVida(vida);
            }
            if (cartaEnemiga.getTipo() == "ESPADA" && cartaElegida.getTipo() == "DRAGON"){
                vida = cartaElegida.getVida() - cartaEnemiga.getAtaque()+ cartaElegida.getDefensa();
                cartaElegida.setVida(vida);
            }
            if (cartaEnemiga.getTipo() == "DRAGON" && cartaElegida.getTipo() == "MAGO"){
                vida = cartaElegida.getVida() - cartaEnemiga.getAtaque()+ cartaElegida.getDefensa();
                cartaElegida.setVida(vida);
            }
        }
    }
    private Cartas actualizarCartas(Cartas cartaElegida, Cartas cartaEnemiga, int cartaElegida1, int habitacionActual){
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
    }
}

