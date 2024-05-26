package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidationClassPricesFlights;
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
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static co.com.udea.certificacion.autenticacion.userinterfaces.HomeFlights.flightClassElement;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.*;

public class HU1_5_1VisualVueloPorClaseStepDefinition {

    private final Actor user = Actor.named("User");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void init() {
        user.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("Un usuario en la vista busqueda de vuelo5.1")
    public void inTheSite() {
        user.attemptsTo(OpenThe.browser(new HomeFlights()));
    }

    @When("Realiza una busqueda de vuelos")
    public void searchFlightsForHU1_5_1() {
        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(SubmitThe.flight());

        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Escala')]")));
        Target directFlightElement = Target.the("Direct flight button")
                .located(By.xpath("//*[contains(text(), 'Escala')]"));
        user.attemptsTo(Click.on(directFlightElement));
    }

    @Then("Deben mostrarse los vuelos disponibles con las clases en los resultados")
    public void FindFlightsClass() {

        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Selecciona')]")));
        user.should(seeThat(Text.of(flightClassElement), containsString("Selecciona")));
    }

    @Then("Deben mostrarse los vuelos disponibles con las clases en los resultados y reflejar el cambio en precio entre clases")
    public void FindFlightsAndChangePricesClass() {

        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Selecciona')]")));
        user.should(seeThat(Text.of(flightClassElement), containsString("Selecciona")));
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationClassPricesFlights.arePricesDifferent(),
                        Matchers.is(true)
                ));
    }
}

