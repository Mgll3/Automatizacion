package co.com.udea.certificacion.autenticacion.tasks;

import co.com.udea.certificacion.autenticacion.interactions.DatesToFind;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectThe implements Task {

    private String date;

    public SelectThe(String date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        //ingresar
        actor.attemptsTo(DatesToFind.inTextInput(date));



    }
    public static SelectThe date(String date){

        return Tasks.instrumented(SelectThe.class,date);

    }

}

    



