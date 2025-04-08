package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.codeborne.selenide.*;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

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
  public void typeInSearchImage() {
    page().InputSearchImages("Io N1 / error");
  }

  @Step
  public void typeInRatingFrom() {
    page().InputRatingFrom("1");
  }

  @Step
  public void typeInRatingTo() {
    page().InputRatingTo("5");
  }

  @Step
  public void typeInPriceFrom() {
    page().InputPriceFrom("1");
  }

  @Step
  public void typeInPriceTo() {
    page().InputPriceTo("100");
  }

  @Step
  public void PressSearch() {
    page().PressSearch();
  }

  @Step
  public void PressReset() {
    page().PressReset();
  }

  @Step
  public void loopThroughCategories() {
    ElementsCollection categories = $$("#divCategoryNames > div");
    for (int i = 0; i < categories.size(); i++) {
      SelenideElement link = categories.get(i).$("a");
      String linkText = link.getText();
      System.out.println("Opening category: " + linkText);
      link.click();

      $("body").shouldBe(Condition.visible);

      Selenide.back();

      categories = $$("#divCategoryNames > div");
    }
  }

  String addressId = "trAddress_125";
  @Step
  public void getAddressesPage() {
    page().clickAddresses();
  }

  @Step
  public void getAddAddressesPage() {
    page().clickAddAddresses();
  }


  @Step
  public void clickAddressEditLink() {
    $(By.cssSelector("#trAddress_125 > td:nth-child(2) > a")).click();
  }



  @Step
  public void writeAddressesTableRowContentById() {
    List<String> cells = $$("#"+addressId + " td")
            .shouldBe(CollectionCondition.sizeGreaterThan(0))
            .texts();
    System.out.println("Address Row with ID [" + addressId + "] contains: ");
    for (int i = 0; i < cells.size(); i++) {
      System.out.println("  Address Row " + (i + 1) + ": " + cells.get(i));
    }
  }

  @Step
  public void editAddress() {
    page().typeInStreet("Test Street");
    page().typeInStreetAdd("Additional Street");
    page().typeInCity("Gondor");
    page().typeInRegionName("Mediterranean");
    page().typeInPostalCode("131313");
    page().typeInAddressNickname("Bastion");
  }

  @Step
  public void deleteAddress(){
    page().DeleteAddress();

  }






}
