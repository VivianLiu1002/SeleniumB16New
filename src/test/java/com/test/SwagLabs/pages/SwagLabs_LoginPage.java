package com.test.SwagLabs.pages;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabs_LoginPage {
    public SwagLabs_LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#user-name")
    WebElement userName;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(xpath = "//h3")
    WebElement errorMessage;


    public void loginFunctionality(String userName,String Password){
        this.userName.sendKeys(userName);
        password.sendKeys(Password);
        loginButton.click();
    }
   public String errorMessage(){
       return BrowserUtils.getText(errorMessage);
   }
   public void login(){
        userName.sendKeys(ConfigReader.readProperty("SwagLabs_userName"));
        password.sendKeys(ConfigReader.readProperty("SwagLabs_password"));
        loginButton.click();
   }
}
