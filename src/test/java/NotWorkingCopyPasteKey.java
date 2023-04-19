import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NotWorkingCopyPasteKey {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        //Open Google Website
        driver.get("https://www.google.com/");

        //Accepting cookie on google website
        driver.findElement(By.xpath("//div[text()=\"Accept all\"]")).click();

        //Find out and click on Google search
        WebElement googleSearch=driver.findElement(By.className("gLFyf"));
        googleSearch.click();

        Actions actions=new Actions(driver);

        //After found google search, type random paragraph and then click on it
        googleSearch.sendKeys("random paragraph");
        googleSearch.sendKeys(Keys.ENTER);

        // and then click on below - website
        driver.findElement(By.xpath("//h3[text()=\"Random Paragraph\"]")).click();

        //Now I am accepting cookie for that particular website
        //driver.findElement(By.xpath("//p[text()=\"I understand\"]")).click();

        WebElement sourceText=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]"));
        actions.doubleClick(sourceText).doubleClick(sourceText).sendKeys(Keys.CONTROL).sendKeys("c").perform();

        //This is the destination website, where I will paste copied text and translate it

         driver.get("https://www.easyhindityping.com/english-to-gujarati-translation");
        WebElement destinationText=driver.findElement(By.xpath("//textarea[@id=\"SourceTextarea\"]"));
        destinationText.click();

        actions.keyDown(destinationText, Keys.CONTROL).sendKeys("v").perform();

        driver.findElement(By.id("SubmitTranslation")).click();
    }
}
