# Alpaca Emblem

Alpaca Emblem es la implementacion de un juego de estrategia por turnos, donde participan dos jugadores en este
se encuentran unidades e items que pueden equipar estos. El objetivo principal de este videojuego es derrotar a la unidad
enemiga denominada Heroe.

## Interfaces

_Explicación del sistema de implementación de las interfaces._

### Creacion de interfaces y clases abstractas en los items

_Una de las principales ideas de esta tarea fue la implementación de diversas interfaces, para cada una de las entidades que 
participan en el codigo. Los item los podemos ver en tres tipos: armas fisicas, armas magicas y armas de curación, por ahora
poseen atributos muy parecidos, pero no actuan de la misma manera, a su vez estas interfaces son implementadas por cada clase 
abstracta(fisica, magica y de curación). Por otro lado las unidades implementan la misma interface y clase abstracta Unit, pues 
todas actuan de la misma manera._

| Interfaces    | Tipos de Armas |
| ------------- | -------------  |
| IAttackItem   | Fisicas        |
| IMagic        | Magicas        |
| IHeal         | Curación       |


_A su vez estas interfaces extienden a la interface que representa a todos los items, la cual se denomina IEquipableItem_




## Implementación de las Armas magicas

_La implementación de los libros magicos (light, dark y anima) se basaron en las clases LightBook, DarkBook y AnimaBook, estas
son hijas de la clase abstracta AbstractBook, la cual a su vez implementa la interfaz IMagic, la idea principal de esta,
es que contengan todos los parametros necesarios que deba poseer un tipo de libro magico (daño, counters, etc)._

## Implementación del Sorcerer

_La implementación del Sorcerer es muy parecida a las demas unidades, pues poseen parametros similares a las demas unidades, una
de las unicas diferencias que presenta son el tipo de armas que puede equipar, estas son las Armas Magicas(libros), esta unidad recibe los parametros de hitPoints, movement, location, maxItems, List items y a su vez implementa la interfaz de IUnit._


## Implementación del sistema de combate

_El sistema de combate se basa principalmente en un ataque y contrataque, una unidad con un arma equipada (dependiendo de la clase), podra atacar a una unidad enemiga siempre y cuando esta a la distancia correspondiente al arma, este ataque dependera 
del arma que posea el enemigo, pues el daño se calcula con el daño del arma equipada considerando si esta es fuerte o debil al arma del enemigo._


### Diseño

El diseño se basa principalmente en la metodologis del Doble Dispatch

_   _

## Implementación del sistema de Intercambio

## Cambios al programa inicial

## Detalles de implementación



### Supuestos realizados



### Como ejecutarlo

### Patrones de diseño
