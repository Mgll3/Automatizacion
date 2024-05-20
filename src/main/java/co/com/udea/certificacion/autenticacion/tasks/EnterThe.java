package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.ConfirmPassengersToFind;
import co.com.udea.certificacion.autenticacion.interactions.DepartureCityToFind;
import co.com.udea.certificacion.autenticacion.interactions.SearchFlyToFind;
import co.com.udea.certificacion.autenticacion.interactions.wordToSearch;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class EnterThe implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        //ingresar
        actor.attemptsTo(DepartureCityToFind.inTextInput());

        //Confirmar pasajeros
        actor.attemptsTo(ConfirmPassengersToFind.withButton());

        //Busque
        actor.attemptsTo(SearchFlyToFind.withButton());

    }
    public static EnterThe flight(){

        return Tasks.instrumented(EnterThe.class);

    }

}

    



