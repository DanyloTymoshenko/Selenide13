package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.auxiliary.DriverManager;
import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import com.griddynamics.qa.vikta.uitesting.sample.config.TestDataAndProperties;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AdminSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.HomePageSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.LoginSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.io.FileUtils;
//import jdk.internal.org.jline.terminal.TerminalBuilder;
import org.jline.terminal.TerminalBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {

  // TODO: Think about some IoC/DI here.
  private DriverManager driverManager;
  private String baseUrl;

  LoginSteps loginSteps;
  RegistrationSteps registrationSteps;
  HomePageSteps homePageSteps;
  AdminSteps adminSteps;

  public BaseTest() {
    driverManager = new DriverManager(DataProvider.get());
  }

  @BeforeClass
  void setupClass() {
    this.baseUrl = DataProvider.get().baseUrl();
    System.out.println("Base URL: " + baseUrl);
    System.out.println("LOGIN PAGE URL IN BASE TEST: " + DataProvider.get().loginPageUrl());

    this.driverManager = new DriverManager(DataProvider.get());
    driverManager.instantiateDriver();
    driverManager.get().get(baseUrl);
    loginSteps = new LoginSteps(driverManager.get());
    registrationSteps = new RegistrationSteps(driverManager.get());
    homePageSteps = new HomePageSteps(driverManager.get());
    adminSteps = new AdminSteps(driverManager.get());
  }

  // TODO: Do a screenshot at the end upon test failure. Hint: @AfterMethod + Allure.
  @AfterMethod
  public void tearDown(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      captureScreenshot(result);
    }
  }

  public void captureScreenshot(ITestResult result) {
    String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    String testName = "TestFail";
    String fileName = testName + "_" + timestamp + ".png";
    File destinationFile = new File("screenshots/" + fileName);
    try {
      Files.createDirectories(destinationFile.getParentFile().toPath());
      File screenshotFile =
        ((TakesScreenshot) driverManager.get()).getScreenshotAs(OutputType.FILE);
      Files.copy(
        screenshotFile.toPath(),
        destinationFile.toPath(),
        StandardCopyOption.REPLACE_EXISTING
      );
      System.out.println("Screenshot Saved To: " + destinationFile.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterClass
  void tearDownClass() {
    driverManager.quit();
  }
}
