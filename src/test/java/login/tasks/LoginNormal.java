package login.tasks;

import login.ui.LoginForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import java.util.Base64;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginNormal implements Task {
    private String username;
    private String password;
    protected LoginNormal(String username, String password){
        this.username = username;
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        this.password = new String(decodedBytes);
    }

    public static LoginNormal Login(String username, String password) {
        return instrumented(LoginNormal.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(username).into(LoginForm.USERNAME_FIELD),
                Enter.keyValues(password).into(LoginForm.PASSWORD_FIELD),
                Hit.the(Keys.ENTER).into(LoginForm.PASSWORD_FIELD)
        );
    }
}
