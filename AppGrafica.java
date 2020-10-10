
/**
 * Descripción: la appGrafica es llamada desde la clase Main si el jugador le da como parametros "paneles" o no le da parametros. Esta clase es el cuerpo del juego con la interfaz JOptionPane.
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 *
 * @version 09/10/2020
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
    /**
     * Constructor de la clase appGrafica
     * Efectua: al iniciar crea la interfaz, las tres habitaciones del juego, a su vez les asigna su respectiva letalidad y su numero de habitacion, crea al jugador y una clase resultados para almacenar cambios que se vayan haciendo en los atributos de otras clases.
     * @see InterfazGrafica
     * @see Jugador
     * @see Cartas
     * @see Habitacion
     * @see Resultados
     */
    public AppGrafica(){
        //Tartarus, Mementos y Abyss son todos nombres de lugares hechos para mantener a personas encerradas.
        //Tartarus es de la mitología griega, un profundo abismo usado como una mazmorra de sufrimiento y una prisión para los titanes.
        //Mementos es una prisión ficticia que suele salir en el videjuego Persona.
        //Abyss es una locación del videojuego Dark Souls
        interfaz = new InterfazGrafica();
        tartarus = new Habitacion();
        tartarus.setLetalidad(0.2);
        tartarus.setNumeroHabitacion(1);
        mementos = new Habitacion();
        mementos.setLetalidad(0.25);
        mementos.setNumeroHabitacion(2);
        abyss = new Habitacion();
        abyss.setLetalidad(0.3);
        abyss.setNumeroHabitacion(3);
        player = new Jugador();
        resultados = new Resultados();
    }
    /**
     * Metodo conseguirCarta
     * Efectua: le devuelve a la app una copia exacta de la carta del jugador especificada y la coloca en su cartaJugador para relizar calculos.
     * @param cartaElegida1- el numero que corresponde a la carta que eligió el jugador.
     * Modifica: cartaJugador de la clase app, le transfiere los valores de la carta del jugador.
     */
    public void conseguirCarta(int cartaElegida1){
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
    /**
     * Metodo conseguirCartaHabitacion
     * Efectua: le devuelve a la app una copia exacta de la carta de la habitacion especificada y la coloca en su cartaEnemiga para relizar calculos.
     * @param numeroHabitacion - el numero que corresponde a la habitacion en la que se encuentra el jugador actualmente.
     * Modifica: cartaEnemiga de la clase app, le transfiere los valores de la carta secreta de la habitacion.
     */
    public void conseguirCartaHabitacion(int numeroHabitacion){
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
    /**
     * Metodo trianguloArmas
     * Efectua: con los atributos del ataque, defensa y tipo de las cartas realiza los calculos para afectar la vida de las cartas del jugador o de las habitaciones basados en el triangulo de afectación del enunciado de la tarea.
     * Triángulo de afectación - Mago > Espada/ Espada > Dragon/ Dragon > Mago / cartas del mismo tipo se afectan entre sí.
     * Requiere: dos objetos Cartas y una cantidad especifica de iteraciones.
     * @param cartaEnemiga - la carta de la appGrafica que contiene una copia de los atributos de la carta secreta de una habitacion.
     * @param cartaJugador - la carta de la appGrafica que contiene una copia de los atributos de la carta que el jugador eligió para ese movimiento.
     * @param numeroAtaques - la cantidad de veces que el jugador desea atacar con la carta que especificó.
     * Modifica: la vida de la cartaJugador o la cartaEnemiga dependiendo de su tipo según el triángulo de afectación.
     */
    public void trianguloArmas(Cartas cartaEnemiga, Cartas cartaJugador, int numeroAtaques){
        double vida = 0.0;
        for(int i = 0; i < numeroAtaques; i++){
            if ((cartaEnemiga.getTipo().equals(cartaJugador.getTipo())) && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque() + cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
            if ((cartaEnemiga.getTipo().equals("MAGO")) && (cartaJugador.getTipo().equals("DRAGON")) && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if ((cartaEnemiga.getTipo().equals("ESPADA")) && (cartaJugador.getTipo().equals("MAGO")) && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if ((cartaEnemiga.getTipo().equals("DRAGON")) && (cartaJugador.getTipo().equals("ESPADA")) && cartaJugador.getVida() > 0){
                vida = cartaEnemiga.getVida() - cartaJugador.getAtaque()+ cartaEnemiga.getDefensa();
                cartaEnemiga.setVida(vida);
            }
            if ((cartaEnemiga.getTipo().equals("MAGO")) && (cartaJugador.getTipo().equals("ESPADA")) && cartaJugador.getVida() > 0){
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque()+ cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
            if ((cartaEnemiga.getTipo().equals("ESPADA")) && (cartaJugador.getTipo().equals("DRAGON")) && cartaJugador.getVida() > 0){
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque()+ cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
            if ((cartaEnemiga.getTipo().equals("DRAGON")) && (cartaJugador.getTipo().equals("MAGO")) && cartaJugador.getVida() > 0){
                vida = cartaJugador.getVida() - cartaEnemiga.getAtaque()+ cartaJugador.getDefensa();
                cartaJugador.setVida(vida);
            }
        }
    }
    /**
     * Metodo actualizarCartas
     * Efectua: según la carta elegida por el jugador y la habitación en la que se encuentra dicho jugador, la vida de la carta del jugador y la vida de la carta secreta de la habitación son modificadas tomando en cuenta el triángulo de afectación. (Tomar en cuenta que no todo el tiempo la vida de una carta saldrá afectada).
     * Requiere: dos objetos Cartas, una especificación de la carta elegida por el jugador y la habitacion en la que se encuentra el jugador.
     * @param cartaJugador - la carta de la appGrafica que contiene una copia de los atributos de la carta que el jugador eligió para ese movimiento.
     * @param cartaEnemiga - la carta de la appGrafica que contiene una copia de los atributos de la carta secreta de una habitacion.
     * @param cartaElegida1- el numero que corresponde a la carta que eligió el jugador.
     * @param habitacionActual - el numero de la habitacion en la que se encuentra el jugador.
     * Modifica: la vida de una de las cartas del jugador o de la carta secreta de una habitacion o ambas.
     */
    public void actualizarCartas(Cartas cartaJugador, Cartas cartaEnemiga, int cartaElegida1, int habitacionActual){
        if (cartaElegida1 == 0){
            player.setCartaMago(cartaJugador);
        }
        else if (cartaElegida1 == 1){
            player.setCartaEspada(cartaJugador);
        }
        else if (cartaElegida1 == 2){
            player.setCartaDragon(cartaJugador);
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
    /**
     * Método secuenciaAtaques
     * Efectua: llama a la interfaz para pedirle al jugardor que elija una de las tres cartas a su dispoción, así como que indique la cantidad de ataques a realizar con dicha carta.
     * Llama a dos métodos para conseguir los atributos de la carta del jugador y la habitación para, posteriormente, realizar los cálculos de la afectación de la vida de las cartas.
     * Revisa si la carta del jugador todavía tiene vida, en caso de que no tenga, le manda un aviso al jugador.
     * Consigue la letalidad de la habitacion y el nivel de la agua de la habitación en la que se encuentra el jugador, en caso de que el nivel de agua sea igual o exceda el 100%, la vida del jugador se verá afectada por la letalidad de la habitación.
     * Posteriormente actualiza la carta del jugador y la carta secreta de la habitación que fue afectada y le agrega un movimiento al contador de movimientos del jugador.
     * @param habitacionActual - numero de la habitacion en la que se encuentra el jugador.
     * Modifica: la vida de una carta del jugador y de la carta secreta de la habitación especificada según sea el caso, la vida del jugador dependiendo del nivel de agua y la letalidad, así como el contador de movimientos del jugador.
     */
    public void secuenciaAtaques(int habitacionActual){
        int numeroAtaques = 0;
        int cartaElegida1 = 0;
        cartaElegida1 = interfaz.eleccionDeCartas();
        numeroAtaques = interfaz.cantidadAtaques();
        conseguirCarta(cartaElegida1);
        conseguirCartaHabitacion(habitacionActual);
        trianguloArmas(cartaEnemiga, cartaJugador, numeroAtaques);
        if (cartaJugador.getVida() <=0){
            interfaz.cartaMuerta();
        }
        double letalidad = conseguirLetalidad(habitacionActual);
        double nivelAgua = conseguirNivelAgua(habitacionActual);
        if(nivelAgua >= 1.0){
            double vida = player.getVida() - letalidad;
            player.setVida(vida);
        }
        actualizarCartas(cartaJugador, cartaEnemiga, cartaElegida1, habitacionActual);
        player.agregarMovimiento();

    }
    /**
     * Método actualizarResultados
     * Efectua: actualiza la vida de las cartas del jugador y de las habitaciones, la letalidad, el nivel de agua,el nombre y la vida del jugador, la habitación donde se encuentra y los movimientos efectuados hasta el momento dentro de la clase resultados.
     * @param habitacionActual - el numero de la habitación en la que se encuentra el jugador.
     * @param mago - la información de la carta Mago del jugador.
     * @param espada - la información de la carta Espada del jugador.
     * @param - la información de la carta Dragón del jugador.
     * Modifica: los datos almacenados en la clase resultados sobre la partida.
     */
    public void actualizarResultados(int habitacionActual,String mago, String espada, String dragon){
        double letalidad = 0.0;
        double nivelAgua = 0.0;
        if (habitacionActual==1){
            letalidad = tartarus.getLetalidad();
            nivelAgua = tartarus.getNivelAgua();
        }
        if (habitacionActual==2){
            letalidad = mementos.getLetalidad();
            nivelAgua = mementos.getNivelAgua();
        }
        if (habitacionActual==3){
            letalidad = abyss.getLetalidad();
            nivelAgua = abyss.getNivelAgua();
        }
        double vida = player.getVida();
        int movimiento = player.getMovimientos();
        String nombre = player.getNombre();
        int numeroHabitacion = habitacionActual;
        resultados.actualizarResultados(vida, movimiento, nombre, numeroHabitacion, letalidad, nivelAgua,dragon,mago,espada);
    }
    /**
     * Método subirNivelAgua
     * Efectua: sube el nivel de agua de la habitación especificada según el número de la habitación en la que se encuentra el jugador.(Sube según la letalidad de cada habitación).
     * @param habitacionActual - el número de la habitación en la que se encuentra el jugador.
     * Modifica: el nivel de agua de una habitación.
     */
    public void subirNivelAgua(int habitacionActual){
        double letalidad = conseguirLetalidad(habitacionActual);
        if (habitacionActual==1){
            tartarus.subirNivelAgua(letalidad);
        }
        if (habitacionActual==2){
            mementos.subirNivelAgua(letalidad);
        }
        if (habitacionActual==3){
            abyss.subirNivelAgua(letalidad);
        }
    }
    /**
     * Método duranteJuego
     * Efectua: obtiene los datos de cada una de las cartas del jugador (Mago, Espada, Dragon).
     * Actualiza los resultados dentro de la clase resultados por medio de otro método - @see Método actualizarResultados.
     * Llama a la clase resultados para obtener la información más reciente de la partida después de la actualización.
     * @param habitacionActual - el numero de la habitación en la que se encuentra el jugador.
     * @return juego - hilera con los datos más recientes de la partida para el jugador.
     * Modifica: datos en clase resultados sobre la partida durante el juego.
     */
    public String duranteJuego(int habitacionActual){
        cartaJugador = player.getCartaMago();
        String vidaMago = " "+(int)(cartaJugador.getVida()*100)+"%";
        cartaJugador = player.getCartaEspada();
        String vidaEspada = " "+(int)(cartaJugador.getVida()*100)+"%";
        cartaJugador = player.getCartaDragon();
        String vidaDragon = " "+(int)(cartaJugador.getVida()*100)+"%";
        actualizarResultados(habitacionActual,vidaMago,vidaEspada,vidaDragon);
        String juego = resultados.toStringEnJuego();
        return juego;
    }
    /**
     * Método record
     * Efectua: comparación del record del nuevo jugador con el mejor record hasta el momento, actaliza el record en la clase resultados en caso de que el nuevo sea mejor.
     * @param habitacionActual - numero de la habitación en la que quedó el jugador antes de peder o cuando ganó.
     * @param gano - indica si el jugador llegó a la última habitación y ganó o no.
     * @return record - hilera con la información del mejor record hasta el momento.
     * Modifica: los datos de la clase resultados en el apartado de record.
     */
    public String record(int habitacionActual, boolean gano){
        String record;
        int movimientos = player.getMovimientos();
        double vida = player.getVida();
        String nombre = player.getNombre();
        int habitacion = habitacionActual;
        record = resultados.compararHabitacion(nombre, habitacion, movimientos, vida, gano);
        return record;
    }
    /**
     * Método conseguirLetalidad
     * Efectua: consigue la letalidad de la habitación en la que se encuntra el jugador.
     * @param habitacionActual - el número de la habitación en la que se encuentra el jugador.
     * @return letalidad - la letalidad de la habitación especificada.
     */
    public double conseguirLetalidad(int habitacionActual){
        double letalidad = 0.0;
        if (habitacionActual==1){
            letalidad = tartarus.getLetalidad();
        }
        if (habitacionActual==2){
            letalidad = mementos.getLetalidad();
        }
        if (habitacionActual==3){
            letalidad = abyss.getLetalidad();
        }
        return letalidad;
    }
    /**
     * Método conseguirNivelAgua
     * Efectua: consigue el nivel de agua de la habitación en la que se encuntra el jugador.
     * @param habitacionActual - el número de la habitación en la que se encuentra el jugador.
     * @return nivelAgua - el nivel de agua de la habitación especificada.
     */
    public double conseguirNivelAgua(int habitacionActual){
        double nivelAgua = 0.0;
        if (habitacionActual==1){
            nivelAgua = tartarus.getNivelAgua();
        }
        if (habitacionActual==2){
            nivelAgua = mementos.getNivelAgua();
        }
        if (habitacionActual==3){
            nivelAgua = abyss.getNivelAgua();
        }
        return nivelAgua;
    }
    /**
     * Método conseguirResultadoFinal
     * Efectua: consigue los datos finales de la partida una vez terminada, del jugador, las cartas tanto del jugador como de las habitaciones y el estado de las habitaciones.
     * Le muestra al jugador sus resultados finales.
     */
    public void conseguirResultadoFinal(){
        String jugador = player.toString();
        cartaJugador = player.getCartaMago();
        String mago = "MAGO: "+ cartaJugador.toStringFinal();
        cartaJugador = player.getCartaEspada();
        String espada = "ESPADA: "+cartaJugador.toStringFinal();
        cartaJugador = player.getCartaDragon();
        String dragon = "DRAGON: "+cartaJugador.toStringFinal();
        String habitacion = tartarus.toString()+"\n"+mementos.toString()+"\n"+abyss.toString();
        interfaz.mostrarResultadoFinal(jugador, mago, espada, dragon, habitacion);
    }
    /**
     * Método condicionesPerder
     * Efectua: verifica si el jugador cumple alguna de las condiciones para perder el juego, consigue la información de las cartas y del jugador para asegurarse de que estén en condiciones de avanzar.
     * @param habitacionActual - el numero de la habitación en la que se encuentra el jugador.
     * @param cartaJugador - la carta de la appGrafica dedicada a conseguir la informaión de las cartas del jugador.
     * @return seguirJugando - le indica al programa si el jugador puede seguir jugando o si perdió.
     * Modifica: el estado del juego en el caso de que el jugador pierda.
     */
    public boolean condicionesPerder(int habitacionActual, Cartas cartaJugador){
        boolean seguirJugando = true;
        double letalidad = conseguirLetalidad(habitacionActual);
        double vidaMago = 0.0;
        double vidaEspada = 0.0;
        double vidaDragon = 0.0;
        cartaJugador = player.getCartaMago();
        vidaMago = cartaJugador.getVida();
        cartaJugador = player.getCartaEspada();
        vidaEspada = cartaJugador.getVida();
        cartaJugador = player.getCartaDragon();
        vidaDragon = cartaJugador.getVida();
        if((player.getVida() <= 0)||(vidaMago < letalidad && vidaEspada < letalidad && vidaDragon < letalidad)){
            interfaz.perderGitGud();
            conseguirResultadoFinal();
            seguirJugando = false;
        }
        return seguirJugando;
    }
    /**
     * Método volverJugar
     * Efectua: en el caso de que el jugador quiera jugar de nuevo, resetea el juego para empezar de 0.
     * @param registro - hilera dedicada a mostrarle a los jugadores que pasen por el juego la información de sus partidas.
     * @return registro - reinicia el registro de jugadas para el siguiente jugador.
     * Modifica: el registro histórico del juego.
     */
    public String volverJugar(String registro){
        player = new Jugador();
        tartarus = new Habitacion();
        tartarus.setLetalidad(0.2);
        tartarus.setNumeroHabitacion(1);
        mementos = new Habitacion();
        mementos.setLetalidad(0.25);
        mementos.setNumeroHabitacion(2);
        abyss = new Habitacion();
        abyss.setLetalidad(0.3);
        abyss.setNumeroHabitacion(3);
        registro = "No hay registro";
        return registro;
    }
    /**
     * Método ejecutar
     * Efectua: el cuerpo principal de todo el juego, por medio de la interfaz grafica interactua con el jugador para el avance del juego.
     * Requiere: métodos antes explicados.
     * Modifica: la mayoría de los atributos de las clases que están ligadas a él durante el avance del juego.
     */
    public void ejecutar(){
        //Inicialización de variables necesarias para correr el código.
        boolean jugar = true;
        boolean seguirJugando = true;
        boolean puertaAbierta = false;
        String nombre = "";
        int opcionInicial = 0;
        int habitacionActual = 1;
        int opcionesInGame = 0;
        String registro = "No hay registro";
        String records = "No hay records";
        boolean jugarDeNuevo = false;
        boolean gano = false;
        //Comienzo de interacción con el usuario.
        nombre = interfaz.pedirNombre();
        player.setNombre(nombre);
        opcionInicial = interfaz.opcionesIniciales();
        //Se asume que el usuario desea jugar.
        while (jugar == true){
            //Con la opción 1(en la interfazGrafica es "SALIR DEL JUEGO") el usuario sale definitivamente de la aplicación.
            if(opcionInicial == 1){
                jugar = false;
                interfaz.abandona(opcionInicial);
                jugar = interfaz.volverAJugar();
                //Si al preguntarle que si desea jugar otra vez, responde afirmativamente, los objetos se reinician y se le vuelve a preguntar qué desea hacer.
                if(jugar == true){
                    registro = volverJugar(registro);
                    nombre = interfaz.pedirNombre();
                    player.setNombre(nombre);
                    opcionInicial = interfaz.opcionesIniciales();
                    habitacionActual = 1;
                }
            }
            //En caso de que su elección sea la opción 2 ("HIGHEST SCORE" en la interfaz) se le muestra el mejor record hasta el momento si hay.
            else if (opcionInicial == 2){
                interfaz.records(records);
                opcionInicial = interfaz.opcionesIniciales();
            }
            //Si su eleción es 0 ("EMPEZAR EL JUEGO" en la interfaz) entra a la primera habitación y otro menú se activa.
            else if (opcionInicial == 0){
                while (opcionInicial == 0){
                    opcionesInGame = interfaz.antesDeMover(duranteJuego(habitacionActual));
                    //Si su elección es 0 en el segundo menú ("HACER MOVIMIENTO" en la interfaz)comienza la secuencia de los ataques.
                    if (opcionesInGame == 0){
                        secuenciaAtaques(habitacionActual);
                        registro = "";
                        registro += duranteJuego(habitacionActual)+"\n";
                        subirNivelAgua(habitacionActual);
                        if(cartaEnemiga.getVida() <= 0){
                            if (habitacionActual==1){
                                tartarus.abrirPuerta();
                                puertaAbierta = true;
                            }
                            if (habitacionActual==2){
                                mementos.abrirPuerta();
                                puertaAbierta = true;
                            }
                            if (habitacionActual==3){
                                abyss.abrirPuerta();
                                puertaAbierta = true;
                            }
                        }
                        //Verificaión de condiciones para perder.
                        seguirJugando = condicionesPerder(habitacionActual,cartaJugador);
                        if(seguirJugando == false){
                            opcionInicial = 3;
                            jugar = false;
                            puertaAbierta = false;
                            records = record( habitacionActual, gano);
                            jugar = interfaz.volverAJugar();
                            if(jugar == true){
                                registro = volverJugar(registro);
                                nombre = interfaz.pedirNombre();
                                player.setNombre(nombre);
                                opcionInicial = interfaz.opcionesIniciales();
                                habitacionActual = 1;
                            }
                        }
                        //Cambio de habitación.
                        if(puertaAbierta == true){
                            interfaz.derrotaHabitacion(habitacionActual);
                            habitacionActual++;
                            if (habitacionActual==2){
                                puertaAbierta = false;
                            }
                            if (habitacionActual==3){
                                puertaAbierta = false;
                            }
                            //Si la habitación es la 4, significa que salió.
                            if(habitacionActual == 4){
                                interfaz.ganar();
                                gano = true;
                                records = record( habitacionActual, gano);
                                conseguirResultadoFinal();
                                jugar = false;
                                opcionInicial = 3;
                                jugar = interfaz.volverAJugar();
                                //Si quiere jugar otra vez se resetea lo necesario.
                                if(jugar == true){
                                    registro = volverJugar(registro);
                                    nombre = interfaz.pedirNombre();
                                    player.setNombre(nombre);
                                    opcionInicial = interfaz.opcionesIniciales();
                                    habitacionActual = 1;
                                }
                            }
                        }
                    }
                    //Si el jugador elige 1 en el segundo menú ("REGSITRO DE JUEGO" en la interfaz) se le enseña la información de sus jugadas hasta el momento.
                    else if (opcionesInGame == 1){
                        interfaz.registroJuego(registro);
                    }
                    //Si el jugador elige 2 en el segundo menú ("ABANDONAR JUEGO" en la interfaz) se sale de su partida, pierde y se le pregunta si desea jugar otra vez.
                    else if (opcionesInGame == 2){
                        opcionInicial = 3;
                        jugar = false;
                        interfaz.abandona(opcionesInGame);
                        records = record( habitacionActual, gano);
                        jugar = interfaz.volverAJugar();
                        //En caso de querer jugar otra vez, se resetea lo neceesario.
                        if(jugar == true){
                            registro = volverJugar(registro);
                            nombre = interfaz.pedirNombre();
                            player.setNombre(nombre);
                            opcionInicial = interfaz.opcionesIniciales();
                            habitacionActual = 1;
                        }
                    }
                }
            }
        }
    }
}
=======



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


>>>>>>> f363c755a542cb1061f53e959e6b220f0c835d18
