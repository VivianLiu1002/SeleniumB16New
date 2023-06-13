package SelectClass;

import Utils.BrowserUtils;
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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    /*
    1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */
@Test
    public void validateOrderMessage() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

    WebElement oneWayButton= driver.findElement(By.xpath("//input[@value='oneway']"));
    oneWayButton.click();
    WebElement passengers= driver.findElement(By.xpath("//select[@name='passCount']"));
    Select passengerNumber=new Select(passengers);
    passengerNumber.selectByValue("4");
Thread.sleep(2000);
    WebElement depart=driver.findElement(By.xpath("//select[@name='fromPort']"));
    Select departOptions=new Select(depart);
    Assert.assertEquals(departOptions.getFirstSelectedOption().getText().trim(),"Acapulco");
    departOptions.selectByVisibleText("Paris");
Thread.sleep(2000);
    WebElement fromMonth=driver.findElement(By.xpath("//select[@name='fromMonth']"));
    Select fromMonthOptions=new Select(fromMonth);
    fromMonthOptions.selectByVisibleText("August");
    WebElement fromDay=driver.findElement(By.xpath("//select[@name='fromDay']"));
    Select fromDayOptions=new Select(fromDay);
    fromDayOptions.selectByValue("15");
Thread.sleep(1000);
    WebElement arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
    Select arrivingOptions= new Select(arriving);
    arrivingOptions.selectByVisibleText("San Francisco");
Thread.sleep(1000);
    WebElement returnMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
    Select returnMonthOptions=new Select(returnMonth);
    returnMonthOptions.selectByValue("12");
    WebElement returnDay= driver.findElement(By.xpath("//select[@name='toDay']"));
    Select returnDayOptions=new Select(returnDay);
    returnDayOptions.selectByVisibleText("15");
    Thread.sleep(1000);
    WebElement firstClassButton= driver.findElement(By.xpath("//input[@value='First']"));
    firstClassButton.click();
    Thread.sleep(1000);

    WebElement airlineButton=driver.findElement(By.xpath("//select[@name='airline']"));
    Select airlineSelections=new Select(airlineButton);

    List<WebElement> actualAirlineOptions=airlineSelections.getOptions();
    List<String> expectedAirlineOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

    for (int i =0; i<actualAirlineOptions.size();i++){
        Assert.assertEquals(actualAirlineOptions.get(i).getText(),expectedAirlineOptions.get(i));
    }
    airlineSelections.selectByVisibleText("Unified Airlines");

    WebElement continueButton= driver.findElement(By.xpath("//input[@name='findFlights']"));
    continueButton.click();

    WebElement message= driver.findElement(By.xpath("//font[@size='4']"));
    String actualMessage= message.getText().trim();
    String expectedMessage="After flight finder - No Seats Available";
    Assert.assertEquals(actualMessage,expectedMessage);

}
    @Test
    public void validateOrderMessageShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton= driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengers= driver.findElement(By.xpath("//select[@name='passCount']"));
//        Select passengerNumber=new Select(passengers);
//        passengerNumber.selectByValue("4");
        BrowserUtils.selectBy(passengers,"4","value");

        WebElement depart=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departOptions=new Select(depart);
        Assert.assertEquals(departOptions.getFirstSelectedOption().getText().trim(),"Acapulco");
        //departOptions.selectByVisibleText("Paris");
        BrowserUtils.selectBy(depart,"Paris","text");

        WebElement fromMonth=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        //Select fromMonthOptions=new Select(fromMonth);
        //fromMonthOptions.selectByVisibleText("August");
        BrowserUtils.selectBy(fromMonth,"August","text");

        WebElement fromDay=driver.findElement(By.xpath("//select[@name='fromDay']"));
//        Select fromDayOptions=new Select(fromDay);
//        fromDayOptions.selectByValue("15");
        BrowserUtils.selectBy(fromDay,"15","value");

        WebElement arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select arrivingOptions= new Select(arriving);
//        arrivingOptions.selectByVisibleText("San Francisco");
        BrowserUtils.selectBy(arriving,"San Francisco","text");

        WebElement returnMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
//        Select returnMonthOptions=new Select(returnMonth);
//        returnMonthOptions.selectByValue("12");
        BrowserUtils.selectBy(returnMonth,"12","value");

        WebElement returnDay= driver.findElement(By.xpath("//select[@name='toDay']"));
//        Select returnDayOptions=new Select(returnDay);
//        returnDayOptions.selectByVisibleText("15");
        BrowserUtils.selectBy(returnDay,"15","text");

        WebElement firstClassButton= driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();
        Thread.sleep(1000);

        WebElement airlineButton=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineSelections=new Select(airlineButton);

        List<WebElement> actualAirlineOptions=airlineSelections.getOptions();
        List<String> expectedAirlineOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for (int i =0; i<actualAirlineOptions.size();i++){
            Assert.assertEquals(actualAirlineOptions.get(i).getText(),expectedAirlineOptions.get(i));
        }
        airlineSelections.selectByVisibleText("Unified Airlines");

        WebElement continueButton= driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement message= driver.findElement(By.xpath("//font[@size='4']"));
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);

    }
}
