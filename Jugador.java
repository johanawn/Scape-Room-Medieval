


import java.util.ArrayList;
public class Jugador{
	Cartas Mago = new Cartas();
	Cartas Dragon = new Cartas();
	Cartas Espada = new Cartas();
	Habitacion sala = new Habitacion();
	int movimientos;
	public double vida = 1.0;
	public String nombre;
	private boolean ataca = false;
	int m = 0;
	int numerohabitacion;
	
	
	public Jugador(double vida2, int movimiento, String nombre, int numeroHabitacion) {
		this.movimientos = movimiento;
		this.vida = vida2;
		this.nombre = nombre;
		this.numerohabitacion = sala.getNumeroHabitacion();

	}

	

	// mantiene el record la persona que menos movimientos ha hecho en el escape o el más lejos que ha llegado.
	public double Atacar(double vidaRecibidor, double ataqueAtacador, double defensaRecibidor, int cantidadDeAtaques ){
		ataca = true;
		double resultadoAtaque = 0;
		sala.subirLetalidad();
		Mago.Mago();
		Dragon.Dragon();
		Espada.Espada();

		for(int i = 0; i <= cantidadDeAtaques; i += 1){
			resultadoAtaque = (vidaRecibidor - ataqueAtacador) + defensaRecibidor;
		
		}
		return resultadoAtaque;
	}
	
	
	//Cada vez que ataca sea true, se le suma 1 al contador de movimientos.
	public int Movimiento() {
	
		if (ataca == true) {
			m++;
		   ataca=false;
		}
		
		movimientos = m;
		
		return movimientos;
	}

	

	public int getNumerohabitacion() {
		return numerohabitacion;
	}


	public void setNumerohabitacion(int numerohabitacion) {
		this.numerohabitacion = numerohabitacion;
	}



	public void setSala(Habitacion sala) {
		this.sala = sala;
	}

	public int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}

	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}