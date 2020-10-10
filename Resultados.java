
/**
 *Resultados
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 *
 * @version 09/10/2020
 */
public class Resultados {
    private double vida = 0.0;
    private int movimiento = 0;
    private String nombre;
    private int numeroHabitacion = 0;
    private String record;
    private double letalidad;
    private double nivelAgua;
    private String vidaMago;
    private String vidaDragon;
    private String vidaEspada;
    private double vidaRecord= 0.0;
    private int movimientoRecord = 0;
    private String nombreRecord = "";
    private int numeroHabitacionRecord = 0;
    private boolean gano = false;
    public String registro = "";
    public String historial = "";
    /**
     * Efectua : el método toStringFinal, muestra un mensaje que contiene los valores de los parámetros
     * @param  nombre - nombre del jugador
     * @param  vidaJugador - vida del jugador
     * @param  vidaMago -vida del mago
     * @param  vidaEspada - vida de la espada
     * @param  vidaDragon - vida del dragon
     * @param  numeroHabitacion - número de la habitación
     * @param  numeroMovimientos - número de movimientos efectuados por el jugador
     * @param  nivelAgua - nivel del agua de la habitación
     * @param  letalidad - letalidad de la habitación
     * @return String - mensaje: "\nNOMBRE: "+nombre+"\nVIDA: "+ vidaJugador*100 + "%\n"+"\nVIDA MAGO: "+ vidaMago*100+"%" + "\nVIDA ESPADA: "+ vidaEspada*100+"%" + "\nVIDA DRAGON: "+ vidaDragon*100+"%"+ "\n"+"\nNUMERO HABITACION: "+numeroHabitacion+ "\nNUMERO DE MOVIMIENTOS: "+numeroMovimientos+ "\nNIVEL AGUA:"+ nivelAgua*100+"%" + "\nLETALIDAD: "+letalidad*100+"%"+"\n"
     */
    public String toStringStats( String nombre, double vidaJugador, double vidaMago, double vidaEspada, double vidaDragon, int numeroHabitacion, int numeroMovimientos, double nivelAgua, double letalidad){
        return "\nNOMBRE: "+nombre+"\nVIDA: "+ vidaJugador*100 + "%\n"+"\nVIDA MAGO: "+ vidaMago*100+"%" + "\nVIDA ESPADA: "+ vidaEspada*100+"%" + "\nVIDA DRAGON: "+ vidaDragon*100+"%"+ "\n"+"\nNUMERO HABITACION: "+numeroHabitacion+ "\nNUMERO DE MOVIMIENTOS: "+numeroMovimientos+ "\nNIVEL AGUA:"+ nivelAgua*100+"%" + "\nLETALIDAD: "+letalidad*100+"%"+"\n";
    }

    /**
     * Efectua : el método registroCartasJugador, contiene el variable String registrosStats que va acumulando información que contiene los parámetros
     * @param  vidaMago - vida de mago
     * @param  ataqueMago - ataque de mago
     * @param  defensaMago - defensa de magp
     * @param  vidaEspada - vida de la espada
     * @param  ataqueEspada - ataque de la espada
     * @param  defensaEspada - defensa de la espada
     * @param  vidaDragon - vida del dragon
     * @param  ataqueDragon - ataque del dragon
     * @param  defensaDragon - defensa del dragon
     * @return String registroStats - mensaje
     */

    public String registroCartasJugador(double vidaMago, double ataqueMago, double defensaMago,double vidaEspada, double ataqueEspada, double defensaEspada,double vidaDragon, double ataqueDragon, double defensaDragon){
        String registroStats = "\nVIDA MAGO: "+ vidaMago*100+"%" + " | ATAQUE MAGO: " + ataqueMago*100+"%"+ " | DEFENSA MAGO: " + defensaMago*100+"%" ;
        registroStats += "\nVIDA ESPADA: "+ vidaEspada*100+"%" + " | ATAQUE ESPADA: " + ataqueEspada*100+"%"+ " | DEFENSA ESPADA: " + defensaEspada*100+"%" ;
        registroStats += "\nVIDA DRAGON: "+ vidaDragon*100+"%" + " | ATAQUE DRAGON: " + ataqueDragon*100+"%"+ " | DEFENSA DRAGON: " + defensaDragon*100+"%" ;
        return registroStats;
    }

