package co.com.udea.certificacion.autenticacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.DEPARTURE_TEXTINPUT;

public class DatesToSearch implements Interaction {

    private String date1;
    private String date2;

    public DatesToSearch(String date1, String date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(date1,date2).into(DEPARTURE_TEXTINPUT));
    }

    public static DatesToSearch inTextInput(String date1, String date2){
        return Tasks.instrumented(DatesToSearch.class,date1,date2);
    }
}
