package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.RegistrationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Registration functionality related steps.
 */
public class RegistrationSteps extends BaseSteps {

  private static String SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX =
    "User has been registered successfully: ";

  public RegistrationSteps(WebDriver driver) {
    super(driver);
  }

  public enum FieldName {
    LOGINNAME,
    SURNAME,
    FIRSTNAME,
    PATRONIM,
    PASSWORD,
    AVATARURL,
  }

  public enum SearchFieldName { //for typeInto method
    PASSWORD,
    EMAIL,
  }

  @Step
  public void openRegistrationPage() {
    getDriver().get(data.registrationPageUrl());
  }

  @Step
  public void typeInto(SearchFieldName searchFieldName) {
    String returnValue;
    switch (searchFieldName) {
      case EMAIL:
        returnValue = "test@testAAA.com";
        page().typeInEmail(returnValue);
        break;
      case PASSWORD:
        returnValue = "123";
        page().typeInPassword(returnValue);
        break;
      default:
        throw new IllegalArgumentException(
          "Unsupported Registration page field name: " + searchFieldName
        );
    }
  }

  @Step
  public void typeIntoExistingEmail(SearchFieldName searchFieldName) {
    String returnValue;
    switch (searchFieldName) {
      case EMAIL:
        returnValue = "Dv@rn.ik";
        page().typeInEmail(returnValue);
        break;
      default:
        throw new IllegalArgumentException(
          "Unsupported Registration page field name: " + searchFieldName
        );
    }
  }

  @Step
  public String typeRandomValueInto(FieldName fieldName) {
    String valueToReturn;
    switch (fieldName) {
      case LOGINNAME:
        valueToReturn = generateRandomString(16);
        page().typeInLoginname(valueToReturn);
        break;
      case SURNAME:
        valueToReturn = generateRandomString(10);
        page().typeInSurname(valueToReturn);
        break;
      case FIRSTNAME:
        valueToReturn = generateRandomString(10);
        page().typeInFirstname(valueToReturn);
        break;
      case PATRONIM:
        valueToReturn = generateRandomString(12);
        page().typeInPatronim(valueToReturn);
        break;
      case PASSWORD:
        valueToReturn = generateRandomString(8);
        page().typeInPassword(valueToReturn);
        break;
      //TODO: Add the rest... .
      default:
        throw new IllegalArgumentException(
          "Unsupported Registration page field name: " + fieldName
        );
    }

    return valueToReturn;
  }

  //TODO: Add rest of the steps needed.

  @Step
  public void verifyCurrentPageIsRegistration() {
    assertCurrentPageUrl(
      data.registrationPageUrl(),
      "Registration page was expected to be the current one."
    );
  }

  @Step
  public void verifySuccessfulRegistrationMessageIsDisplayed() {
    getWait().until(ExpectedConditions.visibilityOf(page().getMessageWebElement()));
    // Have a look at https://assertj.github.io/doc/
    assertThat(page().getMessageText().trim())
      .as("Successful registration message was nor shown or had unexpected content.")
      .startsWith(SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX);
  }

  @Step
  public void verifySuccessfulRegistrationMessageContainsNewUsername(String loginnameUsed) {
    getWait().until(ExpectedConditions.visibilityOf(page().getMessageWebElement()));
    // Have a look at https://assertj.github.io/doc/
    assertThat(page().getMessageText().trim())
      .as("Successful registration message was expected to contain the new username used.")
      .contains(loginnameUsed);
  }

  public void pressRegisterButton() {
    page().clickbtnRegister();
  }

  //TODO: Think about generics etc instead of this.
  private RegistrationPage page() {
    return getPage(RegistrationPage.class);
  }
}
