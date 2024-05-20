package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;

public class ValidationResultFlights implements Question<String> {

    public ValidationResultFlights(){}

    @Override
    public String answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(RESULT_FLIGHTS).getText();
        return msg;
    }

    public static ValidationResultFlights result(){
        return new ValidationResultFlights();
    }

}
