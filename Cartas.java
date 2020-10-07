
public class Cartas{
private String tipo ;
private double vida ;
private double defensa ;
private double ataque ;

public Cartas(){
	setVida(1.0);
	setDefensa(Math.random() *0.4000000000000001 + 0.1);
	setAtaque((Math.random()*4.0000000000000001+6)*0.1);




}







	

	


public double getVida(){
	return vida;
}
public double getDefensa(){
	return defensa;
}
public double getAtaque(){
	return ataque;
}


public void setVida(double vida){
  this.vida = vida;
}
public void setDefensa(double defensa){
  this.defensa = defensa;
}
public void setAtaque(double ataque){
  this.ataque = ataque;
}


public void trianguloAfectacionMago(Cartas cartaEnemiga, int cartaMala, int numeroAtaques){

	if (cartaMala == 1 ) {
		for(int i = 1; i <= numeroAtaques; i +=1) {
			cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
		}
	}
	else if (cartaMala == 0) {
		for(int i = 1; i <= numeroAtaques; i +=1) {
			cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
			setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
		}
	}
	else if ( cartaMala == 2) {
		for(int i = 1; i <= numeroAtaques; i +=1) {
			setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
		}
	}

}
	public void trianguloAfectacionEspada(Cartas cartaEnemiga, int cartaMala, int numeroAtaques){

		if (  cartaMala == 2) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
			}
		} else if ( cartaMala == 1 ) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		} else if (  cartaMala == 0) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		}

	}
	public void trianguloAfectacionDragon(Cartas cartaEnemiga, int cartaMala, int numeroAtaques){

		if (cartaMala == 0) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
			}
		} else if ( cartaMala == 2) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				cartaEnemiga.setVida((cartaEnemiga.getVida() - getAtaque()) + cartaEnemiga.getDefensa());
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		} else if (cartaMala == 1) {
			for(int i = 1; i <= numeroAtaques; i +=1) {
				setVida((getVida() - cartaEnemiga.getAtaque()) + getDefensa());
			}
		}

	}



}
	

