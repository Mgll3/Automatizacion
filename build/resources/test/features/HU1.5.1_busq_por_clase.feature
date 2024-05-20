Feature: Busqueda por clase

Scenario: Busqueda por clase exitoso
  Given Un usuario en la vista búsqueda de vuelo
   When Selecciona la clase economica o ejecutiva en la que viajara
   Then Deberia mostrarse los vuelos que coincidan con su búsqueda

Scenario: Cambio de busqueda por clase exitoso
  Given Un usuario en la vista búsqueda de vuelo
   When Selecciona una clase distinta a la actual
   Then Se muestra el vuelo con un cambio de estilo y de precio