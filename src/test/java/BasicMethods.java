//get():- load new website
//getCurrentUrl():- use for fatching URL for current website
//getTitle():- use for fatching title for website
//getpageSource():- use for fatching source code for last website or current website
//navigate():- use for navigate to another website it can be agal ni k pachhal ni k navi website
//quit():- use for close browser with all the opned tab
//close():- use for close current tab
//findelements():- ujse for finding multiple items at a time means in form of list
//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html     this link for all common methods for selenium

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BasicMethods {

    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/"); // This will load this website
        driver.manage().window().maximize();  // This all method for windows

        /*String currentURK=driver.getCurrentUrl(); // This is the gerCurrentUrl()
        System.out.println(currentURK);

        String titleForWebsite=driver.getTitle();
        System.out.println(titleForWebsite);

        String pageSource=driver.getPageSource();
        System.out.println(pageSource);*/

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> allItems= driver.findElements(By.id("//div[@class=\'inventory_list\']/div"));  //Xpath //div[@class="inventory_list"]/div aya /div means it will refer all the items below mentioned parental xpath
        System.out.println(allItems);

        //driver.navigate().to("https://google.com");

        driver.quit();

    }
}
