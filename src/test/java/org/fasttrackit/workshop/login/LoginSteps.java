package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.testy.LoginView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    public static String VALID_EMAIL = "eu@fast.com";
    public static String VaALID_PASS = "eu.pass";


    LoginView loginView = new LoginView();

    @Given("^I open login page$")
    public void I_open_login_page() {
        driver.get("file:///D:/Products/app-demo/login.html");
    }

    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) {
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
    }

    @Given("^I open this URL \"([^\"]*)\"$")
    public void I_open_this_URL(String argument) throws Throwable {
        // Express the Regexp above with the code you wish you had

    }

    @Then("^I send (\\d+) into search field$")
    public void I_send_into_search_field(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("numarul este" + arg1);
    }

    @Given("^I acces the login page$")
    public void I_acces_the_login_page() throws Throwable {
        driver.get("file:///D:/Products/app-demo/login.html");
    }

    @Given("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
        loginView.enterCredentials(VALID_EMAIL, VaALID_PASS);

        Utils.sleep(2000);
    }

    @When("^I click login button$")
    public void I_click_login_button() throws Throwable {
        loginView.clickOnLoginButton();

    }

    public void clickOnLoginButton() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() throws Throwable {
        boolean successsfullLogin = false;
        WebElement btnlogout = driver.findElement(By.partialLinkText("Logout"));
        successsfullLogin = btnlogout.isDisplayed();
        assertThat(successsfullLogin, is(true));
    }


    @Given("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        I_credentials("eu@fast.com", "aa.pass");
        Utils.sleep(2000);
    }

    @Then("^I expect invalid credentials message$")
    public void I_expect_invalid_credentials_message() throws Throwable {
        errorMessageShouldBePresent("Please enter your password!");

    }

    private void errorMessageShouldBePresent(String msg) {
        WebElement error = driver.findElement(By.className("error-msg"));
        assertThat(error.getText(), is(msg));
    }


    @When("^I \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_credentials(String emailValue, String pass) throws Throwable {
        loginView.enterCredentials(emailValue, pass);
        Utils.sleep(2000);
    }

    @Then("^I expect \"([^\"]*)\" message$")
    public void I_expect_message(String msg) {
        errorMessageShouldBePresent(msg);
    }


    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String emailValue, String passValue) throws Throwable {
        I_credentials(emailValue, passValue);
    }
}
