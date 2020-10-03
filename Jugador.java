
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador{

	private int movimientos;
	private double vida;
	private String nombre;
	private boolean ataca;
	private Cartas mago;
	private Cartas espada;
	private Cartas dragon;
	
	public Jugador(){
		setNombre("");
		setMovimientos(0);
		setVida(1.0);
		int construirCartas = 0;
		mago = new Cartas(construirCartas);
		construirCartas++;
		espada = new Cartas(construirCartas);
		construirCartas++;
		dragon = new Cartas(construirCartas);
	}
	
	public Jugador(double vida2, int movimiento, String nombre, int numeroHabitacion) {
		this.movimientos = movimiento;
		this.vida = vida2;
		this.nombre = nombre;

	}

	// mantiene el record la persona que menos movimientos ha hecho en el escape o el más lejos que ha llegado.
	public double Atacar(double vidaRecibidor, double ataqueAtacador, double defensaRecibidor, int cantidadDeAtaques ){
		ataca = true;
		double resultadoAtaque = 0;
		//recordar llamar los métodos de las cartas Mago, Espada y Dragon, y subir el nivel del agua.
		for(int i = 0; i <= cantidadDeAtaques; i += 1){
			resultadoAtaque = (vidaRecibidor - ataqueAtacador) + defensaRecibidor;
		
		}
		return resultadoAtaque;
	}
	
	
	public void agregarMovimiento(){
	    movimientos += 1;
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
	public void setCartaMago(Cartas cartaMago){
	    this.mago = cartaMago;
	   }
	   public void setCartaEspada(Cartas cartaEspada){
	    this.espada = cartaEspada;
	   }
	   public void setCartaDragon(Cartas cartaDragon){
	       this.dragon = cartaDragon;
	   }
	   public Cartas getCartaMago(){
	       return mago;
	   }
	   public Cartas getCartaEspada(){
	       return espada;
	   }
	   public Cartas getCartaDragon(){
	       return dragon;
	   }
	   
}

