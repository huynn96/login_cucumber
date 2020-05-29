package login.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the login normal error message")
public class LoginNormalErrorMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).findBy(".ht-alert__content").getText();
    }

    public static Question<String> value() { return new LoginNormalErrorMessage(); }
}
