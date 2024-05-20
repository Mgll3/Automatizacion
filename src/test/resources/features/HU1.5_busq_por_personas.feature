Feature: Busqueda por cantidad de personas

Scenario: Busqueda por cantidad de personas exitoso
  Given Un usuario en la vista busqueda de vuelo
   When Selecciona la cantidad de adultos y niños que viajarán
    And La cantidad total de adultos y niños es menor o igual a 8
   Then Debería mostrar los vuelos que coincidan con su búsqueda de acuerdo a la cantidad de personas

Scenario: Busqueda por cantidad de adulto con niños exitoso
  Given Un usuario en la vista búsqueda de vuelo
   When Selecciona la cantidad de adultos y niños que viajaran
    And La cantidad de niños que viajan es menor a 7
    And la cantidad de adultos que viajan es minimo uno
   Then Deberia mostrar los vuelos que coincidan con su busqueda de acuerdo a la cantidad de personas

Scenario: Busqueda por cantidad de personas mayor a 8
  Given Un usuario en la vista búsqueda de vuelo
   When Intenta seleccionar la cantidad de adultos y de niños
    And La suma de ambos campos es mayor que 8
   Then Saldria un mensaje de advertencia pidiendole al usuario una menor cantidad de personas