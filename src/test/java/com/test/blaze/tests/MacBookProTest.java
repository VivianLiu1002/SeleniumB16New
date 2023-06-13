package com.test.blaze.tests;

import com.test.blaze.pages.BlazeMainPage;
import com.test.blaze.pages.LaptopsPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Test;

public class MacBookProTest extends BlazeTestBase {

@Test
    public void validateMacBookProInfo() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.chooseCategory("Laptops");
        LaptopsPage laptopsPage=new LaptopsPage(driver);
        laptopsPage.chooseLaptopBrand(driver,"MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.macbookProInfo("MacBook Pro","$1100 *includes tax"
        ,"Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, " +
                        "including a 13-inch and 15-inch model with the Touch Bar, a thin, " +
                        "multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macBookProPage.addToCartFunctionality(driver,"Product added");
    }

}
