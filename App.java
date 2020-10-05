public class App{
    int cartaMala = 0;
    Cartas mago = new Cartas();
    Cartas espada = new Cartas();
    Cartas dragon = new Cartas();
    Cartas cartaEnemiga = new Cartas();
    Resultados resultados = new Resultados();
    InterfazScanner interfaz = new InterfazScanner();
    Habitacion habitacion = new Habitacion();
    Jugador maesito = new Jugador();
    
    public void ejecutar(){
          boolean salirDelJuego = false;
           String nombre = interfaz.pedirNombre();
            maesito.setNombre(nombre);
          mago.Carta(0);
          espada.Carta(1);
          dragon.Carta(2); 
          boolean jugar = true;
      while(jugar == true){
        int quiereJugar = interfaz.quiereJugar();
 
        if(quiereJugar == 2){
           
            
            cartaMala = interfaz.randomCartas();
            cartaEnemiga.Carta(cartaMala);
            habitacion.setNivelAgua(0.0);
            habitacion.cambiarNumeroHabitacion(true);
            habitacion.subirLetalidad();
            if(habitacion.getNumeroHabitacion() > 3){
                jugar = false;
                // LLAMAR A METODO DE INTERFAZ
                System.out.println("HAS GANADO! :)");
            }
            boolean seguirJugando = true;
            while(seguirJugando == true){
            

                String stats = resultados.toStringStats(maesito.getNombre(),maesito.getVida(), mago.getVida(), espada.getVida(), dragon.getVida(), habitacion.getNumeroHabitacion(), maesito.getMovimientos(), habitacion.getNivelAgua(), habitacion.getLetalidad());
                System.out.println(stats);
                // LLAMAR A METODO DE INTERFAZ
            
                int queHacer = interfaz.eleccionMovimiento();
                if(queHacer == 1){
                  
                  habitacion.subirAgua(habitacion.getLetalidad());
                  if(habitacion.getNivelAgua() == 1.0){
                    maesito.setVida(maesito.getVida()-(maesito.getVida()*habitacion.getLetalidad()));
                    
                
                  }
                  maesito.sumarMovimiento();
                  int cartaElegida = interfaz.elegirCarta();
                  int cantidadAtaques = interfaz.cantidadAtaques();
                  
                
                for(int i = 1; i <= cantidadAtaques; i +=1){	
	          if(mago.getVida() > 0){	
	            if(cartaElegida == 0 && cartaMala == 1){
	              cartaEnemiga.setVida((cartaEnemiga.getVida() - mago.getAtaque()) + cartaEnemiga.getDefensa());
	            }
	            else if(cartaElegida == 0 && cartaMala == 0){
	              cartaEnemiga.setVida((cartaEnemiga.getVida() - mago.getAtaque()) + cartaEnemiga.getDefensa());
	              mago.setVida((mago.getVida() - cartaEnemiga.getAtaque()) + mago.getDefensa());
	            }
	            else if(cartaElegida == 0 && cartaMala == 2){
	              mago.setVida((mago.getVida() - cartaEnemiga.getAtaque()) + mago.getDefensa());
	            }
	          }
	          else if (espada.getVida() > 0){	
	            if(cartaElegida == 1 && cartaMala == 2){
	              cartaEnemiga.setVida((cartaEnemiga.getVida() - espada.getAtaque()) + cartaEnemiga.getDefensa());
	            }
	            else if(cartaElegida == 1 && cartaMala == 1){
	              cartaEnemiga.setVida((cartaEnemiga.getVida() - espada.getAtaque()) + cartaEnemiga.getDefensa());
	              espada.setVida((espada.getVida() - cartaEnemiga.getAtaque()) + espada.getDefensa());
	            }
	            else if(cartaElegida == 1 && cartaMala == 0){
	              espada.setVida((espada.getVida() - cartaEnemiga.getAtaque()) + espada.getDefensa());
	            }
	          }
	          else if(dragon.getVida() > 0){		
	            if(cartaElegida == 2 && cartaMala == 0){
	              cartaEnemiga.setVida((cartaEnemiga.getVida() - dragon.getAtaque()) + cartaEnemiga.getDefensa());
	            }
	            else if(cartaElegida == 2 && cartaMala == 2){
	              cartaEnemiga.setVida((cartaEnemiga.getVida() - dragon.getAtaque()) + cartaEnemiga.getDefensa());
	              dragon.setVida((dragon.getVida() - cartaEnemiga.getAtaque()) + dragon.getDefensa());
	            }
	            else if(cartaElegida == 2 && cartaMala == 1){
	              dragon.setVida((dragon.getVida() - cartaEnemiga.getAtaque()) + dragon.getDefensa());
	            }
	          }
	          else {
	           seguirJugando = false; 
	           // LLAMAR A METODO DE INTERFAZ
	           System.out.println("\nLA CARTA QUE ELEGISTE YA NO TIENE VIDA");
	           }
	        } 
	       
	        
	         
	       } 
	       else if(queHacer==3){
	           seguirJugando = false;
	           jugar = false;
	       
	       }
	       else if(queHacer == 2){
	            System.out.println(resultados.toStringStats(maesito.getNombre(),maesito.getVida(), mago.getVida(), espada.getVida(), dragon.getVida(), habitacion.getNumeroHabitacion(), maesito.getMovimientos(), habitacion.getNivelAgua(), habitacion.getLetalidad()));
	           
	           }
	       if(cartaEnemiga.getVida() <= 0){
	            // LLAMAR A METODO DE INTERFAZ
	            System.out.println("\nHAS DERROTADO A LA HABITACION  " +habitacion.getNumeroHabitacion()+"\n");
	            seguirJugando = false;
	            jugar = true;
	            
	        }
	        else if((mago.getVida()<=0 || dragon.getVida()>0 || espada.getVida()>0)||(mago.getVida()<=0 || dragon.getVida()<=0 || espada.getVida()>0) || (mago.getVida()<=0 || dragon.getVida()>0 || espada.getVida()<=0) || (mago.getVida()>0 || dragon.getVida()>0 || espada.getVida()<=0) || (mago.getVida()>0 || dragon.getVida()<=0 || espada.getVida()>0) || (mago.getVida()>0 || dragon.getVida()>0 || espada.getVida()>0)){
                    seguirJugando = true;
	           }
	        else if (((mago.getVida()<=0 && dragon.getVida()<=0 && espada.getVida()<=0) || maesito.getVida() <= 0)){
	            // LLAMAR A METODO DE INTERFAZ
	           System.out.println("HAS PERDIDO :(");
	           seguirJugando = false;
	           jugar = false;
	        }
	       
	       else if((mago.getVida()<= habitacion.getLetalidad() && dragon.getVida()<= habitacion.getLetalidad() && espada.getVida()<= habitacion.getLetalidad())){
	           // LLAMAR A METODO DE INTERFAZ
	           System.out.println("HAS PERDIDO :(");
	           seguirJugando = false;
	           jugar = false;
	       }
	       
	      
                
                
            
            
            }
            
            
            
        
        }
        if(quiereJugar == 3){
          jugar = false;
        }
      
      }
      
      

    }
    
    

}
