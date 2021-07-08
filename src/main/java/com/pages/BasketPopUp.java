package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPopUp {

    private final By popUpElement = By.xpath("//div[contains(@class, \"modal__holder\")]");
    private WebDriver driver;

    @FindBy(css = ".modal__close")
    private WebElement closePopUpElement;


    public BasketPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waitPopUpToBeExist();
    }

    public void closePopUp() {
        closePopUpElement.click();
        waitPopUpToBeNotExist();
    }

    private void waitPopUpToBeExist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(popUpElement));
    }

    private void waitPopUpToBeNotExist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpElement));
    }
}
