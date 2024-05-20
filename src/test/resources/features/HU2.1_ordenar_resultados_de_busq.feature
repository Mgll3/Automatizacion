Feature: Ordenar los resultados de busqueda

Scenario: Ordenar los resultados de los vuelos por precio
Given Un usuario en la vista resultados de vuelo
When Selecciona la opción precio de forma ascendente ó descendente
Then Se muestra los vuelos ordenados que coincidan con su selección

Scenario: Ordenar los resultados de los vuelos por número de escalas
Given Un usuario en la vista resultados de vuelo
When Selecciona la opción número de escalas de forma ascendente o descendente
Then Se muestra los vuelos ordenados que coincidan con su seleccion

Scenario: Ordenar los resultados de los vuelos por duracion
Given Un usuario en la vista resultados de vuelo
When Selecciona la opción duración de forma ascendente o descendente
Then Se muestra los vuelos ordenados que coincidan con su selección