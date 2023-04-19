import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderHandle {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://jqueryui.com/slider/");

        WebElement frame=driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);

        WebElement slider=driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));

        Actions actions=new Actions(driver);

        actions.dragAndDropBy(slider, 150, 100).perform();
    }
}
