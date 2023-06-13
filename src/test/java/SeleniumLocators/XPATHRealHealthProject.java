package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment Confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        //css with ID:
        WebElement appt=driver.findElement(By.cssSelector("#btn-make-appointment"));
        appt.click();

        WebElement userName=driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login=driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();

        WebElement facility=driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement readmission=driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (readmission.isDisplayed() && !readmission.isSelected()){
            readmission.click();
        }
        WebElement medicaid=driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();

        WebElement date=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("17/05/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I want to make an appointment");

        //CSS locator class:
        WebElement bookAppt=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppt.click();

        WebElement Header=driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
       // WebElement Header= driver.findElement(By.tagName("h2"));
        String actualHeader=Header.getText().trim();
        String expectedHeader="Appointment Confirmation";
        WebElement facility1=driver.findElement(By.xpath("//p[contains(text(),'Hongkong CURA Healthcare Center')]"));
        WebElement apply=driver.findElement(By.xpath("//p[.='Yes']"));
        WebElement medicaid1=driver.findElement(By.xpath("//p[.='Medicaid']"));
        WebElement date1=driver.findElement(By.xpath("//p[.='17/05/2023']"));
        WebElement comment1=driver.findElement(By.xpath("//p[contains(text(),'I want to make an app')]"));

        if (actualHeader.equals(expectedHeader)){
            System.out.println(actualHeader);
            System.out.println(facility1.getText());
            System.out.println(apply.getText());
            System.out.println(medicaid1.getText());
            System.out.println(date1.getText());
            System.out.println(comment1.getText());
        }

        WebElement goToHomePage=driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        goToHomePage.click();

        System.out.println(driver.getCurrentUrl());
        driver.quit();







    }
}
