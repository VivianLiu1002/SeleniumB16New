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

public class AlertIntro {
    @Test
    public void AlertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText= alert.getText().trim();//will get the text from the pop-up that i cannot inspect
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);

        alert.accept(); //it'll click the ok button, otherwise will get an UnhandledAlertException
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void AlertDismiss(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsConfirm= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss(); //click the cancel button
        WebElement message= driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        Assert.assertEquals(BrowserUtils.getText(message),"You clicked: Cancel");

    }
    @Test
    public void AlertSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(2000);//slowing down to see the process
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("homework is important");
        alert.accept();// cannot use keys.ENTER, because alert is not a webElement
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#result"))),"You entered: homework is important");

    }
}
