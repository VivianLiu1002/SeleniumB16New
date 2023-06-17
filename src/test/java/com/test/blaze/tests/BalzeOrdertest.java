package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BalzeOrdertest extends BlazeTestBase{
    @Parameters({"category","laptopName","expectedAlertMessage","name","country","city",
            "creditCard","month","year","expectedThankYouMessage","expectedUrl"})
    @Test
    public void validatePlaceOrderFunctionality(String category,String laptopName,String expectedAlertMessage,
                                                String name, String country,String city,String creditCard, String month,
                                                String year,String expectedThankYouMessage,String expectedUrl) throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory(category);
        LaptopsPage laptopsPage=new LaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(driver,laptopName);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.addToCartFunctionality(driver,expectedAlertMessage);
        blazeMainPage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();

        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.placeOrderFunctionality(name,country,city,
                creditCard,month,year,expectedThankYouMessage);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
    @Test(dataProvider = "orderData", dataProviderClass = BlazeData.class)
    public void validatePlaceOrderFunctionality1(String category, String brand, String expectedAlertMessage,String firstName,
                                                 String country,String city,String card,String month,String year,String expectedMessage,String url) throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory(category);
        LaptopsPage laptopsPage=new LaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(driver,brand);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.addToCartFunctionality(driver,expectedAlertMessage);
        blazeMainPage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.clickPlaceOrderButton();

        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeOrderPage.placeOrderFunctionality(firstName,country,city,card,month,year,
                expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl().trim(),url);
    }

}
