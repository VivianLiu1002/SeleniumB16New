package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //wait for 20 seconds and see if the elements are loading
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        WebElement appt=driver.findElement(By.cssSelector("#btn-make-appointment"));
        appt.click();

        WebElement johnDoe= driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(johnDoe.getAttribute("value"));
        WebElement thisIsNotAPassword= driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']"));
        System.out.println(thisIsNotAPassword.getAttribute("type"));
    }
}
