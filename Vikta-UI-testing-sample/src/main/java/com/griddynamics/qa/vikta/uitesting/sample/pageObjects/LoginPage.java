package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Vikta's Login page
 */
public class LoginPage {

  //@FindBy(css = "#tfLoginname")
  private SelenideElement txtLoginname() {
    return $("#tfLoginname");
  }

  //@FindBy(id = "tfPassword")
  private SelenideElement txtPassword() {
    return $("#tfPassword");
  }

  // @FindBy(id = "btnSubmitLogin")
  private SelenideElement btnSubmitLogin() {
    return $("#btnSubmitLogin");
  }

  //@FindBy(id = "btnSubmitGoToHome")
  private SelenideElement btnGoToHome() {
    return $("#btnSubmitGoToHome");
  }

  //@FindBy(xpath = "//div[@class='login']//p[contains(@style, 'color: #FF1C19')]")
  private SelenideElement lblError() {
    return $("body > div > div > div > div > form > div:nth-child(3) > p");
  }

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

  SelenideElement errMessage() {
    return $("body > div > div > div > div > form > div:nth-child(3)");
  }

  public void tryLogin(String username, String password) {
    try {
      if (!WebDriverRunner.url().contains("/login")) {
        Selenide.open("/login");
      }
      txtLoginname().shouldBe(visible, enabled).clear();
      txtLoginname().setValue(username);
      txtPassword().shouldBe(visible, enabled).clear();
      txtPassword().setValue(password);
      btnSubmitLogin().shouldBe(enabled).click();
      if ($$("form p").stream().anyMatch(SelenideElement::isDisplayed)) {
        System.out.println("Login failed: incorrect username or password.");
      }
    } catch (Exception e) {
      System.err.println("Login attempt failed due to unexpected error: " + e.getMessage());
    }
  }

  public HomePage gotoHome() {
    btnGoToHome().click();

    return new HomePage();
  }

  public String getErrorMessage() {
    return lblError().getText();
  }

  public String getErrorWebElement() {
    return lblError().getText();
  }
}
