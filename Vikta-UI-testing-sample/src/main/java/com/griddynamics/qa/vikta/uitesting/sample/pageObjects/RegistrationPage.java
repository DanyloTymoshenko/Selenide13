package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Vikta's Registration page
 */
public class RegistrationPage extends BasePage {

  @FindBy(id = "tbLoginName")
  private WebElement tbLoginName;

  @FindBy(id = "tbSurname")
  private WebElement tbSurname;

  @FindBy(id = "tbFirstName")
  private WebElement tbFirstName;

  @FindBy(id = "tbMiddleName")
  private WebElement tbMiddleName;

  //TODO: Add missing elements.

  @FindBy(id = "tbEmail")
  private WebElement tbEmail;

  @FindBy(id = "tbPassword")
  private WebElement btnPassword;

  @FindBy(id = "tbPassword")
  private WebElement tbPassword;

  @FindBy(id = "btnSubmitGoToHome")
  private WebElement btnGoToHome;

  @FindBy(id = "tSuccessMessage")
  private WebElement tSuccessMessage;

  @FindBy(id = "btnRegister")
  private WebElement btnRegister;

  //TODO: Add [Register User] button support.

  public void typeInLoginname(String value) {
    tbLoginName.clear();
    typeIn(value, tbLoginName);
  }

  public void typeInSurname(String value) {
    tbSurname.clear();
    typeIn(value, tbSurname);
  }

  public void typeInEmail(String value) {
    tbEmail.clear();
    typeIn(value, tbEmail);
  }

  public void typeInFirstname(String value) {
    tbFirstName.clear();
    typeIn(value, tbFirstName);
  }

  public void typeInPatronim(String value) {
    tbMiddleName.clear();
    typeIn(value, tbMiddleName);
  }

  public void typeInPassword(String value) {
    tbPassword.clear();
    typeIn(value, tbPassword);
  }

  public void clickbtnRegister() {
    btnRegister.click();
  }

  private void typeIn(String value, WebElement targetElement) {
    targetElement.clear();
    targetElement.sendKeys(value);
  }

  public String getMessageText() {
    return tSuccessMessage.getText();
  }

  public WebElement getMessageWebElement() {
    return tSuccessMessage;
  }
}
