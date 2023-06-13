package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
       // or: WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile= driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\yabin\\Desktop\\usa.png");
       WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
       uploadButton.click();//or uploadButton.submit();
       WebElement validateFileName= driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(validateFileName),"usa.png");
    }
    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");

        WebElement chooseFile= driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\yabin\\Desktop\\usa.png");
        WebElement selectFileMessage= driver.findElement(By.xpath("//b[contains(text(),'file to send')]"));
        Assert.assertEquals(BrowserUtils.getText(selectFileMessage),"Select file to send(max 196.45 MB)");
        WebElement acceptButton= driver.findElement(By.cssSelector("#terms"));
       if(acceptButton.isDisplayed() && acceptButton.isEnabled() &&!acceptButton.isSelected()){
        acceptButton.click();
       }
        WebElement submitButton= driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        WebElement uploadMessage= driver.findElement(By.xpath("//h3//center"));
        Assert.assertEquals(BrowserUtils.getText(uploadMessage),"1 file\n" +
                "has been successfully uploaded.");
    }

}
