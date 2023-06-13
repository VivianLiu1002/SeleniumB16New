package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.youtube.com/");
//Thread.sleep(2000);
        //song.sendKeys(Keys.Arrow_Down)

        WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Justin Bieber");
        search.sendKeys(Keys.ENTER);
        //WebElement button= driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        //button.click();
Thread.sleep(3000);
        List<WebElement> titles=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement title : titles){
            Thread.sleep(2000);
            title.sendKeys(Keys.ARROW_DOWN);
            if (title.getText().contains("Ghost")){
                title.click();
                break;
            }
        }


    }
}
