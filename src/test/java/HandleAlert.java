//There are 4 differents method to handle alert button
    //accept()
    //dismiss()
    //getText()
    //sendKeys()

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");

        driver.findElement(By.id("name")).sendKeys("admin");
        WebElement alrtButton=driver.findElement(By.id("alertbtn"));
        alrtButton.click();

        Alert alertPOPUP=driver.switchTo().alert(); //Basically If you want to store something for alert then You need to use Alert datatype and this is for only example
        System.out.println(alertPOPUP.getText());

        driver.switchTo().alert().accept();

    }
}
