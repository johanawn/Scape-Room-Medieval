


public class Record{
    private double vida = 0.0;
    private int cantMovimientos = 0;
    private int numHabitacion = 0;
    private String nombreJugador = "";

    public Record(){
        vida = 0.0;
        cantMovimientos = 0;
        numHabitacion = 0;
        nombreJugador = "";
    }

    public void verificar(String jugador, int numHabitacion, int cantMovimientos, double vida){
    	
    
        if(this.numHabitacion < numHabitacion){
            this.numHabitacion = numHabitacion;
            this.cantMovimientos = cantMovimientos;
            this.vida = vida;
            nombreJugador = jugador;
        }
        else if (this.numHabitacion == numHabitacion && this.cantMovimientos < cantMovimientos){
            this.numHabitacion = numHabitacion;
            this.cantMovimientos = cantMovimientos;
            this.vida = vida;
            nombreJugador = jugador;
        }
        else if (this.numHabitacion == numHabitacion && this.cantMovimientos == cantMovimientos && this.vida < vida){
            this.numHabitacion = numHabitacion;
            this.cantMovimientos = cantMovimientos;
            this.vida = vida;
            nombreJugador = jugador;
        }
    }
    
    
    
	
    
    public String toString(){
    	String records = "";
      
             records ="El record total lo posee el jugador "+nombreJugador+", con "+cantMovimientos+" movimientos y con "+(int)(vida*100)+" de vida";
        
        return records;
}
}

