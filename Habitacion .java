
public class Habitacion{
	private int numeroHabitacion = 0;
	private double letalidad = 0.15;
	private double agua = 0.0;
	private boolean puertaAbierta = false;
	private Cartas cartaEnemiga;
	

	public void cambiarNumeroHabitacion(boolean abierto){
		if(abierto == true){
			numeroHabitacion += 1;
		}
	 }
	
	public void subirLetalidad(){
		letalidad += 0.05;
	
	}
	public void subirAgua(double nivelLetalidad){
		agua += nivelLetalidad;
        }
        public void setNivelAgua(double agua){
         this.agua = agua;
        }
	
	
	public void setNumeroHabitacion(int numeroHabitacion) {
			this.numeroHabitacion = numeroHabitacion;
		}

	public double getAgua() {
		return agua;
	}

	public void setAgua(double agua) {
		this.agua = agua;
	}

	public boolean isPuertaAbierta() {
		return puertaAbierta;
	}

	public void setPuertaAbierta(boolean puertaAbierta) {
		this.puertaAbierta = puertaAbierta;
	}

	public void setLetalidad(double letalidad) {
		this.letalidad = letalidad;
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

	public double efectoAgua(double vida){
		if (agua >= 1.0){
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
		return "HABITACION: "+numeroHabitacion+" -LETALIDAD: "+letalidad+" -NIVEL DE AGUA: "+agua+" -ESTADO DE LA PUERTA: "+estadoPuerta;
	}
<<<<<<< HEAD:Habitacion .java
}
=======
	public void setNumeroHabitacion(int numeroHabitacion){
		this.numeroHabitacion = numeroHabitacion;
	}
	public void setLetalidad(double letalidad){
	this.letalidad = letalidad;
	}

}

>>>>>>> e16d2ecc96ca8cb7697ab6e9c0327eccd0902491:Habitacion.java
