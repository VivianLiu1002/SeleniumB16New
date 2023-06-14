package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy()
}
