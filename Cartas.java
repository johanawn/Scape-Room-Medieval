package equipo3;


/**
 * Write a description of class Cartas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cartas{
    private String tipo;
    private double vida;
    private double defensa;
    private double ataque;

    public Cartas(int numeroCarta){
         if (numeroCarta ==0){
            setTipo("MAGO");
        }
            else if (numeroCarta == 1){
                setTipo("ESPADA");
             }
                else if (numeroCarta == 2){
                setTipo("DRAGON");
             }
            setVida(1.0);
            setDefensa(  (Math.random() *5+1)*0.1);
            setAtaque((Math.random()*4+6)*0.1);
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
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
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

}
