/**
 * Interfaz por ventanas para la aplicación AppGrafica
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/10/2020
 */
import javax.swing.*;


public class InterfazGrafica{
    String [] opcionesInciciales = {"EMPEZAR EL JUEGO", "SALIR DEL JUEGO", "HIGHEST SCORE"};
    String [] eleccionCartas = {"MAGO", "ESPADA", "DRAGON"};
    String [] opcionesInGame = {"HACER MOVIMIENTO", "REGISTRO DE JUEGO", "ABANDONAR JUEGO"};
    String nombreD = "Jugador";
    int i = 1;
    /**
     * Método pedirNombre
     * Efectua: le pide el nombre al jugador.
     * @return nombre - el nombre del jugador
     */
    public String pedirNombre(){
        String nombre = JOptionPane.showInputDialog("Digite su nombre, este se usará para llamarlo durante todo el juego.");
        String nombrePrueba = nombre.trim();
        if (nombrePrueba.equals("")){
            nombre = JOptionPane.showInputDialog("Digite su nombre, si no se le asignará un nombre por default");
            nombrePrueba = nombre.trim();
        }
        if (nombrePrueba.equals("")){
            nombre = nombreD+i;
            JOptionPane.showMessageDialog(null, "Se asignará \""+nombre+ "\" como su usuario default.", "ASIGNACIÓN AUTOMATICA",JOptionPane.INFORMATION_MESSAGE);
            i++;
        }
        return nombre;
    }
    /**
     * Método derrotaHabitacion
     * Efectua: le enseña al jugador el mensaje de que derrotó a una habitación.
     * @param numeroHabitacion - el numero de la habitacion que el jugador derrotó.
     */
    public void derrotaHabitacion(int numeroHabitacion){
        JOptionPane.showMessageDialog(null,"HAS SALIDO DE LA HABITACION","HAS DERROTADO A LA HABITACION: "+numeroHabitacion, JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Método opcionesIniciales
     * Efectua: le enseña al jugador el menú inicial para que elija entre empezar el juego, salir del juego o ver el record
     * @return eleccionInicial - la eleccion del jugador en el menú inicial.
     */
    public int opcionesIniciales (){
        String datosMejorJugador="";
        int eleccionInicial = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "BIENVENIDO AL SCAPE ROOM MEDIEVAL", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesInciciales, opcionesInciciales[0]);
        return eleccionInicial;
    }
    /**
     * Método records
     * Efectua: le enseña al jugador el mejor record hasta el momento
     * @param records - los datos del mejor jugador hasta el momento.
     */
    public void records(String records){
        JOptionPane.showMessageDialog(null, new JTextArea(records));
    }
    /**
     * Método eleccionDeCartas
     * Efectua: le pide al jugador que elija la carta que quiere usar entre Mago, Espada y Dragon.
     * @return eleccion - la eleccion del jugador en el menú  de cartas.
     */
    public int eleccionDeCartas (){
        int eleccion = JOptionPane.showOptionDialog(null, "Elige una carta para atacar", "LUCHA PARA SALIR!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionCartas, eleccionCartas[0]);
        return eleccion;
    }
    /**
     * Método cartaMuerta
     * Efectua: le advierte al jugador que la carta que eligió está muerta y ya no hace daño.
     */
    public void cartaMuerta(){
        JOptionPane.showMessageDialog(null,"La carta que elegiste se ha quedado sin vida, por lo tanto ya no hace daño","MIRA CON ATENCION LA VIDA DE TUS CARTAS", JOptionPane.WARNING_MESSAGE);
    }
    /**
     * Método cantidadAtaques
     * Efectua: le pide al jugador que indique cuańtos ataques quiere realizar con la carta que eligió.
     * @return ataques - la cantidad de ataques que el jugador quiere realizar.
     */
    public int cantidadAtaques(){
        int ataques =0;
        String cantidad = JOptionPane.showInputDialog("Digite la cantidad de ataques que desea realizar, si no digita una cantidad, se le asignará 1 y si digita una cantidad negativa se considerara como su equivalente positivo");
        try {
            ataques = Integer.parseInt(cantidad);
        }
        catch (Exception e){
            ataques = 1;
        }
        if ( ataques < 0){
            ataques = ataques * -1;
        }
        return ataques;
    }
    /**
     * Método ganar
     * Efectua: le informa al jugador que es el ganador.
     */
    public void ganar(){
        JOptionPane.showMessageDialog(null, "Persistance is glory", "LOGRASTE ESCAPAR!", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Método perderGitGud
     * Efectua: le informa al jugador que perdió.
     */
    public void perderGitGud(){
        JOptionPane.showMessageDialog(null, "Hesitation is defeat, Git Gud", "HAS MUERTO", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Método abandona
     * Efectua: depende de la situación, si el jugador sale del juego en media partida le informa que perdió, si lo hace en el menú inicial lo invita a jugar de nuevo.
     */
    public void abandona(int abandona){
        if (abandona == 1){
            JOptionPane.showMessageDialog(null, "Vuelve a jugar cuando quieras!", "HASTA PRONTO",JOptionPane.INFORMATION_MESSAGE);
        }
        else if (abandona == 2){
            perderGitGud();
        }
    }
    /**
     * Método antesDeMover
     * Efectua: le pide al jugador que indique cuál acción quiere tomar entre hacer un movimiento, ver su registro de jugadas o abandonar el juego.
     * @return antesDeMover - la elección del jugador en el segundo menú.
     */
    public int antesDeMover(String juego){
        mostrarEstadisticasJugador(juego);
        int antesDeMover = JOptionPane.showOptionDialog(null,"¿Qué acción tomarás?","CUIDA TUS PASOS", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesInGame, opcionesInGame[0]);
        return antesDeMover;
    }
    /**
     * Método registroJuego
     * Efectua: le enseña al jugador su registro de jugadas hasta el momento.
     * @param registro - los datos de las jugadas hasta el momento.
     */
    public void registroJuego(String registro){
        JTextArea textArea = new JTextArea(registro);
        JScrollPane historialDeJuego = new JScrollPane(textArea);
        historialDeJuego.setSize(300, 300);
        JOptionPane.showMessageDialog(null, historialDeJuego, "REGISTRO DE JUGADAS", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Método mostrarEstadisticasJugador
     * Efectua: le enseña al jugador sus estadisticas en el juego, como su vida, la vida de sus cartas y su ubicación en las habitaciones.
     * @param juego - los datos de las estadisticas del jugador.
     */
    public void mostrarEstadisticasJugador(String juego ){
        String estadisticasJugador = juego ;
        JOptionPane.showMessageDialog(null, new JTextArea(estadisticasJugador));
    }
    /**
     * Método mostrarResultadoFinal
     * Efectua: le enseña al jugador sus estadisticas finales en el juego al perder o ganar.
     * @param jugador - las estadisticas del jugador.
     * @param mago - las estadisticas de la carta Mago.
     * @param espada - las estadisticas de la carta Espada.
     * @param dragon - las estadisticas de la carta Dragon.
     * @param habitacion - las estadisticas de las tres habitaciones.
     */
    public void mostrarResultadoFinal(String jugador,String mago, String espada, String dragon, String habitacion){
        String estadisticasFinales = "JUGADOR\n"+jugador+"\n CARTAS\n"+mago+"\n"+espada+"\n"+dragon+"\n"+habitacion;
        JOptionPane.showMessageDialog(null, new JTextArea(estadisticasFinales));
    }
    /**
     * Método volverAJugar
     * Efectua: le pregunta al jugador si desea volver a jugar.
     * @return jugar - le indica al juego si el jugador quiere jugar de nuevo o no.
     */
    public boolean volverAJugar(){
        boolean jugar;
        int volverJugar = JOptionPane.showConfirmDialog(null, "Seleccione \"S\u00ED\" para volver a jugar al SCAPE ROOM MEDIEVAL o \"No\" para salir del juego", "¿VOLVER A JUGAR?", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == volverJugar){
            jugar = true;
        }
        else{
            jugar = false;
        }
        return jugar;
    }
}
