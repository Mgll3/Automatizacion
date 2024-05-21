package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.FillCitiesOneWayToFind;
import co.com.udea.certificacion.autenticacion.interactions.ChoosePassengersToFind;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ChooseThe implements Task  {

    private int adults;
    private int child;
    private int babies;

    public ChooseThe(int adults, int child, int babies) {
        this.adults = adults;
        this.child = child;
        this.babies = babies;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(ChoosePassengersToFind.withButtons(adults, child, babies));

    }

    public static ChooseThe passengers(int adults, int child, int babies){
        return new ChooseThe(adults, child, babies);
    }





}
