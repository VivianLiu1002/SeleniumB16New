package com.test.SwagLabs.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SwagLabs_MainPage {
    public SwagLabs_MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> itemNames;
    @FindBy(xpath = "//div[contains(@class,'inventory_details_name')]")
    WebElement header;
    @FindBy()
    WebElement description;
    @FindBy()
    WebElement price

    public void productSearch(String ItemName) throws InterruptedException {
        for (WebElement name : itemNames) {
            if (BrowserUtils.getText(name).equals(ItemName)){
                Thread.sleep(2000);
                name.click();
                break;
            }
            Assert.assertEquals(BrowserUtils.getText(),"Sauce Labs Backpack");
        }
    }

}
