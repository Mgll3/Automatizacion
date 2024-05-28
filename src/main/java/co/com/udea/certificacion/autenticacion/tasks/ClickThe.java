package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.BestPriceToOrder;
import co.com.udea.certificacion.autenticacion.interactions.FillCitiesRoundTripToFind;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class ClickThe implements Task {

    private Target filterButton;
    public ClickThe(Target filterButton) {
        this.filterButton = filterButton;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(BestPriceToOrder.onClick(filterButton));
    }

    public static ClickThe filterButton(Target filterButton){
        return Tasks.instrumented(ClickThe.class,filterButton);
    }
}
