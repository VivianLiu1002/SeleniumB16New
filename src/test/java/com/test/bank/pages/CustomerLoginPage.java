package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerLoginPage {
    /*
TASK:
1-Click homeButton from top(You can store in Manager Page or LoginPage)
2-Click Customer Login
3-Find Your name from the List
4-Click Login
5-Validate the "Welcome Your Name" from header
6-Click Deposit and put 500
7-Validate "Deposit Successful
8-Click Withdrawl and put 300
9-Validate "Transaction successful"
10-Get the balance from the Customer Page(200)
11-Click Transactions
12-get the 500 and 300 from the table and substract them
13-Validate balance from customer page amount(200) equals to transaction amount(500-300).
14-Quit the driver

NOTE:YOu should have another CustomerPage class and CustomerTest class and do your validation under customerTest
*/
    public CustomerLoginPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement nameSelectBox;
    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//strong[contains(text(),' Welcome ')]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;
    @FindBy(xpath = "//button[.='Deposit']")
    WebElement submitDepositButton;
    @FindBy(xpath = "//span[contains(text(),'Successful')]")
    WebElement depositMessage;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawButton;
    @FindBy(tagName = "input")
    WebElement withdrawAmount;
    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement submitWithdrawButton;
    @FindBy(xpath = "//span[contains(text(),'Transaction')]")
    WebElement withdrawMessage;
    @FindBy(xpath = "//div[@class='center']//strong[2]")
    WebElement customerPageBalance;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawDebit;

//    @FindBy(xpath = "//tr[@id='anchor0']//td")
//    List<WebElement> depositTransaction;
//    @FindBy(xpath = "//tr[@id='anchor1']//td")
//    List<WebElement> withdrawTransaction;
//    static double balance = 0;

    public void loginFunctionality(String name, String expectedMessage) {
        BrowserUtils.selectBy(nameSelectBox, name, "text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage),expectedMessage);
    }

    public void depositFunctionality(String depositAmount, String expectedDepositMessage) {
        depositButton.click();
        this.depositAmount.sendKeys(depositAmount);
        submitDepositButton.click();
        Assert.assertEquals(BrowserUtils.getText(depositMessage), expectedDepositMessage);
    }

    public void withdrawFunctionality(String withdrawAmount, String expectedWithdrawMessage) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(2000);
        this.withdrawAmount.sendKeys(withdrawAmount);
        submitWithdrawButton.click();
        Assert.assertEquals(BrowserUtils.getText(withdrawMessage), expectedWithdrawMessage);
    }


    public void transactionFunctionality() throws InterruptedException {
        int actualBalance=Integer.parseInt(BrowserUtils.getText(customerPageBalance));
        Thread.sleep(5000);//this needs to be before clicking since click was failing
        transactionButton.click();

        int expectedBalance=(Integer.parseInt(BrowserUtils.getText(depositCredit))-
                Integer.parseInt(BrowserUtils.getText(withdrawDebit)));
        Assert.assertEquals(actualBalance,expectedBalance);

    }


//    public double depositTransactionFunctionality(double depositAmount) {
//
//        for (WebElement depositData : depositTransaction) {
//            if (BrowserUtils.getText(depositData).contains("Credit")) {
//            }
//        }
//        return balance += depositAmount;
//    }
//
//    public double withdrawTransactionFunctionality(double withdrawAmount) {
//        for (WebElement withdrawData : withdrawTransaction) {
//            if (BrowserUtils.getText(withdrawData).contains("Debit")) {
//            }
//        }
//        return balance -= withdrawAmount;
//    }
//
//    public void balanceFunctionality() throws InterruptedException {
//        double customerPageBalancePrice = Double.parseDouble(BrowserUtils.getText(customerPageBalance));
//        depositTransactionFunctionality(500);
//        withdrawTransactionFunctionality(300);
//        Thread.sleep(2000);
//        Assert.assertEquals(customerPageBalancePrice, balance);
//
//    }


}
