import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UICalanderHandling {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/elegant-gemstone-necklace-rental");
        driver.findElement(By.xpath("//input[contains(@id, \"rental_start_date\")]")).click();
        List<WebElement> dates= driver.findElements(By.className("ui-state-default")); //Here I found common class for all the date
        System.out.println(dates.size()); //And here I find all the date which has same class

        //This is for month selection here ui-datepicter-title class che aa title ma j month nu name lakehlu hoy aa che
        //And ui-datepicter-next che aa next na button matenu che
        //! while ma atla mate lagavelu che jo aa condition flase the to ene true karva mate
        while(!driver.findElement(By.className("ui-datepicker-title")).getText().contains("AUGUST")){
            driver.findElement(By.className("ui-datepicker-next")).click();
        }

        //This for loop will iterate each and each dates from 1 to 31
        for(int i=0; i<=driver.findElements(By.className("ui-state-default")).size(); i++){
            //Jyare for loop 1 thi 31 sudhi iterate kartu hase tyare aa if ni condition match kartu jashe
            String text=driver.findElements(By.className("ui-state-default")).get(i).getText();
            if (text.equalsIgnoreCase("23")){
                driver.findElements(By.className("ui-state-default")).get(i).click();
                break;
            }
        }

    }
}
