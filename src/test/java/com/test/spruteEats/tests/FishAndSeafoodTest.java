package com.test.spruteEats.tests;

import com.test.spruteEats.pages.FishAndSeafoodPage;
import com.test.spruteEats.pages.SpruteEatsMainPage;
import org.testng.annotations.Test;

public class FishAndSeafoodTest extends SpruteEatsTestBase{
    @Test
    public void validateSearchFunctionality() throws InterruptedException {
        SpruteEatsMainPage spruteEatsMainPage=new SpruteEatsMainPage(driver);
        spruteEatsMainPage.chooseIngredients(driver);
        FishAndSeafoodPage fishAndSeafoodPage=new FishAndSeafoodPage(driver);
        fishAndSeafoodPage.searchFunctionality(driver,"Fish for dinner","6-Ingredient Roasted Salmon Fillets");
    }
}
