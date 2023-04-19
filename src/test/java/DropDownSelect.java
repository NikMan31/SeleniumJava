//DropDown select mate apne Select class ni help laishu
// first:- apne aa parents elements na location ne find out karvanu
// second:- Then apne Select class no object define karvano and pass that elements while define object
// third:- by using that object, apply various function. As you can see in the below example where I have been taking selectByValue method
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        WebElement DOB=driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]"));
        Select select=new Select(DOB);
        int i=0;
        for (i=1; i<=31;i++){
            select.selectByValue(String.valueOf(i));
            //select.selectByVisibleText("1");
            //select.selectByIndex("1");
        }

        WebElement DOM=driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"));
        Select select1=new Select(DOM);
        for (int j=1; j<=12; j++){
            select1.selectByValue(String.valueOf(j));
        }

        WebElement DOY=driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]"));
        Select select2=new Select(DOY);
        for(int y=2000; y<=2023; y++){
            select2.selectByValue(String.valueOf(y));
        }


    }
}
