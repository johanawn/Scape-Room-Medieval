

PROJECT TITLE: Scape Room Medieval 
PURPOSE OF PROJECT: Tarea Programada 1
VERSION or DATE: 09/10/2020
HOW TO START THIS PROJECT: Para dar comienzo al juego por consola se tendrá que escribir "consola" en el terminal, por lo contrario el juego se ejecutará con paneles.
AUTHORS: Saindell Sabrina Brenes Hernández Brenes C01309, Gabriel Bonilla Rivera C01252, Johana Wu Nie C08591


USER INSTRUCTIONS: 

##Juego Scape Room Medieval

**Reglas del Juego**

El jugador tendrá que derrotar las 3 cartas secretas(Aleatorea) que están protegiendo las 3 puertas de las habitaciones que tendrá presente el nivel del agua y la letalidad característica de cada una. Para poder escapar y ganar el juego tendrá que derrotar a las 3 cartas secretas. El jugador que más lejos ha llegado con la menor cantidad de movimientos y con más vida tendrá su puesto en el record.

Creaciones de las cartas :
 La vida inicial de las cartas es de 100%
 El ataque será un porcentaje aleatorio entre 60% y 100%
 La defensa será un porcentaje aleatorio entre 10% y 50%

No se le serán mostradas al jugador el porcentaje de ataque y defensa que tiene cada carta, y el tipo de las cartas secretas hasta que pierda o gane el juego.

Consideraciones:

El jugador entrará con un 100% de vida, para pasar a la siguiente habitación tendrá que derrotar a la carta secreta que lo protege.

Cuidado con los movimientos!
Se le va a sumar los movimiento cada vez que el jugador ataque a la carta secreta de la habitación.
Cada vez que llega a una nueva habitación, se resetea el nivel del agua a 0%, y sube dependiendo de los movimientos a una razón de la letalidad de la habitación, si el nivel del agua llega al 100% se empezará a bajar la vida del jugador basándose al igual con la letalidad de la habitación.

En cada habitacion tendrá su propia letalidad:
Primera habitacion : Letalidad 20%
Segunda habitacion : Letalidad 25%
Tercera habitacion : Letalidad 30%

Afectación de las Cartas:
El mago afecta la espada.
La espada afecta el dragon.
El dragon afecta el mago.
Se afecta entre sí los mismos tipos de cartas.

Formas de Perder:

1. La vida del jugador están menor o igual a 0%.
2. La vida de las 3 cartas del jugador están menor o igual a 0%.
3. La vida de las 3 cartas del jugador están menor que la letalidad de la habitacion en la que se encuentra.



**Pasos**

1. Existen dos formas de ejecución del juego, por consola o por paneles. Para dar comienzo al juego por consola se tendrá que escribir "consola" en el terminal, por lo contrario el juego se ejecutará con paneles.
2. Al inicio se brinda una breve bienvenida al juego y posteriormete pedirá el nombre del jugador
3. Luego, ofrecerá un menú (principal) que permite salir del juego (sale por completo), ver el record o iniciar el juego.
4. Posteriormete, si el jugador inicia el juego, se le entregará 3 cartas, un mago, un dragon y una espada.
5. Se le será mostrada primeramente las estadísticas antes de cada movimiento que son : el nombre del jugador, el nivel del vida del jugador y de las 3 cartas, el numero de habitacion en la que se encuentra, la letalidad de la habitacion y el nivel del agua.
6. Luego, aparecerá un menú de opciones, entre ellas, abandonar el juego(regresa al menú principal), ver el historial del juego (se le mostrará las estadísticas con cada movimiento que ha hecho en las partidas) o realizar un movimiento.
7. En la opción de realizar un movimiento, se le pedirá luego que escoja a una de sus tres cartas para atacar, y próximamente la cantidad de ataques que quiere realizar.
8. Al finalizar la partida, ya sea que ganó o perdió se le mostrará:

Vida de del jugador, de sus cartas y de las cartas secretas.
Ataque y defensa de las cartas del jugador y de las cartas secretas de cada habitacion.

9. Se le pedirá digitar  nuevamente un nombre y será considerado como un nuevo jugador y comienza el ciclo nuevamente.
