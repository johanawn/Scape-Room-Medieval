

import java.util.Scanner;


public class InterfazScanner{
	Scanner lector = new Scanner(System.in);
	Boolean iniciarJuego = false;
	boolean Jugar = false;
  
	
	
	public int quiereJugar(){
		
	
		System.out.println("Bienvenido a Scape Room Medieval\n1. Ver el historial del mejor juego hasta el momento.\n2. Entrar a la habitación 1 para iniciar su juego\n3. Salir y abandonar el juego ");
		int eleccion2 = 0;
		int eleccion;
	   
			
			try {
				eleccion = lector.nextInt();
				}
				catch(Exception e) {
		                 System.out.println("Recuerda que el rango es de 1 a 3");
					eleccion = 0;
					lector.next();
				}
		
			
			if (eleccion == 1) {
				eleccion = 0;
				eleccion2 = eleccion;
			}else {
				if (eleccion == 2) {
					eleccion = 1;
					eleccion2 = eleccion;
				}else {
					if (eleccion == 3) {
						eleccion = 2;
						eleccion2 = eleccion;
					}else {
						if (eleccion > 3 || eleccion <= 0) {
							   System.out.println("Fuera de rango");
						        quiereJugar();
						}
					}
				}
			}
			
	    	 
	
  
    
    return eleccion2;
}

	
	public String pedirNombre() {
		System.out.println("Digite su nombre");
		String nombre = lector.next();
		System.out.println(nombre+" se le ha entregado 3 carta: 1 MAGO, 1 ESPADA, 1 DRAGÓN\n");
		return nombre;
	}

	public int menuyRespuesta(){
		
		Scanner lector = new Scanner(System.in);
		System.out.println("1. Hacer un movimiento \n2. Ver registro histórico de su juego \n3.Abandonar el juego ");
		int respuesta;
		int respuesta2 = 0;
		try {
			respuesta = lector.nextInt();
			}
			catch(Exception e) {
	                 System.out.println("Recuerda que el rango es de 1 a 3");
				respuesta = 0;
				lector.next();
			
			}
		if (respuesta == 1) {
			respuesta = 0;
			respuesta2 = respuesta;
		}else {
			if (respuesta == 2) {
				respuesta = 1;
				respuesta2 = respuesta;
			}else {
				if (respuesta == 3) {
					respuesta = 2;
					respuesta2 = respuesta;
				}else {
					if (respuesta > 3 || respuesta <= 0) {
						   System.out.println("Fuera de rango");
					        quiereJugar();
					}
				}
			}
		}
	
    
		
		return respuesta2;
	}
	
	
	
	public int menuAtaque() {
		System.out.println("ELIJA LA CARTA PARA ATACAR \n Digite el numero de la opcion que desea \n 1.Mago \n 2.Dragon \n 3.Espada \n");
		int respuesta2;
	    int respuesta3 = 0;
	    try {
			respuesta2 = lector.nextInt();
			}
			catch(Exception e) {
	                 System.out.println("Recuerda que el rango es de 1 a 3");
				respuesta2 = 0;
				lector.next();
			
			}
		if (respuesta2 == 1) {
			respuesta2 = 0;
			respuesta3 = respuesta2;
		}else {
			if (respuesta2 == 2) {
				respuesta2 = 1;
				respuesta3 = respuesta2;
			}else {
				if (respuesta2 == 3) {
					respuesta2 = 2;
					respuesta3 = respuesta2;
				}else {
				
						if(respuesta2> 3 || respuesta2 <= 0) {
							 System.out.println("Fuera de rango");
						        menuAtaque();
						}
					
				}
			}
		}
	    
	
		return respuesta3;
	}
	
	
	public int CantidadDeAtaques() {
		System.out.println("ELIJA LA CANTIDAD DE ATAQUES QUE QUIERE REALIZAR");
		int cantidadDeAtaques;
		try {
			 cantidadDeAtaques = lector.nextInt();
		}
		catch (Exception e){
			cantidadDeAtaques = 1;
		}
		if ( cantidadDeAtaques < 0){
			cantidadDeAtaques = cantidadDeAtaques * -1;
		}
		return cantidadDeAtaques;
	}

	public void gana() {
		System.out.println("YEI!!! YOU WIN, BUT STILL A LOOSER");	
	}
	public void abandona() {
		System.out.println("BITCH");
	}
	public void pierde() {
		System.out.println("YOU ARE A LOOSER");
	}
	
	public void mostrarStats(int numeroHabitacion, double vidajugador, double vidaMago, double vidaDragon, double vidaEspada, double letalidad, double nivelAgua ){
	
		System.out.println("-HABITACION: "+ numeroHabitacion+ " -LETALIDAD: "+letalidad+" -NIVEL DE AGUA: "+nivelAgua+"\nTU VIDA: "+vidajugador+"\nVIDA DE SUS CARTAS: -MAGO: "+vidaMago+"% -ESPADA: "+vidaEspada+"% -DRAGON: "+vidaDragon+"%\n");
		
	}
	
	
	public void mostrarResultadoFinal(String vidajugador,String mago, String espada, String dragon, String habitacion){
		String estadisticasFinales = "JUGADOR\n"+vidajugador+"CARTAS\n"+mago+"\n"+espada+"\n"+dragon+"\n"+habitacion;
		System.out.println(estadisticasFinales);
		quiereJugar();
	}



	}
