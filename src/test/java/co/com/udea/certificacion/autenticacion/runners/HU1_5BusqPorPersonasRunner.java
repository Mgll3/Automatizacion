package co.com.udea.certificacion.autenticacion.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/HU1.5_busq_por_personas.feature",
        glue = "co.com.udea.certificacion.autenticacion.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class HU1_5BusqPorPersonasRunner { }
