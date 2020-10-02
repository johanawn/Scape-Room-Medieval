
public class Resultados {
	private double vida;
	private double movimiento;
	private String nombre;
	private double numeroHabitacion;
	public String record;
	

	public Resultados(double vida, double movimiento, String nombre, double numeroHabitacion) {

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

	public void setMovimiento(double movimiento) {
		this.movimiento = movimiento;
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

	public void setNumeroHabitacion(double numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	
	

}
