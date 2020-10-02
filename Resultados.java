
public class Resultados {
	private double vida;
	private int movimiento;
	private String nombre;
	private int numeroHabitacion;
	public String record;
	Cartas cartas = new Cartas();
	InterfazScanner interfaz = new InterfazScanner();
	Jugador player = new Jugador( vida, movimiento, nombre, numeroHabitacion);
	Habitacion habitacion = new Habitacion();
	
	
	public String RegistroHistorico() {
		String representacion = "";
		
		for(int i = 0; i < player.getMovimientos(); i++) {
			
			representacion = "-HABITACION: "+ player.getNumerohabitacion() + " -LETALIDAD: "+habitacion.getLetalidad()+" -NIVEL DE AGUA: "+habitacion.getNivelAgua()+"\nMOVIMIENTOS EFECTUADOS: "+player.getVida()+"\nVIDA DE SUS CARTAS: -MAGO: "+cartas.getAtaqueMago()+"% -ESPADA: "+cartas.getVidaEspada()+"% -DRAGON: "+cartas.getAtaqueEspada()+"%";
		}
		return representacion;
	}
	
	

	public Resultados(double vida, int movimiento, String nombre, int numeroHabitacion) {

	     setNombre(nombre);
	     setMovimiento(movimiento);
	     setNumeroHabitacion(numeroHabitacion);
	     setVida(vida);
	     
	}
	
	
	public Resultados() {
		 setNombre(nombre);
	     setMovimiento(movimiento);
	     setNumeroHabitacion(numeroHabitacion);
	     setVida(vida);
	}



	public String CompararHabitacion(double distancia, double distanciaNuevo, double movimiento, double movimientoNuevo, double vida, double vidaNuevo) {
		    record = "Vida: "+ vida + "Cantidad de Movimientos: "+movimiento + "Habitacion: "+distancia;
		
		if(distancia ==  distanciaNuevo && movimiento == movimientoNuevo && vida == vidaNuevo ) {
			record = "Vida: "+ vida + "Cantidad de Movimientos: "+movimiento + "Habitacion: "+distancia;
		
		}
		if(distancia ==  distanciaNuevo && movimiento < movimientoNuevo && vida > vidaNuevo || vida < vidaNuevo  ) {
			record = "Vida: "+ vida + "Cantidad de Movimientos: "+movimiento + "Habitacion: "+distancia;
			
		}
		
		if(distancia ==  distanciaNuevo && movimiento > movimientoNuevo &&  vida > vidaNuevo || vida < vidaNuevo) {
			record = "Vida: "+ vidaNuevo + "Cantidad de Movimientos: "+movimientoNuevo + "Habitacion: "+distanciaNuevo;
			
		}
		if(distancia <  distanciaNuevo) {
			record = "Vida: "+ vidaNuevo + "Cantidad de Movimientos: "+movimientoNuevo + "Habitacion: "+distanciaNuevo;
	
		}
		
		if(distancia >  distanciaNuevo) {
			record = "Vida: "+ vidaNuevo + "Cantidad de Movimientos: "+ movimientoNuevo + "Habitacion: "+distanciaNuevo;
		}
	
		return record;
	}


	public String toString(String nombre, double distancia, double movimiento, double vida) {
	       CompararHabitacion(distancia, 0.0, movimiento, 0.0, vida, 0.0) ;
		return nombre+" Resultados "+record;
	}


	public double getVida() {
		return vida;
	}

	public void setVida(double vida) {
		this.vida = vida;
	}

	public double getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(int movimiento) {
		this.movimiento =  movimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	
	

}