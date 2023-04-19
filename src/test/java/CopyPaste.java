import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPaste {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.easyhindityping.com/english-to-gujarati-translation");

        Actions actions=new Actions(driver);

        WebElement sourceText=driver.findElement(By.xpath("//textarea[@id=\"SourceTextarea\"]"));
        sourceText.sendKeys("Hello, I am Nikunj Here");

        actions.keyDown(sourceText, Keys.CONTROL).sendKeys("A").sendKeys("C").perform();

        //Click on translate button
        /* WebElement transBtn=driver.findElement(By.xpath("//input[@id=\"SubmitTranslation\"]"));
        transBtn.click(); */

        WebElement DestinationText=driver.findElement(By.xpath("//textarea[@id=\"TargetTextarea\"]"));
        DestinationText.click();
        actions.keyDown(Keys.CONTROL).sendKeys("V").perform();



    }
}
