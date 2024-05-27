package co.com.udea.certificacion.autenticacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeFlights extends PageObject  {

    public static final Target ORIGIN_TEXTINPUT = Target
            .the("origen del vuelo")
            .locatedBy("//*[@id='origin']");

    public static final Target DESTINATION_TEXTINPUT = Target
            .the("destino del vuelo")
            .locatedBy("//*[@id='destination']");

    public static final Target DEPARTURE_TEXTINPUT = Target
            .the("fecha ida del vuelo")
            .locatedBy("//*[@id='departureDate']");

    public static final Target RETURN_TEXTINPUT = Target
            .the("fecha regreso del vuelo")
            .locatedBy("//*[@id='returnDate']");

    public static final Target ADD_ADULT_BUTTON = Target
            .the("boton de agregar adulto")
            .locatedBy("//*[@id='addAdultButton']");

    public static final Target ADD_CHILD_BUTTON = Target
            .the("boton de agregar infante")
            .locatedBy("//*[@id='addChildButton']");

    public static final Target ADD_BABY_BUTTON = Target
            .the("boton de agregar bebe")
            .locatedBy("//*[@id='addBabyButton']");

    public static final Target SEARCH_FLIGHT_BUTTON = Target
            .the("boton de buscar vuelo")
            .locatedBy("//*[@id='submit']");

    public static final Target ROUND_TRIP_BUTTON = Target
            .the("boton ida y vuelta")
            .locatedBy("//*[@name='roundTrip']");

    public static final Target ONE_WAY_BUTTON = Target
            .the("boton solo ida")
            .locatedBy("//*[@name='oneWay']");

    public static final Target CONFIRM_PASSENGERS_BUTTON = Target
            .the("boton confirmar pasajeros")
            .locatedBy("//*[@id='confirmPassengers']");

    public static final Target PASSENGERS_BUTTON = Target
            .the("boton pasajeros")
            .locatedBy("//*[@id='passengers']");

    public static final Target RESULT_FLIGHTS = Target
            .the("Texto Resultados de Vuelo")
            .locatedBy("//*[@id='resultSpan']");

    public static final Target DEPARTURE_TIME_HOUR = Target
            .the("Hora de ida de Vuelo")
            .locatedBy("//*[@id='departure-time']");

    public static final Target ARRIVAL_TIME_HOUR = Target
            .the("Hora de llegada de Vuelo")
            .locatedBy("//*[@id='arrival-time']");

    public static final Target PRICE_FLIGHT = Target
            .the("Precio del Vuelo")
            .locatedBy("//*[@id='price-flight']");

    public static final Target FLIGHT_SCALE = Target
            .the("Escala del Vuelo")
            .locatedBy("//*[@id='fligth-scale']");

    public static final Target flightClassElement = Target
            .the("Flight class")
            .located(By.xpath("//*[contains(text(), 'Selecciona')]"));

    public static final Target FLIGHT_CLASS_ECONOMIC = Target
            .the("Precio por clase economica del Vuelo")
            .locatedBy("//*[@id='class-economico-button']");

    public static final Target FLIGHT_CLASS_EXECUTIVE = Target
            .the("Precio por clase ejecutiva el Vuelo")
            .locatedBy("//*[@id='class-ejecutivo-button']");

    public static final Target DIRECT_FLIGHT_BUTTON = Target
            .the("Boton de ordenar primero los vuelos directos")
            .locatedBy("/html/body/div/div/div[5]/div[1]/div/div[2]/button[1]");

    public static final Target BEST_PRICE_BUTTON = Target
            .the("Boton de ordenar por mejor precio")
            .locatedBy("/html/body/div/div/div[5]/div[1]/div/div[2]/button[2]");

    public static final Target DURATION_BUTTON = Target
            .the("")
            .locatedBy("/html/body/div/div/div[5]/div[1]/div/div[2]/button[3]");

    public static final Target FIRST_PRICE_TEXT = Target
            .the("")
            .locatedBy("/html/body/div/div/div[5]/div[3]/div[1]/div[7]/div");

    public static final Target SECOND_PRICE_TEXT = Target
            .the("")
            .locatedBy("/html/body/div/div/div[5]/div[3]/div[2]/div[7]/div");
}
