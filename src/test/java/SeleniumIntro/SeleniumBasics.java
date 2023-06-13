package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {
    //first step is: setting your automation
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //temporary bug from Chrome, so we're adding these following 2 lines:
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //then create your driver to start automation
        WebDriver driver = new ChromeDriver(options);//to connect the driver to the website
        driver.get("https://www.amazon.com/"); //directing the driver to the website we want

        System.out.println(driver.getTitle());//just to show the website
        String actualTitle = driver.getTitle(); //coming from the system
        String expectedTitle ="Amazon.com. Spend less. Smile more.";//coming from us (based on the website)
                                                                    //click inspect, search for title,and copy
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title pass");
        }else {
            System.out.println("Title fail");
        }
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        System.out.println( actualUrl.equals(expectedUrl) ? "Url passed" :"Url failed" );
        driver.close();
    }
}
