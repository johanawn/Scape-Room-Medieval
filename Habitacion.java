
/**
 * Crea las habitaciones en el juego.
 * 
 * @author (Sabrina Brenes) 
 * @version (1/10/2020)
 */
public class Habitacion{
	private int numeroHabitacion = 1;
	private Cartas cartaEnemiga = new Cartas();
	private double letalidad = 0.2;
	private double agua = 0;
	private boolean puertaAbierta = false;
	
	public int cambiarNumeroHabitacion(boolean abierto){
		if(abierto == true){
			numeroHabitacion += 1;
		}
	}
	public boolean abrirPuerta(double vidaCartaEnemiga){
		if (vidaCartaEnemiga <= 0){
			puertaAbierta = true;
		}
		return puertaAbierta;
	}
	public double subirLetalidad(){
		letalidad += 0.05;
		return letalidad;	
	}
	public double nivelAgua(){
		return agua += letalidad;
	}
	public int getNumeroHabitacion(){
		return numeroHabitacion;
	}
	public double getNivelAgua(){
		return agua;
	}
	public double getLetalidad(){
		return letalidad;
	}
	public boolean morir(double vidaMago, double vidaEspada, double vidaDragon){
		boolean morir = false;
		if ((vidaMago < letalidad) && (vidaEspada < letalidad) && (vidaDragon < letalidad)){
			morir = true;
		}
		return morir;
	}
	public double dañoAgua(double vida){
		if (agua >= 1.0){
			vida -=letalidad;
		}
		return vida;
	}
	public void cartaEnemiga(){
		int random = (int)((Math.random()*3));
		cartaEnemiga.carta(random);
	}
	public String toString(){
		String estadoPuerta="";
		if (puertaAbierta == false){
			estadoPuerta = "Cerrada";
		}
		else{
			estadoPuerta = "Abierta";
		}
		return "HABITACION: "+numeroHabitacion+" -LETALIDAD: "+letalidad+" -NIVEL DE AGUA: "+agua+" -ESTADO DE LA PUERTA: "+estadoPuerta;
	}
}
