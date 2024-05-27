package co.com.udea.certificacion.autenticacion.stepdefinitions;

import co.com.udea.certificacion.autenticacion.questions.ValidationResultFlights;
import co.com.udea.certificacion.autenticacion.tasks.EnterThe;
import co.com.udea.certificacion.autenticacion.tasks.SelectThe;
import co.com.udea.certificacion.autenticacion.tasks.OpenThe;
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
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class HU1_1BusqPorCiudadesStepDefinition {


    //actor
    private final Actor user = Actor.named("User");

    //driver
    @Managed(driver="chrome", uniqueSession = true)
    public WebDriver theDriver;

    //inicializar
    @Before
    public void init(){
        user.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
    }

    @Given("Un usuario en la vista busqueda de vuelo2")
    public void inTheSite(){

        user.attemptsTo(OpenThe.browser(new HomeFlights()));

    }

    @When("selecciona las ciudades preestablecidas de origen y destino")
    public void selectFlightDates(){
        //Envio la fecha aca para poder enviar la fecha que se quiera desde afuera
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(SubmitThe.flight());

    }

    @Then("deberia mostrarse los vuelos que coincidan con su busqueda")
    public void canLookFlights(){
        //TODO: aqui se comprueba unicamente si se muestran resultados no si coinciden con su busqueda
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.containsString(Constants2.FLIGHT_RESULT)));
    }

    @When("selecciona la misma ciudad de origen y destino")
    public void selectSameCity(){

        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY1));
        user.attemptsTo(SubmitThe.flight());

    }

    @Then("le indicaria al usuario que debe seleccionar un destino diferente al origen")
    public void shouldIndicateUser(){
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.not(Matchers.containsString(Constants2.FLIGHT_RESULT))));
    }

    @When("no selecciona las ciudades de origen y destino")
    public void selectNoCity(){

        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(SubmitThe.flight());

    }

    @Then("no lo dejaria buscar2")
    public void shouldNotLookFlights(){
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.allOf(
                                Matchers.not(Matchers.containsString(Constants2.FLIGHT_RESULT)),
                                Matchers.equalTo("")
                        )));

    }
}
