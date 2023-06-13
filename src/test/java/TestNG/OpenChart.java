package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChart {
    @Test
    public void successfulLogin(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        /*
        validate the log in with username and password both "demo"
        and validate the title to be 'dashboard'
         */
        WebElement userName= driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        login.click();
        WebElement close=driver.findElement(By.xpath("//button[@class='btn-close']"));
        close.click();
        String actualTitle=driver.getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void validateLogIn() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName= driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("DEMO");
        WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        login.click();
        WebElement close=driver.findElement(By.xpath("//button[@class='btn-close']"));
        close.click();
        Thread.sleep(2000);
        WebElement errorMessage=driver.findElement(By.cssSelector("#alert"));
        String actualMessage=errorMessage.getText().trim();
        String expectedMessage="No match for Username and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName= driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        login.click();
        WebElement close=driver.findElement(By.xpath("//button[@class='btn-close']"));
        close.click();
        Thread.sleep(2000);
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton=driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();

        List<WebElement> list=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i=1;i<list.size();i++){
            Thread.sleep(1000);
            Assert.assertTrue(list.get(i).isDisplayed());
            Assert.assertTrue(list.get(i).isEnabled());
            Assert.assertFalse(list.get(i).isSelected());
            list.get(i).click();
            Assert.assertTrue(list.get(i).isSelected());
            list.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }
    @Test
    public void validateProductNameAscendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        login.click();
        WebElement close = driver.findElement(By.xpath("//button[@class='btn-close']"));
        close.click();
        Thread.sleep(2000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();

        WebElement productNameButton=driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
        productNameButton.click();
        Thread.sleep(2000);

        List<WebElement> allProductNames=driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames=new ArrayList<>();
        for (int i =1; i<allProductNames.size();i++){
            actualNames.add(allProductNames.get(i).getText().toLowerCase().trim());
            //use .lowercase because the Ascii table lowercase comes first
            expectedNames.add(allProductNames.get(i).getText().toLowerCase().trim());
       //now both lists have same order and same items
        }

        Collections.sort(expectedNames);//ascending

        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames,expectedNames);
    }
    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        login.click();
        WebElement close = driver.findElement(By.xpath("//button[@class='btn-close']"));
        close.click();
        Thread.sleep(2000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();

        WebElement productNameButton=driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
        productNameButton.click();
        Thread.sleep(2000);

        List<WebElement> allProductNames=driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames=new ArrayList<>();
        for (int i =1; i<allProductNames.size();i++){
            actualNames.add(allProductNames.get(i).getText().toLowerCase().trim());
            //use .lowercase because the Ascii table lowercase comes first
            expectedNames.add(allProductNames.get(i).getText().toLowerCase().trim());
            //now both lists have same order and same items
        }

        Collections.sort(expectedNames);//ascending
        Collections.reverse(expectedNames);
        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames,expectedNames);
    }
}
