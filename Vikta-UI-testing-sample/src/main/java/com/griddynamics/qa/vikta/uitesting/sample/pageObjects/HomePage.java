package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object of Home page
 */
public class HomePage extends BasePage {

  //TODO: Add more.

  @FindBy(css = "#aUsers")
  private WebElement aUsers;

  @FindBy(xpath = "//*[@id=\"tbTerm\"]")
  private WebElement tbTerm;

  @FindBy(id = "tSelectedCategoryTitle")
  private WebElement tSelectedCategoryTitle;

  @FindBy(xpath = "//*[@id=\"tbRatingFrom\"]")
  private WebElement tbRatingFrom;

  @FindBy(xpath = "//*[@id=\"tbRatingTo\"]")
  private WebElement tbRatingTo;

  @FindBy(xpath = "//*[@id=\"tbPriceFrom\"]")
  private WebElement tbPriceFrom;

  @FindBy(xpath = "//*[@id=\"tbPriceTo\"]")
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
    $(aUsers).click();
  }

  public void InputSearchImages(String SearchImg) {
    tbTerm.sendKeys(SearchImg);
  }

  public void InputRatingFrom(String RatingFrom) {
    tbRatingFrom.sendKeys(RatingFrom);
  }

  public void InputRatingTo(String RatingTo) {
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

  public void InputPriceFrom(String PriceFrom) {
    tbPriceFrom.sendKeys(PriceFrom);
  }

  public void InputPriceTo(String PriceTo) {
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

  @FindBy(css = "#aAddUser")
  private WebElement aAddUser;

  public void clickAddUser() {
    $(aAddUser).click();
  }

  @FindBy(id = "btnReset")
  private WebElement btnReset;

  public void clickReset() {
    btnReset.click();
  }

  /// IMAGES
  @FindBy(css = "#aImages")
  private  WebElement aImage;

  public void clickImages() {
    $(aImage).shouldBe(Condition.visible).click();

  }

  @FindBy(id = "tbUEL")
  private WebElement imageURL;

  public void typeInImageUrl(String value) {
    imageURL.clear();
    typeIn(value, imageURL);
  }

  @FindBy(id = "tbTitle")
  private WebElement imageTitle;

  public void typeInImageTitle(String value) {
    imageTitle.clear();
    typeIn(value, imageTitle);
  }

  @FindBy(id = "tbDescription")
  private WebElement imageDesctiption;

  public void typeInImageDescription(String value) {
    imageDesctiption.clear();
    typeIn(value, imageDesctiption);
  }

  @FindBy(css = "#tbAuthor")
  private WebElement imageAuthor;

  public void typeInImageAuthor(String value) {
    $(imageAuthor).setValue(value);
   // typeIn(value, imageAuthor);
  }

  @FindBy(id = "tbPrice")
  private WebElement imagePrice;

  public void typeInImagePrice(String value) {
    imagePrice.clear();
    typeIn(value, imagePrice);
  }

  @FindBy(id = "tbTags")
  private WebElement imageTags;

  public void typeInImageTags(String value) {
    imageTags.clear();
    typeIn(value, imageTags);
  }

  @FindBy(id = "rating")
  private WebElement imageRatingSlider;

  public void ChangeRating(int value) {
    $("#rating").setValue(String.valueOf(value));
  }

  @FindBy(id = "slctCategories")
  private WebElement imageCategoriesListBox;

  public void SetCategory(String categoryName) {
    Select select = new Select(imageCategoriesListBox);

    select.selectByVisibleText(categoryName);
  }

  @FindBy(id = "aAddImage")
  private WebElement AddImagePage;

  public void clickAddImage() {
    AddImagePage.click();
  }

  @FindBy(xpath = "//*[@id=\"btnResetSearchCriteria\"]")
  private WebElement ResetButton;

  public void PressReset() {
    ResetButton.click();
  }
}
