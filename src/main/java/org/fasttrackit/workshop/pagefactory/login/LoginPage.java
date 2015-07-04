package org.fasttrackit.workshop.pagefactory.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(how = How.ID, using = "email")
    private WebElement emailEl;

    @FindBy (how = How.ID, using = "loginButton")
    private WebElement loginButton;

    @FindBy (how = How.ID, using = "email")
    private WebElement email;

    @FindBy (how = How.ID, using = "password")
    private WebElement passEl;

    public void enterEmail(String email) {
        emailEl.sendKeys(email);
    }
    @FindBy (how = How.CLASS_NAME, using = "error-msg")
    private WebElement error;

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterCredentials(String emailValue, String pass) {
        email.sendKeys(emailValue);
        passEl.sendKeys(pass);
    }
    public void errorMessageShouldBePresent(String expectedMessage) {
       assertThat(error.getText(), is(expectedMessage));
}}

