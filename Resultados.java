

public class Resultados{
		
		
  String record;


   
    
    public String toStringStats(String nombre, double vidaJugador, double vidaMago, double vidaEspada, double vidaDragon, int numeroHabitacion, int numeroMovimientos, double nivelAgua, double letalidad){
    return "\nNOMBRE: "+nombre+"\nVIDA: "+ (int)vidaJugador * 100 +"%" + "\nVIDA MAGO: "+ (int)vidaMago* 100 +"%" +"\nVIDA ESPADA: "+ (int)vidaEspada * 100 +"%"+ "\nVIDA DRAGON: "+(int) vidaDragon* 100 +"%"+ "\nNUMERO HABITACION: "+numeroHabitacion+ "\nNUMERO DE MOVIMIENTOS: "+numeroMovimientos+ "\nNIVEL AGUA:"+ nivelAgua * 100 +"%"+ "\nLETALIDAD: "+letalidad* 100 +"%" ;
    }
    
    
    public String registro(String historial){
        String resultadoFinal = ""; 
        resultadoFinal += historial;
        resultadoFinal += "\n";
        return resultadoFinal;
    
    }
		
    
    public String toStringRecord(String nombre, double distancia, double movimiento, double vida) {
	       Comparar(distancia, 0.0, movimiento, 0.0, vida, 0.0) ;
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


		


		
	}
