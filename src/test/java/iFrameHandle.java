//Basically There are 3 different method to use Frame.
    // Find by frame(index)
    // Find by frame(id or name)
    //find by Storing into WebElement
//Basically Frame means short part of HTML Page within Parental HTML Page


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrameHandle {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://courses.letskodeit.com/practice");
        driver.manage().window().maximize();
        //Here I am using  switch to frame by Webelement method
        WebElement Frame=driver.findElement(By.id("courses-iframe"));  //Here I found iframe by using ID
        driver.switchTo().frame(Frame);
        //After switched into the Iframe and then click on Below link
        driver.findElement(By.xpath("//img[@src=\"https://s3.amazonaws.com/contents.newzenler.com/3072/courses/11131/data/thumb/s-2.jpg\"]")).click();

        //Switch to main frame again
        driver.switchTo().parentFrame();

        //By fetching text just verify
        System.out.println(driver.getTitle());
    }
}
