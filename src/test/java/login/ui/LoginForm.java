package login.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginForm {
    public static Target LOGIN_GITHUB_BTN = Target.the("Sign in with github button").located(By.className("ht-btn--github"));
    public static Target LOGIN_GOOGLE_BTN = Target.the("Sign in with google button").located(By.className("ht-btn--google"));
    public static Target GITHUB_USERNAME_FIELD = Target.the("github username field").located(By.id("login_field"));
    public static Target GITHUB_PASSWORD_FIELD = Target.the("github password field").located(By.id("password"));
    public static Target USERNAME_FIELD = Target.the("username field").located(By.id("user_email"));
    public static Target PASSWORD_FIELD = Target.the("password field").located(By.id("user_password"));
}
