import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDeSelect {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        WebElement MultipSelectOption=driver.findElement(By.id("multiple-select-example"));
        Select select=new Select(MultipSelectOption);
        select.selectByValue("apple");
        select.selectByVisibleText("Peach");

        select.deselectByValue("apple");

        select.selectByValue("orange");

        select.deselectAll();
    }
}
