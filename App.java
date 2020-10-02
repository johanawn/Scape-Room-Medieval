public class App{

	
Cartas Mago = new Cartas();
Cartas Espada = new Cartas();
Cartas Dragon = new Cartas();
Cartas CartaEnemiga = new Cartas();

NumeroCeroDos random = new NumeroCeroDos();
	
Habitacion hab1 = new Habitacion();
Habitacion hab2 = new Habitacion();
Habitacion hab3 = new Habitacion();

Jugador player1 = new Jugador();

int randomEnemiga = random.ElegirCartaAleatoria();

CartaEnemiga.Carta(randomEnemiga);

Mago.Carta(0);
Espada.Carta(1);
Dragon.Carta(2);
	







}