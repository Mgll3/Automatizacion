package co.com.udea.certificacion.autenticacion.interactions;

import co.com.udea.certificacion.autenticacion.utils.Constants2;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class SearchFlyToFind implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(SEARCH_FLIGHT_BUTTON));

    }
    public static SearchFlyToFind withButton(){
        return new SearchFlyToFind();
    }

}
