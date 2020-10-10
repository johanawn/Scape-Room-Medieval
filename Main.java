/**
 * Main
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/10/2020
 */
public class Main{
    public static void main(String trigger[]){
        App app = new App();
        AppGrafica app1 = new AppGrafica();
        if(trigger.length > 0){
            if(trigger[0].equals("-consola")){
                app.ejecutar();
            }
            else{
                app1.ejecutar();
            }
        }
    }
}