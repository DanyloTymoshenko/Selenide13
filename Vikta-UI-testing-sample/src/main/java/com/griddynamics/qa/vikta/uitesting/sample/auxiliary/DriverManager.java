package com.griddynamics.qa.vikta.uitesting.sample.auxiliary;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.griddynamics.qa.vikta.uitesting.sample.config.TestDataAndProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages WebDriver instantiation etc.
 */

//@RequiredArgsConstructor
public final class DriverManager {

  private static final Logger log = LoggerFactory.getLogger(DriverManager.class);

  private static final int THOUSAND = 1000;
  private final TestDataAndProperties properties;
  private ThreadLocal<WebDriver> threadWebDriver = new ThreadLocal<>();

  public DriverManager(TestDataAndProperties properties) {
    this.properties = properties;
  }

  enum WebDriverType {
    FIREFOX,
    CHROME,
  }

  public void instantiateDriver() {
    log.info("About to init new web driver instance.");
    final WebDriver driver;
    WebDriverType driverType = getDriverType();

    switch (driverType) {
      case FIREFOX:
        driver = createFirefoxDriver();
        break;
      case CHROME:
        driver = createChromeDriver();
        break;
      default:
        throw new UnsupportedOperationException("Unsupported WebDriver type: " + driverType);
    }

    Configuration.browser = driverType.name().toLowerCase();
    Configuration.startMaximized = true;
    Configuration.timeout = properties.waitTimeout() * THOUSAND;
    Configuration.pageLoadTimeout = properties.pageLoadTimeout() * THOUSAND;

    WebDriverRunner.setWebDriver(driver);
    threadWebDriver.set(driver);
  }

  public void quit() {
    if (Objects.nonNull(threadWebDriver.get())) {
      log.info("Shutting down the driver.");
      threadWebDriver.get().quit();
      threadWebDriver.remove();
    }
  }

  public WebDriver get() {
    return threadWebDriver.get();
  }

  public byte[] takeScreenshot() {
    return ((TakesScreenshot) get()).getScreenshotAs(OutputType.BYTES);
  }

  /**
   * Driver type to use is defined by corresponding property value.
   * Defaults to Chrome if property is not set
   *
   * @return web driver type specified by the properties.
   */
  private WebDriverType getDriverType() {
    String driver = properties.browser();
    return Objects.isNull(driver)
      ? WebDriverType.CHROME
      : WebDriverType.valueOf(driver.toUpperCase());
  }

  private FirefoxDriver createFirefoxDriver() {
    // https://github.com/bonigarcia/webdrivermanager/
    final FirefoxOptions ops = new FirefoxOptions();
    //TODO: Configure as needed.
    ops.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
    io.github.bonigarcia.wdm.WebDriverManager.getInstance(WebDriverType.FIREFOX.name()).setup();

    return new FirefoxDriver(ops);
  }

  private ChromeDriver createChromeDriver() {
    final ChromeOptions ops = new ChromeOptions();
    ops.addArguments("--start-maximized");
    ops.addArguments("--dns-prefetch-disable");
    ops.addArguments("--remote-allow-origins=*"); // Solution?
    ops.addArguments("test-type");
    ops.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
    WebDriverManager.getInstance(WebDriverType.CHROME.name()).setup();

    return new ChromeDriver(ops);
  }
}
