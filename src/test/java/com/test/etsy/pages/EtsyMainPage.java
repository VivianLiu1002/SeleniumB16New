package com.test.etsy.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class EtsyMainPage {
    public EtsyMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='search_query']")
    WebElement searchBar;
    @FindBy(xpath = "//div[contains(@class,'listing')]//h3")
    List<WebElement> productTitles;

    public void searchBarFunctionality( String phone, String phoneModel, String productType,String fullSearchName){
        searchBar.sendKeys(fullSearchName, Keys.ENTER);
        for (WebElement productTitle : productTitles){
            String text=BrowserUtils.getText(productTitle).toLowerCase();
            Assert.assertTrue(text.contains(phone)
                            || text.contains(phoneModel) || text.contains(productType) || text.contains(fullSearchName));
        }
    }


}
