package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {
    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h2")
    WebElement header;
    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement price;
    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;
    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;
    public void macbookProInfo(String expectedHeader,String expectedPrice, String expectedDescription) throws InterruptedException {

        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
    }

    public void addToCartFunctionality(WebDriver driver, String expectedAlertMessage) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver,addToCartButton);
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedAlertMessage));
        alert.accept();
    }



}
