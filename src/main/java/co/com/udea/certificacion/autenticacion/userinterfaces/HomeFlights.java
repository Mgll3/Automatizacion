package co.com.udea.certificacion.autenticacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

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


}
