package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class DriverFindElementPractice {
    public static void main(String[] args) {
        /*
        print out all links
        and count how many links are there
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        //print if the length is equal and more than 12 and count
        List<WebElement> list=driver.findElements(By.tagName("li"));// or By.xpath("//li")
        int count =0;
        for (WebElement element : list){
            if (element.getText().length()>=12){
                System.out.println(element.getText());
                count++;
            }
        }
        System.out.println(count);




    }
}
