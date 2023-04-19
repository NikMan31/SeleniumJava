import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.Date;

public class ScreenShots {

    public static WebDriver driver;
    public static void main(String[] args) throws IOException {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.get("https://www.ebay.co.uk/");


        //Accepting cookie for ebay.com
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(1000));
        driver.findElement(By.xpath("//button[@id=\"gdpr-banner-accept\"]")).sendKeys(Keys.ENTER);

        //Step 1 :- For Taking Screen shot We need to import repo at pom.xml from MVNRepo and name of Repo is /*common io*/

        /*File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // This line I copied from Selenium Java doc
        FileUtils.copyFile(screenshotFile, new File(".//screenshot//ss.png"));*/

        //If I am using Above script for SS then There is one problem like Name of each ss will remain same means It will overright again and again
        //So for resolve this issue, I will use all SS name as per the time stamp and for that I need to take use of Date class in Java

        //When I am printing date Here at that time format will be (Wed Mar 01 09 37 42 GMT 2023) like this
        Date date=new Date();

        //So here I am replacing space and colon with -
        String screenshotFileName=date.toString().replace(" ", "-").replace(":", "-");
        System.out.println(screenshotFileName);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotFileName+".png"));
    }
}
