package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/yabin/Downloads/Techtorial%20(1).html");
        WebElement box= driver.findElement(By.xpath("//select[@name='country']"));
        Select countryOptions= new Select(box);
        Assert.assertEquals(countryOptions.getFirstSelectedOption().getText().trim(),"UNITED STATES ".trim());

        //print out all the options and count
        List<WebElement> allOptions=countryOptions.getOptions();
        int count=0;
        for (int i=0; i<allOptions.size();i++){
            System.out.println(allOptions.get(i).getText().trim());
            count++;
        }
        System.out.println(count);
        countryOptions.selectByVisibleText("CHINA ");//choose own country
        Thread.sleep(2000);
        //choose fav country with ByValue:
        countryOptions.selectByValue("132");//MEXICO
        Thread.sleep(2000);
        //choose a country you want to travel (Index)
        countryOptions.selectByIndex(9);//AMERIA
    }

}
