import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        WebElement mouseHoverBtn=driver.findElement(By.id("mousehover"));
        Actions actions=new Actions(driver);
        actions.moveToElement(mouseHoverBtn).moveToElement(driver.findElement(By.xpath("//a[text()=\"Reload\"]"))).click().perform();
    }
}
