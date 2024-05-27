package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.FLIGHT_PASSENGERS_COUNT;

public class ValidationPassengersCount implements Question<Boolean> {

    private final int adults;
    private final int children;
    private final int babies;

    public ValidationPassengersCount(int adults, int children, int babies) {
        this.adults = adults;
        this.children = children;
        this.babies = babies;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try{
        // Assuming that flight results contain elements with specific class or id to denote passengers count
         int flightResults = Integer.parseInt(BrowseTheWeb.as(actor).find(FLIGHT_PASSENGERS_COUNT).getText());
         int totalPassengers = adults + children + babies;
            return flightResults == totalPassengers;
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    public static ValidationPassengersCount result(int adults, int children, int babies) {
        return new ValidationPassengersCount(adults, children, babies);
    }
}

