package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import lombok.val;
import org.testng.annotations.Test;

/**
 * Feature: User registration
 * As a guest user
 * I should be able to register new user account(sign-up) and use it to login into the application
 */
public class RegistrationTest extends BaseTest {

  /**
   * Scenario: Regular user is able to login
   */
  @Test(groups = { "smoke", "signup" }, enabled = false)
  public void testRegularUserIsAbleToLogin() {
    // Given user opens Registration page
    registrationSteps.openRegistrationPage();

    // When user types in some random values.
    val loginName = registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);

    // TODO: uncomment, debug, implement - make it working.
    registrationSteps.typeInto(RegistrationSteps.SearchFieldName.EMAIL);
    registrationSteps.typeInto(RegistrationSteps.SearchFieldName.PASSWORD);

    // TODO: And user hits the Register User button
    registrationSteps.pressRegisterButton();

    // Then Registration page the current one
    registrationSteps.verifyCurrentPageIsRegistration();

    // TODO: Then Successful registration message is displayed
    registrationSteps.verifySuccessfulRegistrationMessageIsDisplayed();

    // Then Successful registration message contains the login name used
    registrationSteps.verifySuccessfulRegistrationMessageContainsNewUsername(loginName);
    // TODO: Develop the rest of the scenario. E.g. login as new user etc.
  }

  /**
   * Scenario: Guest user is NOT able to register regular user account using some existing user account's name
   */
  @Test(groups = { "smoke", "signup" })
  public void testImpossibleToReUseEmailForRegistration() {
    //# TODO: Develop the rest of the scenario.

    // Existing Email -> Dv@rn.ik

    registrationSteps.openRegistrationPage();

    val loginName = registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    registrationSteps.typeIntoExistingEmail(RegistrationSteps.SearchFieldName.EMAIL);
    registrationSteps.typeInto(RegistrationSteps.SearchFieldName.PASSWORD);

    registrationSteps.pressRegisterButton();

    registrationSteps.verifyCurrentPageIsRegistration();

    registrationSteps.verifySuccessfulRegistrationMessageIsDisplayed();

    // Then Successful registration message contains the login name used
    registrationSteps.verifySuccessfulRegistrationMessageContainsNewUsername(loginName);
  }
}
