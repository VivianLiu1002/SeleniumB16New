package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework2_3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement userName= driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";

        System.out.println(actualUrl.equals(expectedUrl)? "passed":"failed");
        driver.quit();

    }
}
