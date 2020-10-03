
/**
 * Write a description of class InterfazGrafica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;


public class InterfazGrafica{
	String [] opcionesInciciales = {"EMPEZAR EL JUEGO", "SALIR DEL JUEGO", "HIGHEST SCORE"};
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
	public int mostrarEstadisticasJugador(String jugador, double vidaMago, double vidaEspada, double vidaDragon, int movimientos, int numeroHabitacion, double letalidad, double nivelAgua){
		String estadisticasJugador = "-HABITACION: "+ numeroHabitacion+ " -LETALIDAD: "+letalidad+" -NIVEL DE AGUA: "+nivelAgua+"\nMOVIMIENTOS EFECTUADOS: "+jugador+"\nVIDA DE SUS CARTAS: -MAGO: "+vidaMago+"% -ESPADA: "+vidaEspada+"% -DRAGON: "+vidaDragon+"%";
		JOptionPane.showMessageDialog(null, new JTextArea(estadisticasJugador));
		int seguir = antesDeMover();
		return seguir;
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
  

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
