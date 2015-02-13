package com.lohika.atf.test;

import com.lohika.atf.lb.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadFactory;

public class FirstTest extends coreTest {



        @Test (groups = {"smoke","All","E2E"})
        public void loginAsAdmin(){
            // driver = new FirefoxDriver();
            driver.get("http://localhost:9090/Forum");
            WebElement elementLogin = driver.findElement(By.id("login"));
            WebElement elementPassword = driver.findElement(By.id("password"));
            WebElement submitButton = driver.findElement(By.id("submit"));
            //try {
            //    Assert.assertEquals("Google", driver.getTitle(), "Unexpected Title was found. Alarma!!;) ");
            //}
            //catch(AssertionError e){
            //Reporter.log("I catched it",true);
            //   }
            Reporter.log("We are  starting <br>", true);
            elementLogin.sendKeys("admin");
            elementPassword.sendKeys("admin");
            CommonMethods.setTimeout(1);
            submitButton.click();

            CommonMethods.setTimeout(3);

            //Assert.fail("enough ;)"); //For failing test purposes

    }
    @Test (groups = {"E2E","All"}, dependsOnMethods = { "loginAsAdmin" })
    public void addTopicButton(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addPost")));
        WebElement elementAddTopic = driver.findElement(By.id("addPost"));
       // WebElement elementAddTopic3 = driver.findElement(By.id("tList"));
        //element.clear();
        //element.sendKeys("TestNG");


       // elementAddPost.submit();
        elementAddTopic.click();
        //CommonMethods.setTimeout(1);
        //Assert.assertEquals("service__name", driver.findElement(By.className("service__name")));
        //driver.findElement(By.className("input__control")).sendKeys("eeeee");
        CommonMethods.setTimeout(3);
        Reporter.log(" Testing  Add Topic Point  <br>",true);

    }
    @Test (groups = {"E2E","All"}, dependsOnMethods = { "addTopicButton" })
    public void performAddTopic(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topicName")));
        WebElement elementAddTopicName = driver.findElement(By.id("topicName"));
        elementAddTopicName.sendKeys("TestNG");
        WebElement elementAddTopicContent = driver.findElement(By.id("content"));
        elementAddTopicContent.sendKeys("Simple Forum autoTests - admin E2E");
        WebElement submitButton = driver.findElement(By.id("addTopic"));
        submitButton.click();
        CommonMethods.setTimeout(3);
        Reporter.log(" Testing  Add Topic Form  <br> ",true);
    }

    @Test (groups = {"E2E","All"}, dependsOnMethods = { "performAddTopic" })
    public void viewTopic(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestNG")));

        WebElement elementViewTopic = driver.findElement(By.id("TestNG"));
        elementViewTopic.click();
        CommonMethods.setTimeout(3);
        Reporter.log(" View Topic Form  <br> ",true);
    }

    @Test (groups = {"E2E","All"}, dependsOnMethods = { "viewTopic" })
    public void addPostButton(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Postlink")));

        WebElement elementAddPost = driver.findElement(By.id("Postlink"));
        elementAddPost.click();
        CommonMethods.setTimeout(5);
        Reporter.log(" Add Post link  <br> ",true);
    }

    @Test (groups = {"E2E","All"}, dependsOnMethods = { "addPostButton" })
    public void addPost(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PostField")));

        WebElement elementPostField = driver.findElement(By.id("PostField"));
        elementPostField.sendKeys("Testim testim peretestim");

        WebElement elementAddPost = driver.findElement(By.id("addPost"));
        elementAddPost.click();
        CommonMethods.setTimeout(5);
        Reporter.log(" Add Post Form  <br> ",true);
    }
}
