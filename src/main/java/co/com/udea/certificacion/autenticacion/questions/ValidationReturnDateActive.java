package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoSuchElementException;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.RESULT_FLIGHTS;
import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.RETURN_TEXTINPUT;

public class ValidationReturnDateActive implements Question<String> {

    public ValidationReturnDateActive(){}

    @Override
    public String answeredBy(Actor actor) {
        String msg = "";
        try {
            msg = BrowseTheWeb.as(actor).find(RETURN_TEXTINPUT).getText();
            return msg;
        } catch (NoSuchElementException e) {
            return msg;
        }


    }

    public static ValidationReturnDateActive result(){
        return new ValidationReturnDateActive();
    }

}
