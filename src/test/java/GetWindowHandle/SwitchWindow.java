package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));//opening a new window --> from main page

        System.out.println(driver.getWindowHandle());//will return the id of the page that the driver pointing
        //which in here is Main page ID --> The Internet
        String mainPageId=driver.getWindowHandle();//store main page ID
        Set<String> allPagesID=driver.getWindowHandles(); //returns set collection
        System.out.println(allPagesID);//printing out IDs of all pages that are open

        for (String id : allPagesID){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));//new window -->from the opening page

    }
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2= driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollWithJS(driver,button2);//failed without this because the screen couldn't see button2 when it first open

        Thread.sleep(2000);
        button2.click();
        Thread.sleep(2000);


//        String firstPageID= driver.getWindowHandle();
//        Set<String> allPagesID= driver.getWindowHandles();
//
//        for (String id: allPagesID){
//            if (!id.equals(firstPageID)){
//               driver.switchTo().window(id);
//               break;
//            }
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
            Assert.assertEquals(driver.getTitle().trim(),"AlertsDemo - H Y R Tutorials");
Thread.sleep(2000);
           WebElement alertHeader= driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
            Assert.assertEquals(BrowserUtils.getText(alertHeader),"AlertsDemo");

        }






    }

