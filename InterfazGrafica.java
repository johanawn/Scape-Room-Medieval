package TareaProgramada;


/**
 * Write a description of class InterfazGrafica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;


public class InterfazGrafica{
    String [] opcionesInciciales = {"VER EL MEJOR RECORD HASTA EL MOMENTO", "EMPEZAR EL JUEGO", "SALIR DEL JUEGO"};
    String [] eleccionCartas = {"MAGO", "ESPADA", "DRAGON"};
    String [] opcionesInGame = {"HACER MOVIMIENTO", "REGISTRO DE JUEGO", "ABANDONAR JUEGO"};
    String nombreD = "Jugador";
    int i = 1;
    
    public String pedirNombre(){
        String nombre = JOptionPane.showInputDialog("Digite su nombre, este se usará para llamarlo durante todo el juego.");
        if (nombre == ""){
        nombre = JOptionPane.showInputDialog("Digite su nombre, si no se le asignará un nombre por default");
        }
        if (nombre == ""){
            nombre = nombreD+i;
            JOptionPane.showMessageDialog(null, "Se asignará \""+nombre+ "\" como su usuario default.", "ASIGNACIÓN AUTOMATICA",JOptionPane.INFORMATION_MESSAGE);
            i++;
        }
        return nombre;
    }
    public int opcionesInciales (){
        String datosMejorJugador="";
        int eleccionInicial = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "BIENVENIDO AL SCAPE ROOM MEDIEVAL", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesInciciales, opcionesInciciales[0]);
        return eleccionInicial;
    }
    public void derrotaHabitacion(int numeroHabitacion){
        JOptionPane.showMessageDialog(null,"HAS SALIDO DE LA HABITACION","HAS DERROTADO A LA HABITACION: "+numeroHabitacion, JOptionPane.INFORMATION_MESSAGE);
       }
     public void cartaMuerta(){
        JOptionPane.showMessageDialog(null,"MIRA CON ATENCION LA VIDA DE TUS CARTAS","La carta que elegiste no tiene vida, por lo tanro ya no hace daño", JOptionPane.WARNING_MESSAGE);
       }
    public int records(String records){
        String datosMejorJugador = records;
        JOptionPane.showMessageDialog(null, new JTextArea(datosMejorJugador));
        int elegir = opcionesInciales();
        return elegir;
    }
    public int eleccionDeCartas (){
        int eleccion = JOptionPane.showOptionDialog(null, "Elige una carta para atacar", "LUCHA PARA SALIR!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionCartas, eleccionCartas[0]);
        return eleccion;
    }
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
    public void ganar(){
        JOptionPane.showMessageDialog(null, "Persistance is glory", "LOGRASTE ESCAPAR!", JOptionPane.INFORMATION_MESSAGE);
    }
    public void perderGitGud(){
        JOptionPane.showMessageDialog(null, "Hesitation is defeat, Git Gud", "HAS MUERTO", JOptionPane.INFORMATION_MESSAGE);
    }
    public void abandona(int abandona){
        if (abandona == 1){
            JOptionPane.showMessageDialog(null, "Vuelve a jugar cuando quieras!", "HASTA PRONTO",JOptionPane.INFORMATION_MESSAGE);
        }
        else if (abandona == 2){
            perderGitGud();
        }
    }
    public int antesDeMover(){
        int antesDeMover = JOptionPane.showOptionDialog(null,"¿Qué acción tomarás?","CUIDA TUS PASOS", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesInGame, opcionesInGame[0]);
        return antesDeMover;
    }
    public int registroJuego(String registro){
        JTextArea textArea = new JTextArea(registro);
        JScrollPane historialDeJuego = new JScrollPane(textArea); 
        historialDeJuego.setSize(300, 300);
        JOptionPane.showMessageDialog(null, historialDeJuego, "REGISTRO DE JUGADAS", JOptionPane.INFORMATION_MESSAGE); 
        int seguir = antesDeMover();
        return seguir;
    }
    public void mostrarEstadisticasJugador(String estadisticas ){
        String estadisticasJugador = estadisticas;
        JOptionPane.showMessageDialog(null, new JTextArea(estadisticasJugador));
    }
    public void mostrarResultadoFinal(String registroFinal){
        String estadisticasFinales = registroFinal;
        JOptionPane.showMessageDialog(null, new JTextArea(estadisticasFinales));
    }
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
  

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
