package com.test.spruteEats.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SpruteEatsTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=DriverHelper.getDriver();
        driver.navigate().to("https://www.thespruceeats.com/");
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"Sprute Eats");
        }
        driver.quit();
    }
}
