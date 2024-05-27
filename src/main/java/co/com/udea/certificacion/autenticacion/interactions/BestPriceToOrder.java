package co.com.udea.certificacion.autenticacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class BestPriceToOrder implements Interaction {

    private Target filterButton;
    public BestPriceToOrder(Target filterButton) {
        this.filterButton = filterButton;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(filterButton));
    }
    
    public static BestPriceToOrder onClick(Target filterButton){
        return new BestPriceToOrder(filterButton);
    }
    
}
