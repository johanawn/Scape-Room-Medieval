
/**
 * Write a description of class Resultados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Resultados {
	private double vida;
	private int movimiento;
	private String nombre;
	private int numeroHabitacion;
	private String record;
	private double letalidad;
	private double nivelAgua;
	private Cartas mago;
	private Cartas espada;
	private Cartas dragon;
	private Cartas hab1;
	private Cartas hab2;
	private Cartas hab3;
	private double vidaMago;
	private double vidaDragon;
	private double vidaEspada;
	
	
	
	public String registroHistorico() {
		String representacion = "";
			
		representacion += "-HABITACION: "+ numeroHabitacion + " -LETALIDAD: "+ letalidad+" -NIVEL DE AGUA: "+nivelAgua+"\nMOVIMIENTOS EFECTUADOS: "+vida+"\nVIDA DE SUS CARTAS: -MAGO: "+vidaMago+"% -ESPADA: "+vidaEspada+"% -DRAGON: "+vidaDragon+"%";
		
		return representacion;
	}
	
	

	public void actualizarResultados(double vida, int movimiento, String nombre, int numeroHabitacion, double letalidad, double nivelAgua, Cartas cartaEnemiga, Cartas cartaJugador ) {
	    setNivelAgua(nivelAgua);
	     setNombre(nombre);
	     setMovimiento(movimiento);
	     setNumeroHabitacion(numeroHabitacion);
	     setVida(vida);
	     if(cartaJugador.getTipo().equals("MAGO")){
	         setMago(cartaJugador);
	       }
	       else if(cartaJugador.getTipo().equals("ESPADA")){
	          setEspada(cartaJugador);
	       }
	       else if(cartaJugador.getTipo().equals("DRAGON")){
	         setDragon(cartaJugador);
	       }
	         if(numeroHabitacion ==1){
	         this.hab1 = cartaEnemiga;
	       }
	       else if(numeroHabitacion ==2){
	           this.hab2 = cartaEnemiga;
	       }
	       else if(numeroHabitacion ==3){
	            this.hab3 = cartaEnemiga;
	       }
	       
	     
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


	public String Comparar(double distancia, double distanciaNuevo, double movimiento, double movimientoNuevo, double vida, double vidaNuevo) {
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


	public String toStringRecord(String nombre, double distancia, double movimiento, double vida) {
	       Comparar(distancia, 0.0, movimiento, 0.0, vida, 0.0) ;
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
	public void setMago(Cartas cartaJugador){
	    this.mago = cartaJugador;
	   }
	   public void setEspada(Cartas cartaJugador){
	    this.espada = cartaJugador;
	   }
	   public void setDragon(Cartas cartaJugador){
	    this.dragon = cartaJugador;
	   }
	   public void setHab1(Cartas cartaEnemiga){
	    this.hab1 = cartaEnemiga;
	   }
	    public void setHab2(Cartas cartaEnemiga){
	    this.hab2 = cartaEnemiga;
	   }
	    public void setHab3(Cartas cartaEnemiga){
	    this.hab3 = cartaEnemiga;
	   }





	
	

}

