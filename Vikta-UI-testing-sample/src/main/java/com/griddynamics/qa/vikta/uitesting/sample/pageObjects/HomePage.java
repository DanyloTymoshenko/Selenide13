package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object of Home page
 */
public class HomePage extends BasePage {

  //TODO: Add more.

  @FindBy(xpath = "//*[@id=\"aUsers\"]")
  private WebElement aUsers;

  @FindBy(id = "tbTerm")
  private WebElement tbTerm;

  @FindBy(id = "tSelectedCategoryTitle")
  private WebElement tSelectedCategoryTitle;

  @FindBy(id = "tbRatingFrom")
  private WebElement tbRatingFrom;

  @FindBy(id = "tbRatingTo")
  private WebElement tbRatingTo;

  @FindBy(id = "tbRPriceFrom")
  private WebElement tbPriceFrom;

  @FindBy(id = "tbPriceTo")
  private WebElement tbPriceTo;

  @FindBy(id = "btnSearch")
  private WebElement btnSearch;

  @FindBy(id = "btnResetSearchCriteria")
  private WebElement btnResetSearchCriteria;

  // Side Categories

  @FindBy(id = "category1")
  private WebElement catEmpty;

  @FindBy(id = "category2")
  private WebElement catFull;

  @FindBy(id = "category3")
  private WebElement catMyth;

  @FindBy(id = "category4")
  private WebElement catCity;

  @FindBy(id = "category5")
  private WebElement catStreet;

  @FindBy(id = "category6")
  private WebElement catTech;

  @FindBy(id = "category7")
  private WebElement catWhoUN;

  @FindBy(id = "category8")
  private WebElement catVitamin;

  @FindBy(id = "category9")
  private WebElement catFiction;

  @FindBy(id = "category10")
  private WebElement catElectronic;

  @FindBy(id = "category11")
  private WebElement catSales;

  @FindBy(id = "category12")
  private WebElement catCymric;

  @FindBy(id = "category13")
  private WebElement catBouvier;

  @FindBy(xpath = "//*[@id=\"tbRatingFrom\"]//div[2]/div[2]")
  private WebElement btnRatingUp, btnRatingDown;

  public void clickAdminUsers() {
    aUsers.click();
  }

  String SearchImg = "";

  public void InputSearchImages() {
    tbTerm.sendKeys(SearchImg);
  }

  String RatingFrom = "";
  String RatingTo = "";

  public void InputRatingFrom() {
    tbRatingFrom.sendKeys(RatingFrom);
  }

  public void InputRatingTo() {
    tbRatingTo.sendKeys(RatingTo);
  }

  WebDriver driver;

  public void PageClass(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void PressRatingButtonUp() {
    Actions actions = new Actions(driver);
    //actions.moveToElement(tbRatingFrom, tbPriceFrom.getSize().getHeight() - 13, 13).click().perform();

    actions.moveToElement(btnRatingUp).moveByOffset(7, 12).click();
  }

  public void PressRatingButtonDown() {
    Actions actions = new Actions(driver);

    actions.moveToElement(btnRatingDown).moveByOffset(7, 8).click();
  }

  String PriceFrom = "";
  String PriceTo = "";

  public void InputPriceFrom() {
    tbPriceFrom.sendKeys(PriceFrom);
  }

  public void InputPriceTo() {
    tbPriceTo.sendKeys(PriceTo);
  }

  public void PressSearch() {
    btnSearch.click();
  }

  public void catEmpty() {
    catEmpty.click();
  }

  public void catFull() {
    catFull.click();
  }

  public void catMyth() {
    catMyth.click();
  }

  public void catCity() {
    catCity.click();
  }

  public void catStreet() {
    catStreet.click();
  }

  public void catTech() {
    catTech.click();
  }

  public void catWhoUN() {
    catWhoUN.click();
  }

  public void catVitamin() {
    catVitamin.click();
  }

  public void catFiction() {
    catFiction.click();
  }

  public void catElectronic() {
    catElectronic.click();
  }

  public void catSales() {
    catSales.click();
  }

  public void catCymric() {
    catCymric.click();
  }

  public void catBouvier() {
    catBouvier.click();
  }

  /// ADMIN EXTENSION

  @FindBy(id = "btnSave")
  private WebElement btnSave;

  public void clickSave() {
    btnSave.click();
  }

  @FindBy(id = "tbPathToAvatarImage")
  private WebElement tbPathToAvatarImage;

  public void typeInAvatar(String value) {
    tbPathToAvatarImage.clear();
    typeIn(value, tbPathToAvatarImage);
  }

  private void typeIn(String value, WebElement targetElement) {
    targetElement.clear();
    targetElement.sendKeys(value);
  }

  @FindBy(id = "aAddUser")
  private WebElement aAddUser;

  public void clickAddUser() {
    aAddUser.click();
  }

  @FindBy(id = "btnReset")
  private WebElement btnReset;

  public void clickReset() {
    btnReset.click();
  }
}
