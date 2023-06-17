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
    @DataProvider(name = "productData")
    public Object[][] productLogInData(){
        return new Object[][]{
                {"Sauce Labs Backpack","Sauce Labs Backpack","Sly Pack","$29.99"},
                {"Sauce Labs Bike Light","Sauce Labs Bike Light","Water-resistant","$9.99"},
                {"Sauce Labs Bolt T-Shirt","Sauce Labs Bolt T-Shirt","Sauce Labs bolt T-shirt","$15.99"},
                {"Sauce Labs Fleece Jacket","Sauce Labs Fleece Jacket","quarter-zip fleece jacket","$49.99"},
                {"Sauce Labs Onesie","Sauce Labs Onesie","3-snap bottom closure","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","Test.allTheThings() T-Shirt (Red)","Super-soft and comfy","$15.99"}
        };
    }
}
