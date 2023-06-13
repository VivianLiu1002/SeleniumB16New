package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("file:///C:/Users/yabin/Downloads/Techtorial.html");
        driver.manage().window().maximize();


        //linkText locator:
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        String actualHeader = javaHeader.getText().trim();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "correct" : "false");
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumheader = driver.findElement(By.className("display-1"));
        String actualSeleniumHeader = seleniumheader.getText();
        String expectedS_Header = "Selenium automates browsers. That's it!";
        System.out.println(actualSeleniumHeader.equals(expectedS_Header) ? "Selenium passed" : "Selenium failed");
        driver.navigate().back();

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        String actualCucumberHeader = cucumberHeader.getText();
        String expectedCucumberHeader = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualCucumberHeader.equals(expectedCucumberHeader) ? "cucumber passed" : "cucumber failed");
        driver.navigate().back();

        WebElement testNGLink = driver.findElement(By.linkText("TestNG"));
        testNGLink.click();
        WebElement testNGHeader = driver.findElement(By.tagName("h2"));
        String actualTestNgHeader = testNGHeader.getText();
        String expectedTestNGHeader = "TestNG";
        System.out.println(actualTestNgHeader.equals(expectedTestNGHeader) ? "TestNG passed" : "TestNG failed");
        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "file:///C:/Users/yabin/Downloads/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "url passed" : "url failed");

        //locator partial link text: for the linktext "Rest Api"
            WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
            restApi.click();
        System.out.println(driver.getTitle());

    }
}
