package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.codeborne.selenide.conditions.Enabled;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AdminSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.HomePageSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import com.griddynamics.qa.vikta.uitesting.sample.tests.AdminTest;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

  private String name = "qq";
  private String password = "changeme";

  @Test
  public void testImageSearch() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();

    homePageSteps.typeInSearchImage();
    homePageSteps.typeInPriceFrom();
    homePageSteps.typeInPriceTo();
    homePageSteps.typeInRatingFrom();
    homePageSteps.typeInRatingTo();

    homePageSteps.PressReset();

    homePageSteps.typeInSearchImage();
    homePageSteps.typeInPriceFrom();
    homePageSteps.typeInPriceTo();
    homePageSteps.typeInRatingFrom();
    homePageSteps.typeInRatingTo();

    homePageSteps.PressSearch();
  }

  @Test
  public void testCategorySearch() {
    homePageSteps.loopThroughCategories();
  }

  @Test
  public void testEditAddress() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();

    homePageSteps.getAddressesPage();
    homePageSteps.writeAddressesTableRowContentById();
    homePageSteps.clickAddressEditLink();
    homePageSteps.editAddress();
    //homePageSteps.deleteAddress();
    //homePageSteps.editAddress();
    adminSteps.clickSave();
  }

  @Test
  public void testAddAddress() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();

    homePageSteps.getAddAddressesPage();
    homePageSteps.editAddress();
    adminSteps.clickReset();
    homePageSteps.editAddress();
    //homePageSteps.deleteAddress();
    //homePageSteps.editAddress();
    adminSteps.clickSave();
  }

  @Test
  public void testEditCard() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();

    homePageSteps.getcardPage();
    homePageSteps.writeCardTableRowContentById();
    homePageSteps.clickCardEditLink();
    homePageSteps.editCard();
    //homePageSteps.deleteCard();
    adminSteps.clickSave();
  }

  @Test
  public void testAddCard() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();

    homePageSteps.getAddCardPage();
    homePageSteps.editCard();
    adminSteps.clickReset();
    homePageSteps.editCard();
    adminSteps.clickSave();
  }

  /// PURCHASING
  @Test
  public void testBuyImage() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();

    homePageSteps.selectImageToPurchase();
    homePageSteps.clickCart();

    homePageSteps.setQuantity();
    homePageSteps.selectAddress();
    homePageSteps.selectPaymentCard();

    homePageSteps.clickEmpty();

    homePageSteps.clickCart();
    homePageSteps.setQuantity();
    homePageSteps.selectAddress();
    homePageSteps.selectPaymentCard();

    homePageSteps.clickPurchase();
    homePageSteps.getTextUponPurchase();
  }
}
