package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerLoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BankTestBase {
    @Parameters({"firstName","lastName","postCode","expectedMessage", "fullName","currency","expectedAccountMessage","expectedCustomerMessage",
    "depositAmount","expectedDepositMessage","withdrawAmount","expectedWithdrawMessage"})
    @Test
    public void validateCustomerLoginTransaction(String firstName, String lastName,String postCode, String expectedMessage,
    String fullname,String currency,String expectedAccountMessage, String expectedCustomerMessage,String depositAmount, String expectedDepositMessage,
    String withdrawAmount, String expectedWithdrawMessage) throws InterruptedException {
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
        bankManagerPage.OpenAccountFunctionality(driver, fullname, currency,
                expectedAccountMessage);
        //validate the last functionality on manager page:
        bankManagerPage.customerFunctionality(firstName,lastName,postCode);

        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLoginButton();
        CustomerLoginPage customerLoginPage=new CustomerLoginPage(driver);
        customerLoginPage.loginFunctionality(fullname,expectedCustomerMessage);

        customerLoginPage.depositFunctionality(depositAmount,expectedDepositMessage);
        customerLoginPage.withdrawFunctionality(withdrawAmount,expectedWithdrawMessage);
        customerLoginPage.transactionFunctionality();




    }


}
