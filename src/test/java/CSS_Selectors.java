// CSS selectors:- tagName[AttributeName="Value"]
    //If, CSS selectors has ID then tagName#Value
    // If, CSS selectors has Class than tagName.Value

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Selectors {

    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        //By CSS ID
        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user"); //Here, input is tagName # indicating Id and user-name is value
        driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce"); //Here, input is tagName # indicating Id and password is value
        driver.findElement(By.cssSelector("input#login-button")).click(); //Here, input is tagName # indicating id and login-button is value


        //Multiple CSS selectors
        //<input class="input_error form_input error" placeholder="Username" type="text" data-test="username" id="user-name" name="user-name" autocorrect="off" autocapitalize="none" value="">
        //input[class="input_error form_input error"][id="user-name"]
    }
}
