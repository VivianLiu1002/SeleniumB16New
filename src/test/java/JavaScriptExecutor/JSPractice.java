package JavaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void JSPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton= driver.findElement(By.xpath("//input[@id='yesRadio']"));

       // yesButton.click(); when this is not working:
        Actions actions=new Actions(driver);
        actions.click(yesButton).perform();

        //when actions is not working:
        // JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()" ,yesButton);
       WebElement yesText= driver.findElement(By.xpath("//p[@class='mt-3']"));

        String actualYesText= BrowserUtils.getText(yesText);
        String expectedYesText="You have selected Yes";
        Assert.assertEquals(actualYesText,expectedYesText);

WebElement noRadioButton= driver.findElement(By.cssSelector("#noRadio"));
Assert.assertTrue(noRadioButton.isEnabled());//false

        WebElement impressiveButton= driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
              //when if actions is not working:
                  actions.click(impressiveButton).perform();
                  WebElement impressiveText= driver.findElement(By.xpath("//p[@class='mt-3']"));
    }
    @Test
    public  void practice2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyRight= driver.findElement(By.xpath("//div[contains(text(),'Copyright ')]"));
        BrowserUtils.scrollWithJS(driver,copyRight);//scroll down to where the element located

        String actualCopyRight=BrowserUtils.getText(copyRight);
        String expectedCopyRight="Copyright © 2023";
        Assert.assertEquals(actualCopyRight,expectedCopyRight);

        WebElement applyNow= driver.findElement(By.linkText("Apply Now"));
        BrowserUtils.scrollWithJS(driver,applyNow);
       BrowserUtils.clickWithJS(driver,applyNow);

        Assert.assertEquals( BrowserUtils.getTitleWithJS(driver),"Apply Now");

        List<WebElement> allInformation = driver.findElements(By.xpath("//div[@data-element-id='columnsType11']//h3"));
        List<String> expectedInfo= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

      for (int i =0; i<allInformation.size();i++){
        Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInfo.get(i));
      }





    }
}
