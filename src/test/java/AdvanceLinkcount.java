import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvanceLinkcount {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size()); //This will fatch all the link from entire page as driver is in global scope

        //Now my goal is to find all the link from footer only
        WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size()); //Here I am using fooetr instead of driver and scope of the footer driver is now limited to footer only

        // In the footer there are 4 various column but my task is to open all the link of first column in the new tab

        WebElement allTheLinkFor1stColumOfFooter=driver.findElement(By.xpath("//tbody/tr/td/ul"));
        System.out.println(allTheLinkFor1stColumOfFooter.findElements(By.tagName("a")).size()); //This will print 5
        for (int i=1; i<=allTheLinkFor1stColumOfFooter.findElements(By.tagName("a")).size(); i++){ //This loop will iterate 5 times
            allTheLinkFor1stColumOfFooter.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL, Keys.ENTER); //Now this will open all the link from 1st column
        }
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
     }
}
