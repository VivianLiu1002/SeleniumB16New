package com.test.SwagLabs.tests;

import com.test.SwagLabs.pages.SwagLabs_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabs_LoginTest extends SwagLabs_TestBase{

@Test(dataProvider = "positiveTest",dataProviderClass = SwagLabsData.class)
    public void validatePositiveLoginFunctionality(String name, String password, String expectedUrl){
    SwagLabs_LoginPage swagLabsLoginPage=new SwagLabs_LoginPage(driver);
    swagLabsLoginPage.loginFunctionality(name,password);
    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
}
@Test(dataProvider = "negativeTest",dataProviderClass = SwagLabsData.class)
    public void validateNegativeLoginFunctionality(String name,String password,String expectedMessage){
    SwagLabs_LoginPage swagLabsLoginPage=new SwagLabs_LoginPage(driver);
    swagLabsLoginPage.loginFunctionality(name,password);
    Assert.assertEquals(swagLabsLoginPage.errorMessage(),expectedMessage);
}
}
