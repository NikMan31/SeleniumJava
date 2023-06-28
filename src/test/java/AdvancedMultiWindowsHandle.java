import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedMultiWindowsHandle {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();
        WebElement link=driver.findElement(By.xpath("//a[@target=\"_blank\"][1]"));
        link.click();
         // Multiple Windows handler
        Set<String> allTheWindows=driver.getWindowHandles();
        System.out.println(allTheWindows);

        Iterator<String> iterator=allTheWindows.iterator(); //Here iterator will help to iterate all the windows

        String parentalWindows=iterator.next();
        String childWindows=iterator.next();

        driver.switchTo().window(childWindows);

        System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());

        String emailAddressFromChildWindows= driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
                                            // driver.findElement(By.cssSelector("p.im-para.red")).getText() //It will return all the string
                                            //.split("at")[1] //This will split entire string from [at] means at hase tyathi string na bhag thase means [Please email us, mentor@rahulshettyacademy.com with below template to receive response] and temathi [1 select karshe]
                                            // .trim() //This method will remove all the space from front and end
                                            // .split(" ") //This will split string from  {space} means [mentor@rahulshettyacademy.com, with, below, template, to, receive, response] and among them choosing[0]
        driver.switchTo().window(parentalWindows);
        driver.findElement(By.id("username")).sendKeys(emailAddressFromChildWindows);

    }
}
