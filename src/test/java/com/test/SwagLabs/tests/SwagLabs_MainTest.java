package com.test.SwagLabs.tests;

import com.test.SwagLabs.pages.SwagLabs_LoginPage;
import com.test.SwagLabs.pages.SwagLabs_MainPage;
import org.testng.annotations.Test;

public class SwagLabs_MainTest extends SwagLabs_TestBase{
@Test
    public void validateProductSearch() throws InterruptedException {
    SwagLabs_LoginPage swagLabsLoginPage=new SwagLabs_LoginPage(driver);
    swagLabsLoginPage.login();
    SwagLabs_MainPage swagLabsMainPage=new SwagLabs_MainPage(driver);
    swagLabsMainPage.productSearch("Sauce Labs Backpack");
}
}
