package com.test.bank.tests;

import Utils.ConfigReader;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankManageTest extends BankTestBase {
    @Parameters({"firstName","lastName","postCode","expectedMessage"})
    @Test
    public void validateAddCustomerFunctionality(String firstName, String lastName, String postCode, String expectedMessage) {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, firstName, lastName, postCode,
                expectedMessage);
    }
@Parameters({"firstName","lastName","postCode","expectedMessage", "fullName","currency","expectedAccountMessage"})
    @Test
    public void validateOpenAccountFunctionality(String firstName, String lastName, String postCode, String expectedMessage, String fullName,
                                                 String currency,String expectedAccountMessage) {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        //to be able to open account, need to add customer first, so the step is repeated for needs
        bankManagerPage.addCustomerFunctionality(driver, firstName, lastName, postCode,
                expectedMessage);
        bankManagerPage.OpenAccountFunctionality(driver, fullName, currency,
                expectedAccountMessage);
    }

    @Test
    public void validateCustomerFunctionality(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");


        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        //to be able to open account, need to add customer first, so the step is repeated for needs
        bankManagerPage.addCustomerFunctionality(driver, ConfigReader.readProperty("QA_bankManagerTest_firstName"), ConfigReader.readProperty("QA_bankManagerTest_lastname"),
                ConfigReader.readProperty("QA_bankManagerTest_zipcode"),
                ConfigReader.readProperty("QA_bankManagerTest_expectedMessage"));
       // bankManagerPage.OpenAccountFunctionality(driver, "Vivian Liu", "Dollar",
              //  "Account created successfully with account Number");
       //validate the last functionality on manager page:
       // bankManagerPage.customerFunctionality("Vivian","Liu","60133");
    }
}
