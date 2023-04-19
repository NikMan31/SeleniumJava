import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        WebElement radio1=driver.findElement(By.id("bmwradio"));
        radio1.click();
        System.out.println(radio1.isSelected());

        WebElement radio2=driver.findElement(By.id("benzradio"));
        radio2.click();
        System.out.println(radio2.isSelected());

        WebElement radio3=driver.findElement(By.id("hondaradio"));
        radio3.click();
        System.out.println(radio3.isSelected());

        System.out.println(driver.findElements(By.xpath("//input[@type=\"radio\"]")).size());
    }
}