    /**
     * Efectua : el método toStringregistroHistorico, contiene el variable String representacion que va acumulando información de las variables numeroHabitacion, nivelAgua, vida, vidaMago, vidaEspada y vidaDragon de la clase Resultados
     *
     * @return String representación - mensaje
     */

    public String toStringregistroHistorico() {
        String representacion = "";

        representacion += "-HABITACION: "+ numeroHabitacion + " -LETALIDAD: "+ letalidad+" -NIVEL DE AGUA: "+nivelAgua+"\nMOVIMIENTOS EFECTUADOS: "+vida+"\nVIDA DE SUS CARTAS: -MAGO: "+vidaMago+"% -ESPADA: "+vidaEspada+"% -DRAGON: "+vidaDragon+"%";

        return representacion;
    }

    /**
     * Efectua : el método toStringEnJuego, contiene el variable String estadísticas que contiene la información de las variables numeroHabitacion, letalidad, nivelAgua, vida, movimiento, vidaMago, vidaEspada y vidaDragon de la clase Resultados
     *
     * @return String estadisticas - mensaje:"HABITACION: "+numeroHabitacion+" LETALIDAD: "+(int)(letalidad*100)+"%"+" NIVEL DEL AGUA: "+(int)(nivelAgua*100)+" MOVIMIENTOS: "+movimiento+" VIDA JUGADOR: "+(int)(vida*100)+"VIDA MAGO: "+vidaMago+" VIDA ESPADA: "+vidaEspada+" VIDA DRAGON: "+vidaDragon
     */

    public String toStringEnJuego(){
        String estadisticas = "HABITACION: "+numeroHabitacion+" LETALIDAD: "+(int)(letalidad*100)+"%"+" NIVEL DEL AGUA: "+(int)(nivelAgua*100)+" MOVIMIENTOS: "+movimiento+" VIDA JUGADOR: "+(int)(vida*100)+"VIDA MAGO: "+vidaMago+" VIDA ESPADA: "+vidaEspada+" VIDA DRAGON: "+vidaDragon;
        return estadisticas;
    }

    /**
     * Efectua : el método actualizarResultados, modifica con sets el nivelAgua, nombre, movimiento, numeroHabitacion, vida, letalidad, dragon, mago y espada de la clase Resultados.
     * @param  vida - vida de jugador
     * @param  movimiento - movimiento del jugador
     * @param  nombre -nombre del jugador
     * @param  numeroHabitacion - número de habitación
     * @param  letalidad - letalidad de la habitación
     * @param  nivelAgua - nivel de agua de la habitación
     * @param  dragon - carta dragon
     * @param  mago - carta mago
     * @param  espada - carta espada
     * Modifica : nivelAgua, nombre, movimeinto, numeroHabitacion, vida, letalidad, dragon, mago y espada por los valores de los parametros
     */

    public void actualizarResultados(double vida, int movimiento, String nombre, int numeroHabitacion, double letalidad, double nivelAgua,String dragon, String mago, String espada) {
        setNivelAgua(nivelAgua);
        setNombre(nombre);
        setMovimiento(movimiento);
        setNumeroHabitacion(numeroHabitacion);
        setVida(vida);
        setLetalidad(letalidad);
        setVidaDragon(dragon);
        setVidaMago(mago);
        setVidaEspada(espada);
    }

