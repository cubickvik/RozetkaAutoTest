package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class=\"product-about__right\"]//button[contains(@class, \"buy-button\")]")
    private WebElement buyButtonElement;

    private By idCode = By.cssSelector(".product__code-accent");

    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(idCode));
        new Actions(driver).moveToElement(driver.findElement(idCode)).perform();
    }


    public BasketPopUp clickOnBuyButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(buyButtonElement));
        buyButtonElement.click();
        return new BasketPopUp(driver);
    }

}
