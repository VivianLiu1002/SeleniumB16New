package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeCartTest extends BlazeTestBase{
    @Parameters({"category","laptopName","expectedAlertMessage","expectedHeader","laptopPrice"})
    @Test
    public void validateCartItem(String category,String laptopName,String expectedAlertMessage, String expectedHeader,
                                 String laptopPrice) throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory(category);
        LaptopsPage laptopsPage=new LaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(driver,laptopName);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.addToCartFunctionality(driver,expectedAlertMessage);

        blazeMainPage.clickCartButton();
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.productInfoFunctionality(expectedHeader,laptopPrice);
        blazeCartPage.clickPlaceOrderButton();



    }
}
