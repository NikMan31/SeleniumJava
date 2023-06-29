import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class ElementScreenShot {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        //ChromeOptions chromeOptions=new ChromeOptions();


        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.youtube.com/");



        //Here my goal is to take screenshot of youtube logo
        WebElement logo=driver.findElement(By.id("logo-icon"));

        File file=logo.getScreenshotAs(OutputType.FILE); //Here I am taking use of File class
        FileUtils.copyFile(file, new File("Logo.png"));

        driver.quit();
    }
}
