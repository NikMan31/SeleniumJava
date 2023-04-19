import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");

        driver.findElement(By.id("bmwcheck")).click();
        driver.findElement(By.id("bmwcheck")).click();
        driver.findElement(By.id("bmwcheck")).isSelected();

        driver.findElement(By.id("benzcheck")).click();
        driver.findElement(By.id("benzcheck")).click();

        driver.findElement(By.id("hondacheck")).click();
        driver.findElement(By.id("hondacheck")).click();

        System.out.println(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size());
        driver.close();
    }
}
