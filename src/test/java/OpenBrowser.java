import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.youtube.com/");
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/ul[2]/li[1]/div/a/img")).click();
    }
}
