package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_old.Thathe;
import org.apache.xpath.SourceTree;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps extends TestBaseNative {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    @Given("^I open login page$")
    public void I_open_login_page() {
        driver.get("file:///D:/Testy/src/test/functional/login.html");

        //loginPage = PageFactory.initElements(driver, LoginPage.class);
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
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }

    @And("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
       WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("eu@fast.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("eu.pass");

        Utils.sleep(2000);
    }

    @When("^I click login button$")
    public void I_click_login_button() throws Throwable {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        Utils.sleep(2000);
    }

    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() throws Throwable {
        boolean successsfullLogin = false;
       WebElement logout = driver.findElement(By.linkText("Logout"));
        boolean succesLoggedIn = logout.isDisplayed();("Could not find logout button", succesLoggedIn, is(true));
    }

    @And("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I expect invalid credentials message$")
    public void I_expect_invalid_credentials_message() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
