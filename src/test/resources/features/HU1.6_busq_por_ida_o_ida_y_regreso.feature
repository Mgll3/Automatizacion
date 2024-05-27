Feature: Opcion solo ida o ida y regreso

Scenario: Seleccionar solo ida satisfactoriamente
  Given Un usuario en la vista busqueda de vuelo6
   When selecciona la opcion solo ida
    And llena todos los campos correctamente
   Then Se muestra los vuelos que coincidan con su busqueda

Scenario: Seleccionar ida y vuelta satisfactoriamente
  Given Un usuario en la vista busqueda de vuelo
   When selecciona la opcion ida y regreso
    And llena todos los campos correctamente2
   Then Se muestra los vuelos que coincidan con su busqueda en ida y regreso

#Scenario: El usuario no selecciona ningún campo
#  Given Un usuario en la vista búsqueda de vuelo
#   When No selecciona ninguna opción de vuelo, ida o ida y regreso
#   Then Se tiene predefinida la opción ida y regreso

#Scenario: Busqueda por ida
#  Given Un usuario en la vista búsqueda de vuelo
#   When Selecciona ida
#   Then Se habilitan únicamente los campos de la ubicación y la fecha de ida
#    And Los campos son obligatorios

#Scenario: Búsqueda por ida y regreso
#  Given Un usuario en la vista búsqueda de vuelo
#   When Selecciona ida y regreso
#   Then Se habilitan los campos de las ubicaciones y las fechas para la ida y el regreso
#    And Los campos son obligatorios