package ActionsClass;

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

public class PracticeActions {
    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage= BrowserUtils.getText(dropBox);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);

        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,dropBox).perform();

        dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        //re-assign it because of StaleElement exception
        String actualMessageAfter=BrowserUtils.getText(dropBox);
        String expectedMessageAfter="Dropped!";
        Assert.assertEquals(actualMessageAfter,expectedMessageAfter);

       String actualColor=dropBox.getCssValue("background-color");
       String expectedColor="rgba(70, 130, 180, 1)";
       Assert.assertEquals(actualColor,expectedColor);
    }
    @Test
    public void practiceClickAndHold(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement acceptButton= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();
        WebElement dropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        WebElement notAcceptable=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualNotAcceptableMessage=BrowserUtils.getText(notAcceptable);
        String expectedNotAcceptableMessage="Not Acceptable";
        Assert.assertEquals(actualNotAcceptableMessage,expectedNotAcceptableMessage);

        String ActualBeforeMessage=BrowserUtils.getText(dropBox);
        String expectedBeforeMessage="Drop here";
        Assert.assertEquals(expectedBeforeMessage,expectedBeforeMessage);

        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptable).moveToElement(dropBox).release().perform();

        dropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualAfterMessage=BrowserUtils.getText(dropBox);
        String expectedAfterMessage="Drop here";
        Assert.assertEquals(actualAfterMessage,expectedAfterMessage);




    }
}