    /**
     * Efectua : el método compararHabitacion, tiene la variable record1 que contiene la información de los atributos el nombreRecord, gano, vidaRecord, movimientoRecord y numeroHabitacionRecord de la clase Resultados que son modificados dependiendo de las condiciones establecidas
     * @param  nombre - nombre del jugador
     * @param  distanciaNuevo - numero de Habitación
     * @paran  movimientoNuevo - movimiento
     * @param  vidaNuevo - vida del jugador
     * @param  gano - indica si el jugador ganó la partida
     * @return String record1- mensaje
     * Modifica : el nombreRecord, gano, vidaRecord, movimientoRecord y numeroHabitacionRecord de la clase Resultados por los valores de los parámetros
     */

    public String compararHabitacion(String nombre, int distanciaNuevo, int movimientoNuevo, double vidaNuevo, boolean gano) {
        String record1 ="";
        record1 = " Nombre " +this.nombreRecord +" Vida: "+ (int)(this.vidaRecord*100) + " Cantidad de Movimientos: "+this.movimientoRecord + " Habitacion: "+this.numeroHabitacionRecord;

        if(this.numeroHabitacionRecord ==  distanciaNuevo && this.movimientoRecord == movimientoNuevo && this.vidaRecord == vidaNuevo && this.gano == gano ) {
            record1 = " Nombre "+this.nombreRecord+"Vida: "+ (int)(this.vidaRecord*100) + " Cantidad de Movimientos: "+this.movimientoRecord + " Habitacion: "+this.numeroHabitacionRecord;
            this.record = record1;

        }
        else if(this.numeroHabitacionRecord == distanciaNuevo && gano == true  ) {

            this.record = record1;
            this.vidaRecord = vidaNuevo;
            this.movimientoRecord = movimientoNuevo;
            this.nombreRecord = nombre;
            this.gano = gano;
            this.numeroHabitacionRecord = distanciaNuevo;
            if(distanciaNuevo == 4){
                distanciaNuevo = 3;
            }
            record1 = " Nombre "+nombre+" Vida: "+ (int)(vidaNuevo*100) + " Cantidad de Movimientos: "+movimientoNuevo + " Habitacion: "+distanciaNuevo;
        }
        else if(this.numeroHabitacionRecord < distanciaNuevo) {

            this.record = record1;
            this.vidaRecord = vidaNuevo;
            this.movimientoRecord = movimientoNuevo;
            this.nombreRecord = nombre;
            this.gano = gano;
            this.numeroHabitacionRecord = distanciaNuevo;
            if(distanciaNuevo == 4){
                distanciaNuevo = 3;
            }
            record1 = " Nombre "+nombre+" Vida: "+ (int)(vidaNuevo*100) + " Cantidad de Movimientos: "+movimientoNuevo + " Habitacion: "+distanciaNuevo;
        }
        else if(this.numeroHabitacionRecord ==  distanciaNuevo && this.movimientoRecord > movimientoNuevo ) {


            this.record = record1;
            this.vidaRecord = vidaNuevo;
            this.movimientoRecord = movimientoNuevo;
            this.nombreRecord = nombre;
            this.gano = gano;
            this.numeroHabitacionRecord = distanciaNuevo;
            if(distanciaNuevo == 4){
                distanciaNuevo = 3;
            }
            record1 = " Nombre "+nombre+" Vida: "+ (int)(vidaNuevo*100) + " Cantidad de Movimientos: "+movimientoNuevo + " Habitacion: "+distanciaNuevo;
        }

        else if(this.numeroHabitacionRecord == distanciaNuevo && this.movimientoRecord == movimientoNuevo && this.vidaRecord < vidaNuevo  ) {

            this.record = record1;
            this.vidaRecord = vidaNuevo;
            this.movimientoRecord = movimientoNuevo;
            this.nombreRecord = nombre;
            this.gano = gano;
            this.numeroHabitacionRecord = distanciaNuevo;
            if(distanciaNuevo == 4){
                distanciaNuevo = 3;
            }
            record1 = " Nombre "+nombre+" Vida: "+ (int)(vidaNuevo*100) + " Cantidad de Movimientos: "+movimientoNuevo + " Habitacion: "+distanciaNuevo;
        }

        return record1;
    }
    /**
     * Efectua : el método registrocartasHabitacion, tiene las variables String registroStatsEnemigo que dependiendo de tipo1, tipo2 y tipo3 contendrá el String de la variable habitacion1, habitacion2 o habitacion3 que contiene los valores de los paramétros
     * @param  vida1 - vida de la carta enemiga
     * @param  ataque1 - ataque de la carta enemiga
     * @param  defensa1 - defensa de la carta enemiga
     * @param  vida2 - vida de la carta enemiga
     * @param  ataque2 - ataque de la carta enemiga
     * @param  defensa2 - defensa de la carta enemiga
     * @param  vida3 - vida de la carta enemiga
     * @param  ataque3 - ataque de la carta enemiga
     * @param  defensa3 -defensa de la carta enemiga
     * @param  tipo1 - tipo de la carta enemiga
     * @param  tipo2 - tipo de la carta enemiga
     * @param  tipo3 -tipo de la carta enemiga
     * @return String registroStatsEnemigo
     */
    public String registrocartasHabitacion(double vida1, double ataque1, double defensa1, double vida2, double ataque2, double defensa2, double vida3, double ataque3, double defensa3, int tipo1, int tipo2, int tipo3){
        String habitacion1 = "";
        String habitacion2 ="";
        String habitacion3 ="";
        String registroStatsEnemigo = "";
        if(tipo1 == 0) {
            habitacion1 = "\nNUMERO DE HABITACION: 1 | TIPO DE CARTA: MAGO" + " | VIDA: " + vida1*100 + " | ATAQUE: " + ataque1*100 + " | DEFENSA: " + defensa1*100+"%";
        }
        else if(tipo1 == 1){
            habitacion1 = "\nNUMERO DE HABITACION: 1 | TIPO DE CARTA: ESPADA" + " | VIDA: " + vida1*100 + " | ATAQUE: " + ataque1*100 + " | DEFENSA: " + defensa1*100+"%";
        }
        else{
            habitacion1 = "\nNUMERO DE HABITACION: 1 | TIPO DE CARTA: DRAGON" + " | VIDA: " + vida1*100 + " | ATAQUE: " + ataque1*100 + " | DEFENSA: " + defensa1*100+"%";
        }

        if(tipo2 == 0) {
            habitacion2 = "\nNUMERO DE HABITACION: 2 | TIPO DE CARTA: MAGO" + " | VIDA: " + vida2*100 + " | ATAQUE: " + ataque2*100+ " | DEFENSA: " + defensa2*100+"%";
        }
        else if(tipo2 == 1){
            habitacion2 = "\nNUMERO DE HABITACION: 2 | TIPO DE CARTA: ESPADA" + " | VIDA: " + vida2*100 + " | ATAQUE: " + ataque2*100 + " | DEFENSA: " + defensa2*100+"%";
        }
        else{
            habitacion2 = "\nNUMERO DE HABITACION: 2 | TIPO DE CARTA: DRAGON" + " | VIDA: " + vida2*100 + "% | ATAQUE: " + ataque2*100 + "% | DEFENSA: " + defensa2*100+"%";
        }

        if(tipo3 == 0) {
            habitacion3 = "\nNUMERO DE HABITACION: 3 | TIPO DE CARTA: MAGO" + " | VIDA: " + vida3*100 + "% | ATAQUE: " + ataque3*100 + "% | DEFENSA: " + defensa3*100+"%\n";
        }
        else if(tipo3 == 1){
            habitacion3 = "\nNUMERO DE HABITACION: 3 | TIPO DE CARTA: ESPADA" + " | VIDA: " + vida3*100 + "% | ATAQUE: " + ataque3*100 + "% | DEFENSA: " + defensa3*100+"%\n";
        }
        else{
            habitacion3 = "\nNUMERO DE HABITACION: 3 | TIPO DE CARTA: DRAGON" + " | VIDA: " + vida3*100 + "% | ATAQUE: " + ataque3*100 + "% | DEFENSA: " + defensa3*100+"%\n";
        }
        registroStatsEnemigo = ""+ habitacion1 +habitacion2+habitacion3;
        return registroStatsEnemigo;
    }

