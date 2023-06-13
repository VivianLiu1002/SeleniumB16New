package com.test.spruteEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruteEatsMainPage {
    /*
1-Navigate to the website "https://www.thespruceeats.com/"
2-Under Ingredients tab --> choose Fish&SeaFood option
3-ScrollDown to the search bar (Use JS Method)
4-Send the data: "Fish for dinner"
5-On the left side choose 4 star up option
6-From popular: Choose the Editor's choice option
7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
8-Quit or close your driver

PURPOSE: *Apply Action class method
         *Apply How to find the unique element for real website
     */
    public SpruteEatsMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='global-nav__list-item-link']//span[.='Ingredients']")
    WebElement ingredients;
    @FindBy(xpath = "//ul[@class='global-nav__sub-list']//a[contains(text(),'Fish & Seafood')]")
    WebElement fishAndSeafood;


    public void chooseIngredients(WebDriver driver) throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredients).perform();
        Thread.sleep(2000);
        //actions.moveToElement(fishAndSeafood).perform();

        actions.click(fishAndSeafood).perform();
    }

}
