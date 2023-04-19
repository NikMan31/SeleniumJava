import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicOperation {

    public static String browser = "chrome"; //Here, This chrome is suppose coming from extrenal CLV, XML file
    public static WebDriver driver; //Here, Webdrive is interface which consistes of all browser like chrome, edge, firefox etc. and chromedriver(), firefoxdriver() aa badha class che,

    // matlab maanage(), quit() function use karva mate badha class na alag alag objects create karva pade
    // Paan Webdriver aa common interface che for all this class atle banne class na object same name hoy to b its ohk
    // refre this link :- https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html
    public static void main(String[] args) throws InterruptedException {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        String baseURL = "https://www.saucedemo.com/";
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}