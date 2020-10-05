
public class Resultados{
    
    public String toStringStats(String nombre, double vidaJugador, double vidaMago, double vidaEspada, double vidaDragon, int numeroHabitacion, int numeroMovimientos, double nivelAgua, double letalidad){
    return "\nNOMBRE: "+nombre+"\nVIDA: "+ vidaJugador + "\nVIDA MAGO: "+ vidaMago + "\nVIDA ESPADA: "+ vidaEspada + "\nVIDA DRAGON: "+ vidaDragon+ "\nNUMERO HABITACION: "+numeroHabitacion+ "\nNUMERO DE MOVIMIENTOS: "+numeroMovimientos+ "\nNIVEL AGUA:"+ nivelAgua + "\nLETALIDAD: "+letalidad ;
    }
    
    
    public String registro(String historial){
        String resultadoFinal = ""; 
        resultadoFinal += historial;
        resultadoFinal += "\n";
        return resultadoFinal;
    
    }

    




}