package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class homeWork1 {
    /*
        Hello everyone, I see the excitement on your face and asking me to give you homework for tomorrow through DM. Here is the TASK:
1-Create a homework package and class
2-Under 1 main method--> go to 3 different websites and validate the title, and URL of the page with Ternary Operator.
 (It can be any website you decide)
SIDE NOTE: You do not need to create 3 different web drivers. One will be enough.
                     Send your code screenshot by replaying this thread.
 */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.netflix.com/");
        String actualTitle1=driver.getTitle();
        String expectedTitle1="Netflix - Watch TV Shows Online, Watch Movies Online";
        System.out.println(actualTitle1.equals(expectedTitle1)? "Netflix title passed" : "Netflix title failed");
        String actualUrl1= driver.getCurrentUrl();
        String expectedUrl1 = "https://www.netflix.com/";
        System.out.println(actualUrl1.equals(expectedUrl1) ? "Netflix Url passed" : "Netflix Url failed");

        driver.navigate().to("https://www.adidas.com/us");
        String actualTitle2= driver.getTitle();
        String expectedTitle2= "adidas Official Website | adidas US";
        System.out.println(actualTitle2.equals(expectedTitle2)? "Adidas title passed" : "Adidas title failed");
        String actualUrl2= driver.getCurrentUrl();
        String expectedUrl2= "https://www.adidas.com/us";
        System.out.println(actualUrl2.equals(expectedUrl2)? "Adidas Url passed": "Adidas Url failed");

        driver.navigate().to("https://www.hulu.com/welcome");
        String actualTitle3 = driver.getTitle();
        String expectedTitle3="Stream TV and Movies Live and Online | Hulu";
        System.out.println(actualTitle3.equals(expectedTitle3)? "Hulu title passed":"Hulu title failed");
        String actualUrl3=driver.getCurrentUrl();
        String expectedUrl3= "https://www.hulu.com/welcome";
        System.out.println(actualUrl3.equals(expectedUrl3)? "Hulu Url passed":"Hulu Url failed");







    }
}
