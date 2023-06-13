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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
12- validate if the prices are ascending order ( from lowest to highest)
 */
    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");

        WebElement newOptions= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newOptions,"New", "text");
        WebElement makeOptions= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeOptions,"Lexus","text");
        WebElement modelOptions= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelOptions,"lexus-rx_350","value");

        WebElement maxPriceOptions= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select maxPrice=new Select(maxPriceOptions);
        Assert.assertEquals(BrowserUtils.getText(maxPrice.getFirstSelectedOption()),"No max price");

        WebElement distanceBox= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distanceBox,"40 miles","text");
        WebElement zipcode= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");
        WebElement searchButton= driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();

        WebElement header= driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        Assert.assertEquals(BrowserUtils.getText(header),"New Lexus RX 350 for sale");
        WebElement sortBox= driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortBox,"Lowest price","text");

        Thread.sleep(2000);
        List<WebElement> titles=driver.findElements(By.xpath("//h2[@class='title']"));
        for (int i =0; i<titles.size();i++){
            Assert.assertTrue(BrowserUtils.getText(titles.get(i)).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(titles.get(i)));
        }

        List<WebElement> prices=driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Double> actualPricesOrder=new ArrayList<>();
        List<Double> expectedPriceOrder=new ArrayList<>();
        for (WebElement price : prices){
           actualPricesOrder.add(Double.parseDouble(BrowserUtils.getText(price).replace("$","").replace(",","")));
           expectedPriceOrder.add(Double.parseDouble(BrowserUtils.getText(price).replace("$","").replace(",","")));
        }
        Collections.sort(expectedPriceOrder);
        System.out.println(actualPricesOrder);
        System.out.println(expectedPriceOrder);
        Assert.assertEquals(actualPricesOrder,expectedPriceOrder);




    }
}
