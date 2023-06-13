package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class locatorPractice {
    public static void main(String[] args) throws InterruptedException {
         /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Vivian");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Liu");
        Thread.sleep(3000);

        WebElement gender= driver.findElement(By.id("sex-1"));
gender.click();
        WebElement experience =driver.findElement(By.id("exp-4"));
experience.click();

        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("05/16/23");

        WebElement profession1=driver.findElement(By.id("profession-0"));
        WebElement profession2= driver.findElement(By.id("profession-1"));
            profession1.click();
            profession2.click();

            WebElement continent=driver.findElement(By.id("continents"));
            continent.sendKeys("North America");
        Thread.sleep(3000);

            WebElement button=driver.findElement(By.id("submit"));
            button.click();

            String actualUrl=driver.getCurrentUrl();
            String expectedUrl="https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expectedUrl)? "url passed":"url failed");
        driver.quit();




    }

}
