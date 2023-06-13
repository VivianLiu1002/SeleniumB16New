package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js=driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        //opening 3 tabs

        String firstPageID= driver.getWindowHandle();
        Set<String> allPagesID= driver.getWindowHandles();
        for (String id : allPagesID){
            if (!id.equals(firstPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        //by using BrowserUtils, it shortens the code into just 1 line:
        BrowserUtils.switchByTitle(driver,"Contact us");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //switch to the page based on title --> contains, meaning no need to put all in there:
        BrowserUtils.switchByTitle(driver,"-Rated Coding Bootcamp");
        System.out.println(driver.getTitle());//printing out the page title

        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());
    }
    @Test
      /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4= driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();

        BrowserUtils.switchByTitle(driver,"Basic Controls ");
        WebElement firstName= driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Vivian");
        WebElement lastName= driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Liu");
        WebElement femaleButton= driver.findElement(By.xpath("//input[@id='femalerb']"));
        BrowserUtils.scrollWithJS(driver,femaleButton);
        femaleButton.click();
        WebElement englishButton=driver.findElement(By.xpath("//input[@id='englishchbx']"));
        englishButton.click();
        Thread.sleep(2000);
        WebElement chineseButton= driver.findElement(By.cssSelector("#chinesechbx"));
        chineseButton.click();
        Thread.sleep(2000);
        WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("vivianliu1002@gmail.com");
        WebElement password= driver.findElement(By.cssSelector("#password"));
        password.sendKeys("123456");
        WebElement register=driver.findElement(By.cssSelector("#registerbtn"));

        Thread.sleep(2000);
        WebElement bottomPage= driver.findElement(By.xpath("//a[contains(text(),'Asked Questions Abou')]"));
        BrowserUtils.scrollWithJS(driver,bottomPage);
        register.click();

        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.cssSelector("#msg"))),"Registration is Successful");
        BrowserUtils.switchByTitle(driver,"Window Handles");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//h1[@itemprop='name']"))),"Window Handles Practice");
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMe= driver.findElement(By.cssSelector("#promptBox"));
        clickMe.click();
        driver.quit();









    }
}
