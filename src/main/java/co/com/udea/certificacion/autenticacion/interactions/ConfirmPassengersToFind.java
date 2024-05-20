package co.com.udea.certificacion.autenticacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class ConfirmPassengersToFind implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        //Click en el boton de pajaseros para sacar desplegable
        actor.attemptsTo(Click.on(PASSENGERS_BUTTON));
        actor.attemptsTo(Click.on(CONFIRM_PASSENGERS_BUTTON));

    }
    public static ConfirmPassengersToFind withButton(){
        return new ConfirmPassengersToFind();
    }
}
