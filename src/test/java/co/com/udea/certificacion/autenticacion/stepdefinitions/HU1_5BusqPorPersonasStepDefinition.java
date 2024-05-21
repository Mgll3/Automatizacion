package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidationResultFlights;
import co.com.udea.certificacion.autenticacion.tasks.*;
import co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights;
import co.com.udea.certificacion.autenticacion.utils.Constants2;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class HU1_5BusqPorPersonasStepDefinition {

    private final Actor user = Actor.named("User");

    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void init(){
        user.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("Un usuario en la vista busqueda de vuelo5")
    public void inTheSite(){
        user.attemptsTo(OpenThe.browser(new HomeFlights()));
    }

    @When("Selecciona la cantidad de adultos y ninios que viajaran")
    public void selectPassengers() {
        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(ChooseThe.passengers(Constants2.ADULTS, Constants2.CHILD, Constants2.BABIES));
        user.attemptsTo(SubmitThe.flight());
    }

    @Then("Deberia mostrar los vuelos que coincidan con su busqueda de acuerdo a la cantidad de personas")
    public void canLookFlights(){

        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.containsString(Constants2.FLIGHT_RESULT)));

    }


}
