Feature: Opcion solo ida o ida y regreso

Scenario: Seleccionar solo ida satisfactoriamente
  Given Un usuario en la vista busqueda de vuelo6
   When selecciona la opcion solo ida
    And llena todos los campos correctamente
   Then Se muestra los vuelos que coincidan con su busqueda

Scenario: Seleccionar ida y vuelta satisfactoriamente
  Given Un usuario en la vista busqueda de vuelo6
   When selecciona la opcion ida y regreso
    And llena todos los campos correctamente2
   Then Se muestra los vuelos que coincidan con su busqueda en ida y regreso

Scenario: Busqueda por ida
  Given Un usuario en la vista busqueda de vuelo6
   When selecciona la opcion solo ida
   Then se habilita unicamente del campo la fecha de ida