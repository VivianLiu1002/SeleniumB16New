package com.test.spruteEats.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FishAndSeafoodPage {
    public FishAndSeafoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#search-form-input")
    WebElement searchBar;
    @FindBy(xpath = "//input[contains(@id,'starRating_score_4Star')]")
    WebElement fourStarButton;
    @FindBy(css = "#pop_search_editor")
    WebElement editorChoice;
    @FindBy(xpath = "//span[contains(text(),'Salmon Fillets')]")
    WebElement nameOfDish;


    public void searchFunctionality(WebDriver driver,String searchInfo, String expectedNameOfDish) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,searchBar);
        searchBar.sendKeys(searchInfo, Keys.ENTER);
        if (fourStarButton.isEnabled() && !fourStarButton.isSelected() && fourStarButton.isDisplayed()){
            Thread.sleep(2000);
            fourStarButton.click();
        }
        if (editorChoice.isDisplayed() && !editorChoice.isSelected()){
            editorChoice.click();
        }
        Assert.assertEquals(BrowserUtils.getText(nameOfDish),expectedNameOfDish);



    }
}
