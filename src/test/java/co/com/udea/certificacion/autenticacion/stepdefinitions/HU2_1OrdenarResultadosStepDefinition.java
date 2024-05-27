package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidationResultFlights;
import co.com.udea.certificacion.autenticacion.tasks.*;
import co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights;
import co.com.udea.certificacion.autenticacion.utils.Constants2;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

public class HU2_1OrdenarResultadosStepDefinition {

    private final Actor user = Actor.named("User");

    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void init(){
        user.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("Un usuario en la vista resultados de vuelo")
    public void inTheSite() {
        user.attemptsTo(OpenThe.browser(new HomeFlights()));
    }

    @When("Selecciona la opción precio de forma descendente")
    public void preferOneWay() {
        //TODO
    }

    @Then("Se muestra los vuelos ordenados que coincidan con el precio descendente")
    public void canLookOneWayFlights(){
        //TODO
    }

    @When("Selecciona la opción numero de escalas de forma descendente")
    public void preferRoundTrip() {
        //TODO
    }

    @Then("Se muestra los vuelos ordenados que coincidan con el numero de escalas descendente")
    public void canLookRoundTripsFlights(){
        //TODO
    }

    @When("Selecciona la opción duracion de forma descendente")
    public void noSelectTrip(){
        //TODO
    }

    @Then("Se muestra los vuelos ordenados que coincidan con la duracion descendente")
    public void defautOption(){
        //TODO
    }
}
