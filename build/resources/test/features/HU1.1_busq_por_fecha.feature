Feature: Busqueda por fecha

Scenario: Busqueda por fecha exitosa
  Given Un usuario en la vista busqueda de vuelo
   When selecciona las fechas del vuelo
    #And son posteriores al día actual
   Then debe mostrarse los vuelos que coincidan con su busqueda

Scenario: Busqueda de fecha anterior al día actual
  Given Un usuario en la vista busqueda de vuelo
   When intenta seleccionar las fechas del vuelo para un dia anterior al actual
   Then las fechas estarian bloqueadas y no las podria seleccionar

Scenario: Busqueda sin fecha
  Given Un usuario en la vista busqueda de vuelo
   When no selecciona las fechas del vuelo
   Then no lo dejaria buscar