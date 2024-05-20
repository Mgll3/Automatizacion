package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.ConfirmPassengersToFind;
import co.com.udea.certificacion.autenticacion.interactions.SearchFlyToFind;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SubmitThe implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        //Confirmar pasajeros
        actor.attemptsTo(ConfirmPassengersToFind.withButton());
        //Busque
        actor.attemptsTo(SearchFlyToFind.withButton());

    }

    public static SubmitThe flight() {
        return Tasks.instrumented(SubmitThe.class);

    }

}
