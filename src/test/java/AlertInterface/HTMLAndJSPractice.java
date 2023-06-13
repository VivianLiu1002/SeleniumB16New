package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTMLAndJSPractice {
    @Test
    public void practiceBoth(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement jsPreviewButton= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        jsPreviewButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        alert.accept();

        WebElement htmlPreviewButton = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        htmlPreviewButton.click();
        String actualMessage= BrowserUtils.getText(driver.findElement(By.xpath("//div[@class='swal-modal']")));
        //getting the whole message including OOPS
        Assert.assertTrue(actualMessage.contains("Something went wrong!"));
        WebElement okButton= driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();


    }
}
