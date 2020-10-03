package equipo3;

public class TrianguloCartas{
	
public void Triangulo(int cartaElegida, int cartaEnemiga, int numeroMovimientos){
	
	for(int i = 1; i <= numeroMovimientos; i +=1){
		
	if(Mago.getVida() != 0){	
	    if(cartaElegida == 0 && cartaEnemiga == 1){
	      CartaEnemiga.setVida() = (CartaEnemiga.getVida() - Mago.getAtaque()) + CartaEnemiga.getDefensa();
	    }
	    else if(cartaElegida == 0 && cartaEnemiga == 0){
	      CartaEnemiga.setVida() = (CartaEnemiga.getVida() - Mago.getAtaque()) + CartaEnemiga.getDefensa();
	    }
	    else if(cartaElegida == 0 && cartaEnemiga == 2){
	      Mago.setVida() = (Mago.getVida() - CartaEnemiga.getAtaque()) + Mago.getDefensa();
	    }
	}
	else{
	
	}
	if (Espada.getVida() != 0){	
	    else if(cartaElegida == 1 && cartaEnemiga == 2){
	      CartaEnemiga.setVida() = (CartaEnemiga.getVida() - Espada.getAtaque()) + CartaEnemiga.getDefensa();
	    }
	    else if(cartaElegida == 1 && cartaEnemiga == 1){
	      CartaEnemiga.setVida() = (CartaEnemiga.getVida() - Espada.getAtaque()) + CartaEnemiga.getDefensa();
	    }
	    else if(cartaElegida == 1 && cartaEnemiga == 0){
	      Espada.setVida() = (Espada.getVida() - CartaEnemiga.getAtaque()) + Espada.getDefensa();
	    }
	}
	else{
	
	}
	if(Dragon.getVida != 0){		
	    else if(cartaElegida == 2 && cartaEnemiga == 0){
	      CartaEnemiga.setVida() = (CartaEnemiga.getVida() - Dragon.getAtaque()) + CartaEnemiga.getDefensa();
	    }
	    else if(cartaElegida == 2 && cartaEnemiga == 2){
	      CartaEnemiga.setVida() = (CartaEnemiga.getVida() - Dragon.getAtaque()) + CartaEnemiga.getDefensa();
	    }
	    else if(cartaElegida == 2 && cartaEnemiga == 1){
	      Dragon.setVida() = (Dragon.getVida() - CartaEnemiga.getAtaque()) + Dragon.getDefensa();
	    }
	}
	else {
	
	}
	} 
}
}