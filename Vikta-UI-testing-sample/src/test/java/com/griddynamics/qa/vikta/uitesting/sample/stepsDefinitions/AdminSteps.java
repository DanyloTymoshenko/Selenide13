package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminSteps extends BaseSteps {

  public AdminSteps(WebDriver driver) {
    super(driver);
  }

  private HomePage page() {
    return getPage(HomePage.class);
  }

  @Step
  public void getUserPage() {
    page().clickAdminUsers();
  }
  @Step
  public void getImagePage() {
    page().clickImages();
  }

  String username = "AbAaAaeA-AeaA-AA";
  String dynamicId = "trUser_" + username;
  String imageId = "trImage_14";

  @Step
  public void getUser() {
    $(dynamicId).hover();
  }

  // #trUser_qq > td:nth-child(3)   //*[@id=\""+username+"\"]/td[2
  @Step
  public String getTableRowContentById() {
    /*if(!$("#"+dynamicId).exists()){throw new NoSuchElementException("ELEMENT "+ dynamicId +" is not FOUND");
    }*/
    return $(By.id(dynamicId)).should(Condition.exist).shouldBe(Condition.visible).getText();
  }

  @Step
  public void writeTableRowContentById() {
    List<String> cells = $$("#" + dynamicId + " td")
      .shouldBe(CollectionCondition.sizeGreaterThan(0))
      .texts();
    System.out.println("Row with ID [" + dynamicId + "] contains: ");
    for (int i = 0; i < cells.size(); i++) {
      System.out.println("  Row " + (i + 1) + ": " + cells.get(i));
    }
  }

  @Step
  public void deleteRowById() {
    SelenideElement deleteButton = $("#" + dynamicId + " > td:nth-child(7) > a"); //#trUser_qq > td:nth-child(7) > a

    deleteButton.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    System.out.println("ROw" + dynamicId + " has been deleted");
  }

  @Step
  public void typeIntoAvatar() {
    String returnValue =
      "https://www.google.com/imgres?q=owl%20photo&imgurl=https%3A%2F%2Fwww.akronzoo.org%2Fsites%2Fdefault%2Ffiles%2Fstyles%2Funcropped_xl%2Fpublic%2F2022-05%2FSnowy-owl-Frost.png%3Fitok%3Dbw8666Ly&imgrefurl=https%3A%2F%2Fwww.akronzoo.org%2Fbirds%2Fsnowy-owl&docid=HJnJFSxsErnqWM&tbnid=eAY5ZvktTqj35M&vet=12ahUKEwiw_5CizriMAxUkxAIHHQdkEocQM3oFCIUBEAA..i&w=1600&h=1600&hcb=2&ved=2ahUKEwiw_5CizriMAxUkxAIHHQdkEocQM3oFCIUBEAA";
    page().typeInAvatar(returnValue);
  }

  @Step
  public void clickUserProfileLink() {
    $(By.xpath("//*[@id=\"trUser_eeAAAAAA-AAAA-AA\"]/td[2]/a")).click();
  }

  @Step
  public void clickSave() {
    page().clickSave();
  }

  @Step
  public void getAddUser() {
    page().clickAddUser();
  }

  @Step
  public void clickReset() {
    page().clickReset();
  }

  /// IMAGE

  @Step
  public void clickImageEditLink() {
    $(By.xpath("//*[@id=\"trImage_14\"]/td[3]/a")).click();
  }
  @Step
  public String getImageTableRowContentById() {

    return $(By.id(imageId)).should(Condition.exist).shouldBe(Condition.visible).getText();
  }

  @Step
  public void writeImageTableRowContentById() {
    List<String> cells = $$("#" + imageId + " td")
            .shouldBe(CollectionCondition.sizeGreaterThan(0))
            .texts();
    System.out.println("Image Row with ID [" + imageId + "] contains: ");
    for (int i = 0; i < cells.size(); i++) {
      System.out.println("  Image Row " + (i + 1) + ": " + cells.get(i));
    }
  }
  @Step
  public void deleteImageRowById() {
    SelenideElement deleteButton = $("#" + imageId + " > td:nth-child(10)");

    deleteButton.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    System.out.println("ROw" + imageId + " has been deleted");
  }
  @Step
  public void editImage(){
    page().typeInImageAuthor("Test");
    page().typeInImageDescription("TEST");
    page().typeInImageTitle("TEST");
    page().typeInImagePrice("13");
    page().typeInImageTags("Subete");
    page().typeInImageUrl("https://www.google.com/imgres?q=owl%20photo&imgurl=https%3A%2F%2Fwww.akronzoo.org%2Fsites%2Fdefault%2Ffiles%2Fstyles%2Funcropped_xl%2Fpublic%2F2022-05%2FSnowy-owl-Frost.png%3Fitok%3Dbw8666Ly&imgrefurl=https%3A%2F%2Fwww.akronzoo.org%2Fbirds%2Fsnowy-owl&docid=HJnJFSxsErnqWM&tbnid=eAY5ZvktTqj35M&vet=12ahUKEwiw_5CizriMAxUkxAIHHQdkEocQM3oFCIUBEAA..i&w=1600&h=1600&hcb=2&ved=2ahUKEwiw_5CizriMAxUkxAIHHQdkEocQM3oFCIUBEAA");
    page().ChangeRating(3);
    page().SetCategory("Rock");

  }
  @Step
  public void AddImage(){
    page().clickAddImage();
  }
}


