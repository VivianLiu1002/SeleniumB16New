package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selfPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/yabin/Downloads/Techtorial.html");//copy the url from website
        driver.manage().window().maximize();

        WebElement seleniumLink=driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String header=seleniumHeader.getText().trim();
        System.out.println(seleniumHeader.getText());
        String expectedHeader="Selenium automates browsers. That's it!";
        System.out.println(header.equals(expectedHeader) ? "selenium header passed" : "selenium header failed");
        driver.navigate().back();





    }

}
