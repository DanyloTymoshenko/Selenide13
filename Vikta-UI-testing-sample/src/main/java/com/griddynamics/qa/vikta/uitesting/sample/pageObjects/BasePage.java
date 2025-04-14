package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
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

  //@FindBy(id = "sploggedInName")
  private SelenideElement loggedInName() {
    return $("#sploggedInName");
  }

  @FindBy(id = "aLogoutTop")
  private WebElement LogoutTopLink;

  @FindBy(id = "aHome")
  private WebElement HomeLink;

  @FindBy(id = "aAddresses")
  private WebElement AddressesLink;

  @FindBy(id = "aAddAddress")
  private WebElement AddAddressLink;

  @FindBy(id = "aCards")
  private WebElement CardsLink;

  @FindBy(id = "aAddCard")
  private WebElement AddCardLink;

  @FindBy(id = "aEditProfile")
  private WebElement EditProfileLink;

  @FindBy(css = "body > main > div:nth-child(1) > nav > div > div.navbar-header > a")
  private WebElement navBarBrandV;

  @FindBy(css = "#navbar > ul.nav.navbar-nav.navbar-right > li > span > span:nth-child(2)")
  private WebElement userRoleTop;

  // FOOTER

  @FindBy(css = "body > main > div.footer > div > footer > a")
  private WebElement GridDynamicsLink;

  @FindBy(css = "body > main > div.footer > div > footer > span > span:nth-child(1)")
  private WebElement loggedUserNameBottom;

  @FindBy(css = "body > main > div.footer > div > footer > span > span:nth-child(2)")
  private WebElement userRoleBottom;

  @FindBy(id = "aLogoutBottom")
  private WebElement LogoutBottomLink;

  public String getCurrentUserName() {
    return loggedInName().getText();
  }

  public String getLoggedInName() {
    return loggedInName().getText();
  }

  public void clickNavBarBrandV() {
    $(navBarBrandV).click();
  }

  public void clickHomeLink() {
    $(HomeLink).click();
  }

  public void clickAddressesLink() {
    $(AddressesLink).click();
  }

  public void clickAddAddressLink() {
    $(AddAddressLink).click();
  }

  public void clickCardsLink() {
    $(CardsLink).click();
  }

  public void clickAddCardLink() {
    $(AddCardLink).click();
  }

  public void clickEditProfileLink() {
    $(EditProfileLink).click();
  }

  public void clickLogoutTop() {
    $(LogoutTopLink).click();
  }

  public void clickGridDynamicsLink() {
    $(GridDynamicsLink).click();
  }

  public String getloggedUserNameBottom() {
    return $(loggedUserNameBottom).getText();
  }

  public void clickLogoutBottom() {
    LogoutBottomLink.click();
  }

  public String getCurrentUserRole() {
    return $(userRoleBottom).getText().trim();
  }
}
