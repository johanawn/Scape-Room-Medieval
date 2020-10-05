
public class Cartas{
String Tipo = "";
double vida = 0.0;
double defensa = 0.0;
double ataque = 0.0;

public void Carta(int numeroCarta){
	if(numeroCarta == 0){
	Tipo = "MAGO";
	vida = 1.0 ;
	defensa =  (Math.random() *5+1)*0.1;
        ataque =  (Math.random()*4+6)*0.1;
	}
	else if(numeroCarta == 1){
	Tipo = "ESPADA";
	vida = 1.0 ;
	defensa =  (Math.random() *5+1)*0.1;
        ataque =  (Math.random()*4+6)*0.1;
	}
	if(numeroCarta == 2){
	Tipo = "DRAGON";
	vida = 1.0 ;
	defensa =  (Math.random() *5+1)*0.1;
        ataque =  (Math.random()*4+6)*0.1;
	}
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
public String getTipo(){
	return Tipo;
}
public void setVida(double Vida1){
  this.vida = Vida1;
}
public void setDefensa(double Defensa1){
  this.defensa = Defensa1;
}
public void setAtaque(double Ataque1){
  this.ataque = Ataque1;
}



}
	

