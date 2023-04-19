//Basic format for Xpath is //tagname[@Attribute="Value"]
                            //tagname means it is starting tag
//<input id="UserFirstName-mAA9" type="text" name="UserFirstName" aria-required="true" required="true" aria-describedby="UserFirstName-mAA9-errMsg" aria-invalid="true">
            //In the above tag <input> is tagname, inside in this tag all are attribute and value
            ////input[@id="UserFirstName]
// There are 2 types of Xpath, Absolute and relative
// Absolute means its always start with / (single slash) and start from root
// Relative means its always start with // (Double slash), below example is of relative
// Xpath using text() = //input[text()="any texts"]
// Xpath using OR and AND = //input[@Attribute="Value" or/and @Attribute="Value"]
//Xpath using Axes mathod:- which has 3 another methods, like parents, child, self (Relative jevu j che but ama apne elements parents, child k self thi found out karia)
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name=\"login-button\"]")).click();

    }
}
