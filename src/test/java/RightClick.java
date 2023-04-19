import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://jqueryui.com/");

        //contextClick means it will perform right click wherever aero is
        Actions actions=new Actions(driver);
        //actions.contextClick().perform();

        //perform contextClick on particular element
        WebElement targetEleForRightClick=driver.findElement(By.xpath("//a[text()=\"Resizable\"]"));
        actions.contextClick(targetEleForRightClick).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
}
