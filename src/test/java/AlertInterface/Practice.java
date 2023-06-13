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

public class Practice {
    @Test
    public void practiceJSAlert(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement clickMe1 = driver.findElement(By.cssSelector("#alertBox"));
        clickMe1.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();
        WebElement message= driver.findElement(By.xpath("//div[@id='output']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You selected alert popup");

        WebElement clickMe2= driver.findElement(By.cssSelector("#confirmBox"));
        clickMe2.click();
       alert.dismiss();//no need to create another alert, can just use the same one multiple times
        Assert.assertEquals(BrowserUtils.getText(message),"You pressed Cancel in confirmation popup");

        WebElement clickMe3= driver.findElement(By.cssSelector("#promptBox"));
        clickMe3.click();
       alert.sendKeys("Vivian Liu");
       alert.accept();
       Assert.assertEquals(BrowserUtils.getText(message),"You entered text Vivian Liu in prompt popup");//there's miss-spelling on the website
        //logically, this test should fail because of the miss-spelling  prompt --actual: propmt

    }
    
}
