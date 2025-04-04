package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

/**
 * Home page related step Definitions
 */
public class HomePageSteps extends BaseSteps {

  public HomePageSteps(WebDriver driver) {
    super(driver);
  }

  private HomePage page() {
    return getPage(HomePage.class);
  }

  @Step
  public void typeInSearchImage(){
    page().InputSearchImages("T-50");
  }
  @Step
  public void typeInRatingFrom(){
    page().InputRatingFrom("1");
  }
  @Step
  public void typeInRatingTo(){
    page().InputRatingTo("5");
  }
  @Step
  public void typeInPriceFrom(){
    page().InputPriceFrom("1");
  }
  @Step
  public void typeInPriceTo(){
    page().InputPriceTo("100");
  }
  @Step
  public void PressSearch(){
    page().PressSearch();
  }
  @Step
  public void PressReset(){
    page().PressReset();
  }

}