    /**
     * Efectua : el método resultadosHabitacionesPerder, contiene la variable String resultado que contendrá la información de las 3 habitaciones junto a los parámetros ingresados
     * @param   nivelAguaHab1- nivel del agua de la habitación 1
     * @param  nivelAguaHab2- nivel del agua de la habitación 2
     * @param  nivelAguaHab3 -nivel del agua de la habitación 3
     * @return String resultados-mensaje "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20%\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25%\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% "
     */
    public String resultadosHabitacionesPerder(double nivelAguaHab1,double nivelAguaHab2,double nivelAguaHab3){
        String resultado = "";
        resultado = "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20%\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25%\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% ";
        return resultado;
    }
    /**
     * Efectua : el método resultadosHabitacionesPerder1, contiene la variable String resultado que contendrá la información de las 3 habitaciones junto a los parámetros ingresados
     * @param   nivelAguaHab1- nivel del agua de la habitación 1
     * @param  nivelAguaHab2- nivel del agua de la habitación 2
     * @param  nivelAguaHab3 -nivel del agua de la habitación 3
     * @return String resultados-mensaje "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20%\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25%\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% "
     */
    public String resultadosHabitacionesPerder1(double nivelAguaHab1,double nivelAguaHab2,double nivelAguaHab3){
        String resultado = "";
        resultado = "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20% | PUERTA: CERRADA\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25% | PUERTA: CERRADA\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% | PUERTA: CERRADA";
        return resultado;
    }

