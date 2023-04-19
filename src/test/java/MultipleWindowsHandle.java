import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsHandle {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.findElement(By.id("openwindow")).click();

        Set<String> multipleWindows=driver.getWindowHandles();
        System.out.println(multipleWindows); //At the terminal you can see, Here there are 2 windows screen


        Iterator<String> iterator=multipleWindows.iterator();//Basically Iterator is use for visit all the windows

        String parentsWin=iterator.next();
        String childWin=iterator.next();

        driver.switchTo().window(childWin);

        driver.findElement(By.xpath("//p[text()=\"Novice To Ninja + Interview Guide\"]")).click();

        driver.switchTo().window(parentsWin);

    }
}
