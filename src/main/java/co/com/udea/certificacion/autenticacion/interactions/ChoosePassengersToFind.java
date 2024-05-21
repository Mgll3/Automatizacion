package co.com.udea.certificacion.autenticacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class ChoosePassengersToFind implements Interaction {

    private int adults;
    private int child;
    private int babies;

    public ChoosePassengersToFind(int adults, int child, int babies) {
        this.adults = adults;
        this.child = child;
        this.babies = babies;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(PASSENGERS_BUTTON));

        //i = 1 porque ya hay un adulto por defecto
        for (int i = 1; i < adults; i++) {
            actor.attemptsTo(Click.on(ADD_ADULT_BUTTON));
        }
        for (int i = 0; i < child; i++) {
            actor.attemptsTo(Click.on(ADD_CHILD_BUTTON));
        }
        for (int i = 0; i < babies; i++) {
            actor.attemptsTo(Click.on(ADD_BABY_BUTTON));
        }
        actor.attemptsTo(Click.on(CONFIRM_PASSENGERS_BUTTON));
    }

    public static ChoosePassengersToFind withButtons(int adults, int child, int babies){
        return new ChoosePassengersToFind(adults, child, babies);
    }



}
