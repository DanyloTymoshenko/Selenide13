package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.*;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import io.qameta.allure.Step;

import java.util.List;
import org.openqa.selenium.By;
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
  public void typeInSearchImage() {
    page().inputSearchImages("Io N1 / error");
  }

  @Step
  public void typeInRatingFrom() {
    page().inputRatingFrom("1");
  }

  @Step
  public void typeInRatingTo() {
    page().inputRatingTo("5");
  }

  @Step
  public void typeInPriceFrom() {
    page().inputPriceFrom("1");
  }

  @Step
  public void typeInPriceTo() {
    page().inputPriceTo("100");
  }

  @Step
  public void PressSearch() {
    page().pressSearch();
  }

  @Step
  public void PressReset() {
    page().pressReset();
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
    List<String> cells = $$("#" + addressId + " td")
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
  public void deleteAddress() {
    page().deleteAddress();
  }

  /// CARDS
  String cardId = "trCard_1234212112211211";

  @Step
  public void getcardPage() {
    page().clickCards();
  }

  @Step
  public void getAddCardPage() {
    page().clickAddCards();
  }

  @Step
  public void clickCardEditLink() {
    $("#trCard_1234212112211211 > td:nth-child(2) > a").click();
  }

  @Step
  public void writeCardTableRowContentById() {
    List<String> cells = $$("#" + cardId + " td")
      .shouldBe(CollectionCondition.sizeGreaterThan(0))
      .texts();
    System.out.println("Card Row with ID [" + cardId + "] contains: ");
    for (int i = 0; i < cells.size(); i++) {
      System.out.println("  Card Row " + (i + 1) + ": " + cells.get(i));
    }
  }

  @Step
  public void editCard() {
    page().typeInCardNumber("1234 5678 9123 4567");
    page().typeInCardCode("123");
    page().typeInCardOwner("Test_Owner");
    page().typeInCardDate("2029-12-13");
    page().typeInCardNick("Rich_Card");
  }

  @Step
  public void deleteCard() {
    page().btnDeleteCard();
  }

  /// PURCHASING

  @Step
  public void selectImageToPurchase() {
    page().clickImageDetails();
  }

  @Step
  public void clickCart() {
    page().clickAddToCart();
    page().clickCart();
  }

  @Step
  public void setQuantity() {
    page().clickAddQuantity();
    page().clickAddQuantity();
    page().clickDecreaseQuantity();
  }

  @Step
  public void selectAddress() {
    page().selectAddress();
  }

  @Step
  public void selectPaymentCard() {
    page().selectPaymentCard();
  }

  @Step
  public void clickPurchase() {
    page().clickPurchase();
  }

  @Step
  public void clickEmpty() {
    page().clickEmpty();
    back();
  }

  @Step
  public void getTextUponPurchase() {
    System.out.println(page().getTextUponPurchase());
  }
}
