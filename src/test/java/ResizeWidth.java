import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeWidth {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        //Instead of that, You can you use https://jqueryui.com/resizable/
        driver.get("https://jqueryui.com/");
        driver.findElement(By.xpath("//a[text()=\"Resizable\"]")).click();

        //Switching to the iframe
        WebElement frame=driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
        driver.switchTo().frame(frame);

        WebElement resize=driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));

        Actions actions=new Actions(driver);

        actions.dragAndDropBy(resize, 200,100).perform();
    }
}
