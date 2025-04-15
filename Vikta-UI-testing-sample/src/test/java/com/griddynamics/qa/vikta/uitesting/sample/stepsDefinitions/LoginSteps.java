package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;

import com.codeborne.selenide.SelenideElement;
import com.griddynamics.qa.vikta.uitesting.sample.auxiliary.DriverManager;
import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Login functionality related steps.
 */
public class LoginSteps extends BaseSteps {

  private String baseUrl;

  public LoginSteps(WebDriver driver) {
    super(driver);
  }

  @Step
  public void openLoginPage() {
    System.out.println("NAVIGATION TO: " + data.loginPageUrl());
    getDriver().get(data.loginPageUrl());
  }

  @Step
  public void login(String username, String password) {
    page().login(username, password);
  }

  @Step
  public void loginAsRegularUser() {
    page().login(data.userName(), data.userPassword());
  }

  @Step
  public void loginAsAdmin() {
    page().login(data.adminName(), data.adminPassword());
  }

  @Step
  public void verifyCurrentPageIsHomePageForTheRegularUser() {
    verifyCurrentPageIsHomePageForTheUser(data.userName());
  }

  @Step
  public void verifyCurrentPageIsHomePageForTheAdmin() {
    verifyCurrentPageIsHomePageForTheUser(data.adminName());
  }

  @Step
  public void verifyErrorMessage(String expectedText) {
    SelenideElement errorElement = $$("form p").findBy(text(expectedText));
    errorElement.shouldBe(visible);
    assertThat(errorElement.getText())
      .as("Expected error message not shown or incorrect")
      .contains(expectedText);
  }

  //TODO: Think about generics etc instead of this.
  private LoginPage page() {
    return getPage(LoginPage.class);
  }
}
