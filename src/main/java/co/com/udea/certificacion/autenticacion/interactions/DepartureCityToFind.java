package co.com.udea.certificacion.autenticacion.interactions;

import co.com.udea.certificacion.autenticacion.utils.Constants2;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class DepartureCityToFind implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(ONE_WAY_BUTTON));

        actor.attemptsTo(Enter.theValue(Constants2.CITY1).into(ORIGIN_TEXTINPUT));
        actor.attemptsTo(Enter.theValue(Constants2.CITY2).into(DESTINATION_TEXTINPUT));
        actor.attemptsTo(Enter.theValue(Constants2.DATE1).into(DEPARTURE_TEXTINPUT));

        actor.attemptsTo(Click.on(SEARCH_FLIGHT_BUTTON));
    }
    public static DepartureCityToFind inTextInput(){
        return Tasks.instrumented(DepartureCityToFind.class);
    }
}
