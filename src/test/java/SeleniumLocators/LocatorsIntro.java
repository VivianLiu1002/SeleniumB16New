package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.zip.CheckedInputStream;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        //to test web elements
        //Locators  --> is a way to locate(find) element and manipulate on it

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/yabin/Downloads/Techtorial.html");//copy the url from website
        driver.manage().window().maximize();
        //id locator:
        WebElement header = driver.findElement(By.id("techtorial1"));//grab from the website inpsect
        String actualHeader=header.getText().trim(); //it gets the text from element
        String expectedHeader= "Techtorial Academy";//normally from a test document
        System.out.println(header.getText());
        System.out.println( actualHeader.equals(expectedHeader) ? "Correct" : "Wrong");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());//to print out the paragraph on the page

        //Name locator:
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Vivian");//system will write the name on website at this location
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Liu");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("123-456-7890");
        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("vivianliu@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("123 Main St.");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Hanover Park");
        WebElement state= driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("60133");

        //class locator:
        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        //check the functionality of the box:
        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();//system will select the box
        }
        System.out.println(javaBox.isSelected() ? "Selected" : "not Selected");

    WebElement testNG = driver.findElement(By.id("cond3"));
    if (testNG.isDisplayed() && !testNG.isSelected()){
        testNG.click();
    }
        System.out.println(testNG.isSelected() ? "testNG is selected" : "testNG is not selected");
    WebElement cucumber=driver.findElement(By.id("cond4"));
    if (cucumber.isDisplayed() && !cucumber.isSelected()){
        cucumber.click();
    }
        System.out.println(cucumber.isSelected() ? "cucumber is selected" : " cucumber is not selected");

        //tag name locator:
        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());//Techtorial Academy
        WebElement useJavaVersion=driver.findElement(By.tagName("u"));
        System.out.println(useJavaVersion.getText());//Use Java Version
        Thread.sleep(2000);
        driver.quit();
    }
}
