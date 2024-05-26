package co.com.udea.certificacion.autenticacion.interactions;

import co.com.udea.certificacion.autenticacion.utils.Constants2;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class DatesToFind implements Interaction {

    private String date;

    public DatesToFind (String date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(date).into(DEPARTURE_TEXTINPUT));

    }
    public static DatesToFind inTextInput(String date){
        return Tasks.instrumented(DatesToFind.class,date);
    }
}
