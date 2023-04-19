//In Web Table always remember :- <tr> means Rows
//                                <td> means Columns
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableHandle {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://tradingeconomics.com/united-kingdom/stock-market");

        //Step 1:- Switch to the iFrame (If web table define under Iframe then)
        //Step 2:- Fetch total number of Row
        //Step 3:- Fetch total number of Column
        //Step 4:- Try to fetch all the value from Table

        //Step 2:- Fetch total number of Row
        //When I was inspect particular row and copy xpath that xPath is:- //*[@id="Index"]/table/tbody/tr[1] (But Here if I am removing [1] then I will get total number of Row)
        List<WebElement> rows= driver.findElements(By.xpath("//*[@id=\"Index\"]/table/tbody/tr"));
        System.out.println("Row for given table is " + rows.size());

        //Step 3:- Fetch total number of Column
        // When I inspected particular column and copy xPath for data that is :- //*[@id="Index"]/table/tbody/tr[1]/td[1] (As I mentioned on the head of the file that <td> means column so if I removed [1] from <td> then I will get total number of columns)
        List<WebElement> columns=driver.findElements(By.xpath("//*[@id=\"Index\"]/table/tbody/tr[1]/td"));
        System.out.println("Columns for given Number is " + columns.size());

        for (int i=1; i<=rows.size(); i++){
            for (int j=1; j<= columns.size(); j++){
                System.out.println(driver.findElement(By.xpath("//*[@id=\"Index\"]/table/tbody/tr[" + i + " ]/td[" + j + "]")).getText());
            }
            System.out.println();
        }
    }
}
