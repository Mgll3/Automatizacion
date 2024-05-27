Feature: Ordenar los resultados de busqueda

Scenario: Ordenar los resultados de los vuelos por precio
Given Un usuario en la vista resultados de vuelo
When Selecciona la opción precio de forma descendente
Then Se muestra los vuelos ordenados que coincidan con el precio descendente

Scenario: Ordenar los resultados de los vuelos por número de escalas
Given Un usuario en la vista resultados de vuelo
When Selecciona la opción numero de escalas de forma descendente
Then Se muestra los vuelos ordenados que coincidan con el numero de escalas descendente

Scenario: Ordenar los resultados de los vuelos por duracion
Given Un usuario en la vista resultados de vuelo
When Selecciona la opción duracion de forma descendente
Then Se muestra los vuelos ordenados que coincidan con la duracion descendente