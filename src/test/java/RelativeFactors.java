import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeFactors {
    public static WebDriver driver;
    public static String browser = "chrome";
    public static void main(String[] args) {
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        driver.get("https://www.saucedemo.com/");
        WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement passwordFiled=driver.findElement(with(By.tagName("input")).below(userName));
        passwordFiled.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

    }
}
