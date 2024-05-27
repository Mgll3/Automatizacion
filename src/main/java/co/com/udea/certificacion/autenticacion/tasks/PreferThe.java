package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.DatesToFind;
import co.com.udea.certificacion.autenticacion.interactions.DatesToSearch;
import co.com.udea.certificacion.autenticacion.interactions.FillCitiesOneWayToFind;
import co.com.udea.certificacion.autenticacion.interactions.FillCitiesRoundTripToFind;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class PreferThe implements Task {

    private String date1;
    private String date2;

    public PreferThe(String date1, String date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(DatesToSearch.inTextInput(date1,date2));
    }
    public static PreferThe dates(String date1, String date2){
        return Tasks.instrumented(PreferThe.class,date1,date2);
    }
}
