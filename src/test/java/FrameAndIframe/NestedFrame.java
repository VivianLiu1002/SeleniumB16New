package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        //name or id:
        driver.switchTo().frame("frame-top");//first layer -- top frame

        //WebElement --iframe:
        WebElement iframeLeft=driver.findElement(By.xpath("//frame[@name='frame-left']"));//2nd layer: left frame
        driver.switchTo().frame(iframeLeft);
        WebElement left= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));//LEFT

        driver.switchTo().parentFrame();//top frame
        driver.switchTo().frame("frame-middle");//middle frame
        WebElement middle= driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middle));//MIDDLE

        driver.switchTo().parentFrame();//top frame
        driver.switchTo().frame("frame-right");//right frame
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));//RIGHT

        //print out bottom:
        driver.switchTo().parentFrame();//switch to top frame
        driver.switchTo().parentFrame();//switch to the parent of both top and bottom (main html)
        driver.switchTo().frame("frame-bottom");//buttom frame
        WebElement bottom= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));//BOTTOM

        // go straight to the main html from any inner frames: (instead of jumping more than one time)
        driver.switchTo().defaultContent();
    }
}
