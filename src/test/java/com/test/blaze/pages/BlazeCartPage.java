package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlazeCartPage {
    /*
1-Navigate to the website "https://www.demoblaze.com/#"
2-Click the Laptops with Loop logic
3-Click MacBook Pro from the list with Loop(LaptopPage)
4-Click Add to cart button
5-Validate the text and click ok button(you already have method)
6-Click Cart Button top(WebElement can be in MainPage)
7-Validate the Name of Product and Price(no need test class for it just method)
8-Click Place Order and provide all the information(ORDER PAGE)
9-Validate the Thank you message and click OK
10-Validate the url is "https://www.demoblaze.com/index.html"

 */
    public BlazeCartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//tr[@class='success']//td")
    List<WebElement> productInfo;
    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;


    public void productInfoFunctionality(String expectedTitle, String expectedPrice){
        List<String> expectedInfo= Arrays.asList("",expectedTitle,expectedPrice, "");
        for (int i=1; i<productInfo.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(productInfo.get(i)),expectedInfo.get(i));
            Assert.assertEquals(BrowserUtils.getText(productInfo.get(i)),expectedInfo.get(i));
        }
    }
    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }
}
