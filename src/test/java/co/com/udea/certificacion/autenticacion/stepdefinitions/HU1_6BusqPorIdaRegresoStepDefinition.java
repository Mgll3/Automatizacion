package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidationResultFlights;
import co.com.udea.certificacion.autenticacion.tasks.EnterThe;
import co.com.udea.certificacion.autenticacion.tasks.OpenThe;
import co.com.udea.certificacion.autenticacion.tasks.SelectThe;
import co.com.udea.certificacion.autenticacion.tasks.SubmitThe;
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

public class HU1_6BusqPorIdaRegresoStepDefinition {

    private final Actor user = Actor.named("User");

    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void init(){
        user.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("Un usuario en la vista busqueda de vuelo6")
    public void inTheSite(){

        user.attemptsTo(OpenThe.browser(new HomeFlights()));

    }

    @When("selecciona la opcion solo ida")
    public void selectOneWay() {

        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(SubmitThe.flight());
    }

    @And("llena todos los campos correctamente")
    public void fillFields() {
        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(SubmitThe.flight());
    }

    //TODO: Validar que se muestren vuelos especificamente con su busqueda? o que se muestren vuelos y ya
    @Then("Se muestra los vuelos que coincidan con su busqueda")
    public void canLookFlights(){
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.containsString(Constants2.FLIGHT_RESULT)));

    }


}