    /**
     * Efectua : el método resultadosHabitacionesPerder2, contiene la variable String resultado que contendrá la información de las 3 habitaciones junto a los parámetros ingresados
     * @param   nivelAguaHab1- nivel del agua de la habitación 1
     * @param  nivelAguaHab2- nivel del agua de la habitación 2
     * @param  nivelAguaHab3 -nivel del agua de la habitación 3
     * @return String resultados-mensaje "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20%\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25%\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% "
     */
    public String resultadosHabitacionesPerder2(double nivelAguaHab1,double nivelAguaHab2,double nivelAguaHab3){
        String resultado = "";
        resultado = "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20% | PUERTA: ABIERTA\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25% | PUERTA: CERRADA\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% | PUERTA: CERRADA";
        return resultado;
    }
    /**
     * Efectua : el método resultadosHabitacionesPerder3, contiene la variable String resultado que contendrá la información de las 3 habitaciones junto a los parámetros ingresados
     * @param   nivelAguaHab1- nivel del agua de la habitación 1
     * @param  nivelAguaHab2- nivel del agua de la habitación 2
     * @param nivelAguaHab3 -nivel del agua de la habitación 3
     * @return String resultados-mensaje "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20%\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25%\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% "
     */
    public String resultadosHabitacionesPerder3(double nivelAguaHab1,double nivelAguaHab2,double nivelAguaHab3){
        String resultado = "";
        resultado = "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20% | PUERTA: ABIERTA\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25% | PUERTA: ABIERTA\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% | PUERTA: CERRADA";
        return resultado;
    }
    /**
     * Efectua : el método resultadosHabitacionesGanar, contiene la variable String resultado que contendrá la información de las 3 habitaciones junto a los parámetros ingresados
     * @param   nivelAguaHab1- nivel del agua de la habitación 1
     * @param  nivelAguaHab2- nivel del agua de la habitación 2
     * @param  nivelAguaHab3 -nivel del agua de la habitación 3
     * @return String resultados-mensaje "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20%\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25%\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% "
     */
    public String resultadosHabitacionGanar(double nivelAguaHab1,double nivelAguaHab2,double nivelAguaHab3){
        String resultado = "";
        resultado = "HABITACION 1: Nivel Agua: "+nivelAguaHab1*100+"% | LETALIDAD: 20% | PUERTA: ABIERTA\nHABITACION 2: Nivel Agua:"+nivelAguaHab2*100+"% | LETALIDAD: 25% | PUERTA: ABIERTA\nHABITACION 3: Nivel Agua: "+nivelAguaHab3*100+"% | LETALIDAD: 30% | PUERTA: ABIERTA";
        return resultado;
    }
    /**
     * Efectua : el método atributosJugador, contiene la variable String resultado que contendrá la información del jugador junto a los parámetros dados
     *@param  vida
     *@param  nombre
     * @return String resultados-mensaje: "NOMBRE JUGADOR: "+ nombre+ "\nVIDA JUGADOR: "+ vida*100+ "%\n"
     */
    public String atributosJugador(double vida, String nombre){
        String resultado = "";
        resultado = "NOMBRE JUGADOR: "+ nombre+ "\nVIDA JUGADOR: "+ vida*100+ "%\n";
        return resultado;
    }

