
/**
 * Write a description of class InterfazGrafica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;


public class InterfazGrafica{
    String [] opcionesInciciales = {"MEJOR PUNTAJE HASTA AHORA", "EMPEZAR EL JUEGO", "SALIR DEL JUEGO"};
    String [] eleccionCartas = {"MAGO", "ESPADA", "DRAGON"};
    String [] opcionesInGame = {"HACER MOVIMIENTO", "REGISTRO DE JUEGO", "ABANDONAR JUEGO"};
    String nombreD = "Jugador";
    int i = 1;
    
    public String pedirNombre(){
        String nombre = JOptionPane.showInputDialog("Digite su nombre, este se usará para llamarlo durante todo el juego.");
        String nombrePrueba = nombre.trim();
        if (nombrePrueba.equals("")){
        nombre = JOptionPane.showInputDialog("Digite su nombre, si no se le asignará un nombre por default");
        }
        if (nombrePrueba.equals("")){
            nombre = nombreD+i;
            JOptionPane.showMessageDialog(null, "Se asignará \""+nombre+ "\" como su usuario default.", "ASIGNACIÓN AUTOMATICA",JOptionPane.INFORMATION_MESSAGE);
            i++;
        }
        return nombre;
    }
      public void derrotaHabitacion(int numeroHabitacion){
        JOptionPane.showMessageDialog(null,"HAS SALIDO DE LA HABITACION","HAS DERROTADO A LA HABITACION: "+numeroHabitacion, JOptionPane.INFORMATION_MESSAGE);
       }
    public int opcionesIniciales (){
        String datosMejorJugador="";
        int eleccionInicial = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "BIENVENIDO AL SCAPE ROOM MEDIEVAL", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesInciciales, opcionesInciciales[0]);
        return eleccionInicial;
    }
    public void records(String records){
        String datosMejorJugador = records;
        JOptionPane.showMessageDialog(null, new JTextArea(datosMejorJugador));
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
    public void cartaMuerta(){
         JOptionPane.showMessageDialog(null, "La carta que elegiste se ha quedado sin vida", "Cuida tus Cartas", JOptionPane.WARNING_MESSAGE);
    }
    public int randomCartas(){
        int numRandom = (int) (Math.random()*3);

       return numRandom;
     }
    public void abandona(int abandona){
        if (abandona == 1){
            JOptionPane.showMessageDialog(null, "Vuelve a jugar cuando quieras!", "HASTA PRONTO",JOptionPane.INFORMATION_MESSAGE);
        }
        else if (abandona == 2){
            perderGitGud();
        }
    }
    public int antesDeMover(String juego){
        mostrarEstadisticasJugador(juego);
        int antesDeMover = JOptionPane.showOptionDialog(null,"¿Qué acción tomarás?","CUIDA TUS PASOS", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesInGame, opcionesInGame[0]);
        return antesDeMover;
    }
    public void registroJuego(String registro){
        JTextArea textArea = new JTextArea(registro);
        JScrollPane historialDeJuego = new JScrollPane(textArea); 
        historialDeJuego.setSize(300, 300);
        JOptionPane.showMessageDialog(null, historialDeJuego, "REGISTRO DE JUGADAS", JOptionPane.INFORMATION_MESSAGE); 
    }
    public void mostrarEstadisticasJugador(String juego ){
        String estadisticasJugador = juego ;
        JOptionPane.showMessageDialog(null, new JTextArea(estadisticasJugador));
    }
    public void mostrarResultadoFinal(String jugador,String mago, String espada, String dragon, String habitacion){
        String estadisticasFinales = "JUGADOR\n"+jugador+"\n CARTAS\n"+mago+"\n"+espada+"\n"+dragon+"\n"+habitacion;
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
