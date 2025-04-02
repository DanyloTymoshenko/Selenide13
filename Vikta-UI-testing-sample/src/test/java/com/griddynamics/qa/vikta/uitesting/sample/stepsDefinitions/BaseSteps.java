package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker; // Використовуємо JavaFaker для генерації випадкових даних
import com.griddynamics.qa.vikta.uitesting.sample.config.TestDataAndProperties;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.BasePage;
import java.util.Objects;
import java.util.UUID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 Base class to contain common auxiliary methods for step definitions.
 */
abstract class BaseSteps {

  private WebDriver driver;
  private WebDriverWait wait;
  private static final Faker faker = new Faker(); // Додаємо Faker для генерації даних

  BaseSteps(WebDriver driver) {
    this.driver = driver;
  }

  WebDriver getDriver() {
    return this.driver;
  }

  WebDriverWait getWait() {
    if (Objects.isNull(this.wait)) {
      this.wait = new WebDriverWait(getDriver(), getData().waitTimeout());
    }
    return wait;
  }

  TestDataAndProperties getData() {
    return new TestDataAndProperties() {
      @Override
      public String browser() {
        return "chrome"; // Додаємо значення за замовчуванням
      }

      @Override
      public int pageLoadTimeout() {
        return 10; // Змінюємо з 1 на щось більш адекватне
      }

      @Override
      public int waitTimeout() {
        return 5; // Змінюємо з 3 на щось оптимальне
      }

      @Override
      public String baseHost() {
        return "localhost";
      }

      @Override
      public String basePort() {
        return "5054";
      }

      @Override
      public String baseUrl() {
        return "http://localhost:5054";
      }

      @Override
      public String loginPageUrl() {
        return baseUrl() + "/login";
      }

      @Override
      public String registrationPageUrl() {
        return baseUrl() + "/registration";
      }

      public String usersPageUrl() {
        return baseUrl() + "/admin/users";
      }

      @Override
      public String adminName() {
        return "admin";
      }

      @Override
      public String adminPassword() {
        return "123qweadmin";
      }

      @Override
      public String userName() {
        return "qq";
      }

      @Override
      public String userPassword() {
        return "123";
      }
    };
  }

  <P> P getPage(Class<P> pageClass) {
    return PageFactory.initElements(getDriver(), pageClass);
  }

  void verifyCurrentPageIsHomePageForTheUser(String username) {
    BasePage currentPage = getPage(BasePage.class);
    getWait().until(ExpectedConditions.visibilityOf(currentPage.getLoggedInName()));
    assertCurrentPageUrl(getData().baseUrl(), "Home page was expected to be the current one.");
    assertThat(currentPage.getCurrentUserName())
      .as("Unexpected current user's name displayed. Expected: %s", username)
      .contains(username);

    assertThat(currentPage.getCurrentUserRole()).as("Unexpected user role displayed.").isNotNull();
  }

  void assertCurrentPageUrl(String expectedUrl, String messageOnFail) {
    assertThat(getDriver().getCurrentUrl()).as(messageOnFail).contains(expectedUrl);
  }

  static String generateRandomString(int maxLength) {
    return UUID
      .randomUUID()
      .toString()
      .replaceAll("\\d", "A")
      .substring(0, Math.min(maxLength, 36));
  }

  static String generateRandomUsername() {
    return faker.name().username().replaceAll("\\W", "");
  }

  static String generateRandomEmail() {
    return faker.internet().emailAddress();
  }
}
