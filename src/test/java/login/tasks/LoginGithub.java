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

public class LoginGithub implements Task {
    private String username;
    private String password;
    protected LoginGithub(String username, String password){
        this.username = username;
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        this.password = new String(decodedBytes);
    }

    public static LoginGithub Login(String username, String password) {
        return instrumented(LoginGithub.class, username, password);
    }

    public static void main(String[] args) {
        String originalInput = "!Qw23er45t";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println(encodedString);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginForm.LOGIN_GITHUB_BTN),
                Enter.keyValues(username).into(LoginForm.GITHUB_USERNAME_FIELD),
                Enter.keyValues(password).into(LoginForm.GITHUB_PASSWORD_FIELD),
                Hit.the(Keys.ENTER).into(LoginForm.GITHUB_PASSWORD_FIELD)
        );
    }
}
