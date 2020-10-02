
public class Resultados {
	private double vida;
	private int movimiento;
	private String nombre;
	private int numeroHabitacion;
	public String record;
	private double letalidad;
	private double nivelAgua;
	private double vidaMago;
	private double vidaDragon;
	private double vidaEspada;
	
	
	
	
	public String RegistroHistorico(int movimiento) {
		String representacion = "";
		
		for(int i = 0; i < movimiento; i++) {
			
			representacion = "-HABITACION: "+ numeroHabitacion + " -LETALIDAD: "+ letalidad+" -NIVEL DE AGUA: "+nivelAgua+"\nMOVIMIENTOS EFECTUADOS: "+vida+"\nVIDA DE SUS CARTAS: -MAGO: "+vidaMago+"% -ESPADA: "+vidaEspada+"% -DRAGON: "+vidaDragon+"%";
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



	public int getMovimiento() {
		return movimiento;
	}



	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}



	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}



	public String getRecord() {
		return record;
	}



	public void setRecord(String record) {
		this.record = record;
	}



	public double getLetalidad() {
		return letalidad;
	}



	public void setLetalidad(double letalidad) {
		this.letalidad = letalidad;
	}



	public double getNivelAgua() {
		return nivelAgua;
	}



	public void setNivelAgua(double nivelAgua) {
		this.nivelAgua = nivelAgua;
	}



	public double getVidaMago() {
		return vidaMago;
	}



	public void setVidaMago(double vidaMago) {
		this.vidaMago = vidaMago;
	}



	public double getVidaDragon() {
		return vidaDragon;
	}



	public void setVidaDragon(double vidaDragon) {
		this.vidaDragon = vidaDragon;
	}



	public double getVidaEspada() {
		return vidaEspada;
	}



	public void setVidaEspada(double vidaEspada) {
		this.vidaEspada = vidaEspada;
	}



	
	

}

