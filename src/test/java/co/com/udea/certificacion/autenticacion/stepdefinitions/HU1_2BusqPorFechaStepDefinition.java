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

public class HU1_2BusqPorFechaStepDefinition {

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

    @Given("Un usuario en la vista busqueda de vuelo")
    public void inTheSite(){
        user.attemptsTo(OpenThe.browser(new HomeFlights()));
    }

    @When("selecciona las fechas del vuelo")
    public void selectFlightsDates(){

        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        //Envio la fecha aca para poder enviar la fecha que se quiera desde afuera
        user.attemptsTo(SelectThe.date(Constants2.DATE1));
        user.attemptsTo(SubmitThe.flight());

    }

    /*
    @And("son posteriores al día actual")
    public void areAfterToday(){

        Boolean isDateAfterToday = ValidateTheDate.originDate(Constants2.DATE1).answeredBy(user);


        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidateTheDate.originDate(Constants2.DATE1),
                        Matchers.is(Boolean.TRUE)));

    }
    */

    @Then("debe mostrarse los vuelos que coincidan con su busqueda")
    public void canLookFlights(){

        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.containsString(Constants2.FLIGHT_RESULT)));
    }

    @When("intenta seleccionar las fechas del vuelo para un dia anterior al actual")
    public void selectBadFlightsDates(){

        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(SelectThe.date(Constants2.BAD_DATE));
        user.attemptsTo(SubmitThe.flight());

    }

    @Then("las fechas estarian bloqueadas y no las podria seleccionar")
    public void canNotLookFlights(){
        //Busco que no se muestre el mensaje de que encontro vuelos
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.not(Matchers.containsString(Constants2.FLIGHT_RESULT))));
    }

    // Se llenan todos los campos menos las fechas
    @When("no selecciona las fechas del vuelo")
    public void notSelectFlightsDates(){

        user.attemptsTo(EnterThe.cities(Constants2.CITY1, Constants2.CITY2));
        user.attemptsTo(SubmitThe.flight());

    }

    //Busca que no se encuentren busquedas de vuelos
    @Then("no lo dejaria buscar")
    public void canNotFindFlights(){
        //Busco que no se muestre el mensaje de que encontro vuelos

        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidationResultFlights.result(),
                        Matchers.not(Matchers.containsString(Constants2.FLIGHT_RESULT))));
    }




}
