
/**
 * Crea las habitaciones en el juego.
 * 
 * @author (Sabrina Brenes) 
 * @version (1/10/2020)
 */
public class Habitacion{
	private int numeroHabitacion;
	private Cartas cartaEnemiga;
	private double letalidad;
	private double nivelAgua;
	private boolean puertaAbierta;
	
	public Habitacion(){
		setNumeroHabitacion(1);
		setLetalidad(0.2);
		setNivelAgua(0);
		setPuertaAbierta(false);
		int random = (int)((Math.random()*3));
		cartaEnemiga = new Cartas(random);
	}
	public void cambiarNumeroHabitacion(boolean abierto){
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
		return nivelAgua += letalidad;
	}
	public int getNumeroHabitacion(){
		return numeroHabitacion;
	}
	public double getNivelAgua(){
		return nivelAgua;
	}
	public double getLetalidad(){
		return letalidad;
	}
	public Cartas getCartaEnemiga(){
	    return cartaEnemiga;
	   }
	public boolean morir(double vidaMago, double vidaEspada, double vidaDragon){
		boolean morir = false;
		if ((vidaMago < letalidad) && (vidaEspada < letalidad) && (vidaDragon < letalidad)){
			morir = true;
		}
		return morir;
	}
	public double dañoAgua(double vida){
		if (nivelAgua >= 1.0){
			vida -=letalidad;
		}
		return vida;
	}
	public String toString(){
		String estadoPuerta="";
		if (puertaAbierta == false){
			estadoPuerta = "Cerrada";
		}
		else{
			estadoPuerta = "Abierta";
		}
		return "HABITACION: "+numeroHabitacion+" -LETALIDAD: "+letalidad+" -NIVEL DE AGUA: "+nivelAgua+" -ESTADO DE LA PUERTA: "+estadoPuerta;
	}
	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	public void setLetalidad(double letalidad) {
		this.letalidad= letalidad;
	}
	public void setNivelAgua(double nivelAgua) {
		this.nivelAgua = nivelAgua;
	}
	public void setPuertaAbierta(boolean puertaAbierta) {
		this.puertaAbierta = puertaAbierta;
	}
	public void setCartaEnemiga(Cartas cartaEnemiga){
	    this.cartaEnemiga = cartaEnemiga;
	}
}
