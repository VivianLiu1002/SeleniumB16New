package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void FramePractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        //print out the header:
        WebElement header= driver.findElement(By.xpath("//h3[contains(text(),'containing the TinyMCE')]"));
        System.out.println(BrowserUtils.getText(header));

        driver.switchTo().frame("mce_0_ifr");//can be reached by name. ID. or WebElement
        //switch to external frame/html first in order to touch anything within the frame
        //-->frame is sort of a protection for that specific element
        WebElement content=driver.findElement(By.cssSelector("#tinymce"));
        content.clear();
        content.sendKeys("I love Selenium");

        driver.switchTo().parentFrame(); //jump to the bigger frame of the page
        //otherwise won't be able to reach the header again since the driver is inside of the inner frame
        System.out.println(BrowserUtils.getText(header));

    }
    @Test
 /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial"
  5-Print out(NO validation) all the links from website
  6-Wait for Second task
 */
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilionButton= driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilionButton.click();

        BrowserUtils.switchByTitle(driver,"qavalidation");
        WebElement seleniumPython= driver.findElement(By.xpath("//span[contains(text(),'Selenium-Python')]"));
        Actions actions=new Actions(driver);

        WebElement seleniumButton= driver.findElement(By.linkText("Selenium"));
        actions.moveToElement(seleniumButton).perform();
        actions.click(seleniumPython).perform();

        WebElement header= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header),"Selenium-Python Tutorial");
        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));
        for (WebElement link : allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */
        BrowserUtils.switchByTitle(driver,"iframes");//going to main page
        driver.switchTo().frame("Frame1");//going into the frame
        WebElement category1=driver.findElement(By.linkText("Category1"));
        Thread.sleep(2000);
        category1.click();
        //have to switch to the right page again:
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");

        WebElement headerCategory1= driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(headerCategory1),"Category Archives: SeleniumTesting");

        //if the list didn't print,however, it doesn't throw exception
        //so need to pay extra attention here, by adding Thread.sleep to slow down system in order to catch
        //all elements
        System.out.println("+++++++++++++++++++++++++++");
        Thread.sleep(2000);
        List<WebElement> allHeaders=driver.findElements(By.xpath("//h3//a"));
        for (int i=0; i<allHeaders.size();i++){
            System.out.println(BrowserUtils.getText(allHeaders.get(i)));
        }
/*
TASK 3:
1-Go back mainPage- print out i am inside frame
2-Click Category3
3-Validate the header "Category Archives: SoftwareTesting"
 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");
        WebElement frameMessage= driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(frameMessage));
        //go out of frame1 in order to jump into another frame:
        driver.switchTo().parentFrame();
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();

        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        //pay attention to which tab it's switching, there're partial repeated titles
        WebElement category3Header=driver.findElement(By.xpath("//div[@class='wf-wrap']//h1"));
        Assert.assertEquals(BrowserUtils.getText(category3Header),"Category Archives: SoftwareTesting");



    }

}
