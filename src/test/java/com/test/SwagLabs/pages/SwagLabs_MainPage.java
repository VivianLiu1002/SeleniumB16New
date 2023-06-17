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

    @FindBy(xpath = "//a[contains(@id,'title_link')]")
    List<WebElement> itemNames;
    @FindBy(xpath = "//div[contains(@class,'inventory_details_name')]")
    WebElement header;
    @FindBy(xpath = "//div[contains(@class,'inventory_details_desc large_size')]")
    WebElement description;
    @FindBy(css = ".inventory_details_price")
    WebElement price;

    public void productSearch(String ItemName,String header,String description,String price) throws InterruptedException {
        for (WebElement name : itemNames) {
            if (BrowserUtils.getText(name).equals(ItemName)){
                name.click();
                Thread.sleep(1000);
                Assert.assertEquals(BrowserUtils.getText(this.header),header);
                Assert.assertTrue(BrowserUtils.getText(this.description).contains(description));
                Assert.assertEquals(BrowserUtils.getText(this.price),price);
                break;
            }


        }
    }

}
