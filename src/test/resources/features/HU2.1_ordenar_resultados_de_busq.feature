Feature: Ordenar los resultados de busqueda

Scenario: Ordenar los resultados de los vuelos por precio
Given Un usuario en la vista resultados de vuelo
When Selecciona la opcion precio de forma descendente
Then Se muestra los vuelos ordenados que coincidan con el precio descendente

Scenario: Ordenar los resultados de los vuelos por numero de escalas
Given Un usuario en la vista resultados de vuelo
When Selecciona la opcion numero de escalas de forma descendente
Then Se muestra los vuelos ordenados que coincidan con el numero de escalas descendente

Scenario: Ordenar los resultados de los vuelos por duracion
Given Un usuario en la vista resultados de vuelo
When Selecciona la opcion duracion de forma descendente
Then Se muestra los vuelos ordenados que coincidan con la duracion descendente