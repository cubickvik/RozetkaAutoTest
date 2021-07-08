package com;

import com.pages.RozetkaMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;

public class RozetkaSimpleTests {

    private WebDriver driver;

    @Test
    public void userCanAddItemToBucket() throws InterruptedException {
        driver.get("https://rozetka.com.ua/");
        RozetkaMainPage mainPage = new RozetkaMainPage(driver);
        int currentItemsCountInBucket = mainPage.getItemsCountInBucket();
        Assert.assertEquals(currentItemsCountInBucket, 0, "Checking the items count in basket");
        mainPage
                .selectFirstItemFromThePage()
                .clickOnBuyButton()
                .closePopUp();
        currentItemsCountInBucket = mainPage.getItemsCountInBucket();
        Assert.assertEquals(currentItemsCountInBucket, 1, "Checking the items count in basket after adding item ");

    }

    @BeforeTest
    public void before() throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver",
                new File(RozetkaSimpleTests.class.getClassLoader().getResource("drivers\\chromedriver91.exe")
                        .toURI())
                        .getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.driver = driver;
    }

    @AfterTest
    public void  after(){
        if (driver != null){
            driver.quit();
        }

    }

}
