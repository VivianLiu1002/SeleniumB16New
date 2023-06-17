package com.test.SwagLabs.tests;

import Utils.ConfigReader;
import org.testng.annotations.DataProvider;

public class SwagLabsData {
    @DataProvider(name="positiveTest")
    public Object[][] swagLabPositiveData(){
        return new Object[][]{
                {"standard_user","secret_sauce", ConfigReader.readProperty("SwagLabs_mainPageUrl")},
                {"problem_user","secret_sauce",ConfigReader.readProperty("SwagLabs_mainPageUrl")},
                {"performance_glitch_user","secret_sauce",ConfigReader.readProperty("SwagLabs_mainPageUrl")}
        };
    }
    @DataProvider(name="negativeTest")
    public Object[][] swagLabNegativeData(){
        return new Object[][]{
                {"wrongName","wrongPassWord","Epic sadface: Username and password do not match any user in this service"},
                {"","wrongPassWord","Epic sadface: Username is required"},
                {"standard_user","","Epic sadface: Password is required"},
                {"","","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."}
        };
    }
   // @DataProvider(name = "productData")
}
