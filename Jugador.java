
import java.util.ArrayList;
public class Jugador{


	int movimientos;
	public double vida = 1.0;
	public String nombre;
	private boolean ataca = false;
	int m = 0;
	
	
	public Jugador() {
		setMovimientos(0);
		setVida(1.0);
		setNombre("");

	}
	
	

	// mantiene el record la persona que menos movimientos ha hecho en el escape o el más lejos que ha llegado.
	
	
	
	//Cada vez que ataca sea true, se le suma 1 al contador de movimientos.
	public void sumarMovimiento() {
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
	
	

}