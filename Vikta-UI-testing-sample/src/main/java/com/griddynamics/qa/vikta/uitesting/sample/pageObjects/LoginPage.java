package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Vikta's Login page
 */
public class LoginPage {

  @FindBy(css = "#tfLoginname")
  private WebElement txtLoginname;

  @FindBy(id = "tfPassword")
  private WebElement txtPassword;

  @FindBy(id = "btnSubmitLogin")
  private WebElement btnSubmitLogin;

  @FindBy(id = "btnSubmitGoToHome")
  private WebElement btnGoToHome;

  @FindBy(xpath = "//div[@class='login']//p[contains(@style, 'color: #FF1C19')]")
  private WebElement lblError;

  //TODO: Add [Sign-up] button.
  @FindBy(id = "btnSubmitGoRegistration")
  private WebElement btnSubmitGoRegistration;

  public void SubmitGoRegistration() {
    btnSubmitGoRegistration.click();
  }

  public HomePage login(String username, String password) {
    tryLogin(username, password);
    return new HomePage();
  }

  public void tryLogin(String username, String password) {
    $(txtLoginname).sendKeys(username);
    $(txtPassword).clear();
    $(txtPassword).sendKeys(password);

    btnSubmitLogin.click();
  }

  public HomePage gotoHome() {
    btnGoToHome.click();

    return new HomePage();
  }

  public String getErrorMessage() {
    return lblError.getText();
  }

  public WebElement getErrorWebElement() {
    return lblError;
  }
}
