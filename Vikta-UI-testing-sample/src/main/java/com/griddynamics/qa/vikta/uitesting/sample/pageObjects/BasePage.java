package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * "Parent" Page Object for almost all of the rest of the pages (except Login).
 * <p>
 * More to read:
 * https://selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/
 * https://martinfowler.com/bliki/PageObject.html
 * https://www.baeldung.com/selenium-webdriver-page-object
 * https://www.pluralsight.com/guides/getting-started-with-page-object-pattern-for-your-selenium-tests
 */
public class BasePage {

  //TODO: Add more header/ footer elements.

  // HEADER

  @FindBy(id = "sploggedInName")
  private WebElement sploggedInName;

  @FindBy(id = "aLogoutTop")
  private WebElement aLogoutTop;

  @FindBy(id = "aHome")
  private WebElement aHome;

  @FindBy(id = "aAddresses")
  private WebElement aAddresses;

  @FindBy(id = "aAddAddress")
  private WebElement aAddAddress;

  @FindBy(id = "aCards")
  private WebElement aCards;

  @FindBy(id = "aAddCard")
  private WebElement aAddCard;

  @FindBy(id = "aEditProfile")
  private WebElement aEditProfile;

  @FindBy(xpath = "/html/body/main/div[1]/nav/div/div[1]/a")
  private WebElement navbarBrandV;

  @FindBy(xpath = "//*[@id=\"navbar\"]/ul[2]/li/span/span[2]")
  private WebElement userRoleTop;

  // FOOTER

  @FindBy(xpath = "/html/body/main/div[3]/div/footer/a")
  private WebElement GridDynamicsLink;

  @FindBy(xpath = "/html/body/main/div[3]/div/footer/text()")
  private WebElement yearPublished;

  @FindBy(xpath = "/html/body/main/div[3]/div/footer/span/span[1]")
  private WebElement loggedUserNameBottom;

  @FindBy(xpath = "/html/body/main/div[3]/div/footer/span/span[2]")
  private WebElement userRoleBottom;

  @FindBy(id = "aLogoutBottom")
  private WebElement aLogoutBottom;

  public String getCurrentUserName() {
    return sploggedInName.getText();
  }

  public WebElement getLoggedInName() {
    return sploggedInName;
  }

  public void clicknavbarBrandV() {
    navbarBrandV.click();
  }

  public void clickaHome() {
    aHome.click();
  }

  public void clickaAddresses() {
    aAddresses.click();
  }

  public void clickaAddAddress() {
    aAddAddress.click();
  }

  public void clickaCards() {
    aCards.click();
  }

  public void clickaAddCard() {
    aAddCard.click();
  }

  public void clickaEditProfile() {
    aEditProfile.click();
  }

  public void clickLogoutTop() {
    aLogoutTop.click();
  }

  public void clickGridDynamicsLink() {
    GridDynamicsLink.click();
  }

  public WebElement loggedUserNameBottom() {
    return loggedUserNameBottom;
  }

  public void clickLogoutBottom() {
    aLogoutBottom.click();
  }
}
