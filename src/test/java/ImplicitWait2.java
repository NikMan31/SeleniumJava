import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ImplicitWait2 {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); //Implicit wait ()
        //Jo hu aya implicit wait apply na karu to... cookie accept j nati thati bucause cookie nu button
        // jyare hu trigger karu tyare cookie accept button ready j natu matlab website load j nati thay ... atle
        // tya me 10 sec no implicit wait mukyo matlab jyre website load thase tyre cookie nu button accept thay jashe
        //Accepting Cookie
        WebElement AccptCokkie=driver.findElement(By.xpath("//*[@id=\"gdpr-banner-accept\"]"));
        AccptCokkie.sendKeys(Keys.ENTER);

        Actions actions=new Actions(driver);

        WebElement mouseHoverOnElectronis=driver.findElement(By.xpath("/html/body/div[6]/div[1]/ul/li[4]/a"));
        actions.moveToElement(mouseHoverOnElectronis).perform();

        WebElement clickOnApplieiPhone=driver.findElement(By.xpath("/html/body/div[6]/div[1]/ul/li[4]/div[2]/div[1]/nav[2]/ul/li[4]/a"));
        clickOnApplieiPhone.click();
    }
}
