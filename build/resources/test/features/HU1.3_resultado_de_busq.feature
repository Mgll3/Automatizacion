Feature: Resultados de Busqueda

Scenario: Mostrar Busqueda satisfactoriamente
  Given Un usuario en la vista busqueda de vuelo
   When se envio la busqueda correctamente
   Then debería mostrarse los vuelos con horario de salida y llegada, el precio, el numero de escalas y el número del vuelo

Scenario: No existen resultados disponibles
  Given Un usuario en la vista búsqueda de vuelo
   When se envio la búsqueda correctamente
    And no se encontraron resultados
   Then no se muestran vuelos disponibles