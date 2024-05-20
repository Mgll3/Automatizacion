package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.ConfirmPassengersToFind;
import co.com.udea.certificacion.autenticacion.interactions.FillCitiesOneWayToFind;
import co.com.udea.certificacion.autenticacion.interactions.SearchFlyToFind;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class EnterThe implements Task {

    private String city;

    private String city2;

    public EnterThe(String city, String city2) {
        this.city = city;
        this.city2 = city2;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //llenar ciudades

        actor.attemptsTo(FillCitiesOneWayToFind.inTextField());

    }

    public static EnterThe cities(String city1, String city2){
        return Tasks.instrumented(EnterThe.class,city1,city2);
    }





}
