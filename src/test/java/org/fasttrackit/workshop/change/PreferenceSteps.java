package org.fasttrackit.workshop.change;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.Preferences.PreferencesView;
import org.fasttrackit.workshop.login.LoginSteps;
import org.fasttrackit.workshop.testy.LoginView;

/**
 * Created by lucian.micu on 7/4/2015.
 */
public class PreferenceSteps extends TestBase {
    private PreferencesView preferencesView = new PreferencesView();

    @And("^I input current password$")
    public void I_input_current_password() {
       preferencesView.inputCurrent("eu.pass");;
    }

    @And("^I input new password$")
    public void I_input_new_password() {
        preferencesView.inputNewPass("eu.p");
    }

    @And("^I confirm the new password$")
    public void I_confirm_the_new_password() {
        preferencesView.repeatPass("eu.p");
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button() throws Throwable {
        preferencesView.doSave();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void I_should_see_message(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I close the Preferences window$")
    public void I_close_the_Preferences_window() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^I can re-login with new credentials$")
    public void I_can_re_login_with_new_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^I successfully login$")
    public void I_successfully_login() throws Throwable {

        new LoginView().enterCredentials(LoginSteps.VALID_EMAIL, LoginSteps.VaALID_PASS);
        new LoginView().clickOnLoginButton();
    }

    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() throws Throwable {
        preferencesView.open();
    }
}
