import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AllLinksCountOnPage {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("Total number of Tgs:= "+allLinks.size());
        for (int i=0; i< allLinks.size();i++){
            System.out.println("Link is"+allLinks.get(i).getAttribute("href"));  //Aya allLinks.get(i) atle lakhyu che k ano data type apne upper List<> define karyo che atle k aa list mathi one by one all <a> tag no attribute <href> print thase
            System.out.println(allLinks.get(i).getText());
        }
        driver.quit();
    }
}
