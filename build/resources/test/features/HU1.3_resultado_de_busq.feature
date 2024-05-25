Feature: Resultados de Busqueda

Scenario: Mostrar Busqueda satisfactoriamente
  Given Un usuario en la vista busqueda de vuelo3
   When se envio la busqueda correctamente
   Then deben mostrarse los vuelos con horario de salida y llegada, el precio y el numero de escalas

Scenario: No existen resultados disponibles
  Given Un usuario en la vista busqueda de vuelo3
   When se envio la busqueda correctamente
    And no se encontraron resultados
   Then no se muestran vuelos disponibles