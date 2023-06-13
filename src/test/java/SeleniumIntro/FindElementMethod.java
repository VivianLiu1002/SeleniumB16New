package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class FindElementMethod {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //wait for 20 seconds and see if the elements are loading
        driver.navigate().to("file:///C:/Users/yabin/Downloads/Techtorial.html");

        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));//4elements
        for (WebElement box : allBoxes){
            if (box.isDisplayed()&& box.isEnabled() &&!box.isSelected()){
                Thread.sleep(3000);//just to slow down and show
                box.click();
            }
        }





    }
}