    /**
     * Efectua : el método comparar, contiene la variable String resultado que contendrá la información del jugador junto a los parámetros dados
     *@param numeroHabitacionRecord = número mayor de la habitación que ha llegado el jugador
     *@param cantidadMovimientosRecord = movimiento record del jugador
     *@param vidaRecord = vida record del jugador
     *@param numeroHabitacionNuevo = numero de Habitación que ha llegado el jugador
     *@param cantidadMovimientosNuevo = cantidad de movimiento que ha efectuado el jugador
     *@param vidaNuevo = vida del jugador
     *@param ganoViejo = indica si ha ganado o no el jugador anterior
     *@param ganoNuevo = indica si ha ganado o no el jugador actual
     * @return String resultados-mensaje: "NOMBRE JUGADOR: "+ nombre+ "\nVIDA JUGADOR: "+ vida*100+ "%\n"
     */
    public boolean comparar(int numeroHabitacionRecord, int cantidadMovimientosRecord, double vidaRecord, int numeroHabitacionNuevo, int cantidadMovimientosNuevo, double vidaNuevo, boolean ganoViejo, boolean ganoNuevo){
        boolean resultado = false;
        if(numeroHabitacionNuevo > numeroHabitacionRecord){
            resultado = true;
        }
        else if(ganoViejo == false && ganoNuevo == true){
            resultado = true;
        }
        else if(numeroHabitacionNuevo == numeroHabitacionRecord && cantidadMovimientosRecord > cantidadMovimientosNuevo) {
            resultado = true;
        }

        else if(numeroHabitacionNuevo == numeroHabitacionRecord && vidaRecord < vidaNuevo && cantidadMovimientosRecord == cantidadMovimientosNuevo){
            resultado = true;
        }
        else{
            resultado = false;
        }
        return resultado;
    }










    /**
     * Método para modificar la variable vida
     * @param  - indica si el jugador gano o no
     * Modifica : el varible local vida de la clase resultados por el valor de parámetro
     *
     */

    public void setVida(double vida) {
        this.vida = vida;
    }





