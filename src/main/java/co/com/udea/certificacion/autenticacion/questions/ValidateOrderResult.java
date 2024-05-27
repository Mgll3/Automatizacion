package co.com.udea.certificacion.autenticacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateOrderResult implements Question<Boolean> {

    private Target less;
    private Target greater;
    private String suffix;

    public ValidateOrderResult(Target less, Target greater, String suffix){

        this.less = less;
        this.greater = greater;
        this.suffix = suffix;
    }

    public Boolean answeredBy(Actor actor) {
        int intLess = 0;
        int intGrather = 0;
        String stringLess = BrowseTheWeb.as(actor).find(less).getText();
        String stringGreater = BrowseTheWeb.as(actor).find(greater).getText();
        if (suffix != null && !suffix.isEmpty()) {
        stringLess = stringLess.replace(suffix, "");
        stringGreater = stringGreater.replace(suffix, "");}
        try{
            intLess = Integer.parseInt(stringLess);
            intGrather = Integer.parseInt(stringGreater);
        }catch(Exception e){
            return false;
        }
        return (intLess < intGrather);
    }

    public static ValidateOrderResult lessThan(Target less, Target greater, String suffix) {
        return new ValidateOrderResult(less,greater,suffix);
    }
}
