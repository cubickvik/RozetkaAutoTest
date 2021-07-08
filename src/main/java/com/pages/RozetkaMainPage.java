package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RozetkaMainPage {

    private WebDriver driver;
    @FindBy(css = "rz-icon-counter")
    private WebElement itemsInBucketElement;
    @FindBy(css = ".tile__title")
    private List<WebElement> listOfAvailableItems;
    public RozetkaMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getItemsCountInBucket() {
        String value = itemsInBucketElement.getText();
        if (value.equals("")) {
            return 0;
        } else {
            return Integer.valueOf(value);
        }
    }

    public ItemPage selectFirstItemFromThePage() {
        listOfAvailableItems.get(0).click();
        return new ItemPage(driver);
    }
}
