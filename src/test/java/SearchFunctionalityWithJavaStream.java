import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFunctionalityWithJavaStream {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //Here I am sending text at search bar
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        //Now I will fatch all the matched elements
        List<WebElement> matchElements=driver.findElements(By.xpath("//tbody/tr/td[1]"));

        //Now using Java stream I will check that particular element having same word in the Name
        //For example, When I type rice then all the rice should come like brown rice, basmati rice etc

        matchElements.stream().filter(veggie->veggie.getText().contains("Rice")).forEach(element -> System.out.println(element));

    }
}
