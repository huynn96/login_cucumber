package login.features.login;

import login.questions.LoginGithubErrorMessage;
import login.questions.LoginNormalErrorMessage;
import login.tasks.LoginGithub;
import login.tasks.LoginNormal;
import login.ui.LoginForm;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import login.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class LoginStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @After
    public void annaQuitTheWeb() {
        herBrowser.quit();
    }

    @Test
    public void login_success_with_github() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(LoginGithub.Login("huyteonb@gmail.com", "IVF3MjNlcjQ1dA=="));

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("CucumberStudio | Projects list"))));

    }

    @Test
    public void login_failed_with_github() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(LoginGithub.Login("huyteob@gmail.com", "IVF3MjNlcjQ1dA=="));

        then(anna).should(eventually(seeThat(LoginGithubErrorMessage.value(), containsString("Incorrect username or password."))));

    }

    @Test
    public void login_success_normal() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(LoginNormal.Login("huynnhu1996@gmail.com", "IVF3MjNlcjQ1dA=="));

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("CucumberStudio | Projects list"))));

    }

    @Test
    public void login_failed_normal() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(LoginNormal.Login("huyteob@gmail.com", "IVF3MjNlcjQ1dA=="));

        then(anna).should(eventually(seeThat(LoginNormalErrorMessage.value(), containsString("Invalid email or password."))));

    }
}