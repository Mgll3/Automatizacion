package co.com.udea.certificacion.autenticacion.stepdefinitions;

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
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class HU1_3ResultadosBusquedaStepDefinition {

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

    @Given("Un usuario en la vista busqueda de vuelo3")
    public void inTheSite(){
        user.attemptsTo(OpenThe.browser(new HomeFlights()));
    }

    @When("se envio la busqueda correctamente")
    public void searchFlights(){

        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY1));
        user.attemptsTo(SubmitThe.flight());

    }

    //NO deberia pasar, por que le falta el numero de vuelo
    @Then("deberia mostrarse los vuelos con horario de salida y llegada, el precio, el numero de escalas y el numero del vuelo")
    public void canLookFlights(){
        //TODO: validar que se muestre cada uno de los elementos en el then
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.containsString(Constants2.RESULT1)));
    }

}
