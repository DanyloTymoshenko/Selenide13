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
  private String password = "123";

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
}
