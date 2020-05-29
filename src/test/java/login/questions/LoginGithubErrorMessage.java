package login.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the login github error message")
public class LoginGithubErrorMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).findBy("#login .flash-error").getText();
    }

    public static Question<String> value() { return new LoginGithubErrorMessage(); }
}
