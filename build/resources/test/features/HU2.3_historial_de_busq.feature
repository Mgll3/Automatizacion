Feature: Historial de busqueda

Scenario: Guardar historial de búsquedas de vuelos
  Given Un usuario registrado en la vista búsqueda de vuelo
   When Hace una busqueda exitosa
   Then Se guarda toda la información de esa busqueda

Scenario: Consultar historial de busquedas de vuelos
  Given Un usuario registrado en la vista historial de vuelos
   When Accede al historial de vuelos
   Then Se muestra el historial de sus busquedas de vuelos