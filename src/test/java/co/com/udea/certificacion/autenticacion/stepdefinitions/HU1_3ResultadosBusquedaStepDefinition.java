package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.models.FlightDetail;
import co.com.udea.certificacion.autenticacion.questions.FlightDetailQuestions;
import co.com.udea.certificacion.autenticacion.questions.ValidationAllComponentsFlights;
import co.com.udea.certificacion.autenticacion.questions.ValidationResultFlights;
import co.com.udea.certificacion.autenticacion.tasks.EnterThe;
import co.com.udea.certificacion.autenticacion.tasks.OpenThe;
import co.com.udea.certificacion.autenticacion.tasks.SelectThe;
import co.com.udea.certificacion.autenticacion.tasks.SubmitThe;
import co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights;
import co.com.udea.certificacion.autenticacion.utils.Constants2;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.ehcache.shadow.org.terracotta.context.query.Matchers.allOf;
import static org.hamcrest.Matchers.*;

public class HU1_3ResultadosBusquedaStepDefinition {

    private final Actor user = Actor.named("User");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void init() {
        user.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("Un usuario en la vista busqueda de vuelo3")
    public void inTheSite() {
        user.attemptsTo(OpenThe.browser(new HomeFlights()));
    }

    @When("se envio la busqueda correctamente")
    public void searchFlights() {

        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY1));
        user.attemptsTo(SubmitThe.flight());
    }

    @Then("deben mostrarse los vuelos con horario de salida y llegada, el precio y el numero de escalas")
    public void canLookFlights() {
        FlightDetail flightDetail = user.asksFor(ValidationAllComponentsFlights.result());

        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat( FlightDetailQuestions.FlightDepartureTime.of(flightDetail), Matchers.containsString(Constants2.HOUR1)),
                GivenWhenThen.seeThat( FlightDetailQuestions.FlightArrivalTime.of(flightDetail), Matchers.containsString(Constants2.HOUR2)),
                GivenWhenThen.seeThat( FlightDetailQuestions.FlightPrice.of(flightDetail), Matchers.containsString(Constants2.PRICE)),
                GivenWhenThen.seeThat( FlightDetailQuestions.FlightStops.of(flightDetail), Matchers.containsString(Constants2.SCALE))
        );
    }
}

