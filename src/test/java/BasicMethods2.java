//clear():- If the element is a text entry element, this method will clear value
//getAttribute():- Get the value of the given attribute of the element
//getCssValue():- Get the CSS property of the given attribute of the element
//getLocation():- Get the location of the attribute
//getSize():- Get the width and height of the rendered element
//getTagName():- Get the main tag name of this elements
//getText():- Get the visible text
//isDisplayed():- use for validate Is this element displayed or not ?
//isEnabled():- use for validate is the elements currently enabled or not ?
//is Selected():- Determine whether or not this element selected or not ?

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicMethods2 {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        /*WebElement userName=driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        userName.clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();*/
        System.out.println(driver.findElement(By.id("user-name")).getAttribute("placeholder"));
        System.out.println(driver.findElement(By.id("login-button")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.id("login-button")).getSize());
        System.out.println(driver.findElement(By.id("login-button")).getLocation());
        System.out.println(driver.findElement(By.id("login-button")).getTagName());
        System.out.println(driver.findElement(By.id("login-button")).isDisplayed());
        System.out.println(driver.findElement(By.id("login-button")).isEnabled());
        System.out.println(driver.findElement(By.id("login-button")).isSelected());
    }
}
