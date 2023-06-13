package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LaptopsPage {
    public LaptopsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".card-title")
    List<WebElement> laptopTitles;

    public void chooseLaptopBrand(WebDriver driver,String laptopName) throws InterruptedException {
      //  BrowserUtils.scrollWithJS(driver,macBookpro);
        Thread.sleep(2000);
        for (WebElement laptop : laptopTitles){
            if (BrowserUtils.getText(laptop).equalsIgnoreCase(laptopName)){
                laptop.click();
                break;
            }

        }
    }
}
