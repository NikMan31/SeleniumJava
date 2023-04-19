import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCredentialPopUp {
    public static WebDriver driver;
    public static String username="admin"; //From here, It might read from extrnak
    public static String password="admin";
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth");

        // Way 1
        //Just add username and password at the start of the URL as like below,
        //https://admin:admin@the-internet.herokuapp.com/basic_auth

        //Way 2
        //Just use variable of Username and password in the URl
        ////https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth
    }
}
