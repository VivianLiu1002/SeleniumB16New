package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework2_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("http://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement name= driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("Vivian Liu");
        WebElement email=driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("vivian123@gmail.com");
        WebElement currentAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("123 Main St. Chicago, IL, 60616");
        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("567 Washington St. Chicago, IL, 60616");
        WebElement submit=driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(3000);
        submit.click();

        WebElement displayName= driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(displayName.getText().contains(""+name.getText()) ? "name passed":"name failed");
        WebElement displayEmail=driver.findElement(By.xpath("//p[@id='email']"));
        System.out.println(displayEmail.getText().contains(email.getText())? "email passed":"email failed");
        WebElement displayCurrentAddress=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        System.out.println(displayCurrentAddress.getText().contains(currentAddress.getText())? "current address passed":"current address failed");
        WebElement displayPermanentAddress=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        System.out.println(displayPermanentAddress.getText().contains(permanentAddress.getText())? "permanent address passed": "permanent address failed");
        driver.quit();





    }
}
