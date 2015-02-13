package com.lohika.atf.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public abstract class coreTest {
    protected WebDriver driver;



    @BeforeSuite (alwaysRun = true)
    @Parameters({"browser"})
    public void setUP(@Optional("firefox") String browser) {
        if (browser.equalsIgnoreCase("firefox") ) {
        driver = new FirefoxDriver();
        }
            else if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Dev\\atf2\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            }
        driver.manage().window().maximize();
    }




    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}