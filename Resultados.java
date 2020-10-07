

public class Resultados{
    private String registro;
    private String historial;
    private Record record;
    
    public Resultados(){
        registro = "";
        historial = "";
        
    }

   
    public String toStringStats(String nombre, double vidaJugador, double vidaMago, double vidaEspada, double vidaDragon, int numeroHabitacion, int numeroMovimientos, double nivelAgua, double letalidad){
        return "\nNOMBRE: "+nombre+"\nVIDA: "+ (int)(vidaJugador* 100)+"%" + "\nVIDA MAGO: "+(int) (vidaMago* 100) +"%" +"\nVIDA ESPADA: "+ (int)(vidaEspada * 100) +"%"+ "\nVIDA DRAGON: "+(int)( vidaDragon* 100) +"%"+ "\nNUMERO HABITACION: "+numeroHabitacion+ "\nNUMERO DE MOVIMIENTOS: "+numeroMovimientos+ "\nNIVEL AGUA:"+ (int)(nivelAgua * 100) +"%"+ "\nLETALIDAD: "+(int)(letalidad* 100) +"%"+"\n" ;
    }

    
    public void registro(String stats){
        registro += stats;
    }

    public void printRegistro(){
        System.out.println(registro);
    }

    public void historial(String stats){
        historial += stats;
    }
    
    public void verificarRecord(String jugador, int numHabitacion, int cantMovimientos, double vida){
        record.verificar(jugador, numHabitacion, cantMovimientos, vida);
       
    }
    
    public String getRecord(){
        return record.toString();
    }

    public String registroMago(double vidaMago, double ataqueMago, double defensaMago){
        String registroStats = "\nVIDA MAGO: "+ (int)(vidaMago*100) + " | ATAQUE MAGO: " + (int)(ataqueMago*100)+ " | DEFENSA MAGO: " + (int)(defensaMago*100) ;
        return registroStats;
    }

    public String registroEspada(double vidaEspada, double ataqueEspada, double defensaEspada){
        String registroStats = "\nVIDA ESPADA: "+ (int)(vidaEspada*100) + " | ATAQUE ESPADA: " + (int)(ataqueEspada*100)+ " | DEFENSA ESPADA: " + (int)(defensaEspada *100);
        return registroStats;
    }

    public String registroDragon(double vidaDragon, double ataqueDragon, double defensaDragon){
        String registroStats = "\nVIDA DRAGON: "+ (int)(vidaDragon*100) + " | ATAQUE DRAGON: " + (int)(ataqueDragon*100)+ " | DEFENSA DRAGON: " +(int)( defensaDragon *100);
        return registroStats;
    }

    public String registroEnemiga(int numeroHabitacion, int tipo,double vida, double ataque, double defensa){
        String registroStatsEnemigo = "";
        if (tipo == 0) {
            registroStatsEnemigo = "\nNUMERO DE HABITACION: "+numeroHabitacion+" | TIPO DE CARTA: MAGO"+" | VIDA: " + (int)(vida*100) + " | ATAQUE: " + (int)(ataque*100) + " | DEFENSA: " +(int)(defensa*100) +"\n";
        }
        else if (tipo == 1) {
            registroStatsEnemigo = "\nNUMERO DE HABITACION: "+numeroHabitacion+" | TIPO DE CARTA: ESPADA"+" | VIDA: " +(int)(vida*100) + " | ATAQUE: " + (int)(ataque*100) + " | DEFENSA: " + (int)(defensa*100)+"\n";
        }
        else if (tipo == 2) {
            registroStatsEnemigo = "\nNUMERO DE HABITACION: "+numeroHabitacion+" | TIPO DE CARTA: DRAGON"+" | VIDA: " +(int)(vida*100) + " | ATAQUE: " +(int)( ataque*100) + " | DEFENSA: " +(int)(defensa*100)+"\n";
        }
        return registroStatsEnemigo;
    }

        
}
