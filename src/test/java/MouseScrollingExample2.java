import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MouseScrollingExample2 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //For scrolling website here I am taking use of JavaSctript and in the JavaScript there one of the class name is executor

        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(3000);

        //To scroll down table on the webpage then
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> dateFrom4thColumn=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        System.out.println(dateFrom4thColumn.size());
        int sum=0;
        for (int i=0; i<dateFrom4thColumn.size();i++){
            sum=sum+Integer.parseInt(dateFrom4thColumn.get(i).getText()); //Here parseInt means converting String to Integer
        }

        System.out.println(sum);


    }
}
