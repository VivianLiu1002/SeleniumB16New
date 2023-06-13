package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver) {//create constructor to initialize elements
        PageFactory.initElements(driver, this);//it does same logic of driver.findElement in this page
    }

    @FindBy(css = ".mainHeading") //needs to be outside of the constructor
    WebElement header;//instance variable

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    @FindBy(xpath = "//button[contains(text(),'Manager Login')]")
    WebElement managerLogin;

    public void LoginPageComponentValidation(String expectedHeader) {
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed() && customerLogin.isEnabled());
        Assert.assertTrue(managerLogin.isDisplayed() && managerLogin.isEnabled());
    }

    public void clickManagerButton() {//normally for buttons, create independent methods for each
        managerLogin.click();
    }

    public void clickCustomerLoginButton() {
        customerLogin.click();
    }


}
