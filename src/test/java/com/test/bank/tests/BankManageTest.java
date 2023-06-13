package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Test;

public class BankManageTest extends BankTestBase {
    @Test
    public void validateAddCustomerFunctionality() {
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
        bankManagerPage.addCustomerFunctionality(driver, "Vivian", "Liu", "60133",
                "Customer added successfully with customer id");
    }

    @Test
    public void validateOpenAccountFunctionality() {
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
        bankManagerPage.addCustomerFunctionality(driver, "Vivian", "Liu", "60133",
                "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Vivian Liu", "Dollar",
                "Account created successfully with account Number");
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
        bankManagerPage.addCustomerFunctionality(driver, "Vivian", "Liu", "60133",
                "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Vivian Liu", "Dollar",
                "Account created successfully with account Number");
       //validate the last functionality on manager page:
        bankManagerPage.customerFunctionality("Vivian","Liu","60133");
    }
}
