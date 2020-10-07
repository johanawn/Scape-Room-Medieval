
public class Resultados{
    public String registro = "";
    public String historial = "";

    
    public String toStringStats( String nombre, double vidaJugador, double vidaMago, double vidaEspada, double vidaDragon, int numeroHabitacion, int numeroMovimientos, double nivelAgua, double letalidad){
    return "\nNOMBRE: "+nombre+"\nVIDA: "+ vidaJugador + "\n"+"\nVIDA MAGO: "+ vidaMago + "\nVIDA ESPADA: "+ vidaEspada + "\nVIDA DRAGON: "+ vidaDragon+ "\n"+"\nNUMERO HABITACION: "+numeroHabitacion+ "\nNUMERO DE MOVIMIENTOS: "+numeroMovimientos+ "\nNIVEL AGUA:"+ nivelAgua + "\nLETALIDAD: "+letalidad+"\n";
    }

    public String registroMago(double vidaMago, double ataqueMago, double defensaMago){
        String registroStats = "\nVIDA MAGO: "+ vidaMago + " | ATAQUE MAGO: " + ataqueMago+ " | DEFENSA MAGO: " + defensaMago ;
        return registroStats;
    }
    public String registroEspada(double vidaEspada, double ataqueEspada, double defensaEspada){
        String registroStats = "\nVIDA ESPADA: "+ vidaEspada + " | ATAQUE ESPADA: " + ataqueEspada+ " | DEFENSA ESPADA: " + defensaEspada ;
        return registroStats;
    }
    public String registroDragon(double vidaDragon, double ataqueDragon, double defensaDragon){
        String registroStats = "\nVIDA DRAGON: "+ vidaDragon + " | ATAQUE DRAGON: " + ataqueDragon+ " | DEFENSA DRAGON: " + defensaDragon ;
        return registroStats;
    }
    public String registroEnemiga(int numeroHabitacion, int tipo,double vida, double ataque, double defensa){
        String registroStatsEnemigo = "";
        if (tipo == 0) {
            registroStatsEnemigo = "\nNUMERO DE HABITACION: "+numeroHabitacion+" | TIPO DE CARTA: MAGO"+" | VIDA: " + vida + " | ATAQUE: " + ataque + " | DEFENSA: " + defensa;
        }
        else if (tipo == 1) {
            registroStatsEnemigo = "\nNUMERO DE HABITACION: "+numeroHabitacion+" | TIPO DE CARTA: ESPADA"+" | VIDA: " + vida + " | ATAQUE: " + ataque + " | DEFENSA: " + defensa;
        }
        else if (tipo == 2) {
            registroStatsEnemigo = "\nNUMERO DE HABITACION: "+numeroHabitacion+" | TIPO DE CARTA: DRAGON"+" | VIDA: " + vida + " | ATAQUE: " + ataque + " | DEFENSA: " + defensa;
        }
        return registroStatsEnemigo;
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

    




}
