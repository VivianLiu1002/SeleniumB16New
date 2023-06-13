package com.test.blaze.tests;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BlazeTestBase {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions=new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        driver=new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver= DriverHelper.getDriver();
        driver.navigate().to("https://www.demoblaze.com/#");
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if (!iTestResult.isSuccess()){//means if the test fails, get a screenshot and quit
            BrowserUtils.getScreenShot(driver,"blazePictures");
        }
        driver.quit();
    }
}
