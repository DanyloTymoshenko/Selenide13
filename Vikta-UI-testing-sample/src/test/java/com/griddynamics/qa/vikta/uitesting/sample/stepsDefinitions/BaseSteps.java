package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.error.ShouldBe.shouldBe;

import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import com.griddynamics.qa.vikta.uitesting.sample.config.TestDataAndProperties;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.BasePage;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class to contain common auxiliary methods for step definitions.
 */
abstract class BaseSteps {

  TestDataAndProperties data = DataProvider.get();

  private WebDriver driver;
  private WebDriverWait wait;
  private static final Faker faker = new Faker();

  BaseSteps(WebDriver driver) {
    this.driver = driver;
  }

  WebDriver getDriver() {
    return this.driver;
  }

  WebDriverWait getWait() {
    if (Objects.isNull(this.wait)) {
      this.wait = new WebDriverWait(getDriver(), data.waitTimeout());
    }
    return wait;
  }

  <P> P getPage(Class<P> pageClass) {
    return PageFactory.initElements(getDriver(), pageClass);
  }

  void verifyCurrentPageIsHomePageForTheUser(String username) {
    BasePage currentPage = getPage(BasePage.class);

    assertCurrentPageUrl(data.baseUrl(), "Home page was expected to be the current one.");
    assertThat(currentPage.getCurrentUserName())
      .as("Unexpected current user's name displayed. Expected: %s", username)
      .contains(username);

    assertThat(currentPage.getCurrentUserRole()).as("Unexpected user role displayed.").isNotNull();
  }

  void assertCurrentPageUrl(String expectedUrl, String messageOnFail) {
    assertThat(getDriver().getCurrentUrl()).as(messageOnFail).contains(expectedUrl);
  }

  static String generateRandomString(int maxLength) {
    return RandomStringUtils.randomAlphabetic(maxLength);
  }

  static String generateRandomUsername() {
    return faker.name().username().replaceAll("\\W", "");
  }

  static String generateRandomEmail() {
    return faker.internet().emailAddress();
  }
}
