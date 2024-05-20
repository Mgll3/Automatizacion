Feature: Filtrar los resultados de la búsqueda

Scenario: Filtrar los resultados de los vuelos por precio
  Given Un usuario en la vista resultados de vuelo
   When Selecciona un rango de precio
   Then Se muestra los vuelos que coincidan con su seleccion

Scenario: Filtrar los resultados de los vuelos por numero de escalas
  Given Un usuario en la vista resultados de vuelo
   When Selecciona un numero de escalas
   Then Se muestra los vuelos que coincidan con su seleccion

Scenario: Filtrar los resultados de los vuelos por horarios
  Given Un usuario en la vista resultados de vuelo
   When Selecciona un rango de horarios
   Then Se muestra los vuelos que coincidan con su seleccion