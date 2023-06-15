package com.test.blaze.tests;

import com.test.blaze.pages.BlazeMainPage;
import com.test.blaze.pages.LaptopsPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MacBookProTest extends BlazeTestBase {
@Parameters({"category","laptopName","expectedHeader","expectedPrice","expectedDescription","expectedAlertMessage"})
@Test
    public void validateMacBookProInfo(String category,String laptopName,String expectedHeader,
                                       String expectedPrice,String expectedDescription, String expectedAlertMessage) throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory(category);
        LaptopsPage laptopsPage=new LaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(driver,laptopName);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.macbookProInfo(expectedHeader,expectedPrice,expectedDescription);
        macBookProPage.addToCartFunctionality(driver,expectedAlertMessage);
    }

}
