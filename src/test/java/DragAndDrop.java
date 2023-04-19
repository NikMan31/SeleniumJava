import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        WebElement frame=driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);

        //Here, This drag and drop are belonging to the one of the iFrame so We need to switch to that frame
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));

        //For Drag and Drop action we will use Action class

        Actions actions=new Actions(driver);

        actions.dragAndDrop(drag, drop).perform();

    }
}
