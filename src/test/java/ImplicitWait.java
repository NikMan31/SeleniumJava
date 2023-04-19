//Implicit wait means, aa wait tya sudhi raah joshe jya sudhi ene given time ma element naay male tya sudhi, ak vaar element m,ali jashe to te ahead move on karshe
//Ex, MouseHover karya pachhi suppose subelements ne load thata time lage che to tya implicit wait mukaay
//ak vakhat website full load thaay jaay pachhi automatic sub element malshe and ana upper click karshe

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nike.com/gb/");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[2]/div/div[2]/div[2]/button/span")).click();

        Actions actions=new Actions(driver);

        WebElement mouseHover=driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/header/div/div[1]/div[2]/nav/div[2]/div/ul/li[2]/a"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); //This is the implicit wait
        actions.moveToElement(mouseHover).moveToElement(driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/header/div/div[1]/div[2]/nav/div[2]/div/ul/li[2]/div/div/div[2]/a[3]"))).click().perform();
    }
}
