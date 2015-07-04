package org.fasttrackit.workshop.testy;

import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator emailEl = new WebLocator().setId("email");
    private WebLocator loginButton = new WebLocator().setId("loginButton");
    private WebLocator email = new WebLocator().setId("email");
    private WebLocator passEl = new WebLocator().setId("password");
    private WebLocator error = new WebLocator().setClasses("error-msg");

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterCredentials(String emailValue, String pass) {
        email.sendKeys(emailValue);
        System.out.println("Enter email:" + emailValue);
        passEl.sendKeys(pass);
        System.out.println("Enter pass:" + pass);
    }
    public void errorMessageShouldBePresent(String expectedMessage) {
       assertThat(error.getHtmlText(), is(expectedMessage));
}}

