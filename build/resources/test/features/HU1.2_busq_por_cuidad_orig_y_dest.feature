Feature: Busqueda de vuelos por ciudades de origen y destino

Scenario: Busqueda por ciudades exitosa
  Given Un usuario en la vista busqueda de vuelo2
   When selecciona las ciudades preestablecidas de origen y destino
   Then deberia mostrarse los vuelos que coincidan con su busqueda

Scenario: Busqueda por la misma ciudad de origen y destino
  Given Un usuario en la vista busqueda de vuelo2
   When selecciona la misma ciudad de origen y destino
   Then le indicaria al usuario que debe seleccionar un destino diferente al origen

Scenario: Busqueda sin ciudades
  Given Un usuario en la vista busqueda de vuelo2
   When no selecciona las ciudades de origen y destino
   Then no lo dejaria buscar2