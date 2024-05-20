package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Valida que cualquier fecha sea posterior al actual
 * */
public class ValidateTheDate implements Question<Boolean> {

    private String date;

    public ValidateTheDate(String date){
        this.date = date;
    }

    public Boolean answeredBy(Actor actor) {

        String dateStr = date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date2 = LocalDate.parse(dateStr, formatter);

        /*
        if (LocalDate.now().isBefore(date2)){
            return Boolean.TRUE;

        }
         */
        return Boolean.FALSE;
    }

    public static ValidateTheDate originDate(String date) {
        return new ValidateTheDate(date);
    }


}
