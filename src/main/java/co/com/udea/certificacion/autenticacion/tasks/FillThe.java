package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.FillCitiesRoundTripToFind;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FillThe implements Task {

    private String city;
    private String city2;

    public FillThe(String city, String city2) {
        this.city = city;
        this.city2 = city2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(FillCitiesRoundTripToFind.inTextField());
    }

    public static FillThe cities(String city1, String city2){
        return Tasks.instrumented(FillThe.class,city1,city2);
    }
}
