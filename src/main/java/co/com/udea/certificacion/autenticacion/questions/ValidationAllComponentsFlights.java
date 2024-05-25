package co.com.udea.certificacion.autenticacion.questions;

import co.com.udea.certificacion.autenticacion.models.FlightDetail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoSuchElementException;
import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class ValidationAllComponentsFlights implements Question<FlightDetail> {

    public ValidationAllComponentsFlights(){}

    @Override
    public FlightDetail answeredBy(Actor actor) {
        String departureTime = "";
        String arrivalTime = "";
        String price = "";
        String stop = "";
        try {

            departureTime = BrowseTheWeb.as(actor).find(DEPARTURE_TIME_HOUR).getText();
            arrivalTime = BrowseTheWeb.as(actor).find(ARRIVAL_TIME_HOUR).getText();
            price = BrowseTheWeb.as(actor).find(PRICE_FLIGHT).getText();
            stop = BrowseTheWeb.as(actor).find(FLIGHT_SCALE).getText();

            return new FlightDetail(departureTime, arrivalTime, price, stop);
        } catch (NoSuchElementException e) {
            return new FlightDetail(departureTime, arrivalTime, price, stop);

        }


    }

    public static  ValidationAllComponentsFlights  result() {
        return new ValidationAllComponentsFlights();
    }
}


