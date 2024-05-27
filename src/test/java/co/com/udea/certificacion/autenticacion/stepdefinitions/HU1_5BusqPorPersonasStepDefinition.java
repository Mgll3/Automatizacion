package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidationPassengersCount;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class HU1_5BusqPorPersonasStepDefinition {

    private final Actor user = Actor.named("User");

    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver theDriver;

    private static final Logger logger = Logger.getLogger(HU1_5BusqPorPersonasStepDefinition.class.getName());

    @Before
    public void init(){
        user.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("Un usuario en la vista busqueda de vuelo5")
    public void inTheSite(){
        logger.info("Opening the browser to the home page.");
        user.attemptsTo(OpenThe.browser(new HomeFlights()));
    }

    @When("Selecciona la cantidad de adultos y ninios que viajaran")
    public void selectPassengers() {
        logger.info("Selecting the date.");
        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        logger.info("Entering the cities.");
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        logger.info("Choosing the number of passengers.");
        user.attemptsTo(ChooseThe.passengers(Constants2.ADULTS, Constants2.CHILD, Constants2.BABIES));
        logger.info("Submitting the flight search.");
        user.attemptsTo(SubmitThe.flight());
    }

    @When("La cantidad de infantes que viajan es menor a 7")
    public void validateChildrenCount() {
        logger.info("Validating the number of children.");
        assert Constants2.CHILD < 7 : "La cantidad de infantes debe ser menor a 7";
    }

    @When("la cantidad de adultos que viajan es minimo uno")
    public void validateAdultsCount() {
        logger.info("Validating the number of adults.");
        assert Constants2.ADULTS >= 1 : "Debe haber al menos un adulto";
    }

    @Then("Deberia mostrar los vuelos que coincidan con su busqueda de acuerdo a la cantidad de personas")
    public void canLookFlights() {

        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.containsString(Constants2.FLIGHT_RESULT)));

        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationPassengersCount.result(Constants2.ADULTS, Constants2.CHILD, Constants2.BABIES), Matchers.is(true)));
    }
}

