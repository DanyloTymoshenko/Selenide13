package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.codeborne.selenide.conditions.Enabled;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AdminSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import com.griddynamics.qa.vikta.uitesting.sample.tests.AdminTest;
import io.qameta.allure.Step;
import lombok.val;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

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
    //adminSteps.deleteRowById();
  }

  @Test
  public void testAdminUserEdit() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();

    adminSteps.getUserPage();
    adminSteps.clickUserProfileLink();

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

  @Test
  public void testAdminGetImageTable() {
    loginSteps.openLoginPage();

    // When user logins as ADMIN user
    loginSteps.loginAsAdmin();

    System.out.println("START ADMIN IMAGE TEST");
    adminSteps.getImagePage();

    //adminSteps.getUser();
    System.out.println("FIND ALL CONTENT IN A ROW");
    adminSteps.getImageTableRowContentById();
    adminSteps.writeImageTableRowContentById();
    // System.out.println("DELETE ROW");
    //adminSteps.deleteImageRowById();
  }

  @Test
  public void testAdminEditImage() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    System.out.println("IMAGE EDIT TEST");
    adminSteps.getImagePage();
    adminSteps.clickImageEditLink();

    adminSteps.editImage();

    adminSteps.clickSave();
  }

  @Test
  public void AddImage() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    adminSteps.AddImage();
    adminSteps.ImageAddTitle();
    adminSteps.editImage();
    adminSteps.clickReset();
    adminSteps.editImage();
    adminSteps.clickSave();
  }

  @Test
  public void testAdminGetCatTable() {
    loginSteps.openLoginPage();

    loginSteps.loginAsAdmin();

    System.out.println("START ADMIN CAT TEST");
    adminSteps.getCategoryPage();

    System.out.println("FIND ALL CONTENT IN A ROW");

    adminSteps.writeCatTableRowContentById();
    // System.out.println("DELETE ROW");
    //adminSteps.deleteCatRowById();
  }

  @Test
  public void AddCat() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    adminSteps.getAddCategoryPage();
    adminSteps.ImageAddTitle();
    adminSteps.editCat();
    adminSteps.clickReset();
    adminSteps.ImageAddTitle();
    adminSteps.editCat();
    adminSteps.clickSave();
  }

  @Test
  public void testAdminEditCat() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    System.out.println("CATEGORY EDIT TEST");
    adminSteps.getCategoryPage();
    adminSteps.clickCatEditLink();

    adminSteps.editCat();

    adminSteps.clickSave();
  }
}
