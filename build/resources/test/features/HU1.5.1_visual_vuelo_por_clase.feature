Feature: Visualizacion de vuelos por clase en los resultados

Scenario: Visualizacion de vuelos por clase en los resultados de busqueda
Given Un usuario en la vista busqueda de vuelo5.1
When Realiza una busqueda de vuelos
Then Deben mostrarse los vuelos disponibles con las clases en los resultados

Scenario: Cambio de visualizacion de clase en los resultados
Given Un usuario en la vista busqueda de vuelo5.1
When Realiza una busqueda de vuelos
Then Deben mostrarse los vuelos disponibles con las clases en los resultados y reflejar el cambio en precio entre clases