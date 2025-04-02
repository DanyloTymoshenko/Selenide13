package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AdminSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import com.griddynamics.qa.vikta.uitesting.sample.tests.AdminTest;
import io.qameta.allure.Step;
import lombok.val;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

  /*@Test(groups = { "smoke", "login" })
  public void testAdminUserIsAbleToLogin() {
    // Given user opens Login page
    loginSteps.openLoginPage();

    // When user logins as ADMIN user
    loginSteps.loginAsAdmin();

    // Then Home is displayed for the ADMIN user
    loginSteps.verifyCurrentPageIsHomePageForTheAdmin();
  }*/

  @Test
  public void testAdminGetUserTable() {
    loginSteps.openLoginPage();

    // When user logins as ADMIN user
    loginSteps.loginAsAdmin();

    System.out.println("START ADMIN TEST");
    adminSteps.getUserPage();

    //adminSteps.getUser();
    System.out.println("FIND ALL CONTENT IN A ROW");
    adminSteps.getTableRowContentById();
    adminSteps.writeTableRowContentById();
    System.out.println("DELETE ROW");
    adminSteps.deleteRowById();
  }

  @Test
  public void testAdminUserEdit() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();

    adminSteps.getUserPage();
    adminSteps.clickUserProfileLink();

    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    registrationSteps.typeIntoExistingEmail(RegistrationSteps.SearchFieldName.EMAIL);
    registrationSteps.typeInto(RegistrationSteps.SearchFieldName.PASSWORD);
    adminSteps.typeIntoAvatar();

    adminSteps.clickSave();
  }

  @Test
  public void testAdminUserAdd() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();

    adminSteps.getAddUser();

    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    registrationSteps.typeIntoExistingEmail(RegistrationSteps.SearchFieldName.EMAIL);
    registrationSteps.typeInto(RegistrationSteps.SearchFieldName.PASSWORD);
    adminSteps.typeIntoAvatar();

    adminSteps.clickReset();

    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    registrationSteps.typeIntoExistingEmail(RegistrationSteps.SearchFieldName.EMAIL);
    registrationSteps.typeInto(RegistrationSteps.SearchFieldName.PASSWORD);
    adminSteps.typeIntoAvatar();

    adminSteps.clickSave();
  }
}
