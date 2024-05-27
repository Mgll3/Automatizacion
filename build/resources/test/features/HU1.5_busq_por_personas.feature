Feature: Busqueda por cantidad de personas

Scenario: Busqueda por cantidad de personas exitoso
  Given Un usuario en la vista busqueda de vuelo5
   When Selecciona la cantidad de adultos y ninios que viajaran
   Then Deberia mostrar los vuelos que coincidan con su busqueda de acuerdo a la cantidad de personas

Scenario: Busqueda por cantidad de adulto con niños exitoso
  Given Un usuario en la vista busqueda de vuelo5
  When Selecciona la cantidad de adultos y ninios que viajaran
  And La cantidad de infantes que viajan es menor a 7
  And la cantidad de adultos que viajan es minimo uno
  Then Deberia mostrar los vuelos que coincidan con su busqueda de acuerdo a la cantidad de personas

Scenario: Busqueda por cantidad de personas mayor a 8
  Given Un usuario en la vista busqueda de vuelo5
  When Selecciona la cantidad de adultos y ninios que viajaran
  And La suma de ambos campos es mayor que 8
  Then no lo dejaria buscar3
