//For applying Explicit wait you need to take use of WebDriverWait class and then Give condition by using ExpectedCondition keyword
//Basically Explicit wait che... Aa given condition fulfill nay thaay tya sudhi given time sudji
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        //WebDriverWait wait=new WebDriverWait(driver, 10); //This is WebDriverWait class
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"gdpr-banner-accept\"]"))).click(); //Here I am defining condition
    }
}
