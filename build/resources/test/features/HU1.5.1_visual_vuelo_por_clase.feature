Feature: Visualizacion de vuelos por clase en los resultados

Scenario: Visualizacion de vuelos por clase en los resultados de busqueda
Given Un usuario en la vista busqueda de vuelo5.1
When Realiza una busqueda de vuelos
Then Deben mostrarse los vuelos disponibles con las clases en los resultados

#Scenario: Cambio de visualización de clase en los resultados
#Given Un usuario en la vista búsqueda de vuelo
#When Realiza una búsqueda de vuelos
#Then Deberían mostrarse los vuelos disponibles con la clase (económica o ejecutiva) indicada en los resultados y reflejar el cambio en el estilo y precio cuando la clase es distinta.