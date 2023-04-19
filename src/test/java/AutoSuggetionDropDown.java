import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggetionDropDown {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//div[text()=\"Accept all\"]")).click();
        WebElement search=driver.findElement(By.className("gLFyf"));
        search.sendKeys("makem");
        Thread.sleep(2000);
        search.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.quit();
    }
}
