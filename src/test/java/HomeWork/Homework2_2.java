package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class Homework2_2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement message=driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualMessage.equals(expectedMessage)? "passed":"failed");
        driver.quit();


    }
}
