package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidateOrderResult;
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

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.*;
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
        user.attemptsTo(FillThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(PreferThe.dates(Constants2.DATE1, Constants2.DATE2));
        user.attemptsTo(SubmitThe.flight());
    }

    @When("Selecciona la opcion precio de forma descendente")
    public void bestPriceButton() {
        user.attemptsTo(ClickThe.filterButton(BEST_PRICE_BUTTON));
    }

    @Then("Se muestra los vuelos ordenados que coincidan con el precio descendente")
    public void bestPriceResult(){
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidateOrderResult.lessThan(FIRST_PRICE_TEXT, SECOND_PRICE_TEXT, " COP"),
                        Matchers.is(Boolean.TRUE)));
    }

    @When("Selecciona la opcion numero de escalas de forma descendente")
    public void lessHourButton() {
        user.attemptsTo(ClickThe.filterButton(DIRECT_FLIGHT_BUTTON));
    }

    @Then("Se muestra los vuelos ordenados que coincidan con el numero de escalas descendente")
    public void lessHourResult(){
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidateOrderResult.lessThan(FIRST_DURATION_TEXT, LAST_DURATION_TEXT, ""),
                        Matchers.is(Boolean.TRUE)));
    }

    @When("Selecciona la opcion duracion de forma descendente")
    public void durationButton(){
        user.attemptsTo(ClickThe.filterButton(DURATION_BUTTON));
    }

    @Then("Se muestra los vuelos ordenados que coincidan con la duracion descendente")
    public void DurationResult(){
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidateOrderResult.lessThan(FIRST_HOUR_TEXT, SECOND_HOUR_TEXT, ":"),
                        Matchers.is(Boolean.TRUE)));
    }
}
