package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoSuchElementException;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class ValidationClassPricesFlights implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String economicPrice = "";
        String executivePrice = "";

        try {
            economicPrice = BrowseTheWeb.as(actor).find(FLIGHT_CLASS_ECONOMIC).getText();
            executivePrice = BrowseTheWeb.as(actor).find(FLIGHT_CLASS_EXECUTIVE).getText();
        } catch (NoSuchElementException e) {
            // Handle exception as needed, possibly logging or setting default values
        }

        return !economicPrice.equals(executivePrice);
    }

    public static ValidationClassPricesFlights arePricesDifferent() {
        return new ValidationClassPricesFlights();
    }
}