    /**
     * Método para modificar la variable movimiento
     * @param movimiento - movimiento del jugador
     * Modifica : el varible local movimiento de la clase resultados por el valor de parámetro
     *
     */
    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }
    /**
     * Método para modificar la variable movimientoRecord
     * @param movimiento - movimiento del jugador
     * Modifica : el varible local movimientRecordo de la clase resultados por el valor de parámetro
     *
     */
    public void setMovimientoRecord(int movimiento) {
        this.movimientoRecord = movimiento;
    }
    /**
     * Método para modificar la variable nombreRecord
     * @param nombre - nombre del jugador
     * Modifica : el variable local nombreRecord de la clase resultados por el valor de parámetro
     *
     */
    public void setNombreRecord(String nombre) {
        this.nombreRecord = nombre;
    }

    /**
     * Método para conseguir el variable nombre
     * @return nombre- nombre del jugador
     */

    public String getNombre() {
        return nombre;
    }


    /**
     * Método para modificar la variable nombre
     * @param nombre - nombre del jugador
     * Modifica : el variable local nombre de la clase resultados por el valor de parámetro
     *
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para conseguir el variable numeroHabitación
     * @return numeroHabitacion- número de habitación
     */

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }


    /**
     * Método para modificar la variable numeroHabitacion
     * @param numeroHabitacion - numero de Habitación
     * Modifica : el variable local numeroHabitacion de la clase resultados por el valor de parámetro
     *
     */
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    /**
     * Método para modificar la variable nombre
     * @param  - nombre del jugador
     * Modifica : el variable local nombre de la clase resultados por el valor de parámetro
     *
     */
    public void setNumeroHabitacionRecord(int numeroHabitacion) {
        this.numeroHabitacionRecord = numeroHabitacion;
    }

    /**
     * Método para conseguir el variable record
     * @return record- record del juego
     */

    public String getRecord() {
        return record;
    }


    /**
     * Método para modificar la variable record
     * @param record - record del juego
     * Modifica : el variable local record de la clase resultados por el valor de parámetro
     *
     */
    public void setRecord(String record) {
        this.record = record;
    }

    /**
     * Método para conseguir el variable letalidad
     * @return letalidad-letalidad de la habitación
     */

    public double getLetalidad() {
        return letalidad;
    }

    /**
     * Método para modificar la variable letalidad
     * @param letalidad - letalidad de la habitacion
     * Modifica : el variable local letalidad de la clase resultados por el valor de parámetro
     *
     */

    public void setLetalidad(double letalidad) {
        this.letalidad = letalidad;
    }

    /**
     * Método para modificar la variable gano
     * @param gano - indica si gano el jugador o no
     * Modifica : el variable local gano de la clase resultados por el valor de parámetro
     *
     */
    public void setGano(boolean gano) {
        this.gano = gano;
    }

    /**
     * Método para conseguir el variable nivelagua
     * @return nivelAgua- nivel del agua de la habitación
     */
    public double getNivelAgua() {
        return nivelAgua;
    }

    /**
     * Método para modificar la variable nivelAgua
     * @param nivelAgua - nivel agua de la habitación
     * Modifica : el variable local nivelAgua de la clase resultados por el valor de parámetro
     *
     */

    public void setNivelAgua(double nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    /**
     * Método para conseguir el variable vidaMago
     * @return vidaMago- vida del mago
     */

    public String getVidaMago() {
        return vidaMago;
    }


    /**
     * Método para modificar la variable vidaMago
     * @param vidaMago - vida del Mago
     * Modifica : el variable local vidaMago de la clase resultados por el valor de parámetro
     *
     */
    public void setVidaMago(String vidaMago) {
        this.vidaMago = vidaMago;
    }

    /**
     * Método para conseguir el variable vidaDragon
     * @return vidaDragon- vida del dragon
     */


    public String getVidaDragon() {
        return vidaDragon;
    }


    /**
     * Método para modificar la variable vidaDragon
     * @param vidaDragon - vida del dragon
     * Modifica : el variable local vidaDragon de la clase resultados por el valor de parámetro
     *
     */
    public void setVidaDragon(String vidaDragon) {
        this.vidaDragon = vidaDragon;
    }


    /**
     * Método para conseguir el variable vidaeEspada
     * @return vidaEspada- vida del espada
     */

    public String getVidaEspada() {
        return vidaEspada;
    }

    /**
     * Método para modificar la variable vidaEspada
     * @param vidaEspada - vida de la esapda
     * Modifica : el variable local vidaEspada de la clase resultados por el valor de parámetro
     *
     */

    public void setVidaEspada(String vidaEspada) {
        this.vidaEspada = vidaEspada;
    }








}

