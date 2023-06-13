package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Vivian");
        WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Liu");
        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("vivianliu11@gmail.com");
        WebElement phone= driver.findElement(By.xpath("//input[@name='telephone']"));
        phone.sendKeys("1234567895");
        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Abc12345");
        WebElement confirm=driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirm.sendKeys("Abc12345");
        WebElement subscribe = driver.findElement(By.xpath("//input[@value='0']"));
        subscribe.click();
        WebElement agree=driver.findElement(By.xpath("//input[@name='agree']"));
        agree.click();
        WebElement cont=driver.findElement(By.xpath("//input[@value='Continue']"));
        cont.click();

       WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        String actualHeader= header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)? "header passed":"header failed");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";
        System.out.println(actualUrl.equals(expectedUrl) ? "url passed" : "url failed");

        driver.quit();





    }
}
